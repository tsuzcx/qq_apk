package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Field;

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
    AppMethodBeat.i(252657);
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
      this.mTheme = getSelfTheme(this.mResources);
      AppMethodBeat.o(252657);
      return;
      this.mAsset = getSelfAssets(paramContext, paramString);
      this.mResources = getSelfRes(paramContext, this.mAsset);
      APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
    }
  }
  
  private static String getApplicationPackageName(Context paramContext)
  {
    AppMethodBeat.i(252679);
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
      AppMethodBeat.o(252679);
      return str1;
    }
    catch (Exception paramContext)
    {
      APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + paramContext.toString());
      AppMethodBeat.o(252679);
    }
    return "";
  }
  
  private int getInnerRIdValue(String paramString)
  {
    AppMethodBeat.i(252671);
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
    catch (Throwable paramString)
    {
      label171:
      break label171;
    }
    AppMethodBeat.o(252671);
    return i;
  }
  
  /* Error */
  private AssetManager getSelfAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 178
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 180
    //   7: invokevirtual 184	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: checkcast 180	android/content/res/AssetManager
    //   13: astore 6
    //   15: ldc 186
    //   17: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: ldc 188
    //   22: iconst_0
    //   23: anewarray 157	java/lang/Class
    //   26: invokevirtual 192	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   29: pop
    //   30: iconst_1
    //   31: istore_3
    //   32: iload_3
    //   33: ifne +371 -> 404
    //   36: ldc 194
    //   38: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   41: ldc 188
    //   43: iconst_0
    //   44: anewarray 157	java/lang/Class
    //   47: invokevirtual 192	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   50: pop
    //   51: iconst_1
    //   52: istore_3
    //   53: ldc 196
    //   55: aload_1
    //   56: invokestatic 198	com/tencent/midas/plugin/APPluginContext:getApplicationPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   59: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: istore 5
    //   64: iload 5
    //   66: ifeq +348 -> 414
    //   69: iconst_1
    //   70: istore 4
    //   72: iload_3
    //   73: ifne +8 -> 81
    //   76: iload 4
    //   78: ifeq +197 -> 275
    //   81: aload_1
    //   82: invokestatic 208	com/tencent/midas/plugin/APPluginUtils:getMidasEmptyPaht	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   85: astore 7
    //   87: ldc 40
    //   89: new 42	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 210
    //   95: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload 7
    //   100: invokevirtual 215	java/util/ArrayList:size	()I
    //   103: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 65	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: iconst_0
    //   113: istore_3
    //   114: iload_3
    //   115: aload 7
    //   117: invokevirtual 215	java/util/ArrayList:size	()I
    //   120: if_icmpge +155 -> 275
    //   123: aload 7
    //   125: iload_3
    //   126: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   129: checkcast 134	java/lang/String
    //   132: astore 8
    //   134: ldc 40
    //   136: ldc 224
    //   138: aload 8
    //   140: invokestatic 228	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   143: invokevirtual 232	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokestatic 65	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload 8
    //   151: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +253 -> 407
    //   157: ldc 40
    //   159: ldc 240
    //   161: ldc 180
    //   163: ldc 242
    //   165: iconst_1
    //   166: anewarray 157	java/lang/Class
    //   169: dup
    //   170: iconst_0
    //   171: ldc 134
    //   173: aastore
    //   174: invokevirtual 245	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   177: aload 6
    //   179: iconst_1
    //   180: anewarray 247	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 8
    //   187: aastore
    //   188: invokevirtual 253	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast 255	java/lang/Integer
    //   194: invokevirtual 258	java/lang/Integer:intValue	()I
    //   197: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   200: invokevirtual 232	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 65	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: goto +201 -> 407
    //   209: astore 7
    //   211: ldc 40
    //   213: new 42	java/lang/StringBuilder
    //   216: dup
    //   217: ldc_w 263
    //   220: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload 7
    //   225: invokevirtual 125	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 266	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_0
    //   238: istore_3
    //   239: goto -207 -> 32
    //   242: astore 7
    //   244: ldc 40
    //   246: new 42	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 268
    //   253: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 7
    //   258: invokevirtual 125	java/lang/Exception:toString	()Ljava/lang/String;
    //   261: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 266	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_0
    //   271: istore_3
    //   272: goto -219 -> 53
    //   275: ldc 180
    //   277: ldc 242
    //   279: iconst_1
    //   280: anewarray 157	java/lang/Class
    //   283: dup
    //   284: iconst_0
    //   285: ldc 134
    //   287: aastore
    //   288: invokevirtual 245	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: aload 6
    //   293: iconst_1
    //   294: anewarray 247	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_2
    //   300: aastore
    //   301: invokevirtual 253	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: aload_1
    //   306: invokevirtual 272	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   309: getfield 278	android/content/pm/ApplicationInfo:sharedLibraryFiles	[Ljava/lang/String;
    //   312: astore_2
    //   313: aload_2
    //   314: arraylength
    //   315: istore 4
    //   317: iconst_0
    //   318: istore_3
    //   319: aload 6
    //   321: astore_1
    //   322: iload_3
    //   323: iload 4
    //   325: if_icmpge +58 -> 383
    //   328: aload_2
    //   329: iload_3
    //   330: aaload
    //   331: astore_1
    //   332: aload_1
    //   333: ldc_w 280
    //   336: invokevirtual 284	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   339: ifeq +34 -> 373
    //   342: ldc 180
    //   344: ldc_w 286
    //   347: iconst_1
    //   348: anewarray 157	java/lang/Class
    //   351: dup
    //   352: iconst_0
    //   353: ldc 134
    //   355: aastore
    //   356: invokevirtual 245	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   359: aload 6
    //   361: iconst_1
    //   362: anewarray 247	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: aload_1
    //   368: aastore
    //   369: invokevirtual 253	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: iload_3
    //   374: iconst_1
    //   375: iadd
    //   376: istore_3
    //   377: goto -58 -> 319
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_1
    //   383: ldc 178
    //   385: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aload_1
    //   389: areturn
    //   390: astore_1
    //   391: aload 6
    //   393: astore_1
    //   394: goto -11 -> 383
    //   397: astore_1
    //   398: aload 6
    //   400: astore_1
    //   401: goto -18 -> 383
    //   404: goto -351 -> 53
    //   407: iload_3
    //   408: iconst_1
    //   409: iadd
    //   410: istore_3
    //   411: goto -297 -> 114
    //   414: iconst_0
    //   415: istore 4
    //   417: goto -345 -> 72
    //   420: astore 7
    //   422: iconst_0
    //   423: istore 4
    //   425: goto -353 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	APPluginContext
    //   0	428	1	paramContext	Context
    //   0	428	2	paramString	String
    //   31	380	3	i	int
    //   70	354	4	j	int
    //   62	3	5	bool	boolean
    //   13	386	6	localAssetManager	AssetManager
    //   85	39	7	localArrayList	java.util.ArrayList
    //   209	15	7	localException1	Exception
    //   242	15	7	localException2	Exception
    //   420	1	7	localException3	Exception
    //   132	54	8	str	String
    // Exception table:
    //   from	to	target	type
    //   15	30	209	java/lang/Exception
    //   36	51	242	java/lang/Exception
    //   5	15	380	java/lang/Throwable
    //   15	30	390	java/lang/Throwable
    //   36	51	390	java/lang/Throwable
    //   53	64	390	java/lang/Throwable
    //   81	112	390	java/lang/Throwable
    //   114	206	390	java/lang/Throwable
    //   211	237	390	java/lang/Throwable
    //   244	270	390	java/lang/Throwable
    //   275	305	390	java/lang/Throwable
    //   305	317	390	java/lang/Throwable
    //   332	373	390	java/lang/Throwable
    //   305	317	397	java/lang/Exception
    //   332	373	397	java/lang/Exception
    //   53	64	420	java/lang/Exception
  }
  
  private Resources getSelfRes(Context paramContext, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(252664);
    paramContext = new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
    AppMethodBeat.o(252664);
    return paramContext;
  }
  
  private Resources.Theme getSelfTheme(Resources paramResources)
  {
    AppMethodBeat.i(252667);
    paramResources = paramResources.newTheme();
    this.mThemeResId = getInnerRIdValue("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.mThemeResId, true);
    AppMethodBeat.o(252667);
    return paramResources;
  }
  
  public AssetManager getAssets()
  {
    return this.mAsset;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(252677);
    if (this.mClassLoader != null)
    {
      localClassLoader = this.mClassLoader;
      AppMethodBeat.o(252677);
      return localClassLoader;
    }
    ClassLoader localClassLoader = super.getClassLoader();
    AppMethodBeat.o(252677);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginContext
 * JD-Core Version:    0.7.0.1
 */