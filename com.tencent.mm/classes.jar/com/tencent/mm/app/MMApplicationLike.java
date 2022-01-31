package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MMApplicationLike
  extends DefaultApplicationLike
{
  private static final String TAG = "MicroMsg.MMApplication";
  private j mMMApplicationLikeImpl = new j(this);
  private ApplicationLifeCycle wrapper;
  
  public MMApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
  }
  
  public Resources getResources(Resources paramResources)
  {
    if (ae.getResources() == null) {
      return paramResources;
    }
    return ae.getResources();
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    Object localObject1 = q.aF(paramContext);
    if (localObject1 == null) {
      y.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
    }
    for (;;)
    {
      d.DEBUG = false;
      d.BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #7898";
      d.OWNER = "amm_code_helper";
      d.HOSTNAME = "c39127bbe61f";
      d.TIME = "2018-09-29 00:16:23";
      d.COMMAND = "null";
      d.REV = "9583be09a035314bcc371f0780e1d8bd46a0b1d1";
      d.SVNPATH = "origin/RB-2018-AUG@git";
      d.CLIENT_VERSION = "0x26070333";
      d.ENABLE_FPS_ANALYSE = true;
      d.ENABLE_MATRIX = false;
      d.EX_DEVICE_LOGIN = false;
      d.PRE_RELEASE = false;
      d.REDESIGN_ENTRANCE = false;
      d.IS_FLAVOR_RED = false;
      localObject1 = new ArrayMap();
      localObject2 = BuildConfig.class.getFields();
      int j = localObject2.length;
      int i = 0;
      label108:
      if (i < j)
      {
        Object localObject3 = localObject2[i];
        try
        {
          y.i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", new Object[] { localObject3.getName(), localObject3.get(null) });
          ((ArrayMap)localObject1).put(localObject3.getName(), localObject3.get(null));
          i += 1;
          break label108;
          com.tencent.mm.loader.a.a.h((Bundle)localObject1);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", localIllegalAccessException, "", new Object[0]);
          }
        }
      }
    }
    Object localObject2 = d.ueg;
    if (!((p)localObject2).uev) {
      ((p)localObject2).ueu.putAll((ArrayMap)localObject1);
    }
    d.ueg.uev = true;
    super.onBaseContextAttached(paramContext);
    localObject1 = this.mMMApplicationLikeImpl;
    if ((com.tencent.tinker.lib.e.b.c(j.applicationLike)) && (com.tencent.tinker.lib.e.b.d(j.applicationLike)))
    {
      com.tencent.tinker.lib.a.a.a(j.applicationLike, "armeabi-v7a");
      com.tencent.tinker.lib.a.a.a(j.applicationLike, "armeabi");
    }
    b.bvZ = j.applicationLike.getApplicationStartMillisTime();
    j.a(j.applicationLike);
    j.bwx = j.bwx + "/" + localObject1.hashCode();
    ae.ms(false);
    ae.setContext(j.applicationLike.getApplication());
    localObject2 = bk.am(paramContext, Process.myPid());
    y.Fc(0);
    b.bnX = (String)localObject2;
    if (!d.DEBUG) {
      h.a(j.applicationLike.getApplication(), (String)localObject2);
    }
    long l1 = System.currentTimeMillis();
    com.tencent.mm.sdk.e.a locala = new com.tencent.mm.sdk.e.a(com.tencent.mm.loader.a.b.dOP + "NowRev.ini");
    ((j)localObject1).bwy = locala.getValue("NowRev");
    ((j)localObject1).bwz = com.tencent.mm.loader.a.a.EP();
    long l2 = System.currentTimeMillis();
    ((j)localObject1).bwA = (l2 - l1);
    ((j)localObject1).bwB = 0L;
    if (!((j)localObject1).bwz.equals(((j)localObject1).bwy))
    {
      ae.ufk = true;
      e.l(j.applicationLike.getApplication().getDir("lib", 0));
      e.l(j.applicationLike.getApplication().getDir("dex", 0));
      e.l(j.applicationLike.getApplication().getDir("cache", 0));
      e.l(j.applicationLike.getApplication().getDir("recover_lib", 0));
      com.tencent.tinker.lib.e.b.f(j.applicationLike);
      locala.gi("NowRev", ((j)localObject1).bwz);
      ((j)localObject1).bwB = (System.currentTimeMillis() - l2);
      y.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", new Object[] { j.bwx, bk.csb().toString() });
    }
    y.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[] { ((j)localObject1).bwy, ((j)localObject1).bwz, Long.valueOf(((j)localObject1).bwA), Long.valueOf(((j)localObject1).bwB) });
    if ((d.DEBUG) || (d.PRE_RELEASE)) {
      h.a(j.applicationLike.getApplication(), (String)localObject2);
    }
    localObject1 = b.bnX;
    try
    {
      this.wrapper = ((ApplicationLifeCycle)Class.forName(ae.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[] { ApplicationLike.class, String.class }).newInstance(new Object[] { this, localObject1 }));
      this.wrapper.onBaseContextAttached(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.MMApplication", paramContext, "failed to create application wrapper class", new Object[0]);
      throw new RuntimeException("failed to create application wrapper class", paramContext);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.d("MicroMsg.MMApplication", "configuration changed");
    super.onConfigurationChanged(paramConfiguration);
    if (this.wrapper != null) {
      this.wrapper.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    if (this.wrapper != null) {
      this.wrapper.onCreate();
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.wrapper != null) {
      this.wrapper.onLowMemory();
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.wrapper != null) {
      this.wrapper.onTerminate();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.wrapper != null) {
      this.wrapper.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationLike
 * JD-Core Version:    0.7.0.1
 */