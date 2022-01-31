package com.tencent.mm.app;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.ao.d;

public final class h
{
  public static String a(Application paramApplication, final String paramString)
  {
    AppMethodBeat.i(115032);
    if (!"com.tencent.mm:cuploader".equals(paramString))
    {
      ao.a(new ao.d()
      {
        /* Error */
        public final void a(ao paramAnonymousao, String paramAnonymousString, java.lang.Throwable paramAnonymousThrowable)
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 37
          //   7: ldc 39
          //   9: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   12: aload_0
          //   13: getfield 19	com/tencent/mm/app/h$1:bXX	Landroid/app/Application;
          //   16: astore 6
          //   18: aload_0
          //   19: getfield 21	com/tencent/mm/app/h$1:bXY	Ljava/lang/String;
          //   22: astore 4
          //   24: ldc 37
          //   26: ldc 47
          //   28: aload_2
          //   29: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   32: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   35: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   38: new 59	java/lang/StringBuilder
          //   41: dup
          //   42: sipush 2560
          //   45: invokespecial 61	java/lang/StringBuilder:<init>	(I)V
          //   48: astore 7
          //   50: new 63	android/util/StringBuilderPrinter
          //   53: dup
          //   54: aload 7
          //   56: invokespecial 66	android/util/StringBuilderPrinter:<init>	(Ljava/lang/StringBuilder;)V
          //   59: astore 8
          //   61: aload 8
          //   63: new 59	java/lang/StringBuilder
          //   66: dup
          //   67: ldc 68
          //   69: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   72: getstatic 76	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
          //   75: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   78: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   81: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   84: getstatic 93	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
          //   87: ifeq +728 -> 815
          //   90: aload 8
          //   92: ldc 95
          //   94: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   97: getstatic 101	com/tencent/mm/loader/j/c:eQB	Lcom/tencent/mm/loader/j/c;
          //   100: ldc 103
          //   102: ldc 105
          //   104: invokevirtual 109	com/tencent/mm/loader/j/c:Y	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   107: astore 5
          //   109: aload 5
          //   111: ifnull +16 -> 127
          //   114: aload 5
          //   116: astore_1
          //   117: aload 5
          //   119: ldc 105
          //   121: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   124: ifeq +44 -> 168
          //   127: new 59	java/lang/StringBuilder
          //   130: dup
          //   131: invokespecial 114	java/lang/StringBuilder:<init>	()V
          //   134: getstatic 119	android/os/Build:DEVICE	Ljava/lang/String;
          //   137: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   140: getstatic 122	android/os/Build:FINGERPRINT	Ljava/lang/String;
          //   143: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   146: getstatic 125	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   149: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   152: getstatic 128	android/os/Build:MODEL	Ljava/lang/String;
          //   155: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   158: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   161: invokevirtual 132	java/lang/String:hashCode	()I
          //   164: invokestatic 137	java/lang/Integer:toString	(I)Ljava/lang/String;
          //   167: astore_1
          //   168: aload 8
          //   170: ldc 139
          //   172: aload_1
          //   173: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   176: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   179: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   182: new 59	java/lang/StringBuilder
          //   185: dup
          //   186: ldc 141
          //   188: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   191: invokestatic 147	com/tencent/mm/sdk/platformtools/bo:aoy	()J
          //   194: getstatic 153	com/tencent/mm/app/b:bXE	J
          //   197: lsub
          //   198: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   201: ldc 158
          //   203: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   206: astore 5
          //   208: aload 4
          //   210: astore_1
          //   211: aload 4
          //   213: ifnonnull +6 -> 219
          //   216: ldc 160
          //   218: astore_1
          //   219: aload 8
          //   221: aload 5
          //   223: aload_1
          //   224: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   227: ldc 162
          //   229: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   232: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   235: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   238: getstatic 93	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
          //   241: ifeq +608 -> 849
          //   244: aload 8
          //   246: ldc 164
          //   248: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   251: invokestatic 170	android/os/Environment:getDataDirectory	()Ljava/io/File;
          //   254: astore_1
          //   255: new 172	android/os/StatFs
          //   258: dup
          //   259: aload_1
          //   260: invokevirtual 177	java/io/File:getPath	()Ljava/lang/String;
          //   263: invokespecial 178	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   266: astore 4
          //   268: new 172	android/os/StatFs
          //   271: dup
          //   272: getstatic 183	com/tencent/mm/loader/j/b:eQx	Ljava/lang/String;
          //   275: invokespecial 178	android/os/StatFs:<init>	(Ljava/lang/String;)V
          //   278: astore 5
          //   280: ldc 185
          //   282: bipush 10
          //   284: anewarray 4	java/lang/Object
          //   287: dup
          //   288: iconst_0
          //   289: aload 6
          //   291: ldc 187
          //   293: invokevirtual 193	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   296: checkcast 195	android/app/ActivityManager
          //   299: invokevirtual 198	android/app/ActivityManager:getMemoryClass	()I
          //   302: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   305: aastore
          //   306: dup
          //   307: iconst_1
          //   308: aload 6
          //   310: ldc 187
          //   312: invokevirtual 193	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
          //   315: checkcast 195	android/app/ActivityManager
          //   318: invokevirtual 204	android/app/ActivityManager:getLargeMemoryClass	()I
          //   321: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   324: aastore
          //   325: dup
          //   326: iconst_2
          //   327: aload_1
          //   328: invokevirtual 207	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   331: aastore
          //   332: dup
          //   333: iconst_3
          //   334: aload 4
          //   336: invokevirtual 210	android/os/StatFs:getBlockSize	()I
          //   339: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   342: aastore
          //   343: dup
          //   344: iconst_4
          //   345: aload 4
          //   347: invokevirtual 213	android/os/StatFs:getBlockCount	()I
          //   350: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   353: aastore
          //   354: dup
          //   355: iconst_5
          //   356: aload 4
          //   358: invokevirtual 216	android/os/StatFs:getAvailableBlocks	()I
          //   361: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   364: aastore
          //   365: dup
          //   366: bipush 6
          //   368: getstatic 183	com/tencent/mm/loader/j/b:eQx	Ljava/lang/String;
          //   371: aastore
          //   372: dup
          //   373: bipush 7
          //   375: aload 5
          //   377: invokevirtual 210	android/os/StatFs:getBlockSize	()I
          //   380: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   383: aastore
          //   384: dup
          //   385: bipush 8
          //   387: aload 5
          //   389: invokevirtual 213	android/os/StatFs:getBlockCount	()I
          //   392: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   395: aastore
          //   396: dup
          //   397: bipush 9
          //   399: aload 5
          //   401: invokevirtual 216	android/os/StatFs:getAvailableBlocks	()I
          //   404: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   407: aastore
          //   408: invokestatic 220	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   411: astore_1
          //   412: aload_3
          //   413: invokestatic 226	com/tencent/mm/app/x:f	(Ljava/lang/Throwable;)V
          //   416: aload 8
          //   418: ldc 228
          //   420: aload_1
          //   421: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   424: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   427: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   430: new 230	java/util/Date
          //   433: dup
          //   434: invokespecial 231	java/util/Date:<init>	()V
          //   437: astore_1
          //   438: new 233	java/text/SimpleDateFormat
          //   441: dup
          //   442: ldc 235
          //   444: invokestatic 241	java/util/Locale:getDefault	()Ljava/util/Locale;
          //   447: invokespecial 244	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
          //   450: astore_3
          //   451: aload 8
          //   453: new 59	java/lang/StringBuilder
          //   456: dup
          //   457: ldc 246
          //   459: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   462: aload_3
          //   463: aload_1
          //   464: invokevirtual 249	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
          //   467: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   470: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   473: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   476: aload 8
          //   478: ldc 251
          //   480: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   483: aload_2
          //   484: astore_1
          //   485: invokestatic 257	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
          //   488: invokestatic 263	com/tencent/mm/app/f:ba	(Landroid/content/Context;)I
          //   491: iconst_1
          //   492: if_icmpne +15 -> 507
          //   495: aload_2
          //   496: iconst_0
          //   497: invokestatic 257	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
          //   500: invokestatic 266	com/tencent/mm/app/f:bb	(Landroid/content/Context;)I
          //   503: invokevirtual 270	java/lang/String:substring	(II)Ljava/lang/String;
          //   506: astore_1
          //   507: invokestatic 257	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
          //   510: invokestatic 273	com/tencent/mm/sdk/platformtools/ah:getProcessName	()Ljava/lang/String;
          //   513: ldc_w 275
          //   516: invokestatic 278	com/tencent/mm/app/f:e	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
          //   519: aload 8
          //   521: aload_1
          //   522: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   525: ldc 37
          //   527: ldc_w 280
          //   530: aload_1
          //   531: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   534: invokevirtual 57	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   537: invokestatic 45	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   540: new 282	android/content/Intent
          //   543: dup
          //   544: invokespecial 283	android/content/Intent:<init>	()V
          //   547: astore_1
          //   548: aload_1
          //   549: ldc_w 285
          //   552: invokevirtual 289	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
          //   555: pop
          //   556: aload_1
          //   557: ldc_w 291
          //   560: getstatic 101	com/tencent/mm/loader/j/c:eQB	Lcom/tencent/mm/loader/j/c;
          //   563: ldc_w 293
          //   566: ldc_w 295
          //   569: invokevirtual 109	com/tencent/mm/loader/j/c:Y	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   572: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   575: pop
          //   576: aload_1
          //   577: ldc_w 301
          //   580: aload 7
          //   582: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   585: invokevirtual 305	java/lang/String:getBytes	()[B
          //   588: iconst_2
          //   589: invokestatic 311	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
          //   592: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   595: pop
          //   596: aload_1
          //   597: ldc_w 313
          //   600: new 59	java/lang/StringBuilder
          //   603: dup
          //   604: invokespecial 114	java/lang/StringBuilder:<init>	()V
          //   607: getstatic 316	com/tencent/mm/loader/j/b:eQv	Ljava/lang/String;
          //   610: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   613: ldc_w 318
          //   616: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   619: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   622: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   625: pop
          //   626: aload_1
          //   627: ldc_w 320
          //   630: getstatic 323	com/tencent/mm/loader/j/b:eQA	Ljava/lang/String;
          //   633: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   636: pop
          //   637: aload_1
          //   638: ldc_w 325
          //   641: getstatic 101	com/tencent/mm/loader/j/c:eQB	Lcom/tencent/mm/loader/j/c;
          //   644: ldc 103
          //   646: ldc 105
          //   648: invokevirtual 109	com/tencent/mm/loader/j/c:Y	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   651: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   654: pop
          //   655: aload_1
          //   656: ldc_w 327
          //   659: getstatic 76	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
          //   662: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   665: pop
          //   666: aload_1
          //   667: ldc_w 329
          //   670: getstatic 332	com/tencent/mm/loader/j/a:eQs	Ljava/lang/String;
          //   673: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   676: pop
          //   677: aload_1
          //   678: ldc_w 334
          //   681: ldc_w 336
          //   684: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   687: pop
          //   688: aload 6
          //   690: ldc_w 338
          //   693: iconst_0
          //   694: invokevirtual 342	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
          //   697: astore_2
          //   698: aload_1
          //   699: ldc_w 344
          //   702: new 59	java/lang/StringBuilder
          //   705: dup
          //   706: ldc_w 346
          //   709: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   712: aload_2
          //   713: ldc_w 348
          //   716: ldc_w 348
          //   719: invokeinterface 353 3 0
          //   724: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   727: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   730: invokevirtual 299	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   733: pop
          //   734: aload_1
          //   735: aload 6
          //   737: new 59	java/lang/StringBuilder
          //   740: dup
          //   741: invokespecial 114	java/lang/StringBuilder:<init>	()V
          //   744: aload 6
          //   746: invokevirtual 356	android/content/Context:getPackageName	()Ljava/lang/String;
          //   749: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   752: ldc_w 358
          //   755: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   758: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   761: invokevirtual 362	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
          //   764: pop
          //   765: aload_1
          //   766: ldc_w 364
          //   769: iconst_1
          //   770: new 282	android/content/Intent
          //   773: dup
          //   774: invokespecial 283	android/content/Intent:<init>	()V
          //   777: aload 6
          //   779: new 59	java/lang/StringBuilder
          //   782: dup
          //   783: invokespecial 114	java/lang/StringBuilder:<init>	()V
          //   786: aload 6
          //   788: invokevirtual 356	android/content/Context:getPackageName	()Ljava/lang/String;
          //   791: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   794: ldc_w 366
          //   797: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   800: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   803: invokevirtual 362	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
          //   806: invokestatic 371	com/tencent/mm/service/c:a	(Landroid/content/Intent;Ljava/lang/String;ZLandroid/content/Intent;)V
          //   809: ldc 29
          //   811: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   814: return
          //   815: aload 8
          //   817: new 59	java/lang/StringBuilder
          //   820: dup
          //   821: ldc_w 376
          //   824: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   827: invokestatic 379	com/tencent/mm/loader/j/a:Ui	()Ljava/lang/String;
          //   830: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   833: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   836: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   839: goto -742 -> 97
          //   842: astore_1
          //   843: ldc 29
          //   845: invokestatic 374	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   848: return
          //   849: aload 8
          //   851: new 59	java/lang/StringBuilder
          //   854: dup
          //   855: ldc_w 381
          //   858: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   861: getstatic 384	com/tencent/mm/loader/j/a:TIME	Ljava/lang/String;
          //   864: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   867: ldc_w 386
          //   870: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   873: getstatic 389	com/tencent/mm/loader/j/a:HOSTNAME	Ljava/lang/String;
          //   876: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   879: ldc_w 391
          //   882: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   885: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   888: invokevirtual 87	android/util/StringBuilderPrinter:println	(Ljava/lang/String;)V
          //   891: goto -640 -> 251
          //   894: astore_1
          //   895: ldc 160
          //   897: astore_1
          //   898: goto -486 -> 412
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	901	0	this	1
          //   0	901	1	paramAnonymousao	ao
          //   0	901	2	paramAnonymousString	String
          //   0	901	3	paramAnonymousThrowable	java.lang.Throwable
          //   22	335	4	localObject1	Object
          //   107	293	5	localObject2	Object
          //   16	771	6	localApplication	Application
          //   48	533	7	localStringBuilder	java.lang.StringBuilder
          //   59	791	8	localStringBuilderPrinter	android.util.StringBuilderPrinter
          // Exception table:
          //   from	to	target	type
          //   38	97	842	java/lang/Exception
          //   97	109	842	java/lang/Exception
          //   117	127	842	java/lang/Exception
          //   127	168	842	java/lang/Exception
          //   168	208	842	java/lang/Exception
          //   219	251	842	java/lang/Exception
          //   412	483	842	java/lang/Exception
          //   485	507	842	java/lang/Exception
          //   507	809	842	java/lang/Exception
          //   815	839	842	java/lang/Exception
          //   849	891	842	java/lang/Exception
          //   251	412	894	java/lang/Exception
        }
      });
      ao.a(new ao.a()
      {
        public final void Bi()
        {
          String str = a.eQt;
        }
      });
    }
    AppMethodBeat.o(115032);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.h
 * JD-Core Version:    0.7.0.1
 */