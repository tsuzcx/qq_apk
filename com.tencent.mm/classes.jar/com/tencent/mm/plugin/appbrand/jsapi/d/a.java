package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  protected static void I(int paramInt, String paramString)
  {
    u.Hc().v("AppBrandJsInput@" + paramInt, true).S("passing_data", paramString);
  }
  
  protected static void a(int paramInt, q paramq)
  {
    if (paramq == null) {
      return;
    }
    u.Hc().v("AppBrandJsInput@" + paramInt, true).h("webview_reference", new WeakReference(paramq));
  }
  
  protected static String lr(int paramInt)
  {
    return u.Hc().v("AppBrandJsInput@" + paramInt, true).getString("passing_data", "");
  }
  
  protected static q ls(int paramInt)
  {
    Object localObject = u.Hc().ih("AppBrandJsInput@" + paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = (WeakReference)((u.b)localObject).get("webview_reference", null);
    if (localObject == null) {
      return null;
    }
    return (q)((WeakReference)localObject).get();
  }
  
  /* Error */
  protected boolean a(P paramP, org.json.JSONObject paramJSONObject, q paramq, int paramInt)
  {
    // Byte code:
    //   0: new 88	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: ldc 90
    //   7: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 94	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload_1
    //   16: aload 5
    //   18: ldc 96
    //   20: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 114	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyy	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 116
    //   34: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 119	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyz	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 121
    //   48: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 124	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyA	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 126
    //   62: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 129	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyB	Ljava/lang/Integer;
    //   71: aload 5
    //   73: ifnonnull +78 -> 151
    //   76: aload_0
    //   77: invokevirtual 133	com/tencent/mm/plugin/appbrand/jsapi/d/a:aiT	()Z
    //   80: ifne +264 -> 344
    //   83: ldc 135
    //   85: ldc 137
    //   87: invokestatic 143	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: iload 4
    //   93: aload_0
    //   94: ldc 145
    //   96: aconst_null
    //   97: invokevirtual 150	com/tencent/mm/plugin/appbrand/jsapi/i:h	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   100: invokevirtual 153	com/tencent/mm/plugin/appbrand/page/q:C	(ILjava/lang/String;)V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_0
    //   111: invokevirtual 133	com/tencent/mm/plugin/appbrand/jsapi/d/a:aiT	()Z
    //   114: ifne -43 -> 71
    //   117: ldc 135
    //   119: ldc 155
    //   121: iconst_1
    //   122: anewarray 157	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload 6
    //   129: invokestatic 163	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 166	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_3
    //   137: iload 4
    //   139: aload_0
    //   140: ldc 145
    //   142: aconst_null
    //   143: invokevirtual 150	com/tencent/mm/plugin/appbrand/jsapi/i:h	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   146: invokevirtual 153	com/tencent/mm/plugin/appbrand/page/q:C	(ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: aload 5
    //   154: ldc 168
    //   156: aconst_null
    //   157: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: putfield 175	com/tencent/mm/plugin/appbrand/widget/input/d/f:fLT	Ljava/lang/String;
    //   163: aload_1
    //   164: aload 5
    //   166: ldc 177
    //   168: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   171: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: putfield 180	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyC	Ljava/lang/Integer;
    //   177: aload_1
    //   178: aload 5
    //   180: ldc 182
    //   182: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   185: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: putfield 185	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyD	Ljava/lang/Integer;
    //   191: aload_1
    //   192: aload 5
    //   194: ldc 187
    //   196: aconst_null
    //   197: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 190	com/tencent/mm/plugin/appbrand/widget/input/d/f:fMb	Ljava/lang/String;
    //   203: aload_1
    //   204: aload 5
    //   206: ldc 192
    //   208: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: ldc 193
    //   213: invokestatic 197	com/tencent/mm/plugin/appbrand/u/h:bd	(Ljava/lang/String;I)I
    //   216: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: putfield 200	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyF	Ljava/lang/Integer;
    //   222: aload_1
    //   223: aload 5
    //   225: ldc 202
    //   227: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 197	com/tencent/mm/plugin/appbrand/u/h:bd	(Ljava/lang/String;I)I
    //   234: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: putfield 205	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyE	Ljava/lang/Integer;
    //   240: aload_1
    //   241: aload 5
    //   243: ldc 207
    //   245: invokestatic 211	com/tencent/mm/plugin/appbrand/u/h:k	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   248: invokestatic 216	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   251: putfield 220	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyG	Ljava/lang/Float;
    //   254: aload_1
    //   255: aload 5
    //   257: ldc 222
    //   259: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   262: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: putfield 225	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyS	Ljava/lang/Integer;
    //   268: aload_1
    //   269: aload 5
    //   271: ldc 227
    //   273: invokevirtual 231	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: invokestatic 237	com/tencent/mm/plugin/appbrand/widget/input/d/d:bf	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   279: putfield 240	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyW	Ljava/lang/Integer;
    //   282: aload_1
    //   283: getfield 240	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyW	Ljava/lang/Integer;
    //   286: ifnull +20 -> 306
    //   289: aload_1
    //   290: aload_1
    //   291: getfield 240	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyW	Ljava/lang/Integer;
    //   294: invokevirtual 244	java/lang/Integer:intValue	()I
    //   297: invokestatic 248	com/tencent/mm/plugin/appbrand/u/h:my	(I)I
    //   300: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: putfield 240	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyW	Ljava/lang/Integer;
    //   306: aload_1
    //   307: aload 5
    //   309: ldc 250
    //   311: invokevirtual 231	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: invokestatic 237	com/tencent/mm/plugin/appbrand/widget/input/d/d:bf	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   317: putfield 253	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyX	Ljava/lang/Integer;
    //   320: aload_1
    //   321: getfield 253	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyX	Ljava/lang/Integer;
    //   324: ifnull +20 -> 344
    //   327: aload_1
    //   328: aload_1
    //   329: getfield 253	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyX	Ljava/lang/Integer;
    //   332: invokevirtual 244	java/lang/Integer:intValue	()I
    //   335: invokestatic 248	com/tencent/mm/plugin/appbrand/u/h:my	(I)I
    //   338: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: putfield 253	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyX	Ljava/lang/Integer;
    //   344: aload_1
    //   345: aload_2
    //   346: ldc 255
    //   348: invokevirtual 259	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   351: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: putfield 268	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyQ	Ljava/lang/Boolean;
    //   357: aload_1
    //   358: aload_2
    //   359: ldc_w 270
    //   362: aload_2
    //   363: ldc_w 272
    //   366: aconst_null
    //   367: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   370: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   373: putfield 275	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyx	Ljava/lang/String;
    //   376: aload_1
    //   377: aload_2
    //   378: ldc_w 277
    //   381: invokevirtual 281	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   384: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: putfield 284	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyH	Ljava/lang/Integer;
    //   390: aload_1
    //   391: aload_2
    //   392: ldc_w 286
    //   395: invokevirtual 288	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: putfield 291	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyI	Ljava/lang/String;
    //   401: new 88	org/json/JSONObject
    //   404: dup
    //   405: aload_2
    //   406: ldc_w 293
    //   409: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokespecial 94	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   415: astore_3
    //   416: aload_1
    //   417: aload_3
    //   418: ldc 192
    //   420: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   423: invokestatic 298	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   426: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: putfield 301	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyL	Ljava/lang/Integer;
    //   432: aload_1
    //   433: aload_3
    //   434: ldc 207
    //   436: invokestatic 102	com/tencent/mm/plugin/appbrand/u/h:i	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   439: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: putfield 304	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyK	Ljava/lang/Integer;
    //   445: aload_1
    //   446: aload_3
    //   447: ldc 168
    //   449: ldc_w 306
    //   452: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   455: putfield 309	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyJ	Ljava/lang/String;
    //   458: aload_1
    //   459: aload_2
    //   460: ldc_w 311
    //   463: invokevirtual 259	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   466: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   469: putfield 314	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyN	Ljava/lang/Boolean;
    //   472: aload_1
    //   473: aload_2
    //   474: ldc_w 316
    //   477: invokevirtual 259	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   480: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   483: putfield 319	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyM	Ljava/lang/Boolean;
    //   486: aload_1
    //   487: aload_2
    //   488: ldc_w 321
    //   491: invokevirtual 259	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   494: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   497: putfield 324	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyR	Ljava/lang/Boolean;
    //   500: aload_1
    //   501: aload_2
    //   502: ldc_w 326
    //   505: invokevirtual 288	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: invokestatic 332	com/tencent/mm/plugin/appbrand/widget/input/d/b:xc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   511: putfield 336	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyT	Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   514: aload_1
    //   515: aload_2
    //   516: ldc_w 338
    //   519: invokevirtual 259	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   522: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   525: putfield 341	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyU	Ljava/lang/Boolean;
    //   528: aload_1
    //   529: aload_2
    //   530: ldc_w 343
    //   533: invokevirtual 231	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   536: invokestatic 349	com/tencent/mm/plugin/appbrand/v/h:aY	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   539: putfield 352	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyV	Ljava/lang/Boolean;
    //   542: iconst_1
    //   543: ireturn
    //   544: astore_3
    //   545: aload_1
    //   546: aconst_null
    //   547: putfield 225	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyS	Ljava/lang/Integer;
    //   550: goto -282 -> 268
    //   553: astore_3
    //   554: aload_1
    //   555: aconst_null
    //   556: putfield 314	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyN	Ljava/lang/Boolean;
    //   559: goto -87 -> 472
    //   562: astore_3
    //   563: aload_1
    //   564: aconst_null
    //   565: putfield 319	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyM	Ljava/lang/Boolean;
    //   568: goto -82 -> 486
    //   571: astore_3
    //   572: aload_1
    //   573: aconst_null
    //   574: putfield 324	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyR	Ljava/lang/Boolean;
    //   577: goto -77 -> 500
    //   580: astore_3
    //   581: aload_1
    //   582: aconst_null
    //   583: putfield 341	com/tencent/mm/plugin/appbrand/widget/input/d/f:hyU	Ljava/lang/Boolean;
    //   586: goto -58 -> 528
    //   589: astore_3
    //   590: goto -132 -> 458
    //   593: astore_3
    //   594: goto -204 -> 390
    //   597: astore_3
    //   598: goto -241 -> 357
    //   601: astore_3
    //   602: goto -348 -> 254
    //   605: astore_3
    //   606: goto -366 -> 240
    //   609: astore_3
    //   610: goto -388 -> 222
    //   613: astore_3
    //   614: goto -423 -> 191
    //   617: astore_3
    //   618: goto -441 -> 177
    //   621: astore 6
    //   623: goto -513 -> 110
    //   626: astore 6
    //   628: goto -585 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	a
    //   0	631	1	paramP	P
    //   0	631	2	paramJSONObject	org.json.JSONObject
    //   0	631	3	paramq	q
    //   0	631	4	paramInt	int
    //   13	295	5	localJSONObject	org.json.JSONObject
    //   105	23	6	localException1	java.lang.Exception
    //   621	1	6	localException2	java.lang.Exception
    //   626	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	105	java/lang/Exception
    //   254	268	544	java/lang/Exception
    //   458	472	553	org/json/JSONException
    //   472	486	562	java/lang/Exception
    //   486	500	571	java/lang/Exception
    //   514	528	580	java/lang/Exception
    //   401	458	589	java/lang/Exception
    //   376	390	593	java/lang/Exception
    //   344	357	597	java/lang/Exception
    //   240	254	601	java/lang/Exception
    //   222	240	605	java/lang/Exception
    //   203	222	609	java/lang/Exception
    //   177	191	613	java/lang/Exception
    //   163	177	617	java/lang/Exception
    //   15	29	621	java/lang/Exception
    //   43	71	621	java/lang/Exception
    //   29	43	626	java/lang/Exception
  }
  
  protected boolean aiT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */