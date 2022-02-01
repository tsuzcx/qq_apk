package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.platformtools.z;
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
    Object localObject = com.tencent.mm.booter.d.cO(this.app.getBaseContext());
    w.f(false, PROCESS_NAME);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).Ci("EXDEVICE");
    z.pBz = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.display_errcode"), false);
    z.pBA = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.display_msgstate"), false);
    z.pBB = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    z.pBC = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.network.force_touch"), false);
    z.pBD = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    z.pBE = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.crashIsExit"), false);
    z.pBI = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.album_show_info"), false);
    z.pBJ = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.location_help"), false);
    z.pBM = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.force_soso"), false);
    z.pBN = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    z.pBO = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    z.pBP = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    z.pBS = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.filterfpnp"), false);
    z.pBT = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((r)localObject).Cj(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    z.pBQ = i;
    if ((i != 4) && (z.pBQ > 0))
    {
      com.tencent.mm.storage.as.acHo = z.pBQ;
      Log.e("MicroMsg.ExdDebugger", "cdn thread num " + z.pBQ);
    }
    z.pBR = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.axo(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.nsC = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxc = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxe = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.nsC).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Yxg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Yxg = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.e(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              z.pCh = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + z.pCh);
              z.pCi = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + z.pCi);
              z.pCj = Util.nullAs(((r)localObject).Ck(".com.tencent.mm.debug.skiploadurlcheck"), false);
              Log.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + z.pCj);
              af.aCS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */