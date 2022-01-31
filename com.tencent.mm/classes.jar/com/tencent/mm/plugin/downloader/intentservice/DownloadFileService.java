package com.tencent.mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.x.c;
import com.tencent.mm.plugin.downloader.c.a;
import java.io.File;

public class DownloadFileService
  extends IntentService
{
  private static final String TAG = DownloadFileService.class.getSimpleName();
  private ResultReceiver iOP;
  private int iOQ;
  private int iOR;
  
  public DownloadFileService()
  {
    super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
  }
  
  /* Error */
  private void c(String paramString, File paramFile)
  {
    // Byte code:
    //   0: new 42	java/io/FileOutputStream
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 45	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 12
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 8
    //   22: aload 8
    //   24: astore 5
    //   26: aload 9
    //   28: astore 6
    //   30: aload 10
    //   32: astore 7
    //   34: aload 11
    //   36: astore_2
    //   37: new 47	java/net/URL
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 48	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 52	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   48: checkcast 54	java/net/HttpURLConnection
    //   51: astore 13
    //   53: aload 8
    //   55: astore 5
    //   57: aload 9
    //   59: astore 6
    //   61: aload 10
    //   63: astore 7
    //   65: aload 11
    //   67: astore_2
    //   68: aload 13
    //   70: ldc 56
    //   72: invokevirtual 59	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: aload 8
    //   77: astore 5
    //   79: aload 9
    //   81: astore 6
    //   83: aload 10
    //   85: astore 7
    //   87: aload 11
    //   89: astore_2
    //   90: aload 13
    //   92: sipush 10000
    //   95: invokevirtual 63	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   98: aload 8
    //   100: astore 5
    //   102: aload 9
    //   104: astore 6
    //   106: aload 10
    //   108: astore 7
    //   110: aload 11
    //   112: astore_2
    //   113: aload 13
    //   115: sipush 3000
    //   118: invokevirtual 66	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   121: aload 8
    //   123: astore 5
    //   125: aload 9
    //   127: astore 6
    //   129: aload 10
    //   131: astore 7
    //   133: aload 11
    //   135: astore_2
    //   136: aload 13
    //   138: ldc 68
    //   140: invokevirtual 72	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   143: invokestatic 78	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   146: invokevirtual 82	java/lang/Integer:intValue	()I
    //   149: istore_3
    //   150: aload 8
    //   152: astore 5
    //   154: aload 9
    //   156: astore 6
    //   158: aload 10
    //   160: astore 7
    //   162: aload 11
    //   164: astore_2
    //   165: aload 13
    //   167: invokevirtual 86	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   170: astore_1
    //   171: aload_1
    //   172: astore 5
    //   174: aload_1
    //   175: astore 6
    //   177: aload_1
    //   178: astore 7
    //   180: aload_1
    //   181: astore_2
    //   182: aload 13
    //   184: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
    //   187: istore 4
    //   189: iload 4
    //   191: sipush 200
    //   194: if_icmpne +282 -> 476
    //   197: aload_1
    //   198: astore 5
    //   200: aload_1
    //   201: astore 6
    //   203: aload_1
    //   204: astore 7
    //   206: aload_1
    //   207: astore_2
    //   208: sipush 8192
    //   211: newarray byte
    //   213: astore 8
    //   215: aload_1
    //   216: astore 5
    //   218: aload_1
    //   219: astore 6
    //   221: aload_1
    //   222: astore 7
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: aload 8
    //   229: invokevirtual 95	java/io/InputStream:read	([B)I
    //   232: istore 4
    //   234: iload 4
    //   236: iconst_m1
    //   237: if_icmpeq +273 -> 510
    //   240: aload_1
    //   241: astore 5
    //   243: aload_1
    //   244: astore 6
    //   246: aload_1
    //   247: astore 7
    //   249: aload_1
    //   250: astore_2
    //   251: aload 12
    //   253: aload 8
    //   255: iconst_0
    //   256: iload 4
    //   258: invokevirtual 99	java/io/FileOutputStream:write	([BII)V
    //   261: aload_1
    //   262: astore 5
    //   264: aload_1
    //   265: astore 6
    //   267: aload_1
    //   268: astore 7
    //   270: aload_1
    //   271: astore_2
    //   272: aload_0
    //   273: iload 4
    //   275: aload_0
    //   276: getfield 101	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOQ	I
    //   279: iadd
    //   280: putfield 101	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOQ	I
    //   283: aload_1
    //   284: astore 5
    //   286: aload_1
    //   287: astore 6
    //   289: aload_1
    //   290: astore 7
    //   292: aload_1
    //   293: astore_2
    //   294: new 103	android/os/Bundle
    //   297: dup
    //   298: invokespecial 105	android/os/Bundle:<init>	()V
    //   301: astore 9
    //   303: aload_1
    //   304: astore 5
    //   306: aload_1
    //   307: astore 6
    //   309: aload_1
    //   310: astore 7
    //   312: aload_1
    //   313: astore_2
    //   314: aload_0
    //   315: getfield 101	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOQ	I
    //   318: i2l
    //   319: ldc2_w 106
    //   322: lmul
    //   323: iload_3
    //   324: i2l
    //   325: ldiv
    //   326: l2i
    //   327: istore 4
    //   329: aload_1
    //   330: astore 5
    //   332: aload_1
    //   333: astore 6
    //   335: aload_1
    //   336: astore 7
    //   338: aload_1
    //   339: astore_2
    //   340: iload 4
    //   342: aload_0
    //   343: getfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOR	I
    //   346: if_icmple -131 -> 215
    //   349: aload_1
    //   350: astore 5
    //   352: aload_1
    //   353: astore 6
    //   355: aload_1
    //   356: astore 7
    //   358: aload_1
    //   359: astore_2
    //   360: aload 9
    //   362: ldc 111
    //   364: iload 4
    //   366: invokevirtual 115	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   369: aload_1
    //   370: astore 5
    //   372: aload_1
    //   373: astore 6
    //   375: aload_1
    //   376: astore 7
    //   378: aload_1
    //   379: astore_2
    //   380: aload_0
    //   381: getfield 117	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOP	Landroid/os/ResultReceiver;
    //   384: sipush 4657
    //   387: aload 9
    //   389: invokevirtual 123	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   392: aload_1
    //   393: astore 5
    //   395: aload_1
    //   396: astore 6
    //   398: aload_1
    //   399: astore 7
    //   401: aload_1
    //   402: astore_2
    //   403: aload_0
    //   404: iload 4
    //   406: putfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:iOR	I
    //   409: goto -194 -> 215
    //   412: astore_1
    //   413: aload 5
    //   415: astore_2
    //   416: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   419: aload_1
    //   420: ldc 125
    //   422: iconst_0
    //   423: anewarray 127	java/lang/Object
    //   426: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload 12
    //   431: invokevirtual 137	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   434: invokevirtual 142	java/io/FileDescriptor:sync	()V
    //   437: aload 12
    //   439: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   442: aload 5
    //   444: ifnull +8 -> 452
    //   447: aload 5
    //   449: invokevirtual 146	java/io/InputStream:close	()V
    //   452: return
    //   453: astore_1
    //   454: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   457: ldc 148
    //   459: invokestatic 152	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   465: aload_1
    //   466: ldc 125
    //   468: iconst_0
    //   469: anewarray 127	java/lang/Object
    //   472: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: return
    //   476: aload_1
    //   477: astore 5
    //   479: aload_1
    //   480: astore 6
    //   482: aload_1
    //   483: astore 7
    //   485: aload_1
    //   486: astore_2
    //   487: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   490: new 154	java/lang/StringBuilder
    //   493: dup
    //   494: ldc 156
    //   496: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: iload 4
    //   501: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 152	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 12
    //   512: invokevirtual 137	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   515: invokevirtual 142	java/io/FileDescriptor:sync	()V
    //   518: aload 12
    //   520: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   523: aload_1
    //   524: ifnull -72 -> 452
    //   527: aload_1
    //   528: invokevirtual 146	java/io/InputStream:close	()V
    //   531: return
    //   532: astore_1
    //   533: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   536: aload_1
    //   537: ldc 125
    //   539: iconst_0
    //   540: anewarray 127	java/lang/Object
    //   543: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   546: return
    //   547: astore_1
    //   548: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   551: aload_1
    //   552: ldc 125
    //   554: iconst_0
    //   555: anewarray 127	java/lang/Object
    //   558: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   561: return
    //   562: astore_1
    //   563: aload 6
    //   565: astore_2
    //   566: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   569: aload_1
    //   570: ldc 125
    //   572: iconst_0
    //   573: anewarray 127	java/lang/Object
    //   576: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: aload 12
    //   581: invokevirtual 137	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   584: invokevirtual 142	java/io/FileDescriptor:sync	()V
    //   587: aload 12
    //   589: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   592: aload 6
    //   594: ifnull -142 -> 452
    //   597: aload 6
    //   599: invokevirtual 146	java/io/InputStream:close	()V
    //   602: return
    //   603: astore_1
    //   604: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   607: aload_1
    //   608: ldc 125
    //   610: iconst_0
    //   611: anewarray 127	java/lang/Object
    //   614: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: return
    //   618: astore_1
    //   619: aload 7
    //   621: astore_2
    //   622: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   625: aload_1
    //   626: ldc 125
    //   628: iconst_0
    //   629: anewarray 127	java/lang/Object
    //   632: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload 12
    //   637: invokevirtual 137	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   640: invokevirtual 142	java/io/FileDescriptor:sync	()V
    //   643: aload 12
    //   645: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   648: aload 7
    //   650: ifnull -198 -> 452
    //   653: aload 7
    //   655: invokevirtual 146	java/io/InputStream:close	()V
    //   658: return
    //   659: astore_1
    //   660: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   663: aload_1
    //   664: ldc 125
    //   666: iconst_0
    //   667: anewarray 127	java/lang/Object
    //   670: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: return
    //   674: astore_1
    //   675: aload 12
    //   677: invokevirtual 137	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   680: invokevirtual 142	java/io/FileDescriptor:sync	()V
    //   683: aload 12
    //   685: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   688: aload_2
    //   689: ifnull +7 -> 696
    //   692: aload_2
    //   693: invokevirtual 146	java/io/InputStream:close	()V
    //   696: aload_1
    //   697: athrow
    //   698: astore_2
    //   699: getstatic 21	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   702: aload_2
    //   703: ldc 125
    //   705: iconst_0
    //   706: anewarray 127	java/lang/Object
    //   709: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   712: goto -16 -> 696
    //   715: astore 5
    //   717: goto -34 -> 683
    //   720: astore_1
    //   721: goto -78 -> 643
    //   724: astore_1
    //   725: goto -138 -> 587
    //   728: astore_1
    //   729: goto -292 -> 437
    //   732: astore_2
    //   733: goto -215 -> 518
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	this	DownloadFileService
    //   0	736	1	paramString	String
    //   0	736	2	paramFile	File
    //   149	175	3	i	int
    //   187	313	4	j	int
    //   24	454	5	localObject1	java.lang.Object
    //   715	1	5	localException	java.lang.Exception
    //   28	570	6	localObject2	java.lang.Object
    //   32	622	7	localObject3	java.lang.Object
    //   20	234	8	arrayOfByte	byte[]
    //   11	377	9	localBundle	Bundle
    //   14	145	10	localObject4	java.lang.Object
    //   17	146	11	localObject5	java.lang.Object
    //   8	676	12	localFileOutputStream	java.io.FileOutputStream
    //   51	132	13	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   37	53	412	java/net/ProtocolException
    //   68	75	412	java/net/ProtocolException
    //   90	98	412	java/net/ProtocolException
    //   113	121	412	java/net/ProtocolException
    //   136	150	412	java/net/ProtocolException
    //   165	171	412	java/net/ProtocolException
    //   182	189	412	java/net/ProtocolException
    //   208	215	412	java/net/ProtocolException
    //   226	234	412	java/net/ProtocolException
    //   251	261	412	java/net/ProtocolException
    //   272	283	412	java/net/ProtocolException
    //   294	303	412	java/net/ProtocolException
    //   314	329	412	java/net/ProtocolException
    //   340	349	412	java/net/ProtocolException
    //   360	369	412	java/net/ProtocolException
    //   380	392	412	java/net/ProtocolException
    //   403	409	412	java/net/ProtocolException
    //   487	510	412	java/net/ProtocolException
    //   0	10	453	java/io/FileNotFoundException
    //   510	518	532	java/io/IOException
    //   518	523	532	java/io/IOException
    //   527	531	532	java/io/IOException
    //   429	437	547	java/io/IOException
    //   437	442	547	java/io/IOException
    //   447	452	547	java/io/IOException
    //   37	53	562	java/net/MalformedURLException
    //   68	75	562	java/net/MalformedURLException
    //   90	98	562	java/net/MalformedURLException
    //   113	121	562	java/net/MalformedURLException
    //   136	150	562	java/net/MalformedURLException
    //   165	171	562	java/net/MalformedURLException
    //   182	189	562	java/net/MalformedURLException
    //   208	215	562	java/net/MalformedURLException
    //   226	234	562	java/net/MalformedURLException
    //   251	261	562	java/net/MalformedURLException
    //   272	283	562	java/net/MalformedURLException
    //   294	303	562	java/net/MalformedURLException
    //   314	329	562	java/net/MalformedURLException
    //   340	349	562	java/net/MalformedURLException
    //   360	369	562	java/net/MalformedURLException
    //   380	392	562	java/net/MalformedURLException
    //   403	409	562	java/net/MalformedURLException
    //   487	510	562	java/net/MalformedURLException
    //   579	587	603	java/io/IOException
    //   587	592	603	java/io/IOException
    //   597	602	603	java/io/IOException
    //   37	53	618	java/io/IOException
    //   68	75	618	java/io/IOException
    //   90	98	618	java/io/IOException
    //   113	121	618	java/io/IOException
    //   136	150	618	java/io/IOException
    //   165	171	618	java/io/IOException
    //   182	189	618	java/io/IOException
    //   208	215	618	java/io/IOException
    //   226	234	618	java/io/IOException
    //   251	261	618	java/io/IOException
    //   272	283	618	java/io/IOException
    //   294	303	618	java/io/IOException
    //   314	329	618	java/io/IOException
    //   340	349	618	java/io/IOException
    //   360	369	618	java/io/IOException
    //   380	392	618	java/io/IOException
    //   403	409	618	java/io/IOException
    //   487	510	618	java/io/IOException
    //   635	643	659	java/io/IOException
    //   643	648	659	java/io/IOException
    //   653	658	659	java/io/IOException
    //   37	53	674	finally
    //   68	75	674	finally
    //   90	98	674	finally
    //   113	121	674	finally
    //   136	150	674	finally
    //   165	171	674	finally
    //   182	189	674	finally
    //   208	215	674	finally
    //   226	234	674	finally
    //   251	261	674	finally
    //   272	283	674	finally
    //   294	303	674	finally
    //   314	329	674	finally
    //   340	349	674	finally
    //   360	369	674	finally
    //   380	392	674	finally
    //   403	409	674	finally
    //   416	429	674	finally
    //   487	510	674	finally
    //   566	579	674	finally
    //   622	635	674	finally
    //   675	683	698	java/io/IOException
    //   683	688	698	java/io/IOException
    //   692	696	698	java/io/IOException
    //   675	683	715	java/lang/Exception
    //   635	643	720	java/lang/Exception
    //   579	587	724	java/lang/Exception
    //   429	437	728	java/lang/Exception
    //   510	518	732	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    x.c localc = new x.c(this, (byte)0);
    localc.c("Something Download").d("Download in progress").ah(c.a.icon);
    startForeground(4657, localc.build());
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getExtras().getString("url");
    this.iOP = ((ResultReceiver)paramIntent.getParcelableExtra("receiver"));
    paramIntent = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    if (!paramIntent.exists()) {
      paramIntent.mkdirs();
    }
    c(str, new File(paramIntent, "file11.apk"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadFileService
 * JD-Core Version:    0.7.0.1
 */