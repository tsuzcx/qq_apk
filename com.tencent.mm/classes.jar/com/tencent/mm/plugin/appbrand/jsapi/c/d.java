package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public class d
  extends c<f>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int ag(JSONObject paramJSONObject)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(145532);
    float f2 = (float)paramJSONObject.optDouble("quality", 1.0D);
    if (f2 < 0.0F) {}
    for (;;)
    {
      int i = (int)f1;
      AppMethodBeat.o(145532);
      return i;
      if (f2 > 1.0F) {
        f1 = 100.0F;
      } else {
        f1 = f2 * 100.0F;
      }
    }
  }
  
  public static Bitmap.CompressFormat ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145533);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    AppMethodBeat.o(145533);
    return localCompressFormat;
  }
  
  public void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145531);
    o.cNm().postToWorker(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 41
        //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   9: invokeinterface 53 1 0
        //   14: ifne +38 -> 52
        //   17: ldc 55
        //   19: ldc 57
        //   21: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   28: aload_0
        //   29: getfield 27	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:elZ	I
        //   32: aload_0
        //   33: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:rRk	Lcom/tencent/mm/plugin/appbrand/jsapi/c/d;
        //   36: ldc 65
        //   38: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   41: invokeinterface 73 3 0
        //   46: ldc 41
        //   48: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   51: return
        //   52: aload_0
        //   53: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   56: ldc 78
        //   58: invokeinterface 82 2 0
        //   63: checkcast 78	com/tencent/mm/plugin/appbrand/jsapi/base/g
        //   66: aload_0
        //   67: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   70: aload_0
        //   71: getfield 29	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:ejE	Lorg/json/JSONObject;
        //   74: invokeinterface 86 3 0
        //   79: astore 16
        //   81: aload 16
        //   83: ifnonnull +38 -> 121
        //   86: ldc 55
        //   88: ldc 88
        //   90: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   93: aload_0
        //   94: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   97: aload_0
        //   98: getfield 27	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:elZ	I
        //   101: aload_0
        //   102: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:rRk	Lcom/tencent/mm/plugin/appbrand/jsapi/c/d;
        //   105: ldc 90
        //   107: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   110: invokeinterface 73 3 0
        //   115: ldc 41
        //   117: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   120: return
        //   121: aload_0
        //   122: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:rRk	Lcom/tencent/mm/plugin/appbrand/jsapi/c/d;
        //   125: astore 14
        //   127: aload_0
        //   128: getfield 29	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:ejE	Lorg/json/JSONObject;
        //   131: astore 17
        //   133: new 92	com/tencent/mm/plugin/appbrand/jsapi/base/i
        //   136: dup
        //   137: aload_0
        //   138: getfield 25	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:qwp	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
        //   141: aload_0
        //   142: getfield 27	com/tencent/mm/plugin/appbrand/jsapi/c/d$1:elZ	I
        //   145: invokespecial 95	com/tencent/mm/plugin/appbrand/jsapi/base/i:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;I)V
        //   148: astore 15
        //   150: aload 17
        //   152: ldc 97
        //   154: invokevirtual 103	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   157: istore 7
        //   159: aload 16
        //   161: aload 17
        //   163: ldc 105
        //   165: iconst_0
        //   166: invokevirtual 109	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
        //   169: invokeinterface 115 2 0
        //   174: iload 7
        //   176: invokeinterface 121 2 0
        //   181: astore 12
        //   183: aload 12
        //   185: ifnonnull +76 -> 261
        //   188: ldc 55
        //   190: ldc 123
        //   192: iconst_1
        //   193: anewarray 4	java/lang/Object
        //   196: dup
        //   197: iconst_0
        //   198: iload 7
        //   200: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   203: aastore
        //   204: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   207: aload 15
        //   209: aload 14
        //   211: ldc 134
        //   213: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   216: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   219: ldc 41
        //   221: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   224: return
        //   225: astore 12
        //   227: ldc 55
        //   229: ldc 140
        //   231: iconst_1
        //   232: anewarray 4	java/lang/Object
        //   235: dup
        //   236: iconst_0
        //   237: aload 12
        //   239: aastore
        //   240: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   243: aload 15
        //   245: aload 14
        //   247: ldc 142
        //   249: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   252: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   255: ldc 41
        //   257: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   260: return
        //   261: aload 12
        //   263: instanceof 144
        //   266: ifne +40 -> 306
        //   269: ldc 55
        //   271: ldc 146
        //   273: iconst_1
        //   274: anewarray 4	java/lang/Object
        //   277: dup
        //   278: iconst_0
        //   279: iload 7
        //   281: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   284: aastore
        //   285: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   288: aload 15
        //   290: aload 14
        //   292: ldc 148
        //   294: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   297: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   300: ldc 41
        //   302: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   305: return
        //   306: aload 12
        //   308: checkcast 144	com/tencent/mm/plugin/appbrand/jsapi/coverview/CoverViewContainer
        //   311: ldc 150
        //   313: invokevirtual 154	com/tencent/mm/plugin/appbrand/jsapi/coverview/CoverViewContainer:aT	(Ljava/lang/Class;)Ljava/lang/Object;
        //   316: checkcast 150	android/view/View
        //   319: astore 12
        //   321: aload 12
        //   323: ifnonnull +40 -> 363
        //   326: ldc 55
        //   328: ldc 156
        //   330: iconst_1
        //   331: anewarray 4	java/lang/Object
        //   334: dup
        //   335: iconst_0
        //   336: iload 7
        //   338: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   341: aastore
        //   342: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   345: aload 15
        //   347: aload 14
        //   349: ldc 158
        //   351: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   354: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   357: ldc 41
        //   359: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   362: return
        //   363: aload 12
        //   365: invokevirtual 162	android/view/View:getMeasuredWidth	()I
        //   368: istore 8
        //   370: aload 12
        //   372: invokevirtual 165	android/view/View:getMeasuredHeight	()I
        //   375: istore 9
        //   377: iload 8
        //   379: iload 9
        //   381: getstatic 171	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
        //   384: invokestatic 177	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
        //   387: astore 13
        //   389: aload 17
        //   391: ldc 179
        //   393: invokestatic 184	com/tencent/mm/plugin/appbrand/af/i:i	(Lorg/json/JSONObject;Ljava/lang/String;)F
        //   396: fstore_3
        //   397: aload 17
        //   399: ldc 186
        //   401: invokestatic 184	com/tencent/mm/plugin/appbrand/af/i:i	(Lorg/json/JSONObject;Ljava/lang/String;)F
        //   404: fstore 4
        //   406: aload 17
        //   408: ldc 188
        //   410: iload 8
        //   412: i2f
        //   413: invokestatic 191	com/tencent/mm/plugin/appbrand/af/i:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
        //   416: fstore_1
        //   417: aload 17
        //   419: ldc 193
        //   421: iload 9
        //   423: i2f
        //   424: invokestatic 191	com/tencent/mm/plugin/appbrand/af/i:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
        //   427: fstore_2
        //   428: fload_3
        //   429: fload_1
        //   430: fadd
        //   431: iload 8
        //   433: i2f
        //   434: fcmpl
        //   435: ifle +963 -> 1398
        //   438: iload 8
        //   440: i2f
        //   441: fload_3
        //   442: fsub
        //   443: fstore_1
        //   444: fload 4
        //   446: fload_2
        //   447: fadd
        //   448: iload 9
        //   450: i2f
        //   451: fcmpl
        //   452: ifle +943 -> 1395
        //   455: iload 9
        //   457: i2f
        //   458: fload 4
        //   460: fsub
        //   461: fstore_2
        //   462: aload 17
        //   464: ldc 195
        //   466: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   469: fload_1
        //   470: invokestatic 204	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
        //   473: fstore 5
        //   475: aload 17
        //   477: ldc 206
        //   479: invokevirtual 198	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   482: fload_2
        //   483: invokestatic 204	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
        //   486: fstore 6
        //   488: fload_3
        //   489: f2i
        //   490: iflt +50 -> 540
        //   493: fload 4
        //   495: f2i
        //   496: iflt +44 -> 540
        //   499: fload_1
        //   500: f2i
        //   501: ifle +39 -> 540
        //   504: fload_2
        //   505: f2i
        //   506: ifle +34 -> 540
        //   509: fload_3
        //   510: fload_1
        //   511: fadd
        //   512: f2i
        //   513: iload 8
        //   515: if_icmpgt +25 -> 540
        //   518: fload 4
        //   520: fload_2
        //   521: fadd
        //   522: f2i
        //   523: iload 9
        //   525: if_icmpgt +15 -> 540
        //   528: fload 5
        //   530: f2i
        //   531: ifle +9 -> 540
        //   534: fload 6
        //   536: f2i
        //   537: ifgt +157 -> 694
        //   540: ldc 55
        //   542: ldc 208
        //   544: iconst_5
        //   545: anewarray 4	java/lang/Object
        //   548: dup
        //   549: iconst_0
        //   550: fload_3
        //   551: invokestatic 213	java/lang/Float:valueOf	(F)Ljava/lang/Float;
        //   554: aastore
        //   555: dup
        //   556: iconst_1
        //   557: fload 4
        //   559: invokestatic 213	java/lang/Float:valueOf	(F)Ljava/lang/Float;
        //   562: aastore
        //   563: dup
        //   564: iconst_2
        //   565: fload_1
        //   566: invokestatic 213	java/lang/Float:valueOf	(F)Ljava/lang/Float;
        //   569: aastore
        //   570: dup
        //   571: iconst_3
        //   572: fload_2
        //   573: invokestatic 213	java/lang/Float:valueOf	(F)Ljava/lang/Float;
        //   576: aastore
        //   577: dup
        //   578: iconst_4
        //   579: iload 7
        //   581: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   584: aastore
        //   585: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   588: aload 15
        //   590: aload 14
        //   592: ldc 218
        //   594: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   597: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   600: ldc 41
        //   602: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   605: return
        //   606: astore 12
        //   608: ldc 55
        //   610: ldc 220
        //   612: iconst_2
        //   613: anewarray 4	java/lang/Object
        //   616: dup
        //   617: iconst_0
        //   618: iload 7
        //   620: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   623: aastore
        //   624: dup
        //   625: iconst_1
        //   626: aload 12
        //   628: aastore
        //   629: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   632: aload 15
        //   634: aload 14
        //   636: ldc 222
        //   638: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   641: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   644: ldc 41
        //   646: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   649: return
        //   650: astore 12
        //   652: ldc 55
        //   654: ldc 224
        //   656: iconst_2
        //   657: anewarray 4	java/lang/Object
        //   660: dup
        //   661: iconst_0
        //   662: iload 7
        //   664: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   667: aastore
        //   668: dup
        //   669: iconst_1
        //   670: aload 12
        //   672: aastore
        //   673: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   676: aload 15
        //   678: aload 14
        //   680: ldc 222
        //   682: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   685: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   688: ldc 41
        //   690: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   693: return
        //   694: aload 12
        //   696: instanceof 226
        //   699: ifeq +254 -> 953
        //   702: aload 12
        //   704: checkcast 226	com/tencent/mm/plugin/appbrand/canvas/widget/a
        //   707: new 228	com/tencent/mm/plugin/appbrand/canvas/f
        //   710: dup
        //   711: aload 13
        //   713: invokespecial 231	com/tencent/mm/plugin/appbrand/canvas/f:<init>	(Landroid/graphics/Bitmap;)V
        //   716: invokeinterface 235 2 0
        //   721: pop
        //   722: fload_1
        //   723: iload 8
        //   725: i2f
        //   726: fcmpl
        //   727: ifne +15 -> 742
        //   730: aload 13
        //   732: astore 12
        //   734: fload_2
        //   735: iload 9
        //   737: i2f
        //   738: fcmpl
        //   739: ifeq +58 -> 797
        //   742: fload_3
        //   743: f2i
        //   744: istore 8
        //   746: fload 4
        //   748: f2i
        //   749: istore 9
        //   751: fload_1
        //   752: f2i
        //   753: istore 10
        //   755: fload_2
        //   756: f2i
        //   757: istore 11
        //   759: aload 13
        //   761: iload 8
        //   763: iload 9
        //   765: iload 10
        //   767: iload 11
        //   769: aconst_null
        //   770: iconst_0
        //   771: invokestatic 238	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
        //   774: astore 12
        //   776: ldc 55
        //   778: ldc 240
        //   780: iconst_1
        //   781: anewarray 4	java/lang/Object
        //   784: dup
        //   785: iconst_0
        //   786: aload 13
        //   788: aastore
        //   789: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   792: aload 13
        //   794: invokevirtual 245	android/graphics/Bitmap:recycle	()V
        //   797: fload_1
        //   798: fload 5
        //   800: fcmpl
        //   801: ifne +14 -> 815
        //   804: aload 12
        //   806: astore 13
        //   808: fload_2
        //   809: fload 6
        //   811: fcmpl
        //   812: ifeq +46 -> 858
        //   815: fload 5
        //   817: f2i
        //   818: istore 8
        //   820: fload 6
        //   822: f2i
        //   823: istore 9
        //   825: aload 12
        //   827: iload 8
        //   829: iload 9
        //   831: iconst_0
        //   832: invokestatic 249	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
        //   835: astore 13
        //   837: ldc 55
        //   839: ldc 240
        //   841: iconst_1
        //   842: anewarray 4	java/lang/Object
        //   845: dup
        //   846: iconst_0
        //   847: aload 12
        //   849: aastore
        //   850: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   853: aload 12
        //   855: invokevirtual 245	android/graphics/Bitmap:recycle	()V
        //   858: aload 17
        //   860: invokestatic 253	com/tencent/mm/plugin/appbrand/jsapi/c/d:ah	(Lorg/json/JSONObject;)Landroid/graphics/Bitmap$CompressFormat;
        //   863: astore 18
        //   865: aload 18
        //   867: getstatic 259	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   870: if_acmpne +276 -> 1146
        //   873: ldc_w 261
        //   876: astore 12
        //   878: aload 16
        //   880: invokeinterface 265 1 0
        //   885: new 267	java/lang/StringBuilder
        //   888: dup
        //   889: ldc_w 269
        //   892: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   895: iload 7
        //   897: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   900: ldc_w 277
        //   903: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   906: aload 12
        //   908: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   911: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   914: invokeinterface 290 2 0
        //   919: astore 19
        //   921: aload 19
        //   923: ifnonnull +231 -> 1154
        //   926: ldc 55
        //   928: ldc_w 292
        //   931: invokestatic 294	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   934: aload 15
        //   936: aload 14
        //   938: ldc_w 296
        //   941: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   944: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   947: ldc 41
        //   949: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   952: return
        //   953: aload 12
        //   955: new 228	com/tencent/mm/plugin/appbrand/canvas/f
        //   958: dup
        //   959: aload 13
        //   961: invokespecial 231	com/tencent/mm/plugin/appbrand/canvas/f:<init>	(Landroid/graphics/Bitmap;)V
        //   964: invokevirtual 300	android/view/View:draw	(Landroid/graphics/Canvas;)V
        //   967: goto -245 -> 722
        //   970: astore 12
        //   972: ldc 55
        //   974: ldc 220
        //   976: iconst_2
        //   977: anewarray 4	java/lang/Object
        //   980: dup
        //   981: iconst_0
        //   982: iload 7
        //   984: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   987: aastore
        //   988: dup
        //   989: iconst_1
        //   990: aload 12
        //   992: aastore
        //   993: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   996: aload 15
        //   998: aload 14
        //   1000: ldc 222
        //   1002: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1005: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1008: ldc 41
        //   1010: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1013: return
        //   1014: astore 12
        //   1016: ldc 55
        //   1018: ldc 224
        //   1020: iconst_2
        //   1021: anewarray 4	java/lang/Object
        //   1024: dup
        //   1025: iconst_0
        //   1026: iload 7
        //   1028: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1031: aastore
        //   1032: dup
        //   1033: iconst_1
        //   1034: aload 12
        //   1036: aastore
        //   1037: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1040: aload 15
        //   1042: aload 14
        //   1044: ldc 222
        //   1046: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1049: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1052: ldc 41
        //   1054: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1057: return
        //   1058: astore 12
        //   1060: ldc 55
        //   1062: ldc 220
        //   1064: iconst_2
        //   1065: anewarray 4	java/lang/Object
        //   1068: dup
        //   1069: iconst_0
        //   1070: iload 7
        //   1072: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1075: aastore
        //   1076: dup
        //   1077: iconst_1
        //   1078: aload 12
        //   1080: aastore
        //   1081: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1084: aload 15
        //   1086: aload 14
        //   1088: ldc 222
        //   1090: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1093: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1096: ldc 41
        //   1098: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1101: return
        //   1102: astore 12
        //   1104: ldc 55
        //   1106: ldc 224
        //   1108: iconst_2
        //   1109: anewarray 4	java/lang/Object
        //   1112: dup
        //   1113: iconst_0
        //   1114: iload 7
        //   1116: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1119: aastore
        //   1120: dup
        //   1121: iconst_1
        //   1122: aload 12
        //   1124: aastore
        //   1125: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1128: aload 15
        //   1130: aload 14
        //   1132: ldc 222
        //   1134: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1137: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1140: ldc 41
        //   1142: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1145: return
        //   1146: ldc_w 302
        //   1149: astore 12
        //   1151: goto -273 -> 878
        //   1154: aload 19
        //   1156: invokevirtual 308	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
        //   1159: invokestatic 314	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
        //   1162: astore 19
        //   1164: ldc 55
        //   1166: ldc_w 316
        //   1169: iconst_1
        //   1170: anewarray 4	java/lang/Object
        //   1173: dup
        //   1174: iconst_0
        //   1175: aload 19
        //   1177: aastore
        //   1178: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1181: aload 13
        //   1183: aload 17
        //   1185: invokestatic 323	com/tencent/mm/plugin/appbrand/jsapi/c/d:ag	(Lorg/json/JSONObject;)I
        //   1188: aload 18
        //   1190: aload 19
        //   1192: iconst_1
        //   1193: invokestatic 329	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   1196: pop
        //   1197: new 331	com/tencent/mm/plugin/appbrand/af/k
        //   1200: dup
        //   1201: invokespecial 332	com/tencent/mm/plugin/appbrand/af/k:<init>	()V
        //   1204: astore 13
        //   1206: aload 16
        //   1208: invokeinterface 265 1 0
        //   1213: new 304	com/tencent/mm/vfs/u
        //   1216: dup
        //   1217: aload 19
        //   1219: invokespecial 333	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
        //   1222: aload 12
        //   1224: iconst_1
        //   1225: aload 13
        //   1227: invokeinterface 336 5 0
        //   1232: pop
        //   1233: aload 13
        //   1235: getfield 340	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
        //   1238: checkcast 342	java/lang/String
        //   1241: astore 12
        //   1243: ldc 55
        //   1245: ldc_w 344
        //   1248: iconst_1
        //   1249: anewarray 4	java/lang/Object
        //   1252: dup
        //   1253: iconst_0
        //   1254: aload 12
        //   1256: aastore
        //   1257: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1260: new 346	java/util/HashMap
        //   1263: dup
        //   1264: invokespecial 347	java/util/HashMap:<init>	()V
        //   1267: astore 13
        //   1269: aload 13
        //   1271: ldc_w 349
        //   1274: aload 12
        //   1276: invokeinterface 355 3 0
        //   1281: pop
        //   1282: aload 15
        //   1284: aload 14
        //   1286: ldc_w 357
        //   1289: aload 13
        //   1291: invokevirtual 361	com/tencent/mm/plugin/appbrand/jsapi/c/d:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
        //   1294: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1297: ldc 41
        //   1299: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1302: return
        //   1303: astore 12
        //   1305: ldc 55
        //   1307: ldc_w 363
        //   1310: iconst_2
        //   1311: anewarray 4	java/lang/Object
        //   1314: dup
        //   1315: iconst_0
        //   1316: iload 7
        //   1318: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1321: aastore
        //   1322: dup
        //   1323: iconst_1
        //   1324: aload 12
        //   1326: aastore
        //   1327: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1330: aload 15
        //   1332: aload 14
        //   1334: ldc_w 365
        //   1337: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1340: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1343: ldc 41
        //   1345: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1348: return
        //   1349: astore 12
        //   1351: ldc 55
        //   1353: ldc_w 367
        //   1356: iconst_2
        //   1357: anewarray 4	java/lang/Object
        //   1360: dup
        //   1361: iconst_0
        //   1362: iload 7
        //   1364: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1367: aastore
        //   1368: dup
        //   1369: iconst_1
        //   1370: aload 12
        //   1372: aastore
        //   1373: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   1376: aload 15
        //   1378: aload 14
        //   1380: ldc_w 365
        //   1383: invokevirtual 69	com/tencent/mm/plugin/appbrand/jsapi/c/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
        //   1386: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/base/i:aal	(Ljava/lang/String;)V
        //   1389: ldc 41
        //   1391: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1394: return
        //   1395: goto -933 -> 462
        //   1398: goto -954 -> 444
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1401	0	this	1
        //   416	382	1	f1	float
        //   427	382	2	f2	float
        //   396	347	3	f3	float
        //   404	343	4	f4	float
        //   473	343	5	f5	float
        //   486	335	6	f6	float
        //   157	1206	7	i	int
        //   368	460	8	j	int
        //   375	455	9	k	int
        //   753	13	10	m	int
        //   757	11	11	n	int
        //   181	3	12	localView1	android.view.View
        //   225	82	12	localJSONException	org.json.JSONException
        //   319	52	12	localView2	android.view.View
        //   606	21	12	localException1	java.lang.Exception
        //   650	53	12	localObject1	Object
        //   732	222	12	localObject2	Object
        //   970	21	12	localException2	java.lang.Exception
        //   1014	21	12	localObject3	Object
        //   1058	21	12	localException3	java.lang.Exception
        //   1102	21	12	localObject4	Object
        //   1149	126	12	str	String
        //   1303	22	12	localIOException	java.io.IOException
        //   1349	22	12	localObject5	Object
        //   387	903	13	localObject6	Object
        //   125	1254	14	locald	d
        //   148	1229	15	locali	com.tencent.mm.plugin.appbrand.jsapi.base.i
        //   79	1128	16	localh	com.tencent.mm.plugin.appbrand.jsapi.h
        //   131	1053	17	localJSONObject	JSONObject
        //   863	326	18	localCompressFormat	Bitmap.CompressFormat
        //   919	299	19	localObject7	Object
        // Exception table:
        //   from	to	target	type
        //   150	159	225	org/json/JSONException
        //   377	389	606	java/lang/Exception
        //   377	389	650	finally
        //   759	797	970	java/lang/Exception
        //   759	797	1014	finally
        //   825	858	1058	java/lang/Exception
        //   825	858	1102	finally
        //   1181	1197	1303	java/io/IOException
        //   1181	1197	1349	finally
      }
    });
    AppMethodBeat.o(145531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.d
 * JD-Core Version:    0.7.0.1
 */