package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class l
  extends m
  implements k
{
  private f callback;
  private int chT;
  private int fsd;
  private int fse;
  private String fst;
  private String fsu;
  private String fsv;
  private String imgPath;
  
  public l(String paramString)
  {
    AppMethodBeat.i(77941);
    this.fsv = r.Zn();
    o.acQ();
    this.fst = d.E(this.fsv, true);
    String str = this.fst + ".tmp";
    if (aA(paramString, str) == 0)
    {
      this.imgPath = str;
      this.fse = 1;
      o.acQ();
      this.fsu = com.tencent.mm.a.g.w(com.tencent.mm.vfs.e.i(d.D(this.fsv, true), 0, -1));
      this.fsd = 0;
      this.chT = 0;
    }
    AppMethodBeat.o(77941);
  }
  
  /* Error */
  private static int aA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 106	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore 11
    //   11: aload 11
    //   13: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   16: sipush 640
    //   19: if_icmpge +60 -> 79
    //   22: aload 11
    //   24: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   27: sipush 640
    //   30: if_icmpge +49 -> 79
    //   33: aload_0
    //   34: aload_1
    //   35: invokestatic 118	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   38: pop2
    //   39: ldc 120
    //   41: ldc 122
    //   43: iconst_2
    //   44: anewarray 124	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload 11
    //   51: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   54: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload 11
    //   62: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   65: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 100
    //   74: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_0
    //   78: ireturn
    //   79: bipush 50
    //   81: istore 4
    //   83: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   86: invokestatic 147	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
    //   89: ifeq +428 -> 517
    //   92: ldc 149
    //   94: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   97: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   100: invokeinterface 158 1 0
    //   105: ldc 160
    //   107: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   110: bipush 50
    //   112: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   115: istore 5
    //   117: iload 5
    //   119: istore 4
    //   121: iconst_0
    //   122: istore 7
    //   124: iconst_0
    //   125: istore 6
    //   127: iload 6
    //   129: istore 5
    //   131: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   134: invokestatic 147	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
    //   137: ifeq +494 -> 631
    //   140: iload 6
    //   142: istore 5
    //   144: ldc 149
    //   146: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   149: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   152: invokeinterface 158 1 0
    //   157: ldc 174
    //   159: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 10
    //   164: iload 6
    //   166: istore 5
    //   168: aload 10
    //   170: ldc 176
    //   172: invokevirtual 182	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   196: invokevirtual 186	java/lang/String:substring	(II)Ljava/lang/String;
    //   199: invokestatic 189	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   202: invokevirtual 193	java/lang/Integer:intValue	()I
    //   205: istore 6
    //   207: iload 6
    //   209: istore 5
    //   211: aload 10
    //   213: iload 8
    //   215: iconst_1
    //   216: iadd
    //   217: invokevirtual 196	java/lang/String:substring	(I)Ljava/lang/String;
    //   220: invokestatic 189	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   223: invokevirtual 193	java/lang/Integer:intValue	()I
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
    //   256: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   259: aload 11
    //   261: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   264: if_icmple +527 -> 791
    //   267: aload 11
    //   269: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   272: istore 7
    //   274: aload 11
    //   276: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   279: aload 11
    //   281: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   284: if_icmpge +517 -> 801
    //   287: aload 11
    //   289: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   292: istore 8
    //   294: ldc 120
    //   296: ldc 198
    //   298: iconst_5
    //   299: anewarray 124	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload 6
    //   306: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: iload 5
    //   314: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: iload 4
    //   322: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: dup
    //   327: iconst_3
    //   328: aload 11
    //   330: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   333: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: dup
    //   338: iconst_4
    //   339: aload 11
    //   341: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   344: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iload 5
    //   353: ifle +458 -> 811
    //   356: iload 8
    //   358: iload 5
    //   360: idiv
    //   361: istore 7
    //   363: aload 11
    //   365: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   368: iload 5
    //   370: imul
    //   371: iload 8
    //   373: idiv
    //   374: istore 6
    //   376: iload 5
    //   378: aload 11
    //   380: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
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
    //   402: ldc 199
    //   404: if_icmple +33 -> 437
    //   407: ldc2_w 200
    //   410: iload 6
    //   412: iload 5
    //   414: imul
    //   415: i2d
    //   416: ddiv
    //   417: invokestatic 207	java/lang/Math:sqrt	(D)D
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
    //   437: new 108	android/graphics/BitmapFactory$Options
    //   440: dup
    //   441: invokespecial 208	android/graphics/BitmapFactory$Options:<init>	()V
    //   444: astore 10
    //   446: aload 10
    //   448: getstatic 214	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   451: putfield 217	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   454: iload 7
    //   456: iconst_2
    //   457: if_icmplt +10 -> 467
    //   460: aload 10
    //   462: iload 7
    //   464: putfield 220	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   467: aload_0
    //   468: aload 10
    //   470: invokestatic 224	com/tencent/mm/sdk/platformtools/d:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   473: astore 12
    //   475: aload 12
    //   477: ifnonnull +382 -> 859
    //   480: ldc 120
    //   482: ldc 226
    //   484: iconst_1
    //   485: anewarray 124	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload 10
    //   492: getfield 220	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   495: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: invokestatic 234	com/tencent/mm/compatible/util/g:getLine	()I
    //   505: istore 4
    //   507: ldc 100
    //   509: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: iconst_0
    //   513: iload 4
    //   515: isub
    //   516: ireturn
    //   517: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   520: invokestatic 237	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   523: ifeq +35 -> 558
    //   526: ldc 149
    //   528: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   531: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   534: invokeinterface 158 1 0
    //   539: ldc 239
    //   541: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   544: bipush 50
    //   546: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   549: istore 5
    //   551: iload 5
    //   553: istore 4
    //   555: goto -434 -> 121
    //   558: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   561: invokestatic 242	com/tencent/mm/sdk/platformtools/at:is3G	(Landroid/content/Context;)Z
    //   564: ifeq +35 -> 599
    //   567: ldc 149
    //   569: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   572: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   575: invokeinterface 158 1 0
    //   580: ldc 244
    //   582: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   585: bipush 50
    //   587: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   590: istore 5
    //   592: iload 5
    //   594: istore 4
    //   596: goto -475 -> 121
    //   599: ldc 149
    //   601: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   604: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   607: invokeinterface 158 1 0
    //   612: ldc 246
    //   614: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   617: bipush 50
    //   619: invokestatic 172	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   622: istore 5
    //   624: iload 5
    //   626: istore 4
    //   628: goto -507 -> 121
    //   631: iload 6
    //   633: istore 5
    //   635: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   638: invokestatic 237	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   641: ifeq +30 -> 671
    //   644: iload 6
    //   646: istore 5
    //   648: ldc 149
    //   650: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   653: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   656: invokeinterface 158 1 0
    //   661: ldc 248
    //   663: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   666: astore 10
    //   668: goto -504 -> 164
    //   671: iload 6
    //   673: istore 5
    //   675: invokestatic 141	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   678: invokestatic 242	com/tencent/mm/sdk/platformtools/at:is3G	(Landroid/content/Context;)Z
    //   681: ifeq +30 -> 711
    //   684: iload 6
    //   686: istore 5
    //   688: ldc 149
    //   690: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   693: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   696: invokeinterface 158 1 0
    //   701: ldc 250
    //   703: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   706: astore 10
    //   708: goto -544 -> 164
    //   711: iload 6
    //   713: istore 5
    //   715: ldc 149
    //   717: invokestatic 154	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   720: checkcast 149	com/tencent/mm/plugin/zero/b/a
    //   723: invokeinterface 158 1 0
    //   728: ldc 252
    //   730: invokevirtual 166	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
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
    //   769: ifgt +435 -> 1204
    //   772: iload 5
    //   774: sipush 3240
    //   777: if_icmple +427 -> 1204
    //   780: sipush 1620
    //   783: istore 6
    //   785: iconst_0
    //   786: istore 5
    //   788: goto -534 -> 254
    //   791: aload 11
    //   793: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   796: istore 7
    //   798: goto -524 -> 274
    //   801: aload 11
    //   803: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   806: istore 8
    //   808: goto -514 -> 294
    //   811: iload 7
    //   813: iload 6
    //   815: idiv
    //   816: istore 8
    //   818: aload 11
    //   820: getfield 111	android/graphics/BitmapFactory$Options:outHeight	I
    //   823: iload 6
    //   825: imul
    //   826: iload 7
    //   828: idiv
    //   829: istore 5
    //   831: iload 6
    //   833: aload 11
    //   835: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
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
    //   859: ldc 120
    //   861: ldc 254
    //   863: iconst_2
    //   864: anewarray 124	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload 12
    //   871: invokevirtual 259	android/graphics/Bitmap:getWidth	()I
    //   874: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   877: aastore
    //   878: dup
    //   879: iconst_1
    //   880: aload 12
    //   882: invokevirtual 262	android/graphics/Bitmap:getHeight	()I
    //   885: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   888: aastore
    //   889: invokestatic 265	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   892: iload 7
    //   894: iconst_1
    //   895: if_icmple +79 -> 974
    //   898: aload 12
    //   900: iload 8
    //   902: iload 9
    //   904: iconst_1
    //   905: invokestatic 269	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   908: astore 10
    //   910: aload 12
    //   912: aload 10
    //   914: if_acmpeq +28 -> 942
    //   917: ldc 120
    //   919: ldc_w 271
    //   922: iconst_1
    //   923: anewarray 124	java/lang/Object
    //   926: dup
    //   927: iconst_0
    //   928: aload 12
    //   930: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   933: aastore
    //   934: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 12
    //   939: invokevirtual 275	android/graphics/Bitmap:recycle	()V
    //   942: aload 10
    //   944: astore 12
    //   946: aload 10
    //   948: ifnonnull +26 -> 974
    //   951: ldc 120
    //   953: ldc_w 277
    //   956: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: invokestatic 234	com/tencent/mm/compatible/util/g:getLine	()I
    //   962: istore 4
    //   964: ldc 100
    //   966: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   969: iconst_0
    //   970: iload 4
    //   972: isub
    //   973: ireturn
    //   974: aconst_null
    //   975: astore 11
    //   977: aconst_null
    //   978: astore 10
    //   980: aload_1
    //   981: iconst_0
    //   982: invokestatic 284	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   985: astore 13
    //   987: aload 13
    //   989: astore 10
    //   991: aload 13
    //   993: astore 11
    //   995: aload 12
    //   997: getstatic 290	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1000: iload 4
    //   1002: aload 13
    //   1004: invokevirtual 294	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1007: pop
    //   1008: aload 13
    //   1010: ifnull +8 -> 1018
    //   1013: aload 13
    //   1015: invokevirtual 299	java/io/OutputStream:close	()V
    //   1018: ldc 120
    //   1020: ldc_w 301
    //   1023: iconst_3
    //   1024: anewarray 124	java/lang/Object
    //   1027: dup
    //   1028: iconst_0
    //   1029: aload 12
    //   1031: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   1034: aastore
    //   1035: dup
    //   1036: iconst_1
    //   1037: aload_0
    //   1038: invokestatic 305	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1041: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1044: aastore
    //   1045: dup
    //   1046: iconst_2
    //   1047: aload_1
    //   1048: invokestatic 305	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1051: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1054: aastore
    //   1055: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1058: aload 12
    //   1060: invokevirtual 275	android/graphics/Bitmap:recycle	()V
    //   1063: ldc 100
    //   1065: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1068: iconst_0
    //   1069: ireturn
    //   1070: astore_0
    //   1071: aload 10
    //   1073: astore 11
    //   1075: ldc 120
    //   1077: ldc_w 312
    //   1080: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1083: aload 10
    //   1085: astore 11
    //   1087: ldc 120
    //   1089: ldc_w 314
    //   1092: iconst_1
    //   1093: anewarray 124	java/lang/Object
    //   1096: dup
    //   1097: iconst_0
    //   1098: aload_0
    //   1099: invokestatic 318	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1102: aastore
    //   1103: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1106: aload 10
    //   1108: astore 11
    //   1110: ldc 120
    //   1112: ldc_w 271
    //   1115: iconst_1
    //   1116: anewarray 124	java/lang/Object
    //   1119: dup
    //   1120: iconst_0
    //   1121: aload 12
    //   1123: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   1126: aastore
    //   1127: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1130: aload 10
    //   1132: astore 11
    //   1134: aload 12
    //   1136: invokevirtual 275	android/graphics/Bitmap:recycle	()V
    //   1139: aload 10
    //   1141: astore 11
    //   1143: invokestatic 234	com/tencent/mm/compatible/util/g:getLine	()I
    //   1146: istore 4
    //   1148: aload 10
    //   1150: ifnull +8 -> 1158
    //   1153: aload 10
    //   1155: invokevirtual 299	java/io/OutputStream:close	()V
    //   1158: ldc 100
    //   1160: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: iconst_0
    //   1164: iload 4
    //   1166: isub
    //   1167: ireturn
    //   1168: astore_0
    //   1169: aload 11
    //   1171: ifnull +8 -> 1179
    //   1174: aload 11
    //   1176: invokevirtual 299	java/io/OutputStream:close	()V
    //   1179: ldc 100
    //   1181: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1184: aload_0
    //   1185: athrow
    //   1186: astore 10
    //   1188: goto -170 -> 1018
    //   1191: astore_0
    //   1192: goto -34 -> 1158
    //   1195: astore_1
    //   1196: goto -17 -> 1179
    //   1199: astore 10
    //   1201: goto -1080 -> 121
    //   1204: iload 5
    //   1206: istore 7
    //   1208: iload 6
    //   1210: istore 5
    //   1212: iload 7
    //   1214: istore 6
    //   1216: goto -962 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1219	0	paramString1	String
    //   0	1219	1	paramString2	String
    //   420	13	2	d	double
    //   81	1086	4	i	int
    //   115	1096	5	j	int
    //   125	1090	6	k	int
    //   122	1091	7	m	int
    //   175	726	8	n	int
    //   391	512	9	i1	int
    //   162	572	10	localObject1	Object
    //   738	1	10	localException1	Exception
    //   908	246	10	localObject2	Object
    //   1186	1	10	localIOException	java.io.IOException
    //   1199	1	10	localException2	Exception
    //   9	1166	11	localObject3	Object
    //   473	662	12	localObject4	Object
    //   985	29	13	localOutputStream	java.io.OutputStream
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
    //   980	987	1070	java/lang/Exception
    //   995	1008	1070	java/lang/Exception
    //   980	987	1168	finally
    //   995	1008	1168	finally
    //   1075	1083	1168	finally
    //   1087	1106	1168	finally
    //   1110	1130	1168	finally
    //   1134	1139	1168	finally
    //   1143	1148	1168	finally
    //   1013	1018	1186	java/io/IOException
    //   1153	1158	1191	java/io/IOException
    //   1174	1179	1195	java/io/IOException
    //   83	117	1199	java/lang/Exception
    //   517	551	1199	java/lang/Exception
    //   558	592	1199	java/lang/Exception
    //   599	624	1199	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77945);
    super.cancel();
    AppMethodBeat.o(77945);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(77942);
    this.callback = paramf;
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      AppMethodBeat.o(77942);
      return -1;
    }
    if (!com.tencent.mm.vfs.e.cN(this.imgPath))
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.imgPath);
      AppMethodBeat.o(77942);
      return -1;
    }
    if (this.fsd == 0) {
      this.fsd = ((int)com.tencent.mm.vfs.e.avI(this.imgPath));
    }
    int i = Math.min(this.fsd - this.chT, 8192);
    paramf = com.tencent.mm.vfs.e.i(this.imgPath, this.chT, i);
    if (paramf == null)
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      AppMethodBeat.o(77942);
      return -1;
    }
    ab.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.fsd) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cod();
    ((b.a)localObject).fsY = new coe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    ((b.a)localObject).funcId = 157;
    ((b.a)localObject).reqCmdId = 46;
    ((b.a)localObject).respCmdId = 1000000046;
    localObject = ((b.a)localObject).ado();
    cod localcod = (cod)((b)localObject).fsV.fta;
    localcod.pIx = this.fsd;
    localcod.pIy = this.chT;
    localcod.xbX = this.fse;
    localcod.pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    localcod.xWU = this.fsu;
    i = dispatch(parame, (q)localObject, this);
    AppMethodBeat.o(77942);
    return i;
  }
  
  public final int getType()
  {
    return 157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77944);
    paramArrayOfByte = (coe)((b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77944);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(77944);
      return;
    }
    paramInt1 = paramq.getRespObj().getRetCode();
    if (paramInt1 == -4) {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77944);
      return;
    }
    this.chT = paramArrayOfByte.pIy;
    if (this.chT < this.fsd)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ab.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ab.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      AppMethodBeat.o(77944);
      return;
    }
    try
    {
      com.tencent.mm.vfs.e.aT(this.imgPath, this.fst);
      com.tencent.mm.kernel.g.RL().Ru().set(12297, paramArrayOfByte.xWV);
      o.acQ().f(this.fsv, com.tencent.mm.sdk.platformtools.d.aoV(this.fst));
      paramq = r.Zn();
      if (!bo.isNullOrNil(paramq))
      {
        paramArrayOfByte = new h();
        paramArrayOfByte.username = paramq;
        paramArrayOfByte.cM(true);
        paramArrayOfByte.bsY = 32;
        paramArrayOfByte.dqB = 3;
        paramArrayOfByte.bsY = 34;
        o.adg().b(paramArrayOfByte);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77944);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(77944);
    }
  }
  
  public final int securityLimitCount()
  {
    return 200;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(77943);
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      paramq = m.b.ftv;
      AppMethodBeat.o(77943);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(77943);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ah.l
 * JD-Core Version:    0.7.0.1
 */