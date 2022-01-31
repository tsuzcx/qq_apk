package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.s;
import java.io.File;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MountReceiver
  extends BroadcastReceiver
{
  private String action = "";
  private Context context = null;
  private com.tencent.mm.sdk.platformtools.ah dhG = new MountReceiver.1(this, Looper.getMainLooper());
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null) || (com.tencent.mm.platformtools.ah.bl(paramIntent.getAction()))) {}
    String str1;
    boolean bool;
    do
    {
      return;
      this.context = paramContext;
      this.action = paramIntent.getAction();
      str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", new Object[] { this.action, Boolean.valueOf(au.DK()), e.bkF, str1 });
      bool = this.action.equals("android.intent.action.MEDIA_MOUNTED");
    } while ((!bool) && (!this.action.equals("android.intent.action.MEDIA_EJECT")) && (!this.action.equals("android.intent.action.MEDIA_SHARED")));
    if (!e.bkF.equalsIgnoreCase("/dev/null")) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i != 0) {}
      try
      {
        localObject = new StatFs(e.bkF);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { e.bkF, Integer.valueOf(((StatFs)localObject).getBlockSize()), Integer.valueOf(((StatFs)localObject).getBlockCount()), Integer.valueOf(((StatFs)localObject).getAvailableBlocks()) });
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MountReceiver", "CheckSD failed :%s", new Object[] { localException.getMessage() });
          j = 0;
          continue;
          l = 12L;
          continue;
          paramIntent = new com.tencent.mm.storage.y(ac.dOP + "SdcardInfo.cfg");
          String str2 = (String)paramIntent.get(1, "");
          i = ((Integer)paramIntent.get(2, Integer.valueOf(0))).intValue();
          j = Build.VERSION.SDK_INT;
          String str3 = e.bkF;
          paramIntent.set(1, str1);
          paramIntent.set(2, Integer.valueOf(j));
          e.fc(str1);
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), str1, str3, e.bkF });
        }
        paramIntent = h.nFQ;
        if (!bool) {
          break label591;
        }
        for (long l = 13L;; l = 14L)
        {
          paramIntent.a(340L, l, 1L, false);
          break;
        }
        s.gM(paramContext);
        au.DS().O(new MountReceiver.3(this));
      }
      paramIntent = paramIntent.getData();
      if (paramIntent == null) {
        break label563;
      }
      paramIntent = paramIntent.getPath();
      if (!e.bkF.equalsIgnoreCase(paramIntent))
      {
        if ((!bool) || (j != 0)) {
          break;
        }
        localObject = h.nFQ;
        if (!e.bkF.equalsIgnoreCase("/dev/null")) {
          break label415;
        }
        l = 9L;
        ((h)localObject).a(340L, l, 1L, false);
        if ((com.tencent.mm.platformtools.ah.bl(str1)) || (!str1.equalsIgnoreCase(paramIntent))) {
          break;
        }
        if (new File(ac.dOP + "SdcardInfo.cfg").exists()) {
          break label423;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", new Object[] { e.bkF, str1, Integer.valueOf(Build.VERSION.SDK_INT) });
        e.bkF = str1;
        e.fc(str1);
      }
      if (!bool) {
        break label599;
      }
      au.DS().O(new MountReceiver.2(this));
      return;
    }
    label415:
    label423:
    label563:
    label591:
    label599:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver
 * JD-Core Version:    0.7.0.1
 */