package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.GCSemiSpaceTrimWrapper;
import com.tencent.mm.sdk.platformtools.ImmutableBundle;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.PatronsWrapper;
import com.tencent.mm.sdk.platformtools.ThreadStackShinkerWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WVReservedSpaceShinkerWrapper;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

public class MMApplicationLike
  extends DefaultApplicationLike
{
  private static final String TAG = "MicroMsg.MMApplication";
  private static MMApplicationLike sSafeguardInstance = null;
  private static byte[] sSafeguardLock = new byte[0];
  private v mMMApplicationLikeImpl;
  private ApplicationLifeCycle wrapper;
  
  public MMApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
    AppMethodBeat.i(123467);
    this.mMMApplicationLikeImpl = new v(this);
    aa.a("MicroMsg.MMApplication", "[+] ClassLoader of MMApplicationLike: %s", new Object[] { MMApplicationLike.class.getClassLoader() });
    AppMethodBeat.o(123467);
  }
  
  public Resources getResources(Resources paramResources)
  {
    AppMethodBeat.i(123472);
    if (MMApplicationContext.getResources() == null)
    {
      AppMethodBeat.o(123472);
      return paramResources;
    }
    paramResources = MMApplicationContext.getResources();
    AppMethodBeat.o(123472);
    return paramResources;
  }
  
  public int mzNightModeUseOf()
  {
    return 0;
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    AppMethodBeat.i(123468);
    if (safeguard())
    {
      AppMethodBeat.o(123468);
      return;
    }
    ApplicationGlobal.attach(getApplication());
    MMApplicationContext.setApplicationId(paramContext.getPackageName());
    Object localObject1 = ag.cB(paramContext);
    if (localObject1 == null) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
    }
    for (;;)
    {
      BuildInfo.DEBUG = false;
      BuildInfo.BUILD_TAG = "Android_Wechat_RELEASE #12812";
      BuildInfo.OWNER = "amm_code_helper";
      BuildInfo.HOSTNAME = "VM_53_123_centos";
      BuildInfo.TIME = "2022-01-25 18:21:16";
      BuildInfo.COMMAND = "null";
      BuildInfo.REV = "bf890dd246b3be076e2eadbde32b6bb720336f00";
      BuildInfo.SVNPATH = "RB-2022-JAN@git";
      int i;
      label232:
      Object localObject3;
      if (com.tencent.mm.loader.i.a.IS_ARM64)
      {
        localObject1 = "0x28001337";
        BuildInfo.CLIENT_VERSION = (String)localObject1;
        BuildInfo.CLIENT_VERSION_INT = Integer.decode((String)localObject1).intValue();
        BuildInfo.ENABLE_FPS_ANALYSE = false;
        BuildInfo.ENABLE_MATRIX = true;
        BuildInfo.ENABLE_MATRIX_SILENCE_ANALYSE = false;
        BuildInfo.ENABLE_MATRIX_MEMORY_HOOK = false;
        BuildInfo.ENABLE_MATRIX_PTHREAD_HOOK = false;
        BuildInfo.ENABLE_XPOSED_HOOK = false;
        BuildInfo.ENABLE_MATRIX_TRACE = false;
        BuildInfo.EX_DEVICE_LOGIN = false;
        BuildInfo.PRE_RELEASE = false;
        BuildInfo.REDESIGN_ENTRANCE = false;
        BuildInfo.IS_FLAVOR_RED = false;
        BuildInfo.IS_FLAVOR_PURPLE = false;
        BuildInfo.IS_FLAVOR_BLUE = false;
        BuildInfo.MATRIX_VERSION = "2.0.5-905";
        BuildInfo.IS_ARM64 = com.tencent.mm.loader.i.a.IS_ARM64;
        BuildInfo.KINDA_DEFAULT = "default";
        BuildInfo.TINKER_VERSION = "1.9.14.19-beta4";
        BuildInfo.IS_UAT = false;
        BuildInfo.ENABLE_PAYTEST = false;
        BuildInfo.OVERRIDE_VERSION_NAME = "";
        BuildInfo.ENABLE_LIVE_SDK_DEBUG = false;
        BuildInfo.LIVE_JS_ADAPTER_VERSION = 0;
        localObject1 = new ArrayMap();
        localObject2 = BuildConfig.class.getFields();
        int j = localObject2.length;
        i = 0;
        if (i < j) {
          localObject3 = localObject2[i];
        }
      }
      else
      {
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", new Object[] { localObject3.getName(), localObject3.get(null) });
          ((ArrayMap)localObject1).put(localObject3.getName(), localObject3.get(null));
          i += 1;
          break label232;
          com.tencent.mm.loader.i.a.M((Bundle)localObject1);
          continue;
          localObject1 = "0x28001336";
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", localIllegalAccessException, "", new Object[0]);
          }
        }
      }
    }
    BuildInfo.ext.putAll((ArrayMap)localObject1);
    BuildInfo.ext.markImmutable();
    com.tencent.stubs.logger.Log.setLogger(o.aCq());
    super.onBaseContextAttached(paramContext);
    Object localObject2 = Util.getProcessNameByPid(paramContext, Process.myPid());
    e.eMg = (String)localObject2;
    if (ae.cA(paramContext))
    {
      AppMethodBeat.o(123468);
      return;
    }
    localObject1 = ah.aCT();
    Object localObject4 = getApplication();
    if (((ah)localObject1).mInstalled) {
      aa.b("MicroMsg.StartupCostReporter", "[tomys] Already installed.", new Object[0]);
    }
    for (;;)
    {
      localObject4 = this.mMMApplicationLikeImpl;
      if (!BuildInfo.DEBUG)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
        n.h(v.hfI.getApplication());
      }
      if (!MMApplicationContext.isToolsIsolatedProcess())
      {
        am.a.hiV.b(v.hfI);
        am.a.hiV.aDf();
      }
      localObject1 = v.hfI;
      if ((localObject1 != null) && (((ApplicationLike)localObject1).getApplication() != null)) {
        break;
      }
      paramContext = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(123468);
      throw paramContext;
      ((ah)localObject1).hhP = ah.aCU();
      ((ah)localObject1).hhh = ((Application)localObject4);
      ((ah)localObject1).mProcessName = Util.getProcessNameByPid((Context)localObject4, Process.myPid());
      ((Application)localObject4).registerActivityLifecycleCallbacks(((ah)localObject1).hhY);
      ((ah)localObject1).mMainHandler.post(((ah)localObject1).hhV);
      ((ah)localObject1).mInstalled = true;
    }
    Object localObject5;
    if ((ShareTinkerInternals.isTinkerEnabledForNativeLib(((ApplicationLike)localObject1).getTinkerFlags())) && (com.tencent.tinker.lib.e.b.c(v.hfI)))
    {
      if (com.tencent.mm.loader.i.a.IS_ARM64)
      {
        localObject1 = v.in("arm64-v8a");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          k.Dz((String)localObject1);
        }
        com.tencent.tinker.lib.a.a.a(v.hfI, "arm64-v8a");
      }
    }
    else
    {
      e.hfJ = v.hfI.getApplicationStartMillisTime();
      v.a(v.hfI);
      v.cDz = v.cDz + "/" + localObject4.hashCode();
      MMApplicationContext.setAppHasInitFlag(false);
      MMApplicationContext.setContext(v.hfI.getApplication());
      com.tencent.mm.sdk.platformtools.Log.setLevel(0, false);
      long l1 = System.currentTimeMillis();
      localObject5 = new u(com.tencent.mm.loader.i.b.bmr() + "NowRev.ini");
      if ((((u)localObject5).propertie == null) || (!((u)localObject5).propertie.containsKey("NowRev"))) {
        break label1639;
      }
      localObject1 = ((u)localObject5).propertie.getProperty("NowRev");
      label757:
      ((v)localObject4).hgE = ((String)localObject1);
      ((v)localObject4).hgF = BuildInfo.CLIENT_VERSION;
      long l2 = System.currentTimeMillis();
      ((v)localObject4).hgG = (l2 - l1);
      ((v)localObject4).hgH = 0L;
      if (!((v)localObject4).hgF.equals(((v)localObject4).hgE))
      {
        MMApplicationContext.sIsRevChange = true;
        v.B(v.hfI.getApplication().getDir("lib", 0));
        v.B(v.hfI.getApplication().getDir("dex", 0));
        v.B(v.hfI.getApplication().getDir("cache", 0));
        v.B(v.hfI.getApplication().getDir("recover_lib", 0));
        if (com.tencent.mm.loader.i.a.CLIENT_VERSION.equals(BuildInfo.CLIENT_VERSION))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMApplicationLikeImpl", "[tomys] clean patch since base apk is upgraded, prev_clientversion: %s, curr_clientversion: %s, curr_base_clientversion: %s", new Object[] { ((v)localObject4).hgE, ((v)localObject4).hgF, com.tencent.mm.loader.i.a.CLIENT_VERSION });
          com.tencent.tinker.lib.e.b.e(v.hfI);
        }
        ((u)localObject5).saveValue("NowRev", ((v)localObject4).hgF);
        ((v)localObject4).hgH = (System.currentTimeMillis() - l2);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", new Object[] { v.cDz, Util.getStack().toString() });
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[] { ((v)localObject4).hgE, ((v)localObject4).hgF, Long.valueOf(((v)localObject4).hgG), Long.valueOf(((v)localObject4).hgH) });
      if ((BuildInfo.DEBUG) || (BuildInfo.PRE_RELEASE))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
        n.h(v.hfI.getApplication());
      }
      if ((!MMApplicationContext.isPushProcess()) && (!MMApplicationContext.isSandBoxProcess()) && (!MMApplicationContext.isBacktraceProcess()) && (!MMApplicationContext.isHotpotDotDotProcess()) && (!MMApplicationContext.isRecoveryProcess()))
      {
        ThreadStackShinkerWrapper.tryToInstall(paramContext);
        WVReservedSpaceShinkerWrapper.tryToInstall(paramContext);
        if (Build.VERSION.SDK_INT < 26) {
          break label1645;
        }
        PatronsWrapper.tryToInstall(paramContext);
      }
      label1119:
      if (((String)localObject2).equals(paramContext.getPackageName())) {
        aa.a("MicroMsg.MMApplication", "** Hit main process condition.", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        if (!com.tencent.tinker.lib.e.b.c(this)) {
          continue;
        }
        File localFile1 = SharePatchFileUtil.getPatchDirectory(paramContext);
        localObject1 = SharePatchFileUtil.getPatchInfoFile(localFile1.getAbsolutePath());
        localObject4 = SharePatchFileUtil.getPatchInfoLockFile(localFile1.getAbsolutePath());
        localObject5 = SharePatchInfo.readAndCheckPropertyWithLock((File)localObject1, (File)localObject4);
        if (!"changing".equals(((SharePatchInfo)localObject5).oatDir)) {
          continue;
        }
        aa.a("MicroMsg.MMApplication", "** Before fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint });
        aa.b(19725, new Object[] { Integer.valueOf(2), localObject2, String.format("BEFORE_FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        localFile2 = new File(localFile1, SharePatchFileUtil.getPatchVersionDirectory(((SharePatchInfo)localObject5).newVersion));
        localFile1 = new File(localFile2, "odex");
        localFile2 = new File(localFile2, "interpet");
        localFile1 = new File(localFile1, "tinker_classN.dex");
        localFile2 = new File(localFile2, "tinker_classN.dex");
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          continue;
        }
        ((SharePatchInfo)localObject5).oatDir = "odex";
        aa.b(19725, new Object[] { Integer.valueOf(2), localObject2, String.format("FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        aa.a("MicroMsg.MMApplication", "** After fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint });
        SharePatchInfo.rewritePatchInfoFileWithLock((File)localObject1, (SharePatchInfo)localObject5, (File)localObject4);
        aa.a("MicroMsg.MMApplication", "** Killing other processes.", new Object[0]);
        ShareTinkerInternals.killProcessExceptMain(paramContext);
        aa.a("MicroMsg.MMApplication", "** Other processes were killed.", new Object[0]);
      }
      finally
      {
        File localFile2;
        label1639:
        label1645:
        aa.a("MicroMsg.MMApplication", localThrowable, "** Exception occurred.", new Object[0]);
        continue;
        aa.a("MicroMsg.MMApplication", "** Status is ok, do not needs to do fix.", new Object[0]);
        continue;
        aa.a("MicroMsg.MMApplication", "** Patch is not loaded, do not needs to do fix.", new Object[0]);
        continue;
      }
      if (!m.g(getApplication())) {
        break label1728;
      }
      AppMethodBeat.o(123468);
      return;
      localObject1 = v.in("armeabi-v7a");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        k.Dz((String)localObject1);
      }
      localObject1 = v.in("armeabi");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        k.Dz((String)localObject1);
      }
      com.tencent.tinker.lib.a.a.a(v.hfI, "armeabi-v7a");
      com.tencent.tinker.lib.a.a.a(v.hfI, "armeabi");
      break;
      localObject1 = null;
      break label757;
      GCSemiSpaceTrimWrapper.tryToInstall(paramContext);
      break label1119;
      if ((localFile2.exists()) && (localFile2.canRead())) {
        ((SharePatchInfo)localObject5).oatDir = "interpet";
      }
    }
    for (;;)
    {
      try
      {
        label1728:
        if (MMApplicationContext.isToolsIsolatedProcess())
        {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMIsolatedApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
          this.wrapper.onBaseContextAttached(paramContext);
          AppMethodBeat.o(123468);
          return;
        }
        if (MMApplicationContext.isNoSpaceProcess())
        {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMCleanApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
          continue;
        }
        if (!MMApplicationContext.isHotpotDotDotProcess()) {
          break label2002;
        }
      }
      catch (Exception paramContext)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.MMApplication", paramContext, "failed to create application wrapper class", new Object[0]);
        paramContext = new RuntimeException("failed to create application wrapper class", paramContext);
        AppMethodBeat.o(123468);
        throw paramContext;
      }
      this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMHotpotDotDotWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
      continue;
      label2002:
      if (MMApplicationContext.isBacktraceProcess()) {
        this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMWeChatBacktraceWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
      } else if (MMApplicationContext.isImeProcess()) {
        this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMHldApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
      } else {
        this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(123471);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMApplication", "configuration changed");
    super.onConfigurationChanged(paramConfiguration);
    if (this.wrapper != null) {
      this.wrapper.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(123471);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(123469);
    if (this.wrapper != null) {
      this.wrapper.onCreate();
    }
    AppMethodBeat.o(123469);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(123473);
    super.onLowMemory();
    if (this.wrapper != null) {
      this.wrapper.onLowMemory();
    }
    AppMethodBeat.o(123473);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(123470);
    super.onTerminate();
    if (this.wrapper != null) {
      this.wrapper.onTerminate();
    }
    AppMethodBeat.o(123470);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(123474);
    super.onTrimMemory(paramInt);
    if (this.wrapper != null) {
      this.wrapper.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(123474);
  }
  
  public boolean safeguard()
  {
    synchronized (sSafeguardLock)
    {
      if (sSafeguardInstance != this)
      {
        if (sSafeguardInstance == null) {
          sSafeguardInstance = this;
        }
      }
      else {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationLike
 * JD-Core Version:    0.7.0.1
 */