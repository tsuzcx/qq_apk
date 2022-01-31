package com.microrapid.lensFlare;

import com.tencent.filter.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a
  extends c
{
  private float param = 1.0F;
  private int type = 0;
  
  /* Error */
  public final com.tencent.filter.QImage ApplyFilter(com.tencent.filter.QImage paramQImage)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 30	com/microrapid/lensFlare/LensFlareHandle
    //   8: dup
    //   9: invokespecial 31	com/microrapid/lensFlare/LensFlareHandle:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: iconst_2
    //   17: putfield 34	com/microrapid/lensFlare/LensFlareHandle:blR	I
    //   20: aload 4
    //   22: iconst_1
    //   23: putfield 37	com/microrapid/lensFlare/LensFlareHandle:blQ	I
    //   26: aload 4
    //   28: invokevirtual 40	com/microrapid/lensFlare/LensFlareHandle:tb	()V
    //   31: aload 4
    //   33: aload 4
    //   35: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   38: iconst_1
    //   39: invokevirtual 48	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateOpType	(JI)V
    //   42: aload_0
    //   43: getfield 14	com/microrapid/lensFlare/a:type	I
    //   46: tableswitch	default:+1071 -> 1117, 1:+431->477, 2:+1078->1124, 3:+1085->1131, 4:+1092->1138, 5:+1099->1145, 6:+1106->1152, 7:+1113->1159
    //   89: iconst_1
    //   90: invokevirtual 40	com/microrapid/lensFlare/LensFlareHandle:tb	()V
    //   93: aload_3
    //   94: invokestatic 54	com/tencent/view/b:wv	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +32 -> 131
    //   102: aload_3
    //   103: invokestatic 60	com/tencent/filter/QImage:BindBitmap	(Landroid/graphics/Bitmap;)Lcom/tencent/filter/QImage;
    //   106: astore 5
    //   108: aload 4
    //   110: aload 4
    //   112: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   115: aload 5
    //   117: invokevirtual 64	com/microrapid/lensFlare/LensFlareHandle:nativeUpdatePatternImage	(JLcom/tencent/filter/QImage;)V
    //   120: aload 5
    //   122: aload_3
    //   123: invokevirtual 68	com/tencent/filter/QImage:UnBindBitmap	(Landroid/graphics/Bitmap;)Z
    //   126: pop
    //   127: aload_3
    //   128: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   131: aload_0
    //   132: getfield 16	com/microrapid/lensFlare/a:param	F
    //   135: fstore_2
    //   136: aload 4
    //   138: invokevirtual 40	com/microrapid/lensFlare/LensFlareHandle:tb	()V
    //   141: aload 4
    //   143: aload 4
    //   145: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   148: ldc 74
    //   150: ldc 75
    //   152: fload_2
    //   153: fmul
    //   154: fadd
    //   155: invokevirtual 79	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateCrossNumStrength	(JF)V
    //   158: aload_0
    //   159: getfield 16	com/microrapid/lensFlare/a:param	F
    //   162: fstore_2
    //   163: aload 4
    //   165: invokevirtual 40	com/microrapid/lensFlare/LensFlareHandle:tb	()V
    //   168: aload 4
    //   170: aload 4
    //   172: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   175: ldc 74
    //   177: ldc 75
    //   179: fload_2
    //   180: fmul
    //   181: fadd
    //   182: invokevirtual 82	com/microrapid/lensFlare/LensFlareHandle:nativeUpdateCrossSizeStrength	(JF)V
    //   185: aload 4
    //   187: invokevirtual 40	com/microrapid/lensFlare/LensFlareHandle:tb	()V
    //   190: aload 4
    //   192: aload 4
    //   194: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   197: invokevirtual 86	com/microrapid/lensFlare/LensFlareHandle:nativeGetPatternImage	(J)Lcom/tencent/filter/QImage;
    //   200: ifnull +265 -> 465
    //   203: aload 4
    //   205: getfield 37	com/microrapid/lensFlare/LensFlareHandle:blQ	I
    //   208: ifne +436 -> 644
    //   211: aload 4
    //   213: getfield 90	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   216: ifne +15 -> 231
    //   219: aload 4
    //   221: aload_1
    //   222: invokevirtual 94	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;)V
    //   225: aload 4
    //   227: iconst_1
    //   228: putfield 90	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   231: aload 4
    //   233: aload 4
    //   235: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   238: aload_1
    //   239: invokevirtual 98	com/microrapid/lensFlare/LensFlareHandle:nativeIsLightSourceExisted	(JLcom/tencent/filter/QImage;)Z
    //   242: ifeq +241 -> 483
    //   245: ldc 100
    //   247: invokestatic 104	com/microrapid/lensFlare/LensFlareHandle:bn	(Ljava/lang/String;)V
    //   250: iconst_2
    //   251: newarray float
    //   253: astore_3
    //   254: aload 4
    //   256: aload 4
    //   258: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   261: aload_1
    //   262: aload_3
    //   263: invokevirtual 108	com/microrapid/lensFlare/LensFlareHandle:nativePreProcessLensImgWithLightSource	(JLcom/tencent/filter/QImage;[F)Lcom/tencent/filter/QImage;
    //   266: astore 5
    //   268: aload 4
    //   270: aload 5
    //   272: aload_3
    //   273: iconst_0
    //   274: faload
    //   275: aload_3
    //   276: iconst_1
    //   277: faload
    //   278: invokevirtual 111	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;FF)V
    //   281: aload 4
    //   283: aload 4
    //   285: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   288: aload 5
    //   290: invokevirtual 114	com/microrapid/lensFlare/LensFlareHandle:nativeBlurImage	(JLcom/tencent/filter/QImage;)V
    //   293: aload_1
    //   294: invokevirtual 118	com/tencent/filter/QImage:CreateImageFromQImage	()Lcom/tencent/filter/QImage;
    //   297: astore 6
    //   299: aload 4
    //   301: aload 4
    //   303: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   306: aload 6
    //   308: invokevirtual 121	com/microrapid/lensFlare/LensFlareHandle:nativeLightSourceCrossImgSingle	(JLcom/tencent/filter/QImage;)V
    //   311: aload 5
    //   313: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   316: aload 5
    //   318: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   321: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   324: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   327: astore_3
    //   328: aload 5
    //   330: aload_3
    //   331: invokevirtual 141	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   334: pop
    //   335: aload 5
    //   337: invokevirtual 144	com/tencent/filter/QImage:Dispose	()V
    //   340: aload 6
    //   342: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   345: aload 6
    //   347: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   350: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   353: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   356: astore 5
    //   358: aload 6
    //   360: aload 5
    //   362: invokevirtual 141	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   365: pop
    //   366: aload 6
    //   368: invokevirtual 144	com/tencent/filter/QImage:Dispose	()V
    //   371: new 146	com/tencent/filter/BaseFilter
    //   374: dup
    //   375: getstatic 151	com/tencent/filter/GLSLRender:bwd	I
    //   378: getstatic 154	com/tencent/filter/GLSLRender:bve	I
    //   381: invokespecial 157	com/tencent/filter/BaseFilter:<init>	(II)V
    //   384: astore 6
    //   386: aload 6
    //   388: new 159	com/tencent/filter/m$k
    //   391: dup
    //   392: ldc 161
    //   394: aload_3
    //   395: ldc 162
    //   397: iconst_1
    //   398: invokespecial 165	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   401: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   404: pop
    //   405: aload 6
    //   407: new 159	com/tencent/filter/m$k
    //   410: dup
    //   411: ldc 171
    //   413: aload 5
    //   415: ldc 172
    //   417: iconst_1
    //   418: invokespecial 165	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   421: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   424: pop
    //   425: aload 6
    //   427: iconst_0
    //   428: aload_1
    //   429: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   432: i2f
    //   433: aload_1
    //   434: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   437: i2f
    //   438: invokevirtual 176	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   441: new 178	com/tencent/filter/h
    //   444: dup
    //   445: invokespecial 179	com/tencent/filter/h:<init>	()V
    //   448: astore_3
    //   449: aload 6
    //   451: aload_1
    //   452: aload_3
    //   453: invokevirtual 183	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   456: aload 6
    //   458: invokevirtual 186	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   461: aload_3
    //   462: invokevirtual 189	com/tencent/filter/h:clear	()V
    //   465: aload 4
    //   467: invokevirtual 192	com/microrapid/lensFlare/LensFlareHandle:dispose	()V
    //   470: ldc 22
    //   472: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_1
    //   476: areturn
    //   477: ldc 197
    //   479: astore_3
    //   480: goto -392 -> 88
    //   483: ldc 199
    //   485: invokestatic 104	com/microrapid/lensFlare/LensFlareHandle:bn	(Ljava/lang/String;)V
    //   488: iconst_2
    //   489: newarray float
    //   491: astore 5
    //   493: aload 4
    //   495: aload 4
    //   497: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   500: aload_1
    //   501: aload 5
    //   503: invokevirtual 202	com/microrapid/lensFlare/LensFlareHandle:nativePreProcessLensImgNoLightSource	(JLcom/tencent/filter/QImage;[F)Lcom/tencent/filter/QImage;
    //   506: astore_3
    //   507: aload 4
    //   509: aload_3
    //   510: aload 5
    //   512: iconst_0
    //   513: faload
    //   514: aload 5
    //   516: iconst_1
    //   517: faload
    //   518: invokevirtual 111	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;FF)V
    //   521: aload 4
    //   523: aload 4
    //   525: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   528: aload_3
    //   529: invokevirtual 206	com/microrapid/lensFlare/LensFlareHandle:nativePostProcessForBg	(JLcom/tencent/filter/QImage;)Lcom/tencent/filter/QImage;
    //   532: astore 5
    //   534: aload_3
    //   535: invokevirtual 144	com/tencent/filter/QImage:Dispose	()V
    //   538: aload 5
    //   540: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   543: aload 5
    //   545: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   548: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   551: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   554: astore_3
    //   555: aload 5
    //   557: aload_3
    //   558: invokevirtual 141	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   561: pop
    //   562: aload 5
    //   564: invokevirtual 144	com/tencent/filter/QImage:Dispose	()V
    //   567: new 146	com/tencent/filter/BaseFilter
    //   570: dup
    //   571: getstatic 151	com/tencent/filter/GLSLRender:bwd	I
    //   574: getstatic 209	com/tencent/filter/GLSLRender:bvf	I
    //   577: invokespecial 157	com/tencent/filter/BaseFilter:<init>	(II)V
    //   580: astore 5
    //   582: aload 5
    //   584: new 159	com/tencent/filter/m$k
    //   587: dup
    //   588: ldc 161
    //   590: aload_3
    //   591: ldc 162
    //   593: iconst_1
    //   594: invokespecial 165	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   597: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   600: pop
    //   601: aload 5
    //   603: iconst_0
    //   604: aload_1
    //   605: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   608: i2f
    //   609: aload_1
    //   610: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   613: i2f
    //   614: invokevirtual 176	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   617: new 178	com/tencent/filter/h
    //   620: dup
    //   621: invokespecial 179	com/tencent/filter/h:<init>	()V
    //   624: astore_3
    //   625: aload 5
    //   627: aload_1
    //   628: aload_3
    //   629: invokevirtual 183	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   632: aload 5
    //   634: invokevirtual 186	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   637: aload_3
    //   638: invokevirtual 189	com/tencent/filter/h:clear	()V
    //   641: goto -176 -> 465
    //   644: aload 4
    //   646: getfield 90	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   649: ifne +25 -> 674
    //   652: aload 4
    //   654: aload_1
    //   655: invokevirtual 94	com/microrapid/lensFlare/LensFlareHandle:a	(Lcom/tencent/filter/QImage;)V
    //   658: aload 4
    //   660: aload 4
    //   662: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   665: invokevirtual 213	com/microrapid/lensFlare/LensFlareHandle:nativeRefineLabelmapEx	(J)V
    //   668: aload 4
    //   670: iconst_1
    //   671: putfield 90	com/microrapid/lensFlare/LensFlareHandle:hasInit	Z
    //   674: aload 4
    //   676: getfield 34	com/microrapid/lensFlare/LensFlareHandle:blR	I
    //   679: iconst_2
    //   680: if_icmpne +26 -> 706
    //   683: aload 4
    //   685: aload 4
    //   687: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   690: aload_1
    //   691: invokevirtual 216	com/microrapid/lensFlare/LensFlareHandle:nativeLightSourceCrossImgTotalCPU	(JLcom/tencent/filter/QImage;)Z
    //   694: pop
    //   695: goto -230 -> 465
    //   698: astore_1
    //   699: ldc 22
    //   701: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: aload_1
    //   705: athrow
    //   706: bipush 55
    //   708: newarray float
    //   710: astore_3
    //   711: bipush 55
    //   713: newarray float
    //   715: astore 5
    //   717: bipush 55
    //   719: newarray float
    //   721: astore 6
    //   723: bipush 55
    //   725: newarray float
    //   727: astore 7
    //   729: bipush 55
    //   731: newarray float
    //   733: astore 8
    //   735: bipush 55
    //   737: newarray float
    //   739: astore 9
    //   741: bipush 55
    //   743: newarray float
    //   745: astore 10
    //   747: bipush 55
    //   749: newarray float
    //   751: astore 11
    //   753: bipush 55
    //   755: newarray float
    //   757: astore 12
    //   759: bipush 55
    //   761: newarray float
    //   763: astore 13
    //   765: bipush 55
    //   767: newarray float
    //   769: astore 14
    //   771: aload 4
    //   773: aload 4
    //   775: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   778: aload_1
    //   779: aload_3
    //   780: aload 5
    //   782: aload 6
    //   784: aload 7
    //   786: aload 8
    //   788: aload 9
    //   790: aload 10
    //   792: aload 11
    //   794: aload 12
    //   796: aload 13
    //   798: aload 14
    //   800: invokevirtual 220	com/microrapid/lensFlare/LensFlareHandle:nativeAttachLightSourceCrossGPUOne	(JLcom/tencent/filter/QImage;[F[F[F[F[F[F[F[F[F[F[F)I
    //   803: pop
    //   804: aload 4
    //   806: aload 4
    //   808: getfield 44	com/microrapid/lensFlare/LensFlareHandle:blO	J
    //   811: invokevirtual 86	com/microrapid/lensFlare/LensFlareHandle:nativeGetPatternImage	(J)Lcom/tencent/filter/QImage;
    //   814: astore 16
    //   816: aload 16
    //   818: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   821: aload 16
    //   823: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   826: getstatic 134	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   829: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   832: astore 15
    //   834: aload 16
    //   836: aload 15
    //   838: invokevirtual 141	com/tencent/filter/QImage:ToBitmap	(Landroid/graphics/Bitmap;)Z
    //   841: pop
    //   842: aload 4
    //   844: aload 15
    //   846: invokevirtual 224	com/microrapid/lensFlare/LensFlareHandle:nativeGrayProcess	(Landroid/graphics/Bitmap;)V
    //   849: new 146	com/tencent/filter/BaseFilter
    //   852: dup
    //   853: getstatic 227	com/tencent/filter/GLSLRender:bvg	I
    //   856: invokespecial 229	com/tencent/filter/BaseFilter:<init>	(I)V
    //   859: astore 16
    //   861: aload 16
    //   863: new 159	com/tencent/filter/m$k
    //   866: dup
    //   867: ldc 161
    //   869: aload 15
    //   871: ldc 162
    //   873: iconst_1
    //   874: invokespecial 165	com/tencent/filter/m$k:<init>	(Ljava/lang/String;Landroid/graphics/Bitmap;IZ)V
    //   877: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   880: pop
    //   881: aload 16
    //   883: new 231	com/tencent/filter/m$a
    //   886: dup
    //   887: ldc 233
    //   889: aload_3
    //   890: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   893: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   896: pop
    //   897: aload 16
    //   899: new 231	com/tencent/filter/m$a
    //   902: dup
    //   903: ldc 238
    //   905: aload 5
    //   907: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   910: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   913: pop
    //   914: aload 16
    //   916: new 231	com/tencent/filter/m$a
    //   919: dup
    //   920: ldc 240
    //   922: aload 6
    //   924: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   927: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   930: pop
    //   931: aload 16
    //   933: new 231	com/tencent/filter/m$a
    //   936: dup
    //   937: ldc 242
    //   939: aload 7
    //   941: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   944: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   947: pop
    //   948: aload 16
    //   950: new 231	com/tencent/filter/m$a
    //   953: dup
    //   954: ldc 244
    //   956: aload 8
    //   958: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   961: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   964: pop
    //   965: aload 16
    //   967: new 231	com/tencent/filter/m$a
    //   970: dup
    //   971: ldc 246
    //   973: aload 9
    //   975: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   978: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   981: pop
    //   982: aload 16
    //   984: new 231	com/tencent/filter/m$a
    //   987: dup
    //   988: ldc 248
    //   990: aload 10
    //   992: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   995: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   998: pop
    //   999: aload 16
    //   1001: new 231	com/tencent/filter/m$a
    //   1004: dup
    //   1005: ldc 250
    //   1007: aload 11
    //   1009: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1012: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1015: pop
    //   1016: aload 16
    //   1018: new 231	com/tencent/filter/m$a
    //   1021: dup
    //   1022: ldc 252
    //   1024: aload 12
    //   1026: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1029: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1032: pop
    //   1033: aload 16
    //   1035: new 231	com/tencent/filter/m$a
    //   1038: dup
    //   1039: ldc 254
    //   1041: aload 13
    //   1043: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1046: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1049: pop
    //   1050: aload 16
    //   1052: new 231	com/tencent/filter/m$a
    //   1055: dup
    //   1056: ldc_w 256
    //   1059: aload 14
    //   1061: invokespecial 236	com/tencent/filter/m$a:<init>	(Ljava/lang/String;[F)V
    //   1064: invokevirtual 169	com/tencent/filter/BaseFilter:addParam	(Lcom/tencent/filter/m;)Lcom/tencent/filter/BaseFilter;
    //   1067: pop
    //   1068: aload 16
    //   1070: iconst_0
    //   1071: aload_1
    //   1072: invokevirtual 125	com/tencent/filter/QImage:getWidth	()I
    //   1075: i2f
    //   1076: aload_1
    //   1077: invokevirtual 128	com/tencent/filter/QImage:getHeight	()I
    //   1080: i2f
    //   1081: invokevirtual 176	com/tencent/filter/BaseFilter:ApplyGLSLFilter	(ZFF)V
    //   1084: ldc_w 258
    //   1087: invokestatic 104	com/microrapid/lensFlare/LensFlareHandle:bn	(Ljava/lang/String;)V
    //   1090: new 178	com/tencent/filter/h
    //   1093: dup
    //   1094: invokespecial 179	com/tencent/filter/h:<init>	()V
    //   1097: astore_3
    //   1098: aload 16
    //   1100: aload_1
    //   1101: aload_3
    //   1102: invokevirtual 183	com/tencent/filter/BaseFilter:RendProcessImage	(Lcom/tencent/filter/QImage;Lcom/tencent/filter/h;)V
    //   1105: aload 16
    //   1107: invokevirtual 186	com/tencent/filter/BaseFilter:ClearGLSL	()V
    //   1110: aload_3
    //   1111: invokevirtual 189	com/tencent/filter/h:clear	()V
    //   1114: goto -649 -> 465
    //   1117: ldc_w 260
    //   1120: astore_3
    //   1121: goto -1033 -> 88
    //   1124: ldc_w 262
    //   1127: astore_3
    //   1128: goto -1040 -> 88
    //   1131: ldc_w 264
    //   1134: astore_3
    //   1135: goto -1047 -> 88
    //   1138: ldc_w 266
    //   1141: astore_3
    //   1142: goto -1054 -> 88
    //   1145: ldc_w 268
    //   1148: astore_3
    //   1149: goto -1061 -> 88
    //   1152: ldc_w 270
    //   1155: astore_3
    //   1156: goto -1068 -> 88
    //   1159: ldc_w 272
    //   1162: astore_3
    //   1163: goto -1075 -> 88
    //   1166: astore_3
    //   1167: goto -697 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1170	0	this	a
    //   0	1170	1	paramQImage	com.tencent.filter.QImage
    //   135	45	2	f	float
    //   93	1070	3	localObject1	Object
    //   1166	1	3	localThrowable	java.lang.Throwable
    //   12	831	4	localLensFlareHandle	LensFlareHandle
    //   106	800	5	localObject2	Object
    //   297	626	6	localObject3	Object
    //   727	213	7	arrayOfFloat1	float[]
    //   733	224	8	arrayOfFloat2	float[]
    //   739	235	9	arrayOfFloat3	float[]
    //   745	246	10	arrayOfFloat4	float[]
    //   751	257	11	arrayOfFloat5	float[]
    //   757	268	12	arrayOfFloat6	float[]
    //   763	279	13	arrayOfFloat7	float[]
    //   769	291	14	arrayOfFloat8	float[]
    //   832	38	15	localBitmap	android.graphics.Bitmap
    //   814	292	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   5	88	698	finally
    //   88	98	698	finally
    //   102	131	698	finally
    //   131	231	698	finally
    //   231	465	698	finally
    //   465	470	698	finally
    //   483	641	698	finally
    //   644	674	698	finally
    //   674	695	698	finally
    //   706	1114	698	finally
    //   5	88	1166	java/lang/Throwable
    //   88	98	1166	java/lang/Throwable
    //   102	131	1166	java/lang/Throwable
    //   131	231	1166	java/lang/Throwable
    //   231	465	1166	java/lang/Throwable
    //   465	470	1166	java/lang/Throwable
    //   483	641	1166	java/lang/Throwable
    //   644	674	1166	java/lang/Throwable
    //   674	695	1166	java/lang/Throwable
    //   706	1114	1166	java/lang/Throwable
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    this.param = paramFloat;
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86248);
    if (paramMap.containsKey("filterAdjustParam")) {
      this.param = ((Float)paramMap.get("filterAdjustParam")).floatValue();
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    AppMethodBeat.o(86248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.microrapid.lensFlare.a
 * JD-Core Version:    0.7.0.1
 */