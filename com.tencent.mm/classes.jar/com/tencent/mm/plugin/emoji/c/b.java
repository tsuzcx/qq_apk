package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.sdk.event.IListener;

public final class b
  extends IListener<bp>
{
  public b()
  {
    AppMethodBeat.i(161066);
    this.__eventId = bp.class.getName().hashCode();
    AppMethodBeat.o(161066);
  }
  
  /* Error */
  private static boolean a(bp parambp)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: instanceof 18
    //   9: ifeq +415 -> 424
    //   12: invokestatic 49	com/tencent/mm/kernel/g:aAc	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 43
    //   20: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   29: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   32: bipush 33
    //   34: if_icmpne +531 -> 565
    //   37: new 60	com/tencent/mm/vfs/o
    //   40: dup
    //   41: aload_0
    //   42: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   45: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   48: invokespecial 67	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   51: astore 12
    //   53: aload 12
    //   55: invokevirtual 70	com/tencent/mm/vfs/o:exists	()Z
    //   58: ifeq +497 -> 555
    //   61: ldc 72
    //   63: ldc 74
    //   65: iconst_1
    //   66: anewarray 76	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 12
    //   73: invokevirtual 80	com/tencent/mm/vfs/o:hes	()Lcom/tencent/mm/vfs/o;
    //   76: aastore
    //   77: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: new 60	com/tencent/mm/vfs/o
    //   83: dup
    //   84: invokestatic 90	com/tencent/mm/aq/a:bbu	()Ljava/lang/String;
    //   87: ldc 92
    //   89: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: astore 13
    //   94: new 60	com/tencent/mm/vfs/o
    //   97: dup
    //   98: aload 13
    //   100: ldc 97
    //   102: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   105: astore 14
    //   107: aload 13
    //   109: invokevirtual 103	com/tencent/mm/vfs/o:mkdirs	()Z
    //   112: pop
    //   113: aload 12
    //   115: invokevirtual 107	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   118: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aload 14
    //   123: invokevirtual 107	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   126: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   129: invokestatic 119	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   132: pop2
    //   133: aload 14
    //   135: invokevirtual 107	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   138: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   141: aload 13
    //   143: invokevirtual 107	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   146: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   149: invokestatic 123	com/tencent/mm/vfs/s:fW	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: istore 4
    //   154: iconst_1
    //   155: istore_3
    //   156: iconst_1
    //   157: istore_2
    //   158: iconst_1
    //   159: istore_1
    //   160: iload 4
    //   162: iflt +198 -> 360
    //   165: aconst_null
    //   166: astore 8
    //   168: aconst_null
    //   169: astore 6
    //   171: new 60	com/tencent/mm/vfs/o
    //   174: dup
    //   175: aload 13
    //   177: ldc 125
    //   179: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   182: invokestatic 129	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   185: astore_0
    //   186: aload_0
    //   187: astore 6
    //   189: aload_0
    //   190: astore 8
    //   192: new 131	java/io/InputStreamReader
    //   195: dup
    //   196: aload_0
    //   197: invokespecial 134	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   200: astore 7
    //   202: new 136	java/io/BufferedReader
    //   205: dup
    //   206: aload 7
    //   208: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   211: astore 6
    //   213: ldc 141
    //   215: astore 11
    //   217: aload 6
    //   219: astore 10
    //   221: aload_0
    //   222: astore 9
    //   224: aload 7
    //   226: astore 8
    //   228: iload_2
    //   229: istore_1
    //   230: aload 6
    //   232: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   235: astore 15
    //   237: aload 15
    //   239: ifnull +41 -> 280
    //   242: aload 6
    //   244: astore 10
    //   246: aload_0
    //   247: astore 9
    //   249: aload 7
    //   251: astore 8
    //   253: iload_2
    //   254: istore_1
    //   255: new 146	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   262: aload 11
    //   264: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 15
    //   269: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: astore 11
    //   277: goto -60 -> 217
    //   280: aload 6
    //   282: astore 10
    //   284: aload_0
    //   285: astore 9
    //   287: aload 7
    //   289: astore 8
    //   291: iload_2
    //   292: istore_1
    //   293: new 156	org/json/JSONObject
    //   296: dup
    //   297: aload 11
    //   299: invokespecial 157	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   302: ldc 159
    //   304: invokevirtual 163	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   307: istore_2
    //   308: aload 6
    //   310: astore 10
    //   312: aload_0
    //   313: astore 9
    //   315: aload 7
    //   317: astore 8
    //   319: iload_2
    //   320: istore_1
    //   321: ldc 72
    //   323: ldc 165
    //   325: iconst_2
    //   326: anewarray 76	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 11
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: iload_2
    //   337: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: aload_0
    //   345: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   348: aload 7
    //   350: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   353: aload 6
    //   355: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   358: iload_2
    //   359: istore_1
    //   360: aload 13
    //   362: getfield 184	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   365: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   368: iconst_1
    //   369: invokestatic 188	com/tencent/mm/vfs/s:dy	(Ljava/lang/String;Z)Z
    //   372: pop
    //   373: aload 14
    //   375: getfield 184	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   378: invokestatic 113	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   381: invokestatic 192	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   384: pop
    //   385: getstatic 195	com/tencent/mm/aq/a:iUo	I
    //   388: iload_1
    //   389: if_icmpge +136 -> 525
    //   392: ldc 72
    //   394: ldc 197
    //   396: iconst_2
    //   397: anewarray 76	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: getstatic 195	com/tencent/mm/aq/a:iUo	I
    //   405: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: aastore
    //   409: dup
    //   410: iconst_1
    //   411: iload_1
    //   412: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload 12
    //   421: invokestatic 201	com/tencent/mm/aq/a:k	(Lcom/tencent/mm/vfs/o;)V
    //   424: ldc 43
    //   426: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore 11
    //   433: aconst_null
    //   434: astore 8
    //   436: aconst_null
    //   437: astore 7
    //   439: aload 6
    //   441: astore_0
    //   442: aload 8
    //   444: astore 6
    //   446: iload_3
    //   447: istore_1
    //   448: aload 6
    //   450: astore 10
    //   452: aload_0
    //   453: astore 9
    //   455: aload 7
    //   457: astore 8
    //   459: ldc 72
    //   461: aload 11
    //   463: aload 11
    //   465: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: iconst_0
    //   469: anewarray 76	java/lang/Object
    //   472: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload_0
    //   476: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   479: aload 7
    //   481: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   484: aload 6
    //   486: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   489: goto -129 -> 360
    //   492: astore 6
    //   494: aconst_null
    //   495: astore 10
    //   497: aconst_null
    //   498: astore 7
    //   500: aload 8
    //   502: astore_0
    //   503: aload_0
    //   504: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   507: aload 7
    //   509: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   512: aload 10
    //   514: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   517: ldc 43
    //   519: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: aload 6
    //   524: athrow
    //   525: ldc 72
    //   527: ldc 210
    //   529: iconst_2
    //   530: anewarray 76	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: getstatic 195	com/tencent/mm/aq/a:iUo	I
    //   538: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: iload_1
    //   545: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: goto -128 -> 424
    //   555: ldc 72
    //   557: ldc 212
    //   559: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: goto -138 -> 424
    //   565: aload_0
    //   566: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   569: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   572: bipush 37
    //   574: if_icmpne -150 -> 424
    //   577: aload_0
    //   578: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   581: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   584: iconst_1
    //   585: if_icmpne +13 -> 598
    //   588: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   591: aload_0
    //   592: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/g/a/bp;)V
    //   595: goto -171 -> 424
    //   598: aload_0
    //   599: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   602: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   605: iconst_2
    //   606: if_icmpne +557 -> 1163
    //   609: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   612: astore 8
    //   614: getstatic 234	com/tencent/mm/plugin/emoji/e/h$a:raq	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   617: astore 6
    //   619: aload 8
    //   621: aload 6
    //   623: invokevirtual 237	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   626: astore 7
    //   628: aload 6
    //   630: invokestatic 240	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   633: istore_1
    //   634: aload_0
    //   635: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   638: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   641: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   644: invokestatic 247	com/tencent/mm/plugin/emoji/e/h:fV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   647: istore 5
    //   649: aload 7
    //   651: iload_1
    //   652: new 60	com/tencent/mm/vfs/o
    //   655: dup
    //   656: new 146	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   663: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   666: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: ldc 252
    //   671: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   677: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: getstatic 255	com/tencent/mm/plugin/emoji/e/h:qZR	Ljava/lang/String;
    //   686: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: invokestatic 259	com/tencent/mm/plugin/emoji/e/h:N	(Lcom/tencent/mm/vfs/o;)I
    //   692: invokevirtual 265	com/tencent/mm/emoji/c/f:cK	(II)V
    //   695: aload 7
    //   697: iload 5
    //   699: invokevirtual 269	com/tencent/mm/emoji/c/f:ee	(Z)V
    //   702: aload 7
    //   704: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   707: iconst_0
    //   708: putfield 278	com/tencent/mm/g/b/a/ap:eqa	I
    //   711: aload 7
    //   713: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   716: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   719: pop
    //   720: iload 5
    //   722: ifeq +429 -> 1151
    //   725: new 146	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   732: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   735: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc 252
    //   740: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   746: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: new 146	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   759: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   762: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc 252
    //   767: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: getstatic 284	com/tencent/mm/plugin/emoji/e/h:qZK	Ljava/lang/String;
    //   773: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 287	com/tencent/mm/vfs/s:cL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   782: pop
    //   783: new 60	com/tencent/mm/vfs/o
    //   786: dup
    //   787: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   790: getstatic 284	com/tencent/mm/plugin/emoji/e/h:qZK	Ljava/lang/String;
    //   793: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: astore 9
    //   798: invokestatic 292	com/tencent/mm/emoji/b/n:avb	()Ljava/lang/String;
    //   801: astore 7
    //   803: aload 7
    //   805: invokestatic 295	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   808: ifeq +266 -> 1074
    //   811: getstatic 298	com/tencent/mm/plugin/emoji/e/h:qZZ	Ljava/lang/String;
    //   814: astore 6
    //   816: ldc_w 300
    //   819: ldc_w 302
    //   822: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: new 60	com/tencent/mm/vfs/o
    //   828: dup
    //   829: aload 9
    //   831: aload 6
    //   833: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   836: astore 7
    //   838: aload 7
    //   840: invokevirtual 70	com/tencent/mm/vfs/o:exists	()Z
    //   843: ifeq +296 -> 1139
    //   846: aload 7
    //   848: invokestatic 309	com/tencent/mm/emoji/e/b:e	(Lcom/tencent/mm/vfs/o;)Ljava/util/ArrayList;
    //   851: astore 7
    //   853: aload 8
    //   855: getstatic 234	com/tencent/mm/plugin/emoji/e/h$a:raq	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   858: invokevirtual 237	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   861: astore 8
    //   863: aload 7
    //   865: invokevirtual 314	java/util/ArrayList:isEmpty	()Z
    //   868: ifne +253 -> 1121
    //   871: iconst_1
    //   872: istore 5
    //   874: aload 8
    //   876: iload 5
    //   878: invokevirtual 317	com/tencent/mm/emoji/c/f:ef	(Z)V
    //   881: aload 8
    //   883: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   886: aload 7
    //   888: invokevirtual 320	java/util/ArrayList:size	()I
    //   891: putfield 278	com/tencent/mm/g/b/a/ap:eqa	I
    //   894: aload 8
    //   896: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   899: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   902: pop
    //   903: aload 7
    //   905: invokevirtual 314	java/util/ArrayList:isEmpty	()Z
    //   908: ifne +219 -> 1127
    //   911: ldc_w 322
    //   914: invokestatic 326	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   917: checkcast 322	com/tencent/mm/plugin/emoji/b/d
    //   920: invokeinterface 330 1 0
    //   925: aload 7
    //   927: invokeinterface 336 2 0
    //   932: ifeq +91 -> 1023
    //   935: new 338	com/tencent/mm/g/a/dh
    //   938: dup
    //   939: invokespecial 339	com/tencent/mm/g/a/dh:<init>	()V
    //   942: astore 7
    //   944: aload 7
    //   946: getfield 343	com/tencent/mm/g/a/dh:dGr	Lcom/tencent/mm/g/a/dh$a;
    //   949: iconst_2
    //   950: putfield 346	com/tencent/mm/g/a/dh$a:subType	I
    //   953: getstatic 352	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   956: aload 7
    //   958: invokevirtual 356	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   961: pop
    //   962: new 60	com/tencent/mm/vfs/o
    //   965: dup
    //   966: new 146	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   973: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   976: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: ldc 252
    //   981: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: getstatic 284	com/tencent/mm/plugin/emoji/e/h:qZK	Ljava/lang/String;
    //   987: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: getstatic 255	com/tencent/mm/plugin/emoji/e/h:qZR	Ljava/lang/String;
    //   996: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: invokestatic 259	com/tencent/mm/plugin/emoji/e/h:N	(Lcom/tencent/mm/vfs/o;)I
    //   1002: putstatic 359	com/tencent/mm/plugin/emoji/e/h:rah	I
    //   1005: invokestatic 363	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   1008: invokevirtual 369	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   1011: getstatic 375	com/tencent/mm/storage/ar$a:NTc	Lcom/tencent/mm/storage/ar$a;
    //   1014: getstatic 359	com/tencent/mm/plugin/emoji/e/h:rah	I
    //   1017: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1020: invokevirtual 381	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1023: invokestatic 363	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   1026: invokevirtual 369	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   1029: getstatic 384	com/tencent/mm/storage/ar$a:NTf	Lcom/tencent/mm/storage/ar$a;
    //   1032: aload 6
    //   1034: invokevirtual 381	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1037: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1040: aload_0
    //   1041: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1044: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   1047: aload_0
    //   1048: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1051: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1054: aload_0
    //   1055: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1058: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   1061: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   1064: getstatic 403	com/tencent/mm/emoji/a/f:gVz	Lcom/tencent/mm/emoji/a/f$a;
    //   1067: astore_0
    //   1068: invokestatic 408	com/tencent/mm/emoji/a/f$a:auy	()V
    //   1071: goto -647 -> 424
    //   1074: aload 7
    //   1076: astore 6
    //   1078: new 60	com/tencent/mm/vfs/o
    //   1081: dup
    //   1082: aload 9
    //   1084: aload 7
    //   1086: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   1089: invokevirtual 70	com/tencent/mm/vfs/o:exists	()Z
    //   1092: ifne +8 -> 1100
    //   1095: getstatic 298	com/tencent/mm/plugin/emoji/e/h:qZZ	Ljava/lang/String;
    //   1098: astore 6
    //   1100: ldc_w 300
    //   1103: ldc_w 410
    //   1106: iconst_1
    //   1107: anewarray 76	java/lang/Object
    //   1110: dup
    //   1111: iconst_0
    //   1112: aload 6
    //   1114: aastore
    //   1115: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1118: goto -293 -> 825
    //   1121: iconst_0
    //   1122: istore 5
    //   1124: goto -250 -> 874
    //   1127: ldc_w 300
    //   1130: ldc_w 412
    //   1133: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1136: goto -113 -> 1023
    //   1139: ldc_w 300
    //   1142: ldc_w 414
    //   1145: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: goto -84 -> 1064
    //   1151: ldc_w 300
    //   1154: ldc_w 416
    //   1157: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: goto -736 -> 424
    //   1163: aload_0
    //   1164: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1167: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1170: iconst_3
    //   1171: if_icmpne +274 -> 1445
    //   1174: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1177: astore 7
    //   1179: getstatic 419	com/tencent/mm/plugin/emoji/e/h$a:rar	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1182: astore 6
    //   1184: aload 7
    //   1186: aload 6
    //   1188: invokevirtual 237	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1191: astore 7
    //   1193: aload 6
    //   1195: invokestatic 240	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   1198: istore_1
    //   1199: aload_0
    //   1200: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1203: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   1206: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1209: invokestatic 247	com/tencent/mm/plugin/emoji/e/h:fV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1212: istore 5
    //   1214: aload 7
    //   1216: iload_1
    //   1217: new 60	com/tencent/mm/vfs/o
    //   1220: dup
    //   1221: new 146	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1228: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1231: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc 252
    //   1236: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1242: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1248: getstatic 255	com/tencent/mm/plugin/emoji/e/h:qZR	Ljava/lang/String;
    //   1251: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1254: invokestatic 259	com/tencent/mm/plugin/emoji/e/h:N	(Lcom/tencent/mm/vfs/o;)I
    //   1257: invokevirtual 265	com/tencent/mm/emoji/c/f:cK	(II)V
    //   1260: aload 7
    //   1262: iload 5
    //   1264: invokevirtual 269	com/tencent/mm/emoji/c/f:ee	(Z)V
    //   1267: aload 7
    //   1269: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1272: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1275: pop
    //   1276: iload 5
    //   1278: ifeq +155 -> 1433
    //   1281: new 146	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1288: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1291: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: ldc 252
    //   1296: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1302: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1308: new 146	java/lang/StringBuilder
    //   1311: dup
    //   1312: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1315: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1318: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: ldc 252
    //   1323: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: getstatic 422	com/tencent/mm/plugin/emoji/e/h:qZL	Ljava/lang/String;
    //   1329: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 287	com/tencent/mm/vfs/s:cL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1338: pop
    //   1339: new 60	com/tencent/mm/vfs/o
    //   1342: dup
    //   1343: new 60	com/tencent/mm/vfs/o
    //   1346: dup
    //   1347: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1350: getstatic 422	com/tencent/mm/plugin/emoji/e/h:qZL	Ljava/lang/String;
    //   1353: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1356: getstatic 425	com/tencent/mm/plugin/emoji/e/h:raa	Ljava/lang/String;
    //   1359: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   1362: astore 6
    //   1364: aload 6
    //   1366: invokevirtual 70	com/tencent/mm/vfs/o:exists	()Z
    //   1369: ifeq +52 -> 1421
    //   1372: aload 7
    //   1374: aload 6
    //   1376: invokestatic 429	com/tencent/mm/plugin/emoji/e/h:P	(Lcom/tencent/mm/vfs/o;)Z
    //   1379: invokevirtual 317	com/tencent/mm/emoji/c/f:ef	(Z)V
    //   1382: aload 7
    //   1384: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1387: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1390: pop
    //   1391: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1394: aload_0
    //   1395: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1398: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   1401: aload_0
    //   1402: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1405: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1408: aload_0
    //   1409: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1412: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   1415: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   1418: goto -994 -> 424
    //   1421: ldc_w 300
    //   1424: ldc_w 431
    //   1427: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1430: goto -39 -> 1391
    //   1433: ldc_w 300
    //   1436: ldc_w 433
    //   1439: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1442: goto -1018 -> 424
    //   1445: aload_0
    //   1446: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1449: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1452: iconst_5
    //   1453: if_icmpne +285 -> 1738
    //   1456: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1459: astore 6
    //   1461: getstatic 436	com/tencent/mm/plugin/emoji/e/h$a:rat	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1464: astore 8
    //   1466: aload 6
    //   1468: aload 8
    //   1470: invokevirtual 237	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1473: astore 7
    //   1475: aload 8
    //   1477: invokestatic 240	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   1480: istore_1
    //   1481: aload_0
    //   1482: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1485: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   1488: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1491: invokestatic 247	com/tencent/mm/plugin/emoji/e/h:fV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1494: istore 5
    //   1496: aload 7
    //   1498: iload_1
    //   1499: new 60	com/tencent/mm/vfs/o
    //   1502: dup
    //   1503: new 146	java/lang/StringBuilder
    //   1506: dup
    //   1507: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1510: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1513: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: ldc 252
    //   1518: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1524: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1530: getstatic 255	com/tencent/mm/plugin/emoji/e/h:qZR	Ljava/lang/String;
    //   1533: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1536: invokestatic 259	com/tencent/mm/plugin/emoji/e/h:N	(Lcom/tencent/mm/vfs/o;)I
    //   1539: invokevirtual 265	com/tencent/mm/emoji/c/f:cK	(II)V
    //   1542: aload 7
    //   1544: iload 5
    //   1546: invokevirtual 269	com/tencent/mm/emoji/c/f:ee	(Z)V
    //   1549: aload 7
    //   1551: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1554: iconst_0
    //   1555: putfield 278	com/tencent/mm/g/b/a/ap:eqa	I
    //   1558: aload 7
    //   1560: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1563: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1566: pop
    //   1567: iload 5
    //   1569: ifeq +157 -> 1726
    //   1572: new 146	java/lang/StringBuilder
    //   1575: dup
    //   1576: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1579: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1582: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: ldc 252
    //   1587: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: getstatic 243	com/tencent/mm/plugin/emoji/e/h:qZI	Ljava/lang/String;
    //   1593: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: new 146	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1606: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1609: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: ldc 252
    //   1614: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: getstatic 439	com/tencent/mm/plugin/emoji/e/h:qZM	Ljava/lang/String;
    //   1620: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1626: invokestatic 287	com/tencent/mm/vfs/s:cL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1629: pop
    //   1630: new 60	com/tencent/mm/vfs/o
    //   1633: dup
    //   1634: new 60	com/tencent/mm/vfs/o
    //   1637: dup
    //   1638: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1641: getstatic 439	com/tencent/mm/plugin/emoji/e/h:qZM	Ljava/lang/String;
    //   1644: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1647: getstatic 442	com/tencent/mm/plugin/emoji/e/h:rab	Ljava/lang/String;
    //   1650: invokespecial 100	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   1653: astore 8
    //   1655: aload 8
    //   1657: invokevirtual 70	com/tencent/mm/vfs/o:exists	()Z
    //   1660: ifeq +54 -> 1714
    //   1663: aload 7
    //   1665: aload 6
    //   1667: aload 8
    //   1669: invokevirtual 445	com/tencent/mm/plugin/emoji/e/h:Q	(Lcom/tencent/mm/vfs/o;)Z
    //   1672: invokevirtual 317	com/tencent/mm/emoji/c/f:ef	(Z)V
    //   1675: aload 7
    //   1677: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1680: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1683: pop
    //   1684: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1687: aload_0
    //   1688: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1691: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   1694: aload_0
    //   1695: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1698: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1701: aload_0
    //   1702: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1705: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   1708: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   1711: goto -1287 -> 424
    //   1714: ldc_w 300
    //   1717: ldc_w 447
    //   1720: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1723: goto -1299 -> 424
    //   1726: ldc_w 300
    //   1729: ldc_w 447
    //   1732: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1735: goto -1311 -> 424
    //   1738: aload_0
    //   1739: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1742: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1745: iconst_4
    //   1746: if_icmpne +105 -> 1851
    //   1749: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1752: pop
    //   1753: ldc_w 300
    //   1756: ldc_w 449
    //   1759: invokestatic 451	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1762: new 261	com/tencent/mm/emoji/c/f
    //   1765: dup
    //   1766: invokespecial 452	com/tencent/mm/emoji/c/f:<init>	()V
    //   1769: astore 6
    //   1771: aload 6
    //   1773: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1776: iconst_4
    //   1777: putfield 455	com/tencent/mm/g/b/a/ap:eqd	I
    //   1780: aload_0
    //   1781: invokestatic 458	com/tencent/mm/plugin/emoji/e/h:c	(Lcom/tencent/mm/g/a/bp;)Z
    //   1784: ifeq +37 -> 1821
    //   1787: invokestatic 464	com/tencent/mm/ce/b:gxI	()Lcom/tencent/mm/ce/b;
    //   1790: pop
    //   1791: aload_0
    //   1792: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1795: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   1798: invokestatic 467	com/tencent/mm/ce/b:bhX	(Ljava/lang/String;)V
    //   1801: aload 6
    //   1803: invokestatic 464	com/tencent/mm/ce/b:gxI	()Lcom/tencent/mm/ce/b;
    //   1806: invokevirtual 470	com/tencent/mm/ce/b:init	()Z
    //   1809: invokevirtual 317	com/tencent/mm/emoji/c/f:ef	(Z)V
    //   1812: aload 6
    //   1814: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1817: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1820: pop
    //   1821: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1824: aload_0
    //   1825: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1828: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   1831: aload_0
    //   1832: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1835: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1838: aload_0
    //   1839: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1842: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   1845: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   1848: goto -1424 -> 424
    //   1851: aload_0
    //   1852: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1855: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1858: bipush 6
    //   1860: if_icmpne +102 -> 1962
    //   1863: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1866: getstatic 473	com/tencent/mm/plugin/emoji/e/h$a:rau	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1869: invokevirtual 237	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1872: astore 6
    //   1874: aload_0
    //   1875: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1878: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   1881: getstatic 476	com/tencent/mm/plugin/emoji/e/h:qZO	Ljava/lang/String;
    //   1884: invokestatic 247	com/tencent/mm/plugin/emoji/e/h:fV	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1887: istore 5
    //   1889: aload 6
    //   1891: iload 5
    //   1893: invokevirtual 269	com/tencent/mm/emoji/c/f:ee	(Z)V
    //   1896: aload 6
    //   1898: getfield 273	com/tencent/mm/emoji/c/f:hcm	Lcom/tencent/mm/g/b/a/ap;
    //   1901: invokevirtual 281	com/tencent/mm/g/b/a/ap:bfK	()Z
    //   1904: pop
    //   1905: iload 5
    //   1907: ifeq -1483 -> 424
    //   1910: new 60	com/tencent/mm/vfs/o
    //   1913: dup
    //   1914: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1917: getstatic 476	com/tencent/mm/plugin/emoji/e/h:qZO	Ljava/lang/String;
    //   1920: invokespecial 95	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1923: pop
    //   1924: getstatic 482	com/tencent/mm/emoji/b/c/g:gZH	Lcom/tencent/mm/emoji/b/c/g;
    //   1927: astore 6
    //   1929: invokestatic 485	com/tencent/mm/emoji/b/c/g:avL	()V
    //   1932: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1935: aload_0
    //   1936: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1939: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   1942: aload_0
    //   1943: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1946: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1949: aload_0
    //   1950: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1953: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   1956: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   1959: goto -1535 -> 424
    //   1962: aload_0
    //   1963: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1966: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   1969: bipush 7
    //   1971: if_icmpne +49 -> 2020
    //   1974: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1977: aload_0
    //   1978: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1981: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   1984: invokevirtual 488	com/tencent/mm/plugin/emoji/e/h:amD	(Ljava/lang/String;)Z
    //   1987: ifeq -1563 -> 424
    //   1990: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   1993: aload_0
    //   1994: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   1997: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   2000: aload_0
    //   2001: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2004: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   2007: aload_0
    //   2008: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2011: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   2014: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   2017: goto -1593 -> 424
    //   2020: aload_0
    //   2021: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2024: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   2027: bipush 9
    //   2029: if_icmpne -1605 -> 424
    //   2032: invokestatic 224	com/tencent/mm/plugin/emoji/e/h:cFT	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   2035: aload_0
    //   2036: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2039: getfield 64	com/tencent/mm/g/a/bp$a:filePath	Ljava/lang/String;
    //   2042: invokevirtual 491	com/tencent/mm/plugin/emoji/e/h:aiX	(Ljava/lang/String;)I
    //   2045: ifle -1621 -> 424
    //   2048: invokestatic 390	com/tencent/mm/pluginsdk/j/a/a/b:gnC	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   2051: aload_0
    //   2052: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2055: getfield 58	com/tencent/mm/g/a/bp$a:dEO	I
    //   2058: aload_0
    //   2059: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2062: getfield 218	com/tencent/mm/g/a/bp$a:subType	I
    //   2065: aload_0
    //   2066: getfield 53	com/tencent/mm/g/a/bp:dEN	Lcom/tencent/mm/g/a/bp$a;
    //   2069: getfield 393	com/tencent/mm/g/a/bp$a:dEP	I
    //   2072: invokevirtual 397	com/tencent/mm/pluginsdk/j/a/a/b:aP	(III)V
    //   2075: goto -1651 -> 424
    //   2078: astore 6
    //   2080: aconst_null
    //   2081: astore 10
    //   2083: goto -1580 -> 503
    //   2086: astore 6
    //   2088: aload 9
    //   2090: astore_0
    //   2091: aload 8
    //   2093: astore 7
    //   2095: goto -1592 -> 503
    //   2098: astore 11
    //   2100: aconst_null
    //   2101: astore 6
    //   2103: iload_3
    //   2104: istore_1
    //   2105: goto -1657 -> 448
    //   2108: astore 11
    //   2110: goto -1662 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2113	0	parambp	bp
    //   159	1946	1	i	int
    //   157	202	2	j	int
    //   155	1949	3	k	int
    //   152	9	4	m	int
    //   647	1259	5	bool	boolean
    //   169	316	6	localObject1	java.lang.Object
    //   492	31	6	localObject2	java.lang.Object
    //   617	1311	6	localObject3	java.lang.Object
    //   2078	1	6	localObject4	java.lang.Object
    //   2086	1	6	localObject5	java.lang.Object
    //   2101	1	6	localObject6	java.lang.Object
    //   200	1894	7	localObject7	java.lang.Object
    //   166	1926	8	localObject8	java.lang.Object
    //   222	1867	9	localObject9	java.lang.Object
    //   219	1863	10	localObject10	java.lang.Object
    //   215	117	11	str1	String
    //   431	33	11	localException1	java.lang.Exception
    //   2098	1	11	localException2	java.lang.Exception
    //   2108	1	11	localException3	java.lang.Exception
    //   51	369	12	localo1	com.tencent.mm.vfs.o
    //   92	269	13	localo2	com.tencent.mm.vfs.o
    //   105	269	14	localo3	com.tencent.mm.vfs.o
    //   235	33	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   171	186	431	java/lang/Exception
    //   192	202	431	java/lang/Exception
    //   171	186	492	finally
    //   192	202	492	finally
    //   202	213	2078	finally
    //   230	237	2086	finally
    //   255	277	2086	finally
    //   293	308	2086	finally
    //   321	344	2086	finally
    //   459	475	2086	finally
    //   202	213	2098	java/lang/Exception
    //   230	237	2108	java/lang/Exception
    //   255	277	2108	java/lang/Exception
    //   293	308	2108	java/lang/Exception
    //   321	344	2108	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */