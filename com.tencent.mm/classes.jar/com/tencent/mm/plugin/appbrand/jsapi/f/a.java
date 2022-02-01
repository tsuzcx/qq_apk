package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.page.z>
{
  protected static void a(int paramInt, com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    if (paramz == null) {
      return;
    }
    com.tencent.mm.model.z.aBG().F("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).k("webview_reference", new WeakReference(paramz));
  }
  
  protected static void ai(int paramInt, String paramString)
  {
    com.tencent.mm.model.z.aBG().F("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).aI("passing_data", paramString);
  }
  
  protected static String tg(int paramInt)
  {
    return com.tencent.mm.model.z.aBG().F("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).getString("passing_data", "");
  }
  
  /* Error */
  protected boolean a(P paramP, org.json.JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.z paramz, int paramInt)
  {
    // Byte code:
    //   0: new 69	org/json/JSONObject
    //   3: dup
    //   4: aload_2
    //   5: ldc 71
    //   7: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload_1
    //   16: aload 5
    //   18: ldc 78
    //   20: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 95	com/tencent/mm/plugin/appbrand/widget/input/d/f:noe	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 97
    //   34: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 100	com/tencent/mm/plugin/appbrand/widget/input/d/f:nof	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 102
    //   48: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 105	com/tencent/mm/plugin/appbrand/widget/input/d/f:nog	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 107
    //   62: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 110	com/tencent/mm/plugin/appbrand/widget/input/d/f:noh	Ljava/lang/Integer;
    //   71: aload 5
    //   73: ifnonnull +78 -> 151
    //   76: aload_0
    //   77: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/f/a:bld	()Z
    //   80: ifne +264 -> 344
    //   83: ldc 116
    //   85: ldc 118
    //   87: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: iload 4
    //   93: aload_0
    //   94: ldc 126
    //   96: aconst_null
    //   97: invokevirtual 131	com/tencent/mm/plugin/appbrand/jsapi/m:e	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   100: invokevirtual 136	com/tencent/mm/plugin/appbrand/page/z:h	(ILjava/lang/String;)V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_0
    //   111: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/f/a:bld	()Z
    //   114: ifne -43 -> 71
    //   117: ldc 116
    //   119: ldc 138
    //   121: iconst_1
    //   122: anewarray 140	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload 6
    //   129: invokestatic 146	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 149	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_3
    //   137: iload 4
    //   139: aload_0
    //   140: ldc 126
    //   142: aconst_null
    //   143: invokevirtual 131	com/tencent/mm/plugin/appbrand/jsapi/m:e	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   146: invokevirtual 136	com/tencent/mm/plugin/appbrand/page/z:h	(ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: aload 5
    //   154: ldc 151
    //   156: aconst_null
    //   157: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: putfield 158	com/tencent/mm/plugin/appbrand/widget/input/d/f:czp	Ljava/lang/String;
    //   163: aload_1
    //   164: aload 5
    //   166: ldc 160
    //   168: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   171: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: putfield 163	com/tencent/mm/plugin/appbrand/widget/input/d/f:noi	Ljava/lang/Integer;
    //   177: aload_1
    //   178: aload 5
    //   180: ldc 165
    //   182: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   185: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: putfield 168	com/tencent/mm/plugin/appbrand/widget/input/d/f:noj	Ljava/lang/Integer;
    //   191: aload_1
    //   192: aload 5
    //   194: ldc 170
    //   196: aconst_null
    //   197: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 173	com/tencent/mm/plugin/appbrand/widget/input/d/f:jWV	Ljava/lang/String;
    //   203: aload_1
    //   204: aload 5
    //   206: ldc 175
    //   208: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: ldc 176
    //   213: invokestatic 180	com/tencent/mm/plugin/appbrand/y/g:ck	(Ljava/lang/String;I)I
    //   216: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: putfield 183	com/tencent/mm/plugin/appbrand/widget/input/d/f:nol	Ljava/lang/Integer;
    //   222: aload_1
    //   223: aload 5
    //   225: ldc 185
    //   227: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 180	com/tencent/mm/plugin/appbrand/y/g:ck	(Ljava/lang/String;I)I
    //   234: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: putfield 188	com/tencent/mm/plugin/appbrand/widget/input/d/f:nok	Ljava/lang/Integer;
    //   240: aload_1
    //   241: aload 5
    //   243: ldc 190
    //   245: invokestatic 193	com/tencent/mm/plugin/appbrand/y/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   248: invokestatic 198	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   251: putfield 202	com/tencent/mm/plugin/appbrand/widget/input/d/f:nom	Ljava/lang/Float;
    //   254: aload_1
    //   255: aload 5
    //   257: ldc 204
    //   259: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   262: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: putfield 207	com/tencent/mm/plugin/appbrand/widget/input/d/f:noy	Ljava/lang/Integer;
    //   268: aload_1
    //   269: aload 5
    //   271: ldc 209
    //   273: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: invokestatic 219	com/tencent/mm/plugin/appbrand/widget/input/d/d:cx	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   279: putfield 222	com/tencent/mm/plugin/appbrand/widget/input/d/f:noC	Ljava/lang/Integer;
    //   282: aload_1
    //   283: getfield 222	com/tencent/mm/plugin/appbrand/widget/input/d/f:noC	Ljava/lang/Integer;
    //   286: ifnull +20 -> 306
    //   289: aload_1
    //   290: aload_1
    //   291: getfield 222	com/tencent/mm/plugin/appbrand/widget/input/d/f:noC	Ljava/lang/Integer;
    //   294: invokevirtual 226	java/lang/Integer:intValue	()I
    //   297: invokestatic 230	com/tencent/mm/plugin/appbrand/y/g:vO	(I)I
    //   300: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: putfield 222	com/tencent/mm/plugin/appbrand/widget/input/d/f:noC	Ljava/lang/Integer;
    //   306: aload_1
    //   307: aload 5
    //   309: ldc 232
    //   311: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: invokestatic 219	com/tencent/mm/plugin/appbrand/widget/input/d/d:cx	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   317: putfield 235	com/tencent/mm/plugin/appbrand/widget/input/d/f:noD	Ljava/lang/Integer;
    //   320: aload_1
    //   321: getfield 235	com/tencent/mm/plugin/appbrand/widget/input/d/f:noD	Ljava/lang/Integer;
    //   324: ifnull +20 -> 344
    //   327: aload_1
    //   328: aload_1
    //   329: getfield 235	com/tencent/mm/plugin/appbrand/widget/input/d/f:noD	Ljava/lang/Integer;
    //   332: invokevirtual 226	java/lang/Integer:intValue	()I
    //   335: invokestatic 230	com/tencent/mm/plugin/appbrand/y/g:vO	(I)I
    //   338: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: putfield 235	com/tencent/mm/plugin/appbrand/widget/input/d/f:noD	Ljava/lang/Integer;
    //   344: aload_1
    //   345: aload_2
    //   346: ldc 237
    //   348: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   351: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: putfield 250	com/tencent/mm/plugin/appbrand/widget/input/d/f:now	Ljava/lang/Boolean;
    //   357: aload_1
    //   358: aload_2
    //   359: ldc 252
    //   361: aload_2
    //   362: ldc 254
    //   364: aconst_null
    //   365: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   371: putfield 257	com/tencent/mm/plugin/appbrand/widget/input/d/f:nod	Ljava/lang/String;
    //   374: aload_1
    //   375: aload_2
    //   376: ldc_w 259
    //   379: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   382: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: putfield 266	com/tencent/mm/plugin/appbrand/widget/input/d/f:non	Ljava/lang/Integer;
    //   388: aload_2
    //   389: ldc_w 268
    //   392: invokevirtual 271	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   395: ifeq +176 -> 571
    //   398: aload_1
    //   399: aload_2
    //   400: ldc_w 268
    //   403: aconst_null
    //   404: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   407: putfield 274	com/tencent/mm/plugin/appbrand/widget/input/d/f:noo	Ljava/lang/String;
    //   410: getstatic 280	com/tencent/luggage/h/i:cre	Lcom/tencent/luggage/h/i;
    //   413: invokevirtual 283	com/tencent/luggage/h/i:isDarkMode	()Z
    //   416: ifeq +163 -> 579
    //   419: new 69	org/json/JSONObject
    //   422: dup
    //   423: aload_2
    //   424: ldc_w 285
    //   427: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   433: astore_3
    //   434: aload_1
    //   435: aload_3
    //   436: ldc 175
    //   438: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokestatic 288	com/tencent/mm/plugin/appbrand/y/g:VI	(Ljava/lang/String;)I
    //   444: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: putfield 291	com/tencent/mm/plugin/appbrand/widget/input/d/f:nor	Ljava/lang/Integer;
    //   450: aload_1
    //   451: aload_3
    //   452: ldc 190
    //   454: invokestatic 84	com/tencent/mm/plugin/appbrand/y/g:f	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   457: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: putfield 294	com/tencent/mm/plugin/appbrand/widget/input/d/f:noq	Ljava/lang/Integer;
    //   463: aload_1
    //   464: aload_3
    //   465: ldc 151
    //   467: ldc_w 296
    //   470: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   473: putfield 299	com/tencent/mm/plugin/appbrand/widget/input/d/f:nop	Ljava/lang/String;
    //   476: aload_1
    //   477: aload_2
    //   478: ldc_w 301
    //   481: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   484: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   487: putfield 304	com/tencent/mm/plugin/appbrand/widget/input/d/f:not	Ljava/lang/Boolean;
    //   490: aload_1
    //   491: aload_2
    //   492: ldc_w 306
    //   495: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   498: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   501: putfield 309	com/tencent/mm/plugin/appbrand/widget/input/d/f:nos	Ljava/lang/Boolean;
    //   504: aload_1
    //   505: aload_2
    //   506: ldc_w 311
    //   509: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   512: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   515: putfield 314	com/tencent/mm/plugin/appbrand/widget/input/d/f:nox	Ljava/lang/Boolean;
    //   518: aload_1
    //   519: aload_2
    //   520: ldc_w 316
    //   523: invokevirtual 318	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   526: invokestatic 324	com/tencent/mm/plugin/appbrand/widget/input/d/b:We	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   529: putfield 328	com/tencent/mm/plugin/appbrand/widget/input/d/f:noz	Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   532: aload_1
    //   533: aload_2
    //   534: ldc_w 330
    //   537: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   540: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   543: putfield 333	com/tencent/mm/plugin/appbrand/widget/input/d/f:noA	Ljava/lang/Boolean;
    //   546: aload_1
    //   547: aload_2
    //   548: ldc_w 335
    //   551: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   554: invokestatic 341	com/tencent/luggage/h/d:aD	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   557: putfield 344	com/tencent/mm/plugin/appbrand/widget/input/d/f:noB	Ljava/lang/Boolean;
    //   560: iconst_1
    //   561: ireturn
    //   562: astore_3
    //   563: aload_1
    //   564: aconst_null
    //   565: putfield 207	com/tencent/mm/plugin/appbrand/widget/input/d/f:noy	Ljava/lang/Integer;
    //   568: goto -300 -> 268
    //   571: aload_1
    //   572: aconst_null
    //   573: putfield 274	com/tencent/mm/plugin/appbrand/widget/input/d/f:noo	Ljava/lang/String;
    //   576: goto -166 -> 410
    //   579: new 69	org/json/JSONObject
    //   582: dup
    //   583: aload_2
    //   584: ldc_w 346
    //   587: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   593: astore_3
    //   594: goto -160 -> 434
    //   597: astore_3
    //   598: goto -122 -> 476
    //   601: astore_3
    //   602: aload_1
    //   603: aconst_null
    //   604: putfield 304	com/tencent/mm/plugin/appbrand/widget/input/d/f:not	Ljava/lang/Boolean;
    //   607: goto -117 -> 490
    //   610: astore_3
    //   611: aload_1
    //   612: aconst_null
    //   613: putfield 309	com/tencent/mm/plugin/appbrand/widget/input/d/f:nos	Ljava/lang/Boolean;
    //   616: goto -112 -> 504
    //   619: astore_3
    //   620: aload_1
    //   621: aconst_null
    //   622: putfield 314	com/tencent/mm/plugin/appbrand/widget/input/d/f:nox	Ljava/lang/Boolean;
    //   625: goto -107 -> 518
    //   628: astore_3
    //   629: aload_1
    //   630: aconst_null
    //   631: putfield 333	com/tencent/mm/plugin/appbrand/widget/input/d/f:noA	Ljava/lang/Boolean;
    //   634: goto -88 -> 546
    //   637: astore_3
    //   638: goto -250 -> 388
    //   641: astore_3
    //   642: goto -285 -> 357
    //   645: astore_3
    //   646: goto -392 -> 254
    //   649: astore_3
    //   650: goto -410 -> 240
    //   653: astore_3
    //   654: goto -432 -> 222
    //   657: astore_3
    //   658: goto -467 -> 191
    //   661: astore_3
    //   662: goto -485 -> 177
    //   665: astore 6
    //   667: goto -557 -> 110
    //   670: astore 6
    //   672: goto -629 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	a
    //   0	675	1	paramP	P
    //   0	675	2	paramJSONObject	org.json.JSONObject
    //   0	675	3	paramz	com.tencent.mm.plugin.appbrand.page.z
    //   0	675	4	paramInt	int
    //   13	295	5	localJSONObject	org.json.JSONObject
    //   105	23	6	localException1	java.lang.Exception
    //   665	1	6	localException2	java.lang.Exception
    //   670	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	105	java/lang/Exception
    //   254	268	562	java/lang/Exception
    //   410	434	597	java/lang/Exception
    //   434	476	597	java/lang/Exception
    //   579	594	597	java/lang/Exception
    //   476	490	601	org/json/JSONException
    //   490	504	610	java/lang/Exception
    //   504	518	619	java/lang/Exception
    //   532	546	628	java/lang/Exception
    //   374	388	637	java/lang/Exception
    //   344	357	641	java/lang/Exception
    //   240	254	645	java/lang/Exception
    //   222	240	649	java/lang/Exception
    //   203	222	653	java/lang/Exception
    //   177	191	657	java/lang/Exception
    //   163	177	661	java/lang/Exception
    //   15	29	665	java/lang/Exception
    //   43	71	665	java/lang/Exception
    //   29	43	670	java/lang/Exception
  }
  
  protected boolean bld()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a
 * JD-Core Version:    0.7.0.1
 */