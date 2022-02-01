package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class ExDeviceProfile
  extends com.tencent.mm.compatible.loader.c
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(19442);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":exdevice";
    AppMethodBeat.o(19442);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19441);
    Log.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    AppMethodBeat.o(19441);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19440);
    Log.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
    Object localObject = com.tencent.mm.booter.d.cc(this.app.getBaseContext());
    t.f(false, PROCESS_NAME);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).JC("EXDEVICE");
    com.tencent.mm.platformtools.ac.mEX = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ac.mEY = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ac.mEZ = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ac.mFa = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ac.mFb = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ac.mFc = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ac.mFh = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ac.mFi = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ac.mFl = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ac.mFm = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ac.mFn = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ac.mFo = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ac.mFr = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ac.mFs = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((r)localObject).JD(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ac.mFp = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ac.mFp > 0))
    {
      com.tencent.mm.storage.aq.VfZ = com.tencent.mm.platformtools.ac.mFp;
      Log.e("MicroMsg.ExdDebugger", "cdn thread num " + com.tencent.mm.platformtools.ac.mFp);
    }
    com.tencent.mm.platformtools.ac.mFq = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.arg(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.kQZ = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAy = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAA = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.kQZ).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.RAC).append(" new: ").append(i);
          com.tencent.mm.protocal.d.RAC = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              com.tencent.mm.platformtools.ac.mFH = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.mFH);
              com.tencent.mm.platformtools.ac.mFI = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.ac.mFI);
              com.tencent.mm.platformtools.ac.mFJ = Util.nullAs(((r)localObject).JE(".com.tencent.mm.debug.skiploadurlcheck"), false);
              Log.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ac.mFJ);
              ac.abg();
              AppMethodBeat.o(19440);
              return;
              localException1 = localException1;
              Log.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException2 = localException2;
              Log.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              Log.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              Log.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */