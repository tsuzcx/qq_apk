package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.base.t;
import java.io.File;

@k
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MountReceiver
  extends BroadcastReceiver
{
  private String action;
  private Context context;
  private ak dYX;
  
  public MountReceiver()
  {
    AppMethodBeat.i(15848);
    this.context = null;
    this.action = "";
    this.dYX = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool1 = true;
        AppMethodBeat.i(15845);
        paramAnonymousMessage = MountReceiver.a(MountReceiver.this);
        boolean bool2 = aw.RG();
        if (MountReceiver.b(MountReceiver.this) == null) {}
        for (;;)
        {
          ab.d("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b", new Object[] { paramAnonymousMessage, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(f.Mj()) });
          if (MountReceiver.b(MountReceiver.this) != null) {
            break;
          }
          AppMethodBeat.o(15845);
          return;
          bool1 = false;
        }
        if (!f.Mj())
        {
          AppMethodBeat.o(15845);
          return;
        }
        t.ij(MountReceiver.b(MountReceiver.this));
        AppMethodBeat.o(15845);
      }
    };
    AppMethodBeat.o(15848);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(15849);
    if ((paramContext == null) || (paramIntent == null) || (ah.isNullOrNil(paramIntent.getAction())))
    {
      AppMethodBeat.o(15849);
      return;
    }
    this.context = paramContext;
    this.action = paramIntent.getAction();
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    ab.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", new Object[] { this.action, Boolean.valueOf(aw.RG()), e.eQx, str1 });
    boolean bool = this.action.equals("android.intent.action.MEDIA_MOUNTED");
    if ((!bool) && (!this.action.equals("android.intent.action.MEDIA_EJECT")) && (!this.action.equals("android.intent.action.MEDIA_SHARED")))
    {
      AppMethodBeat.o(15849);
      return;
    }
    if (!e.eQx.equalsIgnoreCase("/dev/null")) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i != 0) {}
      try
      {
        localObject = new StatFs(e.eQx);
        ab.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { e.eQx, Integer.valueOf(((StatFs)localObject).getBlockSize()), Integer.valueOf(((StatFs)localObject).getBlockCount()), Integer.valueOf(((StatFs)localObject).getAvailableBlocks()) });
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          ab.e("MicroMsg.MountReceiver", "CheckSD failed :%s", new Object[] { localException.getMessage() });
          j = 0;
          continue;
          l = 12L;
          continue;
          paramIntent = new y(ac.eQv + "SdcardInfo.cfg");
          String str2 = (String)paramIntent.get(1, "");
          i = ((Integer)paramIntent.get(2, Integer.valueOf(0))).intValue();
          j = Build.VERSION.SDK_INT;
          String str3 = e.eQx;
          paramIntent.set(1, str1);
          paramIntent.set(2, Integer.valueOf(j));
          e.lo(str1);
          ab.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), str1, str3, e.eQx });
        }
        AppMethodBeat.o(15849);
        return;
      }
      paramIntent = paramIntent.getData();
      if (paramIntent == null) {
        break label602;
      }
      paramIntent = paramIntent.getPath();
      if (!e.eQx.equalsIgnoreCase(paramIntent))
      {
        if ((!bool) || (j != 0)) {
          break label595;
        }
        localObject = h.qsU;
        if (!e.eQx.equalsIgnoreCase("/dev/null")) {
          break;
        }
        l = 9L;
        ((h)localObject).idkeyStat(340L, l, 1L, false);
        if ((ah.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(paramIntent))) {
          break label588;
        }
        if (new File(ac.eQv + "SdcardInfo.cfg").exists()) {
          break label448;
        }
        ab.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", new Object[] { e.eQx, str1, Integer.valueOf(Build.VERSION.SDK_INT) });
        e.eQx = str1;
        e.lo(str1);
      }
      if (!bool) {
        break label638;
      }
      aw.RO().ac(new MountReceiver.2(this));
      AppMethodBeat.o(15849);
      return;
    }
    label448:
    label588:
    label595:
    AppMethodBeat.o(15849);
    return;
    label602:
    paramIntent = h.qsU;
    if (bool) {}
    for (long l = 13L;; l = 14L)
    {
      paramIntent.idkeyStat(340L, l, 1L, false);
      break;
    }
    label638:
    t.ii(paramContext);
    aw.RO().ac(new MountReceiver.3(this));
    AppMethodBeat.o(15849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver
 * JD-Core Version:    0.7.0.1
 */