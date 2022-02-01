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
    AppMethodBeat.i(193039);
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
      AppMethodBeat.o(193039);
      return;
      this.mAsset = getSelfAssets(paramContext, paramString);
      this.mResources = getSelfRes(paramContext, this.mAsset);
      APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
    }
  }
  
  private static String getApplicationPackageName(Context paramContext)
  {
    AppMethodBeat.i(193045);
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
      AppMethodBeat.o(193045);
      return str1;
    }
    catch (Exception paramContext)
    {
      APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + paramContext.toString());
      AppMethodBeat.o(193045);
    }
    return "";
  }
  
  private int getInnerRIdValue(String paramString)
  {
    AppMethodBeat.i(193043);
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
    AppMethodBeat.o(193043);
    return i;
  }
  
  /* Error */
  private AssetManager getSelfAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: ldc 178
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 180
    //   10: invokevirtual 184	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   13: checkcast 180	android/content/res/AssetManager
    //   16: astore 7
    //   18: ldc 186
    //   20: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   23: ldc 188
    //   25: iconst_0
    //   26: anewarray 157	java/lang/Class
    //   29: invokevirtual 192	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: pop
    //   33: iconst_1
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +292 -> 328
    //   39: ldc 194
    //   41: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   44: ldc 188
    //   46: iconst_0
    //   47: anewarray 157	java/lang/Class
    //   50: invokevirtual 192	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: pop
    //   54: iconst_1
    //   55: istore_3
    //   56: ldc 196
    //   58: aload_1
    //   59: invokestatic 198	com/tencent/midas/plugin/APPluginContext:getApplicationPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   62: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: istore 6
    //   67: iload 6
    //   69: ifeq +269 -> 338
    //   72: iconst_1
    //   73: istore 4
    //   75: iload_3
    //   76: ifne +8 -> 84
    //   79: iload 4
    //   81: ifeq +194 -> 275
    //   84: aload_1
    //   85: invokestatic 208	com/tencent/midas/plugin/APPluginUtils:getMidasEmptyPaht	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   88: astore_1
    //   89: ldc 40
    //   91: new 42	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 210
    //   97: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 215	java/util/ArrayList:size	()I
    //   104: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 65	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: iload 5
    //   115: istore_3
    //   116: iload_3
    //   117: aload_1
    //   118: invokevirtual 215	java/util/ArrayList:size	()I
    //   121: if_icmpge +154 -> 275
    //   124: aload_1
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
    //   154: ifne +177 -> 331
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
    //   177: aload 7
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
    //   206: goto +125 -> 331
    //   209: astore 8
    //   211: ldc 40
    //   213: new 42	java/lang/StringBuilder
    //   216: dup
    //   217: ldc_w 263
    //   220: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload 8
    //   225: invokevirtual 125	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 266	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_0
    //   238: istore_3
    //   239: goto -204 -> 35
    //   242: astore 8
    //   244: ldc 40
    //   246: new 42	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 268
    //   253: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 8
    //   258: invokevirtual 125	java/lang/Exception:toString	()Ljava/lang/String;
    //   261: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 266	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_0
    //   271: istore_3
    //   272: goto -216 -> 56
    //   275: ldc 180
    //   277: ldc 242
    //   279: iconst_1
    //   280: anewarray 157	java/lang/Class
    //   283: dup
    //   284: iconst_0
    //   285: ldc 134
    //   287: aastore
    //   288: invokevirtual 245	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: aload 7
    //   293: iconst_1
    //   294: anewarray 247	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_2
    //   300: aastore
    //   301: invokevirtual 253	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   304: pop
    //   305: aload 7
    //   307: astore_1
    //   308: ldc 178
    //   310: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aload_1
    //   314: areturn
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_1
    //   318: goto -10 -> 308
    //   321: astore_1
    //   322: aload 7
    //   324: astore_1
    //   325: goto -17 -> 308
    //   328: goto -272 -> 56
    //   331: iload_3
    //   332: iconst_1
    //   333: iadd
    //   334: istore_3
    //   335: goto -219 -> 116
    //   338: iconst_0
    //   339: istore 4
    //   341: goto -266 -> 75
    //   344: astore 8
    //   346: iconst_0
    //   347: istore 4
    //   349: goto -274 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	APPluginContext
    //   0	352	1	paramContext	Context
    //   0	352	2	paramString	String
    //   34	301	3	i	int
    //   73	275	4	j	int
    //   1	113	5	k	int
    //   65	3	6	bool	boolean
    //   16	307	7	localAssetManager	AssetManager
    //   132	54	8	str	String
    //   209	15	8	localException1	Exception
    //   242	15	8	localException2	Exception
    //   344	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   18	33	209	java/lang/Exception
    //   39	54	242	java/lang/Exception
    //   8	18	315	java/lang/Throwable
    //   18	33	321	java/lang/Throwable
    //   39	54	321	java/lang/Throwable
    //   56	67	321	java/lang/Throwable
    //   84	113	321	java/lang/Throwable
    //   116	206	321	java/lang/Throwable
    //   211	237	321	java/lang/Throwable
    //   244	270	321	java/lang/Throwable
    //   275	305	321	java/lang/Throwable
    //   56	67	344	java/lang/Exception
  }
  
  private Resources getSelfRes(Context paramContext, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(193041);
    paramContext = new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
    AppMethodBeat.o(193041);
    return paramContext;
  }
  
  private Resources.Theme getSelfTheme(Resources paramResources)
  {
    AppMethodBeat.i(193042);
    paramResources = paramResources.newTheme();
    this.mThemeResId = getInnerRIdValue("com.android.internal.R.style.Theme");
    paramResources.applyStyle(this.mThemeResId, true);
    AppMethodBeat.o(193042);
    return paramResources;
  }
  
  public AssetManager getAssets()
  {
    return this.mAsset;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(193044);
    if (this.mClassLoader != null)
    {
      localClassLoader = this.mClassLoader;
      AppMethodBeat.o(193044);
      return localClassLoader;
    }
    ClassLoader localClassLoader = super.getClassLoader();
    AppMethodBeat.o(193044);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginContext
 * JD-Core Version:    0.7.0.1
 */