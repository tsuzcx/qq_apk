package com.tencent.midas.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginConfig;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class APMidasPluginDownloadWorker
  implements Runnable
{
  private static final String TAG = "PluginDownloadWorker";
  private final Context context;
  private final ArrayList<APMidasPluginDownInfo> downInfos;
  private final IAPMidasPluginDownListener downListener;
  private final File saveDir;
  
  APMidasPluginDownloadWorker(Context paramContext, ArrayList<APMidasPluginDownInfo> paramArrayList, File paramFile, IAPMidasPluginDownListener paramIAPMidasPluginDownListener)
  {
    this.downInfos = paramArrayList;
    this.saveDir = paramFile;
    this.downListener = paramIAPMidasPluginDownListener;
    this.context = paramContext;
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(193242);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(193242);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(193242);
    }
  }
  
  /* Error */
  private boolean downloadSingleDownInfo(APMidasPluginDownInfo paramAPMidasPluginDownInfo)
  {
    // Byte code:
    //   0: ldc 59
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +17 -> 23
    //   9: ldc 10
    //   11: ldc 61
    //   13: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 59
    //   18: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: getfield 72	com/tencent/midas/download/APMidasPluginDownInfo:full_url	Ljava/lang/String;
    //   27: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +17 -> 47
    //   33: ldc 10
    //   35: ldc 80
    //   37: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 59
    //   42: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_1
    //   48: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   51: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +17 -> 71
    //   57: ldc 10
    //   59: ldc 85
    //   61: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: ldc 59
    //   66: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_1
    //   72: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   75: ldc 87
    //   77: invokevirtual 93	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   80: ifne +27 -> 107
    //   83: aload_1
    //   84: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   87: ldc 95
    //   89: invokevirtual 93	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   92: ifne +15 -> 107
    //   95: aload_1
    //   96: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   99: ldc 97
    //   101: invokevirtual 93	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   104: ifeq +54 -> 158
    //   107: aload_1
    //   108: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   111: astore 5
    //   113: aload_0
    //   114: getfield 32	com/tencent/midas/download/APMidasPluginDownloadWorker:context	Landroid/content/Context;
    //   117: aload 5
    //   119: aload_1
    //   120: getfield 100	com/tencent/midas/download/APMidasPluginDownInfo:new_md5_decode	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 28	com/tencent/midas/download/APMidasPluginDownloadWorker:saveDir	Ljava/io/File;
    //   127: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: invokestatic 110	com/tencent/midas/download/APMidasPluginDownloadWorker:isPluginAlreadyExist	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   133: ifeq +52 -> 185
    //   136: ldc 10
    //   138: ldc 112
    //   140: aload 5
    //   142: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 120	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc 59
    //   153: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: new 125	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   165: aload_1
    //   166: getfield 83	com/tencent/midas/download/APMidasPluginDownInfo:name	Ljava/lang/String;
    //   169: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 87
    //   174: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 5
    //   182: goto -69 -> 113
    //   185: invokestatic 139	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   188: invokevirtual 142	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   191: astore_3
    //   192: new 102	java/io/File
    //   195: dup
    //   196: new 125	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   203: aload_3
    //   204: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc 144
    //   209: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload 5
    //   217: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: astore_3
    //   221: aload_3
    //   222: invokevirtual 150	java/io/File:exists	()Z
    //   225: ifeq +309 -> 534
    //   228: ldc 10
    //   230: new 125	java/lang/StringBuilder
    //   233: dup
    //   234: ldc 152
    //   236: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload 5
    //   241: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 157
    //   246: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_3
    //   256: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   259: aload_1
    //   260: getfield 100	com/tencent/midas/download/APMidasPluginDownInfo:new_md5_decode	Ljava/lang/String;
    //   263: invokestatic 163	com/tencent/midas/plugin/APPluginUtils:checkFileMD5	(Ljava/lang/String;Ljava/lang/String;)Z
    //   266: ifeq +203 -> 469
    //   269: ldc 10
    //   271: new 125	java/lang/StringBuilder
    //   274: dup
    //   275: ldc 152
    //   277: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload 5
    //   282: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 165
    //   287: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_3
    //   297: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: aload_0
    //   301: getfield 28	com/tencent/midas/download/APMidasPluginDownloadWorker:saveDir	Ljava/io/File;
    //   304: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   307: aload 5
    //   309: invokestatic 169	com/tencent/midas/plugin/APPluginUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   312: ifeq +37 -> 349
    //   315: ldc 10
    //   317: new 125	java/lang/StringBuilder
    //   320: dup
    //   321: ldc 152
    //   323: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload 5
    //   328: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc 171
    //   333: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: ldc 59
    //   344: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: iconst_1
    //   348: ireturn
    //   349: ldc 10
    //   351: new 125	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 152
    //   357: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload 5
    //   362: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc 173
    //   367: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_1
    //   377: getfield 72	com/tencent/midas/download/APMidasPluginDownInfo:full_url	Ljava/lang/String;
    //   380: astore_1
    //   381: ldc 10
    //   383: ldc 175
    //   385: aload_1
    //   386: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   389: invokevirtual 120	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: ldc 10
    //   397: ldc 177
    //   399: aload 5
    //   401: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   404: invokevirtual 120	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   407: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: new 102	java/io/File
    //   413: dup
    //   414: aload_0
    //   415: getfield 28	com/tencent/midas/download/APMidasPluginDownloadWorker:saveDir	Ljava/io/File;
    //   418: aload 5
    //   420: invokespecial 180	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   423: astore_3
    //   424: aload_3
    //   425: invokevirtual 150	java/io/File:exists	()Z
    //   428: ifeq +160 -> 588
    //   431: aload_3
    //   432: invokevirtual 183	java/io/File:delete	()Z
    //   435: ifne +129 -> 564
    //   438: ldc 10
    //   440: new 125	java/lang/StringBuilder
    //   443: dup
    //   444: ldc 185
    //   446: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload_3
    //   450: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   453: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: ldc 59
    //   464: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: iconst_0
    //   468: ireturn
    //   469: ldc 10
    //   471: new 125	java/lang/StringBuilder
    //   474: dup
    //   475: ldc 152
    //   477: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   480: aload 5
    //   482: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc 187
    //   487: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: goto -120 -> 376
    //   499: astore_3
    //   500: ldc 10
    //   502: new 125	java/lang/StringBuilder
    //   505: dup
    //   506: ldc 152
    //   508: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: aload 5
    //   513: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 189
    //   518: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_3
    //   522: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: goto -155 -> 376
    //   534: ldc 10
    //   536: new 125	java/lang/StringBuilder
    //   539: dup
    //   540: ldc 152
    //   542: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: aload 5
    //   547: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc 194
    //   552: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: goto -185 -> 376
    //   564: ldc 10
    //   566: new 125	java/lang/StringBuilder
    //   569: dup
    //   570: ldc 196
    //   572: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   575: aload_3
    //   576: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   579: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 199	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: new 201	java/net/URL
    //   591: dup
    //   592: aload_1
    //   593: invokespecial 202	java/net/URL:<init>	(Ljava/lang/String;)V
    //   596: invokevirtual 206	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   599: checkcast 208	java/net/HttpURLConnection
    //   602: astore_1
    //   603: aload_1
    //   604: ldc 209
    //   606: invokevirtual 212	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   609: aload_1
    //   610: ldc 209
    //   612: invokevirtual 215	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   615: aload_1
    //   616: ldc 217
    //   618: invokevirtual 220	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   621: aload_1
    //   622: iconst_1
    //   623: invokevirtual 224	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   626: aload_1
    //   627: iconst_0
    //   628: invokevirtual 227	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   631: aload_1
    //   632: ldc 229
    //   634: ldc 231
    //   636: invokevirtual 234	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload_1
    //   640: ldc 236
    //   642: ldc 238
    //   644: invokevirtual 234	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_1
    //   648: invokevirtual 241	java/net/HttpURLConnection:connect	()V
    //   651: aload_1
    //   652: invokevirtual 245	java/net/HttpURLConnection:getResponseCode	()I
    //   655: istore_2
    //   656: iload_2
    //   657: sipush 200
    //   660: if_icmpeq +32 -> 692
    //   663: ldc 10
    //   665: ldc 247
    //   667: iload_2
    //   668: invokestatic 250	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   671: invokevirtual 120	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   674: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aconst_null
    //   678: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   681: aconst_null
    //   682: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   685: ldc 59
    //   687: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: iconst_0
    //   691: ireturn
    //   692: aload_3
    //   693: invokevirtual 255	java/io/File:createNewFile	()Z
    //   696: ifne +43 -> 739
    //   699: ldc 10
    //   701: new 125	java/lang/StringBuilder
    //   704: dup
    //   705: ldc_w 257
    //   708: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   711: aload_3
    //   712: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   715: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aconst_null
    //   725: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   728: aconst_null
    //   729: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   732: ldc 59
    //   734: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   737: iconst_0
    //   738: ireturn
    //   739: new 259	java/io/FileOutputStream
    //   742: dup
    //   743: aload_3
    //   744: invokespecial 262	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   747: astore 4
    //   749: aload_1
    //   750: invokevirtual 266	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   753: astore_1
    //   754: sipush 2048
    //   757: newarray byte
    //   759: astore 6
    //   761: aload_1
    //   762: aload 6
    //   764: invokevirtual 272	java/io/InputStream:read	([B)I
    //   767: istore_2
    //   768: iload_2
    //   769: iconst_m1
    //   770: if_icmpeq +52 -> 822
    //   773: aload 4
    //   775: aload 6
    //   777: iconst_0
    //   778: iload_2
    //   779: invokevirtual 276	java/io/FileOutputStream:write	([BII)V
    //   782: goto -21 -> 761
    //   785: astore_3
    //   786: aload_1
    //   787: astore_3
    //   788: aload 4
    //   790: astore_1
    //   791: ldc 10
    //   793: ldc_w 278
    //   796: aload 5
    //   798: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   801: invokevirtual 120	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   804: invokestatic 67	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload_3
    //   808: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   811: aload_1
    //   812: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   815: ldc 59
    //   817: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: iconst_0
    //   821: ireturn
    //   822: aload 4
    //   824: invokevirtual 281	java/io/FileOutputStream:flush	()V
    //   827: aload_1
    //   828: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   831: aload 4
    //   833: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   836: ldc 10
    //   838: new 125	java/lang/StringBuilder
    //   841: dup
    //   842: ldc_w 283
    //   845: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   848: aload 5
    //   850: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: ldc_w 285
    //   856: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   865: invokestatic 139	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   868: invokevirtual 142	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   871: astore_1
    //   872: new 125	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   879: aload_1
    //   880: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: ldc 144
    //   885: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: astore_1
    //   892: new 102	java/io/File
    //   895: dup
    //   896: aload_1
    //   897: aload 5
    //   899: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: invokevirtual 150	java/io/File:exists	()Z
    //   905: ifeq +60 -> 965
    //   908: ldc 10
    //   910: new 125	java/lang/StringBuilder
    //   913: dup
    //   914: ldc 152
    //   916: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   919: aload 5
    //   921: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: ldc_w 287
    //   927: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: ldc 59
    //   938: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   941: iconst_1
    //   942: ireturn
    //   943: astore_1
    //   944: aconst_null
    //   945: astore 4
    //   947: aconst_null
    //   948: astore_3
    //   949: aload_3
    //   950: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   953: aload 4
    //   955: invokestatic 252	com/tencent/midas/download/APMidasPluginDownloadWorker:closeQuietly	(Ljava/io/Closeable;)V
    //   958: ldc 59
    //   960: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   963: aload_1
    //   964: athrow
    //   965: ldc 10
    //   967: new 125	java/lang/StringBuilder
    //   970: dup
    //   971: ldc 152
    //   973: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   976: aload 5
    //   978: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: ldc_w 289
    //   984: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: aload_3
    //   994: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   997: aload_1
    //   998: aload 5
    //   1000: invokestatic 169	com/tencent/midas/plugin/APPluginUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1003: pop
    //   1004: ldc 59
    //   1006: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1009: iconst_1
    //   1010: ireturn
    //   1011: astore_1
    //   1012: ldc 10
    //   1014: new 125	java/lang/StringBuilder
    //   1017: dup
    //   1018: ldc 152
    //   1020: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1023: aload 5
    //   1025: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: ldc_w 291
    //   1031: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload_1
    //   1035: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1038: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: invokestatic 123	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1044: goto -40 -> 1004
    //   1047: astore_1
    //   1048: aconst_null
    //   1049: astore_3
    //   1050: goto -101 -> 949
    //   1053: astore_3
    //   1054: aload_1
    //   1055: astore 5
    //   1057: aload_3
    //   1058: astore_1
    //   1059: aload 5
    //   1061: astore_3
    //   1062: goto -113 -> 949
    //   1065: astore 5
    //   1067: aload_1
    //   1068: astore 4
    //   1070: aload 5
    //   1072: astore_1
    //   1073: goto -124 -> 949
    //   1076: astore_1
    //   1077: aconst_null
    //   1078: astore_1
    //   1079: aconst_null
    //   1080: astore_3
    //   1081: goto -290 -> 791
    //   1084: astore_1
    //   1085: aload 4
    //   1087: astore_1
    //   1088: aconst_null
    //   1089: astore_3
    //   1090: goto -299 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1093	0	this	APMidasPluginDownloadWorker
    //   0	1093	1	paramAPMidasPluginDownInfo	APMidasPluginDownInfo
    //   655	124	2	i	int
    //   191	259	3	localObject1	Object
    //   499	245	3	localException1	java.lang.Exception
    //   785	1	3	localException2	java.lang.Exception
    //   787	263	3	localAPMidasPluginDownInfo	APMidasPluginDownInfo
    //   1053	5	3	localObject2	Object
    //   1061	29	3	localObject3	Object
    //   747	339	4	localObject4	Object
    //   111	949	5	localObject5	Object
    //   1065	6	5	localObject6	Object
    //   759	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   185	342	499	java/lang/Exception
    //   349	376	499	java/lang/Exception
    //   469	496	499	java/lang/Exception
    //   534	561	499	java/lang/Exception
    //   754	761	785	java/lang/Exception
    //   761	768	785	java/lang/Exception
    //   773	782	785	java/lang/Exception
    //   822	827	785	java/lang/Exception
    //   588	656	943	finally
    //   663	677	943	finally
    //   692	724	943	finally
    //   739	749	943	finally
    //   865	936	1011	java/lang/Exception
    //   965	1004	1011	java/lang/Exception
    //   749	754	1047	finally
    //   754	761	1053	finally
    //   761	768	1053	finally
    //   773	782	1053	finally
    //   822	827	1053	finally
    //   791	807	1065	finally
    //   588	656	1076	java/lang/Exception
    //   663	677	1076	java/lang/Exception
    //   692	724	1076	java/lang/Exception
    //   739	749	1076	java/lang/Exception
    //   749	754	1084	java/lang/Exception
  }
  
  private static boolean isPluginAlreadyExist(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(193243);
    APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, file name = ".concat(String.valueOf(paramString1)));
    APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, md5 = ".concat(String.valueOf(paramString2)));
    if (TextUtils.isEmpty(paramString1))
    {
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test error, empty file name!");
      AppMethodBeat.o(193243);
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test error, empty md5!");
      AppMethodBeat.o(193243);
      return false;
    }
    if (paramContext == null)
    {
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test error, null context!");
      AppMethodBeat.o(193243);
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test error, empty saveDir!");
      AppMethodBeat.o(193243);
      return false;
    }
    paramContext = APPluginConfig.getPluginPath(paramContext);
    if (paramContext == null)
    {
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins error, cannot get plugin path!");
      AppMethodBeat.o(193243);
      return false;
    }
    paramContext = new File(paramContext, paramString1);
    if (!paramContext.exists())
    {
      APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, plugin not exist! Name = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(193243);
      return false;
    }
    for (;;)
    {
      try
      {
        if (!APPluginUtils.checkFileMD5(paramContext.getCanonicalPath(), paramString2)) {
          continue;
        }
        APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, plugin exist & md5 correct!");
        if (APPluginUtils.copyFile(paramContext.getCanonicalPath(), paramString3, paramString1))
        {
          APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, plugin exist & md5 correct & copy success!");
          AppMethodBeat.o(193243);
          return true;
        }
        APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test, plugin exist & md5 correct & copy fail!");
      }
      catch (IOException paramContext)
      {
        APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test error, exception = ".concat(String.valueOf(paramContext)));
        continue;
      }
      APLog.e("PluginDownloadWorker", "plugin already exist in midasplugins test, final false!");
      AppMethodBeat.o(193243);
      return false;
      APLog.d("PluginDownloadWorker", "plugin already exist in midasplugins test, plugin exist & md5 not correct!");
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(193240);
    APLog.d("PluginDownloadWorker", "About to enter critical region！");
    try
    {
      APLog.d("PluginDownloadWorker", "Enter critical region！");
      if (this.downListener == null)
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, null downListener!");
        return;
      }
      if ((this.downInfos == null) || (this.downInfos.isEmpty()))
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, empty down list!");
        this.downListener.onDownloadFail(-5);
        return;
      }
      if (this.context == null)
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, null context!");
        this.downListener.onDownloadFail(-8);
        return;
      }
      if (this.saveDir == null)
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, null save dir!");
        this.downListener.onDownloadFail(-6);
        return;
      }
      if (!this.saveDir.isDirectory())
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, save dir not directory!");
        this.downListener.onDownloadFail(-7);
        return;
      }
      if (APMidasPluginDownloadUtils.checkIniFileExist(this.saveDir))
      {
        APLog.d("PluginDownloadWorker", "MidasSign.ini already exists, no need to download again!");
        this.downListener.onDownloadFail(-2);
        return;
      }
      APLog.d("PluginDownloadWorker", "MidasSign.ini not exists, start to download again!");
      APPluginUtils.clearDirContent(this.saveDir);
      if ((!this.saveDir.exists()) && (!this.saveDir.mkdirs()))
      {
        APLog.e("PluginDownloadWorker", "Cannot start plugin down worker, save dir not exist and cannot create it!");
        this.downListener.onDownloadFail(-3);
        return;
      }
      Iterator localIterator = this.downInfos.iterator();
      while (localIterator.hasNext())
      {
        APMidasPluginDownInfo localAPMidasPluginDownInfo = (APMidasPluginDownInfo)localIterator.next();
        if (!downloadSingleDownInfo(localAPMidasPluginDownInfo))
        {
          this.downListener.onDownloadFail(-4);
          APLog.d("PluginDownloadWorker", "File name = " + localAPMidasPluginDownInfo.name + " download fail, about to clear download dir!");
          APPluginUtils.clearDirContent(this.saveDir);
          return;
        }
      }
      this.downListener.onDownloadSuccess();
      APLog.d("PluginDownloadWorker", "About to leave critical region");
      APLog.d("PluginDownloadWorker", "Leave critical region");
      AppMethodBeat.o(193240);
      return;
    }
    finally
    {
      AppMethodBeat.o(193240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.download.APMidasPluginDownloadWorker
 * JD-Core Version:    0.7.0.1
 */