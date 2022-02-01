package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class ExDeviceProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cLt;
  
  static
  {
    AppMethodBeat.i(19442);
    cLt = aj.getPackageName() + ":exdevice";
    AppMethodBeat.o(19442);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19441);
    ad.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    AppMethodBeat.o(19441);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19440);
    ad.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
    Object localObject = com.tencent.mm.booter.d.bH(this.app.getBaseContext());
    a.bD(aj.getContext());
    s.eA(cLt);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).ok("EXDEVICE");
    ab.hUQ = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.display_errcode"), false);
    ab.hUR = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.display_msgstate"), false);
    ab.hUS = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ab.hUT = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.network.force_touch"), false);
    ab.hUU = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ab.hUV = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.crashIsExit"), false);
    ab.hUZ = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.album_show_info"), false);
    ab.hVa = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.location_help"), false);
    ab.hVd = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.force_soso"), false);
    ab.hVe = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ab.hVf = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ab.hVg = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ab.hVj = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.filterfpnp"), false);
    ab.hVk = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ab.hVh = i;
    if ((i != 4) && (ab.hVh > 0))
    {
      com.tencent.mm.storage.ad.FfF = ab.hVh;
      ad.e("MicroMsg.ExdDebugger", "cdn thread num " + ab.hVh);
    }
    ab.hVi = bt.a(((r)localObject).ol(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.Vv(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.glX = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpG = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpI = String.valueOf(str);
          b.aFa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.glX).append(" ").append(b.eER());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.CpJ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.CpJ = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bt.a(((r)localObject).ol(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bt.a(((r)localObject).ol(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bt.a(((r)localObject).ol(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bt.a(((r)localObject).ol(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              ab.hVx = bt.by(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              ad.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ab.hVx);
              ab.hVy = bt.by(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              ad.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ab.hVy);
              ab.hVz = bt.a(((r)localObject).ol(".com.tencent.mm.debug.skiploadurlcheck"), false);
              ad.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ab.hVz);
              aa.KV();
              AppMethodBeat.o(19440);
              return;
              localException1 = localException1;
              ad.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException2 = localException2;
              ad.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ad.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ad.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return cLt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */