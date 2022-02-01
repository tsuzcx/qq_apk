package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class ExDeviceProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String dkO;
  
  static
  {
    AppMethodBeat.i(19442);
    dkO = MMApplicationContext.getPackageName() + ":exdevice";
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
    Object localObject = com.tencent.mm.booter.d.cg(this.app.getBaseContext());
    a.cc(MMApplicationContext.getContext());
    t.d(false, dkO);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).CN("EXDEVICE");
    ac.jNP = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.jNQ = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.jNR = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.jNS = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.jNT = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.jNU = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.jNY = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.jNZ = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.location_help"), false);
    ac.jOc = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.force_soso"), false);
    ac.jOd = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.jOe = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.jOf = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.jOi = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.jOj = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.jOg = i;
    if ((i != 4) && (ac.jOg > 0))
    {
      com.tencent.mm.storage.aq.NSc = ac.jOg;
      Log.e("MicroMsg.ExdDebugger", "cdn thread num " + ac.jOg);
    }
    ac.jOh = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aiV(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyM = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(i);
          com.tencent.mm.protocal.d.KyN = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              ac.jOx = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ac.jOx);
              ac.jOy = Util.nullAs(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              Log.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ac.jOy);
              ac.jOz = Util.nullAs(((r)localObject).CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
              Log.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ac.jOz);
              ab.WH();
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
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */