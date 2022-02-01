package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.obb.loader.ObbClassLoader;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GPApplication
  extends Application
{
  private static final String CLASSLOADER_INITIALIZER_CLASSNAME = "com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer";
  private static final String CLASSLOADER_INITIALIZER_METHODNAME = "initializeClassLoader";
  private static final String TAG = "MicroMsg.GPApplication";
  private static final String WECHAT_APPLICATION_LIKE_CLASSNAME = "com.tencent.mm.app.MMApplicationLike";
  private Handler mInlineFence;
  private final Intent mResultIntent;
  
  public GPApplication()
  {
    AppMethodBeat.i(239167);
    this.mResultIntent = new Intent();
    this.mInlineFence = null;
    AppMethodBeat.o(239167);
  }
  
  private Handler createInlineFence(long paramLong1, long paramLong2, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(239179);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.app.MMApplicationLike", false, paramClassLoader).getConstructor(new Class[] { Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class }).newInstance(new Object[] { this, Integer.valueOf(0), Boolean.TRUE, Long.valueOf(paramLong1), Long.valueOf(paramLong2), this.mResultIntent });
      paramClassLoader = Class.forName("com.tencent.mm.app.GPAppInlineFence", false, paramClassLoader).getDeclaredConstructor(new Class[] { Class.forName("com.tencent.tinker.entry.ApplicationLike", false, paramClassLoader) });
      paramClassLoader.setAccessible(true);
      paramClassLoader = (Handler)paramClassLoader.newInstance(new Object[] { localObject });
      AppMethodBeat.o(239179);
      return paramClassLoader;
    }
    finally
    {
      paramClassLoader = new IllegalStateException("createInlineFence failed", paramClassLoader);
      AppMethodBeat.o(239179);
    }
  }
  
  private void replaceAndInitAppClassLoader()
  {
    AppMethodBeat.i(239172);
    try
    {
      ClassLoader localClassLoader = ObbClassLoader.injectOnDemand(this);
      Class localClass;
      return;
    }
    finally
    {
      try
      {
        localClass = Class.forName("com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer", false, localClassLoader);
        localClass.getDeclaredMethod("initializeClassLoader", new Class[] { Application.class, ClassLoader.class }).invoke(localClass.newInstance(), new Object[] { this, localClassLoader });
        ShareIntentUtil.setIntentReturnCode(this.mResultIntent, -1);
        AppMethodBeat.o(239172);
        return;
      }
      finally
      {
        ShareTinkerLog.printErrStackTrace("MicroMsg.GPApplication", localThrowable2, "[-] Error when init expansion classloader.", new Object[0]);
        ShareIntentUtil.setIntentReturnCode(this.mResultIntent, -27);
        this.mResultIntent.putExtra("intent_patch_exception", localThrowable2);
        AppMethodBeat.o(239172);
      }
      localThrowable1 = finally;
      ShareTinkerLog.printErrStackTrace("MicroMsg.GPApplication", localThrowable1, "[-] Error when inject expansion classloader.", new Object[0]);
      ShareIntentUtil.setIntentReturnCode(this.mResultIntent, -26);
      this.mResultIntent.putExtra("intent_patch_exception", localThrowable1);
      AppMethodBeat.o(239172);
      return;
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(239186);
    super.attachBaseContext(paramContext);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = System.currentTimeMillis();
    replaceAndInitAppClassLoader();
    this.mInlineFence = createInlineFence(l1, l2, paramContext.getClassLoader());
    Handler localHandler = this.mInlineFence;
    localHandler.handleMessage(Message.obtain(localHandler, 1, paramContext));
    AppMethodBeat.o(239186);
  }
  
  public AssetManager getAssets()
  {
    AppMethodBeat.i(239213);
    Object localObject2 = super.getAssets();
    if (this.mInlineFence != null)
    {
      Object localObject1 = this.mInlineFence;
      localObject2 = Message.obtain((Handler)localObject1, 9, localObject2);
      ((Handler)localObject1).handleMessage((Message)localObject2);
      localObject1 = (AssetManager)((Message)localObject2).obj;
      AppMethodBeat.o(239213);
      return localObject1;
    }
    AppMethodBeat.o(239213);
    return localObject2;
  }
  
  public Context getBaseContext()
  {
    AppMethodBeat.i(239219);
    Object localObject2 = super.getBaseContext();
    if (this.mInlineFence != null)
    {
      Object localObject1 = this.mInlineFence;
      localObject2 = Message.obtain((Handler)localObject1, 8, localObject2);
      ((Handler)localObject1).handleMessage((Message)localObject2);
      localObject1 = (Context)((Message)localObject2).obj;
      AppMethodBeat.o(239219);
      return localObject1;
    }
    AppMethodBeat.o(239219);
    return localObject2;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(239209);
    Object localObject2 = super.getClassLoader();
    if (this.mInlineFence != null)
    {
      Object localObject1 = this.mInlineFence;
      localObject2 = Message.obtain((Handler)localObject1, 7, localObject2);
      ((Handler)localObject1).handleMessage((Message)localObject2);
      localObject1 = (ClassLoader)((Message)localObject2).obj;
      AppMethodBeat.o(239209);
      return localObject1;
    }
    AppMethodBeat.o(239209);
    return localObject2;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(239207);
    Object localObject2 = super.getResources();
    if (this.mInlineFence != null)
    {
      Object localObject1 = this.mInlineFence;
      localObject2 = Message.obtain((Handler)localObject1, 10, localObject2);
      ((Handler)localObject1).handleMessage((Message)localObject2);
      localObject1 = (Resources)((Message)localObject2).obj;
      AppMethodBeat.o(239207);
      return localObject1;
    }
    AppMethodBeat.o(239207);
    return localObject2;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(239216);
    Object localObject = super.getSystemService(paramString);
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      paramString = Message.obtain(localHandler, 11, new Object[] { paramString, localObject });
      localHandler.handleMessage(paramString);
      paramString = paramString.obj;
      AppMethodBeat.o(239216);
      return paramString;
    }
    AppMethodBeat.o(239216);
    return localObject;
  }
  
  public int mzNightModeUseOf()
  {
    AppMethodBeat.i(239222);
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      Message localMessage = Message.obtain(localHandler, 12);
      localHandler.handleMessage(localMessage);
      int i = ((Integer)localMessage.obj).intValue();
      AppMethodBeat.o(239222);
      return i;
    }
    AppMethodBeat.o(239222);
    return 1;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(239203);
    super.onConfigurationChanged(paramConfiguration);
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      localHandler.handleMessage(Message.obtain(localHandler, 3, paramConfiguration));
    }
    AppMethodBeat.o(239203);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(239189);
    super.onCreate();
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      localHandler.handleMessage(Message.obtain(localHandler, 2));
    }
    AppMethodBeat.o(239189);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(239194);
    super.onLowMemory();
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      localHandler.handleMessage(Message.obtain(localHandler, 5));
    }
    AppMethodBeat.o(239194);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(239192);
    super.onTerminate();
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      localHandler.handleMessage(Message.obtain(localHandler, 6));
    }
    AppMethodBeat.o(239192);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(239199);
    super.onTrimMemory(paramInt);
    if (this.mInlineFence != null)
    {
      Handler localHandler = this.mInlineFence;
      localHandler.handleMessage(Message.obtain(localHandler, 4, Integer.valueOf(paramInt)));
    }
    AppMethodBeat.o(239199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.GPApplication
 * JD-Core Version:    0.7.0.1
 */