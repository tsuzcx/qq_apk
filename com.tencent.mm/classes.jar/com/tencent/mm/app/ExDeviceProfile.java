package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.g.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class ExDeviceProfile
  extends e
{
  public static final String bwr = com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":exdevice";
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
  }
  
  public final void onCreate()
  {
    y.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
    Object localObject = com.tencent.mm.booter.c.aS(this.app.getBaseContext());
    a.aQ(com.tencent.mm.sdk.platformtools.ae.getContext());
    k.cl(bwr);
    com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
    localObject = new r((com.tencent.mm.booter.c)localObject);
    ((r)localObject).em("EXDEVICE");
    com.tencent.mm.platformtools.ae.eSd = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ae.eSe = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ae.eSf = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ae.eSg = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ae.eSh = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ae.eSi = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ae.eSm = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ae.eSn = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ae.eSq = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ae.eSr = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ae.eSs = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ae.eSt = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ae.eSw = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ae.eSx = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bk.a(((r)localObject).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ae.eSu = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
    {
      com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
      y.e("MicroMsg.ExdDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
    }
    com.tencent.mm.platformtools.ae.eSv = bk.a(((r)localObject).en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException3)
    {
      try
      {
        String str = ((r)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          d.dOM = "android-" + str;
          d.soW = "android-" + str;
          d.soY = str;
          b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(d.dOM).append(" ").append(b.cql());
        }
      }
      catch (Exception localException3)
      {
        try
        {
          i = Integer.decode(((r)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(d.soZ).append(" new: ").append(i);
          d.soZ = i;
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              boolean bool1 = bk.a(((r)localObject).en(".com.tencent.mm.debug.report.debugmodel"), false);
              boolean bool2 = bk.a(((r)localObject).en(".com.tencent.mm.debug.report.kvstat"), false);
              boolean bool3 = bk.a(((r)localObject).en(".com.tencent.mm.debug.report.clientpref"), false);
              boolean bool4 = bk.a(((r)localObject).en(".com.tencent.mm.debug.report.useraction"), false);
              com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
              new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
              com.tencent.mm.platformtools.ae.eSK = bk.aM(((r)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
              y.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ae.eSK);
              com.tencent.mm.platformtools.ae.eSL = bk.aM(((r)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
              y.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.ae.eSL);
              com.tencent.mm.platformtools.ae.eSM = bk.a(((r)localObject).en(".com.tencent.mm.debug.skiploadurlcheck"), false);
              y.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ae.eSM);
              p.tb();
              return;
              localException1 = localException1;
              y.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException2 = localException2;
              y.i("MicroMsg.ExdDebugger", "no debugger was got");
              continue;
              localException3 = localException3;
              y.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              y.i("MicroMsg.ExdDebugger", "no debugger was got");
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return bwr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ExDeviceProfile
 * JD-Core Version:    0.7.0.1
 */