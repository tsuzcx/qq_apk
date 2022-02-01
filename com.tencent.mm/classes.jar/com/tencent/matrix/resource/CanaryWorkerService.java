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
  protected final void o(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +688 -> 689
    //   4: ldc 18
    //   6: aload_1
    //   7: invokevirtual 40	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +676 -> 689
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 50	com/tencent/matrix/resource/CanaryWorkerService:getClassLoader	()Ljava/lang/ClassLoader;
    //   21: invokevirtual 54	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   24: aload_1
    //   25: ldc 24
    //   27: invokevirtual 58	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   30: checkcast 60	com/tencent/matrix/resource/analyzer/model/f
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +733 -> 768
    //   38: aload_1
    //   39: getfield 64	com/tencent/matrix/resource/analyzer/model/f:faw	Ljava/io/File;
    //   42: invokevirtual 70	java/io/File:getParentFile	()Ljava/io/File;
    //   45: astore 4
    //   47: aload_1
    //   48: getfield 64	com/tencent/matrix/resource/analyzer/model/f:faw	Ljava/io/File;
    //   51: invokevirtual 73	java/io/File:getName	()Ljava/lang/String;
    //   54: astore 5
    //   56: aload 5
    //   58: iconst_0
    //   59: aload 5
    //   61: ldc 75
    //   63: invokevirtual 79	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: invokevirtual 83	java/lang/String:substring	(II)Ljava/lang/String;
    //   69: astore 5
    //   71: new 66	java/io/File
    //   74: dup
    //   75: aload 4
    //   77: new 85	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   84: aload 5
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 92
    //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   100: astore 6
    //   102: new 85	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 100
    //   108: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 109	android/os/Process:myPid	()I
    //   114: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 5
    //   122: new 85	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   129: astore 7
    //   131: aload 7
    //   133: aload 5
    //   135: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: bipush 95
    //   140: invokevirtual 115	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   143: new 117	java/text/SimpleDateFormat
    //   146: dup
    //   147: ldc 119
    //   149: getstatic 125	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   152: invokespecial 128	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   155: new 130	java/util/Date
    //   158: dup
    //   159: invokespecial 131	java/util/Date:<init>	()V
    //   162: invokevirtual 135	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   165: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 137
    //   170: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: new 66	java/io/File
    //   177: dup
    //   178: aload 4
    //   180: aload 7
    //   182: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   188: astore 7
    //   190: aload_1
    //   191: getfield 64	com/tencent/matrix/resource/analyzer/model/f:faw	Ljava/io/File;
    //   194: astore 8
    //   196: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   199: lstore_2
    //   200: new 145	com/tencent/matrix/resource/d/a
    //   203: dup
    //   204: invokespecial 146	com/tencent/matrix/resource/d/a:<init>	()V
    //   207: astore 9
    //   209: new 148	java/io/FileInputStream
    //   212: dup
    //   213: aload 8
    //   215: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   218: astore 5
    //   220: new 153	java/io/BufferedOutputStream
    //   223: dup
    //   224: new 155	java/io/FileOutputStream
    //   227: dup
    //   228: aload 6
    //   230: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   233: invokespecial 159	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   236: astore 4
    //   238: new 161	com/tencent/matrix/resource/d/c
    //   241: dup
    //   242: new 163	java/io/BufferedInputStream
    //   245: dup
    //   246: aload 5
    //   248: invokespecial 166	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   251: invokespecial 167	com/tencent/matrix/resource/d/c:<init>	(Ljava/io/InputStream;)V
    //   254: astore 10
    //   256: aload 10
    //   258: new 169	com/tencent/matrix/resource/d/a$b
    //   261: dup
    //   262: aload 9
    //   264: invokespecial 172	com/tencent/matrix/resource/d/a$b:<init>	(Lcom/tencent/matrix/resource/d/a;)V
    //   267: invokevirtual 175	com/tencent/matrix/resource/d/c:a	(Lcom/tencent/matrix/resource/d/d;)V
    //   270: aload 5
    //   272: invokevirtual 179	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   275: lconst_0
    //   276: invokevirtual 185	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   279: pop
    //   280: aload 10
    //   282: new 187	com/tencent/matrix/resource/d/a$c
    //   285: dup
    //   286: aload 9
    //   288: invokespecial 188	com/tencent/matrix/resource/d/a$c:<init>	(Lcom/tencent/matrix/resource/d/a;)V
    //   291: invokevirtual 175	com/tencent/matrix/resource/d/c:a	(Lcom/tencent/matrix/resource/d/d;)V
    //   294: aload 5
    //   296: invokevirtual 179	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   299: lconst_0
    //   300: invokevirtual 185	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   303: pop
    //   304: aload 10
    //   306: new 190	com/tencent/matrix/resource/d/a$a
    //   309: dup
    //   310: aload 9
    //   312: new 192	com/tencent/matrix/resource/d/e
    //   315: dup
    //   316: aload 4
    //   318: invokespecial 193	com/tencent/matrix/resource/d/e:<init>	(Ljava/io/OutputStream;)V
    //   321: invokespecial 196	com/tencent/matrix/resource/d/a$a:<init>	(Lcom/tencent/matrix/resource/d/a;Lcom/tencent/matrix/resource/d/e;)V
    //   324: invokevirtual 175	com/tencent/matrix/resource/d/c:a	(Lcom/tencent/matrix/resource/d/d;)V
    //   327: aload 4
    //   329: invokevirtual 201	java/io/OutputStream:close	()V
    //   332: aload 5
    //   334: invokevirtual 202	java/io/FileInputStream:close	()V
    //   337: ldc 204
    //   339: ldc 206
    //   341: iconst_5
    //   342: anewarray 208	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload 8
    //   349: invokevirtual 211	java/io/File:getPath	()Ljava/lang/String;
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: aload 8
    //   357: invokevirtual 214	java/io/File:length	()J
    //   360: ldc2_w 215
    //   363: ldiv
    //   364: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   367: aastore
    //   368: dup
    //   369: iconst_2
    //   370: aload 6
    //   372: invokevirtual 211	java/io/File:getPath	()Ljava/lang/String;
    //   375: aastore
    //   376: dup
    //   377: iconst_3
    //   378: aload 6
    //   380: invokevirtual 214	java/io/File:length	()J
    //   383: ldc2_w 215
    //   386: ldiv
    //   387: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: aastore
    //   391: dup
    //   392: iconst_4
    //   393: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   396: lload_2
    //   397: lsub
    //   398: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: aastore
    //   402: invokestatic 228	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: new 230	java/util/zip/ZipOutputStream
    //   408: dup
    //   409: new 153	java/io/BufferedOutputStream
    //   412: dup
    //   413: new 155	java/io/FileOutputStream
    //   416: dup
    //   417: aload 7
    //   419: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   422: invokespecial 159	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   425: invokespecial 231	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   428: astore 4
    //   430: new 233	java/util/zip/ZipEntry
    //   433: dup
    //   434: ldc 235
    //   436: invokespecial 236	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   439: astore 9
    //   441: new 233	java/util/zip/ZipEntry
    //   444: dup
    //   445: aload 6
    //   447: invokevirtual 73	java/io/File:getName	()Ljava/lang/String;
    //   450: invokespecial 236	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   453: astore 5
    //   455: aload 4
    //   457: aload 9
    //   459: invokevirtual 240	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   462: new 242	java/io/PrintWriter
    //   465: dup
    //   466: new 244	java/io/OutputStreamWriter
    //   469: dup
    //   470: aload 4
    //   472: ldc 246
    //   474: invokestatic 252	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   477: invokespecial 255	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   480: invokespecial 258	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   483: astore 9
    //   485: aload 9
    //   487: ldc_w 260
    //   490: invokevirtual 263	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   493: aload 9
    //   495: new 85	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 265
    //   502: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: getstatic 271	android/os/Build$VERSION:SDK_INT	I
    //   508: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokevirtual 263	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   517: aload 9
    //   519: new 85	java/lang/StringBuilder
    //   522: dup
    //   523: ldc_w 273
    //   526: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: invokestatic 279	com/tencent/matrix/c:avW	()Lcom/tencent/matrix/c;
    //   532: ldc_w 281
    //   535: invokevirtual 285	com/tencent/matrix/c:ai	(Ljava/lang/Class;)Lcom/tencent/matrix/d/b;
    //   538: checkcast 281	com/tencent/matrix/resource/c
    //   541: getfield 289	com/tencent/matrix/resource/c:eZp	Lcom/tencent/matrix/resource/b/a;
    //   544: getfield 295	com/tencent/matrix/resource/b/a:fbg	Ljava/lang/String;
    //   547: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokevirtual 263	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   556: aload 9
    //   558: new 85	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 297
    //   565: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload 5
    //   570: invokevirtual 298	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   573: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokevirtual 263	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   582: aload 9
    //   584: new 85	java/lang/StringBuilder
    //   587: dup
    //   588: ldc_w 300
    //   591: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   594: aload_1
    //   595: getfield 303	com/tencent/matrix/resource/analyzer/model/f:eZr	Ljava/lang/String;
    //   598: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokevirtual 263	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   607: aload 9
    //   609: invokevirtual 306	java/io/PrintWriter:flush	()V
    //   612: aload 4
    //   614: invokevirtual 309	java/util/zip/ZipOutputStream:closeEntry	()V
    //   617: aload 4
    //   619: aload 5
    //   621: invokevirtual 240	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   624: aload 6
    //   626: aload 4
    //   628: invokestatic 314	com/tencent/matrix/resource/a/a/c:a	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   631: aload 4
    //   633: invokevirtual 309	java/util/zip/ZipOutputStream:closeEntry	()V
    //   636: aload 6
    //   638: invokevirtual 318	java/io/File:delete	()Z
    //   641: pop
    //   642: aload 8
    //   644: invokevirtual 318	java/io/File:delete	()Z
    //   647: pop
    //   648: ldc 204
    //   650: ldc_w 320
    //   653: iconst_1
    //   654: anewarray 208	java/lang/Object
    //   657: dup
    //   658: iconst_0
    //   659: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   662: lload_2
    //   663: lsub
    //   664: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   667: aastore
    //   668: invokestatic 228	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   671: aload_0
    //   672: aload 7
    //   674: invokevirtual 323	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   677: aload_1
    //   678: getfield 326	com/tencent/matrix/resource/analyzer/model/f:mActivityName	Ljava/lang/String;
    //   681: invokestatic 332	com/tencent/matrix/resource/CanaryResultService:e	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload 4
    //   686: invokestatic 336	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   689: return
    //   690: astore_1
    //   691: aconst_null
    //   692: astore 4
    //   694: aconst_null
    //   695: astore 5
    //   697: aload 4
    //   699: ifnull +8 -> 707
    //   702: aload 4
    //   704: invokevirtual 201	java/io/OutputStream:close	()V
    //   707: aload 5
    //   709: ifnull +8 -> 717
    //   712: aload 5
    //   714: invokevirtual 202	java/io/FileInputStream:close	()V
    //   717: aload_1
    //   718: athrow
    //   719: astore 4
    //   721: aconst_null
    //   722: astore_1
    //   723: ldc 204
    //   725: aload 4
    //   727: ldc_w 338
    //   730: iconst_0
    //   731: anewarray 208	java/lang/Object
    //   734: invokestatic 342	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   737: aload_1
    //   738: invokestatic 336	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   741: return
    //   742: astore_1
    //   743: ldc 204
    //   745: aload_1
    //   746: ldc_w 344
    //   749: iconst_0
    //   750: anewarray 208	java/lang/Object
    //   753: invokestatic 342	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: return
    //   757: astore_1
    //   758: aconst_null
    //   759: astore 4
    //   761: aload 4
    //   763: invokestatic 336	com/tencent/matrix/resource/a/a/c:closeQuietly	(Ljava/lang/Object;)V
    //   766: aload_1
    //   767: athrow
    //   768: ldc 204
    //   770: ldc_w 344
    //   773: iconst_0
    //   774: anewarray 208	java/lang/Object
    //   777: invokestatic 346	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   780: return
    //   781: astore 4
    //   783: goto -451 -> 332
    //   786: astore 4
    //   788: goto -451 -> 337
    //   791: astore 4
    //   793: goto -86 -> 707
    //   796: astore 4
    //   798: goto -81 -> 717
    //   801: astore_1
    //   802: goto -41 -> 761
    //   805: astore 5
    //   807: aload_1
    //   808: astore 4
    //   810: aload 5
    //   812: astore_1
    //   813: goto -52 -> 761
    //   816: astore 5
    //   818: aload 4
    //   820: astore_1
    //   821: aload 5
    //   823: astore 4
    //   825: goto -102 -> 723
    //   828: astore_1
    //   829: aconst_null
    //   830: astore 4
    //   832: goto -135 -> 697
    //   835: astore_1
    //   836: goto -139 -> 697
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	839	0	this	CanaryWorkerService
    //   0	839	1	paramIntent	Intent
    //   199	464	2	l	long
    //   45	658	4	localObject1	java.lang.Object
    //   719	7	4	localIOException1	java.io.IOException
    //   759	3	4	localObject2	java.lang.Object
    //   781	1	4	localObject3	java.lang.Object
    //   786	1	4	localObject4	java.lang.Object
    //   791	1	4	localObject5	java.lang.Object
    //   796	1	4	localObject6	java.lang.Object
    //   808	23	4	localObject7	java.lang.Object
    //   54	659	5	localObject8	java.lang.Object
    //   805	6	5	localObject9	java.lang.Object
    //   816	6	5	localIOException2	java.io.IOException
    //   100	537	6	localFile1	java.io.File
    //   129	544	7	localObject10	java.lang.Object
    //   194	449	8	localFile2	java.io.File
    //   207	401	9	localObject11	java.lang.Object
    //   254	51	10	localc	com.tencent.matrix.resource.d.c
    // Exception table:
    //   from	to	target	type
    //   209	220	690	finally
    //   196	209	719	java/io/IOException
    //   337	430	719	java/io/IOException
    //   717	719	719	java/io/IOException
    //   16	34	742	finally
    //   38	196	742	finally
    //   684	689	742	finally
    //   737	741	742	finally
    //   761	768	742	finally
    //   768	780	742	finally
    //   196	209	757	finally
    //   337	430	757	finally
    //   717	719	757	finally
    //   327	332	781	finally
    //   332	337	786	finally
    //   702	707	791	finally
    //   712	717	796	finally
    //   430	684	801	finally
    //   723	737	805	finally
    //   430	684	816	java/io/IOException
    //   220	238	828	finally
    //   238	327	835	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryWorkerService
 * JD-Core Version:    0.7.0.1
 */