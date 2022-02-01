package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.d
{
  private final String TAG;
  private final String cIB;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(196983);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.cIB = (ai.getProcessName() + ":lite");
    AppMethodBeat.o(196983);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(196981);
    ac.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(196981);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(196980);
    ac.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = this.app;
    k.g(localObject1, "app");
    localObject1 = com.tencent.mm.booter.d.bK(((Application)localObject1).getBaseContext());
    k.g(localObject1, "debugger");
    localObject1 = new com.tencent.mm.booter.s((com.tencent.mm.booter.d)localObject1);
    ((com.tencent.mm.booter.s)localObject1).rq("LITE");
    com.tencent.mm.platformtools.ab.iuU = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ab.iuV = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ab.iuW = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ab.iuX = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ab.iuY = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ab.iuZ = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ab.ivd = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ab.ive = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ab.ivh = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ab.ivi = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ab.ivj = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ab.ivk = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ab.ivn = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ab.ivo = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bs.a(((com.tencent.mm.booter.s)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ab.ivl = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ab.ivl > 0))
    {
      com.tencent.mm.storage.ag.GDs = com.tencent.mm.platformtools.ab.ivl;
      ac.e(((com.tencent.mm.booter.s)localObject1).TAG, "cdn thread num " + com.tencent.mm.platformtools.ab.ivl);
    }
    com.tencent.mm.platformtools.ab.ivm = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      k.g(localObject2, "malformVersion");
      com.tencent.mm.protocal.d.XE(((Integer)localObject2).intValue());
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(((Integer)localObject2).intValue()));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bs.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.gMK = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.DHY = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.DIa = String.valueOf(localObject2);
          b.aKr((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.gMK).append(" ").append(b.eUl());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.DIb).append(" new: ").append(localObject2);
          com.tencent.mm.protocal.d.DIb = ((Integer)localObject2).intValue();
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            com.tencent.mm.booter.d locald = ((com.tencent.mm.booter.s)localObject1).UL();
            k.g(localObject2, "setchannel");
            locald.flW = ((Integer)localObject2).intValue();
            new StringBuilder("set up test channel = ").append(localObject2);
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                com.tencent.mm.platformtools.ab.ivB = bs.bG(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ac.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.jsapiPermission = " + com.tencent.mm.platformtools.ab.ivB);
                com.tencent.mm.platformtools.ab.ivC = bs.bG(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ac.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.generalCtrl = " + com.tencent.mm.platformtools.ab.ivC);
                com.tencent.mm.platformtools.ab.ivD = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ac.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ab.ivD);
                com.tencent.mm.platformtools.ab.ivE = bs.a(((com.tencent.mm.booter.s)localObject1).rr(".com.tencent.mm.debug.forcex5webview"), false);
                ac.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.forceX5WebView = " + com.tencent.mm.platformtools.ab.ivE);
                f.bk((Context)((h)g.agO().agp()).ahJ());
                com.tencent.mm.f.a.bG(ai.getContext());
                s.a((at.c)new LiteAppProfile.a());
                s.ep(this.cIB);
                ab.KT();
                a.JV();
                k.g(LiteAppProfile.class.getClassLoader(), "LiteAppProfile::class.java.classLoader");
                j.load("wechatxlog");
                j.sC("wechatcommon");
                j.sC("wechatbase");
                j.sC("wechatmm");
                j.sC(com.tencent.mm.sdk.a.GpP);
                j.load("wechatlv");
                ac.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(196980);
                return;
                localException1 = localException1;
                ac.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                ac.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                ac.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                ac.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ac.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(196982);
    super.onTrimMemory(paramInt);
    ac.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(196982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */