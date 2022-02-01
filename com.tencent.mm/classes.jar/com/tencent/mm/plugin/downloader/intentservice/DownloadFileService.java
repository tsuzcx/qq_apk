package com.tencent.mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.vfs.e;
import java.io.File;

public class DownloadFileService
  extends IntentService
{
  private static final String TAG;
  private ResultReceiver pls;
  private int plt;
  private int plu;
  
  static
  {
    AppMethodBeat.i(88885);
    TAG = DownloadFileService.class.getSimpleName();
    AppMethodBeat.o(88885);
  }
  
  public DownloadFileService()
  {
    super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
  }
  
  /* Error */
  private void d(String paramString, e parame)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokestatic 55	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   9: astore 8
    //   11: new 57	java/net/URL
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 58	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 62	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 64	java/net/HttpURLConnection
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 66
    //   29: invokevirtual 69	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: sipush 10000
    //   36: invokevirtual 72	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   39: aload_1
    //   40: sipush 3000
    //   43: invokevirtual 75	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   46: aload_1
    //   47: ldc 77
    //   49: invokevirtual 81	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   52: iconst_0
    //   53: invokestatic 87	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   56: istore_3
    //   57: aload_1
    //   58: invokevirtual 91	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
    //   66: istore 4
    //   68: iload 4
    //   70: sipush 200
    //   73: if_icmpne +195 -> 268
    //   76: sipush 8192
    //   79: newarray byte
    //   81: astore 5
    //   83: aload_2
    //   84: aload 5
    //   86: invokevirtual 101	java/io/InputStream:read	([B)I
    //   89: istore 4
    //   91: iload 4
    //   93: iconst_m1
    //   94: if_icmpeq +190 -> 284
    //   97: aload 8
    //   99: aload 5
    //   101: iconst_0
    //   102: iload 4
    //   104: invokevirtual 107	java/io/OutputStream:write	([BII)V
    //   107: aload_0
    //   108: iload 4
    //   110: aload_0
    //   111: getfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:plt	I
    //   114: iadd
    //   115: putfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:plt	I
    //   118: new 111	android/os/Bundle
    //   121: dup
    //   122: invokespecial 113	android/os/Bundle:<init>	()V
    //   125: astore 6
    //   127: aload_0
    //   128: getfield 109	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:plt	I
    //   131: i2l
    //   132: ldc2_w 114
    //   135: lmul
    //   136: iload_3
    //   137: i2l
    //   138: ldiv
    //   139: l2i
    //   140: istore 4
    //   142: iload 4
    //   144: aload_0
    //   145: getfield 117	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:plu	I
    //   148: if_icmple -65 -> 83
    //   151: aload 6
    //   153: ldc 119
    //   155: iload 4
    //   157: invokevirtual 123	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   160: aload_0
    //   161: getfield 125	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:pls	Landroid/os/ResultReceiver;
    //   164: sipush 4657
    //   167: aload 6
    //   169: invokevirtual 131	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   172: aload_0
    //   173: iload 4
    //   175: putfield 117	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:plu	I
    //   178: goto -95 -> 83
    //   181: astore 7
    //   183: aload_2
    //   184: astore 6
    //   186: aload_1
    //   187: astore 5
    //   189: aload 5
    //   191: astore_2
    //   192: aload 6
    //   194: astore_1
    //   195: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   198: aload 7
    //   200: ldc 133
    //   202: iconst_0
    //   203: anewarray 135	java/lang/Object
    //   206: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 8
    //   211: ifnull +8 -> 219
    //   214: aload 8
    //   216: invokevirtual 144	java/io/OutputStream:close	()V
    //   219: aload 6
    //   221: ifnull +8 -> 229
    //   224: aload 6
    //   226: invokevirtual 145	java/io/InputStream:close	()V
    //   229: aload 5
    //   231: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   234: ldc 49
    //   236: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: astore_1
    //   241: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   244: ldc 150
    //   246: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   252: aload_1
    //   253: ldc 133
    //   255: iconst_0
    //   256: anewarray 135	java/lang/Object
    //   259: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: ldc 49
    //   264: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: return
    //   268: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   271: ldc 156
    //   273: iload 4
    //   275: invokestatic 162	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   278: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   281: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 8
    //   286: ifnull +8 -> 294
    //   289: aload 8
    //   291: invokevirtual 144	java/io/OutputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 145	java/io/InputStream:close	()V
    //   302: aload_1
    //   303: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   306: ldc 49
    //   308: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: astore_2
    //   313: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   316: aload_2
    //   317: ldc 133
    //   319: iconst_0
    //   320: anewarray 135	java/lang/Object
    //   323: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: goto -24 -> 302
    //   329: astore_1
    //   330: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   333: aload_1
    //   334: ldc 133
    //   336: iconst_0
    //   337: anewarray 135	java/lang/Object
    //   340: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: goto -114 -> 229
    //   346: astore 7
    //   348: aconst_null
    //   349: astore 5
    //   351: aconst_null
    //   352: astore 6
    //   354: aload 5
    //   356: astore_2
    //   357: aload 6
    //   359: astore_1
    //   360: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   363: aload 7
    //   365: ldc 133
    //   367: iconst_0
    //   368: anewarray 135	java/lang/Object
    //   371: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload 8
    //   376: ifnull +8 -> 384
    //   379: aload 8
    //   381: invokevirtual 144	java/io/OutputStream:close	()V
    //   384: aload 6
    //   386: ifnull +8 -> 394
    //   389: aload 6
    //   391: invokevirtual 145	java/io/InputStream:close	()V
    //   394: aload 5
    //   396: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   399: ldc 49
    //   401: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: return
    //   405: astore_1
    //   406: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   409: aload_1
    //   410: ldc 133
    //   412: iconst_0
    //   413: anewarray 135	java/lang/Object
    //   416: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: goto -25 -> 394
    //   422: astore 7
    //   424: aconst_null
    //   425: astore 5
    //   427: aconst_null
    //   428: astore 6
    //   430: aload 5
    //   432: astore_2
    //   433: aload 6
    //   435: astore_1
    //   436: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   439: aload 7
    //   441: ldc 133
    //   443: iconst_0
    //   444: anewarray 135	java/lang/Object
    //   447: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: aload 8
    //   452: ifnull +8 -> 460
    //   455: aload 8
    //   457: invokevirtual 144	java/io/OutputStream:close	()V
    //   460: aload 6
    //   462: ifnull +8 -> 470
    //   465: aload 6
    //   467: invokevirtual 145	java/io/InputStream:close	()V
    //   470: aload 5
    //   472: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   475: ldc 49
    //   477: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: return
    //   481: astore_1
    //   482: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   485: aload_1
    //   486: ldc 133
    //   488: iconst_0
    //   489: anewarray 135	java/lang/Object
    //   492: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: goto -25 -> 470
    //   498: astore 5
    //   500: aconst_null
    //   501: astore_2
    //   502: aconst_null
    //   503: astore_1
    //   504: aload 8
    //   506: ifnull +8 -> 514
    //   509: aload 8
    //   511: invokevirtual 144	java/io/OutputStream:close	()V
    //   514: aload_1
    //   515: ifnull +7 -> 522
    //   518: aload_1
    //   519: invokevirtual 145	java/io/InputStream:close	()V
    //   522: aload_2
    //   523: invokevirtual 148	java/net/HttpURLConnection:disconnect	()V
    //   526: ldc 49
    //   528: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: aload 5
    //   533: athrow
    //   534: astore_1
    //   535: getstatic 28	com/tencent/mm/plugin/downloader/intentservice/DownloadFileService:TAG	Ljava/lang/String;
    //   538: aload_1
    //   539: ldc 133
    //   541: iconst_0
    //   542: anewarray 135	java/lang/Object
    //   545: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   548: goto -26 -> 522
    //   551: astore 5
    //   553: aconst_null
    //   554: astore 6
    //   556: aload_1
    //   557: astore_2
    //   558: aload 6
    //   560: astore_1
    //   561: goto -57 -> 504
    //   564: astore 5
    //   566: aload_2
    //   567: astore 6
    //   569: aload_1
    //   570: astore_2
    //   571: aload 6
    //   573: astore_1
    //   574: goto -70 -> 504
    //   577: astore 5
    //   579: goto -75 -> 504
    //   582: astore 7
    //   584: aconst_null
    //   585: astore 6
    //   587: aload_1
    //   588: astore 5
    //   590: goto -160 -> 430
    //   593: astore 7
    //   595: aload_1
    //   596: astore 5
    //   598: aload_2
    //   599: astore 6
    //   601: goto -171 -> 430
    //   604: astore 7
    //   606: aconst_null
    //   607: astore 6
    //   609: aload_1
    //   610: astore 5
    //   612: goto -258 -> 354
    //   615: astore 7
    //   617: aload_1
    //   618: astore 5
    //   620: aload_2
    //   621: astore 6
    //   623: goto -269 -> 354
    //   626: astore 7
    //   628: aconst_null
    //   629: astore 5
    //   631: aconst_null
    //   632: astore 6
    //   634: goto -445 -> 189
    //   637: astore 7
    //   639: aconst_null
    //   640: astore 6
    //   642: aload_1
    //   643: astore 5
    //   645: goto -456 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	DownloadFileService
    //   0	648	1	paramString	String
    //   0	648	2	parame	e
    //   56	81	3	i	int
    //   66	208	4	j	int
    //   81	390	5	localObject1	java.lang.Object
    //   498	34	5	localObject2	java.lang.Object
    //   551	1	5	localObject3	java.lang.Object
    //   564	1	5	localObject4	java.lang.Object
    //   577	1	5	localObject5	java.lang.Object
    //   588	56	5	str	String
    //   125	516	6	localObject6	java.lang.Object
    //   181	18	7	localProtocolException1	java.net.ProtocolException
    //   346	18	7	localMalformedURLException1	java.net.MalformedURLException
    //   422	18	7	localIOException1	java.io.IOException
    //   582	1	7	localIOException2	java.io.IOException
    //   593	1	7	localIOException3	java.io.IOException
    //   604	1	7	localMalformedURLException2	java.net.MalformedURLException
    //   615	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   626	1	7	localProtocolException2	java.net.ProtocolException
    //   637	1	7	localProtocolException3	java.net.ProtocolException
    //   9	501	8	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   62	68	181	java/net/ProtocolException
    //   76	83	181	java/net/ProtocolException
    //   83	91	181	java/net/ProtocolException
    //   97	178	181	java/net/ProtocolException
    //   268	284	181	java/net/ProtocolException
    //   5	11	240	java/io/FileNotFoundException
    //   289	294	312	java/io/IOException
    //   298	302	312	java/io/IOException
    //   214	219	329	java/io/IOException
    //   224	229	329	java/io/IOException
    //   11	26	346	java/net/MalformedURLException
    //   379	384	405	java/io/IOException
    //   389	394	405	java/io/IOException
    //   11	26	422	java/io/IOException
    //   455	460	481	java/io/IOException
    //   465	470	481	java/io/IOException
    //   11	26	498	finally
    //   509	514	534	java/io/IOException
    //   518	522	534	java/io/IOException
    //   26	62	551	finally
    //   62	68	564	finally
    //   76	83	564	finally
    //   83	91	564	finally
    //   97	178	564	finally
    //   268	284	564	finally
    //   195	209	577	finally
    //   360	374	577	finally
    //   436	450	577	finally
    //   26	62	582	java/io/IOException
    //   62	68	593	java/io/IOException
    //   76	83	593	java/io/IOException
    //   83	91	593	java/io/IOException
    //   97	178	593	java/io/IOException
    //   268	284	593	java/io/IOException
    //   26	62	604	java/net/MalformedURLException
    //   62	68	615	java/net/MalformedURLException
    //   76	83	615	java/net/MalformedURLException
    //   83	91	615	java/net/MalformedURLException
    //   97	178	615	java/net/MalformedURLException
    //   268	284	615	java/net/MalformedURLException
    //   11	26	626	java/net/ProtocolException
    //   26	62	637	java/net/ProtocolException
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(88882);
    super.onCreate();
    s.c localc = a.bI(this, "reminder_channel_id");
    localc.f("Something Download").g("Download in progress").as(2131232660);
    startForeground(4657, localc.build());
    AppMethodBeat.o(88882);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(88883);
    String str = paramIntent.getExtras().getString("url");
    this.pls = ((ResultReceiver)paramIntent.getParcelableExtra("receiver"));
    paramIntent = new e(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    if (!paramIntent.exists()) {
      paramIntent.mkdirs();
    }
    d(str, new e(paramIntent, "file11.apk"));
    AppMethodBeat.o(88883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.intentservice.DownloadFileService
 * JD-Core Version:    0.7.0.1
 */