package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

class APPluginContext
  extends ContextThemeWrapper
{
  private AssetManager mAsset;
  private ClassLoader mClassLoader;
  private Resources mResources;
  private Resources.Theme mTheme;
  private int mThemeResId;
  
  public APPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader)
  {
    this(paramContext, paramInt, paramString, paramClassLoader, null);
  }
  
  public APPluginContext(Context paramContext, int paramInt, String paramString, ClassLoader paramClassLoader, Resources paramResources)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(217514);
    this.mAsset = null;
    this.mResources = null;
    this.mTheme = null;
    this.mClassLoader = paramClassLoader;
    APLog.i("APPluginContext", "APPluginContext mClassLoader:" + this.mClassLoader + " apkPath:" + paramString);
    if (paramResources != null)
    {
      this.mAsset = paramResources.getAssets();
      APLog.i("APPluginContext", "APPluginActivity APPluginContext 1 mAsset:" + this.mAsset);
      this.mResources = paramResources;
    }
    for (;;)
    {
      this.mTheme = getSelfTheme(paramContext, this.mResources);
      AppMethodBeat.o(217514);
      return;
      this.mAsset = getSelfAssets(paramContext, paramString);
      this.mResources = getSelfRes(paramContext, this.mAsset);
      APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
    }
  }
  
  private static String getApplicationPackageName(Context paramContext)
  {
    AppMethodBeat.i(217568);
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {}
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      str1 = str2;
      if (localPackageManager != null) {
        str1 = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).packageName;
      }
      AppMethodBeat.o(217568);
      return str1;
    }
    catch (Exception paramContext)
    {
      APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + paramContext.toString());
      AppMethodBeat.o(217568);
    }
    return "";
  }
  
  private int getInnerRIdValue(String paramString)
  {
    AppMethodBeat.i(217558);
    int j = -1;
    int i = j;
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = j;
      int k = paramString.lastIndexOf(".");
      i = j;
      String str1 = paramString.substring(k + 1, paramString.length());
      i = j;
      paramString = paramString.substring(0, k);
      i = j;
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      i = j;
      str2 = str2 + "$" + str3;
      i = j;
      j = Class.forName(str2).getDeclaredField(str1).getInt(null);
      i = j;
      APLog.i("APPluginContext", "getInnderR rStrnig:" + paramString + ", className:" + str2 + ", fieldName:" + str1);
      i = j;
    }
    finally
    {
      label171:
      break label171;
    }
    AppMethodBeat.o(217558);
    return i;
  }
  
  private AssetManager getSelfAssets(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217531);
    for (;;)
    {
      try
      {
        localAssetManager = (AssetManager)AssetManager.class.newInstance();
      }
      finally
      {
        AssetManager localAssetManager;
        int i;
        boolean bool;
        label72:
        ArrayList localArrayList;
        String str;
        i += 1;
        continue;
        j = 0;
        continue;
      }
      try
      {
        Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new Class[0]);
        i = 1;
      }
      catch (Exception localException1)
      {
        APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + localException1.toString());
        i = 0;
        continue;
        try
        {
          paramString = paramContext.getApplicationInfo().sharedLibraryFiles;
          j = paramString.length;
          i = 0;
          paramContext = localAssetManager;
          if (i < j)
          {
            paramContext = paramString[i];
            if (paramContext.endsWith(".apk")) {
              AssetManager.class.getDeclaredMethod("addAssetPathAsSharedLibrary", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramContext });
            }
            i += 1;
            continue;
            paramContext = finally;
            paramContext = null;
          }
        }
        catch (Exception paramContext)
        {
          paramContext = localAssetManager;
          continue;
        }
        AppMethodBeat.o(217531);
        return paramContext;
      }
      finally
      {
        paramContext = localAssetManager;
        continue;
      }
    }
    if (i == 0) {
      try
      {
        Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
        i = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + localException2.toString());
          i = 0;
        }
        AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      }
    }
    try
    {
      bool = "com.tencent.weread".equals(getApplicationPackageName(paramContext));
      if (!bool) {
        break label414;
      }
      j = 1;
    }
    catch (Exception localException3)
    {
      j = 0;
      break label72;
    }
    if ((i != 0) || (j != 0))
    {
      localArrayList = APPluginUtils.getMidasEmptyPaht(paramContext);
      APLog.i("APPluginContext", "loadEmptyResAPK emptyList.size:" + localArrayList.size());
      i = 0;
      if (i < localArrayList.size())
      {
        str = (String)localArrayList.get(i);
        APLog.i("APPluginContext", "loadEmptyResAPK emptyResFirstPath:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
          break label407;
        }
        APLog.i("APPluginContext", "loadEmptyResAPK id:".concat(String.valueOf(((Integer)AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { str })).intValue())));
        break label407;
      }
    }
  }
  
  private Resources getSelfRes(Context paramContext, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(217541);
    paramContext = new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
    AppMethodBeat.o(217541);
    return paramContext;
  }
  
  private Resources.Theme getSelfTheme(Context paramContext, Resources paramResources)
  {
    AppMethodBeat.i(217547);
    paramResources = paramResources.newTheme();
    this.mThemeResId = getThemeId(paramContext);
    paramResources.applyStyle(this.mThemeResId, true);
    AppMethodBeat.o(217547);
    return paramResources;
  }
  
  private static int getThemeId(Context paramContext)
  {
    AppMethodBeat.i(217576);
    try
    {
      Method localMethod = ContextThemeWrapper.class.getMethod("getThemeResId", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      AppMethodBeat.o(217576);
      return i;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(217576);
    }
    return -1;
  }
  
  public AssetManager getAssets()
  {
    return this.mAsset;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(217606);
    if (this.mClassLoader != null)
    {
      localClassLoader = this.mClassLoader;
      AppMethodBeat.o(217606);
      return localClassLoader;
    }
    ClassLoader localClassLoader = super.getClassLoader();
    AppMethodBeat.o(217606);
    return localClassLoader;
  }
  
  public Resources getRes()
  {
    return this.mResources;
  }
  
  public Resources getResources()
  {
    return this.mResources;
  }
  
  public Resources.Theme getTheme()
  {
    return this.mTheme;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginContext
 * JD-Core Version:    0.7.0.1
 */