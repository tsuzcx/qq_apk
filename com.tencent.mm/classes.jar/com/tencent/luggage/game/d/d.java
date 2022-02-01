package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class d
  extends a<q>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  /* Error */
  public static i.a a(aa paramaa, JSONObject paramJSONObject, boolean paramBoolean)
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
    //   51: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   78: invokevirtual 80	com/tencent/mm/plugin/appbrand/page/aa:Q	(Ljava/lang/Class;)Ljava/lang/Object;
    //   81: checkcast 74	com/tencent/luggage/game/page/d
    //   84: astore 21
    //   86: aload_1
    //   87: ldc 82
    //   89: iconst_0
    //   90: invokevirtual 86	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   93: istore 18
    //   95: aload 21
    //   97: ifnull +1491 -> 1588
    //   100: aload 21
    //   102: invokeinterface 90 1 0
    //   107: ifnull +1481 -> 1588
    //   110: iload 18
    //   112: ifne +75 -> 187
    //   115: aload 21
    //   117: iload 13
    //   119: iload_2
    //   120: invokeinterface 94 3 0
    //   125: astore 21
    //   127: aload 21
    //   129: ifnonnull +91 -> 220
    //   132: ldc 62
    //   134: ldc 96
    //   136: invokestatic 99	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 101
    //   141: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   144: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   147: astore_0
    //   148: iload 18
    //   150: ifeq +1444 -> 1594
    //   153: ldc2_w 108
    //   156: lstore 19
    //   158: aload_0
    //   159: lload 19
    //   161: invokeinterface 113 3 0
    //   166: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   169: dup
    //   170: ldc 115
    //   172: iconst_0
    //   173: anewarray 54	java/lang/Object
    //   176: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: astore_0
    //   180: ldc 34
    //   182: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_0
    //   186: areturn
    //   187: aload 21
    //   189: invokeinterface 90 1 0
    //   194: invokevirtual 121	com/tencent/magicbrush/ui/MagicBrushView:getMagicBrush	()Lcom/tencent/magicbrush/d;
    //   197: getfield 127	com/tencent/magicbrush/d:cpg	Lcom/tencent/magicbrush/b;
    //   200: aload 21
    //   202: invokeinterface 90 1 0
    //   207: invokevirtual 131	com/tencent/magicbrush/ui/MagicBrushView:getVirtualElementId	()I
    //   210: iconst_m1
    //   211: iconst_1
    //   212: invokevirtual 137	com/tencent/magicbrush/b:h	(IIZ)Landroid/graphics/Bitmap;
    //   215: astore 21
    //   217: goto -90 -> 127
    //   220: aload 21
    //   222: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   225: i2f
    //   226: fstore 10
    //   228: aload 21
    //   230: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   233: i2f
    //   234: fstore 11
    //   236: aload 21
    //   238: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   241: i2f
    //   242: fstore 12
    //   244: aload 21
    //   246: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   249: i2f
    //   250: fstore 6
    //   252: ldc 62
    //   254: ldc 147
    //   256: iconst_4
    //   257: anewarray 54	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: fload 10
    //   264: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: fload 11
    //   272: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   275: aastore
    //   276: dup
    //   277: iconst_2
    //   278: fload 12
    //   280: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   283: aastore
    //   284: dup
    //   285: iconst_3
    //   286: fload 6
    //   288: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   291: aastore
    //   292: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload_1
    //   296: ldc 157
    //   298: dconst_0
    //   299: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   302: d2f
    //   303: fstore 7
    //   305: aload_1
    //   306: ldc 163
    //   308: dconst_0
    //   309: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   312: d2f
    //   313: fstore 5
    //   315: aload_1
    //   316: ldc 165
    //   318: fload 12
    //   320: f2d
    //   321: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   324: d2f
    //   325: fstore 8
    //   327: aload_1
    //   328: ldc 167
    //   330: fload 6
    //   332: f2d
    //   333: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   336: d2f
    //   337: fstore 9
    //   339: ldc 62
    //   341: ldc 169
    //   343: iconst_4
    //   344: anewarray 54	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: fload 7
    //   351: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: fload 5
    //   359: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: fload 8
    //   367: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   370: aastore
    //   371: dup
    //   372: iconst_3
    //   373: fload 9
    //   375: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   378: aastore
    //   379: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: fload 12
    //   384: fconst_0
    //   385: fcmpl
    //   386: ifle +1184 -> 1570
    //   389: fload 6
    //   391: fconst_0
    //   392: fcmpl
    //   393: ifle +1177 -> 1570
    //   396: fload 10
    //   398: fload 12
    //   400: fcmpl
    //   401: ifne +11 -> 412
    //   404: fload 11
    //   406: fload 6
    //   408: fcmpl
    //   409: ifeq +1161 -> 1570
    //   412: fload 7
    //   414: fstore_3
    //   415: fload 7
    //   417: fconst_0
    //   418: fcmpl
    //   419: ifle +12 -> 431
    //   422: fload 7
    //   424: fload 12
    //   426: fdiv
    //   427: fload 10
    //   429: fmul
    //   430: fstore_3
    //   431: fload 5
    //   433: fstore 4
    //   435: fload 5
    //   437: fconst_0
    //   438: fcmpl
    //   439: ifle +13 -> 452
    //   442: fload 5
    //   444: fload 6
    //   446: fdiv
    //   447: fload 11
    //   449: fmul
    //   450: fstore 4
    //   452: fload 8
    //   454: fload 12
    //   456: fdiv
    //   457: fload 10
    //   459: fmul
    //   460: fstore 5
    //   462: fload 9
    //   464: fload 6
    //   466: fdiv
    //   467: fload 11
    //   469: fmul
    //   470: fstore 7
    //   472: fload 4
    //   474: fstore 6
    //   476: fload 7
    //   478: fstore 4
    //   480: goto +1122 -> 1602
    //   483: aload_1
    //   484: ldc 171
    //   486: fload 5
    //   488: f2d
    //   489: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   492: d2f
    //   493: fstore 7
    //   495: aload_1
    //   496: ldc 173
    //   498: fload 4
    //   500: f2d
    //   501: invokevirtual 161	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   504: d2f
    //   505: fstore 8
    //   507: ldc 62
    //   509: ldc 175
    //   511: bipush 8
    //   513: anewarray 54	java/lang/Object
    //   516: dup
    //   517: iconst_0
    //   518: fload_3
    //   519: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: fload 6
    //   527: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   530: aastore
    //   531: dup
    //   532: iconst_2
    //   533: fload 10
    //   535: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   538: aastore
    //   539: dup
    //   540: iconst_3
    //   541: fload 11
    //   543: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   546: aastore
    //   547: dup
    //   548: iconst_4
    //   549: fload 5
    //   551: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   554: aastore
    //   555: dup
    //   556: iconst_5
    //   557: fload 4
    //   559: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   562: aastore
    //   563: dup
    //   564: bipush 6
    //   566: fload 7
    //   568: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   571: aastore
    //   572: dup
    //   573: bipush 7
    //   575: fload 8
    //   577: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   580: aastore
    //   581: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   584: fload_3
    //   585: f2i
    //   586: iflt +56 -> 642
    //   589: fload 6
    //   591: f2i
    //   592: iflt +50 -> 642
    //   595: fload 5
    //   597: f2i
    //   598: ifle +44 -> 642
    //   601: fload 4
    //   603: f2i
    //   604: ifle +38 -> 642
    //   607: fload_3
    //   608: fload 5
    //   610: fadd
    //   611: f2i
    //   612: fload 10
    //   614: f2i
    //   615: if_icmpgt +27 -> 642
    //   618: fload 6
    //   620: fload 4
    //   622: fadd
    //   623: f2i
    //   624: fload 11
    //   626: f2i
    //   627: if_icmpgt +15 -> 642
    //   630: fload 7
    //   632: f2i
    //   633: ifle +9 -> 642
    //   636: fload 8
    //   638: f2i
    //   639: ifgt +74 -> 713
    //   642: ldc 62
    //   644: ldc 177
    //   646: iconst_5
    //   647: anewarray 54	java/lang/Object
    //   650: dup
    //   651: iconst_0
    //   652: fload_3
    //   653: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   656: aastore
    //   657: dup
    //   658: iconst_1
    //   659: fload 6
    //   661: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   664: aastore
    //   665: dup
    //   666: iconst_2
    //   667: fload 5
    //   669: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   672: aastore
    //   673: dup
    //   674: iconst_3
    //   675: fload 4
    //   677: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   680: aastore
    //   681: dup
    //   682: iconst_4
    //   683: iload 13
    //   685: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: aastore
    //   689: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   695: dup
    //   696: ldc 187
    //   698: iconst_0
    //   699: anewarray 54	java/lang/Object
    //   702: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   705: astore_0
    //   706: ldc 34
    //   708: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: aload_0
    //   712: areturn
    //   713: fload 5
    //   715: fload 10
    //   717: fcmpl
    //   718: ifne +11 -> 729
    //   721: fload 4
    //   723: fload 11
    //   725: fcmpl
    //   726: ifeq +835 -> 1561
    //   729: fload_3
    //   730: f2i
    //   731: istore 14
    //   733: fload 6
    //   735: f2i
    //   736: istore 15
    //   738: fload 5
    //   740: f2i
    //   741: istore 16
    //   743: fload 4
    //   745: f2i
    //   746: istore 17
    //   748: aload 21
    //   750: iload 14
    //   752: iload 15
    //   754: iload 16
    //   756: iload 17
    //   758: aconst_null
    //   759: iconst_0
    //   760: invokestatic 191	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   763: astore 22
    //   765: aload 21
    //   767: invokevirtual 194	android/graphics/Bitmap:recycle	()V
    //   770: aload 22
    //   772: astore 21
    //   774: aload 21
    //   776: ifnonnull +31 -> 807
    //   779: ldc 62
    //   781: ldc 196
    //   783: invokestatic 198	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   786: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   789: dup
    //   790: ldc 200
    //   792: iconst_0
    //   793: anewarray 54	java/lang/Object
    //   796: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   799: astore_0
    //   800: ldc 34
    //   802: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   805: aload_0
    //   806: areturn
    //   807: aload 21
    //   809: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   812: ifle +11 -> 823
    //   815: aload 21
    //   817: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   820: ifgt +31 -> 851
    //   823: ldc 62
    //   825: ldc 202
    //   827: invokestatic 198	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   833: dup
    //   834: ldc 200
    //   836: iconst_0
    //   837: anewarray 54	java/lang/Object
    //   840: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: astore_0
    //   844: ldc 34
    //   846: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: aload_0
    //   850: areturn
    //   851: fload 5
    //   853: fload 7
    //   855: fcmpl
    //   856: ifne +11 -> 867
    //   859: fload 4
    //   861: fload 8
    //   863: fcmpl
    //   864: ifeq +282 -> 1146
    //   867: fload 7
    //   869: f2i
    //   870: istore 14
    //   872: fload 8
    //   874: f2i
    //   875: istore 15
    //   877: aload 21
    //   879: iload 14
    //   881: iload 15
    //   883: iconst_0
    //   884: invokestatic 206	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   887: astore 22
    //   889: aload 21
    //   891: invokevirtual 194	android/graphics/Bitmap:recycle	()V
    //   894: aload 22
    //   896: astore 21
    //   898: aload 22
    //   900: ifnonnull +246 -> 1146
    //   903: ldc 101
    //   905: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   908: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   911: ldc2_w 207
    //   914: invokeinterface 113 3 0
    //   919: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   922: dup
    //   923: ldc 210
    //   925: iconst_0
    //   926: anewarray 54	java/lang/Object
    //   929: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   932: astore_0
    //   933: ldc 34
    //   935: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: aload_0
    //   939: areturn
    //   940: astore_0
    //   941: aload 21
    //   943: astore 22
    //   945: ldc 62
    //   947: ldc 212
    //   949: iconst_4
    //   950: anewarray 54	java/lang/Object
    //   953: dup
    //   954: iconst_0
    //   955: aload 22
    //   957: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   960: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   963: aastore
    //   964: dup
    //   965: iconst_1
    //   966: aload 22
    //   968: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   971: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: aastore
    //   975: dup
    //   976: iconst_2
    //   977: fload 7
    //   979: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   982: aastore
    //   983: dup
    //   984: iconst_3
    //   985: fload 8
    //   987: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   990: aastore
    //   991: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   994: ldc 62
    //   996: aload_0
    //   997: ldc 214
    //   999: iconst_0
    //   1000: anewarray 54	java/lang/Object
    //   1003: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1006: ldc 101
    //   1008: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1011: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   1014: ldc2_w 207
    //   1017: invokeinterface 113 3 0
    //   1022: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1025: dup
    //   1026: ldc 210
    //   1028: iconst_0
    //   1029: anewarray 54	java/lang/Object
    //   1032: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1035: astore_0
    //   1036: ldc 34
    //   1038: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1041: aload_0
    //   1042: areturn
    //   1043: astore_0
    //   1044: aload 21
    //   1046: astore 22
    //   1048: ldc 62
    //   1050: ldc 220
    //   1052: iconst_4
    //   1053: anewarray 54	java/lang/Object
    //   1056: dup
    //   1057: iconst_0
    //   1058: aload 22
    //   1060: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   1063: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1066: aastore
    //   1067: dup
    //   1068: iconst_1
    //   1069: aload 22
    //   1071: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   1074: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1077: aastore
    //   1078: dup
    //   1079: iconst_2
    //   1080: fload 7
    //   1082: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1085: aastore
    //   1086: dup
    //   1087: iconst_3
    //   1088: fload 8
    //   1090: invokestatic 153	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1093: aastore
    //   1094: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1097: ldc 62
    //   1099: aload_0
    //   1100: ldc 222
    //   1102: iconst_0
    //   1103: anewarray 54	java/lang/Object
    //   1106: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1109: ldc 101
    //   1111: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1114: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   1117: ldc2_w 223
    //   1120: invokeinterface 113 3 0
    //   1125: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1128: dup
    //   1129: ldc 226
    //   1131: iconst_0
    //   1132: anewarray 54	java/lang/Object
    //   1135: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1138: astore_0
    //   1139: ldc 34
    //   1141: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: aload_0
    //   1145: areturn
    //   1146: aload_1
    //   1147: invokestatic 231	com/tencent/mm/plugin/appbrand/jsapi/b/d:L	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
    //   1150: astore 23
    //   1152: aload 23
    //   1154: getstatic 237	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1157: if_acmpne +401 -> 1558
    //   1160: aload 21
    //   1162: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   1165: aload 21
    //   1167: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   1170: getstatic 243	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   1173: invokestatic 246	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1176: astore 22
    //   1178: new 248	android/graphics/Canvas
    //   1181: dup
    //   1182: aload 22
    //   1184: invokespecial 251	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1187: aload 21
    //   1189: fconst_0
    //   1190: fconst_0
    //   1191: aconst_null
    //   1192: invokevirtual 255	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   1195: aload 22
    //   1197: astore 21
    //   1199: aload_0
    //   1200: invokevirtual 259	com/tencent/mm/plugin/appbrand/page/aa:getAppId	()Ljava/lang/String;
    //   1203: ldc_w 261
    //   1206: iload 13
    //   1208: invokestatic 266	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1211: invokevirtual 270	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1214: invokestatic 276	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:genMediaFilePath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1217: astore 22
    //   1219: aload 21
    //   1221: aload_1
    //   1222: invokestatic 280	com/tencent/mm/plugin/appbrand/jsapi/b/d:K	(Lorg/json/JSONObject;)I
    //   1225: aload 23
    //   1227: aload 22
    //   1229: iconst_1
    //   1230: invokestatic 285	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1233: pop
    //   1234: aload_0
    //   1235: invokevirtual 259	com/tencent/mm/plugin/appbrand/page/aa:getAppId	()Ljava/lang/String;
    //   1238: astore_1
    //   1239: aload 23
    //   1241: getstatic 288	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1244: if_acmpne +109 -> 1353
    //   1247: ldc_w 290
    //   1250: astore_0
    //   1251: aload_1
    //   1252: aload 22
    //   1254: aload_0
    //   1255: iconst_1
    //   1256: invokestatic 294	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject;
    //   1259: astore_0
    //   1260: aload_0
    //   1261: ifnonnull +99 -> 1360
    //   1264: ldc 62
    //   1266: ldc_w 296
    //   1269: iconst_1
    //   1270: anewarray 54	java/lang/Object
    //   1273: dup
    //   1274: iconst_0
    //   1275: iload 13
    //   1277: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1280: aastore
    //   1281: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1284: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1287: dup
    //   1288: ldc_w 298
    //   1291: iconst_0
    //   1292: anewarray 54	java/lang/Object
    //   1295: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1298: astore_0
    //   1299: ldc 34
    //   1301: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1304: aload_0
    //   1305: areturn
    //   1306: astore_0
    //   1307: ldc 62
    //   1309: ldc_w 300
    //   1312: iconst_2
    //   1313: anewarray 54	java/lang/Object
    //   1316: dup
    //   1317: iconst_0
    //   1318: iload 13
    //   1320: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1323: aastore
    //   1324: dup
    //   1325: iconst_1
    //   1326: aload_0
    //   1327: aastore
    //   1328: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1331: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1334: dup
    //   1335: ldc_w 302
    //   1338: iconst_0
    //   1339: anewarray 54	java/lang/Object
    //   1342: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1345: astore_0
    //   1346: ldc 34
    //   1348: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1351: aload_0
    //   1352: areturn
    //   1353: ldc_w 304
    //   1356: astore_0
    //   1357: goto -106 -> 1251
    //   1360: new 306	java/util/HashMap
    //   1363: dup
    //   1364: invokespecial 307	java/util/HashMap:<init>	()V
    //   1367: astore_1
    //   1368: aload_1
    //   1369: ldc_w 309
    //   1372: aload_0
    //   1373: getfield 314	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:diQ	Ljava/lang/String;
    //   1376: invokeinterface 320 3 0
    //   1381: pop
    //   1382: ldc 62
    //   1384: ldc_w 322
    //   1387: iconst_2
    //   1388: anewarray 54	java/lang/Object
    //   1391: dup
    //   1392: iconst_0
    //   1393: aload_0
    //   1394: getfield 314	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:diQ	Ljava/lang/String;
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_1
    //   1400: aload_0
    //   1401: getfield 325	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObject:gPG	Ljava/lang/String;
    //   1404: aastore
    //   1405: invokestatic 328	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1408: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1411: dup
    //   1412: ldc_w 330
    //   1415: iconst_0
    //   1416: anewarray 54	java/lang/Object
    //   1419: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1422: aload_1
    //   1423: invokevirtual 334	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:E	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/file/i$a;
    //   1426: astore_0
    //   1427: ldc 34
    //   1429: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1432: aload_0
    //   1433: areturn
    //   1434: astore_0
    //   1435: ldc 62
    //   1437: aload_0
    //   1438: ldc_w 336
    //   1441: iconst_0
    //   1442: anewarray 54	java/lang/Object
    //   1445: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1448: ldc 101
    //   1450: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1453: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   1456: ldc2_w 337
    //   1459: invokeinterface 113 3 0
    //   1464: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1467: dup
    //   1468: ldc_w 340
    //   1471: iconst_0
    //   1472: anewarray 54	java/lang/Object
    //   1475: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1478: astore_0
    //   1479: ldc 34
    //   1481: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1484: aload_0
    //   1485: areturn
    //   1486: astore_0
    //   1487: ldc 62
    //   1489: aload_0
    //   1490: ldc_w 342
    //   1493: iconst_0
    //   1494: anewarray 54	java/lang/Object
    //   1497: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1500: ldc 101
    //   1502: invokestatic 107	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1505: checkcast 101	com/tencent/mm/plugin/appbrand/u/a
    //   1508: ldc2_w 343
    //   1511: ldc2_w 345
    //   1514: lconst_1
    //   1515: iconst_0
    //   1516: invokeinterface 350 8 0
    //   1521: new 50	com/tencent/mm/plugin/appbrand/jsapi/file/i$a
    //   1524: dup
    //   1525: ldc_w 352
    //   1528: iconst_1
    //   1529: anewarray 54	java/lang/Object
    //   1532: dup
    //   1533: iconst_0
    //   1534: aload_0
    //   1535: invokevirtual 355	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   1538: aastore
    //   1539: invokespecial 57	com/tencent/mm/plugin/appbrand/jsapi/file/i$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1542: astore_0
    //   1543: ldc 34
    //   1545: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1548: aload_0
    //   1549: areturn
    //   1550: astore_0
    //   1551: goto -503 -> 1048
    //   1554: astore_0
    //   1555: goto -610 -> 945
    //   1558: goto -359 -> 1199
    //   1561: goto -787 -> 774
    //   1564: goto -1081 -> 483
    //   1567: goto +51 -> 1618
    //   1570: fload 5
    //   1572: fstore 6
    //   1574: fload 9
    //   1576: fstore 4
    //   1578: fload 8
    //   1580: fstore 5
    //   1582: fload 7
    //   1584: fstore_3
    //   1585: goto +17 -> 1602
    //   1588: aconst_null
    //   1589: astore 21
    //   1591: goto -1464 -> 127
    //   1594: ldc2_w 356
    //   1597: lstore 19
    //   1599: goto -1441 -> 158
    //   1602: fload_3
    //   1603: fload 5
    //   1605: fadd
    //   1606: fload 10
    //   1608: fcmpl
    //   1609: ifle -42 -> 1567
    //   1612: fload 10
    //   1614: fload_3
    //   1615: fsub
    //   1616: fstore 5
    //   1618: fload 6
    //   1620: fload 4
    //   1622: fadd
    //   1623: fload 11
    //   1625: fcmpl
    //   1626: ifle -62 -> 1564
    //   1629: fload 11
    //   1631: fload 6
    //   1633: fsub
    //   1634: fstore 4
    //   1636: goto -1153 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1639	0	paramaa	aa
    //   0	1639	1	paramJSONObject	JSONObject
    //   0	1639	2	paramBoolean	boolean
    //   414	1201	3	f1	float
    //   433	1202	4	f2	float
    //   313	1304	5	f3	float
    //   250	1382	6	f4	float
    //   303	1280	7	f5	float
    //   325	1254	8	f6	float
    //   337	1238	9	f7	float
    //   226	1387	10	f8	float
    //   234	1396	11	f9	float
    //   242	213	12	f10	float
    //   11	1308	13	i	int
    //   731	149	14	j	int
    //   736	146	15	k	int
    //   741	14	16	m	int
    //   746	11	17	n	int
    //   93	56	18	bool	boolean
    //   156	1442	19	l	long
    //   84	1506	21	localObject1	Object
    //   763	490	22	localObject2	Object
    //   1150	90	23	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   5	13	38	org/json/JSONException
    //   877	894	940	java/lang/NullPointerException
    //   877	894	1043	java/lang/IllegalArgumentException
    //   1219	1234	1306	java/io/IOException
    //   5	13	1434	java/lang/OutOfMemoryError
    //   17	31	1434	java/lang/OutOfMemoryError
    //   39	68	1434	java/lang/OutOfMemoryError
    //   75	95	1434	java/lang/OutOfMemoryError
    //   100	110	1434	java/lang/OutOfMemoryError
    //   115	127	1434	java/lang/OutOfMemoryError
    //   132	148	1434	java/lang/OutOfMemoryError
    //   158	180	1434	java/lang/OutOfMemoryError
    //   187	217	1434	java/lang/OutOfMemoryError
    //   220	382	1434	java/lang/OutOfMemoryError
    //   422	431	1434	java/lang/OutOfMemoryError
    //   442	452	1434	java/lang/OutOfMemoryError
    //   452	472	1434	java/lang/OutOfMemoryError
    //   483	584	1434	java/lang/OutOfMemoryError
    //   642	706	1434	java/lang/OutOfMemoryError
    //   748	770	1434	java/lang/OutOfMemoryError
    //   779	800	1434	java/lang/OutOfMemoryError
    //   807	823	1434	java/lang/OutOfMemoryError
    //   823	844	1434	java/lang/OutOfMemoryError
    //   877	894	1434	java/lang/OutOfMemoryError
    //   903	933	1434	java/lang/OutOfMemoryError
    //   945	1036	1434	java/lang/OutOfMemoryError
    //   1048	1139	1434	java/lang/OutOfMemoryError
    //   1146	1195	1434	java/lang/OutOfMemoryError
    //   1199	1219	1434	java/lang/OutOfMemoryError
    //   1219	1234	1434	java/lang/OutOfMemoryError
    //   1234	1247	1434	java/lang/OutOfMemoryError
    //   1251	1260	1434	java/lang/OutOfMemoryError
    //   1264	1299	1434	java/lang/OutOfMemoryError
    //   1307	1346	1434	java/lang/OutOfMemoryError
    //   1360	1427	1434	java/lang/OutOfMemoryError
    //   5	13	1486	java/lang/RuntimeException
    //   17	31	1486	java/lang/RuntimeException
    //   39	68	1486	java/lang/RuntimeException
    //   75	95	1486	java/lang/RuntimeException
    //   100	110	1486	java/lang/RuntimeException
    //   115	127	1486	java/lang/RuntimeException
    //   132	148	1486	java/lang/RuntimeException
    //   158	180	1486	java/lang/RuntimeException
    //   187	217	1486	java/lang/RuntimeException
    //   220	382	1486	java/lang/RuntimeException
    //   422	431	1486	java/lang/RuntimeException
    //   442	452	1486	java/lang/RuntimeException
    //   452	472	1486	java/lang/RuntimeException
    //   483	584	1486	java/lang/RuntimeException
    //   642	706	1486	java/lang/RuntimeException
    //   748	770	1486	java/lang/RuntimeException
    //   779	800	1486	java/lang/RuntimeException
    //   807	823	1486	java/lang/RuntimeException
    //   823	844	1486	java/lang/RuntimeException
    //   877	894	1486	java/lang/RuntimeException
    //   903	933	1486	java/lang/RuntimeException
    //   945	1036	1486	java/lang/RuntimeException
    //   1048	1139	1486	java/lang/RuntimeException
    //   1146	1195	1486	java/lang/RuntimeException
    //   1199	1219	1486	java/lang/RuntimeException
    //   1219	1234	1486	java/lang/RuntimeException
    //   1234	1247	1486	java/lang/RuntimeException
    //   1251	1260	1486	java/lang/RuntimeException
    //   1264	1299	1486	java/lang/RuntimeException
    //   1307	1346	1486	java/lang/RuntimeException
    //   1360	1427	1486	java/lang/RuntimeException
    //   903	933	1550	java/lang/IllegalArgumentException
    //   903	933	1554	java/lang/NullPointerException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.d.d
 * JD-Core Version:    0.7.0.1
 */