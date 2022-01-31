package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.resource.analyzer.model.a;

public class CanaryWorkerService
  extends MatrixJobIntentService
{
  public static void a(Context paramContext, a parama)
  {
    Intent localIntent = new Intent(paramContext, CanaryWorkerService.class);
    localIntent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
    localIntent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", parama);
    a(paramContext, CanaryWorkerService.class, -84148995, localIntent);
  }
  
  /* Error */
  protected final void l(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +718 -> 719
    //   4: ldc 18
    //   6: aload_1
    //   7: invokevirtual 42	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +706 -> 719
    //   16: aload_1
    //   17: ldc 24
    //   19: invokevirtual 52	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   22: checkcast 54	com/tencent/matrix/resource/analyzer/model/a
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +759 -> 788
    //   32: aload 6
    //   34: getfield 58	com/tencent/matrix/resource/analyzer/model/a:bOU	Ljava/io/File;
    //   37: invokevirtual 64	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore_1
    //   41: aload 6
    //   43: getfield 58	com/tencent/matrix/resource/analyzer/model/a:bOU	Ljava/io/File;
    //   46: invokevirtual 67	java/io/File:getName	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: iconst_0
    //   54: aload 4
    //   56: ldc 69
    //   58: invokevirtual 73	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   61: invokevirtual 77	java/lang/String:substring	(II)Ljava/lang/String;
    //   64: astore 4
    //   66: new 60	java/io/File
    //   69: dup
    //   70: aload_1
    //   71: new 79	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   78: aload 4
    //   80: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 86
    //   85: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 7
    //   96: new 79	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 94
    //   102: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: invokestatic 103	android/os/Process:myPid	()I
    //   108: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 4
    //   116: new 79	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   123: astore 5
    //   125: aload 5
    //   127: aload 4
    //   129: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: bipush 95
    //   134: invokevirtual 109	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   137: new 111	java/text/SimpleDateFormat
    //   140: dup
    //   141: ldc 113
    //   143: getstatic 119	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   146: invokespecial 122	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   149: new 124	java/util/Date
    //   152: dup
    //   153: invokespecial 125	java/util/Date:<init>	()V
    //   156: invokevirtual 129	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   159: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 131
    //   164: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: new 60	java/io/File
    //   171: dup
    //   172: aload_1
    //   173: aload 5
    //   175: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore 8
    //   183: aload 6
    //   185: getfield 58	com/tencent/matrix/resource/analyzer/model/a:bOU	Ljava/io/File;
    //   188: astore 9
    //   190: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   193: lstore_2
    //   194: new 139	com/tencent/matrix/resource/c/a
    //   197: dup
    //   198: invokespecial 140	com/tencent/matrix/resource/c/a:<init>	()V
    //   201: astore_1
    //   202: new 142	java/io/FileInputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   211: astore 5
    //   213: new 147	java/io/BufferedOutputStream
    //   216: dup
    //   217: new 149	java/io/FileOutputStream
    //   220: dup
    //   221: aload 7
    //   223: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   226: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   229: astore 4
    //   231: new 155	com/tencent/matrix/resource/c/c
    //   234: dup
    //   235: new 157	java/io/BufferedInputStream
    //   238: dup
    //   239: aload 5
    //   241: invokespecial 160	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   244: invokespecial 161	com/tencent/matrix/resource/c/c:<init>	(Ljava/io/InputStream;)V
    //   247: astore 10
    //   249: aload 10
    //   251: new 163	com/tencent/matrix/resource/c/a$b
    //   254: dup
    //   255: aload_1
    //   256: invokespecial 166	com/tencent/matrix/resource/c/a$b:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   259: invokevirtual 169	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   262: aload 5
    //   264: invokevirtual 173	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   267: lconst_0
    //   268: invokevirtual 179	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   271: pop
    //   272: aload 10
    //   274: new 181	com/tencent/matrix/resource/c/a$c
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 182	com/tencent/matrix/resource/c/a$c:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   282: invokevirtual 169	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   285: aload 5
    //   287: invokevirtual 173	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   290: lconst_0
    //   291: invokevirtual 179	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   294: pop
    //   295: aload 10
    //   297: new 184	com/tencent/matrix/resource/c/a$a
    //   300: dup
    //   301: aload_1
    //   302: new 186	com/tencent/matrix/resource/c/e
    //   305: dup
    //   306: aload 4
    //   308: invokespecial 187	com/tencent/matrix/resource/c/e:<init>	(Ljava/io/OutputStream;)V
    //   311: invokespecial 190	com/tencent/matrix/resource/c/a$a:<init>	(Lcom/tencent/matrix/resource/c/a;Lcom/tencent/matrix/resource/c/e;)V
    //   314: invokevirtual 169	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   317: aload 4
    //   319: invokevirtual 195	java/io/OutputStream:close	()V
    //   322: aload 5
    //   324: invokevirtual 196	java/io/FileInputStream:close	()V
    //   327: ldc 198
    //   329: ldc 200
    //   331: iconst_5
    //   332: anewarray 202	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 9
    //   339: invokevirtual 205	java/io/File:getPath	()Ljava/lang/String;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload 9
    //   347: invokevirtual 208	java/io/File:length	()J
    //   350: ldc2_w 209
    //   353: ldiv
    //   354: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: aload 7
    //   362: invokevirtual 205	java/io/File:getPath	()Ljava/lang/String;
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: aload 7
    //   370: invokevirtual 208	java/io/File:length	()J
    //   373: ldc2_w 209
    //   376: ldiv
    //   377: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   380: aastore
    //   381: dup
    //   382: iconst_4
    //   383: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   386: lload_2
    //   387: lsub
    //   388: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   391: aastore
    //   392: invokestatic 222	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: new 224	java/util/zip/ZipOutputStream
    //   398: dup
    //   399: new 147	java/io/BufferedOutputStream
    //   402: dup
    //   403: new 149	java/io/FileOutputStream
    //   406: dup
    //   407: aload 8
    //   409: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   412: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   415: invokespecial 225	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   418: astore 4
    //   420: aload 4
    //   422: astore_1
    //   423: new 227	java/util/zip/ZipEntry
    //   426: dup
    //   427: ldc 229
    //   429: invokespecial 230	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   432: astore 10
    //   434: aload 4
    //   436: astore_1
    //   437: new 227	java/util/zip/ZipEntry
    //   440: dup
    //   441: aload 7
    //   443: invokevirtual 67	java/io/File:getName	()Ljava/lang/String;
    //   446: invokespecial 230	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   449: astore 5
    //   451: aload 4
    //   453: astore_1
    //   454: aload 4
    //   456: aload 10
    //   458: invokevirtual 234	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   461: aload 4
    //   463: astore_1
    //   464: new 236	java/io/PrintWriter
    //   467: dup
    //   468: new 238	java/io/OutputStreamWriter
    //   471: dup
    //   472: aload 4
    //   474: ldc 240
    //   476: invokestatic 246	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   479: invokespecial 249	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   482: invokespecial 252	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   485: astore 10
    //   487: aload 4
    //   489: astore_1
    //   490: aload 10
    //   492: ldc 254
    //   494: invokevirtual 257	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   497: aload 4
    //   499: astore_1
    //   500: aload 10
    //   502: new 79	java/lang/StringBuilder
    //   505: dup
    //   506: ldc_w 259
    //   509: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   512: getstatic 265	android/os/Build$VERSION:SDK_INT	I
    //   515: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokevirtual 257	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   524: aload 4
    //   526: astore_1
    //   527: aload 10
    //   529: new 79	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 267
    //   536: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: getstatic 273	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   542: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokevirtual 257	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   551: aload 4
    //   553: astore_1
    //   554: aload 10
    //   556: new 79	java/lang/StringBuilder
    //   559: dup
    //   560: ldc_w 275
    //   563: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   566: aload 5
    //   568: invokevirtual 276	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   571: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokevirtual 257	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   580: aload 4
    //   582: astore_1
    //   583: aload 10
    //   585: new 79	java/lang/StringBuilder
    //   588: dup
    //   589: ldc_w 278
    //   592: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: aload 6
    //   597: getfield 281	com/tencent/matrix/resource/analyzer/model/a:bOV	Ljava/lang/String;
    //   600: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokevirtual 257	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   609: aload 4
    //   611: astore_1
    //   612: aload 10
    //   614: invokevirtual 284	java/io/PrintWriter:flush	()V
    //   617: aload 4
    //   619: astore_1
    //   620: aload 4
    //   622: invokevirtual 287	java/util/zip/ZipOutputStream:closeEntry	()V
    //   625: aload 4
    //   627: astore_1
    //   628: aload 4
    //   630: aload 5
    //   632: invokevirtual 234	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   635: aload 4
    //   637: astore_1
    //   638: aload 7
    //   640: aload 4
    //   642: invokestatic 292	com/tencent/matrix/resource/a/a/c:a	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   645: aload 4
    //   647: astore_1
    //   648: aload 4
    //   650: invokevirtual 287	java/util/zip/ZipOutputStream:closeEntry	()V
    //   653: aload 4
    //   655: astore_1
    //   656: aload 7
    //   658: invokevirtual 296	java/io/File:delete	()Z
    //   661: pop
    //   662: aload 4
    //   664: astore_1
    //   665: aload 9
    //   667: invokevirtual 296	java/io/File:delete	()Z
    //   670: pop
    //   671: aload 4
    //   673: astore_1
    //   674: ldc 198
    //   676: ldc_w 298
    //   679: iconst_1
    //   680: anewarray 202	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   688: lload_2
    //   689: lsub
    //   690: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   693: aastore
    //   694: invokestatic 222	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   697: aload 4
    //   699: astore_1
    //   700: aload_0
    //   701: aload 8
    //   703: invokevirtual 301	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   706: aload 6
    //   708: getfield 304	com/tencent/matrix/resource/analyzer/model/a:mActivityName	Ljava/lang/String;
    //   711: invokestatic 310	com/tencent/matrix/resource/CanaryResultService:d	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload 4
    //   716: invokestatic 314	com/tencent/matrix/resource/a/a/c:V	(Ljava/lang/Object;)V
    //   719: return
    //   720: astore_1
    //   721: aconst_null
    //   722: astore 4
    //   724: aconst_null
    //   725: astore 5
    //   727: aload 4
    //   729: ifnull +8 -> 737
    //   732: aload 4
    //   734: invokevirtual 195	java/io/OutputStream:close	()V
    //   737: aload 5
    //   739: ifnull +8 -> 747
    //   742: aload 5
    //   744: invokevirtual 196	java/io/FileInputStream:close	()V
    //   747: aload_1
    //   748: athrow
    //   749: astore 5
    //   751: aconst_null
    //   752: astore 4
    //   754: aload 4
    //   756: astore_1
    //   757: ldc 198
    //   759: aload 5
    //   761: ldc_w 316
    //   764: iconst_0
    //   765: anewarray 202	java/lang/Object
    //   768: invokestatic 320	com/tencent/matrix/g/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   771: aload 4
    //   773: invokestatic 314	com/tencent/matrix/resource/a/a/c:V	(Ljava/lang/Object;)V
    //   776: return
    //   777: astore 4
    //   779: aconst_null
    //   780: astore_1
    //   781: aload_1
    //   782: invokestatic 314	com/tencent/matrix/resource/a/a/c:V	(Ljava/lang/Object;)V
    //   785: aload 4
    //   787: athrow
    //   788: ldc 198
    //   790: ldc_w 322
    //   793: iconst_0
    //   794: anewarray 202	java/lang/Object
    //   797: invokestatic 325	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   800: return
    //   801: astore_1
    //   802: goto -480 -> 322
    //   805: astore_1
    //   806: goto -479 -> 327
    //   809: astore 4
    //   811: goto -74 -> 737
    //   814: astore 4
    //   816: goto -69 -> 747
    //   819: astore 4
    //   821: goto -40 -> 781
    //   824: astore 5
    //   826: goto -72 -> 754
    //   829: astore_1
    //   830: aconst_null
    //   831: astore 4
    //   833: goto -106 -> 727
    //   836: astore_1
    //   837: goto -110 -> 727
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	this	CanaryWorkerService
    //   0	840	1	paramIntent	Intent
    //   193	496	2	l	long
    //   49	723	4	localObject1	java.lang.Object
    //   777	9	4	localObject2	java.lang.Object
    //   809	1	4	localThrowable1	java.lang.Throwable
    //   814	1	4	localThrowable2	java.lang.Throwable
    //   819	1	4	localObject3	java.lang.Object
    //   831	1	4	localObject4	java.lang.Object
    //   123	620	5	localObject5	java.lang.Object
    //   749	11	5	localIOException1	java.io.IOException
    //   824	1	5	localIOException2	java.io.IOException
    //   25	682	6	locala	a
    //   94	563	7	localFile1	java.io.File
    //   181	521	8	localFile2	java.io.File
    //   188	478	9	localFile3	java.io.File
    //   247	366	10	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   202	213	720	finally
    //   190	202	749	java/io/IOException
    //   317	322	749	java/io/IOException
    //   322	327	749	java/io/IOException
    //   327	420	749	java/io/IOException
    //   732	737	749	java/io/IOException
    //   742	747	749	java/io/IOException
    //   747	749	749	java/io/IOException
    //   190	202	777	finally
    //   317	322	777	finally
    //   322	327	777	finally
    //   327	420	777	finally
    //   732	737	777	finally
    //   742	747	777	finally
    //   747	749	777	finally
    //   317	322	801	java/lang/Throwable
    //   322	327	805	java/lang/Throwable
    //   732	737	809	java/lang/Throwable
    //   742	747	814	java/lang/Throwable
    //   423	434	819	finally
    //   437	451	819	finally
    //   454	461	819	finally
    //   464	487	819	finally
    //   490	497	819	finally
    //   500	524	819	finally
    //   527	551	819	finally
    //   554	580	819	finally
    //   583	609	819	finally
    //   612	617	819	finally
    //   620	625	819	finally
    //   628	635	819	finally
    //   638	645	819	finally
    //   648	653	819	finally
    //   656	662	819	finally
    //   665	671	819	finally
    //   674	697	819	finally
    //   700	714	819	finally
    //   757	771	819	finally
    //   423	434	824	java/io/IOException
    //   437	451	824	java/io/IOException
    //   454	461	824	java/io/IOException
    //   464	487	824	java/io/IOException
    //   490	497	824	java/io/IOException
    //   500	524	824	java/io/IOException
    //   527	551	824	java/io/IOException
    //   554	580	824	java/io/IOException
    //   583	609	824	java/io/IOException
    //   612	617	824	java/io/IOException
    //   620	625	824	java/io/IOException
    //   628	635	824	java/io/IOException
    //   638	645	824	java/io/IOException
    //   648	653	824	java/io/IOException
    //   656	662	824	java/io/IOException
    //   665	671	824	java/io/IOException
    //   674	697	824	java/io/IOException
    //   700	714	824	java/io/IOException
    //   213	231	829	finally
    //   231	317	836	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryWorkerService
 * JD-Core Version:    0.7.0.1
 */