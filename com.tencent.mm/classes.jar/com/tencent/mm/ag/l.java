package com.tencent.mm.ag;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.protocal.c.cay;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;

public final class l
  extends m
  implements k
{
  private f dmL;
  private int ebK;
  private int ebL;
  private int ebM;
  private String ecc;
  private String ecd;
  private String ece = com.tencent.mm.model.q.Gj();
  private String imgPath;
  
  public l(int paramInt, String paramString)
  {
    if (paramInt == 2) {
      this.ece = ad.aaZ(this.ece);
    }
    o.JQ();
    this.ecc = d.A(this.ece, true);
    String str = this.ecc + ".tmp";
    if (ak(paramString, str) == 0)
    {
      this.imgPath = str;
      this.ebM = paramInt;
      o.JQ();
      this.ecd = com.tencent.mm.a.g.o(com.tencent.mm.vfs.e.c(d.z(this.ece, true), 0, -1));
      this.ebK = 0;
      this.ebL = 0;
    }
  }
  
  /* Error */
  private static int ak(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 1080
    //   3: istore 7
    //   5: bipush 50
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: invokestatic 102	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   16: astore 11
    //   18: aload 11
    //   20: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   23: sipush 640
    //   26: if_icmpge +60 -> 86
    //   29: aload 11
    //   31: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   34: sipush 640
    //   37: if_icmpge +49 -> 86
    //   40: aload_0
    //   41: aload_1
    //   42: invokestatic 114	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   45: pop2
    //   46: ldc 116
    //   48: ldc 118
    //   50: iconst_2
    //   51: anewarray 120	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload 11
    //   58: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   61: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: aload 11
    //   69: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: iload 5
    //   81: istore 4
    //   83: iload 4
    //   85: ireturn
    //   86: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   89: invokestatic 144	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   92: ifeq +384 -> 476
    //   95: ldc 146
    //   97: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   100: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   103: invokeinterface 155 1 0
    //   108: ldc 157
    //   110: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   113: bipush 50
    //   115: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   118: istore 5
    //   120: iload 5
    //   122: istore 4
    //   124: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   127: invokestatic 144	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   130: ifeq +460 -> 590
    //   133: ldc 146
    //   135: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   138: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   141: invokeinterface 155 1 0
    //   146: ldc 170
    //   148: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore 10
    //   153: aload 10
    //   155: ldc 172
    //   157: invokevirtual 178	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   160: istore 6
    //   162: iconst_m1
    //   163: iload 6
    //   165: if_icmpeq +964 -> 1129
    //   168: aload 10
    //   170: iconst_0
    //   171: iload 6
    //   173: invokevirtual 182	java/lang/String:substring	(II)Ljava/lang/String;
    //   176: invokestatic 185	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   179: invokevirtual 189	java/lang/Integer:intValue	()I
    //   182: istore 5
    //   184: aload 10
    //   186: iload 6
    //   188: iconst_1
    //   189: iadd
    //   190: invokevirtual 192	java/lang/String:substring	(I)Ljava/lang/String;
    //   193: invokestatic 185	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   196: invokevirtual 189	java/lang/Integer:intValue	()I
    //   199: istore 6
    //   201: iload 5
    //   203: ifgt +487 -> 690
    //   206: iload 6
    //   208: ifgt +482 -> 690
    //   211: iconst_0
    //   212: istore 5
    //   214: iload 7
    //   216: istore 6
    //   218: aload 11
    //   220: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   223: aload 11
    //   225: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   228: if_icmple +504 -> 732
    //   231: aload 11
    //   233: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   236: istore 7
    //   238: aload 11
    //   240: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   243: aload 11
    //   245: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   248: if_icmpge +494 -> 742
    //   251: aload 11
    //   253: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   256: istore 8
    //   258: ldc 116
    //   260: ldc 194
    //   262: iconst_5
    //   263: anewarray 120	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: iload 5
    //   270: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: iload 6
    //   278: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: iload 4
    //   286: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: iconst_3
    //   292: aload 11
    //   294: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   297: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: dup
    //   302: iconst_4
    //   303: aload 11
    //   305: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   308: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: iload 6
    //   317: ifle +435 -> 752
    //   320: iload 8
    //   322: iload 6
    //   324: idiv
    //   325: istore 7
    //   327: aload 11
    //   329: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   332: iload 6
    //   334: imul
    //   335: iload 8
    //   337: idiv
    //   338: istore 9
    //   340: iload 6
    //   342: aload 11
    //   344: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   347: imul
    //   348: iload 8
    //   350: idiv
    //   351: istore 5
    //   353: iload 9
    //   355: istore 6
    //   357: iload 6
    //   359: istore 9
    //   361: iload 5
    //   363: istore 8
    //   365: iload 6
    //   367: iload 5
    //   369: imul
    //   370: ldc 195
    //   372: if_icmple +33 -> 405
    //   375: ldc2_w 196
    //   378: iload 6
    //   380: iload 5
    //   382: imul
    //   383: i2d
    //   384: ddiv
    //   385: invokestatic 203	java/lang/Math:sqrt	(D)D
    //   388: dstore_2
    //   389: iload 6
    //   391: i2d
    //   392: dload_2
    //   393: ddiv
    //   394: d2i
    //   395: istore 9
    //   397: iload 5
    //   399: i2d
    //   400: dload_2
    //   401: ddiv
    //   402: d2i
    //   403: istore 8
    //   405: new 104	android/graphics/BitmapFactory$Options
    //   408: dup
    //   409: invokespecial 204	android/graphics/BitmapFactory$Options:<init>	()V
    //   412: astore 10
    //   414: aload 10
    //   416: getstatic 210	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   419: putfield 213	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   422: iload 7
    //   424: iconst_2
    //   425: if_icmplt +10 -> 435
    //   428: aload 10
    //   430: iload 7
    //   432: putfield 216	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   435: aload_0
    //   436: aload 10
    //   438: invokestatic 220	com/tencent/mm/sdk/platformtools/c:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   441: astore 12
    //   443: aload 12
    //   445: ifnonnull +347 -> 792
    //   448: ldc 116
    //   450: ldc 222
    //   452: iconst_1
    //   453: anewarray 120	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload 10
    //   460: getfield 216	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   463: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: aastore
    //   467: invokestatic 225	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: iconst_0
    //   471: invokestatic 230	com/tencent/mm/compatible/util/g:getLine	()I
    //   474: isub
    //   475: ireturn
    //   476: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   479: invokestatic 233	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   482: ifeq +35 -> 517
    //   485: ldc 146
    //   487: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   490: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   493: invokeinterface 155 1 0
    //   498: ldc 235
    //   500: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   503: bipush 50
    //   505: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   508: istore 5
    //   510: iload 5
    //   512: istore 4
    //   514: goto -390 -> 124
    //   517: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   520: invokestatic 238	com/tencent/mm/sdk/platformtools/aq:is3G	(Landroid/content/Context;)Z
    //   523: ifeq +35 -> 558
    //   526: ldc 146
    //   528: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   531: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   534: invokeinterface 155 1 0
    //   539: ldc 240
    //   541: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   544: bipush 50
    //   546: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   549: istore 5
    //   551: iload 5
    //   553: istore 4
    //   555: goto -431 -> 124
    //   558: ldc 146
    //   560: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   563: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   566: invokeinterface 155 1 0
    //   571: ldc 242
    //   573: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   576: bipush 50
    //   578: invokestatic 168	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   581: istore 5
    //   583: iload 5
    //   585: istore 4
    //   587: goto -463 -> 124
    //   590: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   593: invokestatic 233	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   596: ifeq +26 -> 622
    //   599: ldc 146
    //   601: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   604: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   607: invokeinterface 155 1 0
    //   612: ldc 244
    //   614: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore 10
    //   619: goto -466 -> 153
    //   622: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   625: invokestatic 238	com/tencent/mm/sdk/platformtools/aq:is3G	(Landroid/content/Context;)Z
    //   628: ifeq +26 -> 654
    //   631: ldc 146
    //   633: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   636: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   639: invokeinterface 155 1 0
    //   644: ldc 246
    //   646: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   649: astore 10
    //   651: goto -498 -> 153
    //   654: ldc 146
    //   656: invokestatic 151	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   659: checkcast 146	com/tencent/mm/plugin/zero/b/a
    //   662: invokeinterface 155 1 0
    //   667: ldc 248
    //   669: invokevirtual 162	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   672: astore 10
    //   674: goto -521 -> 153
    //   677: astore 10
    //   679: iconst_0
    //   680: istore 5
    //   682: sipush 1080
    //   685: istore 6
    //   687: goto -486 -> 201
    //   690: iload 6
    //   692: sipush 2160
    //   695: if_icmplt +13 -> 708
    //   698: iconst_0
    //   699: istore 5
    //   701: iload 7
    //   703: istore 6
    //   705: goto -487 -> 218
    //   708: iload 6
    //   710: ifgt +416 -> 1126
    //   713: iload 5
    //   715: sipush 3240
    //   718: if_icmple +408 -> 1126
    //   721: iconst_0
    //   722: istore 6
    //   724: sipush 1620
    //   727: istore 5
    //   729: goto -511 -> 218
    //   732: aload 11
    //   734: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   737: istore 7
    //   739: goto -501 -> 238
    //   742: aload 11
    //   744: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   747: istore 8
    //   749: goto -491 -> 258
    //   752: iload 7
    //   754: iload 5
    //   756: idiv
    //   757: istore 8
    //   759: aload 11
    //   761: getfield 107	android/graphics/BitmapFactory$Options:outHeight	I
    //   764: iload 5
    //   766: imul
    //   767: iload 7
    //   769: idiv
    //   770: istore 6
    //   772: aload 11
    //   774: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   777: iload 5
    //   779: imul
    //   780: iload 7
    //   782: idiv
    //   783: istore 5
    //   785: iload 8
    //   787: istore 7
    //   789: goto -432 -> 357
    //   792: ldc 116
    //   794: ldc 250
    //   796: iconst_2
    //   797: anewarray 120	java/lang/Object
    //   800: dup
    //   801: iconst_0
    //   802: aload 12
    //   804: invokevirtual 255	android/graphics/Bitmap:getWidth	()I
    //   807: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   810: aastore
    //   811: dup
    //   812: iconst_1
    //   813: aload 12
    //   815: invokevirtual 258	android/graphics/Bitmap:getHeight	()I
    //   818: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: aastore
    //   822: invokestatic 261	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   825: iload 7
    //   827: iconst_1
    //   828: if_icmple +70 -> 898
    //   831: aload 12
    //   833: iload 8
    //   835: iload 9
    //   837: iconst_1
    //   838: invokestatic 265	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   841: astore 10
    //   843: aload 12
    //   845: aload 10
    //   847: if_acmpeq +28 -> 875
    //   850: ldc 116
    //   852: ldc_w 267
    //   855: iconst_1
    //   856: anewarray 120	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload 12
    //   863: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   866: aastore
    //   867: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   870: aload 12
    //   872: invokevirtual 271	android/graphics/Bitmap:recycle	()V
    //   875: aload 10
    //   877: astore 12
    //   879: aload 10
    //   881: ifnonnull +17 -> 898
    //   884: ldc 116
    //   886: ldc_w 273
    //   889: invokestatic 276	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: iconst_0
    //   893: invokestatic 230	com/tencent/mm/compatible/util/g:getLine	()I
    //   896: isub
    //   897: ireturn
    //   898: aconst_null
    //   899: astore 11
    //   901: aconst_null
    //   902: astore 10
    //   904: aload_1
    //   905: iconst_0
    //   906: invokestatic 279	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   909: astore 13
    //   911: aload 13
    //   913: astore 10
    //   915: aload 13
    //   917: astore 11
    //   919: aload 12
    //   921: getstatic 285	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   924: iload 4
    //   926: aload 13
    //   928: invokevirtual 289	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   931: pop
    //   932: aload 13
    //   934: ifnull +8 -> 942
    //   937: aload 13
    //   939: invokevirtual 294	java/io/OutputStream:close	()V
    //   942: ldc 116
    //   944: ldc_w 296
    //   947: iconst_3
    //   948: anewarray 120	java/lang/Object
    //   951: dup
    //   952: iconst_0
    //   953: aload 12
    //   955: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: aload_0
    //   962: invokestatic 300	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   965: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   968: aastore
    //   969: dup
    //   970: iconst_2
    //   971: aload_1
    //   972: invokestatic 300	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   975: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   978: aastore
    //   979: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   982: aload 12
    //   984: invokevirtual 271	android/graphics/Bitmap:recycle	()V
    //   987: iconst_0
    //   988: ireturn
    //   989: astore_0
    //   990: aload 10
    //   992: astore 11
    //   994: ldc 116
    //   996: ldc_w 307
    //   999: invokestatic 276	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: aload 10
    //   1004: astore 11
    //   1006: ldc 116
    //   1008: ldc_w 309
    //   1011: iconst_1
    //   1012: anewarray 120	java/lang/Object
    //   1015: dup
    //   1016: iconst_0
    //   1017: aload_0
    //   1018: invokestatic 313	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1021: aastore
    //   1022: invokestatic 225	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: aload 10
    //   1027: astore 11
    //   1029: ldc 116
    //   1031: ldc_w 267
    //   1034: iconst_1
    //   1035: anewarray 120	java/lang/Object
    //   1038: dup
    //   1039: iconst_0
    //   1040: aload 12
    //   1042: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   1045: aastore
    //   1046: invokestatic 132	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1049: aload 10
    //   1051: astore 11
    //   1053: aload 12
    //   1055: invokevirtual 271	android/graphics/Bitmap:recycle	()V
    //   1058: aload 10
    //   1060: astore 11
    //   1062: invokestatic 230	com/tencent/mm/compatible/util/g:getLine	()I
    //   1065: istore 4
    //   1067: iconst_0
    //   1068: iload 4
    //   1070: isub
    //   1071: istore 5
    //   1073: iload 5
    //   1075: istore 4
    //   1077: aload 10
    //   1079: ifnull -996 -> 83
    //   1082: aload 10
    //   1084: invokevirtual 294	java/io/OutputStream:close	()V
    //   1087: iload 5
    //   1089: ireturn
    //   1090: astore_0
    //   1091: iload 5
    //   1093: ireturn
    //   1094: astore_0
    //   1095: aload 11
    //   1097: ifnull +8 -> 1105
    //   1100: aload 11
    //   1102: invokevirtual 294	java/io/OutputStream:close	()V
    //   1105: aload_0
    //   1106: athrow
    //   1107: astore 10
    //   1109: goto -167 -> 942
    //   1112: astore_1
    //   1113: goto -8 -> 1105
    //   1116: astore 10
    //   1118: goto -436 -> 682
    //   1121: astore 10
    //   1123: goto -999 -> 124
    //   1126: goto -908 -> 218
    //   1129: sipush 1080
    //   1132: istore 6
    //   1134: iconst_0
    //   1135: istore 5
    //   1137: goto -936 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1140	0	paramString1	String
    //   0	1140	1	paramString2	String
    //   388	13	2	d	double
    //   7	1069	4	i	int
    //   10	1126	5	j	int
    //   160	973	6	k	int
    //   3	826	7	m	int
    //   256	578	8	n	int
    //   338	498	9	i1	int
    //   151	522	10	localObject1	Object
    //   677	1	10	localException1	Exception
    //   841	242	10	localObject2	Object
    //   1107	1	10	localIOException	java.io.IOException
    //   1116	1	10	localException2	Exception
    //   1121	1	10	localException3	Exception
    //   16	1085	11	localObject3	Object
    //   441	613	12	localObject4	Object
    //   909	29	13	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   124	153	677	java/lang/Exception
    //   153	162	677	java/lang/Exception
    //   168	184	677	java/lang/Exception
    //   590	619	677	java/lang/Exception
    //   622	651	677	java/lang/Exception
    //   654	674	677	java/lang/Exception
    //   904	911	989	java/lang/Exception
    //   919	932	989	java/lang/Exception
    //   1082	1087	1090	java/io/IOException
    //   904	911	1094	finally
    //   919	932	1094	finally
    //   994	1002	1094	finally
    //   1006	1025	1094	finally
    //   1029	1049	1094	finally
    //   1053	1058	1094	finally
    //   1062	1067	1094	finally
    //   937	942	1107	java/io/IOException
    //   1100	1105	1112	java/io/IOException
    //   184	201	1116	java/lang/Exception
    //   86	120	1121	java/lang/Exception
    //   476	510	1121	java/lang/Exception
    //   517	551	1121	java/lang/Exception
    //   558	583	1121	java/lang/Exception
  }
  
  protected final int Ka()
  {
    return 200;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      return -1;
    }
    if (!com.tencent.mm.vfs.e.bK(this.imgPath))
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.imgPath);
      return -1;
    }
    if (this.ebK == 0) {
      this.ebK = ((int)com.tencent.mm.vfs.e.aeQ(this.imgPath));
    }
    int i = Math.min(this.ebK - this.ebL, 8192);
    paramf = com.tencent.mm.vfs.e.c(this.imgPath, this.ebL, i);
    if (paramf == null)
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      return -1;
    }
    y.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.ebK) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cax();
    ((b.a)localObject).ecI = new cay();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    ((b.a)localObject).ecG = 157;
    ((b.a)localObject).ecJ = 46;
    ((b.a)localObject).ecK = 1000000046;
    localObject = ((b.a)localObject).Kt();
    cax localcax = (cax)((b)localObject).ecE.ecN;
    localcax.ndf = this.ebK;
    localcax.ndg = this.ebL;
    localcax.tdY = this.ebM;
    localcax.ndi = new bmk().bs(paramf);
    localcax.tPZ = this.ecd;
    return a(parame, (com.tencent.mm.network.q)localObject, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramInt1 = 0;
    paramArrayOfByte = (cay)((b)paramq).ecF.ecN;
    y.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + paramInt2);
      return;
    }
    int i = paramq.HF().spN;
    if (i == -4)
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(i) });
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.ebL = paramArrayOfByte.ndg;
    if (this.ebL < this.ebK)
    {
      if (a(this.edc, this.dmL) < 0)
      {
        y.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.dmL.onSceneEnd(3, -1, "", this);
      }
      y.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      return;
    }
    try
    {
      com.tencent.mm.vfs.e.aA(this.imgPath, this.ecc);
      com.tencent.mm.kernel.g.DP().Dz().o(12297, paramArrayOfByte.tQa);
      o.JQ().e(this.ece, c.YW(this.ecc));
      paramq = com.tencent.mm.model.q.Gj();
      if (!bk.bl(paramq))
      {
        paramArrayOfByte = new h();
        paramArrayOfByte.username = paramq;
        paramArrayOfByte.bK(true);
        paramArrayOfByte.bcw = 32;
        paramArrayOfByte.cCq = 3;
        paramArrayOfByte.bcw = 34;
        o.Kh().a(paramArrayOfByte);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.dmL.onSceneEnd(3, -1, "", this);
    }
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    if ((this.imgPath == null) || (this.imgPath.length() == 0)) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    super.cancel();
  }
  
  public final int getType()
  {
    return 157;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.l
 * JD-Core Version:    0.7.0.1
 */