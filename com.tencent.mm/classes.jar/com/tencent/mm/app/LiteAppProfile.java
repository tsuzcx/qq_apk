package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.c
{
  private final String PROCESS_NAME;
  private final String TAG;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(239257);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.PROCESS_NAME = kotlin.g.b.s.X(MMApplicationContext.getProcessName(), ":lite");
    AppMethodBeat.o(239257);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239261);
    kotlin.g.b.s.u(paramConfiguration, "config");
    Log.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(239261);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(239260);
    Log.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.booter.d.cO(this.app.getBaseContext());
    kotlin.g.b.s.s(localObject1, "debugger");
    localObject1 = new com.tencent.mm.booter.s((com.tencent.mm.booter.d)localObject1);
    ((com.tencent.mm.booter.s)localObject1).Ci("LITE");
    z.pBz = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.display_errcode"), false);
    z.pBA = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.display_msgstate"), false);
    z.pBB = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    z.pBC = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.network.force_touch"), false);
    z.pBD = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    z.pBE = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.crashIsExit"), false);
    z.pBI = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.album_show_info"), false);
    z.pBJ = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.location_help"), false);
    z.pBM = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.force_soso"), false);
    z.pBN = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    z.pBO = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    z.pBP = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    z.pBS = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.filterfpnp"), false);
    z.pBT = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Cj(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    z.pBQ = i;
    if ((i != 4) && (z.pBQ > 0))
    {
      com.tencent.mm.storage.as.acHo = z.pBQ;
      Log.e(((com.tencent.mm.booter.s)localObject1).TAG, kotlin.g.b.s.X("cdn thread num ", Integer.valueOf(z.pBQ)));
    }
    z.pBR = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      kotlin.g.b.s.s(localObject2, "malformVersion");
      com.tencent.mm.protocal.d.axo(((Integer)localObject2).intValue());
      kotlin.g.b.s.X("set up test protocal version = ", Integer.toHexString(((Integer)localObject2).intValue()));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.nsC = kotlin.g.b.s.X("android-", localObject2);
          com.tencent.mm.protocal.d.Yxc = kotlin.g.b.s.X("android-", localObject2);
          com.tencent.mm.protocal.d.Yxe = kotlin.g.b.s.X("", localObject2);
          CrashReportFactory.setDebugerApiLevel((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.nsC).append(' ').append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Yxg).append(" new: ").append(localObject2);
          com.tencent.mm.protocal.d.Yxg = ((Integer)localObject2).intValue();
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            com.tencent.mm.booter.d locald = ((q)localObject1).lsS;
            kotlin.g.b.s.s(localObject2, "setchannel");
            locald.lrt = ((Integer)localObject2).intValue();
            kotlin.g.b.s.X("set up test channel = ", localObject2);
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.e(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                z.pCh = Util.nullAs(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                Log.d(((com.tencent.mm.booter.s)localObject1).TAG, kotlin.g.b.s.X("Test.jsapiPermission = ", z.pCh));
                z.pCi = Util.nullAs(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                Log.d(((com.tencent.mm.booter.s)localObject1).TAG, kotlin.g.b.s.X("Test.generalCtrl = ", z.pCi));
                z.pCj = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.skiploadurlcheck"), false);
                Log.d(((com.tencent.mm.booter.s)localObject1).TAG, kotlin.g.b.s.X("Test.skipLoadUrlCheck = ", Boolean.valueOf(z.pCj)));
                z.pCk = Util.nullAs(((com.tencent.mm.booter.s)localObject1).Ck(".com.tencent.mm.debug.forcex5webview"), false);
                Log.d(((com.tencent.mm.booter.s)localObject1).TAG, kotlin.g.b.s.X("Test.forceX5WebView = ", Boolean.valueOf(z.pCk)));
                h.cr((Context)((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP);
                w.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)new a());
                w.f(false, this.PROCESS_NAME);
                af.aCS();
                a.aBO();
                LiteAppProfile.class.getClassLoader();
                k.load("wechatxlog");
                k.DA("wechatcommon");
                k.DA("wechatbase");
                k.DA("wechatmm");
                k.DA(CommLibFileName.quic);
                k.load("wechatlv");
                k.load("liteapphelper");
                Log.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(239260);
                return;
                localException1 = localException1;
                Log.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                Log.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                Log.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239264);
    super.onTrimMemory(paramInt);
    Log.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(239264);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/app/LiteAppProfile$onCreate$1", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;", "uncaughtException", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "msg", "", "ex", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
  {
    public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
    {
      AppMethodBeat.i(239098);
      kotlin.g.b.s.u(paramMMUncaughtExceptionHandler, "ueh");
      kotlin.g.b.s.u(paramString, "msg");
      kotlin.g.b.s.u(paramThrowable, "ex");
      com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 3L, 1L);
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(23380, "1");
      KVCommCrossProcessReceiver.gNR();
      AppMethodBeat.o(239098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */