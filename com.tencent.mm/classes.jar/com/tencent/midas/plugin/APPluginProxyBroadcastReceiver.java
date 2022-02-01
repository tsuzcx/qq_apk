package com.tencent.midas.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;

public class APPluginProxyBroadcastReceiver
  extends BroadcastReceiver
{
  public static void sendBroadcastReceiver(Context paramContext, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(252642);
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_launchReceiver", paramString2);
    try
    {
      paramContext.sendBroadcast(paramIntent);
      AppMethodBeat.o(252642);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(252642);
    }
  }
  
  /* Error */
  private IAPPluginBroadcastReceiver startPluginIfNeccessary(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 46
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnonnull +10 -> 19
    //   12: ldc 46
    //   14: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_2
    //   20: ldc 22
    //   22: invokevirtual 50	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 5
    //   27: aload_2
    //   28: ldc 30
    //   30: invokevirtual 50	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 6
    //   35: aconst_null
    //   36: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +174 -> 213
    //   42: aload_1
    //   43: aload 5
    //   45: invokestatic 62	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   48: invokevirtual 68	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   51: astore_3
    //   52: ldc 70
    //   54: new 72	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 74
    //   60: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 5
    //   65: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 83
    //   70: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 6
    //   75: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 91	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 4
    //   86: astore_2
    //   87: aload 5
    //   89: ifnull +116 -> 205
    //   92: aload 4
    //   94: astore_2
    //   95: aload 5
    //   97: invokevirtual 97	java/lang/String:length	()I
    //   100: ifle +105 -> 205
    //   103: new 64	java/io/File
    //   106: dup
    //   107: aload_3
    //   108: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: astore 7
    //   113: aload 4
    //   115: astore_2
    //   116: aload 7
    //   118: invokevirtual 102	java/io/File:exists	()Z
    //   121: ifeq +84 -> 205
    //   124: aload 4
    //   126: astore_2
    //   127: aload 7
    //   129: invokevirtual 105	java/io/File:isFile	()Z
    //   132: ifeq +73 -> 205
    //   135: getstatic 111	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: aload_3
    //   139: invokevirtual 117	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 119	android/content/pm/PackageInfo
    //   145: astore_2
    //   146: aload_2
    //   147: ifnonnull +84 -> 231
    //   150: aload_1
    //   151: aload_3
    //   152: iconst_1
    //   153: invokestatic 125	com/tencent/midas/plugin/APApkFileParser:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   156: astore_2
    //   157: getstatic 111	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   160: aload_3
    //   161: aload_2
    //   162: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_1
    //   167: aload 5
    //   169: aload_3
    //   170: invokestatic 135	com/tencent/midas/plugin/APPluginLoader:getOrCreateClassLoaderByPath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ldalvik/system/DexClassLoader;
    //   173: astore 7
    //   175: aload 7
    //   177: aload 6
    //   179: invokevirtual 141	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   182: invokevirtual 147	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   185: checkcast 149	com/tencent/midas/plugin/IAPPluginBroadcastReceiver
    //   188: astore_1
    //   189: aload_1
    //   190: aload 5
    //   192: aload_3
    //   193: aload_0
    //   194: aload 7
    //   196: aload_2
    //   197: iconst_0
    //   198: invokeinterface 153 7 0
    //   203: aload_1
    //   204: astore_2
    //   205: ldc 46
    //   207: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_2
    //   211: areturn
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -163 -> 52
    //   218: astore_1
    //   219: aload 4
    //   221: astore_2
    //   222: goto -17 -> 205
    //   225: astore_2
    //   226: aload_1
    //   227: astore_2
    //   228: goto -23 -> 205
    //   231: goto -65 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	APPluginProxyBroadcastReceiver
    //   0	234	1	paramContext	Context
    //   0	234	2	paramIntent	Intent
    //   51	164	3	str1	String
    //   1	219	4	localObject1	java.lang.Object
    //   25	166	5	str2	String
    //   33	145	6	str3	String
    //   111	84	7	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   42	52	212	java/io/IOException
    //   166	189	218	java/lang/Exception
    //   189	203	225	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(252644);
    IAPPluginBroadcastReceiver localIAPPluginBroadcastReceiver = startPluginIfNeccessary(paramContext, paramIntent);
    APLog.i("APPLuginProxyBroadcastReciver", "onReceive startPluginIfNeccessary: ".concat(String.valueOf(localIAPPluginBroadcastReceiver)));
    if (localIAPPluginBroadcastReceiver != null) {
      localIAPPluginBroadcastReceiver.IOnReceive(paramContext, paramIntent);
    }
    AppMethodBeat.o(252644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */