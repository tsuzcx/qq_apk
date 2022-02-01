package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.sdk.b.c;

public final class b
  extends c<bn>
{
  public b()
  {
    AppMethodBeat.i(161066);
    this.__eventId = bn.class.getName().hashCode();
    AppMethodBeat.o(161066);
  }
  
  /* Error */
  private static boolean a(bn parambn)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: instanceof 18
    //   9: ifeq +415 -> 424
    //   12: invokestatic 49	com/tencent/mm/kernel/g:ajx	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 43
    //   20: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   29: getfield 58	com/tencent/mm/g/a/bn$a:dmx	I
    //   32: bipush 33
    //   34: if_icmpne +531 -> 565
    //   37: new 60	com/tencent/mm/vfs/e
    //   40: dup
    //   41: aload_0
    //   42: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   45: getfield 64	com/tencent/mm/g/a/bn$a:filePath	Ljava/lang/String;
    //   48: invokespecial 67	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   51: astore 11
    //   53: aload 11
    //   55: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   58: ifeq +497 -> 555
    //   61: ldc 72
    //   63: ldc 74
    //   65: iconst_1
    //   66: anewarray 76	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 11
    //   73: invokevirtual 80	com/tencent/mm/vfs/e:fOL	()Lcom/tencent/mm/vfs/e;
    //   76: aastore
    //   77: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: new 60	com/tencent/mm/vfs/e
    //   83: dup
    //   84: invokestatic 90	com/tencent/mm/ar/a:aHk	()Ljava/lang/String;
    //   87: ldc 92
    //   89: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: astore 12
    //   94: new 60	com/tencent/mm/vfs/e
    //   97: dup
    //   98: aload 12
    //   100: ldc 97
    //   102: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   105: astore 13
    //   107: aload 12
    //   109: invokevirtual 103	com/tencent/mm/vfs/e:mkdirs	()Z
    //   112: pop
    //   113: aload 11
    //   115: invokevirtual 107	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   118: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aload 13
    //   123: invokevirtual 107	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   126: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   129: invokestatic 119	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   132: pop2
    //   133: aload 13
    //   135: invokevirtual 107	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   138: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   141: aload 12
    //   143: invokevirtual 107	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   146: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   149: invokestatic 123	com/tencent/mm/vfs/i:fz	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 5
    //   171: new 60	com/tencent/mm/vfs/e
    //   174: dup
    //   175: aload 12
    //   177: ldc 125
    //   179: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   182: invokestatic 129	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   185: astore_0
    //   186: aload_0
    //   187: astore 5
    //   189: aload_0
    //   190: astore 7
    //   192: new 131	java/io/InputStreamReader
    //   195: dup
    //   196: aload_0
    //   197: invokespecial 134	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   200: astore 6
    //   202: new 136	java/io/BufferedReader
    //   205: dup
    //   206: aload 6
    //   208: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   211: astore 5
    //   213: ldc 141
    //   215: astore 10
    //   217: aload 5
    //   219: astore 9
    //   221: aload 6
    //   223: astore 8
    //   225: aload_0
    //   226: astore 7
    //   228: iload_2
    //   229: istore_1
    //   230: aload 5
    //   232: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   235: astore 14
    //   237: aload 14
    //   239: ifnull +41 -> 280
    //   242: aload 5
    //   244: astore 9
    //   246: aload 6
    //   248: astore 8
    //   250: aload_0
    //   251: astore 7
    //   253: iload_2
    //   254: istore_1
    //   255: new 146	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   262: aload 10
    //   264: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 14
    //   269: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: astore 10
    //   277: goto -60 -> 217
    //   280: aload 5
    //   282: astore 9
    //   284: aload 6
    //   286: astore 8
    //   288: aload_0
    //   289: astore 7
    //   291: iload_2
    //   292: istore_1
    //   293: new 156	org/json/JSONObject
    //   296: dup
    //   297: aload 10
    //   299: invokespecial 157	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   302: ldc 159
    //   304: invokevirtual 163	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   307: istore_2
    //   308: aload 5
    //   310: astore 9
    //   312: aload 6
    //   314: astore 8
    //   316: aload_0
    //   317: astore 7
    //   319: iload_2
    //   320: istore_1
    //   321: ldc 72
    //   323: ldc 165
    //   325: iconst_2
    //   326: anewarray 76	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 10
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: iload_2
    //   337: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: aload_0
    //   345: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   348: aload 6
    //   350: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   353: aload 5
    //   355: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   358: iload_2
    //   359: istore_1
    //   360: aload 12
    //   362: getfield 183	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   365: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   368: iconst_1
    //   369: invokestatic 187	com/tencent/mm/vfs/i:cZ	(Ljava/lang/String;Z)Z
    //   372: pop
    //   373: aload 13
    //   375: getfield 183	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   378: invokestatic 113	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   381: invokestatic 191	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   384: pop
    //   385: getstatic 194	com/tencent/mm/ar/a:hWy	I
    //   388: iload_1
    //   389: if_icmpge +136 -> 525
    //   392: ldc 72
    //   394: ldc 196
    //   396: iconst_2
    //   397: anewarray 76	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: getstatic 194	com/tencent/mm/ar/a:hWy	I
    //   405: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: aastore
    //   409: dup
    //   410: iconst_1
    //   411: iload_1
    //   412: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload 11
    //   421: invokestatic 200	com/tencent/mm/ar/a:l	(Lcom/tencent/mm/vfs/e;)V
    //   424: ldc 43
    //   426: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore 10
    //   433: aconst_null
    //   434: astore 7
    //   436: aconst_null
    //   437: astore 6
    //   439: aload 5
    //   441: astore_0
    //   442: aload 7
    //   444: astore 5
    //   446: iload_3
    //   447: istore_1
    //   448: aload 5
    //   450: astore 9
    //   452: aload 6
    //   454: astore 8
    //   456: aload_0
    //   457: astore 7
    //   459: ldc 72
    //   461: aload 10
    //   463: aload 10
    //   465: invokevirtual 203	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: iconst_0
    //   469: anewarray 76	java/lang/Object
    //   472: invokestatic 207	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload_0
    //   476: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   479: aload 6
    //   481: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   484: aload 5
    //   486: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   489: goto -129 -> 360
    //   492: astore 5
    //   494: aconst_null
    //   495: astore 9
    //   497: aconst_null
    //   498: astore 6
    //   500: aload 7
    //   502: astore_0
    //   503: aload_0
    //   504: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   507: aload 6
    //   509: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   512: aload 9
    //   514: invokestatic 179	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   517: ldc 43
    //   519: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: aload 5
    //   524: athrow
    //   525: ldc 72
    //   527: ldc 209
    //   529: iconst_2
    //   530: anewarray 76	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: getstatic 194	com/tencent/mm/ar/a:hWy	I
    //   538: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: iload_1
    //   545: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: goto -128 -> 424
    //   555: ldc 72
    //   557: ldc 211
    //   559: invokestatic 214	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: goto -138 -> 424
    //   565: aload_0
    //   566: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   569: getfield 58	com/tencent/mm/g/a/bn$a:dmx	I
    //   572: bipush 37
    //   574: if_icmpne -150 -> 424
    //   577: aload_0
    //   578: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   581: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   584: iconst_1
    //   585: if_icmpne +207 -> 792
    //   588: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   591: pop
    //   592: aload_0
    //   593: getstatic 229	com/tencent/mm/plugin/emoji/e/h$a:pDk	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   596: invokestatic 232	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;)Z
    //   599: pop
    //   600: aload_0
    //   601: getstatic 229	com/tencent/mm/plugin/emoji/e/h$a:pDk	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   604: getstatic 235	com/tencent/mm/plugin/emoji/e/h:pCK	Ljava/lang/String;
    //   607: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;Ljava/lang/String;)Z
    //   610: ifeq +170 -> 780
    //   613: new 60	com/tencent/mm/vfs/e
    //   616: dup
    //   617: new 60	com/tencent/mm/vfs/e
    //   620: dup
    //   621: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   624: getstatic 235	com/tencent/mm/plugin/emoji/e/h:pCK	Ljava/lang/String;
    //   627: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: getstatic 244	com/tencent/mm/plugin/emoji/e/h:pCX	Ljava/lang/String;
    //   633: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   636: astore_0
    //   637: aload_0
    //   638: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   641: ifeq +127 -> 768
    //   644: aload_0
    //   645: invokestatic 249	com/tencent/mm/emoji/d/b:e	(Lcom/tencent/mm/vfs/e;)Ljava/util/ArrayList;
    //   648: astore_0
    //   649: aload_0
    //   650: invokevirtual 254	java/util/ArrayList:isEmpty	()Z
    //   653: ifne -229 -> 424
    //   656: ldc_w 256
    //   659: invokestatic 260	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   662: checkcast 256	com/tencent/mm/plugin/emoji/b/d
    //   665: invokeinterface 264 1 0
    //   670: aload_0
    //   671: invokeinterface 270 2 0
    //   676: ifeq -252 -> 424
    //   679: new 272	com/tencent/mm/g/a/dd
    //   682: dup
    //   683: invokespecial 273	com/tencent/mm/g/a/dd:<init>	()V
    //   686: astore_0
    //   687: aload_0
    //   688: getfield 277	com/tencent/mm/g/a/dd:dnY	Lcom/tencent/mm/g/a/dd$a;
    //   691: iconst_1
    //   692: putfield 280	com/tencent/mm/g/a/dd$a:subType	I
    //   695: getstatic 286	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   698: aload_0
    //   699: invokevirtual 289	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   702: pop
    //   703: new 60	com/tencent/mm/vfs/e
    //   706: dup
    //   707: new 146	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   714: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   717: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: ldc_w 291
    //   723: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: getstatic 235	com/tencent/mm/plugin/emoji/e/h:pCK	Ljava/lang/String;
    //   729: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: getstatic 294	com/tencent/mm/plugin/emoji/e/h:pCQ	Ljava/lang/String;
    //   738: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: invokestatic 298	com/tencent/mm/plugin/emoji/e/h:J	(Lcom/tencent/mm/vfs/e;)I
    //   744: putstatic 301	com/tencent/mm/plugin/emoji/e/h:pDc	I
    //   747: invokestatic 305	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   750: invokevirtual 311	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   753: getstatic 317	com/tencent/mm/storage/al$a:IqH	Lcom/tencent/mm/storage/al$a;
    //   756: getstatic 301	com/tencent/mm/plugin/emoji/e/h:pDc	I
    //   759: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokevirtual 323	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   765: goto -341 -> 424
    //   768: ldc_w 325
    //   771: ldc_w 327
    //   774: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: goto -353 -> 424
    //   780: ldc_w 325
    //   783: ldc_w 331
    //   786: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: goto -365 -> 424
    //   792: aload_0
    //   793: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   796: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   799: iconst_2
    //   800: if_icmpne +313 -> 1113
    //   803: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   806: pop
    //   807: aload_0
    //   808: getstatic 334	com/tencent/mm/plugin/emoji/e/h$a:pDl	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   811: invokestatic 232	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;)Z
    //   814: pop
    //   815: aload_0
    //   816: getstatic 334	com/tencent/mm/plugin/emoji/e/h$a:pDl	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   819: getstatic 337	com/tencent/mm/plugin/emoji/e/h:pCL	Ljava/lang/String;
    //   822: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;Ljava/lang/String;)Z
    //   825: ifeq +276 -> 1101
    //   828: new 60	com/tencent/mm/vfs/e
    //   831: dup
    //   832: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   835: getstatic 337	com/tencent/mm/plugin/emoji/e/h:pCL	Ljava/lang/String;
    //   838: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: astore 6
    //   843: invokestatic 342	com/tencent/mm/emoji/a/m:aeZ	()Ljava/lang/String;
    //   846: astore 5
    //   848: aload 5
    //   850: invokestatic 345	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   853: ifeq +180 -> 1033
    //   856: getstatic 348	com/tencent/mm/plugin/emoji/e/h:pCY	Ljava/lang/String;
    //   859: astore_0
    //   860: ldc_w 325
    //   863: ldc_w 350
    //   866: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   869: new 60	com/tencent/mm/vfs/e
    //   872: dup
    //   873: aload 6
    //   875: aload_0
    //   876: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   879: astore 5
    //   881: aload 5
    //   883: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   886: ifeq +203 -> 1089
    //   889: aload 5
    //   891: invokestatic 353	com/tencent/mm/emoji/d/b:f	(Lcom/tencent/mm/vfs/e;)Ljava/util/ArrayList;
    //   894: astore 5
    //   896: aload 5
    //   898: invokevirtual 254	java/util/ArrayList:isEmpty	()Z
    //   901: ifne +176 -> 1077
    //   904: ldc_w 256
    //   907: invokestatic 260	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   910: checkcast 256	com/tencent/mm/plugin/emoji/b/d
    //   913: invokeinterface 264 1 0
    //   918: aload 5
    //   920: invokeinterface 356 2 0
    //   925: ifeq +92 -> 1017
    //   928: new 272	com/tencent/mm/g/a/dd
    //   931: dup
    //   932: invokespecial 273	com/tencent/mm/g/a/dd:<init>	()V
    //   935: astore 5
    //   937: aload 5
    //   939: getfield 277	com/tencent/mm/g/a/dd:dnY	Lcom/tencent/mm/g/a/dd$a;
    //   942: iconst_2
    //   943: putfield 280	com/tencent/mm/g/a/dd$a:subType	I
    //   946: getstatic 286	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   949: aload 5
    //   951: invokevirtual 289	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   954: pop
    //   955: new 60	com/tencent/mm/vfs/e
    //   958: dup
    //   959: new 146	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   966: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   969: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc_w 291
    //   975: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: getstatic 337	com/tencent/mm/plugin/emoji/e/h:pCL	Ljava/lang/String;
    //   981: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: getstatic 294	com/tencent/mm/plugin/emoji/e/h:pCQ	Ljava/lang/String;
    //   990: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: invokestatic 298	com/tencent/mm/plugin/emoji/e/h:J	(Lcom/tencent/mm/vfs/e;)I
    //   996: putstatic 359	com/tencent/mm/plugin/emoji/e/h:pDd	I
    //   999: invokestatic 305	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1002: invokevirtual 311	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1005: getstatic 362	com/tencent/mm/storage/al$a:IqI	Lcom/tencent/mm/storage/al$a;
    //   1008: getstatic 359	com/tencent/mm/plugin/emoji/e/h:pDd	I
    //   1011: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1014: invokevirtual 323	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   1017: invokestatic 305	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1020: invokevirtual 311	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1023: getstatic 365	com/tencent/mm/storage/al$a:IqL	Lcom/tencent/mm/storage/al$a;
    //   1026: aload_0
    //   1027: invokevirtual 323	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   1030: goto -606 -> 424
    //   1033: aload 5
    //   1035: astore_0
    //   1036: new 60	com/tencent/mm/vfs/e
    //   1039: dup
    //   1040: aload 6
    //   1042: aload 5
    //   1044: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   1047: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   1050: ifne +7 -> 1057
    //   1053: getstatic 348	com/tencent/mm/plugin/emoji/e/h:pCY	Ljava/lang/String;
    //   1056: astore_0
    //   1057: ldc_w 325
    //   1060: ldc_w 367
    //   1063: iconst_1
    //   1064: anewarray 76	java/lang/Object
    //   1067: dup
    //   1068: iconst_0
    //   1069: aload_0
    //   1070: aastore
    //   1071: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1074: goto -205 -> 869
    //   1077: ldc_w 325
    //   1080: ldc_w 369
    //   1083: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: goto -69 -> 1017
    //   1089: ldc_w 325
    //   1092: ldc_w 371
    //   1095: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: goto -674 -> 424
    //   1101: ldc_w 325
    //   1104: ldc_w 373
    //   1107: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1110: goto -686 -> 424
    //   1113: aload_0
    //   1114: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   1117: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   1120: iconst_3
    //   1121: if_icmpne +90 -> 1211
    //   1124: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1127: pop
    //   1128: aload_0
    //   1129: getstatic 376	com/tencent/mm/plugin/emoji/e/h$a:pDm	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1132: invokestatic 232	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;)Z
    //   1135: pop
    //   1136: aload_0
    //   1137: getstatic 376	com/tencent/mm/plugin/emoji/e/h$a:pDm	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1140: getstatic 379	com/tencent/mm/plugin/emoji/e/h:pCM	Ljava/lang/String;
    //   1143: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;Ljava/lang/String;)Z
    //   1146: ifeq +53 -> 1199
    //   1149: new 60	com/tencent/mm/vfs/e
    //   1152: dup
    //   1153: new 60	com/tencent/mm/vfs/e
    //   1156: dup
    //   1157: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1160: getstatic 379	com/tencent/mm/plugin/emoji/e/h:pCM	Ljava/lang/String;
    //   1163: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: getstatic 382	com/tencent/mm/plugin/emoji/e/h:pCZ	Ljava/lang/String;
    //   1169: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   1172: astore_0
    //   1173: aload_0
    //   1174: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   1177: ifeq +10 -> 1187
    //   1180: aload_0
    //   1181: invokestatic 385	com/tencent/mm/plugin/emoji/e/h:K	(Lcom/tencent/mm/vfs/e;)V
    //   1184: goto -760 -> 424
    //   1187: ldc_w 325
    //   1190: ldc_w 387
    //   1193: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1196: goto -772 -> 424
    //   1199: ldc_w 325
    //   1202: ldc_w 389
    //   1205: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1208: goto -784 -> 424
    //   1211: aload_0
    //   1212: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   1215: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   1218: iconst_5
    //   1219: if_icmpne +93 -> 1312
    //   1222: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1225: astore 5
    //   1227: aload_0
    //   1228: getstatic 392	com/tencent/mm/plugin/emoji/e/h$a:pDo	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1231: invokestatic 232	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;)Z
    //   1234: pop
    //   1235: aload_0
    //   1236: getstatic 392	com/tencent/mm/plugin/emoji/e/h$a:pDo	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1239: getstatic 395	com/tencent/mm/plugin/emoji/e/h:pCN	Ljava/lang/String;
    //   1242: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;Ljava/lang/String;)Z
    //   1245: ifeq +55 -> 1300
    //   1248: new 60	com/tencent/mm/vfs/e
    //   1251: dup
    //   1252: new 60	com/tencent/mm/vfs/e
    //   1255: dup
    //   1256: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1259: getstatic 395	com/tencent/mm/plugin/emoji/e/h:pCN	Ljava/lang/String;
    //   1262: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: getstatic 398	com/tencent/mm/plugin/emoji/e/h:pDa	Ljava/lang/String;
    //   1268: invokespecial 100	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   1271: astore_0
    //   1272: aload_0
    //   1273: invokevirtual 70	com/tencent/mm/vfs/e:exists	()Z
    //   1276: ifeq +12 -> 1288
    //   1279: aload 5
    //   1281: aload_0
    //   1282: invokevirtual 401	com/tencent/mm/plugin/emoji/e/h:L	(Lcom/tencent/mm/vfs/e;)V
    //   1285: goto -861 -> 424
    //   1288: ldc_w 325
    //   1291: ldc_w 403
    //   1294: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1297: goto -873 -> 424
    //   1300: ldc_w 325
    //   1303: ldc_w 403
    //   1306: invokestatic 329	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: goto -885 -> 424
    //   1312: aload_0
    //   1313: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   1316: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   1319: iconst_4
    //   1320: if_icmpne +55 -> 1375
    //   1323: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1326: pop
    //   1327: ldc_w 325
    //   1330: ldc_w 405
    //   1333: invokestatic 407	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1336: aload_0
    //   1337: invokestatic 410	com/tencent/mm/plugin/emoji/e/h:b	(Lcom/tencent/mm/g/a/bn;)Z
    //   1340: ifeq -916 -> 424
    //   1343: invokestatic 416	com/tencent/mm/cf/b:fmR	()Lcom/tencent/mm/cf/b;
    //   1346: pop
    //   1347: aload_0
    //   1348: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   1351: getfield 64	com/tencent/mm/g/a/bn$a:filePath	Ljava/lang/String;
    //   1354: astore_0
    //   1355: invokestatic 419	com/tencent/mm/cf/b:fmS	()V
    //   1358: aload_0
    //   1359: getstatic 422	com/tencent/mm/cf/b:Ijs	Ljava/lang/String;
    //   1362: invokestatic 119	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   1365: pop2
    //   1366: invokestatic 416	com/tencent/mm/cf/b:fmR	()Lcom/tencent/mm/cf/b;
    //   1369: invokevirtual 425	com/tencent/mm/cf/b:init	()V
    //   1372: goto -948 -> 424
    //   1375: aload_0
    //   1376: getfield 53	com/tencent/mm/g/a/bn:dmw	Lcom/tencent/mm/g/a/bn$a;
    //   1379: getfield 217	com/tencent/mm/g/a/bn$a:subType	I
    //   1382: bipush 6
    //   1384: if_icmpne -960 -> 424
    //   1387: invokestatic 223	com/tencent/mm/plugin/emoji/e/h:cgF	()Lcom/tencent/mm/plugin/emoji/e/h;
    //   1390: pop
    //   1391: aload_0
    //   1392: getstatic 428	com/tencent/mm/plugin/emoji/e/h$a:pDp	Lcom/tencent/mm/plugin/emoji/e/h$a;
    //   1395: getstatic 431	com/tencent/mm/plugin/emoji/e/h:pCP	Ljava/lang/String;
    //   1398: invokestatic 238	com/tencent/mm/plugin/emoji/e/h:a	(Lcom/tencent/mm/g/a/bn;Lcom/tencent/mm/plugin/emoji/e/h$a;Ljava/lang/String;)Z
    //   1401: ifeq -977 -> 424
    //   1404: new 60	com/tencent/mm/vfs/e
    //   1407: dup
    //   1408: invokestatic 241	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   1411: getstatic 431	com/tencent/mm/plugin/emoji/e/h:pCP	Ljava/lang/String;
    //   1414: invokespecial 95	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1417: pop
    //   1418: getstatic 437	com/tencent/mm/emoji/a/b/g:gms	Lcom/tencent/mm/emoji/a/b/g;
    //   1421: astore_0
    //   1422: invokestatic 440	com/tencent/mm/emoji/a/b/g:afJ	()V
    //   1425: goto -1001 -> 424
    //   1428: astore 5
    //   1430: aconst_null
    //   1431: astore 9
    //   1433: goto -930 -> 503
    //   1436: astore 5
    //   1438: aload 8
    //   1440: astore 6
    //   1442: aload 7
    //   1444: astore_0
    //   1445: goto -942 -> 503
    //   1448: astore 10
    //   1450: aconst_null
    //   1451: astore 5
    //   1453: iload_3
    //   1454: istore_1
    //   1455: goto -1007 -> 448
    //   1458: astore 10
    //   1460: goto -1012 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1463	0	parambn	bn
    //   159	1296	1	i	int
    //   157	202	2	j	int
    //   155	1299	3	k	int
    //   152	9	4	m	int
    //   169	316	5	localObject1	java.lang.Object
    //   492	31	5	localObject2	java.lang.Object
    //   846	434	5	localObject3	java.lang.Object
    //   1428	1	5	localObject4	java.lang.Object
    //   1436	1	5	localObject5	java.lang.Object
    //   1451	1	5	localObject6	java.lang.Object
    //   200	1241	6	localObject7	java.lang.Object
    //   166	1277	7	localbn	bn
    //   223	1216	8	localObject8	java.lang.Object
    //   219	1213	9	localObject9	java.lang.Object
    //   215	117	10	str1	String
    //   431	33	10	localException1	java.lang.Exception
    //   1448	1	10	localException2	java.lang.Exception
    //   1458	1	10	localException3	java.lang.Exception
    //   51	369	11	locale1	com.tencent.mm.vfs.e
    //   92	269	12	locale2	com.tencent.mm.vfs.e
    //   105	269	13	locale3	com.tencent.mm.vfs.e
    //   235	33	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   171	186	431	java/lang/Exception
    //   192	202	431	java/lang/Exception
    //   171	186	492	finally
    //   192	202	492	finally
    //   202	213	1428	finally
    //   230	237	1436	finally
    //   255	277	1436	finally
    //   293	308	1436	finally
    //   321	344	1436	finally
    //   459	475	1436	finally
    //   202	213	1448	java/lang/Exception
    //   230	237	1458	java/lang/Exception
    //   255	277	1458	java/lang/Exception
    //   293	308	1458	java/lang/Exception
    //   321	344	1458	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */