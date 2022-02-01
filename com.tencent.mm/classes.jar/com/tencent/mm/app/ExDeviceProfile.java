package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class ExDeviceProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cTJ;
  
  static
  {
    AppMethodBeat.i(19442);
    cTJ = aj.getPackageName() + ":exdevice";
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
    Object localObject = com.tencent.mm.booter.d.bJ(this.app.getBaseContext());
    a.bF(aj.getContext());
    s.fk(cTJ);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).uc("EXDEVICE");
    ac.iOb = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iOc = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iOd = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iOe = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iOf = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iOg = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iOk = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iOl = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.location_help"), false);
    ac.iOo = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iOp = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iOq = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iOr = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iOu = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iOv = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iOs = i;
    if ((i != 4) && (ac.iOs > 0))
    {
      com.tencent.mm.storage.ak.IpL = ac.iOs;
      ad.e("MicroMsg.ExdDebugger", "cdn thread num " + ac.iOs);
    }
    ac.iOt = bt.a(((r)localObject).ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.ZA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnh = String.valueOf(str);
          b.aPX(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(b.fjO());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Fni = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bt.a(((r)localObject).ud(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bt.a(((r)localObject).ud(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bt.a(((r)localObject).ud(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bt.a(((r)localObject).ud(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              ac.iOI = bt.bI(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              ad.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ac.iOI);
              ac.iOJ = bt.bI(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              ad.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ac.iOJ);
              ac.iOK = bt.a(((r)localObject).ud(".com.tencent.mm.debug.skiploadurlcheck"), false);
              ad.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ac.iOK);
              ab.MA();
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
    return cTJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */