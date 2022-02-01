package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class DexClassLoaderProvider
  extends DexClassLoader
{
  private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
  private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
  private static final long LOAD_DEX_DELAY = 3000L;
  private static final String LOGTAG = "dexloader";
  protected static DexClassLoader mClassLoaderOriginal = null;
  private static Context mContext = null;
  private static boolean mForceLoadDexFlag;
  private static DexClassLoaderProvider mInstance = null;
  private static String mRealDexPath = null;
  protected static Service mService;
  private SpeedyDexClassLoader mClassLoader = null;
  
  static
  {
    mForceLoadDexFlag = false;
    mService = null;
  }
  
  private DexClassLoaderProvider(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    if (paramBoolean)
    {
      Log.e("dexloader", "SpeedyDexClassLoader: " + mRealDexPath);
      this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, paramString3, paramClassLoader);
      return;
    }
    Log.e("dexloader", "DexClassLoader: " + mRealDexPath);
    this.mClassLoader = null;
  }
  
  public static DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    Log.i("dexloader", "new DexClassLoaderDelegate: " + paramString1 + ", context: " + paramContext);
    mContext = paramContext.getApplicationContext();
    mRealDexPath = paramString1;
    int i = paramString1.lastIndexOf("/");
    paramContext = paramString1.substring(0, i + 1);
    paramContext = paramContext + "fake_dex.jar";
    String str = paramString1.substring(i + 1);
    if ((supportSpeedyClassLoader()) && (is_first_load_tbs_dex(paramString2, str)))
    {
      Log.d("dexloader", "new DexClassLoaderDelegate -- fake: " + paramContext);
      set_first_load_tbs_dex(paramString2, str);
      mInstance = new DexClassLoaderProvider(paramContext, paramString2, paramString3, paramClassLoader, true);
      doAsyncDexLoad(str, paramString1, paramString2, paramString3, paramClassLoader);
    }
    for (;;)
    {
      return mInstance;
      Log.d("dexloader", "new DexClassLoaderDelegate -- real: " + paramString1);
      mInstance = new DexClassLoaderProvider(paramString1, paramString2, paramString3, paramClassLoader, false);
    }
  }
  
  private static void doAsyncDexLoad(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final ClassLoader paramClassLoader)
  {
    if (shouldUseDexLoaderService())
    {
      new Timer().schedule(new TimerTask()
      {
        public void run()
        {
          try
          {
            ArrayList localArrayList = new ArrayList(4);
            localArrayList.add(0, this.val$dexName);
            localArrayList.add(1, paramString2);
            localArrayList.add(2, paramString3);
            localArrayList.add(3, paramString4);
            Intent localIntent = new Intent(DexClassLoaderProvider.mContext, DexClassLoaderProviderService.class);
            localIntent.putStringArrayListExtra("dex2oat", localArrayList);
            DexClassLoaderProvider.mContext.startService(localIntent);
            Log.d("dexloader", "shouldUseDexLoaderService(" + this.val$dexName + ", " + localIntent + ")");
            return;
          }
          catch (SecurityException localSecurityException)
          {
            Log.e("dexloader", "start DexLoaderService exception", localSecurityException);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("dexloader", "after shouldUseDexLoaderService exception: " + localThrowable);
          }
        }
      }, 3000L);
      return;
    }
    Log.d("dexloader", "Background real dex loading(" + paramString1 + ")");
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        boolean bool1 = true;
        try
        {
          Object localObject = new File(this.val$dexPath.replace(".jar", ".dex"));
          if ((((File)localObject).exists()) && (((File)localObject).length() != 0L)) {
            Log.d("dexloader", "" + localObject + " existed!");
          }
          for (;;)
          {
            localObject = new File(paramString3);
            File localFile = new File(this.val$dexPath);
            boolean bool2 = ((File)localObject).exists();
            boolean bool3 = ((File)localObject).isDirectory();
            boolean bool4 = localFile.exists();
            if ((bool2) && (bool3) && (bool4)) {
              break;
            }
            Log.d("dexloader", "dex loading exception(" + bool2 + ", " + bool3 + ", " + bool4 + ")");
            return;
            Log.d("dexloader", "" + localObject + " does not existed!");
            bool1 = false;
          }
          long l = System.currentTimeMillis();
          new DexClassLoader(this.val$dexPath, paramString3, paramString4, paramClassLoader);
          localObject = String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool1) });
          Log.d("dexloader", "" + (String)localObject);
          if ((DexClassLoaderProvider.mForceLoadDexFlag) && ("tbs_jars_fusion_dex.jar".equals(paramString1)))
          {
            Log.d("dexloader", "Stop provider service after loading " + paramString1);
            if (DexClassLoaderProvider.mService != null)
            {
              Log.d("dexloader", "##Stop service##... ");
              DexClassLoaderProvider.mService.stopSelf();
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.e("dexloader", "@AsyncDexLoad task exception: " + localThrowable);
        }
      }
    }, 3000L);
  }
  
  private static boolean is_first_load_tbs_dex(String paramString1, String paramString2)
  {
    if (mForceLoadDexFlag) {}
    while (!new File(paramString1, paramString2 + "_" + "is_first_load_dex_flag_file").exists()) {
      return true;
    }
    return false;
  }
  
  static void setForceLoadDexFlag(boolean paramBoolean, Service paramService)
  {
    mForceLoadDexFlag = paramBoolean;
    mService = paramService;
  }
  
  private static void set_first_load_tbs_dex(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1, paramString2 + "_" + "is_first_load_dex_flag_file");
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static boolean shouldUseDexLoaderService()
  {
    if (mForceLoadDexFlag) {}
    while (!DexLoader.mCanUseDexLoaderProviderService) {
      return false;
    }
    return true;
  }
  
  private static boolean supportSpeedyClassLoader()
  {
    return (Build.VERSION.SDK_INT != 21) || (DexLoader.mCanUseDexLoaderProviderService);
  }
  
  private boolean useSelfClassloader()
  {
    return this.mClassLoader == null;
  }
  
  public void clearAssertionStatus()
  {
    if (useSelfClassloader())
    {
      super.clearAssertionStatus();
      return;
    }
    this.mClassLoader.clearAssertionStatus();
  }
  
  protected Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
    throws IllegalArgumentException
  {
    if (useSelfClassloader()) {
      return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    }
    return this.mClassLoader.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
  }
  
  protected Class<?> findClass(String paramString)
    throws ClassNotFoundException
  {
    if (useSelfClassloader()) {
      return super.findClass(paramString);
    }
    return this.mClassLoader.findClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findLibrary(paramString);
    }
    return this.mClassLoader.findLibrary(paramString);
  }
  
  protected URL findResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResource(paramString);
    }
    return this.mClassLoader.findResource(paramString);
  }
  
  protected Enumeration<URL> findResources(String paramString)
  {
    if (useSelfClassloader()) {
      return super.findResources(paramString);
    }
    return this.mClassLoader.findResources(paramString);
  }
  
  /* Error */
  protected Package getPackage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 201	com/tencent/smtt/export/external/DexClassLoaderProvider:useSelfClassloader	()Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 241	dalvik/system/DexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 60	com/tencent/smtt/export/external/DexClassLoaderProvider:mClassLoader	Lcom/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader;
    //   23: aload_1
    //   24: invokevirtual 242	com/tencent/smtt/export/external/DexClassLoaderProvider$SpeedyDexClassLoader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	DexClassLoaderProvider
    //   0	36	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	31	finally
    //   19	28	31	finally
  }
  
  protected Package[] getPackages()
  {
    if (useSelfClassloader()) {
      return super.getPackages();
    }
    return this.mClassLoader.getPackages();
  }
  
  public URL getResource(String paramString)
  {
    if (useSelfClassloader()) {
      return super.getResource(paramString);
    }
    return this.mClassLoader.getResource(paramString);
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    if (useSelfClassloader()) {
      return getResourceAsStream(paramString);
    }
    return this.mClassLoader.getResourceAsStream(paramString);
  }
  
  public Enumeration<URL> getResources(String paramString)
    throws IOException
  {
    if (useSelfClassloader()) {
      return super.getResources(paramString);
    }
    return this.mClassLoader.getResources(paramString);
  }
  
  public Class<?> loadClass(String paramString)
    throws ClassNotFoundException
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString);
    }
    return this.mClassLoader.loadClass(paramString);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if (useSelfClassloader()) {
      return super.loadClass(paramString, paramBoolean);
    }
    return this.mClassLoader.loadClass(paramString, paramBoolean);
  }
  
  public void setClassAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setClassAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setClassAssertionStatus(paramString, paramBoolean);
  }
  
  public void setDefaultAssertionStatus(boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setDefaultAssertionStatus(paramBoolean);
      return;
    }
    this.mClassLoader.setDefaultAssertionStatus(paramBoolean);
  }
  
  public void setPackageAssertionStatus(String paramString, boolean paramBoolean)
  {
    if (useSelfClassloader())
    {
      super.setPackageAssertionStatus(paramString, paramBoolean);
      return;
    }
    this.mClassLoader.setPackageAssertionStatus(paramString, paramBoolean);
  }
  
  public String toString()
  {
    if (useSelfClassloader()) {
      return super.toString();
    }
    return this.mClassLoader.toString();
  }
  
  private static class SpeedyDexClassLoader
    extends BaseDexClassLoader
  {
    public SpeedyDexClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
    {
      super(null, paramString2, paramClassLoader);
    }
    
    public Package definePackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, URL paramURL)
      throws IllegalArgumentException
    {
      return super.definePackage(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramURL);
    }
    
    public Class<?> findClass(String paramString)
      throws ClassNotFoundException
    {
      return super.findClass(paramString);
    }
    
    public URL findResource(String paramString)
    {
      return super.findResource(paramString);
    }
    
    public Enumeration<URL> findResources(String paramString)
    {
      return super.findResources(paramString);
    }
    
    public Package getPackage(String paramString)
    {
      try
      {
        paramString = super.getPackage(paramString);
        return paramString;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public Package[] getPackages()
    {
      return super.getPackages();
    }
    
    public Class<?> loadClass(String paramString, boolean paramBoolean)
      throws ClassNotFoundException
    {
      return super.loadClass(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider
 * JD-Core Version:    0.7.0.1
 */