package com.tencent.mm.plugin.downloader.c;

public final class e
{
  /* Error */
  public static boolean e(java.io.File paramFile, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 18	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: invokevirtual 24	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 27	java/io/File:isFile	()Z
    //   20: ifne +122 -> 142
    //   23: iconst_0
    //   24: istore 4
    //   26: iload 4
    //   28: ifeq +123 -> 151
    //   31: iconst_2
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_1
    //   35: if_icmpne +637 -> 672
    //   38: ldc 29
    //   40: new 31	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 33
    //   46: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 47
    //   58: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokevirtual 24	java/io/File:exists	()Z
    //   71: ifeq +17 -> 88
    //   74: aload_0
    //   75: invokevirtual 27	java/io/File:isFile	()Z
    //   78: ifeq +10 -> 88
    //   81: aload_1
    //   82: invokevirtual 61	java/lang/String:isEmpty	()Z
    //   85: ifeq +107 -> 192
    //   88: new 8	java/lang/Exception
    //   91: dup
    //   92: new 31	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 63
    //   98: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: ldc 68
    //   107: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 69	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_0
    //   122: ldc 29
    //   124: ldc 71
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 77	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_0
    //   143: invokestatic 83	com/tencent/mm/plugin/downloader/c/i:J	(Ljava/io/File;)Z
    //   146: istore 4
    //   148: goto -122 -> 26
    //   151: aload_0
    //   152: invokevirtual 24	java/io/File:exists	()Z
    //   155: ifeq +10 -> 165
    //   158: aload_0
    //   159: invokevirtual 27	java/io/File:isFile	()Z
    //   162: ifne +16 -> 178
    //   165: iconst_0
    //   166: istore 4
    //   168: iload 4
    //   170: ifeq +17 -> 187
    //   173: iconst_1
    //   174: istore_2
    //   175: goto -142 -> 33
    //   178: aload_0
    //   179: invokestatic 88	com/tencent/mm/plugin/downloader/c/h:G	(Ljava/io/File;)Z
    //   182: istore 4
    //   184: goto -16 -> 168
    //   187: iconst_m1
    //   188: istore_2
    //   189: goto -156 -> 33
    //   192: aconst_null
    //   193: astore 10
    //   195: aconst_null
    //   196: astore 9
    //   198: new 90	com/tencent/mm/plugin/downloader/c/f
    //   201: dup
    //   202: invokespecial 93	com/tencent/mm/plugin/downloader/c/f:<init>	()V
    //   205: astore 11
    //   207: aload 11
    //   209: new 95	com/tencent/mm/plugin/downloader/c/h$1
    //   212: dup
    //   213: aload_1
    //   214: invokespecial 96	com/tencent/mm/plugin/downloader/c/h$1:<init>	(Ljava/lang/String;)V
    //   217: invokevirtual 100	com/tencent/mm/plugin/downloader/c/f:w	(Ljava/util/Map;)V
    //   220: aload 11
    //   222: invokevirtual 104	com/tencent/mm/plugin/downloader/c/f:ss	()[B
    //   225: astore 15
    //   227: aload_0
    //   228: invokestatic 108	com/tencent/mm/plugin/downloader/c/h:F	(Ljava/io/File;)Landroid/util/Pair;
    //   231: astore 11
    //   233: aload 11
    //   235: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   238: checkcast 116	java/nio/ByteBuffer
    //   241: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   244: bipush 22
    //   246: if_icmpne +74 -> 320
    //   249: ldc 122
    //   251: ldc 124
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload_0
    //   260: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 126	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: new 128	java/io/RandomAccessFile
    //   270: dup
    //   271: aload_0
    //   272: ldc 130
    //   274: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   277: astore_1
    //   278: aload_1
    //   279: aload_0
    //   280: invokevirtual 137	java/io/File:length	()J
    //   283: ldc2_w 138
    //   286: lsub
    //   287: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   290: aload 15
    //   292: arraylength
    //   293: aload_1
    //   294: invokestatic 147	com/tencent/mm/plugin/downloader/c/h:a	(ILjava/io/DataOutput;)V
    //   297: aload_1
    //   298: aload 15
    //   300: invokevirtual 151	java/io/RandomAccessFile:write	([B)V
    //   303: aload_1
    //   304: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   307: goto +1240 -> 1547
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   318: aload_0
    //   319: athrow
    //   320: ldc 122
    //   322: ldc 156
    //   324: iconst_1
    //   325: anewarray 4	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: aload_0
    //   331: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   334: aastore
    //   335: invokestatic 126	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload 11
    //   340: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   343: checkcast 116	java/nio/ByteBuffer
    //   346: bipush 20
    //   348: invokestatic 161	com/tencent/mm/plugin/downloader/c/k:e	(Ljava/nio/ByteBuffer;I)I
    //   351: istore_2
    //   352: iload_2
    //   353: newarray byte
    //   355: astore 12
    //   357: aload 11
    //   359: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   362: checkcast 116	java/nio/ByteBuffer
    //   365: aload 11
    //   367: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   370: checkcast 116	java/nio/ByteBuffer
    //   373: invokevirtual 164	java/nio/ByteBuffer:capacity	()I
    //   376: iload_2
    //   377: isub
    //   378: invokevirtual 168	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   381: pop
    //   382: aload 11
    //   384: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   387: checkcast 116	java/nio/ByteBuffer
    //   390: aload 12
    //   392: iconst_0
    //   393: aload 12
    //   395: arraylength
    //   396: invokevirtual 172	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   399: pop
    //   400: new 90	com/tencent/mm/plugin/downloader/c/f
    //   403: dup
    //   404: invokespecial 93	com/tencent/mm/plugin/downloader/c/f:<init>	()V
    //   407: astore 13
    //   409: aload 13
    //   411: aload 12
    //   413: invokevirtual 175	com/tencent/mm/plugin/downloader/c/f:u	([B)V
    //   416: aload 13
    //   418: getfield 179	com/tencent/mm/plugin/downloader/c/f:iON	Ljava/util/Properties;
    //   421: ldc 181
    //   423: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 14
    //   428: aload 14
    //   430: ifnonnull +84 -> 514
    //   433: ldc 122
    //   435: ldc 189
    //   437: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload 15
    //   442: arraylength
    //   443: istore_3
    //   444: new 128	java/io/RandomAccessFile
    //   447: dup
    //   448: aload_0
    //   449: ldc 130
    //   451: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   454: astore_1
    //   455: aload_1
    //   456: aload 11
    //   458: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   461: checkcast 194	java/lang/Long
    //   464: invokevirtual 197	java/lang/Long:longValue	()J
    //   467: ldc2_w 198
    //   470: ladd
    //   471: ldc2_w 138
    //   474: lsub
    //   475: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   478: iload_2
    //   479: iload_3
    //   480: iadd
    //   481: aload_1
    //   482: invokestatic 147	com/tencent/mm/plugin/downloader/c/h:a	(ILjava/io/DataOutput;)V
    //   485: aload_1
    //   486: aload 15
    //   488: invokevirtual 151	java/io/RandomAccessFile:write	([B)V
    //   491: aload_1
    //   492: aload 12
    //   494: invokevirtual 151	java/io/RandomAccessFile:write	([B)V
    //   497: aload_1
    //   498: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   501: goto +1046 -> 1547
    //   504: aload_1
    //   505: ifnull +7 -> 512
    //   508: aload_1
    //   509: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   512: aload_0
    //   513: athrow
    //   514: aload_1
    //   515: aload 14
    //   517: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   520: ifeq +1042 -> 1562
    //   523: ldc 205
    //   525: astore 9
    //   527: ldc 122
    //   529: ldc 207
    //   531: iconst_3
    //   532: anewarray 4	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: aload_1
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: aload 9
    //   543: aastore
    //   544: dup
    //   545: iconst_2
    //   546: aload 14
    //   548: aastore
    //   549: invokestatic 126	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: aload_1
    //   553: aload 14
    //   555: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   558: ifne +989 -> 1547
    //   561: ldc 122
    //   563: ldc 209
    //   565: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload 13
    //   570: getfield 179	com/tencent/mm/plugin/downloader/c/f:iON	Ljava/util/Properties;
    //   573: ldc 181
    //   575: aload_1
    //   576: invokevirtual 213	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: aload 13
    //   582: invokevirtual 104	com/tencent/mm/plugin/downloader/c/f:ss	()[B
    //   585: astore 9
    //   587: new 128	java/io/RandomAccessFile
    //   590: dup
    //   591: aload_0
    //   592: ldc 130
    //   594: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   597: astore_1
    //   598: aload_1
    //   599: invokevirtual 214	java/io/RandomAccessFile:length	()J
    //   602: lstore 5
    //   604: aload_1
    //   605: aload 9
    //   607: arraylength
    //   608: aload 12
    //   610: arraylength
    //   611: isub
    //   612: i2l
    //   613: lload 5
    //   615: ladd
    //   616: invokevirtual 217	java/io/RandomAccessFile:setLength	(J)V
    //   619: aload_1
    //   620: aload 11
    //   622: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   625: checkcast 194	java/lang/Long
    //   628: invokevirtual 197	java/lang/Long:longValue	()J
    //   631: ldc2_w 198
    //   634: ladd
    //   635: ldc2_w 138
    //   638: lsub
    //   639: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   642: aload 9
    //   644: arraylength
    //   645: aload_1
    //   646: invokestatic 147	com/tencent/mm/plugin/downloader/c/h:a	(ILjava/io/DataOutput;)V
    //   649: aload_1
    //   650: aload 9
    //   652: invokevirtual 151	java/io/RandomAccessFile:write	([B)V
    //   655: aload_1
    //   656: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   659: goto +888 -> 1547
    //   662: aload_1
    //   663: ifnull +7 -> 670
    //   666: aload_1
    //   667: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   670: aload_0
    //   671: athrow
    //   672: iload_2
    //   673: iconst_2
    //   674: if_icmpne +825 -> 1499
    //   677: ldc 29
    //   679: new 31	java/lang/StringBuilder
    //   682: dup
    //   683: ldc 33
    //   685: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   688: aload_0
    //   689: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   692: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc 219
    //   697: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload_1
    //   707: invokevirtual 221	java/lang/String:length	()I
    //   710: ifgt +57 -> 767
    //   713: new 223	java/lang/RuntimeException
    //   716: dup
    //   717: new 31	java/lang/StringBuilder
    //   720: dup
    //   721: ldc 225
    //   723: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload_1
    //   727: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc 227
    //   732: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_0
    //   736: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   745: athrow
    //   746: astore_0
    //   747: ldc 29
    //   749: ldc 230
    //   751: iconst_1
    //   752: anewarray 4	java/lang/Object
    //   755: dup
    //   756: iconst_0
    //   757: aload_0
    //   758: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   761: aastore
    //   762: invokestatic 77	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   765: iconst_0
    //   766: ireturn
    //   767: aload_0
    //   768: invokevirtual 24	java/io/File:exists	()Z
    //   771: ifeq +806 -> 1577
    //   774: aload_0
    //   775: invokevirtual 27	java/io/File:isFile	()Z
    //   778: ifne +111 -> 889
    //   781: goto +796 -> 1577
    //   784: new 90	com/tencent/mm/plugin/downloader/c/f
    //   787: dup
    //   788: invokespecial 93	com/tencent/mm/plugin/downloader/c/f:<init>	()V
    //   791: astore 10
    //   793: aload 10
    //   795: new 233	com/tencent/mm/plugin/downloader/c/d$1
    //   798: dup
    //   799: aload_1
    //   800: invokespecial 234	com/tencent/mm/plugin/downloader/c/d$1:<init>	(Ljava/lang/String;)V
    //   803: invokevirtual 100	com/tencent/mm/plugin/downloader/c/f:w	(Ljava/util/Map;)V
    //   806: aload 10
    //   808: invokevirtual 104	com/tencent/mm/plugin/downloader/c/f:ss	()[B
    //   811: invokestatic 238	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   814: astore 10
    //   816: aload 10
    //   818: getstatic 244	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   821: invokevirtual 248	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   824: pop
    //   825: new 250	java/util/LinkedHashMap
    //   828: dup
    //   829: invokespecial 251	java/util/LinkedHashMap:<init>	()V
    //   832: astore_1
    //   833: aload_1
    //   834: ldc 252
    //   836: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   839: aload 10
    //   841: invokeinterface 261 3 0
    //   846: pop
    //   847: aload_1
    //   848: invokeinterface 262 1 0
    //   853: ifeq +45 -> 898
    //   856: new 223	java/lang/RuntimeException
    //   859: dup
    //   860: ldc_w 264
    //   863: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   866: athrow
    //   867: astore_0
    //   868: ldc 29
    //   870: ldc_w 266
    //   873: iconst_1
    //   874: anewarray 4	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: aload_0
    //   880: invokevirtual 267	com/tencent/mm/plugin/downloader/c/b$b:getMessage	()Ljava/lang/String;
    //   883: aastore
    //   884: invokestatic 77	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   887: iconst_0
    //   888: ireturn
    //   889: aload_0
    //   890: invokestatic 271	com/tencent/mm/plugin/downloader/c/i:I	(Ljava/io/File;)Lcom/tencent/mm/plugin/downloader/c/a;
    //   893: astore 9
    //   895: goto -111 -> 784
    //   898: aload_1
    //   899: ldc_w 272
    //   902: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   905: invokeinterface 275 2 0
    //   910: ifeq +16 -> 926
    //   913: aload_1
    //   914: ldc_w 272
    //   917: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   920: invokeinterface 279 2 0
    //   925: pop
    //   926: ldc_w 281
    //   929: new 31	java/lang/StringBuilder
    //   932: dup
    //   933: ldc_w 283
    //   936: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   939: aload_1
    //   940: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: aload 9
    //   951: getfield 289	com/tencent/mm/plugin/downloader/c/a:iOD	Landroid/util/Pair;
    //   954: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   957: checkcast 116	java/nio/ByteBuffer
    //   960: invokestatic 293	com/tencent/mm/plugin/downloader/c/i:z	(Ljava/nio/ByteBuffer;)Ljava/util/Map;
    //   963: astore 10
    //   965: aload 10
    //   967: ldc_w 272
    //   970: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   973: invokeinterface 275 2 0
    //   978: ifne +14 -> 992
    //   981: new 12	com/tencent/mm/plugin/downloader/c/b$b
    //   984: dup
    //   985: ldc_w 295
    //   988: invokespecial 296	com/tencent/mm/plugin/downloader/c/b$b:<init>	(Ljava/lang/String;)V
    //   991: athrow
    //   992: ldc_w 281
    //   995: new 31	java/lang/StringBuilder
    //   998: dup
    //   999: ldc_w 298
    //   1002: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1005: aload 10
    //   1007: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: aload 10
    //   1018: aload_1
    //   1019: invokeinterface 301 2 0
    //   1024: ldc_w 281
    //   1027: new 31	java/lang/StringBuilder
    //   1030: dup
    //   1031: ldc_w 303
    //   1034: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1037: aload 10
    //   1039: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1048: aload 10
    //   1050: invokestatic 307	com/tencent/mm/plugin/downloader/c/i:x	(Ljava/util/Map;)Ljava/nio/ByteBuffer;
    //   1053: astore 12
    //   1055: ldc_w 281
    //   1058: new 31	java/lang/StringBuilder
    //   1061: dup
    //   1062: ldc_w 309
    //   1065: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1068: aload 9
    //   1070: getfield 289	com/tencent/mm/plugin/downloader/c/a:iOD	Landroid/util/Pair;
    //   1073: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   1076: checkcast 116	java/nio/ByteBuffer
    //   1079: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1082: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1085: ldc_w 314
    //   1088: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 12
    //   1093: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1096: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1105: aload 9
    //   1107: getfield 317	com/tencent/mm/plugin/downloader/c/a:iOE	Landroid/util/Pair;
    //   1110: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   1113: checkcast 116	java/nio/ByteBuffer
    //   1116: astore 13
    //   1118: aload 9
    //   1120: getfield 320	com/tencent/mm/plugin/downloader/c/a:iOF	Landroid/util/Pair;
    //   1123: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   1126: checkcast 116	java/nio/ByteBuffer
    //   1129: astore 11
    //   1131: aload 9
    //   1133: getfield 317	com/tencent/mm/plugin/downloader/c/a:iOE	Landroid/util/Pair;
    //   1136: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   1139: checkcast 194	java/lang/Long
    //   1142: invokevirtual 197	java/lang/Long:longValue	()J
    //   1145: lstore 5
    //   1147: aload 12
    //   1149: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1152: aload 9
    //   1154: getfield 289	com/tencent/mm/plugin/downloader/c/a:iOD	Landroid/util/Pair;
    //   1157: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   1160: checkcast 116	java/nio/ByteBuffer
    //   1163: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1166: isub
    //   1167: istore_2
    //   1168: aload 11
    //   1170: iload_2
    //   1171: i2l
    //   1172: lload 5
    //   1174: ladd
    //   1175: invokestatic 324	com/tencent/mm/plugin/downloader/c/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1178: aload 9
    //   1180: getfield 327	com/tencent/mm/plugin/downloader/c/a:iOB	J
    //   1183: lstore 7
    //   1185: lload 7
    //   1187: iload_2
    //   1188: i2l
    //   1189: ladd
    //   1190: lstore 7
    //   1192: aconst_null
    //   1193: astore_1
    //   1194: new 128	java/io/RandomAccessFile
    //   1197: dup
    //   1198: aload_0
    //   1199: ldc 130
    //   1201: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1204: astore 10
    //   1206: aload 9
    //   1208: getfield 331	com/tencent/mm/plugin/downloader/c/a:lowMemory	Z
    //   1211: ifeq +172 -> 1383
    //   1214: aload 10
    //   1216: aload 9
    //   1218: getfield 289	com/tencent/mm/plugin/downloader/c/a:iOD	Landroid/util/Pair;
    //   1221: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   1224: checkcast 194	java/lang/Long
    //   1227: invokevirtual 197	java/lang/Long:longValue	()J
    //   1230: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   1233: aload 10
    //   1235: aload 12
    //   1237: invokevirtual 334	java/nio/ByteBuffer:array	()[B
    //   1240: aload 12
    //   1242: invokevirtual 337	java/nio/ByteBuffer:arrayOffset	()I
    //   1245: aload 12
    //   1247: invokevirtual 339	java/nio/ByteBuffer:position	()I
    //   1250: iadd
    //   1251: aload 12
    //   1253: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1256: invokevirtual 342	java/io/RandomAccessFile:write	([BII)V
    //   1259: aload 10
    //   1261: aload 13
    //   1263: invokevirtual 334	java/nio/ByteBuffer:array	()[B
    //   1266: aload 13
    //   1268: invokevirtual 337	java/nio/ByteBuffer:arrayOffset	()I
    //   1271: aload 13
    //   1273: invokevirtual 339	java/nio/ByteBuffer:position	()I
    //   1276: iadd
    //   1277: aload 13
    //   1279: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1282: invokevirtual 342	java/io/RandomAccessFile:write	([BII)V
    //   1285: aload 10
    //   1287: aload 11
    //   1289: invokevirtual 334	java/nio/ByteBuffer:array	()[B
    //   1292: aload 11
    //   1294: invokevirtual 337	java/nio/ByteBuffer:arrayOffset	()I
    //   1297: aload 11
    //   1299: invokevirtual 339	java/nio/ByteBuffer:position	()I
    //   1302: iadd
    //   1303: aload 11
    //   1305: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1308: invokevirtual 342	java/io/RandomAccessFile:write	([BII)V
    //   1311: aload 10
    //   1313: invokevirtual 345	java/io/RandomAccessFile:getFilePointer	()J
    //   1316: lload 7
    //   1318: lcmp
    //   1319: ifeq +120 -> 1439
    //   1322: new 223	java/lang/RuntimeException
    //   1325: dup
    //   1326: new 31	java/lang/StringBuilder
    //   1329: dup
    //   1330: ldc_w 347
    //   1333: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1336: aload 10
    //   1338: invokevirtual 345	java/io/RandomAccessFile:getFilePointer	()J
    //   1341: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1344: ldc_w 352
    //   1347: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: lload 7
    //   1352: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1355: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1361: athrow
    //   1362: astore_0
    //   1363: aload 10
    //   1365: astore_1
    //   1366: aload 11
    //   1368: lload 5
    //   1370: invokestatic 324	com/tencent/mm/plugin/downloader/c/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1373: aload_1
    //   1374: ifnull +7 -> 1381
    //   1377: aload_1
    //   1378: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   1381: aload_0
    //   1382: athrow
    //   1383: aload 9
    //   1385: getfield 355	com/tencent/mm/plugin/downloader/c/a:iOC	Landroid/util/Pair;
    //   1388: getfield 114	android/util/Pair:first	Ljava/lang/Object;
    //   1391: checkcast 116	java/nio/ByteBuffer
    //   1394: astore_1
    //   1395: aload 10
    //   1397: aload 9
    //   1399: getfield 355	com/tencent/mm/plugin/downloader/c/a:iOC	Landroid/util/Pair;
    //   1402: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   1405: checkcast 194	java/lang/Long
    //   1408: invokevirtual 197	java/lang/Long:longValue	()J
    //   1411: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   1414: aload 10
    //   1416: aload_1
    //   1417: invokevirtual 334	java/nio/ByteBuffer:array	()[B
    //   1420: aload_1
    //   1421: invokevirtual 337	java/nio/ByteBuffer:arrayOffset	()I
    //   1424: aload_1
    //   1425: invokevirtual 339	java/nio/ByteBuffer:position	()I
    //   1428: iadd
    //   1429: aload_1
    //   1430: invokevirtual 120	java/nio/ByteBuffer:remaining	()I
    //   1433: invokevirtual 342	java/io/RandomAccessFile:write	([BII)V
    //   1436: goto -203 -> 1233
    //   1439: aload 10
    //   1441: lload 7
    //   1443: invokevirtual 217	java/io/RandomAccessFile:setLength	(J)V
    //   1446: ldc_w 281
    //   1449: new 31	java/lang/StringBuilder
    //   1452: dup
    //   1453: ldc_w 357
    //   1456: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1459: aload_0
    //   1460: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1463: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: ldc_w 359
    //   1469: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: aload_0
    //   1473: invokevirtual 137	java/io/File:length	()J
    //   1476: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1479: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1485: aload 11
    //   1487: lload 5
    //   1489: invokestatic 324	com/tencent/mm/plugin/downloader/c/k:c	(Ljava/nio/ByteBuffer;J)V
    //   1492: aload 10
    //   1494: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   1497: iconst_1
    //   1498: ireturn
    //   1499: ldc 29
    //   1501: new 31	java/lang/StringBuilder
    //   1504: dup
    //   1505: ldc 33
    //   1507: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1510: aload_0
    //   1511: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1514: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: ldc_w 361
    //   1520: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: invokestatic 56	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1529: iconst_0
    //   1530: ireturn
    //   1531: astore_0
    //   1532: goto -166 -> 1366
    //   1535: astore_0
    //   1536: goto -874 -> 662
    //   1539: astore_0
    //   1540: goto -1036 -> 504
    //   1543: astore_0
    //   1544: goto -1234 -> 310
    //   1547: iconst_1
    //   1548: ireturn
    //   1549: astore_0
    //   1550: aconst_null
    //   1551: astore_1
    //   1552: goto -1242 -> 310
    //   1555: astore_0
    //   1556: aload 9
    //   1558: astore_1
    //   1559: goto -1055 -> 504
    //   1562: ldc_w 363
    //   1565: astore 9
    //   1567: goto -1040 -> 527
    //   1570: astore_0
    //   1571: aload 10
    //   1573: astore_1
    //   1574: goto -912 -> 662
    //   1577: aconst_null
    //   1578: astore 9
    //   1580: goto -796 -> 784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1583	0	paramFile	java.io.File
    //   0	1583	1	paramString	java.lang.String
    //   32	1156	2	i	int
    //   443	38	3	j	int
    //   24	159	4	bool	boolean
    //   602	886	5	l1	long
    //   1183	259	7	l2	long
    //   196	1383	9	localObject1	Object
    //   193	1379	10	localObject2	Object
    //   205	1281	11	localObject3	Object
    //   355	897	12	localObject4	Object
    //   407	871	13	localObject5	Object
    //   426	128	14	str	java.lang.String
    //   225	262	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	88	121	java/lang/Exception
    //   88	121	121	java/lang/Exception
    //   198	267	121	java/lang/Exception
    //   303	307	121	java/lang/Exception
    //   314	318	121	java/lang/Exception
    //   318	320	121	java/lang/Exception
    //   320	428	121	java/lang/Exception
    //   433	444	121	java/lang/Exception
    //   497	501	121	java/lang/Exception
    //   508	512	121	java/lang/Exception
    //   512	514	121	java/lang/Exception
    //   514	523	121	java/lang/Exception
    //   527	587	121	java/lang/Exception
    //   655	659	121	java/lang/Exception
    //   666	670	121	java/lang/Exception
    //   670	672	121	java/lang/Exception
    //   706	746	746	java/io/IOException
    //   767	781	746	java/io/IOException
    //   784	867	746	java/io/IOException
    //   889	895	746	java/io/IOException
    //   898	926	746	java/io/IOException
    //   926	992	746	java/io/IOException
    //   992	1185	746	java/io/IOException
    //   1366	1373	746	java/io/IOException
    //   1377	1381	746	java/io/IOException
    //   1381	1383	746	java/io/IOException
    //   1485	1497	746	java/io/IOException
    //   706	746	867	com/tencent/mm/plugin/downloader/c/b$b
    //   767	781	867	com/tencent/mm/plugin/downloader/c/b$b
    //   784	867	867	com/tencent/mm/plugin/downloader/c/b$b
    //   889	895	867	com/tencent/mm/plugin/downloader/c/b$b
    //   898	926	867	com/tencent/mm/plugin/downloader/c/b$b
    //   926	992	867	com/tencent/mm/plugin/downloader/c/b$b
    //   992	1185	867	com/tencent/mm/plugin/downloader/c/b$b
    //   1366	1373	867	com/tencent/mm/plugin/downloader/c/b$b
    //   1377	1381	867	com/tencent/mm/plugin/downloader/c/b$b
    //   1381	1383	867	com/tencent/mm/plugin/downloader/c/b$b
    //   1485	1497	867	com/tencent/mm/plugin/downloader/c/b$b
    //   1206	1233	1362	finally
    //   1233	1362	1362	finally
    //   1383	1436	1362	finally
    //   1439	1485	1362	finally
    //   1194	1206	1531	finally
    //   598	655	1535	finally
    //   455	497	1539	finally
    //   278	303	1543	finally
    //   267	278	1549	finally
    //   444	455	1555	finally
    //   587	598	1570	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.e
 * JD-Core Version:    0.7.0.1
 */