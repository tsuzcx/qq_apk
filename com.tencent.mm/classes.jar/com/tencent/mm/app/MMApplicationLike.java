package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImmutableBundle;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.PatronsWrapper;
import com.tencent.mm.sdk.platformtools.ThreadStackShinkerWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WVReservedSpaceShinkerWrapper;
import com.tencent.tinker.anno.Keep;
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
import java.lang.reflect.Method;
import java.util.Properties;

@Keep
public class MMApplicationLike
  extends DefaultApplicationLike
{
  private static final String TAG = "MicroMsg.MMApplication";
  private static MMApplicationLike sSafeguardInstance = null;
  private static byte[] sSafeguardLock = new byte[0];
  private s mMMApplicationLikeImpl;
  private ApplicationLifeCycle wrapper;
  
  @Keep
  public MMApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
    AppMethodBeat.i(123467);
    this.mMMApplicationLikeImpl = new s(this);
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
    Object localObject1 = ad.bO(paramContext);
    if (localObject1 == null) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
    }
    for (;;)
    {
      BuildInfo.DEBUG = false;
      BuildInfo.BUILD_TAG = "Android_Wechat_RELEASE #8780";
      BuildInfo.OWNER = "amm_code_helper";
      BuildInfo.HOSTNAME = "VM_68_37_centos";
      BuildInfo.TIME = "2021-07-02 19:00:26";
      BuildInfo.COMMAND = "null";
      BuildInfo.REV = "999a31602a87e54588225e7c692eb761d9753386";
      BuildInfo.SVNPATH = "RB-2021-JUN@git";
      int i;
      label207:
      Object localObject3;
      if (com.tencent.mm.loader.j.a.IS_ARM64)
      {
        localObject1 = "0x28000737";
        BuildInfo.CLIENT_VERSION = (String)localObject1;
        BuildInfo.CLIENT_VERSION_INT = Integer.decode((String)localObject1).intValue();
        BuildInfo.ENABLE_FPS_ANALYSE = false;
        BuildInfo.ENABLE_MATRIX = true;
        BuildInfo.ENABLE_MATRIX_TRACE = false;
        BuildInfo.EX_DEVICE_LOGIN = false;
        BuildInfo.PRE_RELEASE = false;
        BuildInfo.REDESIGN_ENTRANCE = false;
        BuildInfo.IS_FLAVOR_RED = false;
        BuildInfo.IS_FLAVOR_PURPLE = false;
        BuildInfo.IS_FLAVOR_BLUE = false;
        BuildInfo.MATRIX_VERSION = "2.0.0-344";
        BuildInfo.IS_ARM64 = com.tencent.mm.loader.j.a.IS_ARM64;
        BuildInfo.KINDA_DEFAULT = "default";
        BuildInfo.TINKER_VERSION = "1.9.14.17";
        BuildInfo.IS_UAT = false;
        BuildInfo.ENABLE_PAYTEST = false;
        BuildInfo.OVERRIDE_VERSION_NAME = "";
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
          break label207;
          com.tencent.mm.loader.j.a.F((Bundle)localObject1);
          continue;
          localObject1 = "0x28000736";
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
    com.tencent.stubs.logger.Log.setLogger(m.aaK());
    super.onBaseContextAttached(paramContext);
    Object localObject2 = Util.getProcessNameByPid(paramContext, Process.myPid());
    d.cQP = (String)localObject2;
    if (ab.bN(paramContext))
    {
      AppMethodBeat.o(123468);
      return;
    }
    Object localObject4 = this.mMMApplicationLikeImpl;
    if (!BuildInfo.DEBUG)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
      l.g(s.fcb.getApplication());
    }
    if (!MMApplicationContext.isToolsIsolatedProcess())
    {
      ai.a.feP.b(s.fcb);
      ai.a.feP.abn();
    }
    localObject1 = s.fcb;
    if ((localObject1 == null) || (((ApplicationLike)localObject1).getApplication() == null))
    {
      paramContext = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(123468);
      throw paramContext;
    }
    Object localObject5;
    if ((ShareTinkerInternals.isTinkerEnabledForNativeLib(((ApplicationLike)localObject1).getTinkerFlags())) && (com.tencent.tinker.lib.e.b.c(s.fcb)))
    {
      if (com.tencent.mm.loader.j.a.IS_ARM64)
      {
        localObject1 = s.gN("arm64-v8a");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          j.KV((String)localObject1);
        }
        com.tencent.tinker.lib.a.a.a(s.fcb, "arm64-v8a");
      }
    }
    else
    {
      d.fcc = s.fcb.getApplicationStartMillisTime();
      s.a(s.fcb);
      s.fcP = s.fcP + "/" + localObject4.hashCode();
      MMApplicationContext.setAppHasInitFlag(false);
      MMApplicationContext.setContext(s.fcb.getApplication());
      com.tencent.mm.sdk.platformtools.Log.setLevel(0, false);
      long l1 = System.currentTimeMillis();
      localObject5 = new r(com.tencent.mm.loader.j.b.aSD() + "NowRev.ini");
      if ((((r)localObject5).propertie == null) || (!((r)localObject5).propertie.containsKey("NowRev"))) {
        break label1482;
      }
      localObject1 = ((r)localObject5).propertie.getProperty("NowRev");
      label638:
      ((s)localObject4).fcQ = ((String)localObject1);
      ((s)localObject4).fcR = BuildInfo.CLIENT_VERSION;
      long l2 = System.currentTimeMillis();
      ((s)localObject4).fcS = (l2 - l1);
      ((s)localObject4).fcT = 0L;
      if (!((s)localObject4).fcR.equals(((s)localObject4).fcQ))
      {
        MMApplicationContext.sIsRevChange = true;
        s.w(s.fcb.getApplication().getDir("lib", 0));
        s.w(s.fcb.getApplication().getDir("dex", 0));
        s.w(s.fcb.getApplication().getDir("cache", 0));
        s.w(s.fcb.getApplication().getDir("recover_lib", 0));
        if (com.tencent.mm.loader.j.a.CLIENT_VERSION.equals(BuildInfo.CLIENT_VERSION))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMApplicationLikeImpl", "[tomys] clean patch since base apk is upgraded, prev_clientversion: %s, curr_clientversion: %s, curr_base_clientversion: %s", new Object[] { ((s)localObject4).fcQ, ((s)localObject4).fcR, com.tencent.mm.loader.j.a.CLIENT_VERSION });
          com.tencent.tinker.lib.e.b.e(s.fcb);
        }
        ((r)localObject5).saveValue("NowRev", ((s)localObject4).fcR);
        ((s)localObject4).fcT = (System.currentTimeMillis() - l2);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", new Object[] { s.fcP, Util.getStack().toString() });
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[] { ((s)localObject4).fcQ, ((s)localObject4).fcR, Long.valueOf(((s)localObject4).fcS), Long.valueOf(((s)localObject4).fcT) });
      if ((BuildInfo.DEBUG) || (BuildInfo.PRE_RELEASE))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
        l.g(s.fcb.getApplication());
      }
      ThreadStackShinkerWrapper.tryToInstall(paramContext);
      WVReservedSpaceShinkerWrapper.tryToInstall(paramContext);
      PatronsWrapper.tryToInstall(paramContext);
      if (((String)localObject2).equals(paramContext.getPackageName())) {
        x.a("MicroMsg.MMApplication", "** Hit main process condition.", new Object[0]);
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
        x.a("MicroMsg.MMApplication", "** Before fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint });
        x.a(19725, new Object[] { Integer.valueOf(2), localObject2, String.format("BEFORE_FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        localFile2 = new File(localFile1, SharePatchFileUtil.getPatchVersionDirectory(((SharePatchInfo)localObject5).newVersion));
        localFile1 = new File(localFile2, "odex");
        localFile2 = new File(localFile2, "interpet");
        localFile1 = new File(localFile1, "tinker_classN.dex");
        localFile2 = new File(localFile2, "tinker_classN.dex");
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          continue;
        }
        ((SharePatchInfo)localObject5).oatDir = "odex";
        x.a(19725, new Object[] { Integer.valueOf(2), localObject2, String.format("FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        x.a("MicroMsg.MMApplication", "** After fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint });
        SharePatchInfo.rewritePatchInfoFileWithLock((File)localObject1, (SharePatchInfo)localObject5, (File)localObject4);
        x.a("MicroMsg.MMApplication", "** Killing other processes.", new Object[0]);
        ShareTinkerInternals.killProcessExceptMain(paramContext);
        x.a("MicroMsg.MMApplication", "** Other processes were killed.", new Object[0]);
      }
      catch (Throwable localThrowable1)
      {
        File localFile2;
        label1482:
        x.a("MicroMsg.MMApplication", localThrowable1, "** Exception occurred.", new Object[0]);
        continue;
        x.a("MicroMsg.MMApplication", "** Status is ok, do not needs to do fix.", new Object[0]);
        continue;
        x.a("MicroMsg.MMApplication", "** Patch is not loaded, do not needs to do fix.", new Object[0]);
        continue;
      }
      if (!k.f(getApplication())) {
        break label1564;
      }
      AppMethodBeat.o(123468);
      return;
      localObject1 = s.gN("armeabi-v7a");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        j.KV((String)localObject1);
      }
      localObject1 = s.gN("armeabi");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        j.KV((String)localObject1);
      }
      com.tencent.tinker.lib.a.a.a(s.fcb, "armeabi-v7a");
      com.tencent.tinker.lib.a.a.a(s.fcb, "armeabi");
      break;
      localObject1 = null;
      break label638;
      if ((localFile2.exists()) && (localFile2.canRead())) {
        ((SharePatchInfo)localObject5).oatDir = "interpet";
      }
    }
    try
    {
      label1564:
      Method localMethod = Class.forName("com.tencent.mm.app.StartupCostReporter").getDeclaredMethod("install", new Class[] { Application.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { getApplication() });
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          if (MMApplicationContext.isToolsIsolatedProcess())
          {
            this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMIsolatedApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
            this.wrapper.onBaseContextAttached(paramContext);
            AppMethodBeat.o(123468);
            return;
            localThrowable2 = localThrowable2;
            x.a("MicroMsg.MMApplication", localThrowable2, "Fail to install StartupCostReporter.", new Object[0]);
            continue;
          }
          if (MMApplicationContext.isNoSpaceProcess())
          {
            this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMCleanApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
            continue;
          }
          if (!MMApplicationContext.isHotpotDotDotProcess()) {
            break label1905;
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
        label1905:
        if (MMApplicationContext.isBacktraceProcess()) {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMWeChatBacktraceWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
        } else if (MMApplicationContext.isImeProcess()) {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMHldApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
        } else {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
        }
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
    try
    {
      Method localMethod = Class.forName("com.tencent.mm.app.StartupCostReporter").getDeclaredMethod("checkColdStartup", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[0]);
      if (this.wrapper != null) {
        this.wrapper.onCreate();
      }
      AppMethodBeat.o(123469);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        x.a("MicroMsg.MMApplication", localThrowable, "Fail to checkColdStartup.", new Object[0]);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationLike
 * JD-Core Version:    0.7.0.1
 */