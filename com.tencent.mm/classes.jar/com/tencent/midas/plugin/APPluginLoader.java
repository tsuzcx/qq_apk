package com.tencent.midas.plugin;

import android.content.Context;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginReportManager;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;

public class APPluginLoader
{
  private static DexClassLoader parentClassLoader;
  private static final HashMap<String, DexClassLoader> sClassLoaderMap;
  
  static
  {
    AppMethodBeat.i(193029);
    sClassLoaderMap = new HashMap();
    parentClassLoader = null;
    AppMethodBeat.o(193029);
  }
  
  public static ClassLoader getClassLoader(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(193024);
      paramString1 = (ClassLoader)sClassLoaderMap.get(paramString1 + "_" + paramString2);
      AppMethodBeat.o(193024);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
  {
    try
    {
      AppMethodBeat.i(193025);
      paramContext = getOrCreateClassLoaderByPath(paramContext, paramString, APPluginInstallerAndUpdater.getInstallPath(paramContext, paramString).getCanonicalPath());
      APLog.d("APPluginStatic", "getClassLoader getOrCreateClassLoader midasClassLoader: " + paramContext.hashCode());
      AppMethodBeat.o(193025);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static DexClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193027);
        String str2 = APPluginUtils.getMD5FromPath(paramString2);
        String str1 = paramString1 + "_" + str2;
        paramString1 = (DexClassLoader)sClassLoaderMap.get(str1);
        APLog.d("APPluginStatic", "getOrCreateClassLoader apkFilePath: " + paramString2 + ", MD5: " + str2 + ", key: " + str1 + ", dexClassLoader: " + paramString1);
        if (paramString1 != null)
        {
          AppMethodBeat.o(193027);
          paramContext = paramString1;
          return paramContext;
        }
        paramString1 = APPluginConfig.getOptimizedDexPath(paramContext).getCanonicalPath();
        long l = System.currentTimeMillis();
        APPluginUtils.extractLibs(paramString2, APPluginConfig.getLibPath(paramContext).getCanonicalPath());
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.unzip.so.time", l);
        str2 = APPluginConfig.getLibPath(paramContext).getCanonicalPath();
        if (parentClassLoader != null)
        {
          paramContext = new DexClassLoader(paramString2, paramString1, str2, parentClassLoader);
          APLog.d("APPluginStatic", "getOrCreateClassLoader new DexClassLoader cache: " + paramString1 + " libDir: " + str2);
          sClassLoaderMap.put(str1, paramContext);
          AppMethodBeat.o(193027);
        }
        else
        {
          paramContext = new DexClassLoader(paramString2, paramString1, str2, paramContext.getClassLoader());
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void preCreateClassLoaderByPath(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 174
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 176
    //   10: astore 4
    //   12: ldc 176
    //   14: astore 5
    //   16: aload_0
    //   17: invokestatic 179	com/tencent/midas/plugin/APPluginConfig:getPluginPath	(Landroid/content/Context;)Ljava/io/File;
    //   20: astore 6
    //   22: aload 5
    //   24: astore_3
    //   25: aload 4
    //   27: astore_2
    //   28: aload 6
    //   30: ifnull +50 -> 80
    //   33: aload 6
    //   35: invokevirtual 183	java/io/File:listFiles	()[Ljava/io/File;
    //   38: astore 6
    //   40: iconst_0
    //   41: istore_1
    //   42: aload 5
    //   44: astore_3
    //   45: aload 4
    //   47: astore_2
    //   48: iload_1
    //   49: aload 6
    //   51: arraylength
    //   52: if_icmpge +28 -> 80
    //   55: aload 6
    //   57: iload_1
    //   58: aaload
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 186	java/io/File:getName	()Ljava/lang/String;
    //   64: ldc 188
    //   66: invokevirtual 194	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: ifeq +41 -> 110
    //   72: ldc 188
    //   74: astore_2
    //   75: aload_3
    //   76: invokevirtual 68	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   79: astore_3
    //   80: aload_2
    //   81: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +17 -> 101
    //   87: aload_3
    //   88: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +10 -> 101
    //   94: aload_0
    //   95: aload_2
    //   96: aload_3
    //   97: invokestatic 72	com/tencent/midas/plugin/APPluginLoader:getOrCreateClassLoaderByPath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ldalvik/system/DexClassLoader;
    //   100: pop
    //   101: ldc 174
    //   103: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: ldc 2
    //   108: monitorexit
    //   109: return
    //   110: iload_1
    //   111: iconst_1
    //   112: iadd
    //   113: istore_1
    //   114: goto -72 -> 42
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   41	73	1	i	int
    //   27	69	2	str1	String
    //   24	73	3	str2	String
    //   10	36	4	str3	String
    //   14	29	5	str4	String
    //   20	36	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	117	finally
    //   16	22	117	finally
    //   33	40	117	finally
    //   48	55	117	finally
    //   60	72	117	finally
    //   75	80	117	finally
    //   80	101	117	finally
    //   101	106	117	finally
  }
  
  static void release()
  {
    AppMethodBeat.i(193026);
    sClassLoaderMap.clear();
    AppMethodBeat.o(193026);
  }
  
  public static void setParentClassLoader(DexClassLoader paramDexClassLoader)
  {
    parentClassLoader = paramDexClassLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginLoader
 * JD-Core Version:    0.7.0.1
 */