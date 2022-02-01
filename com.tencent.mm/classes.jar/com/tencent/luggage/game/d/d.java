package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d
  extends c<y>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  /* Error */
  public static i.a a(ad paramad, JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 42
    //   8: invokevirtual 48	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11: istore 13
    //   13: aload_0
    //   14: ifnonnull +61 -> 75
    //   17: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   20: dup
    //   21: ldc 52
    //   23: iconst_0
    //   24: anewarray 54	java/lang/Object
    //   27: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: astore_0
    //   31: ldc 34
    //   33: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: areturn
    //   38: astore_0
    //   39: ldc 62
    //   41: ldc 64
    //   43: iconst_1
    //   44: anewarray 54	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: aastore
    //   51: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   57: dup
    //   58: ldc 72
    //   60: iconst_0
    //   61: anewarray 54	java/lang/Object
    //   64: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: astore_0
    //   68: ldc 34
    //   70: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: areturn
    //   75: aload_0
    //   76: ldc 74
    //   78: invokevirtual 80	com/tencent/mm/plugin/appbrand/page/ad:aa	(Ljava/lang/Class;)Ljava/lang/Object;
    //   81: checkcast 74	com/tencent/luggage/game/page/d
    //   84: astore 21
    //   86: aload_1
    //   87: ldc 82
    //   89: iconst_0
    //   90: invokevirtual 86	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   93: istore 18
    //   95: aload 21
    //   97: ifnull +1506 -> 1603
    //   100: aload 21
    //   102: invokeinterface 90 1 0
    //   107: ifnull +1496 -> 1603
    //   110: iload 18
    //   112: ifne +78 -> 190
    //   115: aload 21
    //   117: iload 13
    //   119: iload_2
    //   120: invokeinterface 94 3 0
    //   125: astore 21
    //   127: aload 21
    //   129: ifnonnull +94 -> 223
    //   132: ldc 62
    //   134: ldc 96
    //   136: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 101
    //   141: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   144: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   147: astore_0
    //   148: iload 18
    //   150: ifeq +1459 -> 1609
    //   153: ldc2_w 108
    //   156: lstore 19
    //   158: aload_0
    //   159: ldc2_w 110
    //   162: lload 19
    //   164: invokeinterface 115 5 0
    //   169: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   172: dup
    //   173: ldc 117
    //   175: iconst_0
    //   176: anewarray 54	java/lang/Object
    //   179: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: astore_0
    //   183: ldc 34
    //   185: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_0
    //   189: areturn
    //   190: aload 21
    //   192: invokeinterface 90 1 0
    //   197: invokevirtual 123	com/tencent/magicbrush/ui/MagicBrushView:getMagicBrush	()Lcom/tencent/magicbrush/e;
    //   200: getfield 129	com/tencent/magicbrush/e:eHE	Lcom/tencent/magicbrush/b;
    //   203: aload 21
    //   205: invokeinterface 90 1 0
    //   210: invokevirtual 133	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   213: iconst_m1
    //   214: iconst_1
    //   215: invokevirtual 139	com/tencent/magicbrush/b:j	(IIZ)Landroid/graphics/Bitmap;
    //   218: astore 21
    //   220: goto -93 -> 127
    //   223: aload 21
    //   225: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   228: i2f
    //   229: fstore 10
    //   231: aload 21
    //   233: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   236: i2f
    //   237: fstore 11
    //   239: aload 21
    //   241: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   244: i2f
    //   245: fstore 12
    //   247: aload 21
    //   249: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   252: i2f
    //   253: fstore 6
    //   255: ldc 62
    //   257: ldc 149
    //   259: iconst_4
    //   260: anewarray 54	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: fload 10
    //   267: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: fload 11
    //   275: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   278: aastore
    //   279: dup
    //   280: iconst_2
    //   281: fload 12
    //   283: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: fload 6
    //   291: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   294: aastore
    //   295: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: aload_1
    //   299: ldc 159
    //   301: dconst_0
    //   302: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   305: d2f
    //   306: fstore 7
    //   308: aload_1
    //   309: ldc 165
    //   311: dconst_0
    //   312: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   315: d2f
    //   316: fstore 5
    //   318: aload_1
    //   319: ldc 167
    //   321: fload 12
    //   323: f2d
    //   324: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   327: d2f
    //   328: fstore 8
    //   330: aload_1
    //   331: ldc 169
    //   333: fload 6
    //   335: f2d
    //   336: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   339: d2f
    //   340: fstore 9
    //   342: ldc 62
    //   344: ldc 171
    //   346: iconst_4
    //   347: anewarray 54	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: fload 7
    //   354: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: fload 5
    //   362: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   365: aastore
    //   366: dup
    //   367: iconst_2
    //   368: fload 8
    //   370: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   373: aastore
    //   374: dup
    //   375: iconst_3
    //   376: fload 9
    //   378: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   381: aastore
    //   382: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: fload 12
    //   387: fconst_0
    //   388: fcmpl
    //   389: ifle +1196 -> 1585
    //   392: fload 6
    //   394: fconst_0
    //   395: fcmpl
    //   396: ifle +1189 -> 1585
    //   399: fload 10
    //   401: fload 12
    //   403: fcmpl
    //   404: ifne +11 -> 415
    //   407: fload 11
    //   409: fload 6
    //   411: fcmpl
    //   412: ifeq +1173 -> 1585
    //   415: fload 7
    //   417: fstore_3
    //   418: fload 7
    //   420: fconst_0
    //   421: fcmpl
    //   422: ifle +12 -> 434
    //   425: fload 7
    //   427: fload 12
    //   429: fdiv
    //   430: fload 10
    //   432: fmul
    //   433: fstore_3
    //   434: fload 5
    //   436: fstore 4
    //   438: fload 5
    //   440: fconst_0
    //   441: fcmpl
    //   442: ifle +13 -> 455
    //   445: fload 5
    //   447: fload 6
    //   449: fdiv
    //   450: fload 11
    //   452: fmul
    //   453: fstore 4
    //   455: fload 8
    //   457: fload 12
    //   459: fdiv
    //   460: fload 10
    //   462: fmul
    //   463: fstore 5
    //   465: fload 9
    //   467: fload 6
    //   469: fdiv
    //   470: fload 11
    //   472: fmul
    //   473: fstore 7
    //   475: fload 4
    //   477: fstore 6
    //   479: fload 7
    //   481: fstore 4
    //   483: goto +1134 -> 1617
    //   486: aload_1
    //   487: ldc 173
    //   489: fload 5
    //   491: f2d
    //   492: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   495: d2f
    //   496: fstore 7
    //   498: aload_1
    //   499: ldc 175
    //   501: fload 4
    //   503: f2d
    //   504: invokevirtual 163	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   507: d2f
    //   508: fstore 8
    //   510: ldc 62
    //   512: ldc 177
    //   514: bipush 8
    //   516: anewarray 54	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: fload_3
    //   522: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   525: aastore
    //   526: dup
    //   527: iconst_1
    //   528: fload 6
    //   530: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   533: aastore
    //   534: dup
    //   535: iconst_2
    //   536: fload 10
    //   538: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   541: aastore
    //   542: dup
    //   543: iconst_3
    //   544: fload 11
    //   546: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   549: aastore
    //   550: dup
    //   551: iconst_4
    //   552: fload 5
    //   554: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   557: aastore
    //   558: dup
    //   559: iconst_5
    //   560: fload 4
    //   562: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   565: aastore
    //   566: dup
    //   567: bipush 6
    //   569: fload 7
    //   571: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   574: aastore
    //   575: dup
    //   576: bipush 7
    //   578: fload 8
    //   580: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   583: aastore
    //   584: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   587: fload_3
    //   588: f2i
    //   589: iflt +56 -> 645
    //   592: fload 6
    //   594: f2i
    //   595: iflt +50 -> 645
    //   598: fload 5
    //   600: f2i
    //   601: ifle +44 -> 645
    //   604: fload 4
    //   606: f2i
    //   607: ifle +38 -> 645
    //   610: fload_3
    //   611: fload 5
    //   613: fadd
    //   614: f2i
    //   615: fload 10
    //   617: f2i
    //   618: if_icmpgt +27 -> 645
    //   621: fload 6
    //   623: fload 4
    //   625: fadd
    //   626: f2i
    //   627: fload 11
    //   629: f2i
    //   630: if_icmpgt +15 -> 645
    //   633: fload 7
    //   635: f2i
    //   636: ifle +9 -> 645
    //   639: fload 8
    //   641: f2i
    //   642: ifgt +74 -> 716
    //   645: ldc 62
    //   647: ldc 179
    //   649: iconst_5
    //   650: anewarray 54	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: fload_3
    //   656: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   659: aastore
    //   660: dup
    //   661: iconst_1
    //   662: fload 6
    //   664: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   667: aastore
    //   668: dup
    //   669: iconst_2
    //   670: fload 5
    //   672: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   675: aastore
    //   676: dup
    //   677: iconst_3
    //   678: fload 4
    //   680: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   683: aastore
    //   684: dup
    //   685: iconst_4
    //   686: iload 13
    //   688: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   691: aastore
    //   692: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   698: dup
    //   699: ldc 189
    //   701: iconst_0
    //   702: anewarray 54	java/lang/Object
    //   705: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: astore_0
    //   709: ldc 34
    //   711: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   714: aload_0
    //   715: areturn
    //   716: fload 5
    //   718: fload 10
    //   720: fcmpl
    //   721: ifne +11 -> 732
    //   724: fload 4
    //   726: fload 11
    //   728: fcmpl
    //   729: ifeq +847 -> 1576
    //   732: fload_3
    //   733: f2i
    //   734: istore 14
    //   736: fload 6
    //   738: f2i
    //   739: istore 15
    //   741: fload 5
    //   743: f2i
    //   744: istore 16
    //   746: fload 4
    //   748: f2i
    //   749: istore 17
    //   751: aload 21
    //   753: iload 14
    //   755: iload 15
    //   757: iload 16
    //   759: iload 17
    //   761: aconst_null
    //   762: iconst_0
    //   763: invokestatic 193	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   766: astore 22
    //   768: aload 21
    //   770: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   773: aload 22
    //   775: astore 21
    //   777: aload 21
    //   779: ifnonnull +31 -> 810
    //   782: ldc 62
    //   784: ldc 198
    //   786: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   789: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   792: dup
    //   793: ldc 202
    //   795: iconst_0
    //   796: anewarray 54	java/lang/Object
    //   799: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   802: astore_0
    //   803: ldc 34
    //   805: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   808: aload_0
    //   809: areturn
    //   810: aload 21
    //   812: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   815: ifle +11 -> 826
    //   818: aload 21
    //   820: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   823: ifgt +31 -> 854
    //   826: ldc 62
    //   828: ldc 204
    //   830: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   836: dup
    //   837: ldc 202
    //   839: iconst_0
    //   840: anewarray 54	java/lang/Object
    //   843: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   846: astore_0
    //   847: ldc 34
    //   849: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   852: aload_0
    //   853: areturn
    //   854: fload 5
    //   856: fload 7
    //   858: fcmpl
    //   859: ifne +11 -> 870
    //   862: fload 4
    //   864: fload 8
    //   866: fcmpl
    //   867: ifeq +291 -> 1158
    //   870: fload 7
    //   872: f2i
    //   873: istore 14
    //   875: fload 8
    //   877: f2i
    //   878: istore 15
    //   880: aload 21
    //   882: iload 14
    //   884: iload 15
    //   886: iconst_0
    //   887: invokestatic 208	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   890: astore 22
    //   892: aload 21
    //   894: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   897: aload 22
    //   899: astore 21
    //   901: aload 22
    //   903: ifnonnull +255 -> 1158
    //   906: ldc 101
    //   908: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   911: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   914: ldc2_w 110
    //   917: ldc2_w 209
    //   920: invokeinterface 115 5 0
    //   925: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   928: dup
    //   929: ldc 212
    //   931: iconst_0
    //   932: anewarray 54	java/lang/Object
    //   935: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   938: astore_0
    //   939: ldc 34
    //   941: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: aload_0
    //   945: areturn
    //   946: astore_0
    //   947: aload 21
    //   949: astore 22
    //   951: ldc 62
    //   953: ldc 214
    //   955: iconst_4
    //   956: anewarray 54	java/lang/Object
    //   959: dup
    //   960: iconst_0
    //   961: aload 22
    //   963: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   966: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   969: aastore
    //   970: dup
    //   971: iconst_1
    //   972: aload 22
    //   974: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   977: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   980: aastore
    //   981: dup
    //   982: iconst_2
    //   983: fload 7
    //   985: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   988: aastore
    //   989: dup
    //   990: iconst_3
    //   991: fload 8
    //   993: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   996: aastore
    //   997: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1000: ldc 62
    //   1002: aload_0
    //   1003: ldc 216
    //   1005: iconst_0
    //   1006: anewarray 54	java/lang/Object
    //   1009: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1012: ldc 101
    //   1014: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1017: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   1020: ldc2_w 110
    //   1023: ldc2_w 209
    //   1026: invokeinterface 115 5 0
    //   1031: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1034: dup
    //   1035: ldc 212
    //   1037: iconst_0
    //   1038: anewarray 54	java/lang/Object
    //   1041: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1044: astore_0
    //   1045: ldc 34
    //   1047: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1050: aload_0
    //   1051: areturn
    //   1052: astore_0
    //   1053: aload 21
    //   1055: astore 22
    //   1057: ldc 62
    //   1059: ldc 222
    //   1061: iconst_4
    //   1062: anewarray 54	java/lang/Object
    //   1065: dup
    //   1066: iconst_0
    //   1067: aload 22
    //   1069: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   1072: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1075: aastore
    //   1076: dup
    //   1077: iconst_1
    //   1078: aload 22
    //   1080: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   1083: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1086: aastore
    //   1087: dup
    //   1088: iconst_2
    //   1089: fload 7
    //   1091: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1094: aastore
    //   1095: dup
    //   1096: iconst_3
    //   1097: fload 8
    //   1099: invokestatic 155	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1102: aastore
    //   1103: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1106: ldc 62
    //   1108: aload_0
    //   1109: ldc 224
    //   1111: iconst_0
    //   1112: anewarray 54	java/lang/Object
    //   1115: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1118: ldc 101
    //   1120: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1123: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   1126: ldc2_w 110
    //   1129: ldc2_w 225
    //   1132: invokeinterface 115 5 0
    //   1137: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1140: dup
    //   1141: ldc 228
    //   1143: iconst_0
    //   1144: anewarray 54	java/lang/Object
    //   1147: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1150: astore_0
    //   1151: ldc 34
    //   1153: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1156: aload_0
    //   1157: areturn
    //   1158: aload_1
    //   1159: invokestatic 234	com/tencent/mm/plugin/appbrand/jsapi/c/d:ah	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   1162: astore 23
    //   1164: aload 23
    //   1166: getstatic 240	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1169: if_acmpne +404 -> 1573
    //   1172: aload 21
    //   1174: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   1177: aload 21
    //   1179: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   1182: getstatic 246	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   1185: invokestatic 249	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1188: astore 22
    //   1190: new 251	android/graphics/Canvas
    //   1193: dup
    //   1194: aload 22
    //   1196: invokespecial 254	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1199: aload 21
    //   1201: fconst_0
    //   1202: fconst_0
    //   1203: aconst_null
    //   1204: invokevirtual 258	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   1207: aload 22
    //   1209: astore 21
    //   1211: aload_0
    //   1212: invokevirtual 262	com/tencent/mm/plugin/appbrand/page/ad:getAppId	()Ljava/lang/String;
    //   1215: ldc_w 264
    //   1218: iload 13
    //   1220: invokestatic 269	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1223: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1226: invokestatic 279	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:genMediaFilePath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1229: astore 22
    //   1231: aload 21
    //   1233: aload_1
    //   1234: invokestatic 282	com/tencent/mm/plugin/appbrand/jsapi/c/d:ag	(Lorg/json/JSONObject;)I
    //   1237: aload 23
    //   1239: aload 22
    //   1241: iconst_1
    //   1242: invokestatic 288	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1245: pop
    //   1246: aload_0
    //   1247: invokevirtual 262	com/tencent/mm/plugin/appbrand/page/ad:getAppId	()Ljava/lang/String;
    //   1250: astore_1
    //   1251: aload 23
    //   1253: getstatic 291	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1256: if_acmpne +109 -> 1365
    //   1259: ldc_w 293
    //   1262: astore_0
    //   1263: aload_1
    //   1264: aload 22
    //   1266: aload_0
    //   1267: iconst_1
    //   1268: invokestatic 297	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject;
    //   1271: astore_0
    //   1272: aload_0
    //   1273: ifnonnull +99 -> 1372
    //   1276: ldc 62
    //   1278: ldc_w 299
    //   1281: iconst_1
    //   1282: anewarray 54	java/lang/Object
    //   1285: dup
    //   1286: iconst_0
    //   1287: iload 13
    //   1289: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1292: aastore
    //   1293: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1296: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1299: dup
    //   1300: ldc_w 301
    //   1303: iconst_0
    //   1304: anewarray 54	java/lang/Object
    //   1307: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1310: astore_0
    //   1311: ldc 34
    //   1313: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1316: aload_0
    //   1317: areturn
    //   1318: astore_0
    //   1319: ldc 62
    //   1321: ldc_w 303
    //   1324: iconst_2
    //   1325: anewarray 54	java/lang/Object
    //   1328: dup
    //   1329: iconst_0
    //   1330: iload 13
    //   1332: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1335: aastore
    //   1336: dup
    //   1337: iconst_1
    //   1338: aload_0
    //   1339: aastore
    //   1340: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1343: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1346: dup
    //   1347: ldc_w 305
    //   1350: iconst_0
    //   1351: anewarray 54	java/lang/Object
    //   1354: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1357: astore_0
    //   1358: ldc 34
    //   1360: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1363: aload_0
    //   1364: areturn
    //   1365: ldc_w 307
    //   1368: astore_0
    //   1369: goto -106 -> 1263
    //   1372: new 309	java/util/HashMap
    //   1375: dup
    //   1376: invokespecial 310	java/util/HashMap:<init>	()V
    //   1379: astore_1
    //   1380: aload_1
    //   1381: ldc_w 312
    //   1384: aload_0
    //   1385: getfield 317	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:hHB	Ljava/lang/String;
    //   1388: invokeinterface 323 3 0
    //   1393: pop
    //   1394: ldc 62
    //   1396: ldc_w 325
    //   1399: iconst_2
    //   1400: anewarray 54	java/lang/Object
    //   1403: dup
    //   1404: iconst_0
    //   1405: aload_0
    //   1406: getfield 317	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:hHB	Ljava/lang/String;
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_1
    //   1412: aload_0
    //   1413: getfield 328	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:onG	Ljava/lang/String;
    //   1416: aastore
    //   1417: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1420: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1423: dup
    //   1424: ldc_w 333
    //   1427: iconst_0
    //   1428: anewarray 54	java/lang/Object
    //   1431: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1434: aload_1
    //   1435: invokevirtual 337	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:N	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/file/i$a;
    //   1438: astore_0
    //   1439: ldc 34
    //   1441: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1444: aload_0
    //   1445: areturn
    //   1446: astore_0
    //   1447: ldc 62
    //   1449: aload_0
    //   1450: ldc_w 339
    //   1453: iconst_0
    //   1454: anewarray 54	java/lang/Object
    //   1457: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1460: ldc 101
    //   1462: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1465: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   1468: ldc2_w 110
    //   1471: ldc2_w 340
    //   1474: invokeinterface 115 5 0
    //   1479: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1482: dup
    //   1483: ldc_w 343
    //   1486: iconst_0
    //   1487: anewarray 54	java/lang/Object
    //   1490: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1493: astore_0
    //   1494: ldc 34
    //   1496: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1499: aload_0
    //   1500: areturn
    //   1501: astore_0
    //   1502: ldc 62
    //   1504: aload_0
    //   1505: ldc_w 345
    //   1508: iconst_0
    //   1509: anewarray 54	java/lang/Object
    //   1512: invokestatic 220	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1515: ldc 101
    //   1517: invokestatic 107	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1520: checkcast 101	com/tencent/mm/plugin/appbrand/x/a
    //   1523: ldc2_w 110
    //   1526: ldc2_w 346
    //   1529: lconst_1
    //   1530: iconst_0
    //   1531: invokeinterface 351 8 0
    //   1536: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1539: dup
    //   1540: ldc_w 353
    //   1543: iconst_1
    //   1544: anewarray 54	java/lang/Object
    //   1547: dup
    //   1548: iconst_0
    //   1549: aload_0
    //   1550: invokevirtual 356	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1553: aastore
    //   1554: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1557: astore_0
    //   1558: ldc 34
    //   1560: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1563: aload_0
    //   1564: areturn
    //   1565: astore_0
    //   1566: goto -509 -> 1057
    //   1569: astore_0
    //   1570: goto -619 -> 951
    //   1573: goto -362 -> 1211
    //   1576: goto -799 -> 777
    //   1579: goto -1093 -> 486
    //   1582: goto +51 -> 1633
    //   1585: fload 5
    //   1587: fstore 6
    //   1589: fload 9
    //   1591: fstore 4
    //   1593: fload 8
    //   1595: fstore 5
    //   1597: fload 7
    //   1599: fstore_3
    //   1600: goto +17 -> 1617
    //   1603: aconst_null
    //   1604: astore 21
    //   1606: goto -1479 -> 127
    //   1609: ldc2_w 357
    //   1612: lstore 19
    //   1614: goto -1456 -> 158
    //   1617: fload_3
    //   1618: fload 5
    //   1620: fadd
    //   1621: fload 10
    //   1623: fcmpl
    //   1624: ifle -42 -> 1582
    //   1627: fload 10
    //   1629: fload_3
    //   1630: fsub
    //   1631: fstore 5
    //   1633: fload 6
    //   1635: fload 4
    //   1637: fadd
    //   1638: fload 11
    //   1640: fcmpl
    //   1641: ifle -62 -> 1579
    //   1644: fload 11
    //   1646: fload 6
    //   1648: fsub
    //   1649: fstore 4
    //   1651: goto -1165 -> 486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1654	0	paramad	ad
    //   0	1654	1	paramJSONObject	JSONObject
    //   0	1654	2	paramBoolean	boolean
    //   417	1213	3	f1	float
    //   436	1214	4	f2	float
    //   316	1316	5	f3	float
    //   253	1394	6	f4	float
    //   306	1292	7	f5	float
    //   328	1266	8	f6	float
    //   340	1250	9	f7	float
    //   229	1399	10	f8	float
    //   237	1408	11	f9	float
    //   245	213	12	f10	float
    //   11	1320	13	i	int
    //   734	149	14	j	int
    //   739	146	15	k	int
    //   744	14	16	m	int
    //   749	11	17	n	int
    //   93	56	18	bool	boolean
    //   156	1457	19	l	long
    //   84	1521	21	localObject1	Object
    //   766	499	22	localObject2	Object
    //   1162	90	23	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   5	13	38	org/json/JSONException
    //   880	897	946	java/lang/NullPointerException
    //   880	897	1052	java/lang/IllegalArgumentException
    //   1231	1246	1318	java/io/IOException
    //   5	13	1446	java/lang/OutOfMemoryError
    //   17	31	1446	java/lang/OutOfMemoryError
    //   39	68	1446	java/lang/OutOfMemoryError
    //   75	95	1446	java/lang/OutOfMemoryError
    //   100	110	1446	java/lang/OutOfMemoryError
    //   115	127	1446	java/lang/OutOfMemoryError
    //   132	148	1446	java/lang/OutOfMemoryError
    //   158	183	1446	java/lang/OutOfMemoryError
    //   190	220	1446	java/lang/OutOfMemoryError
    //   223	385	1446	java/lang/OutOfMemoryError
    //   425	434	1446	java/lang/OutOfMemoryError
    //   445	455	1446	java/lang/OutOfMemoryError
    //   455	475	1446	java/lang/OutOfMemoryError
    //   486	587	1446	java/lang/OutOfMemoryError
    //   645	709	1446	java/lang/OutOfMemoryError
    //   751	773	1446	java/lang/OutOfMemoryError
    //   782	803	1446	java/lang/OutOfMemoryError
    //   810	826	1446	java/lang/OutOfMemoryError
    //   826	847	1446	java/lang/OutOfMemoryError
    //   880	897	1446	java/lang/OutOfMemoryError
    //   906	939	1446	java/lang/OutOfMemoryError
    //   951	1045	1446	java/lang/OutOfMemoryError
    //   1057	1151	1446	java/lang/OutOfMemoryError
    //   1158	1207	1446	java/lang/OutOfMemoryError
    //   1211	1231	1446	java/lang/OutOfMemoryError
    //   1231	1246	1446	java/lang/OutOfMemoryError
    //   1246	1259	1446	java/lang/OutOfMemoryError
    //   1263	1272	1446	java/lang/OutOfMemoryError
    //   1276	1311	1446	java/lang/OutOfMemoryError
    //   1319	1358	1446	java/lang/OutOfMemoryError
    //   1372	1439	1446	java/lang/OutOfMemoryError
    //   5	13	1501	java/lang/RuntimeException
    //   17	31	1501	java/lang/RuntimeException
    //   39	68	1501	java/lang/RuntimeException
    //   75	95	1501	java/lang/RuntimeException
    //   100	110	1501	java/lang/RuntimeException
    //   115	127	1501	java/lang/RuntimeException
    //   132	148	1501	java/lang/RuntimeException
    //   158	183	1501	java/lang/RuntimeException
    //   190	220	1501	java/lang/RuntimeException
    //   223	385	1501	java/lang/RuntimeException
    //   425	434	1501	java/lang/RuntimeException
    //   445	455	1501	java/lang/RuntimeException
    //   455	475	1501	java/lang/RuntimeException
    //   486	587	1501	java/lang/RuntimeException
    //   645	709	1501	java/lang/RuntimeException
    //   751	773	1501	java/lang/RuntimeException
    //   782	803	1501	java/lang/RuntimeException
    //   810	826	1501	java/lang/RuntimeException
    //   826	847	1501	java/lang/RuntimeException
    //   880	897	1501	java/lang/RuntimeException
    //   906	939	1501	java/lang/RuntimeException
    //   951	1045	1501	java/lang/RuntimeException
    //   1057	1151	1501	java/lang/RuntimeException
    //   1158	1207	1501	java/lang/RuntimeException
    //   1211	1231	1501	java/lang/RuntimeException
    //   1231	1246	1501	java/lang/RuntimeException
    //   1246	1259	1501	java/lang/RuntimeException
    //   1263	1272	1501	java/lang/RuntimeException
    //   1276	1311	1501	java/lang/RuntimeException
    //   1319	1358	1501	java/lang/RuntimeException
    //   1372	1439	1501	java/lang/RuntimeException
    //   906	939	1565	java/lang/IllegalArgumentException
    //   906	939	1569	java/lang/NullPointerException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.d
 * JD-Core Version:    0.7.0.1
 */