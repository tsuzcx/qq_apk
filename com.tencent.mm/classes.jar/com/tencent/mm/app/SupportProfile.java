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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cQi = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19476);
    cQi = MMApplicationContext.getProcessName();
    SupportProfile.class.getClassLoader();
    com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
    t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(231389);
        h.CyF.idkeyStat(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.eOD();
        AppMethodBeat.o(231389);
      }
    });
    v localv = new v(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
    localv.CN("SUPPORT");
    ac.jNP = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.jNQ = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.jNR = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.jNS = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.jNT = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.jNU = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.jNY = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.jNZ = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.location_help"), false);
    ac.jOc = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.force_soso"), false);
    ac.jOd = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.jOe = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.jOf = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.jOi = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.jOj = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.jOg = i;
    if ((i != 4) && (ac.jOg > 0))
    {
      com.tencent.mm.storage.aq.NSc = ac.jOg;
      Log.e("SetupSupportDebugger", "cdn thread num " + ac.jOg);
    }
    ac.jOh = Util.nullAs(localv.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ac.jOA = Util.nullAs(localv.CO(".com.tencent.mm.debug.forcex5webview"), false);
    ac.jOx = Util.nullAs(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    Log.d("SetupSupportDebugger", "Test.jsapiPermission = " + ac.jOx);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aiV(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyM = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(i);
          com.tencent.mm.protocal.d.KyN = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.gmN.glq = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(localv.CO(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(localv.CO(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(localv.CO(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(localv.CO(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                t.d(false, cQi);
                a.VP();
                j.Ed("wcdb");
                j.Ed("commonimgdec");
                j.Ed("wechatcommon");
                j.Ed("wechatbase");
                j.Ed(CommLibFileName.quic);
                j.Ed("wechatmm");
                j.Ed("FFmpeg");
                j.Ed("wechatpack");
                i = m.aon();
                if ((i & 0x400) == 0) {
                  break label923;
                }
                Log.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                j.Ed("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.Dma = 3;
                com.tencent.mm.plugin.sight.base.c.Dmc = 3;
                com.tencent.mm.plugin.sight.base.c.Dmd = 544000;
                com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
                ab.WH();
                MMActivity.initLanguage(this.app.getBaseContext());
                AppMethodBeat.o(19476);
                return;
                localException2 = localException2;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                Log.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
                continue;
                label923:
                Log.i("MicroMsg.SupportProfile", "load wechatsight");
                j.Ed("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
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
    Log.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */