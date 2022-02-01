package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.sdk.event.IListener;

public final class b
  extends IListener<bu>
{
  public b()
  {
    AppMethodBeat.i(161066);
    this.__eventId = bu.class.getName().hashCode();
    AppMethodBeat.o(161066);
  }
  
  /* Error */
  private static boolean a(bu parambu)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: instanceof 18
    //   9: ifeq +396 -> 405
    //   12: invokestatic 49	com/tencent/mm/kernel/h:aHB	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 43
    //   20: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   29: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   32: bipush 33
    //   34: if_icmpne +512 -> 546
    //   37: new 60	com/tencent/mm/vfs/q
    //   40: dup
    //   41: aload_0
    //   42: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   45: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   48: invokespecial 67	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   51: astore 12
    //   53: aload 12
    //   55: invokevirtual 70	com/tencent/mm/vfs/q:ifE	()Z
    //   58: ifeq +478 -> 536
    //   61: ldc 72
    //   63: ldc 74
    //   65: iconst_1
    //   66: anewarray 76	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 12
    //   73: invokevirtual 80	com/tencent/mm/vfs/q:ifG	()Lcom/tencent/mm/vfs/q;
    //   76: aastore
    //   77: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: new 60	com/tencent/mm/vfs/q
    //   83: dup
    //   84: invokestatic 90	com/tencent/mm/at/a:bkK	()Ljava/lang/String;
    //   87: ldc 92
    //   89: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: astore 13
    //   94: new 60	com/tencent/mm/vfs/q
    //   97: dup
    //   98: aload 13
    //   100: ldc 97
    //   102: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   105: astore 14
    //   107: aload 13
    //   109: invokevirtual 103	com/tencent/mm/vfs/q:ifL	()Z
    //   112: pop
    //   113: aload 12
    //   115: invokevirtual 106	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   118: aload 14
    //   120: invokevirtual 106	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   123: invokestatic 112	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   126: pop2
    //   127: aload 14
    //   129: invokevirtual 106	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   132: aload 13
    //   134: invokevirtual 106	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   137: invokestatic 116	com/tencent/mm/vfs/u:gj	(Ljava/lang/String;Ljava/lang/String;)I
    //   140: istore 4
    //   142: iconst_1
    //   143: istore_3
    //   144: iconst_1
    //   145: istore_2
    //   146: iconst_1
    //   147: istore_1
    //   148: iload 4
    //   150: iflt +198 -> 348
    //   153: aconst_null
    //   154: astore 8
    //   156: aconst_null
    //   157: astore 6
    //   159: new 60	com/tencent/mm/vfs/q
    //   162: dup
    //   163: aload 13
    //   165: ldc 118
    //   167: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   170: invokestatic 122	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   173: astore_0
    //   174: aload_0
    //   175: astore 6
    //   177: aload_0
    //   178: astore 8
    //   180: new 124	java/io/InputStreamReader
    //   183: dup
    //   184: aload_0
    //   185: invokespecial 127	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore 7
    //   190: new 129	java/io/BufferedReader
    //   193: dup
    //   194: aload 7
    //   196: invokespecial 132	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   199: astore 6
    //   201: ldc 134
    //   203: astore 11
    //   205: aload 6
    //   207: astore 10
    //   209: aload_0
    //   210: astore 9
    //   212: aload 7
    //   214: astore 8
    //   216: iload_2
    //   217: istore_1
    //   218: aload 6
    //   220: invokevirtual 137	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 15
    //   225: aload 15
    //   227: ifnull +41 -> 268
    //   230: aload 6
    //   232: astore 10
    //   234: aload_0
    //   235: astore 9
    //   237: aload 7
    //   239: astore 8
    //   241: iload_2
    //   242: istore_1
    //   243: new 139	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   250: aload 11
    //   252: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 15
    //   257: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 11
    //   265: goto -60 -> 205
    //   268: aload 6
    //   270: astore 10
    //   272: aload_0
    //   273: astore 9
    //   275: aload 7
    //   277: astore 8
    //   279: iload_2
    //   280: istore_1
    //   281: new 149	org/json/JSONObject
    //   284: dup
    //   285: aload 11
    //   287: invokespecial 150	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   290: ldc 152
    //   292: invokevirtual 156	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   295: istore_2
    //   296: aload 6
    //   298: astore 10
    //   300: aload_0
    //   301: astore 9
    //   303: aload 7
    //   305: astore 8
    //   307: iload_2
    //   308: istore_1
    //   309: ldc 72
    //   311: ldc 158
    //   313: iconst_2
    //   314: anewarray 76	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload 11
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: iload_2
    //   325: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: aastore
    //   329: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload_0
    //   333: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   336: aload 7
    //   338: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   341: aload 6
    //   343: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   346: iload_2
    //   347: istore_1
    //   348: aload 13
    //   350: invokevirtual 176	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   353: invokestatic 180	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   356: pop
    //   357: aload 14
    //   359: invokevirtual 176	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   362: invokestatic 183	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   365: pop
    //   366: getstatic 186	com/tencent/mm/at/a:lKH	I
    //   369: iload_1
    //   370: if_icmpge +136 -> 506
    //   373: ldc 72
    //   375: ldc 188
    //   377: iconst_2
    //   378: anewarray 76	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: getstatic 186	com/tencent/mm/at/a:lKH	I
    //   386: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: iload_1
    //   393: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: aastore
    //   397: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: aload 12
    //   402: invokestatic 192	com/tencent/mm/at/a:k	(Lcom/tencent/mm/vfs/q;)V
    //   405: ldc 43
    //   407: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: iconst_0
    //   411: ireturn
    //   412: astore 11
    //   414: aconst_null
    //   415: astore 8
    //   417: aconst_null
    //   418: astore 7
    //   420: aload 6
    //   422: astore_0
    //   423: aload 8
    //   425: astore 6
    //   427: iload_3
    //   428: istore_1
    //   429: aload 6
    //   431: astore 10
    //   433: aload_0
    //   434: astore 9
    //   436: aload 7
    //   438: astore 8
    //   440: ldc 72
    //   442: aload 11
    //   444: aload 11
    //   446: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: iconst_0
    //   450: anewarray 76	java/lang/Object
    //   453: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: aload_0
    //   457: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   460: aload 7
    //   462: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   465: aload 6
    //   467: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   470: goto -122 -> 348
    //   473: astore 6
    //   475: aconst_null
    //   476: astore 10
    //   478: aconst_null
    //   479: astore 7
    //   481: aload 8
    //   483: astore_0
    //   484: aload_0
    //   485: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   488: aload 7
    //   490: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   493: aload 10
    //   495: invokestatic 173	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   498: ldc 43
    //   500: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: aload 6
    //   505: athrow
    //   506: ldc 72
    //   508: ldc 201
    //   510: iconst_2
    //   511: anewarray 76	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: getstatic 186	com/tencent/mm/at/a:lKH	I
    //   519: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: iload_1
    //   526: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   533: goto -128 -> 405
    //   536: ldc 72
    //   538: ldc 203
    //   540: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: goto -138 -> 405
    //   546: aload_0
    //   547: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   550: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   553: bipush 37
    //   555: if_icmpne -150 -> 405
    //   558: aload_0
    //   559: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   562: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   565: iconst_1
    //   566: if_icmpne +13 -> 579
    //   569: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   572: aload_0
    //   573: invokevirtual 219	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/f/a/bu;)V
    //   576: goto -171 -> 405
    //   579: aload_0
    //   580: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   583: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   586: iconst_2
    //   587: if_icmpne +588 -> 1175
    //   590: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   593: astore 8
    //   595: getstatic 225	com/tencent/mm/plugin/emoji/e/h$a:uDr	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   598: astore 6
    //   600: aload 8
    //   602: aload 6
    //   604: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   607: astore 7
    //   609: aload 6
    //   611: invokestatic 231	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   614: istore_1
    //   615: aload_0
    //   616: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   619: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   622: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   625: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:gi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   628: istore 5
    //   630: aload 7
    //   632: iload_1
    //   633: new 60	com/tencent/mm/vfs/q
    //   636: dup
    //   637: new 139	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   644: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   647: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc 243
    //   652: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   658: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: getstatic 246	com/tencent/mm/plugin/emoji/e/h:uCS	Ljava/lang/String;
    //   667: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:M	(Lcom/tencent/mm/vfs/q;)I
    //   673: invokevirtual 256	com/tencent/mm/emoji/c/f:de	(II)V
    //   676: aload 7
    //   678: iload 5
    //   680: invokevirtual 260	com/tencent/mm/emoji/c/f:eB	(Z)V
    //   683: aload 7
    //   685: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   688: iconst_0
    //   689: putfield 269	com/tencent/mm/f/b/a/ax:glm	I
    //   692: aload 7
    //   694: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   697: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   700: pop
    //   701: iload 5
    //   703: ifeq +460 -> 1163
    //   706: new 139	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   713: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   716: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: ldc 243
    //   721: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: getstatic 275	com/tencent/mm/plugin/emoji/e/h:uCL	Ljava/lang/String;
    //   727: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 180	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   736: pop
    //   737: new 139	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   744: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   747: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: ldc 243
    //   752: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   758: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: new 139	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   771: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   774: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc 243
    //   779: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: getstatic 275	com/tencent/mm/plugin/emoji/e/h:uCL	Ljava/lang/String;
    //   785: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokestatic 278	com/tencent/mm/vfs/u:or	(Ljava/lang/String;Ljava/lang/String;)Z
    //   794: pop
    //   795: new 60	com/tencent/mm/vfs/q
    //   798: dup
    //   799: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   802: getstatic 275	com/tencent/mm/plugin/emoji/e/h:uCL	Ljava/lang/String;
    //   805: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: astore 9
    //   810: invokestatic 283	com/tencent/mm/emoji/b/o:aBW	()Ljava/lang/String;
    //   813: astore 7
    //   815: aload 7
    //   817: invokestatic 286	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   820: ifeq +266 -> 1086
    //   823: getstatic 289	com/tencent/mm/plugin/emoji/e/h:uDa	Ljava/lang/String;
    //   826: astore 6
    //   828: ldc_w 291
    //   831: ldc_w 293
    //   834: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   837: new 60	com/tencent/mm/vfs/q
    //   840: dup
    //   841: aload 9
    //   843: aload 6
    //   845: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   848: astore 7
    //   850: aload 7
    //   852: invokevirtual 70	com/tencent/mm/vfs/q:ifE	()Z
    //   855: ifeq +296 -> 1151
    //   858: aload 7
    //   860: invokestatic 300	com/tencent/mm/emoji/e/b:e	(Lcom/tencent/mm/vfs/q;)Ljava/util/ArrayList;
    //   863: astore 7
    //   865: aload 8
    //   867: getstatic 225	com/tencent/mm/plugin/emoji/e/h$a:uDr	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   870: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   873: astore 8
    //   875: aload 7
    //   877: invokevirtual 305	java/util/ArrayList:isEmpty	()Z
    //   880: ifne +253 -> 1133
    //   883: iconst_1
    //   884: istore 5
    //   886: aload 8
    //   888: iload 5
    //   890: invokevirtual 308	com/tencent/mm/emoji/c/f:eC	(Z)V
    //   893: aload 8
    //   895: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   898: aload 7
    //   900: invokevirtual 311	java/util/ArrayList:size	()I
    //   903: putfield 269	com/tencent/mm/f/b/a/ax:glm	I
    //   906: aload 8
    //   908: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   911: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   914: pop
    //   915: aload 7
    //   917: invokevirtual 305	java/util/ArrayList:isEmpty	()Z
    //   920: ifne +219 -> 1139
    //   923: ldc_w 313
    //   926: invokestatic 317	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   929: checkcast 313	com/tencent/mm/plugin/emoji/b/d
    //   932: invokeinterface 321 1 0
    //   937: aload 7
    //   939: invokeinterface 327 2 0
    //   944: ifeq +91 -> 1035
    //   947: new 329	com/tencent/mm/f/a/dm
    //   950: dup
    //   951: invokespecial 330	com/tencent/mm/f/a/dm:<init>	()V
    //   954: astore 7
    //   956: aload 7
    //   958: getfield 334	com/tencent/mm/f/a/dm:fzc	Lcom/tencent/mm/f/a/dm$a;
    //   961: iconst_2
    //   962: putfield 337	com/tencent/mm/f/a/dm$a:subType	I
    //   965: getstatic 343	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   968: aload 7
    //   970: invokevirtual 347	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   973: pop
    //   974: new 60	com/tencent/mm/vfs/q
    //   977: dup
    //   978: new 139	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   985: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   988: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: ldc 243
    //   993: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: getstatic 275	com/tencent/mm/plugin/emoji/e/h:uCL	Ljava/lang/String;
    //   999: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: getstatic 246	com/tencent/mm/plugin/emoji/e/h:uCS	Ljava/lang/String;
    //   1008: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:M	(Lcom/tencent/mm/vfs/q;)I
    //   1014: putstatic 350	com/tencent/mm/plugin/emoji/e/h:uDi	I
    //   1017: invokestatic 354	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1020: invokevirtual 360	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1023: getstatic 366	com/tencent/mm/storage/ar$a:Vha	Lcom/tencent/mm/storage/ar$a;
    //   1026: getstatic 350	com/tencent/mm/plugin/emoji/e/h:uDi	I
    //   1029: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1032: invokevirtual 372	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1035: invokestatic 354	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1038: invokevirtual 360	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1041: getstatic 375	com/tencent/mm/storage/ar$a:Vhd	Lcom/tencent/mm/storage/ar$a;
    //   1044: aload 6
    //   1046: invokevirtual 372	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1049: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   1052: aload_0
    //   1053: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1056: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   1059: aload_0
    //   1060: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1063: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1066: aload_0
    //   1067: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1070: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   1073: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   1076: getstatic 394	com/tencent/mm/emoji/a/f:jGv	Lcom/tencent/mm/emoji/a/f$a;
    //   1079: astore_0
    //   1080: invokestatic 399	com/tencent/mm/emoji/a/f$a:aBt	()V
    //   1083: goto -678 -> 405
    //   1086: aload 7
    //   1088: astore 6
    //   1090: new 60	com/tencent/mm/vfs/q
    //   1093: dup
    //   1094: aload 9
    //   1096: aload 7
    //   1098: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   1101: invokevirtual 70	com/tencent/mm/vfs/q:ifE	()Z
    //   1104: ifne +8 -> 1112
    //   1107: getstatic 289	com/tencent/mm/plugin/emoji/e/h:uDa	Ljava/lang/String;
    //   1110: astore 6
    //   1112: ldc_w 291
    //   1115: ldc_w 401
    //   1118: iconst_1
    //   1119: anewarray 76	java/lang/Object
    //   1122: dup
    //   1123: iconst_0
    //   1124: aload 6
    //   1126: aastore
    //   1127: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1130: goto -293 -> 837
    //   1133: iconst_0
    //   1134: istore 5
    //   1136: goto -250 -> 886
    //   1139: ldc_w 291
    //   1142: ldc_w 403
    //   1145: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: goto -113 -> 1035
    //   1151: ldc_w 291
    //   1154: ldc_w 405
    //   1157: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: goto -84 -> 1076
    //   1163: ldc_w 291
    //   1166: ldc_w 407
    //   1169: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: goto -767 -> 405
    //   1175: aload_0
    //   1176: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1179: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1182: iconst_3
    //   1183: if_icmpne +305 -> 1488
    //   1186: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1189: astore 7
    //   1191: getstatic 410	com/tencent/mm/plugin/emoji/e/h$a:uDs	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1194: astore 6
    //   1196: aload 7
    //   1198: aload 6
    //   1200: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1203: astore 7
    //   1205: aload 6
    //   1207: invokestatic 231	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   1210: istore_1
    //   1211: aload_0
    //   1212: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1215: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   1218: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1221: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:gi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1224: istore 5
    //   1226: aload 7
    //   1228: iload_1
    //   1229: new 60	com/tencent/mm/vfs/q
    //   1232: dup
    //   1233: new 139	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1240: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1243: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: ldc 243
    //   1248: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1254: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: getstatic 246	com/tencent/mm/plugin/emoji/e/h:uCS	Ljava/lang/String;
    //   1263: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:M	(Lcom/tencent/mm/vfs/q;)I
    //   1269: invokevirtual 256	com/tencent/mm/emoji/c/f:de	(II)V
    //   1272: aload 7
    //   1274: iload 5
    //   1276: invokevirtual 260	com/tencent/mm/emoji/c/f:eB	(Z)V
    //   1279: aload 7
    //   1281: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1284: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1287: pop
    //   1288: iload 5
    //   1290: ifeq +186 -> 1476
    //   1293: new 139	java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1300: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1303: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: ldc 243
    //   1308: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: getstatic 413	com/tencent/mm/plugin/emoji/e/h:uCM	Ljava/lang/String;
    //   1314: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 180	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   1323: pop
    //   1324: new 139	java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1331: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1334: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: ldc 243
    //   1339: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1345: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1351: new 139	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1358: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1361: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: ldc 243
    //   1366: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: getstatic 413	com/tencent/mm/plugin/emoji/e/h:uCM	Ljava/lang/String;
    //   1372: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 278	com/tencent/mm/vfs/u:or	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1381: pop
    //   1382: new 60	com/tencent/mm/vfs/q
    //   1385: dup
    //   1386: new 60	com/tencent/mm/vfs/q
    //   1389: dup
    //   1390: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1393: getstatic 413	com/tencent/mm/plugin/emoji/e/h:uCM	Ljava/lang/String;
    //   1396: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1399: getstatic 416	com/tencent/mm/plugin/emoji/e/h:uDb	Ljava/lang/String;
    //   1402: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   1405: astore 6
    //   1407: aload 6
    //   1409: invokevirtual 70	com/tencent/mm/vfs/q:ifE	()Z
    //   1412: ifeq +52 -> 1464
    //   1415: aload 7
    //   1417: aload 6
    //   1419: invokestatic 420	com/tencent/mm/plugin/emoji/e/h:O	(Lcom/tencent/mm/vfs/q;)Z
    //   1422: invokevirtual 308	com/tencent/mm/emoji/c/f:eC	(Z)V
    //   1425: aload 7
    //   1427: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1430: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1433: pop
    //   1434: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   1437: aload_0
    //   1438: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1441: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   1444: aload_0
    //   1445: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1448: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1451: aload_0
    //   1452: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1455: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   1458: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   1461: goto -1056 -> 405
    //   1464: ldc_w 291
    //   1467: ldc_w 422
    //   1470: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1473: goto -39 -> 1434
    //   1476: ldc_w 291
    //   1479: ldc_w 424
    //   1482: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1485: goto -1080 -> 405
    //   1488: aload_0
    //   1489: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1492: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1495: iconst_5
    //   1496: if_icmpne +316 -> 1812
    //   1499: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1502: astore 6
    //   1504: getstatic 427	com/tencent/mm/plugin/emoji/e/h$a:uDu	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1507: astore 8
    //   1509: aload 6
    //   1511: aload 8
    //   1513: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1516: astore 7
    //   1518: aload 8
    //   1520: invokestatic 231	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/plugin/emoji/e/h$a;)I
    //   1523: istore_1
    //   1524: aload_0
    //   1525: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1528: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   1531: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1534: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:gi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1537: istore 5
    //   1539: aload 7
    //   1541: iload_1
    //   1542: new 60	com/tencent/mm/vfs/q
    //   1545: dup
    //   1546: new 139	java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1553: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1556: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: ldc 243
    //   1561: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1567: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1573: getstatic 246	com/tencent/mm/plugin/emoji/e/h:uCS	Ljava/lang/String;
    //   1576: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1579: invokestatic 250	com/tencent/mm/plugin/emoji/e/h:M	(Lcom/tencent/mm/vfs/q;)I
    //   1582: invokevirtual 256	com/tencent/mm/emoji/c/f:de	(II)V
    //   1585: aload 7
    //   1587: iload 5
    //   1589: invokevirtual 260	com/tencent/mm/emoji/c/f:eB	(Z)V
    //   1592: aload 7
    //   1594: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1597: iconst_0
    //   1598: putfield 269	com/tencent/mm/f/b/a/ax:glm	I
    //   1601: aload 7
    //   1603: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1606: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1609: pop
    //   1610: iload 5
    //   1612: ifeq +188 -> 1800
    //   1615: new 139	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1622: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1625: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: ldc 243
    //   1630: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: getstatic 430	com/tencent/mm/plugin/emoji/e/h:uCN	Ljava/lang/String;
    //   1636: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1639: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1642: invokestatic 180	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   1645: pop
    //   1646: new 139	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1653: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1656: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: ldc 243
    //   1661: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: getstatic 234	com/tencent/mm/plugin/emoji/e/h:uCJ	Ljava/lang/String;
    //   1667: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1673: new 139	java/lang/StringBuilder
    //   1676: dup
    //   1677: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1680: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1683: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: ldc 243
    //   1688: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: getstatic 430	com/tencent/mm/plugin/emoji/e/h:uCN	Ljava/lang/String;
    //   1694: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1700: invokestatic 278	com/tencent/mm/vfs/u:or	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1703: pop
    //   1704: new 60	com/tencent/mm/vfs/q
    //   1707: dup
    //   1708: new 60	com/tencent/mm/vfs/q
    //   1711: dup
    //   1712: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1715: getstatic 430	com/tencent/mm/plugin/emoji/e/h:uCN	Ljava/lang/String;
    //   1718: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1721: getstatic 433	com/tencent/mm/plugin/emoji/e/h:uDc	Ljava/lang/String;
    //   1724: invokespecial 100	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   1727: astore 8
    //   1729: aload 8
    //   1731: invokevirtual 70	com/tencent/mm/vfs/q:ifE	()Z
    //   1734: ifeq +54 -> 1788
    //   1737: aload 7
    //   1739: aload 6
    //   1741: aload 8
    //   1743: invokevirtual 436	com/tencent/mm/plugin/emoji/e/h:P	(Lcom/tencent/mm/vfs/q;)Z
    //   1746: invokevirtual 308	com/tencent/mm/emoji/c/f:eC	(Z)V
    //   1749: aload 7
    //   1751: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1754: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1757: pop
    //   1758: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   1761: aload_0
    //   1762: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1765: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   1768: aload_0
    //   1769: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1772: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1775: aload_0
    //   1776: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1779: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   1782: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   1785: goto -1380 -> 405
    //   1788: ldc_w 291
    //   1791: ldc_w 438
    //   1794: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1797: goto -1392 -> 405
    //   1800: ldc_w 291
    //   1803: ldc_w 438
    //   1806: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1809: goto -1404 -> 405
    //   1812: aload_0
    //   1813: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1816: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1819: iconst_4
    //   1820: if_icmpne +105 -> 1925
    //   1823: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1826: pop
    //   1827: ldc_w 291
    //   1830: ldc_w 440
    //   1833: invokestatic 442	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1836: new 252	com/tencent/mm/emoji/c/f
    //   1839: dup
    //   1840: invokespecial 443	com/tencent/mm/emoji/c/f:<init>	()V
    //   1843: astore 6
    //   1845: aload 6
    //   1847: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1850: iconst_4
    //   1851: putfield 446	com/tencent/mm/f/b/a/ax:glp	I
    //   1854: aload_0
    //   1855: invokestatic 449	com/tencent/mm/plugin/emoji/e/h:c	(Lcom/tencent/mm/f/a/bu;)Z
    //   1858: ifeq +37 -> 1895
    //   1861: invokestatic 455	com/tencent/mm/cl/b:htF	()Lcom/tencent/mm/cl/b;
    //   1864: pop
    //   1865: aload_0
    //   1866: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1869: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   1872: invokestatic 458	com/tencent/mm/cl/b:buq	(Ljava/lang/String;)V
    //   1875: aload 6
    //   1877: invokestatic 455	com/tencent/mm/cl/b:htF	()Lcom/tencent/mm/cl/b;
    //   1880: invokevirtual 461	com/tencent/mm/cl/b:init	()Z
    //   1883: invokevirtual 308	com/tencent/mm/emoji/c/f:eC	(Z)V
    //   1886: aload 6
    //   1888: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1891: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1894: pop
    //   1895: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   1898: aload_0
    //   1899: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1902: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   1905: aload_0
    //   1906: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1909: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1912: aload_0
    //   1913: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1916: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   1919: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   1922: goto -1517 -> 405
    //   1925: aload_0
    //   1926: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1929: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   1932: bipush 6
    //   1934: if_icmpne +102 -> 2036
    //   1937: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1940: getstatic 464	com/tencent/mm/plugin/emoji/e/h$a:uDv	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1943: invokevirtual 228	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/plugin/emoji/e/h$a;)Lcom/tencent/mm/emoji/c/f;
    //   1946: astore 6
    //   1948: aload_0
    //   1949: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   1952: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   1955: getstatic 467	com/tencent/mm/plugin/emoji/e/h:uCP	Ljava/lang/String;
    //   1958: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:gi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1961: istore 5
    //   1963: aload 6
    //   1965: iload 5
    //   1967: invokevirtual 260	com/tencent/mm/emoji/c/f:eB	(Z)V
    //   1970: aload 6
    //   1972: getfield 264	com/tencent/mm/emoji/c/f:jNw	Lcom/tencent/mm/f/b/a/ax;
    //   1975: invokevirtual 272	com/tencent/mm/f/b/a/ax:bpa	()Z
    //   1978: pop
    //   1979: iload 5
    //   1981: ifeq -1576 -> 405
    //   1984: new 60	com/tencent/mm/vfs/q
    //   1987: dup
    //   1988: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1991: getstatic 467	com/tencent/mm/plugin/emoji/e/h:uCP	Ljava/lang/String;
    //   1994: invokespecial 95	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1997: pop
    //   1998: getstatic 473	com/tencent/mm/emoji/b/c/g:jKI	Lcom/tencent/mm/emoji/b/c/g;
    //   2001: astore 6
    //   2003: invokestatic 476	com/tencent/mm/emoji/b/c/g:aCH	()V
    //   2006: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   2009: aload_0
    //   2010: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2013: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   2016: aload_0
    //   2017: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2020: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   2023: aload_0
    //   2024: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2027: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   2030: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   2033: goto -1628 -> 405
    //   2036: aload_0
    //   2037: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2040: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   2043: bipush 7
    //   2045: if_icmpne +49 -> 2094
    //   2048: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   2051: aload_0
    //   2052: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2055: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   2058: invokevirtual 479	com/tencent/mm/plugin/emoji/e/h:auw	(Ljava/lang/String;)Z
    //   2061: ifeq -1656 -> 405
    //   2064: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   2067: aload_0
    //   2068: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2071: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   2074: aload_0
    //   2075: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2078: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   2081: aload_0
    //   2082: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2085: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   2088: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   2091: goto -1686 -> 405
    //   2094: aload_0
    //   2095: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2098: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   2101: bipush 9
    //   2103: if_icmpne -1698 -> 405
    //   2106: invokestatic 215	com/tencent/mm/plugin/emoji/e/h:cUA	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   2109: pop
    //   2110: aload_0
    //   2111: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2114: getfield 64	com/tencent/mm/f/a/bu$a:filePath	Ljava/lang/String;
    //   2117: invokestatic 482	com/tencent/mm/plugin/emoji/e/h:auy	(Ljava/lang/String;)I
    //   2120: ifle -1715 -> 405
    //   2123: invokestatic 381	com/tencent/mm/pluginsdk/k/a/a/b:hii	()Lcom/tencent/mm/pluginsdk/k/a/a/b;
    //   2126: aload_0
    //   2127: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2130: getfield 58	com/tencent/mm/f/a/bu$a:fxC	I
    //   2133: aload_0
    //   2134: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2137: getfield 209	com/tencent/mm/f/a/bu$a:subType	I
    //   2140: aload_0
    //   2141: getfield 53	com/tencent/mm/f/a/bu:fxB	Lcom/tencent/mm/f/a/bu$a;
    //   2144: getfield 384	com/tencent/mm/f/a/bu$a:fxD	I
    //   2147: invokevirtual 388	com/tencent/mm/pluginsdk/k/a/a/b:aT	(III)V
    //   2150: goto -1745 -> 405
    //   2153: astore 6
    //   2155: aconst_null
    //   2156: astore 10
    //   2158: goto -1674 -> 484
    //   2161: astore 6
    //   2163: aload 9
    //   2165: astore_0
    //   2166: aload 8
    //   2168: astore 7
    //   2170: goto -1686 -> 484
    //   2173: astore 11
    //   2175: aconst_null
    //   2176: astore 6
    //   2178: iload_3
    //   2179: istore_1
    //   2180: goto -1751 -> 429
    //   2183: astore 11
    //   2185: goto -1756 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2188	0	parambu	bu
    //   147	2033	1	i	int
    //   145	202	2	j	int
    //   143	2036	3	k	int
    //   140	9	4	m	int
    //   628	1352	5	bool	boolean
    //   157	309	6	localObject1	java.lang.Object
    //   473	31	6	localObject2	java.lang.Object
    //   598	1404	6	localObject3	java.lang.Object
    //   2153	1	6	localObject4	java.lang.Object
    //   2161	1	6	localObject5	java.lang.Object
    //   2176	1	6	localObject6	java.lang.Object
    //   188	1981	7	localObject7	java.lang.Object
    //   154	2013	8	localObject8	java.lang.Object
    //   210	1954	9	localObject9	java.lang.Object
    //   207	1950	10	localObject10	java.lang.Object
    //   203	117	11	str1	String
    //   412	33	11	localException1	java.lang.Exception
    //   2173	1	11	localException2	java.lang.Exception
    //   2183	1	11	localException3	java.lang.Exception
    //   51	350	12	localq1	com.tencent.mm.vfs.q
    //   92	257	13	localq2	com.tencent.mm.vfs.q
    //   105	253	14	localq3	com.tencent.mm.vfs.q
    //   223	33	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   159	174	412	java/lang/Exception
    //   180	190	412	java/lang/Exception
    //   159	174	473	finally
    //   180	190	473	finally
    //   190	201	2153	finally
    //   218	225	2161	finally
    //   243	265	2161	finally
    //   281	296	2161	finally
    //   309	332	2161	finally
    //   440	456	2161	finally
    //   190	201	2173	java/lang/Exception
    //   218	225	2183	java/lang/Exception
    //   243	265	2183	java/lang/Exception
    //   281	296	2183	java/lang/Exception
    //   309	332	2183	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */