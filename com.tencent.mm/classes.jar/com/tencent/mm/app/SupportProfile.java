package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cvL = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19476);
    cvL = aj.getProcessName();
    SupportProfile.class.getClassLoader();
    com.tencent.mm.f.a.bD(aj.getContext());
    s.a(new au.c()
    {
      public final void b(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(19475);
        h.vKh.idkeyStat(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.dkK();
        AppMethodBeat.o(19475);
      }
    });
    u localu = new u(com.tencent.mm.booter.d.bH(this.app.getBaseContext()));
    localu.ok("SUPPORT");
    ab.hUQ = bt.a(localu.ol(".com.tencent.mm.debug.test.display_errcode"), false);
    ab.hUR = bt.a(localu.ol(".com.tencent.mm.debug.test.display_msgstate"), false);
    ab.hUS = bt.a(localu.ol(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ab.hUT = bt.a(localu.ol(".com.tencent.mm.debug.test.network.force_touch"), false);
    ab.hUU = bt.a(localu.ol(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ab.hUV = bt.a(localu.ol(".com.tencent.mm.debug.test.crashIsExit"), false);
    ab.hUZ = bt.a(localu.ol(".com.tencent.mm.debug.test.album_show_info"), false);
    ab.hVa = bt.a(localu.ol(".com.tencent.mm.debug.test.location_help"), false);
    ab.hVd = bt.a(localu.ol(".com.tencent.mm.debug.test.force_soso"), false);
    ab.hVe = bt.a(localu.ol(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ab.hVf = bt.a(localu.ol(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ab.hVg = bt.a(localu.ol(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ab.hVj = bt.a(localu.ol(".com.tencent.mm.debug.test.filterfpnp"), false);
    ab.hVk = bt.a(localu.ol(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(localu.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ab.hVh = i;
    if ((i != 4) && (ab.hVh > 0))
    {
      com.tencent.mm.storage.ad.FfF = ab.hVh;
      ad.e("SetupSupportDebugger", "cdn thread num " + ab.hVh);
    }
    ab.hVi = bt.a(localu.ol(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ab.hVA = bt.a(localu.ol(".com.tencent.mm.debug.forcex5webview"), false);
    ab.hVx = bt.by(localu.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ad.d("SetupSupportDebugger", "Test.jsapiPermission = " + ab.hVx);
    try
    {
      i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.Vv(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localu.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.glX = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpG = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpI = String.valueOf(str);
          b.aFa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.glX).append(" ").append(b.eER());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.CpJ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.CpJ = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localu.fjW.fiC = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(localu.ol(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(localu.ol(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(localu.ol(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(localu.ol(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                s.eA(cvL);
                a.Kl();
                j.pq("wcdb");
                j.pq("commonimgdec");
                j.pq("wechatcommon");
                j.pq("wechatbase");
                j.pq(com.tencent.mm.sdk.a.ESC);
                j.pq("wechatmm");
                j.pq("FFmpeg");
                j.pq("wechatpack");
                i = m.WG();
                if ((i & 0x400) == 0) {
                  break label922;
                }
                ad.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                j.pq("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.wqY = 3;
                com.tencent.mm.plugin.sight.base.c.wra = 3;
                com.tencent.mm.plugin.sight.base.c.wrb = 544000;
                com.tencent.mm.f.a.bD(aj.getContext());
                aa.KV();
                MMActivity.initLanguage(this.app.getBaseContext());
                AppMethodBeat.o(19476);
                return;
                localException2 = localException2;
                ad.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ad.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ad.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                ad.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.wqY = 1;
                com.tencent.mm.plugin.sight.base.c.wra = 1;
                com.tencent.mm.plugin.sight.base.c.wrb = 640000;
                continue;
                label922:
                ad.i("MicroMsg.SupportProfile", "load wechatsight");
                j.pq("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.wqY = 1;
                com.tencent.mm.plugin.sight.base.c.wra = 1;
                com.tencent.mm.plugin.sight.base.c.wrb = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(19477);
    super.onTrimMemory(paramInt);
    ad.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */