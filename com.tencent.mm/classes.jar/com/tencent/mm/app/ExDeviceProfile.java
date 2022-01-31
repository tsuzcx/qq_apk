package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class ExDeviceProfile
  extends e
{
  public static final String bXW;
  
  static
  {
    AppMethodBeat.i(15379);
    bXW = ah.getPackageName() + ":exdevice";
    AppMethodBeat.o(15379);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(15378);
    ab.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    AppMethodBeat.o(15378);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(15377);
    ab.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
    Object localObject = com.tencent.mm.booter.d.bt(this.app.getBaseContext());
    a.bp(ah.getContext());
    m.dw(bXW);
    localObject = new r((com.tencent.mm.booter.d)localObject);
    ((r)localObject).kt("EXDEVICE");
    ae.gjY = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.display_errcode"), false);
    ae.gjZ = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.display_msgstate"), false);
    ae.gka = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ae.gkb = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.network.force_touch"), false);
    ae.gkc = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ae.gkd = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.crashIsExit"), false);
    ae.gkh = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.album_show_info"), false);
    ae.gki = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.location_help"), false);
    ae.gkl = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.force_soso"), false);
    ae.gkm = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ae.gkn = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ae.gko = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ae.gkr = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.filterfpnp"), false);
    ae.gks = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bo.a(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ae.gkp = i;
    if ((i != 4) && (ae.gkp > 0))
    {
      com.tencent.mm.storage.ab.yxm = ae.gkp;
      ab.e("MicroMsg.ExdDebugger", "cdn thread num " + ae.gkp);
    }
    ae.gkq = bo.a(((r)localObject).ku(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.MA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bo.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.eQs = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whF = String.valueOf(str);
          b.aoP(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eQs).append(" ").append(b.dsg());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.whG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.whG = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bo.a(((r)localObject).ku(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bo.a(((r)localObject).ku(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bo.a(((r)localObject).ku(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bo.a(((r)localObject).ku(".com.tencent.mm.debug.report.useraction"), false);
              c.c(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              ae.gkF = bo.bf(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              ab.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + ae.gkF);
              ae.gkG = bo.bf(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              ab.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + ae.gkG);
              ae.gkH = bo.a(((r)localObject).ku(".com.tencent.mm.debug.skiploadurlcheck"), false);
              ab.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + ae.gkH);
              s.By();
              AppMethodBeat.o(15377);
              return;
              localException1 = localException1;
              ab.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException2 = localException2;
              ab.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              ab.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ab.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */