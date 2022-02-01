package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.console.Shell;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;

public class AppBrandProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cDP = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19429);
    ad.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
    cDP = aj.getProcessName();
    AppBrandProfile.class.getClassLoader();
    com.tencent.mm.f.a.bF(aj.getContext());
    s.a(new au.c()
    {
      public final void a(au paramAnonymousau, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(193072);
        g.yhR.idkeyStat(365L, 3L, 1L, false);
        KVCommCrossProcessReceiver.dKl();
        AppMethodBeat.o(193072);
      }
    });
    p localp = new p(com.tencent.mm.booter.d.bJ(this.app.getBaseContext()));
    cDP.replace(aj.getPackageName() + ":appbrand", "");
    ac.iOb = bt.a(localp.ud(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iOc = bt.a(localp.ud(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iOd = bt.a(localp.ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iOe = bt.a(localp.ud(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iOf = bt.a(localp.ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iOg = bt.a(localp.ud(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iOk = bt.a(localp.ud(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iOl = bt.a(localp.ud(".com.tencent.mm.debug.test.location_help"), false);
    ac.iOo = bt.a(localp.ud(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iOp = bt.a(localp.ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iOq = bt.a(localp.ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iOr = bt.a(localp.ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iOu = bt.a(localp.ud(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iOv = bt.a(localp.ud(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(localp.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iOs = i;
    if ((i != 4) && (ac.iOs > 0))
    {
      com.tencent.mm.storage.ak.IpL = ac.iOs;
      ad.e("MicroMsg.AppBDebugger", "cdn thread num " + ac.iOs);
    }
    ac.iOt = bt.a(localp.ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ac.iOL = bt.a(localp.ud(".com.tencent.mm.debug.forcex5webview"), false);
    ac.iOI = bt.bI(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ad.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + ac.iOI);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.ZA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnh = String.valueOf(str);
          b.aPX(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(b.fjO());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Fni = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.fFy.fEd = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(localp.ud(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(localp.ud(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(localp.ud(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(localp.ud(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                if (bu.flY()) {
                  new Shell().init(aj.getContext());
                }
                a.Lu();
                j.vr("commonimgdec");
                j.vr("wechatcommon");
                j.vr("wechatbase");
                j.vr(com.tencent.mm.sdk.a.IbC);
                j.vr("wechatmm");
                j.vr("FFmpeg");
                j.vr("wechatpack");
                ab.MA();
                com.tencent.mm.plugin.appbrand.api.a.jCJ = bt.flT();
                com.tencent.mm.cq.d.kQ(this.app);
                com.tencent.mm.plugin.appbrand.api.a.jCK = bt.flT();
                com.tencent.mm.sdk.b.a.IbL.c(new u(42, 52));
                AppMethodBeat.o(19429);
                return;
                localException2 = localException2;
                ad.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ad.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ad.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                ad.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(19430);
    super.onTrimMemory(paramInt);
    ad.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile
 * JD-Core Version:    0.7.0.1
 */