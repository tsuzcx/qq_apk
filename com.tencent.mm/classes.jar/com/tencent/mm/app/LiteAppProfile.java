package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.c
{
  private final String PROCESS_NAME;
  private final String TAG;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(278803);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.PROCESS_NAME = (MMApplicationContext.getProcessName() + ":lite");
    AppMethodBeat.o(278803);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(278801);
    p.k(paramConfiguration, "config");
    Log.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(278801);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(278800);
    Log.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = this.app;
    p.j(localObject1, "app");
    localObject1 = com.tencent.mm.booter.d.cc(((Application)localObject1).getBaseContext());
    p.j(localObject1, "debugger");
    localObject1 = new s((com.tencent.mm.booter.d)localObject1);
    ((s)localObject1).JC("LITE");
    com.tencent.mm.platformtools.ac.mEX = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ac.mEY = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ac.mEZ = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ac.mFa = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ac.mFb = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ac.mFc = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ac.mFh = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ac.mFi = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ac.mFl = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ac.mFm = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ac.mFn = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ac.mFo = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ac.mFr = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ac.mFs = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((s)localObject1).JD(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ac.mFp = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ac.mFp > 0))
    {
      com.tencent.mm.storage.aq.VfZ = com.tencent.mm.platformtools.ac.mFp;
      Log.e(((s)localObject1).TAG, "cdn thread num " + com.tencent.mm.platformtools.ac.mFp);
    }
    com.tencent.mm.platformtools.ac.mFq = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      p.j(localObject2, "Integer.decode(getString…m.debug.log.setversion\"))");
      i = ((Integer)localObject2).intValue();
      com.tencent.mm.protocal.d.arg(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.kQZ = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.RAy = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.RAA = String.valueOf(localObject2);
          CrashReportFactory.setDebugerApiLevel((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.kQZ).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          p.j(localObject2, "Integer.decode(getString…nt.mm.debug.log.setuin\"))");
          i = ((Integer)localObject2).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.RAC).append(" new: ").append(i);
          com.tencent.mm.protocal.d.RAC = i;
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            p.j(localObject2, "Integer.decode(getString…m.debug.log.setchannel\"))");
            i = ((Integer)localObject2).intValue();
            ((s)localObject1).aqT().iPy = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                com.tencent.mm.platformtools.ac.mFH = Util.nullAs(((s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                Log.d(((s)localObject1).TAG, "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.mFH);
                com.tencent.mm.platformtools.ac.mFI = Util.nullAs(((s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                Log.d(((s)localObject1).TAG, "Test.generalCtrl = " + com.tencent.mm.platformtools.ac.mFI);
                com.tencent.mm.platformtools.ac.mFJ = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.skiploadurlcheck"), false);
                Log.d(((s)localObject1).TAG, "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ac.mFJ);
                com.tencent.mm.platformtools.ac.mFK = Util.nullAs(((s)localObject1).JE(".com.tencent.mm.debug.forcex5webview"), false);
                Log.d(((s)localObject1).TAG, "Test.forceX5WebView = " + com.tencent.mm.platformtools.ac.mFK);
                f.bE((Context)((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIC());
                t.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)new a());
                t.f(false, this.PROCESS_NAME);
                ac.abg();
                a.aak();
                LiteAppProfile.class.getClassLoader();
                j.load("wechatxlog");
                j.KW("wechatcommon");
                j.KW("wechatbase");
                j.KW("wechatmm");
                j.KW(CommLibFileName.quic);
                j.load("wechatlv");
                j.load("liteapphelper");
                Log.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(278800);
                return;
                localException1 = localException1;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                Log.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(278802);
    super.onTrimMemory(paramInt);
    Log.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(278802);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"})
  public static final class a
    implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
  {
    public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
    {
      AppMethodBeat.i(289814);
      p.k(paramMMUncaughtExceptionHandler, "ueh");
      p.k(paramString, "msg");
      p.k(paramThrowable, "ex");
      com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 3L, 1L);
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(23380, "1");
      KVCommCrossProcessReceiver.fBy();
      AppMethodBeat.o(289814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */