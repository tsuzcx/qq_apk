package com.tencent.mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import java.io.File;

public class DownloadFileService
  extends IntentService
{
  private static final String TAG;
  private ResultReceiver kXG;
  private int kXH;
  private int kXI;
  
  static
  {
    AppMethodBeat.i(2337);
    TAG = DownloadFileService.class.getSimpleName();
    AppMethodBeat.o(2337);
  }
  
  public DownloadFileService()
  {
    super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
  }
  
  /* Error */
  private void e(String paramString, File paramFile)
  {
    // Byte code:
    //   0: sipush 2336
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 51	java/io/FileOutputStream
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 54	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: astore 8
    //   16: new 56	java/net/URL
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 63	java/net/HttpURLConnection
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 65
    //   34: invokevirtual 68	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: sipush 10000
    //   41: invokevirtual 71	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   44: aload_1
    //   45: sipush 3000
    //   48: invokevirtual 74	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   51: aload_1
    //   52: ldc 76
    //   54: invokevirtual 80	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 86	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   60: invokevirtual 90	java/lang/Integer:intValue	()I
    //   63: istore_3
    //   64: aload_1
    //   65: invokevirtual 94	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 97	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore 4
    //   75: iload 4
    //   77: sipush 200
    //   80: if_icmpne +200 -> 280
    //   83: sipush 8192
    //   86: newarray byte
    //   88: astore 5
    //   90: aload_2
    //   91: aload 5
    //   93: invokevirtual 103	java/io/InputStream:read	([B)I
    //   96: istore 4
    //   98: iload 4
    //   100: iconst_m1
    //   101: if_icmpeq +195 -> 296
    //   104: aload 8
    //   106: aload 5
    //   108: iconst_0
    //   109: iload 4
    //   111: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   114: aload_0
    //   115: iload 4
    //   117: aload_0
    //   118: getfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXH	I
    //   121: iadd
    //   122: putfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXH	I
    //   125: new 111	android/os/Bundle
    //   128: dup
    //   129: invokespecial 113	android/os/Bundle:<init>	()V
    //   132: astore 6
    //   134: aload_0
    //   135: getfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXH	I
    //   138: i2l
    //   139: ldc2_w 114
    //   142: lmul
    //   143: iload_3
    //   144: i2l
    //   145: ldiv
    //   146: l2i
    //   147: istore 4
    //   149: iload 4
    //   151: aload_0
    //   152: getfield 117	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXI	I
    //   155: if_icmple -65 -> 90
    //   158: aload 6
    //   160: ldc 119
    //   162: iload 4
    //   164: invokevirtual 123	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   167: aload_0
    //   168: getfield 125	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXG	Landroid/os/ResultReceiver;
    //   171: sipush 4657
    //   174: aload 6
    //   176: invokevirtual 131	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   179: aload_0
    //   180: iload 4
    //   182: putfield 117	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:kXI	I
    //   185: goto -95 -> 90
    //   188: astore 7
    //   190: aload_2
    //   191: astore 6
    //   193: aload_1
    //   194: astore 5
    //   196: aload 5
    //   198: astore_2
    //   199: aload 6
    //   201: astore_1
    //   202: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   205: aload 7
    //   207: ldc 133
    //   209: iconst_0
    //   210: anewarray 135	java/lang/Object
    //   213: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload 8
    //   218: invokevirtual 145	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   221: invokevirtual 150	java/io/FileDescriptor:sync	()V
    //   224: aload 8
    //   226: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   229: aload 6
    //   231: ifnull +8 -> 239
    //   234: aload 6
    //   236: invokevirtual 154	java/io/InputStream:close	()V
    //   239: aload 5
    //   241: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   244: sipush 2336
    //   247: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: return
    //   251: astore_1
    //   252: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   255: ldc 159
    //   257: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   263: aload_1
    //   264: ldc 133
    //   266: iconst_0
    //   267: anewarray 135	java/lang/Object
    //   270: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: sipush 2336
    //   276: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: return
    //   280: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   283: ldc 164
    //   285: iload 4
    //   287: invokestatic 169	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   290: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokestatic 162	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 8
    //   298: invokevirtual 145	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   301: invokevirtual 150	java/io/FileDescriptor:sync	()V
    //   304: aload 8
    //   306: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 154	java/io/InputStream:close	()V
    //   317: aload_1
    //   318: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   321: sipush 2336
    //   324: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: return
    //   328: astore_2
    //   329: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   332: aload_2
    //   333: ldc 133
    //   335: iconst_0
    //   336: anewarray 135	java/lang/Object
    //   339: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: goto -25 -> 317
    //   345: astore_1
    //   346: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   349: aload_1
    //   350: ldc 133
    //   352: iconst_0
    //   353: anewarray 135	java/lang/Object
    //   356: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: goto -120 -> 239
    //   362: astore 7
    //   364: aconst_null
    //   365: astore 5
    //   367: aconst_null
    //   368: astore 6
    //   370: aload 5
    //   372: astore_2
    //   373: aload 6
    //   375: astore_1
    //   376: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   379: aload 7
    //   381: ldc 133
    //   383: iconst_0
    //   384: anewarray 135	java/lang/Object
    //   387: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: aload 8
    //   392: invokevirtual 145	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   395: invokevirtual 150	java/io/FileDescriptor:sync	()V
    //   398: aload 8
    //   400: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   403: aload 6
    //   405: ifnull +8 -> 413
    //   408: aload 6
    //   410: invokevirtual 154	java/io/InputStream:close	()V
    //   413: aload 5
    //   415: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   418: sipush 2336
    //   421: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: return
    //   425: astore_1
    //   426: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   429: aload_1
    //   430: ldc 133
    //   432: iconst_0
    //   433: anewarray 135	java/lang/Object
    //   436: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: goto -26 -> 413
    //   442: astore 7
    //   444: aconst_null
    //   445: astore 5
    //   447: aconst_null
    //   448: astore 6
    //   450: aload 5
    //   452: astore_2
    //   453: aload 6
    //   455: astore_1
    //   456: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   459: aload 7
    //   461: ldc 133
    //   463: iconst_0
    //   464: anewarray 135	java/lang/Object
    //   467: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: aload 8
    //   472: invokevirtual 145	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   475: invokevirtual 150	java/io/FileDescriptor:sync	()V
    //   478: aload 8
    //   480: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   483: aload 6
    //   485: ifnull +8 -> 493
    //   488: aload 6
    //   490: invokevirtual 154	java/io/InputStream:close	()V
    //   493: aload 5
    //   495: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   498: sipush 2336
    //   501: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: return
    //   505: astore_1
    //   506: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   509: aload_1
    //   510: ldc 133
    //   512: iconst_0
    //   513: anewarray 135	java/lang/Object
    //   516: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: goto -26 -> 493
    //   522: astore 5
    //   524: aconst_null
    //   525: astore_2
    //   526: aconst_null
    //   527: astore_1
    //   528: aload 8
    //   530: invokevirtual 145	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   533: invokevirtual 150	java/io/FileDescriptor:sync	()V
    //   536: aload 8
    //   538: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   541: aload_1
    //   542: ifnull +7 -> 549
    //   545: aload_1
    //   546: invokevirtual 154	java/io/InputStream:close	()V
    //   549: aload_2
    //   550: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   553: sipush 2336
    //   556: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload 5
    //   561: athrow
    //   562: astore_1
    //   563: getstatic 27	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   566: aload_1
    //   567: ldc 133
    //   569: iconst_0
    //   570: anewarray 135	java/lang/Object
    //   573: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   576: goto -27 -> 549
    //   579: astore 6
    //   581: goto -45 -> 536
    //   584: astore 5
    //   586: aconst_null
    //   587: astore 6
    //   589: aload_1
    //   590: astore_2
    //   591: aload 6
    //   593: astore_1
    //   594: goto -66 -> 528
    //   597: astore 5
    //   599: aload_2
    //   600: astore 6
    //   602: aload_1
    //   603: astore_2
    //   604: aload 6
    //   606: astore_1
    //   607: goto -79 -> 528
    //   610: astore 5
    //   612: goto -84 -> 528
    //   615: astore_1
    //   616: goto -138 -> 478
    //   619: astore 7
    //   621: aconst_null
    //   622: astore 6
    //   624: aload_1
    //   625: astore 5
    //   627: goto -177 -> 450
    //   630: astore 7
    //   632: aload_1
    //   633: astore 5
    //   635: aload_2
    //   636: astore 6
    //   638: goto -188 -> 450
    //   641: astore_1
    //   642: goto -244 -> 398
    //   645: astore 7
    //   647: aconst_null
    //   648: astore 6
    //   650: aload_1
    //   651: astore 5
    //   653: goto -283 -> 370
    //   656: astore 7
    //   658: aload_1
    //   659: astore 5
    //   661: aload_2
    //   662: astore 6
    //   664: goto -294 -> 370
    //   667: astore_1
    //   668: goto -444 -> 224
    //   671: astore 7
    //   673: aconst_null
    //   674: astore 5
    //   676: aconst_null
    //   677: astore 6
    //   679: goto -483 -> 196
    //   682: astore 7
    //   684: aconst_null
    //   685: astore 6
    //   687: aload_1
    //   688: astore 5
    //   690: goto -494 -> 196
    //   693: astore 5
    //   695: goto -391 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	DownloadFileService
    //   0	698	1	paramString	String
    //   0	698	2	paramFile	File
    //   63	81	3	i	int
    //   73	213	4	j	int
    //   88	406	5	localObject1	java.lang.Object
    //   522	38	5	localObject2	java.lang.Object
    //   584	1	5	localObject3	java.lang.Object
    //   597	1	5	localObject4	java.lang.Object
    //   610	1	5	localObject5	java.lang.Object
    //   625	64	5	str	String
    //   693	1	5	localException1	java.lang.Exception
    //   132	357	6	localObject6	java.lang.Object
    //   579	1	6	localException2	java.lang.Exception
    //   587	99	6	localFile	File
    //   188	18	7	localProtocolException1	java.net.ProtocolException
    //   362	18	7	localMalformedURLException1	java.net.MalformedURLException
    //   442	18	7	localIOException1	java.io.IOException
    //   619	1	7	localIOException2	java.io.IOException
    //   630	1	7	localIOException3	java.io.IOException
    //   645	1	7	localMalformedURLException2	java.net.MalformedURLException
    //   656	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   671	1	7	localProtocolException2	java.net.ProtocolException
    //   682	1	7	localProtocolException3	java.net.ProtocolException
    //   14	523	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	75	188	java/net/ProtocolException
    //   83	90	188	java/net/ProtocolException
    //   90	98	188	java/net/ProtocolException
    //   104	185	188	java/net/ProtocolException
    //   280	296	188	java/net/ProtocolException
    //   6	16	251	java/io/FileNotFoundException
    //   296	304	328	java/io/IOException
    //   304	309	328	java/io/IOException
    //   313	317	328	java/io/IOException
    //   216	224	345	java/io/IOException
    //   224	229	345	java/io/IOException
    //   234	239	345	java/io/IOException
    //   16	31	362	java/net/MalformedURLException
    //   390	398	425	java/io/IOException
    //   398	403	425	java/io/IOException
    //   408	413	425	java/io/IOException
    //   16	31	442	java/io/IOException
    //   470	478	505	java/io/IOException
    //   478	483	505	java/io/IOException
    //   488	493	505	java/io/IOException
    //   16	31	522	finally
    //   528	536	562	java/io/IOException
    //   536	541	562	java/io/IOException
    //   545	549	562	java/io/IOException
    //   528	536	579	java/lang/Exception
    //   31	69	584	finally
    //   69	75	597	finally
    //   83	90	597	finally
    //   90	98	597	finally
    //   104	185	597	finally
    //   280	296	597	finally
    //   202	216	610	finally
    //   376	390	610	finally
    //   456	470	610	finally
    //   470	478	615	java/lang/Exception
    //   31	69	619	java/io/IOException
    //   69	75	630	java/io/IOException
    //   83	90	630	java/io/IOException
    //   90	98	630	java/io/IOException
    //   104	185	630	java/io/IOException
    //   280	296	630	java/io/IOException
    //   390	398	641	java/lang/Exception
    //   31	69	645	java/net/MalformedURLException
    //   69	75	656	java/net/MalformedURLException
    //   83	90	656	java/net/MalformedURLException
    //   90	98	656	java/net/MalformedURLException
    //   104	185	656	java/net/MalformedURLException
    //   280	296	656	java/net/MalformedURLException
    //   216	224	667	java/lang/Exception
    //   16	31	671	java/net/ProtocolException
    //   31	69	682	java/net/ProtocolException
    //   296	304	693	java/lang/Exception
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(2334);
    super.onCreate();
    s.c localc = a.br(this, "reminder_channel_id");
    localc.e("Something Download").f("Download in progress").Y(2130839103);
    startForeground(4657, localc.build());
    AppMethodBeat.o(2334);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(2335);
    String str = paramIntent.getExtras().getString("url");
    this.kXG = ((ResultReceiver)paramIntent.getParcelableExtra("receiver"));
    paramIntent = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    if (!paramIntent.exists()) {
      paramIntent.mkdirs();
    }
    e(str, new File(paramIntent, "file11.apk"));
    AppMethodBeat.o(2335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadFileService
 * JD-Core Version:    0.7.0.1
 */