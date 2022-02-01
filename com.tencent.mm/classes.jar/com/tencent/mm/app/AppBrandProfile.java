package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public class AppBrandProfile
  extends com.tencent.mm.compatible.loader.c
{
  protected static String eMg = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19429);
    Log.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
    eMg = MMApplicationContext.getProcessName();
    AppBrandProfile.class.getClassLoader();
    w.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(239094);
        h.OAn.idkeyStat(365L, 3L, 1L, false);
        KVCommCrossProcessReceiver.gNR();
        AppMethodBeat.o(239094);
      }
    });
    p localp = new p(com.tencent.mm.booter.d.cO(this.app.getBaseContext()));
    eMg.replace(MMApplicationContext.getPackageName() + ":appbrand", "");
    z.pBz = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.display_errcode"), false);
    z.pBA = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.display_msgstate"), false);
    z.pBB = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    z.pBC = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.network.force_touch"), false);
    z.pBD = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    z.pBE = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.crashIsExit"), false);
    z.pBI = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.album_show_info"), false);
    z.pBJ = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.location_help"), false);
    z.pBM = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.force_soso"), false);
    z.pBN = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    z.pBO = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    z.pBP = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    z.pBS = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.filterfpnp"), false);
    z.pBT = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(localp.Cj(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    z.pBQ = i;
    if ((i != 4) && (z.pBQ > 0))
    {
      com.tencent.mm.storage.as.acHo = z.pBQ;
      Log.e("MicroMsg.AppBDebugger", "cdn thread num " + z.pBQ);
    }
    z.pBR = Util.nullAs(localp.Ck(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    z.pCk = Util.nullAs(localp.Ck(".com.tencent.mm.debug.forcex5webview"), false);
    z.pCh = Util.nullAs(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    Log.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + z.pCh);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.axo(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.nsC = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxc = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxe = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.nsC).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Yxg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Yxg = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.lsS.lrt = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(localp.Ck(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(localp.Ck(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(localp.Ck(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(localp.Ck(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.e(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                if (WeChatEnvironment.hasDebugger()) {
                  new Shell().init(MMApplicationContext.getContext());
                }
                a.aBO();
                k.DA("commonimgdec");
                k.DA("wechatcommon");
                k.DA("wechatbase");
                k.DA(CommLibFileName.quic);
                k.DA("wechatmm");
                k.DA("FFmpeg");
                k.DA("wechatpack");
                af.aCS();
                com.tencent.mm.plugin.appbrand.api.a.qAA = Util.nowMilliSecond();
                com.tencent.mm.xwebutil.c.setSandBoxProcessCrashDumpPath(x.g(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "xweb_sandbox"), x.h(MMApplicationContext.getContext(), MMApplicationContext.getProcessName(), "xweb_sandbox"));
                com.tencent.mm.xwebutil.c.nU(this.app);
                com.tencent.mm.plugin.appbrand.api.a.qAB = Util.nowMilliSecond();
                new MediaLeakReporter(42, 52).alive();
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