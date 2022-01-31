package com.microrapid.lensFlare;

import com.tencent.filter.c;
import java.util.Map;

public final class a
  extends c
{
  private float aVe = 1.0F;
  private int type = 0;
  
  /* Error */
  public final com.tencent.filter.QImage ApplyFilter(com.tencent.filter.QImage paramQImage)
  {
    // Byte code:
    //   0: new 23	com/microrapid/lensFlare/LensFlareHandle
    //   3: dup
    //   4: invokespecial 24	com/microrapid/lensFlare/LensFlareHandle:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: iconst_2
    //   12: putfield 27	com/microrapid/lensFlare/LensFlareHandle:aVi	I
    //   15: aload 4
    //   17: iconst_1
    //   18: putfield 30	com/microrapid/lensFlare/LensFlareHandle:aVh	I
    //   21: aload 4
    //   23: invokevirtual 33	com/microrapid/lensFlare/LensFlareHandle:oW	()V
    //   26: aload 4
    //   28: aload 4
    //   30: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   33: iconst_1
    //   34: invokevirtual 41	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateOpType	(JI)V
    //   37: aload_0
    //   38: getfield 14	com/microrapid/lensFlare/a:type	I
    //   41: tableswitch	default:+1054 -> 1095, 1:+1060->1101, 2:+1066->1107, 3:+1072->1113, 4:+1078->1119, 5:+1085->1126, 6:+1092->1133, 7:+1099->1140
    //   85: iconst_1
    //   86: invokevirtual 33	com/microrapid/lensFlare/LensFlareHandle:oW	()V
    //   89: aload_3
    //   90: invokestatic 47	com/tencent/view/b:pe	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +32 -> 127
    //   98: aload_3
    //   99: invokestatic 53	com/tencent/filter/QImage:BindBitmap	(Landroid/graphics/Bitmap;)Lcom/tencent/filter/QImage;
    //   102: astore 5
    //   104: aload 4
    //   106: aload 4
    //   108: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   111: aload 5
    //   113: invokevirtual 57	com/microrapid/lensFlare/LensFlareHandle:nativeUpdatePatternImage	(JLcom/tencent/filter/QImage;)V
    //   116: aload 5
    //   118: aload_3
    //   119: invokevirtual 61	com/tencent/filter/QImage:UnBindBitmap	(Landroid/graphics/Bitmap;)Z
    //   122: pop
    //   123: aload_3
    //   124: invokevirtual 66	android/graphics/Bitmap:recycle	()V
    //   127: aload_0
    //   128: getfield 16	com/microrapid/lensFlare/a:aVe	F
    //   131: fstore_2
    //   132: aload 4
    //   134: invokevirtual 33	com/microrapid/lensFlare/LensFlareHandle:oW	()V
    //   137: aload 4
    //   139: aload 4
    //   141: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   144: ldc 67
    //   146: ldc 68
    //   148: fload_2
    //   149: fmul
    //   150: fadd
    //   151: invokevirtual 72	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateCrossNumStrength	(JF)V
    //   154: aload_0
    //   155: getfield 16	com/microrapid/lensFlare/a:aVe	F
    //   158: fstore_2
    //   159: aload 4
    //   161: invokevirtual 33	com/microrapid/lensFlare/LensFlareHandle:oW	()V
    //   164: aload 4
    //   166: aload 4
    //   168: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   171: ldc 67
    //   173: ldc 68
    //   175: fload_2
    //   176: fmul
    //   177: fadd
    //   178: invokevirtual 75	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateCrossSizeStrength	(JF)V
    //   181: aload 4
    //   183: invokevirtual 33	com/microrapid/lensFlare/LensFlareHandle:oW	()V
    //   186: aload 4
    //   188: aload 4
    //   190: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   193: invokevirtual 79	com/microrapid/lensFlare/LensFlareHandle:nativeGetPatternImage	(J)Lcom/tencent/filter/QImage;
    //   196: ifnull +265 -> 461
    //   199: aload 4
    //   201: getfield 30	com/microrapid/lensFlare/LensFlareHandle:aVh	I
    //   204: ifne +425 -> 629
    //   207: aload 4
    //   209: getfield 83	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   212: ifne +15 -> 227
    //   215: aload 4
    //   217: aload_1
    //   218: invokevirtual 87	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;)V
    //   221: aload 4
    //   223: iconst_1
    //   224: putfield 83	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   227: aload 4
    //   229: aload 4
    //   231: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   234: aload_1
    //   235: invokevirtual 91	com/microrapid/lensFlare/LensFlareHandle:nativeIsLightSourceExisted	(JLcom/tencent/filter/QImage;)Z
    //   238: ifeq +230 -> 468
    //   241: ldc 93
    //   243: invokestatic 97	com/microrapid/lensFlare/LensFlareHandle:aM	(Ljava/lang/String;)V
    //   246: iconst_2
    //   247: newarray float
    //   249: astore_3
    //   250: aload 4
    //   252: aload 4
    //   254: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   257: aload_1
    //   258: aload_3
    //   259: invokevirtual 101	com/microrapid/lensFlare/LensFlareHandle:nativePreProcessLensImgWithLightSource	(JLcom/tencent/filter/QImage;[F)Lcom/tencent/filter/QImage;
    //   262: astore 5
    //   264: aload 4
    //   266: aload 5
    //   268: aload_3
    //   269: iconst_0
    //   270: faload
    //   271: aload_3
    //   272: iconst_1
    //   273: faload
    //   274: invokevirtual 104	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;FF)V
    //   277: aload 4
    //   279: aload 4
    //   281: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   284: aload 5
    //   286: invokevirtual 107	com/microrapid/lensFlare/LensFlareHandle:nativeBlurImage	(JLcom/tencent/filter/QImage;)V
    //   289: aload_1
    //   290: invokevirtual 111	com/tencent/filter/QImage:CreateImageFromQImage	()Lcom/tencent/filter/QImage;
    //   293: astore 6
    //   295: aload 4
    //   297: aload 4
    //   299: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   302: aload 6
    //   304: invokevirtual 114	com/microrapid/lensFlare/LensFlareHandle:nativeLightSourceCrossImgSingle	(JLcom/tencent/filter/QImage;)V
    //   307: aload 5
    //   309: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   312: aload 5
    //   314: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   317: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   320: invokestatic 131	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   323: astore_3
    //   324: aload 5
    //   326: aload_3
    //   327: invokevirtual 134	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   330: pop
    //   331: aload 5
    //   333: invokevirtual 137	com/tencent/filter/QImage:Dispose	()V
    //   336: aload 6
    //   338: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   341: aload 6
    //   343: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   346: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   349: invokestatic 131	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   352: astore 5
    //   354: aload 6
    //   356: aload 5
    //   358: invokevirtual 134	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   361: pop
    //   362: aload 6
    //   364: invokevirtual 137	com/tencent/filter/QImage:Dispose	()V
    //   367: new 139	com/tencent/filter/BaseFilter
    //   370: dup
    //   371: getstatic 144	com/tencent/filter/GLSLRender:bfA	I
    //   374: getstatic 147	com/tencent/filter/GLSLRender:beB	I
    //   377: invokespecial 150	com/tencent/filter/BaseFilter:<init>	(II)V
    //   380: astore 6
    //   382: aload 6
    //   384: new 152	com/tencent/filter/m$k
    //   387: dup
    //   388: ldc 154
    //   390: aload_3
    //   391: ldc 155
    //   393: iconst_1
    //   394: invokespecial 158	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   397: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   400: pop
    //   401: aload 6
    //   403: new 152	com/tencent/filter/m$k
    //   406: dup
    //   407: ldc 164
    //   409: aload 5
    //   411: ldc 165
    //   413: iconst_1
    //   414: invokespecial 158	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   417: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   420: pop
    //   421: aload 6
    //   423: iconst_0
    //   424: aload_1
    //   425: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   428: i2f
    //   429: aload_1
    //   430: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   433: i2f
    //   434: invokevirtual 169	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   437: new 171	com/tencent/filter/h
    //   440: dup
    //   441: invokespecial 172	com/tencent/filter/h:<init>	()V
    //   444: astore_3
    //   445: aload 6
    //   447: aload_1
    //   448: aload_3
    //   449: invokevirtual 176	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   452: aload 6
    //   454: invokevirtual 179	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   457: aload_3
    //   458: invokevirtual 182	com/tencent/filter/h:clear	()V
    //   461: aload 4
    //   463: invokevirtual 185	com/microrapid/lensFlare/LensFlareHandle:dispose	()V
    //   466: aload_1
    //   467: areturn
    //   468: ldc 187
    //   470: invokestatic 97	com/microrapid/lensFlare/LensFlareHandle:aM	(Ljava/lang/String;)V
    //   473: iconst_2
    //   474: newarray float
    //   476: astore 5
    //   478: aload 4
    //   480: aload 4
    //   482: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   485: aload_1
    //   486: aload 5
    //   488: invokevirtual 190	com/microrapid/lensFlare/LensFlareHandle:nativePreProcessLensImgNoLightSource	(JLcom/tencent/filter/QImage;[F)Lcom/tencent/filter/QImage;
    //   491: astore_3
    //   492: aload 4
    //   494: aload_3
    //   495: aload 5
    //   497: iconst_0
    //   498: faload
    //   499: aload 5
    //   501: iconst_1
    //   502: faload
    //   503: invokevirtual 104	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;FF)V
    //   506: aload 4
    //   508: aload 4
    //   510: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   513: aload_3
    //   514: invokevirtual 194	com/microrapid/lensFlare/LensFlareHandle:nativePostProcessForBg	(JLcom/tencent/filter/QImage;)Lcom/tencent/filter/QImage;
    //   517: astore 5
    //   519: aload_3
    //   520: invokevirtual 137	com/tencent/filter/QImage:Dispose	()V
    //   523: aload 5
    //   525: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   528: aload 5
    //   530: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   533: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   536: invokestatic 131	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   539: astore_3
    //   540: aload 5
    //   542: aload_3
    //   543: invokevirtual 134	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   546: pop
    //   547: aload 5
    //   549: invokevirtual 137	com/tencent/filter/QImage:Dispose	()V
    //   552: new 139	com/tencent/filter/BaseFilter
    //   555: dup
    //   556: getstatic 144	com/tencent/filter/GLSLRender:bfA	I
    //   559: getstatic 197	com/tencent/filter/GLSLRender:beC	I
    //   562: invokespecial 150	com/tencent/filter/BaseFilter:<init>	(II)V
    //   565: astore 5
    //   567: aload 5
    //   569: new 152	com/tencent/filter/m$k
    //   572: dup
    //   573: ldc 154
    //   575: aload_3
    //   576: ldc 155
    //   578: iconst_1
    //   579: invokespecial 158	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   582: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   585: pop
    //   586: aload 5
    //   588: iconst_0
    //   589: aload_1
    //   590: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   593: i2f
    //   594: aload_1
    //   595: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   598: i2f
    //   599: invokevirtual 169	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   602: new 171	com/tencent/filter/h
    //   605: dup
    //   606: invokespecial 172	com/tencent/filter/h:<init>	()V
    //   609: astore_3
    //   610: aload 5
    //   612: aload_1
    //   613: aload_3
    //   614: invokevirtual 176	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   617: aload 5
    //   619: invokevirtual 179	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   622: aload_3
    //   623: invokevirtual 182	com/tencent/filter/h:clear	()V
    //   626: goto -165 -> 461
    //   629: aload 4
    //   631: getfield 83	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   634: ifne +25 -> 659
    //   637: aload 4
    //   639: aload_1
    //   640: invokevirtual 87	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;)V
    //   643: aload 4
    //   645: aload 4
    //   647: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   650: invokevirtual 201	com/microrapid/lensFlare/LensFlareHandle:nativeRefineLabelmapEx	(J)V
    //   653: aload 4
    //   655: iconst_1
    //   656: putfield 83	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   659: aload 4
    //   661: getfield 27	com/microrapid/lensFlare/LensFlareHandle:aVi	I
    //   664: iconst_2
    //   665: if_icmpne +21 -> 686
    //   668: aload 4
    //   670: aload 4
    //   672: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   675: aload_1
    //   676: invokevirtual 204	com/microrapid/lensFlare/LensFlareHandle:nativeLightSourceCrossImgTotalCPU	(JLcom/tencent/filter/QImage;)Z
    //   679: pop
    //   680: goto -219 -> 461
    //   683: astore_1
    //   684: aload_1
    //   685: athrow
    //   686: bipush 55
    //   688: newarray float
    //   690: astore_3
    //   691: bipush 55
    //   693: newarray float
    //   695: astore 5
    //   697: bipush 55
    //   699: newarray float
    //   701: astore 6
    //   703: bipush 55
    //   705: newarray float
    //   707: astore 7
    //   709: bipush 55
    //   711: newarray float
    //   713: astore 8
    //   715: bipush 55
    //   717: newarray float
    //   719: astore 9
    //   721: bipush 55
    //   723: newarray float
    //   725: astore 10
    //   727: bipush 55
    //   729: newarray float
    //   731: astore 11
    //   733: bipush 55
    //   735: newarray float
    //   737: astore 12
    //   739: bipush 55
    //   741: newarray float
    //   743: astore 13
    //   745: bipush 55
    //   747: newarray float
    //   749: astore 14
    //   751: aload 4
    //   753: aload 4
    //   755: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   758: aload_1
    //   759: aload_3
    //   760: aload 5
    //   762: aload 6
    //   764: aload 7
    //   766: aload 8
    //   768: aload 9
    //   770: aload 10
    //   772: aload 11
    //   774: aload 12
    //   776: aload 13
    //   778: aload 14
    //   780: invokevirtual 208	com/microrapid/lensFlare/LensFlareHandle:nativeAttachLightSourceCrossGPUOne	(JLcom/tencent/filter/QImage;[F[F[F[F[F[F[F[F[F[F[F)I
    //   783: pop
    //   784: aload 4
    //   786: aload 4
    //   788: getfield 37	com/microrapid/lensFlare/LensFlareHandle:aVf	J
    //   791: invokevirtual 79	com/microrapid/lensFlare/LensFlareHandle:nativeGetPatternImage	(J)Lcom/tencent/filter/QImage;
    //   794: astore 16
    //   796: aload 16
    //   798: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   801: aload 16
    //   803: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   806: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   809: invokestatic 131	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   812: astore 15
    //   814: aload 16
    //   816: aload 15
    //   818: invokevirtual 134	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   821: pop
    //   822: aload 4
    //   824: aload 15
    //   826: invokevirtual 212	com/microrapid/lensFlare/LensFlareHandle:nativeGrayProcess	(Landroid/graphics/Bitmap;)V
    //   829: new 139	com/tencent/filter/BaseFilter
    //   832: dup
    //   833: getstatic 215	com/tencent/filter/GLSLRender:beD	I
    //   836: invokespecial 218	com/tencent/filter/BaseFilter:<init>	(I)V
    //   839: astore 16
    //   841: aload 16
    //   843: new 152	com/tencent/filter/m$k
    //   846: dup
    //   847: ldc 154
    //   849: aload 15
    //   851: ldc 155
    //   853: iconst_1
    //   854: invokespecial 158	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   857: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   860: pop
    //   861: aload 16
    //   863: new 220	com/tencent/filter/m$a
    //   866: dup
    //   867: ldc 222
    //   869: aload_3
    //   870: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   873: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   876: pop
    //   877: aload 16
    //   879: new 220	com/tencent/filter/m$a
    //   882: dup
    //   883: ldc 227
    //   885: aload 5
    //   887: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   890: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   893: pop
    //   894: aload 16
    //   896: new 220	com/tencent/filter/m$a
    //   899: dup
    //   900: ldc 229
    //   902: aload 6
    //   904: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   907: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   910: pop
    //   911: aload 16
    //   913: new 220	com/tencent/filter/m$a
    //   916: dup
    //   917: ldc 231
    //   919: aload 7
    //   921: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   924: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   927: pop
    //   928: aload 16
    //   930: new 220	com/tencent/filter/m$a
    //   933: dup
    //   934: ldc 233
    //   936: aload 8
    //   938: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   941: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   944: pop
    //   945: aload 16
    //   947: new 220	com/tencent/filter/m$a
    //   950: dup
    //   951: ldc 235
    //   953: aload 9
    //   955: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   958: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   961: pop
    //   962: aload 16
    //   964: new 220	com/tencent/filter/m$a
    //   967: dup
    //   968: ldc 237
    //   970: aload 10
    //   972: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   975: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   978: pop
    //   979: aload 16
    //   981: new 220	com/tencent/filter/m$a
    //   984: dup
    //   985: ldc 239
    //   987: aload 11
    //   989: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   992: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   995: pop
    //   996: aload 16
    //   998: new 220	com/tencent/filter/m$a
    //   1001: dup
    //   1002: ldc 241
    //   1004: aload 12
    //   1006: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1009: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1012: pop
    //   1013: aload 16
    //   1015: new 220	com/tencent/filter/m$a
    //   1018: dup
    //   1019: ldc 243
    //   1021: aload 13
    //   1023: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1026: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1029: pop
    //   1030: aload 16
    //   1032: new 220	com/tencent/filter/m$a
    //   1035: dup
    //   1036: ldc 245
    //   1038: aload 14
    //   1040: invokespecial 225	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1043: invokevirtual 162	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1046: pop
    //   1047: aload 16
    //   1049: iconst_0
    //   1050: aload_1
    //   1051: invokevirtual 118	com/tencent/filter/QImage:getWidth	()I
    //   1054: i2f
    //   1055: aload_1
    //   1056: invokevirtual 121	com/tencent/filter/QImage:getHeight	()I
    //   1059: i2f
    //   1060: invokevirtual 169	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   1063: ldc 247
    //   1065: invokestatic 97	com/microrapid/lensFlare/LensFlareHandle:aM	(Ljava/lang/String;)V
    //   1068: new 171	com/tencent/filter/h
    //   1071: dup
    //   1072: invokespecial 172	com/tencent/filter/h:<init>	()V
    //   1075: astore_3
    //   1076: aload 16
    //   1078: aload_1
    //   1079: aload_3
    //   1080: invokevirtual 176	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   1083: aload 16
    //   1085: invokevirtual 179	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   1088: aload_3
    //   1089: invokevirtual 182	com/tencent/filter/h:clear	()V
    //   1092: goto -631 -> 461
    //   1095: ldc 249
    //   1097: astore_3
    //   1098: goto -1014 -> 84
    //   1101: ldc 251
    //   1103: astore_3
    //   1104: goto -1020 -> 84
    //   1107: ldc 253
    //   1109: astore_3
    //   1110: goto -1026 -> 84
    //   1113: ldc 255
    //   1115: astore_3
    //   1116: goto -1032 -> 84
    //   1119: ldc_w 257
    //   1122: astore_3
    //   1123: goto -1039 -> 84
    //   1126: ldc_w 259
    //   1129: astore_3
    //   1130: goto -1046 -> 84
    //   1133: ldc_w 261
    //   1136: astore_3
    //   1137: goto -1053 -> 84
    //   1140: ldc_w 263
    //   1143: astore_3
    //   1144: goto -1060 -> 84
    //   1147: astore_3
    //   1148: aload_1
    //   1149: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1150	0	this	a
    //   0	1150	1	paramQImage	com.tencent.filter.QImage
    //   131	45	2	f	float
    //   89	1055	3	localObject1	Object
    //   1147	1	3	localThrowable	java.lang.Throwable
    //   7	816	4	localLensFlareHandle	LensFlareHandle
    //   102	784	5	localObject2	Object
    //   293	610	6	localObject3	Object
    //   707	213	7	arrayOfFloat1	float[]
    //   713	224	8	arrayOfFloat2	float[]
    //   719	235	9	arrayOfFloat3	float[]
    //   725	246	10	arrayOfFloat4	float[]
    //   731	257	11	arrayOfFloat5	float[]
    //   737	268	12	arrayOfFloat6	float[]
    //   743	279	13	arrayOfFloat7	float[]
    //   749	290	14	arrayOfFloat8	float[]
    //   812	38	15	localBitmap	android.graphics.Bitmap
    //   794	290	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	84	683	finally
    //   84	94	683	finally
    //   98	127	683	finally
    //   127	227	683	finally
    //   227	461	683	finally
    //   461	466	683	finally
    //   468	626	683	finally
    //   629	659	683	finally
    //   659	680	683	finally
    //   686	1092	683	finally
    //   0	84	1147	java/lang/Throwable
    //   84	94	1147	java/lang/Throwable
    //   98	127	1147	java/lang/Throwable
    //   127	227	1147	java/lang/Throwable
    //   227	461	1147	java/lang/Throwable
    //   461	466	1147	java/lang/Throwable
    //   468	626	1147	java/lang/Throwable
    //   629	659	1147	java/lang/Throwable
    //   659	680	1147	java/lang/Throwable
    //   686	1092	1147	java/lang/Throwable
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    this.aVe = paramFloat;
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("filterAdjustParam")) {
      this.aVe = ((Float)paramMap.get("filterAdjustParam")).floatValue();
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.microrapid.lensFlare.a
 * JD-Core Version:    0.7.0.1
 */