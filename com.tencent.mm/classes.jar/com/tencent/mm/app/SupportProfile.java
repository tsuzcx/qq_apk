package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
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
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cDP = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19476);
    cDP = aj.getProcessName();
    SupportProfile.class.getClassLoader();
    com.tencent.mm.f.a.bF(aj.getContext());
    s.a(new au.c()
    {
      public final void a(au paramAnonymousau, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(193074);
        g.yhR.idkeyStat(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.dKl();
        AppMethodBeat.o(193074);
      }
    });
    v localv = new v(com.tencent.mm.booter.d.bJ(this.app.getBaseContext()));
    localv.uc("SUPPORT");
    ac.iOb = bt.a(localv.ud(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iOc = bt.a(localv.ud(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iOd = bt.a(localv.ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iOe = bt.a(localv.ud(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iOf = bt.a(localv.ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iOg = bt.a(localv.ud(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iOk = bt.a(localv.ud(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iOl = bt.a(localv.ud(".com.tencent.mm.debug.test.location_help"), false);
    ac.iOo = bt.a(localv.ud(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iOp = bt.a(localv.ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iOq = bt.a(localv.ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iOr = bt.a(localv.ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iOu = bt.a(localv.ud(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iOv = bt.a(localv.ud(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iOs = i;
    if ((i != 4) && (ac.iOs > 0))
    {
      com.tencent.mm.storage.ak.IpL = ac.iOs;
      ad.e("SetupSupportDebugger", "cdn thread num " + ac.iOs);
    }
    ac.iOt = bt.a(localv.ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ac.iOL = bt.a(localv.ud(".com.tencent.mm.debug.forcex5webview"), false);
    ac.iOI = bt.bI(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ad.d("SetupSupportDebugger", "Test.jsapiPermission = " + ac.iOI);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.ZA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
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
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Fni = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.fFy.fEd = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(localv.ud(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(localv.ud(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(localv.ud(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(localv.ud(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                s.fk(cDP);
                a.Lu();
                j.vr("wcdb");
                j.vr("commonimgdec");
                j.vr("wechatcommon");
                j.vr("wechatbase");
                j.vr(com.tencent.mm.sdk.a.IbC);
                j.vr("wechatmm");
                j.vr("FFmpeg");
                j.vr("wechatpack");
                i = m.aaf();
                if ((i & 0x400) == 0) {
                  break label922;
                }
                ad.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                j.vr("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.yQZ = 3;
                com.tencent.mm.plugin.sight.base.c.yRb = 3;
                com.tencent.mm.plugin.sight.base.c.yRc = 544000;
                com.tencent.mm.f.a.bF(aj.getContext());
                ab.MA();
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
                com.tencent.mm.plugin.sight.base.c.yQZ = 1;
                com.tencent.mm.plugin.sight.base.c.yRb = 1;
                com.tencent.mm.plugin.sight.base.c.yRc = 640000;
                continue;
                label922:
                ad.i("MicroMsg.SupportProfile", "load wechatsight");
                j.vr("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.yQZ = 1;
                com.tencent.mm.plugin.sight.base.c.yRb = 1;
                com.tencent.mm.plugin.sight.base.c.yRc = 640000;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */