package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.console.Shell;
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
  extends com.tencent.mm.compatible.loader.c
{
  protected static String cQP = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19429);
    Log.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
    cQP = MMApplicationContext.getProcessName();
    AppBrandProfile.class.getClassLoader();
    t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(277702);
        h.IzE.idkeyStat(365L, 3L, 1L, false);
        KVCommCrossProcessReceiver.fBy();
        AppMethodBeat.o(277702);
      }
    });
    p localp = new p(com.tencent.mm.booter.d.cc(this.app.getBaseContext()));
    cQP.replace(MMApplicationContext.getPackageName() + ":appbrand", "");
    com.tencent.mm.platformtools.ac.mEX = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ac.mEY = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ac.mEZ = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ac.mFa = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ac.mFb = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ac.mFc = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ac.mFh = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ac.mFi = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ac.mFl = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ac.mFm = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ac.mFn = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ac.mFo = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ac.mFr = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ac.mFs = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(localp.JD(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ac.mFp = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ac.mFp > 0))
    {
      com.tencent.mm.storage.aq.VfZ = com.tencent.mm.platformtools.ac.mFp;
      Log.e("MicroMsg.AppBDebugger", "cdn thread num " + com.tencent.mm.platformtools.ac.mFp);
    }
    com.tencent.mm.platformtools.ac.mFq = Util.nullAs(localp.JE(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    com.tencent.mm.platformtools.ac.mFK = Util.nullAs(localp.JE(".com.tencent.mm.debug.forcex5webview"), false);
    com.tencent.mm.platformtools.ac.mFH = Util.nullAs(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    Log.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.mFH);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.arg(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.kQZ = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAy = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAA = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.kQZ).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.RAC).append(" new: ").append(i);
          com.tencent.mm.protocal.d.RAC = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.iQW.iPy = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(localp.JE(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(localp.JE(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(localp.JE(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(localp.JE(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                if (WeChatEnvironment.hasDebugger()) {
                  new Shell().init(MMApplicationContext.getContext());
                }
                a.aak();
                j.KW("commonimgdec");
                j.KW("wechatcommon");
                j.KW("wechatbase");
                j.KW(CommLibFileName.quic);
                j.KW("wechatmm");
                j.KW("FFmpeg");
                j.KW("wechatpack");
                ac.abg();
                com.tencent.mm.plugin.appbrand.api.a.nBl = Util.nowMilliSecond();
                com.tencent.mm.xwebutil.c.lQ(this.app);
                com.tencent.mm.plugin.appbrand.api.a.nBm = Util.nowMilliSecond();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile
 * JD-Core Version:    0.7.0.1
 */