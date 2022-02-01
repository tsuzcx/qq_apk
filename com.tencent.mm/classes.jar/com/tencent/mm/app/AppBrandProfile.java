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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public class AppBrandProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cQi = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19429);
    Log.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
    cQi = MMApplicationContext.getProcessName();
    AppBrandProfile.class.getClassLoader();
    com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
    t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(231385);
        h.CyF.idkeyStat(365L, 3L, 1L, false);
        KVCommCrossProcessReceiver.eOD();
        AppMethodBeat.o(231385);
      }
    });
    p localp = new p(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
    cQi.replace(MMApplicationContext.getPackageName() + ":appbrand", "");
    ac.jNP = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.jNQ = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.jNR = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.jNS = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.jNT = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.jNU = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.jNY = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.jNZ = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.location_help"), false);
    ac.jOc = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.force_soso"), false);
    ac.jOd = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.jOe = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.jOf = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.jOi = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.jOj = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(localp.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.jOg = i;
    if ((i != 4) && (ac.jOg > 0))
    {
      com.tencent.mm.storage.aq.NSc = ac.jOg;
      Log.e("MicroMsg.AppBDebugger", "cdn thread num " + ac.jOg);
    }
    ac.jOh = Util.nullAs(localp.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ac.jOA = Util.nullAs(localp.CO(".com.tencent.mm.debug.forcex5webview"), false);
    ac.jOx = Util.nullAs(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    Log.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + ac.jOx);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aiV(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
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
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(i);
          com.tencent.mm.protocal.d.KyN = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.gmN.glq = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(localp.CO(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(localp.CO(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(localp.CO(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(localp.CO(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                if (WeChatEnvironment.hasDebugger()) {
                  new Shell().init(MMApplicationContext.getContext());
                }
                a.VP();
                j.Ed("commonimgdec");
                j.Ed("wechatcommon");
                j.Ed("wechatbase");
                j.Ed(CommLibFileName.quic);
                j.Ed("wechatmm");
                j.Ed("FFmpeg");
                j.Ed("wechatpack");
                ab.WH();
                com.tencent.mm.plugin.appbrand.api.a.kHr = Util.nowMilliSecond();
                com.tencent.mm.cr.d.kT(this.app);
                com.tencent.mm.plugin.appbrand.api.a.kHs = Util.nowMilliSecond();
                EventCenter.instance.addListener(new v(42, 52));
                AppMethodBeat.o(19429);
                return;
                localException2 = localException2;
                Log.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                Log.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.i("MicroMsg.AppBDebugger", "no debugger was got");
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
    Log.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile
 * JD-Core Version:    0.7.0.1
 */