package com.tencent.mm.plugin.downloader.d;

public final class e
{
  /* Error */
  public static boolean f(java.io.File paramFile, java.lang.String paramString)
  {
    // Byte code:
    //   0: sipush 2314
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 24	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: sipush 2314
    //   16: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 33	java/io/File:exists	()Z
    //   25: ifeq +10 -> 35
    //   28: aload_0
    //   29: invokevirtual 36	java/io/File:isFile	()Z
    //   32: ifne +136 -> 168
    //   35: iconst_0
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +137 -> 177
    //   43: iconst_2
    //   44: istore_2
    //   45: iload_2
    //   46: iconst_1
    //   47: if_icmpne +677 -> 724
    //   50: ldc 38
    //   52: new 40	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 42
    //   58: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 56
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokevirtual 33	java/io/File:exists	()Z
    //   83: ifeq +17 -> 100
    //   86: aload_0
    //   87: invokevirtual 36	java/io/File:isFile	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_1
    //   94: invokevirtual 69	java/lang/String:isEmpty	()Z
    //   97: ifeq +121 -> 218
    //   100: new 8	java/lang/Exception
    //   103: dup
    //   104: new 40	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 71
    //   110: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 76
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_1
    //   123: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 77	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   132: astore_0
    //   133: sipush 2314
    //   136: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: ldc 38
    //   144: ldc 79
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: sipush 2314
    //   163: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_0
    //   167: ireturn
    //   168: aload_0
    //   169: invokestatic 92	com/tencent/mm/plugin/downloader/d/i:R	(Ljava/io/File;)Z
    //   172: istore 4
    //   174: goto -136 -> 38
    //   177: aload_0
    //   178: invokevirtual 33	java/io/File:exists	()Z
    //   181: ifeq +10 -> 191
    //   184: aload_0
    //   185: invokevirtual 36	java/io/File:isFile	()Z
    //   188: ifne +16 -> 204
    //   191: iconst_0
    //   192: istore 4
    //   194: iload 4
    //   196: ifeq +17 -> 213
    //   199: iconst_1
    //   200: istore_2
    //   201: goto -156 -> 45
    //   204: aload_0
    //   205: invokestatic 97	com/tencent/mm/plugin/downloader/d/h:O	(Ljava/io/File;)Z
    //   208: istore 4
    //   210: goto -16 -> 194
    //   213: iconst_m1
    //   214: istore_2
    //   215: goto -170 -> 45
    //   218: aconst_null
    //   219: astore 10
    //   221: aconst_null
    //   222: astore 9
    //   224: new 99	com/tencent/mm/plugin/downloader/d/f
    //   227: dup
    //   228: invokespecial 102	com/tencent/mm/plugin/downloader/d/f:<init>	()V
    //   231: astore 11
    //   233: aload 11
    //   235: new 104	com/tencent/mm/plugin/downloader/d/h$1
    //   238: dup
    //   239: aload_1
    //   240: invokespecial 105	com/tencent/mm/plugin/downloader/d/h$1:<init>	(Ljava/lang/String;)V
    //   243: invokevirtual 109	com/tencent/mm/plugin/downloader/d/f:G	(Ljava/util/Map;)V
    //   246: aload 11
    //   248: invokevirtual 113	com/tencent/mm/plugin/downloader/d/f:AJ	()[B
    //   251: astore 15
    //   253: aload_0
    //   254: invokestatic 117	com/tencent/mm/plugin/downloader/d/h:N	(Ljava/io/File;)Landroid/util/Pair;
    //   257: astore 11
    //   259: aload 11
    //   261: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   264: checkcast 125	java/nio/ByteBuffer
    //   267: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   270: bipush 22
    //   272: if_icmpne +88 -> 360
    //   275: ldc 131
    //   277: ldc 133
    //   279: iconst_1
    //   280: anewarray 4	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: aload_0
    //   286: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: new 137	java/io/RandomAccessFile
    //   296: dup
    //   297: aload_0
    //   298: ldc 139
    //   300: invokespecial 142	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   303: astore_1
    //   304: aload_1
    //   305: aload_0
    //   306: invokevirtual 146	java/io/File:length	()J
    //   309: ldc2_w 147
    //   312: lsub
    //   313: invokevirtual 152	java/io/RandomAccessFile:seek	(J)V
    //   316: aload 15
    //   318: arraylength
    //   319: aload_1
    //   320: invokestatic 156	com/tencent/mm/plugin/downloader/d/h:a	(ILjava/io/DataOutput;)V
    //   323: aload_1
    //   324: aload 15
    //   326: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   329: aload_1
    //   330: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   333: sipush 2314
    //   336: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iconst_1
    //   340: ireturn
    //   341: astore_0
    //   342: aconst_null
    //   343: astore_1
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   352: sipush 2314
    //   355: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: aload_0
    //   359: athrow
    //   360: ldc 131
    //   362: ldc 165
    //   364: iconst_1
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload_0
    //   371: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   374: aastore
    //   375: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload 11
    //   380: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   383: checkcast 125	java/nio/ByteBuffer
    //   386: bipush 20
    //   388: invokestatic 170	com/tencent/mm/plugin/downloader/d/k:f	(Ljava/nio/ByteBuffer;I)I
    //   391: istore_2
    //   392: iload_2
    //   393: newarray byte
    //   395: astore 12
    //   397: aload 11
    //   399: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   402: checkcast 125	java/nio/ByteBuffer
    //   405: aload 11
    //   407: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   410: checkcast 125	java/nio/ByteBuffer
    //   413: invokevirtual 173	java/nio/ByteBuffer:capacity	()I
    //   416: iload_2
    //   417: isub
    //   418: invokevirtual 177	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   421: pop
    //   422: aload 11
    //   424: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   427: checkcast 125	java/nio/ByteBuffer
    //   430: aload 12
    //   432: iconst_0
    //   433: aload 12
    //   435: arraylength
    //   436: invokevirtual 181	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   439: pop
    //   440: new 99	com/tencent/mm/plugin/downloader/d/f
    //   443: dup
    //   444: invokespecial 102	com/tencent/mm/plugin/downloader/d/f:<init>	()V
    //   447: astore 13
    //   449: aload 13
    //   451: aload 12
    //   453: invokevirtual 184	com/tencent/mm/plugin/downloader/d/f:D	([B)V
    //   456: aload 13
    //   458: getfield 188	com/tencent/mm/plugin/downloader/d/f:kXE	Ljava/util/Properties;
    //   461: ldc 190
    //   463: invokevirtual 196	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   466: astore 14
    //   468: aload 14
    //   470: ifnonnull +90 -> 560
    //   473: ldc 131
    //   475: ldc 198
    //   477: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload 15
    //   482: arraylength
    //   483: istore_3
    //   484: new 137	java/io/RandomAccessFile
    //   487: dup
    //   488: aload_0
    //   489: ldc 139
    //   491: invokespecial 142	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   494: astore_1
    //   495: aload_1
    //   496: aload 11
    //   498: getfield 201	android/util/Pair:second	Ljava/lang/Object;
    //   501: checkcast 203	java/lang/Long
    //   504: invokevirtual 206	java/lang/Long:longValue	()J
    //   507: ldc2_w 207
    //   510: ladd
    //   511: ldc2_w 147
    //   514: lsub
    //   515: invokevirtual 152	java/io/RandomAccessFile:seek	(J)V
    //   518: iload_2
    //   519: iload_3
    //   520: iadd
    //   521: aload_1
    //   522: invokestatic 156	com/tencent/mm/plugin/downloader/d/h:a	(ILjava/io/DataOutput;)V
    //   525: aload_1
    //   526: aload 15
    //   528: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   531: aload_1
    //   532: aload 12
    //   534: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   537: aload_1
    //   538: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   541: goto -208 -> 333
    //   544: aload_1
    //   545: ifnull +7 -> 552
    //   548: aload_1
    //   549: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   552: sipush 2314
    //   555: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_0
    //   559: athrow
    //   560: aload_1
    //   561: aload 14
    //   563: invokevirtual 212	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   566: ifeq +1077 -> 1643
    //   569: ldc 214
    //   571: astore 9
    //   573: ldc 131
    //   575: ldc 216
    //   577: iconst_3
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: aload_1
    //   584: aastore
    //   585: dup
    //   586: iconst_1
    //   587: aload 9
    //   589: aastore
    //   590: dup
    //   591: iconst_2
    //   592: aload 14
    //   594: aastore
    //   595: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   598: aload_1
    //   599: aload 14
    //   601: invokevirtual 212	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   604: ifne -271 -> 333
    //   607: ldc 131
    //   609: ldc 218
    //   611: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 13
    //   616: getfield 188	com/tencent/mm/plugin/downloader/d/f:kXE	Ljava/util/Properties;
    //   619: ldc 190
    //   621: aload_1
    //   622: invokevirtual 222	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   625: pop
    //   626: aload 13
    //   628: invokevirtual 113	com/tencent/mm/plugin/downloader/d/f:AJ	()[B
    //   631: astore 9
    //   633: new 137	java/io/RandomAccessFile
    //   636: dup
    //   637: aload_0
    //   638: ldc 139
    //   640: invokespecial 142	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   643: astore_1
    //   644: aload_1
    //   645: invokevirtual 223	java/io/RandomAccessFile:length	()J
    //   648: lstore 5
    //   650: aload_1
    //   651: aload 9
    //   653: arraylength
    //   654: aload 12
    //   656: arraylength
    //   657: isub
    //   658: i2l
    //   659: lload 5
    //   661: ladd
    //   662: invokevirtual 226	java/io/RandomAccessFile:setLength	(J)V
    //   665: aload_1
    //   666: aload 11
    //   668: getfield 201	android/util/Pair:second	Ljava/lang/Object;
    //   671: checkcast 203	java/lang/Long
    //   674: invokevirtual 206	java/lang/Long:longValue	()J
    //   677: ldc2_w 207
    //   680: ladd
    //   681: ldc2_w 147
    //   684: lsub
    //   685: invokevirtual 152	java/io/RandomAccessFile:seek	(J)V
    //   688: aload 9
    //   690: arraylength
    //   691: aload_1
    //   692: invokestatic 156	com/tencent/mm/plugin/downloader/d/h:a	(ILjava/io/DataOutput;)V
    //   695: aload_1
    //   696: aload 9
    //   698: invokevirtual 160	java/io/RandomAccessFile:write	([B)V
    //   701: aload_1
    //   702: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   705: goto -372 -> 333
    //   708: aload_1
    //   709: ifnull +7 -> 716
    //   712: aload_1
    //   713: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   716: sipush 2314
    //   719: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   722: aload_0
    //   723: athrow
    //   724: iload_2
    //   725: iconst_2
    //   726: if_icmpne +853 -> 1579
    //   729: ldc 38
    //   731: new 40	java/lang/StringBuilder
    //   734: dup
    //   735: ldc 42
    //   737: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   740: aload_0
    //   741: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   744: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: ldc 228
    //   749: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   758: aload_1
    //   759: invokevirtual 230	java/lang/String:length	()I
    //   762: ifgt +71 -> 833
    //   765: new 232	java/lang/RuntimeException
    //   768: dup
    //   769: new 40	java/lang/StringBuilder
    //   772: dup
    //   773: ldc 234
    //   775: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   778: aload_1
    //   779: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc 236
    //   784: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_0
    //   788: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokespecial 237	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   797: astore_0
    //   798: sipush 2314
    //   801: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   804: aload_0
    //   805: athrow
    //   806: astore_0
    //   807: ldc 38
    //   809: ldc 239
    //   811: iconst_1
    //   812: anewarray 4	java/lang/Object
    //   815: dup
    //   816: iconst_0
    //   817: aload_0
    //   818: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   821: aastore
    //   822: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   825: sipush 2314
    //   828: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   831: iconst_0
    //   832: ireturn
    //   833: aload_0
    //   834: invokevirtual 33	java/io/File:exists	()Z
    //   837: ifeq +821 -> 1658
    //   840: aload_0
    //   841: invokevirtual 36	java/io/File:isFile	()Z
    //   844: ifne +126 -> 970
    //   847: goto +811 -> 1658
    //   850: new 99	com/tencent/mm/plugin/downloader/d/f
    //   853: dup
    //   854: invokespecial 102	com/tencent/mm/plugin/downloader/d/f:<init>	()V
    //   857: astore 10
    //   859: aload 10
    //   861: new 242	com/tencent/mm/plugin/downloader/d/d$1
    //   864: dup
    //   865: aload_1
    //   866: invokespecial 243	com/tencent/mm/plugin/downloader/d/d$1:<init>	(Ljava/lang/String;)V
    //   869: invokevirtual 109	com/tencent/mm/plugin/downloader/d/f:G	(Ljava/util/Map;)V
    //   872: aload 10
    //   874: invokevirtual 113	com/tencent/mm/plugin/downloader/d/f:AJ	()[B
    //   877: invokestatic 247	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   880: astore 10
    //   882: aload 10
    //   884: getstatic 253	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   887: invokevirtual 257	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   890: pop
    //   891: new 259	java/util/LinkedHashMap
    //   894: dup
    //   895: invokespecial 260	java/util/LinkedHashMap:<init>	()V
    //   898: astore_1
    //   899: aload_1
    //   900: ldc_w 261
    //   903: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   906: aload 10
    //   908: invokeinterface 270 3 0
    //   913: pop
    //   914: aload_1
    //   915: invokeinterface 271 1 0
    //   920: ifeq +59 -> 979
    //   923: new 232	java/lang/RuntimeException
    //   926: dup
    //   927: ldc_w 273
    //   930: invokespecial 237	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   933: astore_0
    //   934: sipush 2314
    //   937: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: aload_0
    //   941: athrow
    //   942: astore_0
    //   943: ldc 38
    //   945: ldc_w 275
    //   948: iconst_1
    //   949: anewarray 4	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: aload_0
    //   955: invokevirtual 276	com/tencent/mm/plugin/downloader/d/b$b:getMessage	()Ljava/lang/String;
    //   958: aastore
    //   959: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   962: sipush 2314
    //   965: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   968: iconst_0
    //   969: ireturn
    //   970: aload_0
    //   971: invokestatic 280	com/tencent/mm/plugin/downloader/d/i:Q	(Ljava/io/File;)Lcom/tencent/mm/plugin/downloader/d/a;
    //   974: astore 9
    //   976: goto -126 -> 850
    //   979: aload_1
    //   980: ldc_w 281
    //   983: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   986: invokeinterface 284 2 0
    //   991: ifeq +16 -> 1007
    //   994: aload_1
    //   995: ldc_w 281
    //   998: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1001: invokeinterface 288 2 0
    //   1006: pop
    //   1007: ldc_w 290
    //   1010: ldc_w 292
    //   1013: aload_1
    //   1014: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1017: invokevirtual 298	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1023: aload 9
    //   1025: getfield 304	com/tencent/mm/plugin/downloader/d/a:kXu	Landroid/util/Pair;
    //   1028: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1031: checkcast 125	java/nio/ByteBuffer
    //   1034: invokestatic 308	com/tencent/mm/plugin/downloader/d/i:A	(Ljava/nio/ByteBuffer;)Ljava/util/Map;
    //   1037: astore 10
    //   1039: aload 10
    //   1041: ldc_w 281
    //   1044: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1047: invokeinterface 284 2 0
    //   1052: ifne +22 -> 1074
    //   1055: new 12	com/tencent/mm/plugin/downloader/d/b$b
    //   1058: dup
    //   1059: ldc_w 310
    //   1062: invokespecial 311	com/tencent/mm/plugin/downloader/d/b$b:<init>	(Ljava/lang/String;)V
    //   1065: astore_0
    //   1066: sipush 2314
    //   1069: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1072: aload_0
    //   1073: athrow
    //   1074: ldc_w 290
    //   1077: ldc_w 313
    //   1080: aload 10
    //   1082: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1085: invokevirtual 298	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1088: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1091: aload 10
    //   1093: aload_1
    //   1094: invokeinterface 316 2 0
    //   1099: ldc_w 290
    //   1102: ldc_w 318
    //   1105: aload 10
    //   1107: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1110: invokevirtual 298	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1113: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1116: aload 10
    //   1118: invokestatic 322	com/tencent/mm/plugin/downloader/d/i:H	(Ljava/util/Map;)Ljava/nio/ByteBuffer;
    //   1121: astore 12
    //   1123: ldc_w 290
    //   1126: new 40	java/lang/StringBuilder
    //   1129: dup
    //   1130: ldc_w 324
    //   1133: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1136: aload 9
    //   1138: getfield 304	com/tencent/mm/plugin/downloader/d/a:kXu	Landroid/util/Pair;
    //   1141: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1144: checkcast 125	java/nio/ByteBuffer
    //   1147: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1150: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: ldc_w 329
    //   1156: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: aload 12
    //   1161: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1164: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1173: aload 9
    //   1175: getfield 332	com/tencent/mm/plugin/downloader/d/a:kXv	Landroid/util/Pair;
    //   1178: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1181: checkcast 125	java/nio/ByteBuffer
    //   1184: astore 13
    //   1186: aload 9
    //   1188: getfield 335	com/tencent/mm/plugin/downloader/d/a:kXw	Landroid/util/Pair;
    //   1191: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1194: checkcast 125	java/nio/ByteBuffer
    //   1197: astore 11
    //   1199: aload 9
    //   1201: getfield 332	com/tencent/mm/plugin/downloader/d/a:kXv	Landroid/util/Pair;
    //   1204: getfield 201	android/util/Pair:second	Ljava/lang/Object;
    //   1207: checkcast 203	java/lang/Long
    //   1210: invokevirtual 206	java/lang/Long:longValue	()J
    //   1213: lstore 5
    //   1215: aload 12
    //   1217: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1220: aload 9
    //   1222: getfield 304	com/tencent/mm/plugin/downloader/d/a:kXu	Landroid/util/Pair;
    //   1225: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1228: checkcast 125	java/nio/ByteBuffer
    //   1231: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1234: isub
    //   1235: istore_2
    //   1236: aload 11
    //   1238: iload_2
    //   1239: i2l
    //   1240: lload 5
    //   1242: ladd
    //   1243: invokestatic 339	com/tencent/mm/plugin/downloader/d/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1246: aload 9
    //   1248: getfield 343	com/tencent/mm/plugin/downloader/d/a:kXs	J
    //   1251: lstore 7
    //   1253: lload 7
    //   1255: iload_2
    //   1256: i2l
    //   1257: ladd
    //   1258: lstore 7
    //   1260: aconst_null
    //   1261: astore 10
    //   1263: new 137	java/io/RandomAccessFile
    //   1266: dup
    //   1267: aload_0
    //   1268: ldc 139
    //   1270: invokespecial 142	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1273: astore_1
    //   1274: aload 9
    //   1276: getfield 347	com/tencent/mm/plugin/downloader/d/a:lowMemory	Z
    //   1279: ifeq +177 -> 1456
    //   1282: aload_1
    //   1283: aload 9
    //   1285: getfield 304	com/tencent/mm/plugin/downloader/d/a:kXu	Landroid/util/Pair;
    //   1288: getfield 201	android/util/Pair:second	Ljava/lang/Object;
    //   1291: checkcast 203	java/lang/Long
    //   1294: invokevirtual 206	java/lang/Long:longValue	()J
    //   1297: invokevirtual 152	java/io/RandomAccessFile:seek	(J)V
    //   1300: aload_1
    //   1301: aload 12
    //   1303: invokevirtual 350	java/nio/ByteBuffer:array	()[B
    //   1306: aload 12
    //   1308: invokevirtual 353	java/nio/ByteBuffer:arrayOffset	()I
    //   1311: aload 12
    //   1313: invokevirtual 355	java/nio/ByteBuffer:position	()I
    //   1316: iadd
    //   1317: aload 12
    //   1319: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1322: invokevirtual 358	java/io/RandomAccessFile:write	([BII)V
    //   1325: aload_1
    //   1326: aload 13
    //   1328: invokevirtual 350	java/nio/ByteBuffer:array	()[B
    //   1331: aload 13
    //   1333: invokevirtual 353	java/nio/ByteBuffer:arrayOffset	()I
    //   1336: aload 13
    //   1338: invokevirtual 355	java/nio/ByteBuffer:position	()I
    //   1341: iadd
    //   1342: aload 13
    //   1344: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1347: invokevirtual 358	java/io/RandomAccessFile:write	([BII)V
    //   1350: aload_1
    //   1351: aload 11
    //   1353: invokevirtual 350	java/nio/ByteBuffer:array	()[B
    //   1356: aload 11
    //   1358: invokevirtual 353	java/nio/ByteBuffer:arrayOffset	()I
    //   1361: aload 11
    //   1363: invokevirtual 355	java/nio/ByteBuffer:position	()I
    //   1366: iadd
    //   1367: aload 11
    //   1369: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1372: invokevirtual 358	java/io/RandomAccessFile:write	([BII)V
    //   1375: aload_1
    //   1376: invokevirtual 361	java/io/RandomAccessFile:getFilePointer	()J
    //   1379: lload 7
    //   1381: lcmp
    //   1382: ifeq +133 -> 1515
    //   1385: new 232	java/lang/RuntimeException
    //   1388: dup
    //   1389: new 40	java/lang/StringBuilder
    //   1392: dup
    //   1393: ldc_w 363
    //   1396: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1399: aload_1
    //   1400: invokevirtual 361	java/io/RandomAccessFile:getFilePointer	()J
    //   1403: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1406: ldc_w 368
    //   1409: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: lload 7
    //   1414: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokespecial 237	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1423: astore_0
    //   1424: sipush 2314
    //   1427: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1430: aload_0
    //   1431: athrow
    //   1432: astore_0
    //   1433: aload 11
    //   1435: lload 5
    //   1437: invokestatic 339	com/tencent/mm/plugin/downloader/d/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1440: aload_1
    //   1441: ifnull +7 -> 1448
    //   1444: aload_1
    //   1445: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   1448: sipush 2314
    //   1451: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1454: aload_0
    //   1455: athrow
    //   1456: aload 9
    //   1458: getfield 371	com/tencent/mm/plugin/downloader/d/a:kXt	Landroid/util/Pair;
    //   1461: getfield 123	android/util/Pair:first	Ljava/lang/Object;
    //   1464: checkcast 125	java/nio/ByteBuffer
    //   1467: astore 10
    //   1469: aload_1
    //   1470: aload 9
    //   1472: getfield 371	com/tencent/mm/plugin/downloader/d/a:kXt	Landroid/util/Pair;
    //   1475: getfield 201	android/util/Pair:second	Ljava/lang/Object;
    //   1478: checkcast 203	java/lang/Long
    //   1481: invokevirtual 206	java/lang/Long:longValue	()J
    //   1484: invokevirtual 152	java/io/RandomAccessFile:seek	(J)V
    //   1487: aload_1
    //   1488: aload 10
    //   1490: invokevirtual 350	java/nio/ByteBuffer:array	()[B
    //   1493: aload 10
    //   1495: invokevirtual 353	java/nio/ByteBuffer:arrayOffset	()I
    //   1498: aload 10
    //   1500: invokevirtual 355	java/nio/ByteBuffer:position	()I
    //   1503: iadd
    //   1504: aload 10
    //   1506: invokevirtual 129	java/nio/ByteBuffer:remaining	()I
    //   1509: invokevirtual 358	java/io/RandomAccessFile:write	([BII)V
    //   1512: goto -212 -> 1300
    //   1515: aload_1
    //   1516: lload 7
    //   1518: invokevirtual 226	java/io/RandomAccessFile:setLength	(J)V
    //   1521: ldc_w 290
    //   1524: new 40	java/lang/StringBuilder
    //   1527: dup
    //   1528: ldc_w 373
    //   1531: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1534: aload_0
    //   1535: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1538: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: ldc_w 375
    //   1544: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload_0
    //   1548: invokevirtual 146	java/io/File:length	()J
    //   1551: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1560: aload 11
    //   1562: lload 5
    //   1564: invokestatic 339	com/tencent/mm/plugin/downloader/d/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1567: aload_1
    //   1568: invokevirtual 163	java/io/RandomAccessFile:close	()V
    //   1571: sipush 2314
    //   1574: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1577: iconst_1
    //   1578: ireturn
    //   1579: ldc 38
    //   1581: new 40	java/lang/StringBuilder
    //   1584: dup
    //   1585: ldc 42
    //   1587: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1590: aload_0
    //   1591: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1594: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: ldc_w 377
    //   1600: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1609: sipush 2314
    //   1612: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1615: iconst_0
    //   1616: ireturn
    //   1617: astore_0
    //   1618: aload 10
    //   1620: astore_1
    //   1621: goto -188 -> 1433
    //   1624: astore_0
    //   1625: goto -917 -> 708
    //   1628: astore_0
    //   1629: goto -1085 -> 544
    //   1632: astore_0
    //   1633: goto -1289 -> 344
    //   1636: astore_0
    //   1637: aload 9
    //   1639: astore_1
    //   1640: goto -1096 -> 544
    //   1643: ldc_w 379
    //   1646: astore 9
    //   1648: goto -1075 -> 573
    //   1651: astore_0
    //   1652: aload 10
    //   1654: astore_1
    //   1655: goto -947 -> 708
    //   1658: aconst_null
    //   1659: astore 9
    //   1661: goto -811 -> 850
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1664	0	paramFile	java.io.File
    //   0	1664	1	paramString	java.lang.String
    //   44	1212	2	i	int
    //   483	38	3	j	int
    //   36	173	4	bool	boolean
    //   648	915	5	l1	long
    //   1251	266	7	l2	long
    //   222	1438	9	localObject1	Object
    //   219	1434	10	localObject2	Object
    //   231	1330	11	localObject3	Object
    //   395	923	12	localObject4	Object
    //   447	896	13	localObject5	Object
    //   466	134	14	str	java.lang.String
    //   251	276	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   79	100	141	java/lang/Exception
    //   100	141	141	java/lang/Exception
    //   224	293	141	java/lang/Exception
    //   329	333	141	java/lang/Exception
    //   348	352	141	java/lang/Exception
    //   352	360	141	java/lang/Exception
    //   360	468	141	java/lang/Exception
    //   473	484	141	java/lang/Exception
    //   537	541	141	java/lang/Exception
    //   548	552	141	java/lang/Exception
    //   552	560	141	java/lang/Exception
    //   560	569	141	java/lang/Exception
    //   573	633	141	java/lang/Exception
    //   701	705	141	java/lang/Exception
    //   712	716	141	java/lang/Exception
    //   716	724	141	java/lang/Exception
    //   293	304	341	finally
    //   758	806	806	java/io/IOException
    //   833	847	806	java/io/IOException
    //   850	942	806	java/io/IOException
    //   970	976	806	java/io/IOException
    //   979	1007	806	java/io/IOException
    //   1007	1074	806	java/io/IOException
    //   1074	1253	806	java/io/IOException
    //   1433	1440	806	java/io/IOException
    //   1444	1448	806	java/io/IOException
    //   1448	1456	806	java/io/IOException
    //   1560	1571	806	java/io/IOException
    //   758	806	942	com/tencent/mm/plugin/downloader/d/b$b
    //   833	847	942	com/tencent/mm/plugin/downloader/d/b$b
    //   850	942	942	com/tencent/mm/plugin/downloader/d/b$b
    //   970	976	942	com/tencent/mm/plugin/downloader/d/b$b
    //   979	1007	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1007	1074	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1074	1253	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1433	1440	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1444	1448	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1448	1456	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1560	1571	942	com/tencent/mm/plugin/downloader/d/b$b
    //   1274	1300	1432	finally
    //   1300	1432	1432	finally
    //   1456	1512	1432	finally
    //   1515	1560	1432	finally
    //   1263	1274	1617	finally
    //   644	701	1624	finally
    //   495	537	1628	finally
    //   304	329	1632	finally
    //   484	495	1636	finally
    //   633	644	1651	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.e
 * JD-Core Version:    0.7.0.1
 */