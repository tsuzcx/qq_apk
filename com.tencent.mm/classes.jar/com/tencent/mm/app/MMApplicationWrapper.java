package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.booter.aa;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.splash.n;
import com.tencent.mm.ui.aw;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.File;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  public Application app;
  private EasyGo hgI;
  private final ApplicationLike lifeCycle;
  private final long processInitTimestamp;
  private com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  public MMApplicationWrapper(ApplicationLike paramApplicationLike, String paramString)
  {
    AppMethodBeat.i(160077);
    this.profile = null;
    this.processInitTimestamp = System.currentTimeMillis();
    this.hgI = null;
    com.tencent.mm.blink.a.O(paramApplicationLike.getApplicationStartMillisTime(), paramApplicationLike.getApplicationStartElapsedTime());
    this.app = paramApplicationLike.getApplication();
    this.lifeCycle = paramApplicationLike;
    this.thisProcess = paramString;
    AppMethodBeat.o(160077);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(160078);
    com.tencent.mm.kernel.a.a.mDT = SystemClock.elapsedRealtime();
    com.tencent.mm.kernel.a.a.mDS = System.currentTimeMillis();
    AndroidOSafety.replaceTargetVersion(paramContext.getApplicationInfo());
    this.profile = new com.tencent.mm.kernel.b.h(this.thisProcess, this.app, this.lifeCycle);
    this.profile.mFH.mFI = l.baL();
    this.profile.mFH.mFJ = this.processInitTimestamp;
    ao.init(paramContext);
    k.a(new MMApplicationWrapper.1(this, paramContext));
    com.tencent.mm.vfs.af.i(this.profile);
    com.tencent.threadpool.g.a(this.profile.bGP, new aa());
    boolean bool1 = ad.iw(this.thisProcess);
    boolean bool2 = ad.iv(this.thisProcess);
    Object localObject;
    label272:
    float f1;
    int i;
    if (!bool1)
    {
      paramContext.getClassLoader();
      k.DA("stlport_shared");
      paramContext.getClassLoader();
      k.DA("c++_shared");
      localObject = com.tencent.mm.xlog.app.a.agYU;
      paramContext.getClassLoader();
      k.DA((String)localObject);
      this.profile.lsS = com.tencent.mm.booter.d.cO(this.profile.bGP);
      paramContext = this.profile;
      localObject = paramContext.lsS;
      if (paramContext.bbA()) {
        ((com.tencent.mm.booter.d)localObject).Ci("MM");
      }
    }
    else
    {
      com.tencent.mm.splash.a.r(this.app);
      com.tencent.matrix.a.b.c(this.app);
      ac.c(this.app);
      AppForegroundDelegate.heY.c(this.app);
      DataPackageFrequencyDetect.Ozf.c(this.app);
      com.tencent.mm.bu.a.a.iPx();
      if (bool2) {
        break label937;
      }
      ap.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
      com.tencent.mm.pluginguard.a.b(this.profile);
      paramContext = bg.okT.aM("login_user_name", "");
      localObject = new File(com.tencent.mm.loader.i.b.bmr(), "version_history.cfg");
      if ((Util.isNullOrNil(paramContext)) && (!((File)localObject).exists()))
      {
        f1 = MMApplicationContext.getContext().getResources().getConfiguration().fontScale;
        if (f1 >= 1.0F) {
          break label957;
        }
        i = 0;
        label342:
        float f2 = com.tencent.mm.ce.a.axT(i);
        Log.i("MicroMsg.FontUtil", "updateFont systemfont:%s, currentIndex:%s, currentFont:%s ", new Object[] { Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) });
        com.tencent.mm.cd.a.i(MMApplicationContext.getContext(), f2);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putFloat("current_text_size_scale_key", f2);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("current_text_size_index_key", i);
        com.tencent.mm.ce.c.axV(com.tencent.mm.ce.a.aiQ(i));
      }
      paramContext = this.app;
      MMApplicationContext.setResources(com.tencent.mm.ce.d.a(paramContext.getResources(), paramContext, bool2));
      com.tencent.mm.ce.c.a(new MMApplicationWrapper.2(this));
      if (!com.tencent.mm.ce.e.iRP()) {
        break label1103;
      }
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("special_dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        aw.jlk();
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("special_dark_mode_set_follow_system", true);
      }
    }
    for (;;)
    {
      af.at(R.raw.class);
      af.setPackageName("com.tencent.mm.boot");
      if (this.thisProcess.endsWith(":hld"))
      {
        af.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP.getResources());
        com.tencent.mm.plugin.hld.model.g.JuL.ih(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(160078);
      return;
      if (paramContext.FH(":push"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("PUSH");
        break;
      }
      if (paramContext.FH(":tools"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("TOOL");
        break;
      }
      if (paramContext.FH(":toolsmp"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("TOOLSMP");
        break;
      }
      if (paramContext.FH(":sandbox"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("SANDBOX");
        break;
      }
      if (paramContext.FH(":exdevice"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("EXDEVICE");
        break;
      }
      if (paramContext.FH(":patch"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("PATCH");
        break;
      }
      if (paramContext.FH(":appbrand0"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("APPBRAND0");
        break;
      }
      if (paramContext.FH(":appbrand1"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("APPBRAND1");
        break;
      }
      if (paramContext.FH(":appbrand2"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("APPBRAND2");
        break;
      }
      if (paramContext.FH(":appbrand3"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("APPBRAND3");
        break;
      }
      if (paramContext.FH(":appbrand4"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("APPBRAND4");
        break;
      }
      if (paramContext.FH(":TMAssistantDownloadSDKService"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("TMSDK");
        break;
      }
      if (paramContext.FH(":dexopt"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("DEXOPT");
        break;
      }
      if (paramContext.FH(":extmig"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("EXTMIG");
        break;
      }
      if (paramContext.FH(":hld"))
      {
        ((com.tencent.mm.booter.d)localObject).Ci("HLD");
        break;
      }
      if (!paramContext.FH(":magic_emoji")) {
        break;
      }
      ((com.tencent.mm.booter.d)localObject).Ci("ME");
      break;
      label937:
      Log.i("MicroMsg.MMApplicationWrapper", "is plain process. load nothing");
      ap.a(this.profile, null);
      break label272;
      label957:
      if (f1 != 1.0F)
      {
        if ((f1 > 1.0F) && (f1 <= 1.1D))
        {
          i = 2;
          break label342;
        }
        if ((f1 > 1.1D) && (f1 <= 1.2D))
        {
          i = 3;
          break label342;
        }
        if ((f1 > 1.2D) && (f1 <= 1.3D))
        {
          i = 4;
          break label342;
        }
        if ((f1 > 1.3D) && (f1 <= 1.4D))
        {
          i = 5;
          break label342;
        }
        if ((f1 > 1.4D) && (f1 <= 1.5D))
        {
          i = 6;
          break label342;
        }
        if (f1 > 1.5D)
        {
          i = 7;
          break label342;
        }
      }
      i = 1;
      break label342;
      label1103:
      if (!MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_set_follow_system", false))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", true);
        aw.jlk();
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_set_follow_system", true);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(160082);
    if (this.profile != null) {
      this.profile.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(160082);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(160080);
    com.tencent.mm.ag.c.i(this.app);
    n.iWb();
    AppMethodBeat.o(160080);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(160083);
    if (this.profile != null) {
      this.profile.onLowMemory();
    }
    AppMethodBeat.o(160083);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(160081);
    if (this.profile != null) {
      this.profile.onTerminate();
    }
    AppMethodBeat.o(160081);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(160084);
    if (this.profile != null) {
      this.profile.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(160084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper
 * JD-Core Version:    0.7.0.1
 */