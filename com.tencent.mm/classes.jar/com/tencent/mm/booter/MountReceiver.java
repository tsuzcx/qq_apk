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
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.io.IOException;

@k
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MountReceiver
  extends BroadcastReceiver
{
  private String action;
  private Context context;
  private ap fiK;
  
  public MountReceiver()
  {
    AppMethodBeat.i(19882);
    this.context = null;
    this.action = "";
    this.fiK = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool1 = true;
        AppMethodBeat.i(19879);
        paramAnonymousMessage = MountReceiver.a(MountReceiver.this);
        boolean bool2 = az.afw();
        if (MountReceiver.b(MountReceiver.this) == null) {}
        for (;;)
        {
          ad.d("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b", new Object[] { paramAnonymousMessage, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.compatible.util.e.XH()) });
          if (MountReceiver.b(MountReceiver.this) != null) {
            break;
          }
          AppMethodBeat.o(19879);
          return;
          bool1 = false;
        }
        if (!com.tencent.mm.compatible.util.e.XH())
        {
          AppMethodBeat.o(19879);
          return;
        }
        t.jL(MountReceiver.b(MountReceiver.this));
        AppMethodBeat.o(19879);
      }
    };
    AppMethodBeat.o(19882);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19883);
    if ((paramContext == null) || (paramIntent == null) || (bt.isNullOrNil(paramIntent.getAction())))
    {
      AppMethodBeat.o(19883);
      return;
    }
    this.context = paramContext;
    this.action = paramIntent.getAction();
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 != null) {
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    boolean bool;
    String str1;
    for (;;)
    {
      ad.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", new Object[] { this.action, Boolean.valueOf(az.afw()), b.aib(), localObject1 });
      bool = this.action.equals("android.intent.action.MEDIA_MOUNTED");
      if ((bool) || (this.action.equals("android.intent.action.MEDIA_EJECT")) || (this.action.equals("android.intent.action.MEDIA_SHARED"))) {
        break;
      }
      AppMethodBeat.o(19883);
      return;
      try
      {
        localObject1 = new File("/sdcard/").getCanonicalPath();
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.MountReceiver", localIOException, "Fail to resolve canonical path for sdcard root.", new Object[0]);
        str1 = "/sdcard/";
      }
    }
    if (!b.aib().equalsIgnoreCase("/dev/null")) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (i != 0) {}
      try
      {
        localObject2 = new StatFs(b.aib());
        ad.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { b.aib(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ad.e("MicroMsg.MountReceiver", "CheckSD failed :%s", new Object[] { localException.getMessage() });
          j = 0;
          continue;
          l = 12L;
          continue;
          paramIntent = new aa(ae.FfH + "SdcardInfo.cfg");
          String str2 = (String)paramIntent.get(1, "");
          i = ((Integer)paramIntent.get(2, Integer.valueOf(0))).intValue();
          j = Build.VERSION.SDK_INT;
          String str3 = b.aib();
          paramIntent.set(1, str1);
          paramIntent.set(2, Integer.valueOf(j));
          b.y(str1, false);
          ad.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), str1, str3, b.aib() });
        }
        AppMethodBeat.o(19883);
        return;
      }
      paramIntent = paramIntent.getData();
      if (paramIntent == null) {
        break label651;
      }
      paramIntent = paramIntent.getPath();
      if (!b.aib().equalsIgnoreCase(paramIntent))
      {
        if ((!bool) || (j != 0)) {
          break label644;
        }
        localObject2 = h.vKh;
        if (!b.aib().equalsIgnoreCase("/dev/null")) {
          break;
        }
        l = 9L;
        ((h)localObject2).idkeyStat(340L, l, 1L, false);
        if ((bt.isNullOrNil(str1)) || (!str1.equalsIgnoreCase(paramIntent))) {
          break label637;
        }
        if (new com.tencent.mm.vfs.e(ae.FfH + "SdcardInfo.cfg").exists()) {
          break label495;
        }
        ad.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", new Object[] { b.aib(), str1, Integer.valueOf(Build.VERSION.SDK_INT) });
        b.y(str1, false);
      }
      o.fih();
      if (!bool) {
        break label687;
      }
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19880);
          ad.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[] { MountReceiver.a(MountReceiver.this), Boolean.valueOf(az.afw()) });
          if (!az.afw())
          {
            AppMethodBeat.o(19880);
            return;
          }
          g.afB().afn();
          az.arV();
          c.afm();
          MountReceiver.c(MountReceiver.this).sendEmptyMessage(0);
          AppMethodBeat.o(19880);
        }
      });
      AppMethodBeat.o(19883);
      return;
    }
    label495:
    label637:
    AppMethodBeat.o(19883);
    label644:
    return;
    label651:
    paramIntent = h.vKh;
    if (bool) {}
    for (long l = 13L;; l = 14L)
    {
      paramIntent.idkeyStat(340L, l, 1L, false);
      break;
    }
    label687:
    t.g(paramContext, null);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19881);
        ad.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", new Object[] { MountReceiver.a(MountReceiver.this), Boolean.valueOf(az.afw()) });
        if (!az.afw())
        {
          AppMethodBeat.o(19881);
          return;
        }
        g.afB().afn();
        az.arV();
        c.afm();
        AppMethodBeat.o(19881);
      }
    });
    AppMethodBeat.o(19883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver
 * JD-Core Version:    0.7.0.1
 */