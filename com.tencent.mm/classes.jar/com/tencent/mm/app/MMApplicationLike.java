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
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.stubs.logger.Log;
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
  private s mMMApplicationLikeImpl;
  private ApplicationLifeCycle wrapper;
  
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
    if (ak.getResources() == null)
    {
      AppMethodBeat.o(123472);
      return paramResources;
    }
    paramResources = ak.getResources();
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
    e.o(getApplication());
    Object localObject1 = ac.bv(paramContext);
    if (localObject1 == null) {
      ae.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.j.DEBUG = false;
      com.tencent.mm.sdk.platformtools.j.BUILD_TAG = "Android_Wechat_RELEASE #4989";
      com.tencent.mm.sdk.platformtools.j.OWNER = "amm_code_helper";
      com.tencent.mm.sdk.platformtools.j.HOSTNAME = "VM_53_123_centos";
      com.tencent.mm.sdk.platformtools.j.TIME = "2020-09-16 21:37:51";
      com.tencent.mm.sdk.platformtools.j.COMMAND = "null";
      com.tencent.mm.sdk.platformtools.j.REV = "7f05ae1efc6e7d749831f1d7649292886e9a9393";
      com.tencent.mm.sdk.platformtools.j.SVNPATH = "RB-2020-SEP@git";
      int i;
      label191:
      Object localObject3;
      if (com.tencent.mm.loader.j.a.hjx)
      {
        localObject1 = "0x27001335";
        com.tencent.mm.sdk.platformtools.j.hju = (String)localObject1;
        com.tencent.mm.sdk.platformtools.j.IwD = Integer.decode((String)localObject1).intValue();
        com.tencent.mm.sdk.platformtools.j.ENABLE_FPS_ANALYSE = false;
        com.tencent.mm.sdk.platformtools.j.ENABLE_MATRIX = true;
        com.tencent.mm.sdk.platformtools.j.ENABLE_MATRIX_TRACE = false;
        com.tencent.mm.sdk.platformtools.j.EX_DEVICE_LOGIN = false;
        com.tencent.mm.sdk.platformtools.j.PRE_RELEASE = false;
        com.tencent.mm.sdk.platformtools.j.REDESIGN_ENTRANCE = false;
        com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED = false;
        com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE = false;
        com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_BLUE = false;
        com.tencent.mm.sdk.platformtools.j.MATRIX_VERSION = "0.7.8.24";
        com.tencent.mm.sdk.platformtools.j.hjx = com.tencent.mm.loader.j.a.hjx;
        com.tencent.mm.sdk.platformtools.j.KINDA_DEFAULT = "default";
        com.tencent.mm.sdk.platformtools.j.TINKER_VERSION = "1.9.14.8";
        com.tencent.mm.sdk.platformtools.j.IS_UAT = false;
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
          ae.i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", new Object[] { localObject3.getName(), localObject3.get(null) });
          ((ArrayMap)localObject1).put(localObject3.getName(), localObject3.get(null));
          i += 1;
          break label191;
          com.tencent.mm.loader.j.a.s((Bundle)localObject1);
          continue;
          localObject1 = "0x27001334";
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", localIllegalAccessException, "", new Object[0]);
          }
        }
      }
    }
    Object localObject2 = com.tencent.mm.sdk.platformtools.j.IwE;
    if (!((v)localObject2).IwY) {
      ((v)localObject2).IwX.putAll((ArrayMap)localObject1);
    }
    com.tencent.mm.sdk.platformtools.j.IwE.IwY = true;
    Log.setLogger(m.Md());
    super.onBaseContextAttached(paramContext);
    localObject2 = bu.getProcessNameByPid(paramContext, Process.myPid());
    d.cEw = (String)localObject2;
    if (aa.bu(paramContext))
    {
      AppMethodBeat.o(123468);
      return;
    }
    Object localObject4 = this.mMMApplicationLikeImpl;
    if (!com.tencent.mm.sdk.platformtools.j.DEBUG)
    {
      ae.e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
      l.f(s.cTZ.getApplication());
    }
    if (!ak.foB())
    {
      ag.a.cWf.b(s.cTZ);
      ag.a.cWf.Mx();
    }
    localObject1 = s.cTZ;
    if ((localObject1 == null) || (((ApplicationLike)localObject1).getApplication() == null))
    {
      paramContext = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(123468);
      throw paramContext;
    }
    Object localObject5;
    if ((ShareTinkerInternals.isTinkerEnabledForNativeLib(((ApplicationLike)localObject1).getTinkerFlags())) && (com.tencent.tinker.lib.e.b.c(s.cTZ)))
    {
      if (com.tencent.mm.loader.j.a.hjx)
      {
        localObject1 = s.fp("arm64-v8a");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          com.tencent.mm.compatible.util.j.vL((String)localObject1);
        }
        com.tencent.tinker.lib.a.a.a(s.cTZ, "arm64-v8a");
      }
    }
    else
    {
      d.cUa = s.cTZ.getApplicationStartMillisTime();
      s.a(s.cTZ);
      s.cUR = s.cUR + "/" + localObject4.hashCode();
      ak.wO(false);
      ak.setContext(s.cTZ.getApplication());
      ae.abd(0);
      long l1 = System.currentTimeMillis();
      localObject5 = new r(com.tencent.mm.loader.j.b.asb() + "NowRev.ini");
      if ((((r)localObject5).cUQ == null) || (!((r)localObject5).cUQ.containsKey("NowRev"))) {
        break label1462;
      }
      localObject1 = ((r)localObject5).cUQ.getProperty("NowRev");
      label636:
      ((s)localObject4).cUS = ((String)localObject1);
      ((s)localObject4).cUT = com.tencent.mm.sdk.platformtools.j.hju;
      long l2 = System.currentTimeMillis();
      ((s)localObject4).cUU = (l2 - l1);
      ((s)localObject4).cUV = 0L;
      if (!((s)localObject4).cUT.equals(((s)localObject4).cUS))
      {
        ak.IxN = true;
        s.D(s.cTZ.getApplication().getDir("lib", 0));
        s.D(s.cTZ.getApplication().getDir("dex", 0));
        s.D(s.cTZ.getApplication().getDir("cache", 0));
        s.D(s.cTZ.getApplication().getDir("recover_lib", 0));
        if (com.tencent.mm.loader.j.a.hju.equals(com.tencent.mm.sdk.platformtools.j.hju))
        {
          ae.i("MicroMsg.MMApplicationLikeImpl", "[tomys] clean patch since base apk is upgraded, prev_clientversion: %s, curr_clientversion: %s, curr_base_clientversion: %s", new Object[] { ((s)localObject4).cUS, ((s)localObject4).cUT, com.tencent.mm.loader.j.a.hju });
          com.tencent.tinker.lib.e.b.e(s.cTZ);
        }
        ((r)localObject5).N("NowRev", ((s)localObject4).cUT);
        ((s)localObject4).cUV = (System.currentTimeMillis() - l2);
        ae.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", new Object[] { s.cUR, bu.fpN().toString() });
      }
      ae.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[] { ((s)localObject4).cUS, ((s)localObject4).cUT, Long.valueOf(((s)localObject4).cUU), Long.valueOf(((s)localObject4).cUV) });
      if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.PRE_RELEASE))
      {
        ae.e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
        l.f(s.cTZ.getApplication());
      }
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
        x.f(new Object[] { Integer.valueOf(2), localObject2, String.format("BEFORE_FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        localFile2 = new File(localFile1, SharePatchFileUtil.getPatchVersionDirectory(((SharePatchInfo)localObject5).newVersion));
        localFile1 = new File(localFile2, "odex");
        localFile2 = new File(localFile2, "interpet");
        localFile1 = new File(localFile1, "tinker_classN.dex");
        localFile2 = new File(localFile2, "tinker_classN.dex");
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          continue;
        }
        ((SharePatchInfo)localObject5).oatDir = "odex";
        x.f(new Object[] { Integer.valueOf(2), localObject2, String.format("FIXED##%s##%s##%s##%s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint }) });
        x.a("MicroMsg.MMApplication", "** After fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", new Object[] { ((SharePatchInfo)localObject5).oldVersion, ((SharePatchInfo)localObject5).newVersion, ((SharePatchInfo)localObject5).oatDir, ((SharePatchInfo)localObject5).fingerPrint });
        SharePatchInfo.rewritePatchInfoFileWithLock((File)localObject1, (SharePatchInfo)localObject5, (File)localObject4);
        x.a("MicroMsg.MMApplication", "** Killing other processes.", new Object[0]);
        ShareTinkerInternals.killProcessExceptMain(paramContext);
        x.a("MicroMsg.MMApplication", "** Other processes were killed.", new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        File localFile2;
        label1462:
        x.a("MicroMsg.MMApplication", localThrowable, "** Exception occurred.");
        continue;
        x.a("MicroMsg.MMApplication", "** Status is ok, do not needs to do fix.", new Object[0]);
        continue;
        x.a("MicroMsg.MMApplication", "** Patch is not loaded, do not needs to do fix.", new Object[0]);
        continue;
      }
      if (!k.e(getApplication())) {
        break label1540;
      }
      AppMethodBeat.o(123468);
      return;
      localObject1 = s.fp("armeabi-v7a");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        com.tencent.mm.compatible.util.j.vL((String)localObject1);
      }
      localObject1 = s.fp("armeabi");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        com.tencent.mm.compatible.util.j.vL((String)localObject1);
      }
      com.tencent.tinker.lib.a.a.a(s.cTZ, "armeabi-v7a");
      com.tencent.tinker.lib.a.a.a(s.cTZ, "armeabi");
      break;
      localObject1 = null;
      break label636;
      if ((localFile2.exists()) && (localFile2.canRead())) {
        ((SharePatchInfo)localObject5).oatDir = "interpet";
      }
    }
    for (;;)
    {
      try
      {
        label1540:
        if (ak.foB())
        {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(ak.getPackageName() + ".app.MMIsolatedApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
          this.wrapper.onBaseContextAttached(paramContext);
          AppMethodBeat.o(123468);
          return;
        }
        if (ak.foI())
        {
          this.wrapper = ((ApplicationLifeCycle)Class.forName(ak.fov() + ".app.MMCleanApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
          continue;
        }
        if (!ak.foG()) {
          break label1814;
        }
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.MMApplication", paramContext, "failed to create application wrapper class", new Object[0]);
        paramContext = new RuntimeException("failed to create application wrapper class", paramContext);
        AppMethodBeat.o(123468);
        throw paramContext;
      }
      this.wrapper = ((ApplicationLifeCycle)Class.forName(ak.fov() + ".app.MMHotpotDotDotWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
      continue;
      label1814:
      this.wrapper = ((ApplicationLifeCycle)Class.forName(ak.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject2 }));
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(123471);
    ae.d("MicroMsg.MMApplication", "configuration changed");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationLike
 * JD-Core Version:    0.7.0.1
 */