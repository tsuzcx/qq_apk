package com.tencent.matrix.resource;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.resource.analyzer.model.a;

public class CanaryWorkerService
  extends IntentService
{
  public CanaryWorkerService()
  {
    super("Matrix.CanaryWorkerService");
  }
  
  public static void a(Context paramContext, a parama)
  {
    Intent localIntent = new Intent(paramContext, CanaryWorkerService.class);
    localIntent.setAction("com.tencent.matrix.resource.worker.action.SHRINK_HPROF");
    localIntent.putExtra("com.tencent.matrix.resource.worker.param.HEAPDUMP", parama);
    paramContext.startService(localIntent);
  }
  
  /* Error */
  protected void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +719 -> 720
    //   4: ldc 21
    //   6: aload_1
    //   7: invokevirtual 47	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: invokevirtual 53	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +707 -> 720
    //   16: aload_1
    //   17: ldc 27
    //   19: invokevirtual 57	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   22: checkcast 59	com/tencent/matrix/resource/analyzer/model/a
    //   25: astore 6
    //   27: aload 6
    //   29: ifnull +760 -> 789
    //   32: aload 6
    //   34: getfield 63	com/tencent/matrix/resource/analyzer/model/a:boQ	Ljava/io/File;
    //   37: invokevirtual 69	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore_1
    //   41: aload 6
    //   43: getfield 63	com/tencent/matrix/resource/analyzer/model/a:boQ	Ljava/io/File;
    //   46: invokevirtual 72	java/io/File:getName	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: iconst_0
    //   54: aload 4
    //   56: ldc 74
    //   58: invokevirtual 78	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   61: invokevirtual 82	java/lang/String:substring	(II)Ljava/lang/String;
    //   64: astore 4
    //   66: new 65	java/io/File
    //   69: dup
    //   70: aload_1
    //   71: new 84	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   78: aload 4
    //   80: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 92
    //   85: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 7
    //   96: new 84	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 100
    //   102: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: invokestatic 107	android/os/Process:myPid	()I
    //   108: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 4
    //   116: new 84	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   123: astore 5
    //   125: aload 5
    //   127: aload 4
    //   129: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: bipush 95
    //   134: invokevirtual 113	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   137: new 115	java/text/SimpleDateFormat
    //   140: dup
    //   141: ldc 117
    //   143: getstatic 123	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   146: invokespecial 126	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   149: new 128	java/util/Date
    //   152: dup
    //   153: invokespecial 129	java/util/Date:<init>	()V
    //   156: invokevirtual 133	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   159: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 135
    //   164: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: new 65	java/io/File
    //   171: dup
    //   172: aload_1
    //   173: aload 5
    //   175: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore 8
    //   183: aload 6
    //   185: getfield 63	com/tencent/matrix/resource/analyzer/model/a:boQ	Ljava/io/File;
    //   188: astore 9
    //   190: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   193: lstore_2
    //   194: new 143	com/tencent/matrix/resource/c/a
    //   197: dup
    //   198: invokespecial 144	com/tencent/matrix/resource/c/a:<init>	()V
    //   201: astore_1
    //   202: new 146	java/io/FileInputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   211: astore 5
    //   213: new 151	java/io/BufferedOutputStream
    //   216: dup
    //   217: new 153	java/io/FileOutputStream
    //   220: dup
    //   221: aload 7
    //   223: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   226: invokespecial 157	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   229: astore 4
    //   231: new 159	com/tencent/matrix/resource/c/c
    //   234: dup
    //   235: new 161	java/io/BufferedInputStream
    //   238: dup
    //   239: aload 5
    //   241: invokespecial 164	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   244: invokespecial 165	com/tencent/matrix/resource/c/c:<init>	(Ljava/io/InputStream;)V
    //   247: astore 10
    //   249: aload 10
    //   251: new 167	com/tencent/matrix/resource/c/a$b
    //   254: dup
    //   255: aload_1
    //   256: invokespecial 170	com/tencent/matrix/resource/c/a$b:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   259: invokevirtual 173	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   262: aload 5
    //   264: invokevirtual 177	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   267: lconst_0
    //   268: invokevirtual 183	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   271: pop
    //   272: aload 10
    //   274: new 185	com/tencent/matrix/resource/c/a$c
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 186	com/tencent/matrix/resource/c/a$c:<init>	(Lcom/tencent/matrix/resource/c/a;)V
    //   282: invokevirtual 173	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   285: aload 5
    //   287: invokevirtual 177	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   290: lconst_0
    //   291: invokevirtual 183	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   294: pop
    //   295: aload 10
    //   297: new 188	com/tencent/matrix/resource/c/a$a
    //   300: dup
    //   301: aload_1
    //   302: new 190	com/tencent/matrix/resource/c/e
    //   305: dup
    //   306: aload 4
    //   308: invokespecial 191	com/tencent/matrix/resource/c/e:<init>	(Ljava/io/OutputStream;)V
    //   311: invokespecial 194	com/tencent/matrix/resource/c/a$a:<init>	(Lcom/tencent/matrix/resource/c/a;Lcom/tencent/matrix/resource/c/e;)V
    //   314: invokevirtual 173	com/tencent/matrix/resource/c/c:a	(Lcom/tencent/matrix/resource/c/d;)V
    //   317: aload 4
    //   319: invokevirtual 199	java/io/OutputStream:close	()V
    //   322: aload 5
    //   324: invokevirtual 200	java/io/FileInputStream:close	()V
    //   327: ldc 8
    //   329: ldc 202
    //   331: iconst_5
    //   332: anewarray 204	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 9
    //   339: invokevirtual 207	java/io/File:getPath	()Ljava/lang/String;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload 9
    //   347: invokevirtual 210	java/io/File:length	()J
    //   350: ldc2_w 211
    //   353: ldiv
    //   354: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: aload 7
    //   362: invokevirtual 207	java/io/File:getPath	()Ljava/lang/String;
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: aload 7
    //   370: invokevirtual 210	java/io/File:length	()J
    //   373: ldc2_w 211
    //   376: ldiv
    //   377: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   380: aastore
    //   381: dup
    //   382: iconst_4
    //   383: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   386: lload_2
    //   387: lsub
    //   388: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   391: aastore
    //   392: invokestatic 224	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: new 226	java/util/zip/ZipOutputStream
    //   398: dup
    //   399: new 151	java/io/BufferedOutputStream
    //   402: dup
    //   403: new 153	java/io/FileOutputStream
    //   406: dup
    //   407: aload 8
    //   409: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   412: invokespecial 157	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   415: invokespecial 227	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   418: astore 4
    //   420: aload 4
    //   422: astore_1
    //   423: new 229	java/util/zip/ZipEntry
    //   426: dup
    //   427: ldc 231
    //   429: invokespecial 232	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   432: astore 10
    //   434: aload 4
    //   436: astore_1
    //   437: new 229	java/util/zip/ZipEntry
    //   440: dup
    //   441: aload 7
    //   443: invokevirtual 72	java/io/File:getName	()Ljava/lang/String;
    //   446: invokespecial 232	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   449: astore 5
    //   451: aload 4
    //   453: astore_1
    //   454: aload 4
    //   456: aload 10
    //   458: invokevirtual 236	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   461: aload 4
    //   463: astore_1
    //   464: new 238	java/io/PrintWriter
    //   467: dup
    //   468: new 240	java/io/OutputStreamWriter
    //   471: dup
    //   472: aload 4
    //   474: ldc 242
    //   476: invokestatic 248	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   479: invokespecial 251	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   482: invokespecial 254	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   485: astore 10
    //   487: aload 4
    //   489: astore_1
    //   490: aload 10
    //   492: ldc_w 256
    //   495: invokevirtual 259	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   498: aload 4
    //   500: astore_1
    //   501: aload 10
    //   503: new 84	java/lang/StringBuilder
    //   506: dup
    //   507: ldc_w 261
    //   510: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   513: getstatic 267	android/os/Build$VERSION:SDK_INT	I
    //   516: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   519: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokevirtual 259	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   525: aload 4
    //   527: astore_1
    //   528: aload 10
    //   530: new 84	java/lang/StringBuilder
    //   533: dup
    //   534: ldc_w 269
    //   537: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: getstatic 275	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   543: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokevirtual 259	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   552: aload 4
    //   554: astore_1
    //   555: aload 10
    //   557: new 84	java/lang/StringBuilder
    //   560: dup
    //   561: ldc_w 277
    //   564: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   567: aload 5
    //   569: invokevirtual 278	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   572: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokevirtual 259	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   581: aload 4
    //   583: astore_1
    //   584: aload 10
    //   586: new 84	java/lang/StringBuilder
    //   589: dup
    //   590: ldc_w 280
    //   593: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   596: aload 6
    //   598: getfield 283	com/tencent/matrix/resource/analyzer/model/a:boR	Ljava/lang/String;
    //   601: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokevirtual 259	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   610: aload 4
    //   612: astore_1
    //   613: aload 10
    //   615: invokevirtual 286	java/io/PrintWriter:flush	()V
    //   618: aload 4
    //   620: astore_1
    //   621: aload 4
    //   623: invokevirtual 289	java/util/zip/ZipOutputStream:closeEntry	()V
    //   626: aload 4
    //   628: astore_1
    //   629: aload 4
    //   631: aload 5
    //   633: invokevirtual 236	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   636: aload 4
    //   638: astore_1
    //   639: aload 7
    //   641: aload 4
    //   643: invokestatic 294	com/tencent/matrix/resource/a/a/c:a	(Ljava/io/File;Ljava/io/OutputStream;)V
    //   646: aload 4
    //   648: astore_1
    //   649: aload 4
    //   651: invokevirtual 289	java/util/zip/ZipOutputStream:closeEntry	()V
    //   654: aload 4
    //   656: astore_1
    //   657: aload 7
    //   659: invokevirtual 298	java/io/File:delete	()Z
    //   662: pop
    //   663: aload 4
    //   665: astore_1
    //   666: aload 9
    //   668: invokevirtual 298	java/io/File:delete	()Z
    //   671: pop
    //   672: aload 4
    //   674: astore_1
    //   675: ldc 8
    //   677: ldc_w 300
    //   680: iconst_1
    //   681: anewarray 204	java/lang/Object
    //   684: dup
    //   685: iconst_0
    //   686: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   689: lload_2
    //   690: lsub
    //   691: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   694: aastore
    //   695: invokestatic 224	com/tencent/matrix/d/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   698: aload 4
    //   700: astore_1
    //   701: aload_0
    //   702: aload 8
    //   704: invokevirtual 303	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   707: aload 6
    //   709: getfield 306	com/tencent/matrix/resource/analyzer/model/a:mActivityName	Ljava/lang/String;
    //   712: invokestatic 312	com/tencent/matrix/resource/CanaryResultService:d	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   715: aload 4
    //   717: invokestatic 316	com/tencent/matrix/resource/a/a/c:S	(Ljava/lang/Object;)V
    //   720: return
    //   721: astore_1
    //   722: aconst_null
    //   723: astore 4
    //   725: aconst_null
    //   726: astore 5
    //   728: aload 4
    //   730: ifnull +8 -> 738
    //   733: aload 4
    //   735: invokevirtual 199	java/io/OutputStream:close	()V
    //   738: aload 5
    //   740: ifnull +8 -> 748
    //   743: aload 5
    //   745: invokevirtual 200	java/io/FileInputStream:close	()V
    //   748: aload_1
    //   749: athrow
    //   750: astore 5
    //   752: aconst_null
    //   753: astore 4
    //   755: aload 4
    //   757: astore_1
    //   758: ldc 8
    //   760: aload 5
    //   762: ldc_w 318
    //   765: iconst_0
    //   766: anewarray 204	java/lang/Object
    //   769: invokestatic 322	com/tencent/matrix/d/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   772: aload 4
    //   774: invokestatic 316	com/tencent/matrix/resource/a/a/c:S	(Ljava/lang/Object;)V
    //   777: return
    //   778: astore 4
    //   780: aconst_null
    //   781: astore_1
    //   782: aload_1
    //   783: invokestatic 316	com/tencent/matrix/resource/a/a/c:S	(Ljava/lang/Object;)V
    //   786: aload 4
    //   788: athrow
    //   789: ldc 8
    //   791: ldc_w 324
    //   794: iconst_0
    //   795: anewarray 204	java/lang/Object
    //   798: invokestatic 327	com/tencent/matrix/d/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   801: return
    //   802: astore_1
    //   803: goto -481 -> 322
    //   806: astore_1
    //   807: goto -480 -> 327
    //   810: astore 4
    //   812: goto -74 -> 738
    //   815: astore 4
    //   817: goto -69 -> 748
    //   820: astore 4
    //   822: goto -40 -> 782
    //   825: astore 5
    //   827: goto -72 -> 755
    //   830: astore_1
    //   831: aconst_null
    //   832: astore 4
    //   834: goto -106 -> 728
    //   837: astore_1
    //   838: goto -110 -> 728
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	CanaryWorkerService
    //   0	841	1	paramIntent	Intent
    //   193	497	2	l	long
    //   49	724	4	localObject1	java.lang.Object
    //   778	9	4	localObject2	java.lang.Object
    //   810	1	4	localThrowable1	java.lang.Throwable
    //   815	1	4	localThrowable2	java.lang.Throwable
    //   820	1	4	localObject3	java.lang.Object
    //   832	1	4	localObject4	java.lang.Object
    //   123	621	5	localObject5	java.lang.Object
    //   750	11	5	localIOException1	java.io.IOException
    //   825	1	5	localIOException2	java.io.IOException
    //   25	683	6	locala	a
    //   94	564	7	localFile1	java.io.File
    //   181	522	8	localFile2	java.io.File
    //   188	479	9	localFile3	java.io.File
    //   247	367	10	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   202	213	721	finally
    //   190	202	750	java/io/IOException
    //   317	322	750	java/io/IOException
    //   322	327	750	java/io/IOException
    //   327	420	750	java/io/IOException
    //   733	738	750	java/io/IOException
    //   743	748	750	java/io/IOException
    //   748	750	750	java/io/IOException
    //   190	202	778	finally
    //   317	322	778	finally
    //   322	327	778	finally
    //   327	420	778	finally
    //   733	738	778	finally
    //   743	748	778	finally
    //   748	750	778	finally
    //   317	322	802	java/lang/Throwable
    //   322	327	806	java/lang/Throwable
    //   733	738	810	java/lang/Throwable
    //   743	748	815	java/lang/Throwable
    //   423	434	820	finally
    //   437	451	820	finally
    //   454	461	820	finally
    //   464	487	820	finally
    //   490	498	820	finally
    //   501	525	820	finally
    //   528	552	820	finally
    //   555	581	820	finally
    //   584	610	820	finally
    //   613	618	820	finally
    //   621	626	820	finally
    //   629	636	820	finally
    //   639	646	820	finally
    //   649	654	820	finally
    //   657	663	820	finally
    //   666	672	820	finally
    //   675	698	820	finally
    //   701	715	820	finally
    //   758	772	820	finally
    //   423	434	825	java/io/IOException
    //   437	451	825	java/io/IOException
    //   454	461	825	java/io/IOException
    //   464	487	825	java/io/IOException
    //   490	498	825	java/io/IOException
    //   501	525	825	java/io/IOException
    //   528	552	825	java/io/IOException
    //   555	581	825	java/io/IOException
    //   584	610	825	java/io/IOException
    //   613	618	825	java/io/IOException
    //   621	626	825	java/io/IOException
    //   629	636	825	java/io/IOException
    //   639	646	825	java/io/IOException
    //   649	654	825	java/io/IOException
    //   657	663	825	java/io/IOException
    //   666	672	825	java/io/IOException
    //   675	698	825	java/io/IOException
    //   701	715	825	java/io/IOException
    //   213	231	830	finally
    //   231	317	837	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.CanaryWorkerService
 * JD-Core Version:    0.7.0.1
 */