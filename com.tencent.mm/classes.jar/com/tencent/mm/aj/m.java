package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;

public final class m
  extends n
  implements k
{
  private f callback;
  private int dgI;
  private String dzD;
  private int hPI;
  private int hPJ;
  private String hPY;
  private String hPZ;
  private String hQa;
  
  public m(String paramString)
  {
    AppMethodBeat.i(150305);
    this.hQa = v.aAC();
    p.aEA();
    this.hPY = e.K(this.hQa, true);
    String str = this.hPY + ".tmp";
    if (aZ(paramString, str) == 0)
    {
      this.dzD = str;
      this.hPJ = 1;
      p.aEA();
      this.hPZ = com.tencent.mm.b.g.getMessageDigest(o.bb(e.J(this.hQa, true), 0, -1));
      this.hPI = 0;
      this.dgI = 0;
    }
    AppMethodBeat.o(150305);
  }
  
  /* Error */
  private static int aZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 107	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore 11
    //   11: aload 11
    //   13: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   16: sipush 640
    //   19: if_icmpge +60 -> 79
    //   22: aload 11
    //   24: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   27: sipush 640
    //   30: if_icmpge +49 -> 79
    //   33: aload_0
    //   34: aload_1
    //   35: invokestatic 119	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   38: pop2
    //   39: ldc 121
    //   41: ldc 123
    //   43: iconst_2
    //   44: anewarray 125	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload 11
    //   51: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   54: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload 11
    //   62: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   65: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 101
    //   74: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_0
    //   78: ireturn
    //   79: bipush 50
    //   81: istore 4
    //   83: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   86: invokestatic 148	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
    //   89: ifeq +428 -> 517
    //   92: ldc 150
    //   94: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   97: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   100: invokeinterface 160 1 0
    //   105: ldc 162
    //   107: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   110: bipush 50
    //   112: invokestatic 174	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   115: istore 5
    //   117: iload 5
    //   119: istore 4
    //   121: iconst_0
    //   122: istore 7
    //   124: iconst_0
    //   125: istore 6
    //   127: iload 6
    //   129: istore 5
    //   131: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   134: invokestatic 148	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
    //   137: ifeq +494 -> 631
    //   140: iload 6
    //   142: istore 5
    //   144: ldc 150
    //   146: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   149: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   152: invokeinterface 160 1 0
    //   157: ldc 176
    //   159: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 10
    //   164: iload 6
    //   166: istore 5
    //   168: aload 10
    //   170: ldc 178
    //   172: invokevirtual 184	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   175: istore 8
    //   177: iload 7
    //   179: istore 5
    //   181: iconst_m1
    //   182: iload 8
    //   184: if_icmpeq +556 -> 740
    //   187: iload 6
    //   189: istore 5
    //   191: aload 10
    //   193: iconst_0
    //   194: iload 8
    //   196: invokevirtual 188	java/lang/String:substring	(II)Ljava/lang/String;
    //   199: invokestatic 191	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   202: invokevirtual 195	java/lang/Integer:intValue	()I
    //   205: istore 6
    //   207: iload 6
    //   209: istore 5
    //   211: aload 10
    //   213: iload 8
    //   215: iconst_1
    //   216: iadd
    //   217: invokevirtual 198	java/lang/String:substring	(I)Ljava/lang/String;
    //   220: invokestatic 191	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   223: invokevirtual 195	java/lang/Integer:intValue	()I
    //   226: istore 7
    //   228: iload 6
    //   230: istore 5
    //   232: iload 7
    //   234: istore 6
    //   236: iload 5
    //   238: ifgt +510 -> 748
    //   241: iload 6
    //   243: ifgt +505 -> 748
    //   246: iconst_0
    //   247: istore 6
    //   249: sipush 1080
    //   252: istore 5
    //   254: aload 11
    //   256: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   259: aload 11
    //   261: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   264: if_icmple +527 -> 791
    //   267: aload 11
    //   269: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   272: istore 7
    //   274: aload 11
    //   276: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   279: aload 11
    //   281: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   284: if_icmpge +517 -> 801
    //   287: aload 11
    //   289: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   292: istore 8
    //   294: ldc 121
    //   296: ldc 200
    //   298: iconst_5
    //   299: anewarray 125	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload 6
    //   306: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: iload 5
    //   314: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: iload 4
    //   322: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: dup
    //   327: iconst_3
    //   328: aload 11
    //   330: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   333: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: dup
    //   338: iconst_4
    //   339: aload 11
    //   341: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   344: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iload 5
    //   353: ifle +458 -> 811
    //   356: iload 8
    //   358: iload 5
    //   360: idiv
    //   361: istore 7
    //   363: aload 11
    //   365: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   368: iload 5
    //   370: imul
    //   371: iload 8
    //   373: idiv
    //   374: istore 6
    //   376: iload 5
    //   378: aload 11
    //   380: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   383: imul
    //   384: iload 8
    //   386: idiv
    //   387: istore 5
    //   389: iload 6
    //   391: istore 9
    //   393: iload 5
    //   395: istore 8
    //   397: iload 6
    //   399: iload 5
    //   401: imul
    //   402: ldc 201
    //   404: if_icmple +33 -> 437
    //   407: ldc2_w 202
    //   410: iload 6
    //   412: iload 5
    //   414: imul
    //   415: i2d
    //   416: ddiv
    //   417: invokestatic 209	java/lang/Math:sqrt	(D)D
    //   420: dstore_2
    //   421: iload 6
    //   423: i2d
    //   424: dload_2
    //   425: ddiv
    //   426: d2i
    //   427: istore 9
    //   429: iload 5
    //   431: i2d
    //   432: dload_2
    //   433: ddiv
    //   434: d2i
    //   435: istore 8
    //   437: new 109	android/graphics/BitmapFactory$Options
    //   440: dup
    //   441: invokespecial 210	android/graphics/BitmapFactory$Options:<init>	()V
    //   444: astore 10
    //   446: aload 10
    //   448: getstatic 216	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   451: putfield 219	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   454: iload 7
    //   456: iconst_2
    //   457: if_icmplt +10 -> 467
    //   460: aload 10
    //   462: iload 7
    //   464: putfield 222	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   467: aload_0
    //   468: aload 10
    //   470: invokestatic 226	com/tencent/mm/sdk/platformtools/h:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   473: astore 12
    //   475: aload 12
    //   477: ifnonnull +382 -> 859
    //   480: ldc 121
    //   482: ldc 228
    //   484: iconst_1
    //   485: anewarray 125	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload 10
    //   492: getfield 222	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   495: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: invokestatic 236	com/tencent/mm/compatible/util/f:getLine	()I
    //   505: istore 4
    //   507: ldc 101
    //   509: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: iconst_0
    //   513: iload 4
    //   515: isub
    //   516: ireturn
    //   517: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   520: invokestatic 239	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
    //   523: ifeq +35 -> 558
    //   526: ldc 150
    //   528: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   531: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   534: invokeinterface 160 1 0
    //   539: ldc 241
    //   541: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   544: bipush 50
    //   546: invokestatic 174	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   549: istore 5
    //   551: iload 5
    //   553: istore 4
    //   555: goto -434 -> 121
    //   558: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   561: invokestatic 244	com/tencent/mm/sdk/platformtools/az:is3G	(Landroid/content/Context;)Z
    //   564: ifeq +35 -> 599
    //   567: ldc 150
    //   569: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   572: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   575: invokeinterface 160 1 0
    //   580: ldc 246
    //   582: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   585: bipush 50
    //   587: invokestatic 174	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   590: istore 5
    //   592: iload 5
    //   594: istore 4
    //   596: goto -475 -> 121
    //   599: ldc 150
    //   601: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   604: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   607: invokeinterface 160 1 0
    //   612: ldc 248
    //   614: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   617: bipush 50
    //   619: invokestatic 174	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   622: istore 5
    //   624: iload 5
    //   626: istore 4
    //   628: goto -507 -> 121
    //   631: iload 6
    //   633: istore 5
    //   635: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   638: invokestatic 239	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
    //   641: ifeq +30 -> 671
    //   644: iload 6
    //   646: istore 5
    //   648: ldc 150
    //   650: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   653: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   656: invokeinterface 160 1 0
    //   661: ldc 250
    //   663: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   666: astore 10
    //   668: goto -504 -> 164
    //   671: iload 6
    //   673: istore 5
    //   675: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   678: invokestatic 244	com/tencent/mm/sdk/platformtools/az:is3G	(Landroid/content/Context;)Z
    //   681: ifeq +30 -> 711
    //   684: iload 6
    //   686: istore 5
    //   688: ldc 150
    //   690: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   693: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   696: invokeinterface 160 1 0
    //   701: ldc 252
    //   703: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   706: astore 10
    //   708: goto -544 -> 164
    //   711: iload 6
    //   713: istore 5
    //   715: ldc 150
    //   717: invokestatic 156	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   720: checkcast 150	com/tencent/mm/plugin/zero/b/a
    //   723: invokeinterface 160 1 0
    //   728: ldc 254
    //   730: invokevirtual 168	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   733: astore 10
    //   735: goto -571 -> 164
    //   738: astore 10
    //   740: sipush 1080
    //   743: istore 6
    //   745: goto -509 -> 236
    //   748: iload 6
    //   750: sipush 2160
    //   753: if_icmplt +14 -> 767
    //   756: iconst_0
    //   757: istore 6
    //   759: sipush 1080
    //   762: istore 5
    //   764: goto -510 -> 254
    //   767: iload 6
    //   769: ifgt +436 -> 1205
    //   772: iload 5
    //   774: sipush 3240
    //   777: if_icmple +428 -> 1205
    //   780: sipush 1620
    //   783: istore 6
    //   785: iconst_0
    //   786: istore 5
    //   788: goto -534 -> 254
    //   791: aload 11
    //   793: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   796: istore 7
    //   798: goto -524 -> 274
    //   801: aload 11
    //   803: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   806: istore 8
    //   808: goto -514 -> 294
    //   811: iload 7
    //   813: iload 6
    //   815: idiv
    //   816: istore 8
    //   818: aload 11
    //   820: getfield 112	android/graphics/BitmapFactory$Options:outHeight	I
    //   823: iload 6
    //   825: imul
    //   826: iload 7
    //   828: idiv
    //   829: istore 5
    //   831: iload 6
    //   833: aload 11
    //   835: getfield 115	android/graphics/BitmapFactory$Options:outWidth	I
    //   838: imul
    //   839: iload 7
    //   841: idiv
    //   842: istore 7
    //   844: iload 5
    //   846: istore 6
    //   848: iload 7
    //   850: istore 5
    //   852: iload 8
    //   854: istore 7
    //   856: goto -467 -> 389
    //   859: ldc 121
    //   861: ldc_w 256
    //   864: iconst_2
    //   865: anewarray 125	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: aload 12
    //   872: invokevirtual 261	android/graphics/Bitmap:getWidth	()I
    //   875: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   878: aastore
    //   879: dup
    //   880: iconst_1
    //   881: aload 12
    //   883: invokevirtual 264	android/graphics/Bitmap:getHeight	()I
    //   886: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: aastore
    //   890: invokestatic 267	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: iload 7
    //   895: iconst_1
    //   896: if_icmple +79 -> 975
    //   899: aload 12
    //   901: iload 8
    //   903: iload 9
    //   905: iconst_1
    //   906: invokestatic 271	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   909: astore 10
    //   911: aload 12
    //   913: aload 10
    //   915: if_acmpeq +28 -> 943
    //   918: ldc 121
    //   920: ldc_w 273
    //   923: iconst_1
    //   924: anewarray 125	java/lang/Object
    //   927: dup
    //   928: iconst_0
    //   929: aload 12
    //   931: invokevirtual 274	java/lang/Object:toString	()Ljava/lang/String;
    //   934: aastore
    //   935: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   938: aload 12
    //   940: invokevirtual 277	android/graphics/Bitmap:recycle	()V
    //   943: aload 10
    //   945: astore 12
    //   947: aload 10
    //   949: ifnonnull +26 -> 975
    //   952: ldc 121
    //   954: ldc_w 279
    //   957: invokestatic 282	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   960: invokestatic 236	com/tencent/mm/compatible/util/f:getLine	()I
    //   963: istore 4
    //   965: ldc 101
    //   967: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   970: iconst_0
    //   971: iload 4
    //   973: isub
    //   974: ireturn
    //   975: aconst_null
    //   976: astore 11
    //   978: aconst_null
    //   979: astore 10
    //   981: aload_1
    //   982: iconst_0
    //   983: invokestatic 286	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   986: astore 13
    //   988: aload 13
    //   990: astore 10
    //   992: aload 13
    //   994: astore 11
    //   996: aload 12
    //   998: getstatic 292	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1001: iload 4
    //   1003: aload 13
    //   1005: invokevirtual 296	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1008: pop
    //   1009: aload 13
    //   1011: ifnull +8 -> 1019
    //   1014: aload 13
    //   1016: invokevirtual 301	java/io/OutputStream:close	()V
    //   1019: ldc 121
    //   1021: ldc_w 303
    //   1024: iconst_3
    //   1025: anewarray 125	java/lang/Object
    //   1028: dup
    //   1029: iconst_0
    //   1030: aload 12
    //   1032: invokevirtual 274	java/lang/Object:toString	()Ljava/lang/String;
    //   1035: aastore
    //   1036: dup
    //   1037: iconst_1
    //   1038: aload_0
    //   1039: invokestatic 307	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1042: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_2
    //   1048: aload_1
    //   1049: invokestatic 307	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1052: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1055: aastore
    //   1056: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1059: aload 12
    //   1061: invokevirtual 277	android/graphics/Bitmap:recycle	()V
    //   1064: ldc 101
    //   1066: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1069: iconst_0
    //   1070: ireturn
    //   1071: astore_0
    //   1072: aload 10
    //   1074: astore 11
    //   1076: ldc 121
    //   1078: ldc_w 314
    //   1081: invokestatic 282	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: aload 10
    //   1086: astore 11
    //   1088: ldc 121
    //   1090: ldc_w 316
    //   1093: iconst_1
    //   1094: anewarray 125	java/lang/Object
    //   1097: dup
    //   1098: iconst_0
    //   1099: aload_0
    //   1100: invokestatic 319	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1103: aastore
    //   1104: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1107: aload 10
    //   1109: astore 11
    //   1111: ldc 121
    //   1113: ldc_w 273
    //   1116: iconst_1
    //   1117: anewarray 125	java/lang/Object
    //   1120: dup
    //   1121: iconst_0
    //   1122: aload 12
    //   1124: invokevirtual 274	java/lang/Object:toString	()Ljava/lang/String;
    //   1127: aastore
    //   1128: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1131: aload 10
    //   1133: astore 11
    //   1135: aload 12
    //   1137: invokevirtual 277	android/graphics/Bitmap:recycle	()V
    //   1140: aload 10
    //   1142: astore 11
    //   1144: invokestatic 236	com/tencent/mm/compatible/util/f:getLine	()I
    //   1147: istore 4
    //   1149: aload 10
    //   1151: ifnull +8 -> 1159
    //   1154: aload 10
    //   1156: invokevirtual 301	java/io/OutputStream:close	()V
    //   1159: ldc 101
    //   1161: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1164: iconst_0
    //   1165: iload 4
    //   1167: isub
    //   1168: ireturn
    //   1169: astore_0
    //   1170: aload 11
    //   1172: ifnull +8 -> 1180
    //   1175: aload 11
    //   1177: invokevirtual 301	java/io/OutputStream:close	()V
    //   1180: ldc 101
    //   1182: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1185: aload_0
    //   1186: athrow
    //   1187: astore 10
    //   1189: goto -170 -> 1019
    //   1192: astore_0
    //   1193: goto -34 -> 1159
    //   1196: astore_1
    //   1197: goto -17 -> 1180
    //   1200: astore 10
    //   1202: goto -1081 -> 121
    //   1205: iload 5
    //   1207: istore 7
    //   1209: iload 6
    //   1211: istore 5
    //   1213: iload 7
    //   1215: istore 6
    //   1217: goto -963 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1220	0	paramString1	String
    //   0	1220	1	paramString2	String
    //   420	13	2	d	double
    //   81	1087	4	i	int
    //   115	1097	5	j	int
    //   125	1091	6	k	int
    //   122	1092	7	m	int
    //   175	727	8	n	int
    //   391	513	9	i1	int
    //   162	572	10	localObject1	Object
    //   738	1	10	localException1	Exception
    //   909	246	10	localObject2	Object
    //   1187	1	10	localIOException	java.io.IOException
    //   1200	1	10	localException2	Exception
    //   9	1167	11	localObject3	Object
    //   473	663	12	localObject4	Object
    //   986	29	13	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   131	140	738	java/lang/Exception
    //   144	164	738	java/lang/Exception
    //   168	177	738	java/lang/Exception
    //   191	207	738	java/lang/Exception
    //   211	228	738	java/lang/Exception
    //   635	644	738	java/lang/Exception
    //   648	668	738	java/lang/Exception
    //   675	684	738	java/lang/Exception
    //   688	708	738	java/lang/Exception
    //   715	735	738	java/lang/Exception
    //   981	988	1071	java/lang/Exception
    //   996	1009	1071	java/lang/Exception
    //   981	988	1169	finally
    //   996	1009	1169	finally
    //   1076	1084	1169	finally
    //   1088	1107	1169	finally
    //   1111	1131	1169	finally
    //   1135	1140	1169	finally
    //   1144	1149	1169	finally
    //   1014	1019	1187	java/io/IOException
    //   1154	1159	1192	java/io/IOException
    //   1175	1180	1196	java/io/IOException
    //   83	117	1200	java/lang/Exception
    //   517	551	1200	java/lang/Exception
    //   558	592	1200	java/lang/Exception
    //   599	624	1200	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150309);
    super.cancel();
    AppMethodBeat.o(150309);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150306);
    this.callback = paramf;
    if ((this.dzD == null) || (this.dzD.length() == 0))
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      AppMethodBeat.o(150306);
      return -1;
    }
    if (!o.fB(this.dzD))
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.dzD);
      AppMethodBeat.o(150306);
      return -1;
    }
    if (this.hPI == 0) {
      this.hPI = ((int)o.aZR(this.dzD));
    }
    int i = Math.min(this.hPI - this.dgI, 8192);
    Object localObject = o.bb(this.dzD, this.dgI, i);
    if (localObject == null)
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      AppMethodBeat.o(150306);
      return -1;
    }
    ae.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(this.hPI) });
    paramf = new b.a();
    paramf.hQF = new dtm();
    paramf.hQG = new dtn();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    paramf.funcId = 157;
    paramf.hQH = 46;
    paramf.respCmdId = 1000000046;
    paramf = paramf.aDS();
    dtm localdtm = (dtm)paramf.hQD.hQJ;
    localdtm.xsB = this.hPI;
    localdtm.xsC = this.dgI;
    localdtm.GSk = this.hPJ;
    localdtm.xsE = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    localdtm.HZe = this.hPZ;
    try
    {
      localObject = new eby();
      ((eby)localObject).Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
      localdtm.FSj = new SKBuiltinBuffer_t().setBuffer(((eby)localObject).toByteArray());
      label365:
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(150306);
      return i;
    }
    catch (Throwable localThrowable)
    {
      break label365;
    }
  }
  
  public final int getType()
  {
    return 157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150308);
    paramArrayOfByte = (dtn)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(150308);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if (paramInt1 == -4) {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    this.dgI = paramArrayOfByte.xsC;
    if (this.dgI < this.hPI)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ae.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ae.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      AppMethodBeat.o(150308);
      return;
    }
    try
    {
      o.mG(this.dzD, this.hPY);
      com.tencent.mm.kernel.g.ajR().ajA().set(12297, paramArrayOfByte.HZf);
      p.aEA().e(this.hQa, h.aRC(this.hPY));
      paramq = v.aAC();
      if (!bu.isNullOrNil(paramq))
      {
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramq;
        paramArrayOfByte.eD(true);
        paramArrayOfByte.dEu = 32;
        paramArrayOfByte.eQU = 3;
        paramArrayOfByte.dEu = 34;
        p.aEN().b(paramArrayOfByte);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150308);
    }
  }
  
  public final int securityLimitCount()
  {
    return 200;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(150307);
    if ((this.dzD == null) || (this.dzD.length() == 0))
    {
      paramq = n.b.hRj;
      AppMethodBeat.o(150307);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(150307);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.m
 * JD-Core Version:    0.7.0.1
 */