package com.github.henryye.nativeiv;

import android.util.SparseArray;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class a
  implements IImageDecodeService.a
{
  private volatile boolean aUP;
  private int bkR;
  private b cDK;
  private BitmapType cDL;
  private IImageDecodeService.b cDM;
  private int vF;
  
  public a()
  {
    AppMethodBeat.i(208237);
    this.vF = 2048;
    this.bkR = 2048;
    this.cDK = new b();
    this.aUP = false;
    b localb = this.cDK;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala = new com.github.henryye.nativeiv.comm.a();
    localb.cDN.put(localBitmapType, locala);
    AppMethodBeat.o(208237);
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.bitmap.IBitmap a(java.lang.String paramString, Object paramObject, com.github.henryye.nativeiv.b.b paramb, ImageDecodeConfig paramImageDecodeConfig)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 74	com/github/henryye/nativeiv/api/a
    //   8: dup
    //   9: invokespecial 75	com/github/henryye/nativeiv/api/a:<init>	()V
    //   12: astore 11
    //   14: aload_0
    //   15: getfield 30	com/github/henryye/nativeiv/a:vF	I
    //   18: istore 5
    //   20: aload 11
    //   22: aload_0
    //   23: getfield 32	com/github/henryye/nativeiv/a:bkR	I
    //   26: putfield 76	com/github/henryye/nativeiv/api/a:bkR	I
    //   29: aload 11
    //   31: iload 5
    //   33: putfield 77	com/github/henryye/nativeiv/api/a:vF	I
    //   36: aload 11
    //   38: aload_1
    //   39: putfield 81	com/github/henryye/nativeiv/api/a:mPath	Ljava/lang/String;
    //   42: aload 11
    //   44: aload_3
    //   45: invokeinterface 87 1 0
    //   50: putfield 90	com/github/henryye/nativeiv/api/a:cEi	Ljava/lang/String;
    //   53: aload_3
    //   54: aload_2
    //   55: aload 4
    //   57: invokeinterface 93 3 0
    //   62: astore 9
    //   64: aload 9
    //   66: getfield 99	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   69: ifnull +14 -> 83
    //   72: aload 9
    //   74: getfield 102	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   77: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +35 -> 115
    //   83: aload 11
    //   85: aload 9
    //   87: getfield 102	com/github/henryye/nativeiv/b/b$a:errorMsg	Ljava/lang/String;
    //   90: putfield 111	com/github/henryye/nativeiv/api/a:cEj	Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   97: aload_1
    //   98: getstatic 119	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEl	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   101: aload 11
    //   103: invokeinterface 124 4 0
    //   108: ldc 72
    //   110: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload 9
    //   117: getfield 99	com/github/henryye/nativeiv/b/b$a:inputStream	Ljava/io/InputStream;
    //   120: astore 12
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 37	com/github/henryye/nativeiv/a:cDK	Lcom/github/henryye/nativeiv/b;
    //   127: aload 11
    //   129: invokevirtual 127	com/github/henryye/nativeiv/a:a	(Lcom/github/henryye/nativeiv/b;Lcom/github/henryye/nativeiv/api/a;)Lcom/github/henryye/nativeiv/c;
    //   132: astore 13
    //   134: aload 13
    //   136: aload_0
    //   137: getfield 129	com/github/henryye/nativeiv/a:cDL	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   140: putfield 132	com/github/henryye/nativeiv/c:cDL	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   143: aload 13
    //   145: aload_0
    //   146: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   149: putfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   152: aload 13
    //   154: aload 12
    //   156: invokevirtual 139	com/github/henryye/nativeiv/c:p	(Ljava/io/InputStream;)Lcom/github/henryye/nativeiv/bitmap/d;
    //   159: astore 14
    //   161: aload 14
    //   163: ifnonnull +25 -> 188
    //   166: aload_0
    //   167: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   170: aload_1
    //   171: getstatic 142	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEm	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   174: aload 11
    //   176: invokeinterface 124 4 0
    //   181: ldc 72
    //   183: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aconst_null
    //   187: areturn
    //   188: aload 14
    //   190: getfield 148	com/github/henryye/nativeiv/bitmap/d:cEI	Lcom/github/henryye/nativeiv/bitmap/c;
    //   193: getstatic 153	com/github/henryye/nativeiv/bitmap/c:cEG	Lcom/github/henryye/nativeiv/bitmap/c;
    //   196: if_acmpne +25 -> 221
    //   199: aload_0
    //   200: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   203: aload_1
    //   204: getstatic 156	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEo	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   207: aload 11
    //   209: invokeinterface 124 4 0
    //   214: ldc 72
    //   216: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aconst_null
    //   220: areturn
    //   221: aload 14
    //   223: getfield 148	com/github/henryye/nativeiv/bitmap/d:cEI	Lcom/github/henryye/nativeiv/bitmap/c;
    //   226: astore 15
    //   228: aload 12
    //   230: ifnull +139 -> 369
    //   233: aload 13
    //   235: getfield 132	com/github/henryye/nativeiv/c:cDL	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   238: ifnull +231 -> 469
    //   241: aload 13
    //   243: getfield 159	com/github/henryye/nativeiv/c:cDU	Lcom/github/henryye/nativeiv/b;
    //   246: astore 9
    //   248: aload 13
    //   250: invokevirtual 163	java/lang/Object:hashCode	()I
    //   253: istore 5
    //   255: aload 13
    //   257: getfield 132	com/github/henryye/nativeiv/c:cDL	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   260: astore 10
    //   262: aload 9
    //   264: getfield 167	com/github/henryye/nativeiv/b:cDO	Landroid/util/SparseArray;
    //   267: iload 5
    //   269: invokevirtual 173	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   272: checkcast 53	java/util/Map
    //   275: astore 16
    //   277: aload 16
    //   279: ifnull +150 -> 429
    //   282: aload 16
    //   284: aload 10
    //   286: invokeinterface 176 2 0
    //   291: ifnull +138 -> 429
    //   294: aload 16
    //   296: aload 10
    //   298: invokeinterface 176 2 0
    //   303: checkcast 178	com/github/henryye/nativeiv/bitmap/b
    //   306: invokeinterface 182 1 0
    //   311: astore 9
    //   313: aload 13
    //   315: aload 9
    //   317: putfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   320: iconst_0
    //   321: istore 6
    //   323: aload 13
    //   325: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   328: aload 12
    //   330: aload 4
    //   332: aload 15
    //   334: invokeinterface 192 4 0
    //   339: aload 13
    //   341: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   344: invokeinterface 196 1 0
    //   349: astore 9
    //   351: aload 9
    //   353: ifnull +244 -> 597
    //   356: iconst_1
    //   357: istore 5
    //   359: iload 6
    //   361: ifeq +398 -> 759
    //   364: aload 12
    //   366: invokestatic 202	com/github/henryye/nativeiv/c/b:b	(Ljava/io/Closeable;)V
    //   369: aload 14
    //   371: getfield 206	com/github/henryye/nativeiv/bitmap/d:width	J
    //   374: aload_0
    //   375: getfield 30	com/github/henryye/nativeiv/a:vF	I
    //   378: i2l
    //   379: lcmp
    //   380: ifgt +17 -> 397
    //   383: aload 14
    //   385: getfield 209	com/github/henryye/nativeiv/bitmap/d:height	J
    //   388: aload_0
    //   389: getfield 32	com/github/henryye/nativeiv/a:bkR	I
    //   392: i2l
    //   393: lcmp
    //   394: ifle +706 -> 1100
    //   397: aload_0
    //   398: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   401: aload_1
    //   402: getstatic 212	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEp	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   405: aload 11
    //   407: invokeinterface 124 4 0
    //   412: aload 13
    //   414: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   417: invokeinterface 215 1 0
    //   422: ldc 72
    //   424: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aconst_null
    //   428: areturn
    //   429: aload 9
    //   431: getfield 51	com/github/henryye/nativeiv/b:cDN	Ljava/util/Map;
    //   434: aload 10
    //   436: invokeinterface 176 2 0
    //   441: ifnull +685 -> 1126
    //   444: aload 9
    //   446: getfield 51	com/github/henryye/nativeiv/b:cDN	Ljava/util/Map;
    //   449: aload 10
    //   451: invokeinterface 176 2 0
    //   456: checkcast 178	com/github/henryye/nativeiv/bitmap/b
    //   459: invokeinterface 182 1 0
    //   464: astore 9
    //   466: goto -153 -> 313
    //   469: aload 13
    //   471: getfield 159	com/github/henryye/nativeiv/c:cDU	Lcom/github/henryye/nativeiv/b;
    //   474: astore 16
    //   476: aload 13
    //   478: invokevirtual 163	java/lang/Object:hashCode	()I
    //   481: istore 5
    //   483: aload 16
    //   485: getfield 167	com/github/henryye/nativeiv/b:cDO	Landroid/util/SparseArray;
    //   488: iload 5
    //   490: invokevirtual 173	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   493: checkcast 53	java/util/Map
    //   496: astore 9
    //   498: aload 9
    //   500: ifnull +620 -> 1120
    //   503: aload 15
    //   505: aload 9
    //   507: invokestatic 218	com/github/henryye/nativeiv/b:a	(Lcom/github/henryye/nativeiv/bitmap/c;Ljava/util/Map;)Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   510: astore 9
    //   512: aload 9
    //   514: astore 10
    //   516: aload 9
    //   518: ifnonnull +15 -> 533
    //   521: aload 15
    //   523: aload 16
    //   525: getfield 51	com/github/henryye/nativeiv/b:cDN	Ljava/util/Map;
    //   528: invokestatic 218	com/github/henryye/nativeiv/b:a	(Lcom/github/henryye/nativeiv/bitmap/c;Ljava/util/Map;)Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   531: astore 10
    //   533: aload 13
    //   535: aload 10
    //   537: putfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   540: goto -220 -> 320
    //   543: astore 4
    //   545: aload_0
    //   546: getfield 113	com/github/henryye/nativeiv/a:cDM	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   549: aload_1
    //   550: getstatic 221	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEv	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   553: aload 11
    //   555: invokeinterface 124 4 0
    //   560: ldc 223
    //   562: ldc 225
    //   564: iconst_3
    //   565: anewarray 4	java/lang/Object
    //   568: dup
    //   569: iconst_0
    //   570: aload_3
    //   571: aastore
    //   572: dup
    //   573: iconst_1
    //   574: aload_2
    //   575: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
    //   578: aastore
    //   579: dup
    //   580: iconst_2
    //   581: aload 4
    //   583: invokevirtual 229	java/lang/Exception:toString	()Ljava/lang/String;
    //   586: aastore
    //   587: invokestatic 235	com/github/henryye/nativeiv/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: ldc 72
    //   592: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aconst_null
    //   596: areturn
    //   597: iconst_0
    //   598: istore 5
    //   600: goto -241 -> 359
    //   603: astore 9
    //   605: ldc 237
    //   607: aload 9
    //   609: ldc 239
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: aload 13
    //   620: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   623: aload_1
    //   624: getstatic 246	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEq	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   627: aload 13
    //   629: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   632: invokeinterface 124 4 0
    //   637: aload 13
    //   639: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   642: invokeinterface 215 1 0
    //   647: iconst_1
    //   648: istore 6
    //   650: iconst_0
    //   651: istore 5
    //   653: goto -294 -> 359
    //   656: astore 9
    //   658: ldc 237
    //   660: aload 9
    //   662: ldc 239
    //   664: iconst_0
    //   665: anewarray 4	java/lang/Object
    //   668: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   671: aload 13
    //   673: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   676: aload_1
    //   677: getstatic 253	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEr	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   680: aload 13
    //   682: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   685: invokeinterface 124 4 0
    //   690: aload 13
    //   692: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   695: invokeinterface 215 1 0
    //   700: iconst_1
    //   701: istore 6
    //   703: iconst_0
    //   704: istore 5
    //   706: goto -347 -> 359
    //   709: astore 9
    //   711: ldc 237
    //   713: aload 9
    //   715: ldc 255
    //   717: iconst_0
    //   718: anewarray 4	java/lang/Object
    //   721: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   724: aload 13
    //   726: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   729: aload_1
    //   730: getstatic 258	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEu	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   733: aload 13
    //   735: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   738: invokeinterface 124 4 0
    //   743: aload 13
    //   745: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   748: invokeinterface 215 1 0
    //   753: iconst_0
    //   754: istore 5
    //   756: goto -397 -> 359
    //   759: aload 12
    //   761: invokevirtual 263	java/io/InputStream:available	()I
    //   764: istore 6
    //   766: iload 6
    //   768: i2l
    //   769: lstore 7
    //   771: iload 5
    //   773: ifne +76 -> 849
    //   776: aload 13
    //   778: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   781: invokeinterface 267 1 0
    //   786: getstatic 44	com/github/henryye/nativeiv/bitmap/BitmapType:Native	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   789: if_acmpne +60 -> 849
    //   792: ldc 237
    //   794: ldc_w 269
    //   797: iconst_0
    //   798: anewarray 4	java/lang/Object
    //   801: invokestatic 271	com/github/henryye/nativeiv/a/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   804: aload 13
    //   806: aload 13
    //   808: getfield 159	com/github/henryye/nativeiv/c:cDU	Lcom/github/henryye/nativeiv/b;
    //   811: getfield 51	com/github/henryye/nativeiv/b:cDN	Ljava/util/Map;
    //   814: getstatic 274	com/github/henryye/nativeiv/bitmap/BitmapType:Legacy	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   817: invokeinterface 176 2 0
    //   822: checkcast 178	com/github/henryye/nativeiv/bitmap/b
    //   825: invokeinterface 182 1 0
    //   830: putfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   833: aload 13
    //   835: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   838: aload 12
    //   840: aload 4
    //   842: aload 15
    //   844: invokeinterface 192 4 0
    //   849: aload 13
    //   851: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   854: lload 7
    //   856: putfield 277	com/github/henryye/nativeiv/api/a:cEg	J
    //   859: aload 13
    //   861: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   864: aload 13
    //   866: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   869: invokeinterface 281 1 0
    //   874: putfield 284	com/github/henryye/nativeiv/api/a:cEh	J
    //   877: aload 13
    //   879: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   882: aload_1
    //   883: getstatic 287	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEk	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   886: aload 13
    //   888: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   891: invokeinterface 124 4 0
    //   896: aload 13
    //   898: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   901: invokeinterface 267 1 0
    //   906: getstatic 274	com/github/henryye/nativeiv/bitmap/BitmapType:Legacy	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   909: if_acmpne +22 -> 931
    //   912: aload 13
    //   914: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   917: aload_1
    //   918: getstatic 290	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEs	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   921: aload 13
    //   923: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   926: invokeinterface 124 4 0
    //   931: aload 13
    //   933: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   936: invokeinterface 196 1 0
    //   941: ifnonnull +19 -> 960
    //   944: aload 13
    //   946: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   949: invokeinterface 215 1 0
    //   954: aload 13
    //   956: aconst_null
    //   957: putfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   960: aload 12
    //   962: invokestatic 202	com/github/henryye/nativeiv/c/b:b	(Ljava/io/Closeable;)V
    //   965: goto -596 -> 369
    //   968: ldc 237
    //   970: aload 9
    //   972: ldc_w 292
    //   975: iconst_0
    //   976: anewarray 4	java/lang/Object
    //   979: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   982: lconst_0
    //   983: lstore 7
    //   985: goto -214 -> 771
    //   988: astore 4
    //   990: ldc 237
    //   992: aload 4
    //   994: ldc_w 294
    //   997: iconst_0
    //   998: anewarray 4	java/lang/Object
    //   1001: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1004: aload 13
    //   1006: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   1009: aload_1
    //   1010: getstatic 246	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEq	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   1013: aload 13
    //   1015: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   1018: invokeinterface 124 4 0
    //   1023: goto -174 -> 849
    //   1026: astore 4
    //   1028: ldc 237
    //   1030: aload 4
    //   1032: ldc 239
    //   1034: iconst_0
    //   1035: anewarray 4	java/lang/Object
    //   1038: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1041: aload 13
    //   1043: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   1046: aload_1
    //   1047: getstatic 253	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEr	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   1050: aload 13
    //   1052: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   1055: invokeinterface 124 4 0
    //   1060: goto -211 -> 849
    //   1063: astore 4
    //   1065: ldc 237
    //   1067: aload 4
    //   1069: ldc 255
    //   1071: iconst_0
    //   1072: anewarray 4	java/lang/Object
    //   1075: invokestatic 243	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1078: aload 13
    //   1080: getfield 135	com/github/henryye/nativeiv/c:cDS	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b;
    //   1083: aload_1
    //   1084: getstatic 258	com/github/henryye/nativeiv/api/IImageDecodeService$b$a:cEu	Lcom/github/henryye/nativeiv/api/IImageDecodeService$b$a;
    //   1087: aload 13
    //   1089: getfield 250	com/github/henryye/nativeiv/c:cDT	Lcom/github/henryye/nativeiv/api/a;
    //   1092: invokeinterface 124 4 0
    //   1097: goto -248 -> 849
    //   1100: aload 13
    //   1102: getfield 186	com/github/henryye/nativeiv/c:cDR	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   1105: astore 4
    //   1107: ldc 72
    //   1109: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1112: aload 4
    //   1114: areturn
    //   1115: astore 9
    //   1117: goto -149 -> 968
    //   1120: aconst_null
    //   1121: astore 9
    //   1123: goto -611 -> 512
    //   1126: aconst_null
    //   1127: astore 9
    //   1129: goto -816 -> 313
    //   1132: astore 9
    //   1134: goto -166 -> 968
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	a
    //   0	1137	1	paramString	java.lang.String
    //   0	1137	2	paramObject	Object
    //   0	1137	3	paramb	com.github.henryye.nativeiv.b.b
    //   0	1137	4	paramImageDecodeConfig	ImageDecodeConfig
    //   18	754	5	i	int
    //   321	446	6	j	int
    //   769	215	7	l	long
    //   62	455	9	localObject1	Object
    //   603	5	9	localIOException1	java.io.IOException
    //   656	5	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   709	262	9	localThrowable	java.lang.Throwable
    //   1115	1	9	localIllegalStateException	java.lang.IllegalStateException
    //   1121	7	9	localObject2	Object
    //   1132	1	9	localIOException2	java.io.IOException
    //   260	276	10	localObject3	Object
    //   12	542	11	locala	com.github.henryye.nativeiv.api.a
    //   120	841	12	localInputStream	java.io.InputStream
    //   132	969	13	localc	c
    //   159	225	14	locald	com.github.henryye.nativeiv.bitmap.d
    //   226	617	15	localc1	com.github.henryye.nativeiv.bitmap.c
    //   275	249	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   53	83	543	java/lang/Exception
    //   83	108	543	java/lang/Exception
    //   115	161	543	java/lang/Exception
    //   166	181	543	java/lang/Exception
    //   188	214	543	java/lang/Exception
    //   221	228	543	java/lang/Exception
    //   233	277	543	java/lang/Exception
    //   282	313	543	java/lang/Exception
    //   313	320	543	java/lang/Exception
    //   364	369	543	java/lang/Exception
    //   369	397	543	java/lang/Exception
    //   397	422	543	java/lang/Exception
    //   429	466	543	java/lang/Exception
    //   469	498	543	java/lang/Exception
    //   503	512	543	java/lang/Exception
    //   521	533	543	java/lang/Exception
    //   533	540	543	java/lang/Exception
    //   605	647	543	java/lang/Exception
    //   658	700	543	java/lang/Exception
    //   711	753	543	java/lang/Exception
    //   759	766	543	java/lang/Exception
    //   776	833	543	java/lang/Exception
    //   849	931	543	java/lang/Exception
    //   931	960	543	java/lang/Exception
    //   960	965	543	java/lang/Exception
    //   968	982	543	java/lang/Exception
    //   990	1023	543	java/lang/Exception
    //   1028	1060	543	java/lang/Exception
    //   1065	1097	543	java/lang/Exception
    //   1100	1107	543	java/lang/Exception
    //   323	351	603	java/io/IOException
    //   323	351	656	java/lang/OutOfMemoryError
    //   323	351	709	finally
    //   833	849	988	java/io/IOException
    //   833	849	1026	java/lang/OutOfMemoryError
    //   833	849	1063	finally
    //   759	766	1115	java/lang/IllegalStateException
    //   759	766	1132	java/io/IOException
  }
  
  protected c a(b paramb, com.github.henryye.nativeiv.api.a parama)
  {
    AppMethodBeat.i(208246);
    paramb = new c(paramb, parama);
    AppMethodBeat.o(208246);
    return paramb;
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.cDM = paramb;
  }
  
  public final void bX(int paramInt1, int paramInt2)
  {
    this.vF = paramInt1;
    this.bkR = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208239);
    this.aUP = true;
    b localb = this.cDK;
    int i = 0;
    while (i < localb.cDO.size())
    {
      int j = localb.cDO.keyAt(i);
      b.e((Map)localb.cDO.get(j));
      i += 1;
    }
    b.e(localb.cDN);
    AppMethodBeat.o(208239);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.cDL = paramBitmapType;
  }
  
  public final boolean isDestroyed()
  {
    return this.aUP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */