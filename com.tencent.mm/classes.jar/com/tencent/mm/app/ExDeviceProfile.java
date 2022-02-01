package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public class ExDeviceProfile
  extends com.tencent.mm.compatible.loader.d
{
  public static final String cUu;
  
  static
  {
    AppMethodBeat.i(19442);
    cUu = ak.getPackageName() + ":exdevice";
    AppMethodBeat.o(19442);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19441);
    ae.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    AppMethodBeat.o(19441);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19440);
    ae.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
    Object localObject = com.tencent.mm.booter.d.bL(this.app.getBaseContext());
    a.bH(ak.getContext());
    t.fq(cUu);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).ux("EXDEVICE");
    ac.iQV = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iQW = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iQX = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iQY = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iQZ = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iRa = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iRe = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iRf = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.location_help"), false);
    ac.iRi = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iRj = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iRk = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iRl = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iRo = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iRp = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bu.a(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iRm = i;
    if ((i != 4) && (ac.iRm > 0))
    {
      com.tencent.mm.storage.al.IKf = ac.iRm;
      ae.e("MicroMsg.ExdDebugger", "cdn thread num " + ac.iRm);
    }
    ac.iRn = bu.a(((r)localObject).uy(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aag(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bu.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFF = String.valueOf(str);
          b.aRu(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(b.fnG());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.FFG = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bu.a(((r)localObject).uy(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bu.a(((r)localObject).uy(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bu.a(((r)localObject).uy(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bu.a(((r)localObject).uy(".com.tencent.mm.debug.report.useraction"), false);
              c.d(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              ac.iRC = bu.bI(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              ae.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ac.iRC);
              ac.iRD = bu.bI(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              ae.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ac.iRD);
              ac.iRE = bu.a(((r)localObject).uy(".com.tencent.mm.debug.skiploadurlcheck"), false);
              ae.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ac.iRE);
              ab.Mv();
              AppMethodBeat.o(19440);
              return;
              localException1 = localException1;
              ae.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException2 = localException2;
              ae.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ae.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ae.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */