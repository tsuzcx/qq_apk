package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.d
{
  private final String TAG;
  private final String cUu;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(188240);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.cUu = (ak.getProcessName() + ":lite");
    AppMethodBeat.o(188240);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(188238);
    ae.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(188238);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(188237);
    ae.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = this.app;
    p.g(localObject1, "app");
    localObject1 = com.tencent.mm.booter.d.bL(((Application)localObject1).getBaseContext());
    p.g(localObject1, "debugger");
    localObject1 = new s((com.tencent.mm.booter.d)localObject1);
    ((s)localObject1).ux("LITE");
    ac.iQV = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iQW = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iQX = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iQY = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iQZ = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iRa = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iRe = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iRf = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.location_help"), false);
    ac.iRi = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iRj = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iRk = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iRl = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iRo = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iRp = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bu.a(((s)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iRm = i;
    if ((i != 4) && (ac.iRm > 0))
    {
      com.tencent.mm.storage.al.IKf = ac.iRm;
      ae.e(((s)localObject1).TAG, "cdn thread num " + ac.iRm);
    }
    ac.iRn = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      p.g(localObject2, "malformVersion");
      com.tencent.mm.protocal.d.aag(((Integer)localObject2).intValue());
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(((Integer)localObject2).intValue()));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bu.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.FFF = String.valueOf(localObject2);
          b.aRu((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(b.fnG());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(localObject2);
          com.tencent.mm.protocal.d.FFG = ((Integer)localObject2).intValue();
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            com.tencent.mm.booter.d locald = ((s)localObject1).Xk();
            p.g(localObject2, "setchannel");
            locald.fGh = ((Integer)localObject2).intValue();
            new StringBuilder("set up test channel = ").append(localObject2);
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                ac.iRC = bu.bI(((s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ae.d(((s)localObject1).TAG, "Test.jsapiPermission = " + ac.iRC);
                ac.iRD = bu.bI(((s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ae.d(((s)localObject1).TAG, "Test.generalCtrl = " + ac.iRD);
                ac.iRE = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ae.d(((s)localObject1).TAG, "Test.skipLoadUrlCheck = " + ac.iRE);
                ac.iRF = bu.a(((s)localObject1).uy(".com.tencent.mm.debug.forcex5webview"), false);
                ae.d(((s)localObject1).TAG, "Test.forceX5WebView = " + ac.iRF);
                f.bl((Context)((h)g.ajO().ajq()).akJ());
                com.tencent.mm.f.a.bH(ak.getContext());
                t.a((av.c)new LiteAppProfile.a());
                t.fq(this.cUu);
                ab.Mv();
                a.LC();
                p.g(LiteAppProfile.class.getClassLoader(), "LiteAppProfile::class.java.classLoader");
                j.load("wechatxlog");
                j.vN("wechatcommon");
                j.vN("wechatbase");
                j.vN("wechatmm");
                j.vN(com.tencent.mm.sdk.a.IvK);
                j.load("wechatlv");
                ae.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(188237);
                return;
                localException1 = localException1;
                ae.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                ae.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                ae.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                ae.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ae.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(188239);
    super.onTrimMemory(paramInt);
    ae.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(188239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */