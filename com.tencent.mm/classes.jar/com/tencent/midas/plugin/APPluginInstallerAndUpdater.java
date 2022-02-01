package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class APPluginInstallerAndUpdater
{
  private static final int BUFFER_LENGTH = 8192;
  private static final int INSTALL_ERR_LOSTZIPFILE = -2;
  private static final int INSTALL_ERR_MD5CHECKFAIL = -3;
  static final int INSTALL_ERR_SYSTEM = -1;
  static final int INSTALL_FROM_ASSETS = 1;
  static final int INSTALL_FROM_LOCAL = 2;
  private static final int INSTALL_SUCC = 0;
  private static final String TAG = "APPluginInstallerAndUpdater";
  static Map<String, File> sInstallPathMap;
  static Map<String, PackageInfo> sPackageInfoMap;
  
  static
  {
    AppMethodBeat.i(217624);
    sInstallPathMap = new ConcurrentHashMap();
    sPackageInfoMap = new ConcurrentHashMap();
    AppMethodBeat.o(217624);
  }
  
  public static File getInstallPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217552);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(217552);
      return null;
    }
    File localFile = (File)sInstallPathMap.get(paramString);
    if (localFile == null)
    {
      paramContext = APPluginConfig.getPluginPath(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(217552);
        return null;
      }
      paramContext = paramContext.listFiles();
      int i = 0;
      while (i < paramContext.length)
      {
        Object localObject = paramContext[i];
        if (localObject.getName().startsWith(paramString))
        {
          sInstallPathMap.put(paramString, localObject);
          AppMethodBeat.o(217552);
          return localObject;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(217552);
    return localFile;
  }
  
  public static String getInstallPathString(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217504);
    str = "";
    try
    {
      paramString = getInstallPath(paramContext, paramString);
      paramContext = str;
      if (paramString != null) {
        paramContext = paramString.getCanonicalPath();
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
    AppMethodBeat.o(217504);
    return paramContext;
  }
  
  /* Error */
  private static int installFromAssets(Context paramContext)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 113	com/tencent/midas/plugin/APPluginUtils:copyEmtpyResAPKFromAssets	(Landroid/content/Context;)V
    //   9: ldc 115
    //   11: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +11 -> 25
    //   17: ldc 107
    //   19: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: bipush 254
    //   24: ireturn
    //   25: aconst_null
    //   26: astore_2
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 121	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   33: ldc 115
    //   35: invokevirtual 127	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: astore_2
    //   43: aload_0
    //   44: aload_3
    //   45: invokestatic 131	com/tencent/midas/plugin/APPluginInstallerAndUpdater:installFromZipStream	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   48: pop
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 136	java/io/InputStream:close	()V
    //   57: ldc 107
    //   59: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_0
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 136	java/io/InputStream:close	()V
    //   73: ldc 107
    //   75: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_m1
    //   79: ireturn
    //   80: astore_0
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 136	java/io/InputStream:close	()V
    //   89: ldc 107
    //   91: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: goto -40 -> 57
    //   100: astore_0
    //   101: goto -28 -> 73
    //   104: astore_1
    //   105: goto -16 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramContext	Context
    //   28	42	1	localObject1	Object
    //   104	1	1	localIOException	IOException
    //   26	60	2	localObject2	Object
    //   38	16	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   29	39	64	java/io/IOException
    //   43	49	64	java/io/IOException
    //   29	39	80	finally
    //   43	49	80	finally
    //   53	57	96	java/io/IOException
    //   69	73	100	java/io/IOException
    //   85	89	104	java/io/IOException
  }
  
  /* Error */
  private static int installFromData(Context paramContext)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 113	com/tencent/midas/plugin/APPluginUtils:copyEmtpyResAPKFromAssets	(Landroid/content/Context;)V
    //   9: aload_0
    //   10: invokestatic 141	com/tencent/midas/plugin/APPluginUtils:getDataZipFile	(Landroid/content/Context;)Ljava/io/File;
    //   13: astore_1
    //   14: ldc 143
    //   16: ldc 145
    //   18: aload_1
    //   19: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: ifnonnull +11 -> 40
    //   32: ldc 138
    //   34: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: bipush 254
    //   39: ireturn
    //   40: ldc 143
    //   42: new 160	java/lang/StringBuilder
    //   45: dup
    //   46: ldc 162
    //   48: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 104	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   55: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 174	java/io/FileInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokestatic 131	com/tencent/midas/plugin/APPluginInstallerAndUpdater:installFromZipStream	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   78: pop
    //   79: aload_1
    //   80: invokevirtual 136	java/io/InputStream:close	()V
    //   83: ldc 138
    //   85: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 136	java/io/InputStream:close	()V
    //   101: ldc 138
    //   103: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_m1
    //   107: ireturn
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 136	java/io/InputStream:close	()V
    //   119: ldc 138
    //   121: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_0
    //   125: athrow
    //   126: astore_0
    //   127: goto -44 -> 83
    //   130: astore_0
    //   131: goto -30 -> 101
    //   134: astore_1
    //   135: goto -16 -> 119
    //   138: astore_0
    //   139: goto -28 -> 111
    //   142: astore_0
    //   143: goto -50 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   13	103	1	localObject	Object
    //   134	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   40	73	90	java/io/IOException
    //   40	73	108	finally
    //   79	83	126	java/io/IOException
    //   97	101	130	java/io/IOException
    //   115	119	134	java/io/IOException
    //   73	79	138	finally
    //   73	79	142	java/io/IOException
  }
  
  public static int installFromLocal(Context paramContext)
  {
    AppMethodBeat.i(217498);
    APLog.d("APPluginInstallerAndUpdater", "Calling into installFromLocal " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    APPluginUtils.deleteBKPlugin(paramContext);
    APPluginUtils.copyDirect(paramContext, APPluginConfig.getPluginUpdatePath(paramContext), APPluginConfig.getPluginBackUpPath(paramContext));
    try
    {
      File localFile = APPluginConfig.getPluginUpdatePath(paramContext);
      i = installFromLocalByPath(paramContext, localFile);
      APLog.d("APPluginInstallerAndUpdater", "Calling into installFromLocal, installFromLocalByPath result state = " + i + " install src = " + localFile);
      if (i != 0)
      {
        unInstallPlugin(paramContext);
        int j = installFromLocalByPath(paramContext, APPluginConfig.getPluginBackUpPath(paramContext));
        i = j;
        if (j != 0)
        {
          unInstallPlugin(paramContext);
          i = j;
        }
        APLog.i("APPluginUtils", "installFromLocal state:".concat(String.valueOf(i)));
        AppMethodBeat.o(217498);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
        continue;
        APPluginUtils.deleteUpdatePlugin(paramContext);
      }
    }
  }
  
  /* Error */
  private static int installFromLocalByPath(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: ldc 238
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 23
    //   11: ldc 240
    //   13: invokestatic 243	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 238
    //   18: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_m1
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 8
    //   32: aload_0
    //   33: invokestatic 74	com/tencent/midas/plugin/APPluginConfig:getPluginPath	(Landroid/content/Context;)Ljava/io/File;
    //   36: astore 11
    //   38: aload_1
    //   39: invokevirtual 78	java/io/File:listFiles	()[Ljava/io/File;
    //   42: astore 12
    //   44: iconst_0
    //   45: istore_2
    //   46: aload 12
    //   48: arraylength
    //   49: istore_3
    //   50: iload_2
    //   51: iload_3
    //   52: if_icmpge +579 -> 631
    //   55: aload 12
    //   57: iload_2
    //   58: aaload
    //   59: astore 10
    //   61: aload 10
    //   63: invokevirtual 82	java/io/File:getName	()Ljava/lang/String;
    //   66: astore 6
    //   68: ldc 143
    //   70: ldc 245
    //   72: aload 6
    //   74: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload 6
    //   85: ldc 247
    //   87: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   90: ifne +71 -> 161
    //   93: aload 6
    //   95: ldc 252
    //   97: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   100: istore 4
    //   102: iload 4
    //   104: ifne +57 -> 161
    //   107: aload 5
    //   109: ifnull +8 -> 117
    //   112: aload 5
    //   114: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   117: aload 7
    //   119: ifnull +8 -> 127
    //   122: aload 7
    //   124: invokevirtual 136	java/io/InputStream:close	()V
    //   127: aload 8
    //   129: ifnull +8 -> 137
    //   132: aload 8
    //   134: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   137: aload 5
    //   139: astore 6
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_2
    //   145: aload 6
    //   147: astore 5
    //   149: goto -103 -> 46
    //   152: astore 6
    //   154: aload 5
    //   156: astore 6
    //   158: goto -17 -> 141
    //   161: aload 6
    //   163: ldc_w 260
    //   166: invokevirtual 264	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   169: iconst_0
    //   170: aaload
    //   171: astore 9
    //   173: ldc 143
    //   175: ldc_w 266
    //   178: aload 9
    //   180: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   183: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   186: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 11
    //   191: ifnull +67 -> 258
    //   194: aload 11
    //   196: invokevirtual 78	java/io/File:listFiles	()[Ljava/io/File;
    //   199: astore 13
    //   201: iconst_0
    //   202: istore_3
    //   203: iload_3
    //   204: aload 13
    //   206: arraylength
    //   207: if_icmpge +51 -> 258
    //   210: aload 13
    //   212: iload_3
    //   213: aaload
    //   214: astore 14
    //   216: aload 14
    //   218: invokevirtual 82	java/io/File:getName	()Ljava/lang/String;
    //   221: astore 15
    //   223: ldc 143
    //   225: ldc_w 268
    //   228: aload 15
    //   230: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 15
    //   241: aload 9
    //   243: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   246: ifeq +477 -> 723
    //   249: aload 14
    //   251: invokevirtual 272	java/io/File:delete	()Z
    //   254: pop
    //   255: goto +468 -> 723
    //   258: new 68	java/io/File
    //   261: dup
    //   262: new 160	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   269: aload 11
    //   271: invokevirtual 104	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   274: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   280: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 6
    //   285: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   294: astore 9
    //   296: ldc 143
    //   298: ldc_w 279
    //   301: aload 6
    //   303: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   306: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   309: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: new 257	java/io/FileOutputStream
    //   315: dup
    //   316: aload 9
    //   318: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   321: astore 6
    //   323: new 254	java/io/BufferedOutputStream
    //   326: dup
    //   327: aload 6
    //   329: invokespecial 283	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   332: astore 9
    //   334: new 174	java/io/FileInputStream
    //   337: dup
    //   338: aload 10
    //   340: invokevirtual 104	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   343: invokespecial 284	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   346: astore 5
    //   348: sipush 8192
    //   351: newarray byte
    //   353: astore 7
    //   355: aload 5
    //   357: aload 7
    //   359: invokevirtual 288	java/io/InputStream:read	([B)I
    //   362: istore_3
    //   363: iload_3
    //   364: iconst_m1
    //   365: if_icmpeq +99 -> 464
    //   368: aload 9
    //   370: aload 7
    //   372: iconst_0
    //   373: iload_3
    //   374: invokevirtual 292	java/io/BufferedOutputStream:write	([BII)V
    //   377: goto -22 -> 355
    //   380: astore 7
    //   382: aload 5
    //   384: astore 10
    //   386: aload 6
    //   388: astore 5
    //   390: aload 9
    //   392: ifnull +8 -> 400
    //   395: aload 9
    //   397: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   400: aload 10
    //   402: ifnull +8 -> 410
    //   405: aload 10
    //   407: invokevirtual 136	java/io/InputStream:close	()V
    //   410: aload 5
    //   412: astore 8
    //   414: aload 10
    //   416: astore 7
    //   418: aload 9
    //   420: astore 6
    //   422: aload 5
    //   424: ifnull -283 -> 141
    //   427: aload 5
    //   429: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   432: aload 5
    //   434: astore 8
    //   436: aload 10
    //   438: astore 7
    //   440: aload 9
    //   442: astore 6
    //   444: goto -303 -> 141
    //   447: astore 6
    //   449: aload 5
    //   451: astore 8
    //   453: aload 10
    //   455: astore 7
    //   457: aload 9
    //   459: astore 6
    //   461: goto -320 -> 141
    //   464: aload 9
    //   466: invokevirtual 295	java/io/BufferedOutputStream:flush	()V
    //   469: aload 9
    //   471: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   474: aload 5
    //   476: invokevirtual 136	java/io/InputStream:close	()V
    //   479: aload 6
    //   481: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   484: aload 6
    //   486: astore 8
    //   488: aload 5
    //   490: astore 7
    //   492: aload 9
    //   494: astore 6
    //   496: goto -355 -> 141
    //   499: astore 7
    //   501: aload 6
    //   503: astore 8
    //   505: aload 5
    //   507: astore 7
    //   509: aload 9
    //   511: astore 6
    //   513: goto -372 -> 141
    //   516: astore 7
    //   518: aload 5
    //   520: astore 8
    //   522: aload 7
    //   524: astore 5
    //   526: aload 8
    //   528: astore 7
    //   530: aload 9
    //   532: ifnull +8 -> 540
    //   535: aload 9
    //   537: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   540: aload 7
    //   542: ifnull +8 -> 550
    //   545: aload 7
    //   547: invokevirtual 136	java/io/InputStream:close	()V
    //   550: aload 6
    //   552: ifnull +8 -> 560
    //   555: aload 6
    //   557: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   560: ldc 238
    //   562: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 5
    //   567: athrow
    //   568: astore 5
    //   570: aload 5
    //   572: invokestatic 299	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   575: putstatic 302	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   578: iconst_m1
    //   579: istore_2
    //   580: ldc 23
    //   582: new 160	java/lang/StringBuilder
    //   585: dup
    //   586: ldc_w 304
    //   589: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   592: iload_2
    //   593: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: ldc 223
    //   598: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_1
    //   602: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   605: ldc_w 306
    //   608: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 199	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: aload_0
    //   618: invokestatic 205	com/tencent/midas/plugin/APPluginConfig:getPluginUpdatePath	(Landroid/content/Context;)Ljava/io/File;
    //   621: invokestatic 309	com/tencent/midas/plugin/APPluginUtils:clearDirContent	(Ljava/io/File;)V
    //   624: ldc 238
    //   626: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: iload_2
    //   630: ireturn
    //   631: iconst_0
    //   632: istore_2
    //   633: goto -53 -> 580
    //   636: astore 6
    //   638: goto -78 -> 560
    //   641: astore 6
    //   643: aload 5
    //   645: astore 9
    //   647: aload 6
    //   649: astore 5
    //   651: aload 8
    //   653: astore 6
    //   655: goto -125 -> 530
    //   658: astore 8
    //   660: aload 5
    //   662: astore 9
    //   664: aload 8
    //   666: astore 5
    //   668: goto -138 -> 530
    //   671: astore 5
    //   673: goto -143 -> 530
    //   676: astore 6
    //   678: aload 5
    //   680: astore 9
    //   682: aload 8
    //   684: astore 5
    //   686: aload 7
    //   688: astore 10
    //   690: goto -300 -> 390
    //   693: astore 8
    //   695: aload 5
    //   697: astore 9
    //   699: aload 6
    //   701: astore 5
    //   703: aload 7
    //   705: astore 10
    //   707: goto -317 -> 390
    //   710: astore 5
    //   712: aload 6
    //   714: astore 5
    //   716: aload 7
    //   718: astore 10
    //   720: goto -330 -> 390
    //   723: iload_3
    //   724: iconst_1
    //   725: iadd
    //   726: istore_3
    //   727: goto -524 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	730	0	paramContext	Context
    //   0	730	1	paramFile	File
    //   45	588	2	i	int
    //   49	678	3	j	int
    //   100	3	4	bool	boolean
    //   24	542	5	localObject1	Object
    //   568	76	5	localException	Exception
    //   649	18	5	localObject2	Object
    //   671	8	5	localObject3	Object
    //   684	18	5	localObject4	Object
    //   710	1	5	localIOException1	IOException
    //   714	1	5	localObject5	Object
    //   66	80	6	localObject6	Object
    //   152	1	6	localIOException2	IOException
    //   156	287	6	localObject7	Object
    //   447	1	6	localIOException3	IOException
    //   459	97	6	localObject8	Object
    //   636	1	6	localIOException4	IOException
    //   641	7	6	localObject9	Object
    //   653	1	6	localObject10	Object
    //   676	37	6	localIOException5	IOException
    //   27	344	7	arrayOfByte	byte[]
    //   380	1	7	localIOException6	IOException
    //   416	75	7	localObject11	Object
    //   499	1	7	localIOException7	IOException
    //   507	1	7	localObject12	Object
    //   516	7	7	localObject13	Object
    //   528	189	7	localObject14	Object
    //   30	622	8	localObject15	Object
    //   658	25	8	localObject16	Object
    //   693	1	8	localIOException8	IOException
    //   171	527	9	localObject17	Object
    //   59	660	10	localObject18	Object
    //   36	234	11	localFile1	File
    //   42	14	12	arrayOfFile1	File[]
    //   199	12	13	arrayOfFile2	File[]
    //   214	36	14	localFile2	File
    //   221	19	15	str	String
    // Exception table:
    //   from	to	target	type
    //   112	117	152	java/io/IOException
    //   122	127	152	java/io/IOException
    //   132	137	152	java/io/IOException
    //   348	355	380	java/io/IOException
    //   355	363	380	java/io/IOException
    //   368	377	380	java/io/IOException
    //   464	469	380	java/io/IOException
    //   395	400	447	java/io/IOException
    //   405	410	447	java/io/IOException
    //   427	432	447	java/io/IOException
    //   469	484	499	java/io/IOException
    //   348	355	516	finally
    //   355	363	516	finally
    //   368	377	516	finally
    //   464	469	516	finally
    //   32	44	568	java/lang/Exception
    //   46	50	568	java/lang/Exception
    //   112	117	568	java/lang/Exception
    //   122	127	568	java/lang/Exception
    //   132	137	568	java/lang/Exception
    //   395	400	568	java/lang/Exception
    //   405	410	568	java/lang/Exception
    //   427	432	568	java/lang/Exception
    //   469	484	568	java/lang/Exception
    //   535	540	568	java/lang/Exception
    //   545	550	568	java/lang/Exception
    //   555	560	568	java/lang/Exception
    //   560	568	568	java/lang/Exception
    //   535	540	636	java/io/IOException
    //   545	550	636	java/io/IOException
    //   555	560	636	java/io/IOException
    //   61	102	641	finally
    //   161	189	641	finally
    //   194	201	641	finally
    //   203	210	641	finally
    //   216	255	641	finally
    //   258	323	641	finally
    //   323	334	658	finally
    //   334	348	671	finally
    //   61	102	676	java/io/IOException
    //   161	189	676	java/io/IOException
    //   194	201	676	java/io/IOException
    //   203	210	676	java/io/IOException
    //   216	255	676	java/io/IOException
    //   258	323	676	java/io/IOException
    //   323	334	693	java/io/IOException
    //   334	348	710	java/io/IOException
  }
  
  /* Error */
  static int installFromZipStream(Context paramContext, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc_w 310
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 113	com/tencent/midas/plugin/APPluginUtils:copyEmtpyResAPKFromAssets	(Landroid/content/Context;)V
    //   10: aload_1
    //   11: ifnonnull +12 -> 23
    //   14: ldc_w 310
    //   17: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: bipush 254
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 4
    //   26: new 312	java/util/zip/ZipInputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 315	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 7
    //   36: aload 7
    //   38: invokevirtual 319	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   41: astore_1
    //   42: aload_0
    //   43: invokestatic 74	com/tencent/midas/plugin/APPluginConfig:getPluginPath	(Landroid/content/Context;)Ljava/io/File;
    //   46: invokevirtual 322	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: astore 10
    //   51: aload_1
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +372 -> 426
    //   57: aload_0
    //   58: invokevirtual 325	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   61: astore 8
    //   63: aload_0
    //   64: invokevirtual 328	java/util/zip/ZipEntry:isDirectory	()Z
    //   67: ifne +14 -> 81
    //   70: aload 8
    //   72: ldc_w 330
    //   75: invokevirtual 333	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   78: ifeq +12 -> 90
    //   81: aload 7
    //   83: invokevirtual 319	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   86: astore_0
    //   87: goto -34 -> 53
    //   90: aload 8
    //   92: ldc_w 335
    //   95: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   98: ifeq +190 -> 288
    //   101: aload 8
    //   103: ldc_w 335
    //   106: invokevirtual 339	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: iload_2
    //   111: iconst_m1
    //   112: if_icmpeq +430 -> 542
    //   115: aload 8
    //   117: iconst_0
    //   118: iload_2
    //   119: invokevirtual 343	java/lang/String:substring	(II)Ljava/lang/String;
    //   122: astore_0
    //   123: aload_0
    //   124: ldc_w 345
    //   127: invokevirtual 264	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   130: iconst_3
    //   131: aaload
    //   132: astore 5
    //   134: new 160	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   141: aload 10
    //   143: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   149: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 247
    //   158: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore_0
    //   165: iconst_1
    //   166: istore_3
    //   167: new 68	java/io/File
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: astore 11
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore 6
    //   183: aconst_null
    //   184: astore 9
    //   186: new 257	java/io/FileOutputStream
    //   189: dup
    //   190: aload 11
    //   192: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   195: astore_0
    //   196: aload_0
    //   197: astore_1
    //   198: aload 6
    //   200: astore 4
    //   202: new 254	java/io/BufferedOutputStream
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 283	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   210: astore 6
    //   212: sipush 8192
    //   215: newarray byte
    //   217: astore_1
    //   218: aload 7
    //   220: aload_1
    //   221: invokevirtual 346	java/util/zip/ZipInputStream:read	([B)I
    //   224: istore_2
    //   225: iload_2
    //   226: iconst_m1
    //   227: if_icmpeq +97 -> 324
    //   230: aload 6
    //   232: aload_1
    //   233: iconst_0
    //   234: iload_2
    //   235: invokevirtual 292	java/io/BufferedOutputStream:write	([BII)V
    //   238: goto -20 -> 218
    //   241: astore 5
    //   243: aload_0
    //   244: astore_1
    //   245: aload 6
    //   247: astore 4
    //   249: aload 5
    //   251: invokestatic 299	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   254: putstatic 302	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   257: aload 6
    //   259: ifnull +8 -> 267
    //   262: aload 6
    //   264: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   275: aload 7
    //   277: invokevirtual 347	java/util/zip/ZipInputStream:close	()V
    //   280: ldc_w 310
    //   283: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_m1
    //   287: ireturn
    //   288: new 160	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   295: aload 10
    //   297: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: getstatic 276	java/io/File:separator	Ljava/lang/String;
    //   303: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 8
    //   308: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore_0
    //   315: ldc 99
    //   317: astore 5
    //   319: iconst_0
    //   320: istore_3
    //   321: goto -154 -> 167
    //   324: aload 6
    //   326: invokevirtual 295	java/io/BufferedOutputStream:flush	()V
    //   329: iload_3
    //   330: aload 8
    //   332: aload 5
    //   334: aload 11
    //   336: invokevirtual 104	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   339: invokestatic 351	com/tencent/midas/plugin/APPluginUtils:backUp	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload 7
    //   344: invokevirtual 319	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   347: astore_1
    //   348: aload 6
    //   350: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   353: aload_0
    //   354: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   357: aload_1
    //   358: astore_0
    //   359: goto -306 -> 53
    //   362: astore_0
    //   363: aload_1
    //   364: astore_0
    //   365: goto -312 -> 53
    //   368: astore 5
    //   370: aconst_null
    //   371: astore_0
    //   372: aload 4
    //   374: ifnull +8 -> 382
    //   377: aload 4
    //   379: invokevirtual 255	java/io/BufferedOutputStream:close	()V
    //   382: aload_0
    //   383: ifnull +7 -> 390
    //   386: aload_0
    //   387: invokevirtual 258	java/io/FileOutputStream:close	()V
    //   390: ldc_w 310
    //   393: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 5
    //   398: athrow
    //   399: astore_1
    //   400: aload 7
    //   402: astore_0
    //   403: aload_1
    //   404: invokestatic 299	com/tencent/midas/plugin/APPluginUtils:getFullExceptionStacktrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   407: putstatic 302	com/tencent/midas/plugin/APPluginUtils:installErrMsg	Ljava/lang/String;
    //   410: aload_0
    //   411: ifnull +7 -> 418
    //   414: aload_0
    //   415: invokevirtual 347	java/util/zip/ZipInputStream:close	()V
    //   418: ldc_w 310
    //   421: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: iconst_m1
    //   425: ireturn
    //   426: aload 7
    //   428: invokevirtual 347	java/util/zip/ZipInputStream:close	()V
    //   431: ldc_w 310
    //   434: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: iconst_0
    //   438: ireturn
    //   439: astore_0
    //   440: aconst_null
    //   441: astore_1
    //   442: aload_1
    //   443: ifnull +7 -> 450
    //   446: aload_1
    //   447: invokevirtual 347	java/util/zip/ZipInputStream:close	()V
    //   450: ldc_w 310
    //   453: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload_0
    //   457: athrow
    //   458: astore_0
    //   459: goto -179 -> 280
    //   462: astore_0
    //   463: goto -32 -> 431
    //   466: astore_0
    //   467: goto -49 -> 418
    //   470: astore_1
    //   471: goto -21 -> 450
    //   474: astore_0
    //   475: aload 7
    //   477: astore_1
    //   478: goto -36 -> 442
    //   481: astore 4
    //   483: aload_0
    //   484: astore_1
    //   485: aload 4
    //   487: astore_0
    //   488: goto -46 -> 442
    //   491: astore_1
    //   492: aload 4
    //   494: astore_0
    //   495: goto -92 -> 403
    //   498: astore_0
    //   499: goto -109 -> 390
    //   502: astore 5
    //   504: aload_1
    //   505: astore_0
    //   506: goto -134 -> 372
    //   509: astore 5
    //   511: aload 6
    //   513: astore 4
    //   515: goto -143 -> 372
    //   518: astore_0
    //   519: goto -244 -> 275
    //   522: astore 5
    //   524: aconst_null
    //   525: astore_0
    //   526: aload 9
    //   528: astore 6
    //   530: goto -287 -> 243
    //   533: astore 5
    //   535: aload 9
    //   537: astore 6
    //   539: goto -296 -> 243
    //   542: aload 8
    //   544: astore_0
    //   545: goto -422 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	paramContext	Context
    //   0	548	1	paramInputStream	java.io.InputStream
    //   109	126	2	i	int
    //   166	164	3	bool	boolean
    //   24	354	4	localObject1	Object
    //   481	12	4	localObject2	Object
    //   513	1	4	localObject3	Object
    //   132	1	5	str1	String
    //   241	9	5	localException1	Exception
    //   317	16	5	str2	String
    //   368	29	5	localObject4	Object
    //   502	1	5	localObject5	Object
    //   509	1	5	localObject6	Object
    //   522	1	5	localException2	Exception
    //   533	1	5	localException3	Exception
    //   181	357	6	localObject7	Object
    //   34	442	7	localZipInputStream	java.util.zip.ZipInputStream
    //   61	482	8	str3	String
    //   184	352	9	localObject8	Object
    //   49	247	10	str4	String
    //   175	160	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   212	218	241	java/lang/Exception
    //   218	225	241	java/lang/Exception
    //   230	238	241	java/lang/Exception
    //   324	348	241	java/lang/Exception
    //   348	357	362	java/io/IOException
    //   186	196	368	finally
    //   36	51	399	java/lang/Exception
    //   57	81	399	java/lang/Exception
    //   81	87	399	java/lang/Exception
    //   90	110	399	java/lang/Exception
    //   115	123	399	java/lang/Exception
    //   123	165	399	java/lang/Exception
    //   167	177	399	java/lang/Exception
    //   262	267	399	java/lang/Exception
    //   271	275	399	java/lang/Exception
    //   288	315	399	java/lang/Exception
    //   348	357	399	java/lang/Exception
    //   377	382	399	java/lang/Exception
    //   386	390	399	java/lang/Exception
    //   390	399	399	java/lang/Exception
    //   26	36	439	finally
    //   275	280	458	java/io/IOException
    //   426	431	462	java/io/IOException
    //   414	418	466	java/io/IOException
    //   446	450	470	java/io/IOException
    //   36	51	474	finally
    //   57	81	474	finally
    //   81	87	474	finally
    //   90	110	474	finally
    //   115	123	474	finally
    //   123	165	474	finally
    //   167	177	474	finally
    //   262	267	474	finally
    //   271	275	474	finally
    //   288	315	474	finally
    //   348	357	474	finally
    //   377	382	474	finally
    //   386	390	474	finally
    //   390	399	474	finally
    //   403	410	481	finally
    //   26	36	491	java/lang/Exception
    //   377	382	498	java/io/IOException
    //   386	390	498	java/io/IOException
    //   202	212	502	finally
    //   249	257	502	finally
    //   212	218	509	finally
    //   218	225	509	finally
    //   230	238	509	finally
    //   324	348	509	finally
    //   262	267	518	java/io/IOException
    //   271	275	518	java/io/IOException
    //   186	196	522	java/lang/Exception
    //   202	212	533	java/lang/Exception
  }
  
  public static int installPlugin(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(217564);
    j = 0;
    int i = 0;
    APLog.d("APPluginInstallerAndUpdater", "installPlugin from = ".concat(String.valueOf(paramInt)));
    for (;;)
    {
      try
      {
        unInstallPlugin(paramContext);
        if (paramInt != 1) {
          continue;
        }
        i = installFromAssets(paramContext);
        paramInt = i;
        if (i != 0)
        {
          unInstallPlugin(paramContext);
          paramInt = i;
        }
      }
      catch (Exception paramContext)
      {
        APLog.w("APPluginUtils", "installPlugin Exception:" + paramContext.toString());
        APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(paramContext);
        paramInt = j;
        continue;
      }
      finally
      {
        AppMethodBeat.o(217564);
      }
      AppMethodBeat.o(217564);
      return paramInt;
      if (paramInt == 2) {
        i = installFromData(paramContext);
      }
    }
  }
  
  /* Error */
  public static int isNeedUpdateFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 369
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 99
    //   8: astore 4
    //   10: aload_0
    //   11: ldc_w 371
    //   14: invokestatic 101	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   17: invokevirtual 104	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   20: astore 5
    //   22: aload 5
    //   24: astore 4
    //   26: aload 4
    //   28: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +181 -> 212
    //   34: aload_0
    //   35: aload 4
    //   37: invokestatic 375	com/tencent/midas/plugin/APPluginUtils:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/pm/PackageInfo;
    //   40: getfield 380	android/content/pm/PackageInfo:versionCode	I
    //   43: istore_2
    //   44: aload_0
    //   45: invokestatic 383	com/tencent/midas/plugin/APPluginUtils:getAssetsVersionCode	(Landroid/content/Context;)I
    //   48: istore_3
    //   49: ldc 143
    //   51: new 160	java/lang/StringBuilder
    //   54: dup
    //   55: ldc_w 385
    //   58: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: iload_2
    //   62: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 387
    //   68: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_3
    //   72: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: ldc_w 389
    //   84: aload_1
    //   85: invokevirtual 393	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +38 -> 126
    //   91: ldc_w 394
    //   94: iload_3
    //   95: if_icmpeq +31 -> 126
    //   98: aload_0
    //   99: ifnull +27 -> 126
    //   102: aload_0
    //   103: instanceof 396
    //   106: ifeq +20 -> 126
    //   109: aload_0
    //   110: checkcast 396	android/app/Activity
    //   113: astore_1
    //   114: aload_1
    //   115: new 398	com/tencent/midas/plugin/APPluginInstallerAndUpdater$1
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 401	com/tencent/midas/plugin/APPluginInstallerAndUpdater$1:<init>	(Landroid/app/Activity;)V
    //   123: invokevirtual 405	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   126: iload_3
    //   127: iload_2
    //   128: if_icmple +20 -> 148
    //   131: ldc_w 369
    //   134: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_1
    //   138: ireturn
    //   139: astore 4
    //   141: iconst_0
    //   142: istore_2
    //   143: iconst_0
    //   144: istore_3
    //   145: goto -96 -> 49
    //   148: aload_0
    //   149: invokestatic 141	com/tencent/midas/plugin/APPluginUtils:getDataZipFile	(Landroid/content/Context;)Ljava/io/File;
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +40 -> 194
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 322	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   162: invokestatic 408	com/tencent/midas/plugin/APPluginUtils:getZipVersionCodeWtihFileName	(Landroid/content/Context;Ljava/lang/String;)I
    //   165: istore_3
    //   166: ldc 143
    //   168: ldc_w 410
    //   171: iload_3
    //   172: invokestatic 234	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: invokevirtual 153	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: invokestatic 158	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: iload_3
    //   182: iload_2
    //   183: if_icmple +11 -> 194
    //   186: ldc_w 369
    //   189: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: iconst_2
    //   193: ireturn
    //   194: ldc_w 369
    //   197: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore 4
    //   204: goto -61 -> 143
    //   207: astore 5
    //   209: goto -183 -> 26
    //   212: iconst_0
    //   213: istore_2
    //   214: goto -170 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   0	217	1	paramString	String
    //   43	171	2	i	int
    //   48	136	3	j	int
    //   8	28	4	localObject	Object
    //   139	1	4	localException1	Exception
    //   202	1	4	localException2	Exception
    //   20	3	5	str	String
    //   207	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   26	44	139	java/lang/Exception
    //   44	49	202	java/lang/Exception
    //   10	22	207	java/lang/Exception
  }
  
  public static boolean isNeedUpdateFromLocal(Context paramContext)
  {
    AppMethodBeat.i(217544);
    APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal");
    File localFile = APPluginConfig.getPluginUpdatePath(paramContext);
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      int j;
      try
      {
        localObject2 = new File(localFile, APPluginConfig.SIGN_FILE_NAME);
        if (!((File)localObject2).exists())
        {
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, sign file not exist, return false!");
          AppMethodBeat.o(217544);
          return false;
        }
        APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, sign file exist!");
        localObject1 = new HashMap();
        APPluginUtils.readSingInfoItems((HashMap)localObject1, (File)localObject2);
        localObject2 = localFile.listFiles();
        if (localObject2 == null)
        {
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, cannot get local file list, return false!");
          AppMethodBeat.o(217544);
          return false;
        }
        if (localObject2.length == 0)
        {
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, empty local file list, return false!");
          AppMethodBeat.o(217544);
          return false;
        }
        i = 0;
        j = 0;
        if (i < localObject2.length)
        {
          Object localObject3 = localObject2[i];
          String str1 = localObject3.getName();
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating update dir file list, current = ".concat(String.valueOf(str1)));
          if (str1.startsWith("MidasCore")) {
            j = 1;
          }
          if (!str1.endsWith(".apk"))
          {
            APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating update dir file list, current = " + str1 + ", not apk file, continue!");
          }
          else
          {
            String str2 = ((APSignIniItem)((HashMap)localObject1).get(str1.split("\\_")[0])).md5;
            boolean bool = APPluginUtils.checkFileMD5(localObject3.getCanonicalPath(), str2);
            APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating update dir file list, current = " + str1 + " valid = " + bool);
            if (!bool)
            {
              APPluginUtils.clearDirContent(localFile);
              AppMethodBeat.o(217544);
              return false;
            }
            ((HashMap)localObject1).remove(str1.split("\\_")[0]);
          }
        }
      }
      catch (Exception paramContext)
      {
        APLog.e("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, got exception = ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(217544);
        return false;
      }
      if (((HashMap)localObject1).size() > 0)
      {
        APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size = " + ((HashMap)localObject1).size());
        paramContext = APPluginConfig.getPluginPath(paramContext);
        localObject1 = ((HashMap)localObject1).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (APSignIniItem)((Iterator)localObject1).next();
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating sigMap left, current = " + ((APSignIniItem)localObject2).fullName);
          if (!new File(paramContext, ((APSignIniItem)localObject2).fullName).exists())
          {
            APLog.e("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating sigMap left, current = " + ((APSignIniItem)localObject2).fullName + " missing in midasplugins!");
            APPluginUtils.clearDirContent(localFile);
            AppMethodBeat.o(217544);
            return false;
          }
          APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, iterating sigMap left, current = " + ((APSignIniItem)localObject2).fullName + " exist in midasplugins!");
        }
      }
      APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size is 0");
      if (j == 0)
      {
        APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, hasMidasCoreFile == false!");
        AppMethodBeat.o(217544);
        return false;
      }
      APLog.d("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, hasMidasCoreFile == true!");
      APLog.e("APPluginInstallerAndUpdater", "isNeedUpdateFromLocal, return true!");
      AppMethodBeat.o(217544);
      return true;
      i += 1;
    }
  }
  
  public static void unInstallPlugin(Context paramContext)
  {
    AppMethodBeat.i(217619);
    APLog.d("APPluginInstallerAndUpdater", "unInstallPlugin " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    APPluginUtils.deletePlugin(paramContext);
    APPluginUtils.deleteDex(paramContext);
    APPluginUtils.deleteLibs(paramContext);
    sInstallPathMap.clear();
    sPackageInfoMap.clear();
    APPluginStatic.release();
    APPluginConfig.libExtend += 1;
    AppMethodBeat.o(217619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginInstallerAndUpdater
 * JD-Core Version:    0.7.0.1
 */