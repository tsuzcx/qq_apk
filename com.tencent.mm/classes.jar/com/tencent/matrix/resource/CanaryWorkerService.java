package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.resource.analyzer.model.f;

public class CanaryWorkerService
  extends MatrixJobIntentService
{
  public static void a(Context paramContext, f paramf)
  {
    Intent localIntent = new Intent(paramContext, CanaryWorkerService.class);
    localIntent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
    localIntent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", paramf);
    a(paramContext, CanaryWorkerService.class, -84148995, localIntent);
  }
  
  /* Error */
  protected final void l(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +727 -> 728
    //   4: ldc 18
    //   6: aload_1
    //   7: invokevirtual 42	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +715 -> 728
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 52	com/tencent/matrix/resource/CanaryWorkerService:getClassLoader	()Ljava/lang/ClassLoader;
    //   21: invokevirtual 56	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   24: aload_1
    //   25: ldc 24
    //   27: invokevirtual 60	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   30: checkcast 62	com/tencent/matrix/resource/analyzer/model/f
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +775 -> 812
    //   40: aload 6
    //   42: getfield 66	com/tencent/matrix/resource/analyzer/model/f:cvT	Ljava/io/File;
    //   45: invokevirtual 72	java/io/File:getParentFile	()Ljava/io/File;
    //   48: astore_1
    //   49: aload 6
    //   51: getfield 66	com/tencent/matrix/resource/analyzer/model/f:cvT	Ljava/io/File;
    //   54: invokevirtual 75	java/io/File:getName	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload 4
    //   61: iconst_0
    //   62: aload 4
    //   64: ldc 77
    //   66: invokevirtual 81	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
    //   72: astore 4
    //   74: new 68	java/io/File
    //   77: dup
    //   78: aload_1
    //   79: new 87	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   86: aload 4
    //   88: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 94
    //   93: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   102: astore 7
    //   104: new 87	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 102
    //   110: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: invokestatic 111	android/os/Process:myPid	()I
    //   116: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: new 87	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: aload 4
    //   137: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: bipush 95
    //   142: invokevirtual 117	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   145: new 119	java/text/SimpleDateFormat
    //   148: dup
    //   149: ldc 121
    //   151: getstatic 127	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   154: invokespecial 130	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   157: new 132	java/util/Date
    //   160: dup
    //   161: invokespecial 133	java/util/Date:<init>	()V
    //   164: invokevirtual 137	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   167: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 139
    //   172: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: new 68	java/io/File
    //   179: dup
    //   180: aload_1
    //   181: aload 5
    //   183: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   189: astore 8
    //   191: aload 6
    //   193: getfield 66	com/tencent/matrix/resource/analyzer/model/f:cvT	Ljava/io/File;
    //   196: astore 9
    //   198: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   201: lstore_2
    //   202: new 147	com/tencent/matrix/resource/c/a
    //   205: dup
    //   206: invokespecial 148	com/tencent/matrix/resource/c/a:<init>	()V
    //   209: astore_1
    //   210: new 150	java/io/FileInputStream
    //   213: dup
    //   214: aload 9
    //   216: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   219: astore 5
    //   221: new 155	java/io/BufferedOutputStream
    //   224: dup
    //   225: new 157	java/io/FileOutputStream
    //   228: dup
    //   229: aload 7
    //   231: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   234: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   237: astore 4
    //   239: new 163	com/tencent/matrix/resource/c/c
    //   242: dup
    //   243: new 165	java/io/BufferedInputStream
    //   246: dup
    //   247: aload 5
    //   249: invokespecial 168	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   252: invokespecial 169	com/tencent/matrix/resource/c/c:<init>	(Ljava/io/InputStream;)V
    //   255: astore 10
    //   257: aload 10
    //   259: new 171	com/tencent/matrix/resource/c/a$b
    //   262: dup
    //   263: aload_1
    //   264: invokespecial 174	com/tencent/matrix/resource/c/a$b:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   267: invokevirtual 177	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   270: aload 5
    //   272: invokevirtual 181	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   275: lconst_0
    //   276: invokevirtual 187	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   279: pop
    //   280: aload 10
    //   282: new 189	com/tencent/matrix/resource/c/a$c
    //   285: dup
    //   286: aload_1
    //   287: invokespecial 190	com/tencent/matrix/resource/c/a$c:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   290: invokevirtual 177	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   293: aload 5
    //   295: invokevirtual 181	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   298: lconst_0
    //   299: invokevirtual 187	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   302: pop
    //   303: aload 10
    //   305: new 192	com/tencent/matrix/resource/c/a$a
    //   308: dup
    //   309: aload_1
    //   310: new 194	com/tencent/matrix/resource/c/e
    //   313: dup
    //   314: aload 4
    //   316: invokespecial 195	com/tencent/matrix/resource/c/e:<init>	(Ljava/io/OutputStream;)V
    //   319: invokespecial 198	com/tencent/matrix/resource/c/a$a:<init>	(Lcom/tencent/matrix/resource/c/a;Lcom/tencent/matrix/resource/c/e;)V
    //   322: invokevirtual 177	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   325: aload 4
    //   327: invokevirtual 203	java/io/OutputStream:close	()V
    //   330: aload 5
    //   332: invokevirtual 204	java/io/FileInputStream:close	()V
    //   335: ldc 206
    //   337: ldc 208
    //   339: iconst_5
    //   340: anewarray 210	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: aload 9
    //   347: invokevirtual 213	java/io/File:getPath	()Ljava/lang/String;
    //   350: aastore
    //   351: dup
    //   352: iconst_1
    //   353: aload 9
    //   355: invokevirtual 216	java/io/File:length	()J
    //   358: ldc2_w 217
    //   361: ldiv
    //   362: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: aastore
    //   366: dup
    //   367: iconst_2
    //   368: aload 7
    //   370: invokevirtual 213	java/io/File:getPath	()Ljava/lang/String;
    //   373: aastore
    //   374: dup
    //   375: iconst_3
    //   376: aload 7
    //   378: invokevirtual 216	java/io/File:length	()J
    //   381: ldc2_w 217
    //   384: ldiv
    //   385: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   388: aastore
    //   389: dup
    //   390: iconst_4
    //   391: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   394: lload_2
    //   395: lsub
    //   396: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: aastore
    //   400: invokestatic 230	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: new 232	java/util/zip/ZipOutputStream
    //   406: dup
    //   407: new 155	java/io/BufferedOutputStream
    //   410: dup
    //   411: new 157	java/io/FileOutputStream
    //   414: dup
    //   415: aload 8
    //   417: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   420: invokespecial 161	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   423: invokespecial 233	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   426: astore 4
    //   428: aload 4
    //   430: astore_1
    //   431: new 235	java/util/zip/ZipEntry
    //   434: dup
    //   435: ldc 237
    //   437: invokespecial 238	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   440: astore 10
    //   442: aload 4
    //   444: astore_1
    //   445: new 235	java/util/zip/ZipEntry
    //   448: dup
    //   449: aload 7
    //   451: invokevirtual 75	java/io/File:getName	()Ljava/lang/String;
    //   454: invokespecial 238	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   457: astore 5
    //   459: aload 4
    //   461: astore_1
    //   462: aload 4
    //   464: aload 10
    //   466: invokevirtual 242	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   469: aload 4
    //   471: astore_1
    //   472: new 244	java/io/PrintWriter
    //   475: dup
    //   476: new 246	java/io/OutputStreamWriter
    //   479: dup
    //   480: aload 4
    //   482: ldc 248
    //   484: invokestatic 254	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   487: invokespecial 257	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   490: invokespecial 260	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   493: astore 10
    //   495: aload 4
    //   497: astore_1
    //   498: aload 10
    //   500: ldc_w 262
    //   503: invokevirtual 265	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   506: aload 4
    //   508: astore_1
    //   509: aload 10
    //   511: new 87	java/lang/StringBuilder
    //   514: dup
    //   515: ldc_w 267
    //   518: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   521: getstatic 273	android/os/Build$VERSION:SDK_INT	I
    //   524: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   527: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokevirtual 265	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   533: aload 4
    //   535: astore_1
    //   536: aload 10
    //   538: new 87	java/lang/StringBuilder
    //   541: dup
    //   542: ldc_w 275
    //   545: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   548: getstatic 281	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   551: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 265	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   560: aload 4
    //   562: astore_1
    //   563: aload 10
    //   565: new 87	java/lang/StringBuilder
    //   568: dup
    //   569: ldc_w 283
    //   572: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   575: aload 5
    //   577: invokevirtual 284	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   580: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokevirtual 265	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   589: aload 4
    //   591: astore_1
    //   592: aload 10
    //   594: new 87	java/lang/StringBuilder
    //   597: dup
    //   598: ldc_w 286
    //   601: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   604: aload 6
    //   606: getfield 289	com/tencent/matrix/resource/analyzer/model/f:cuP	Ljava/lang/String;
    //   609: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 265	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   618: aload 4
    //   620: astore_1
    //   621: aload 10
    //   623: invokevirtual 292	java/io/PrintWriter:flush	()V
    //   626: aload 4
    //   628: astore_1
    //   629: aload 4
    //   631: invokevirtual 295	java/util/zip/ZipOutputStream:closeEntry	()V
    //   634: aload 4
    //   636: astore_1
    //   637: aload 4
    //   639: aload 5
    //   641: invokevirtual 242	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   644: aload 4
    //   646: astore_1
    //   647: aload 7
    //   649: aload 4
    //   651: invokestatic 300	com/tencent/matrix/resource/a/a/c:a	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   654: aload 4
    //   656: astore_1
    //   657: aload 4
    //   659: invokevirtual 295	java/util/zip/ZipOutputStream:closeEntry	()V
    //   662: aload 4
    //   664: astore_1
    //   665: aload 7
    //   667: invokevirtual 304	java/io/File:delete	()Z
    //   670: pop
    //   671: aload 4
    //   673: astore_1
    //   674: aload 9
    //   676: invokevirtual 304	java/io/File:delete	()Z
    //   679: pop
    //   680: aload 4
    //   682: astore_1
    //   683: ldc 206
    //   685: ldc_w 306
    //   688: iconst_1
    //   689: anewarray 210	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   697: lload_2
    //   698: lsub
    //   699: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   702: aastore
    //   703: invokestatic 230	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: aload 4
    //   708: astore_1
    //   709: aload_0
    //   710: aload 8
    //   712: invokevirtual 309	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   715: aload 6
    //   717: getfield 312	com/tencent/matrix/resource/analyzer/model/f:mActivityName	Ljava/lang/String;
    //   720: invokestatic 318	com/tencent/matrix/resource/CanaryResultService:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   723: aload 4
    //   725: invokestatic 322	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   728: return
    //   729: astore_1
    //   730: aconst_null
    //   731: astore 4
    //   733: aconst_null
    //   734: astore 5
    //   736: aload 4
    //   738: ifnull +8 -> 746
    //   741: aload 4
    //   743: invokevirtual 203	java/io/OutputStream:close	()V
    //   746: aload 5
    //   748: ifnull +8 -> 756
    //   751: aload 5
    //   753: invokevirtual 204	java/io/FileInputStream:close	()V
    //   756: aload_1
    //   757: athrow
    //   758: astore 5
    //   760: aconst_null
    //   761: astore 4
    //   763: aload 4
    //   765: astore_1
    //   766: ldc 206
    //   768: aload 5
    //   770: ldc_w 324
    //   773: iconst_0
    //   774: anewarray 210	java/lang/Object
    //   777: invokestatic 328	com/tencent/matrix/g/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   780: aload 4
    //   782: invokestatic 322	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   785: return
    //   786: astore_1
    //   787: ldc 206
    //   789: aload_1
    //   790: ldc_w 330
    //   793: iconst_0
    //   794: anewarray 210	java/lang/Object
    //   797: invokestatic 328	com/tencent/matrix/g/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   800: return
    //   801: astore 4
    //   803: aconst_null
    //   804: astore_1
    //   805: aload_1
    //   806: invokestatic 322	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   809: aload 4
    //   811: athrow
    //   812: ldc 206
    //   814: ldc_w 330
    //   817: iconst_0
    //   818: anewarray 210	java/lang/Object
    //   821: invokestatic 333	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   824: return
    //   825: astore_1
    //   826: goto -496 -> 330
    //   829: astore_1
    //   830: goto -495 -> 335
    //   833: astore 4
    //   835: goto -89 -> 746
    //   838: astore 4
    //   840: goto -84 -> 756
    //   843: astore 4
    //   845: goto -40 -> 805
    //   848: astore 5
    //   850: goto -87 -> 763
    //   853: astore_1
    //   854: aconst_null
    //   855: astore 4
    //   857: goto -121 -> 736
    //   860: astore_1
    //   861: goto -125 -> 736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	864	0	this	CanaryWorkerService
    //   0	864	1	paramIntent	Intent
    //   201	497	2	l	long
    //   57	724	4	localObject1	java.lang.Object
    //   801	9	4	localObject2	java.lang.Object
    //   833	1	4	localThrowable1	java.lang.Throwable
    //   838	1	4	localThrowable2	java.lang.Throwable
    //   843	1	4	localObject3	java.lang.Object
    //   855	1	4	localObject4	java.lang.Object
    //   131	621	5	localObject5	java.lang.Object
    //   758	11	5	localIOException1	java.io.IOException
    //   848	1	5	localIOException2	java.io.IOException
    //   33	683	6	localf	f
    //   102	564	7	localFile1	java.io.File
    //   189	522	8	localFile2	java.io.File
    //   196	479	9	localFile3	java.io.File
    //   255	367	10	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   210	221	729	finally
    //   198	210	758	java/io/IOException
    //   325	330	758	java/io/IOException
    //   330	335	758	java/io/IOException
    //   335	428	758	java/io/IOException
    //   741	746	758	java/io/IOException
    //   751	756	758	java/io/IOException
    //   756	758	758	java/io/IOException
    //   16	35	786	java/lang/Throwable
    //   40	198	786	java/lang/Throwable
    //   723	728	786	java/lang/Throwable
    //   780	785	786	java/lang/Throwable
    //   805	812	786	java/lang/Throwable
    //   812	824	786	java/lang/Throwable
    //   198	210	801	finally
    //   325	330	801	finally
    //   330	335	801	finally
    //   335	428	801	finally
    //   741	746	801	finally
    //   751	756	801	finally
    //   756	758	801	finally
    //   325	330	825	java/lang/Throwable
    //   330	335	829	java/lang/Throwable
    //   741	746	833	java/lang/Throwable
    //   751	756	838	java/lang/Throwable
    //   431	442	843	finally
    //   445	459	843	finally
    //   462	469	843	finally
    //   472	495	843	finally
    //   498	506	843	finally
    //   509	533	843	finally
    //   536	560	843	finally
    //   563	589	843	finally
    //   592	618	843	finally
    //   621	626	843	finally
    //   629	634	843	finally
    //   637	644	843	finally
    //   647	654	843	finally
    //   657	662	843	finally
    //   665	671	843	finally
    //   674	680	843	finally
    //   683	706	843	finally
    //   709	723	843	finally
    //   766	780	843	finally
    //   431	442	848	java/io/IOException
    //   445	459	848	java/io/IOException
    //   462	469	848	java/io/IOException
    //   472	495	848	java/io/IOException
    //   498	506	848	java/io/IOException
    //   509	533	848	java/io/IOException
    //   536	560	848	java/io/IOException
    //   563	589	848	java/io/IOException
    //   592	618	848	java/io/IOException
    //   621	626	848	java/io/IOException
    //   629	634	848	java/io/IOException
    //   637	644	848	java/io/IOException
    //   647	654	848	java/io/IOException
    //   657	662	848	java/io/IOException
    //   665	671	848	java/io/IOException
    //   674	680	848	java/io/IOException
    //   683	706	848	java/io/IOException
    //   709	723	848	java/io/IOException
    //   221	239	853	finally
    //   239	325	860	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryWorkerService
 * JD-Core Version:    0.7.0.1
 */