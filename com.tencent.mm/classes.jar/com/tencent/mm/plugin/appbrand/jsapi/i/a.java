package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.widget.input.e.f;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends c<com.tencent.mm.plugin.appbrand.page.ad>
{
  protected static String Ay(int paramInt)
  {
    return com.tencent.mm.model.ad.beh().I("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).getString("passing_data", "");
  }
  
  protected static void a(int paramInt, com.tencent.mm.plugin.appbrand.page.ad paramad)
  {
    if (paramad == null) {
      return;
    }
    com.tencent.mm.model.ad.beh().I("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).k("webview_reference", new WeakReference(paramad));
  }
  
  protected static void an(int paramInt, String paramString)
  {
    com.tencent.mm.model.ad.beh().I("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).aO("passing_data", paramString);
  }
  
  /* Error */
  protected boolean a(P paramP, org.json.JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.ad paramad, int paramInt)
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
    //   20: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 95	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAj	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 97
    //   34: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 100	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAk	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 102
    //   48: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 105	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAl	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 107
    //   62: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 110	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAm	Ljava/lang/Integer;
    //   71: aload 5
    //   73: ifnonnull +78 -> 151
    //   76: aload_0
    //   77: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/i/a:bSg	()Z
    //   80: ifne +264 -> 344
    //   83: ldc 116
    //   85: ldc 118
    //   87: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: iload 4
    //   93: aload_0
    //   94: ldc 126
    //   96: aconst_null
    //   97: invokevirtual 131	com/tencent/mm/plugin/appbrand/jsapi/o:h	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   100: invokevirtual 136	com/tencent/mm/plugin/appbrand/page/ad:j	(ILjava/lang/String;)V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_0
    //   111: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/i/a:bSg	()Z
    //   114: ifne -43 -> 71
    //   117: ldc 116
    //   119: ldc 138
    //   121: iconst_1
    //   122: anewarray 140	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload 6
    //   129: invokestatic 146	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 149	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_3
    //   137: iload 4
    //   139: aload_0
    //   140: ldc 126
    //   142: aconst_null
    //   143: invokevirtual 131	com/tencent/mm/plugin/appbrand/jsapi/o:h	(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;
    //   146: invokevirtual 136	com/tencent/mm/plugin/appbrand/page/ad:j	(ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: aload 5
    //   154: ldc 151
    //   156: aconst_null
    //   157: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: putfield 158	com/tencent/mm/plugin/appbrand/widget/input/e/f:cOk	Ljava/lang/String;
    //   163: aload_1
    //   164: aload 5
    //   166: ldc 160
    //   168: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   171: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: putfield 163	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAn	Ljava/lang/Integer;
    //   177: aload_1
    //   178: aload 5
    //   180: ldc 165
    //   182: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   185: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: putfield 168	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAo	Ljava/lang/Integer;
    //   191: aload_1
    //   192: aload 5
    //   194: ldc 170
    //   196: aconst_null
    //   197: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 173	com/tencent/mm/plugin/appbrand/widget/input/e/f:nUc	Ljava/lang/String;
    //   203: aload_1
    //   204: aload 5
    //   206: ldc 175
    //   208: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: ldc 176
    //   213: invokestatic 180	com/tencent/mm/plugin/appbrand/ac/g:cO	(Ljava/lang/String;I)I
    //   216: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: putfield 183	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAq	Ljava/lang/Integer;
    //   222: aload_1
    //   223: aload 5
    //   225: ldc 185
    //   227: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 180	com/tencent/mm/plugin/appbrand/ac/g:cO	(Ljava/lang/String;I)I
    //   234: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: putfield 188	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAp	Ljava/lang/Integer;
    //   240: aload_1
    //   241: aload 5
    //   243: ldc 190
    //   245: invokestatic 193	com/tencent/mm/plugin/appbrand/ac/g:j	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   248: invokestatic 198	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   251: putfield 202	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAr	Ljava/lang/Float;
    //   254: aload_1
    //   255: aload 5
    //   257: ldc 204
    //   259: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   262: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: putfield 207	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAD	Ljava/lang/Integer;
    //   268: aload_1
    //   269: aload 5
    //   271: ldc 209
    //   273: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: invokestatic 219	com/tencent/mm/plugin/appbrand/widget/input/e/d:cH	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   279: putfield 222	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAI	Ljava/lang/Integer;
    //   282: aload_1
    //   283: getfield 222	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAI	Ljava/lang/Integer;
    //   286: ifnull +20 -> 306
    //   289: aload_1
    //   290: aload_1
    //   291: getfield 222	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAI	Ljava/lang/Integer;
    //   294: invokevirtual 226	java/lang/Integer:intValue	()I
    //   297: invokestatic 230	com/tencent/mm/plugin/appbrand/ac/g:Di	(I)I
    //   300: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: putfield 222	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAI	Ljava/lang/Integer;
    //   306: aload_1
    //   307: aload 5
    //   309: ldc 232
    //   311: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: invokestatic 219	com/tencent/mm/plugin/appbrand/widget/input/e/d:cH	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   317: putfield 235	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAJ	Ljava/lang/Integer;
    //   320: aload_1
    //   321: getfield 235	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAJ	Ljava/lang/Integer;
    //   324: ifnull +20 -> 344
    //   327: aload_1
    //   328: aload_1
    //   329: getfield 235	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAJ	Ljava/lang/Integer;
    //   332: invokevirtual 226	java/lang/Integer:intValue	()I
    //   335: invokestatic 230	com/tencent/mm/plugin/appbrand/ac/g:Di	(I)I
    //   338: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: putfield 235	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAJ	Ljava/lang/Integer;
    //   344: aload_1
    //   345: aload_2
    //   346: ldc 237
    //   348: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   351: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: putfield 250	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAB	Ljava/lang/Boolean;
    //   357: aload_1
    //   358: aload_2
    //   359: ldc 252
    //   361: aload_2
    //   362: ldc 254
    //   364: aconst_null
    //   365: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   371: putfield 257	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAi	Ljava/lang/String;
    //   374: aload_1
    //   375: aload_2
    //   376: ldc_w 259
    //   379: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   382: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: putfield 266	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAs	Ljava/lang/Integer;
    //   388: aload_2
    //   389: ldc_w 268
    //   392: invokevirtual 271	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   395: ifeq +181 -> 576
    //   398: aload_1
    //   399: aload_2
    //   400: ldc_w 268
    //   403: aconst_null
    //   404: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   407: putfield 274	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAt	Ljava/lang/String;
    //   410: getstatic 280	com/tencent/luggage/k/j:cEc	Lcom/tencent/luggage/k/j;
    //   413: aload_3
    //   414: invokevirtual 284	com/tencent/mm/plugin/appbrand/page/ad:getAppId	()Ljava/lang/String;
    //   417: invokevirtual 287	com/tencent/luggage/k/j:em	(Ljava/lang/String;)Z
    //   420: ifeq +164 -> 584
    //   423: new 69	org/json/JSONObject
    //   426: dup
    //   427: aload_2
    //   428: ldc_w 289
    //   431: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   437: astore_3
    //   438: aload_1
    //   439: aload_3
    //   440: ldc 175
    //   442: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: invokestatic 292	com/tencent/mm/plugin/appbrand/ac/g:ang	(Ljava/lang/String;)I
    //   448: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: putfield 295	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAw	Ljava/lang/Integer;
    //   454: aload_1
    //   455: aload_3
    //   456: ldc 190
    //   458: invokestatic 84	com/tencent/mm/plugin/appbrand/ac/g:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   461: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: putfield 298	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAv	Ljava/lang/Integer;
    //   467: aload_1
    //   468: aload_3
    //   469: ldc 151
    //   471: ldc_w 300
    //   474: invokevirtual 154	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   477: putfield 303	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAu	Ljava/lang/String;
    //   480: aload_1
    //   481: aload_2
    //   482: ldc_w 305
    //   485: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   488: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   491: putfield 308	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAy	Ljava/lang/Boolean;
    //   494: aload_1
    //   495: aload_2
    //   496: ldc_w 310
    //   499: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   502: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   505: putfield 313	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAx	Ljava/lang/Boolean;
    //   508: aload_1
    //   509: aload_2
    //   510: ldc_w 315
    //   513: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   516: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   519: putfield 318	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAC	Ljava/lang/Boolean;
    //   522: aload_1
    //   523: aload_2
    //   524: ldc_w 320
    //   527: invokevirtual 322	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokestatic 328	com/tencent/mm/plugin/appbrand/widget/input/e/b:anD	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/widget/input/e/b;
    //   533: putfield 332	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAE	Lcom/tencent/mm/plugin/appbrand/widget/input/e/b;
    //   536: aload_1
    //   537: aload_2
    //   538: ldc_w 334
    //   541: invokevirtual 241	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   544: invokestatic 246	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   547: putfield 337	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAF	Ljava/lang/Boolean;
    //   550: aload_1
    //   551: aload_2
    //   552: ldc_w 339
    //   555: invokevirtual 213	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   558: invokestatic 345	com/tencent/luggage/k/e:aJ	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   561: putfield 348	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAG	Ljava/lang/Boolean;
    //   564: iconst_1
    //   565: ireturn
    //   566: astore 6
    //   568: aload_1
    //   569: aconst_null
    //   570: putfield 207	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAD	Ljava/lang/Integer;
    //   573: goto -305 -> 268
    //   576: aload_1
    //   577: aconst_null
    //   578: putfield 274	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAt	Ljava/lang/String;
    //   581: goto -171 -> 410
    //   584: new 69	org/json/JSONObject
    //   587: dup
    //   588: aload_2
    //   589: ldc_w 350
    //   592: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   598: astore_3
    //   599: goto -161 -> 438
    //   602: astore_3
    //   603: goto -123 -> 480
    //   606: astore_3
    //   607: aload_1
    //   608: aconst_null
    //   609: putfield 308	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAy	Ljava/lang/Boolean;
    //   612: goto -118 -> 494
    //   615: astore_3
    //   616: aload_1
    //   617: aconst_null
    //   618: putfield 313	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAx	Ljava/lang/Boolean;
    //   621: goto -113 -> 508
    //   624: astore_3
    //   625: aload_1
    //   626: aconst_null
    //   627: putfield 318	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAC	Ljava/lang/Boolean;
    //   630: goto -108 -> 522
    //   633: astore_3
    //   634: aload_1
    //   635: aconst_null
    //   636: putfield 337	com/tencent/mm/plugin/appbrand/widget/input/e/f:rAF	Ljava/lang/Boolean;
    //   639: goto -89 -> 550
    //   642: astore 5
    //   644: goto -256 -> 388
    //   647: astore 5
    //   649: goto -292 -> 357
    //   652: astore 6
    //   654: goto -400 -> 254
    //   657: astore 6
    //   659: goto -419 -> 240
    //   662: astore 6
    //   664: goto -442 -> 222
    //   667: astore 6
    //   669: goto -478 -> 191
    //   672: astore 6
    //   674: goto -497 -> 177
    //   677: astore 6
    //   679: goto -569 -> 110
    //   682: astore 6
    //   684: goto -641 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	a
    //   0	687	1	paramP	P
    //   0	687	2	paramJSONObject	org.json.JSONObject
    //   0	687	3	paramad	com.tencent.mm.plugin.appbrand.page.ad
    //   0	687	4	paramInt	int
    //   13	295	5	localJSONObject	org.json.JSONObject
    //   642	1	5	localException1	java.lang.Exception
    //   647	1	5	localException2	java.lang.Exception
    //   105	23	6	localException3	java.lang.Exception
    //   566	1	6	localException4	java.lang.Exception
    //   652	1	6	localException5	java.lang.Exception
    //   657	1	6	localException6	java.lang.Exception
    //   662	1	6	localException7	java.lang.Exception
    //   667	1	6	localException8	java.lang.Exception
    //   672	1	6	localException9	java.lang.Exception
    //   677	1	6	localException10	java.lang.Exception
    //   682	1	6	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	105	java/lang/Exception
    //   254	268	566	java/lang/Exception
    //   410	438	602	java/lang/Exception
    //   438	480	602	java/lang/Exception
    //   584	599	602	java/lang/Exception
    //   480	494	606	org/json/JSONException
    //   494	508	615	java/lang/Exception
    //   508	522	624	java/lang/Exception
    //   536	550	633	java/lang/Exception
    //   374	388	642	java/lang/Exception
    //   344	357	647	java/lang/Exception
    //   240	254	652	java/lang/Exception
    //   222	240	657	java/lang/Exception
    //   203	222	662	java/lang/Exception
    //   177	191	667	java/lang/Exception
    //   163	177	672	java/lang/Exception
    //   15	29	677	java/lang/Exception
    //   43	71	677	java/lang/Exception
    //   29	43	682	java/lang/Exception
  }
  
  protected boolean bSg()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */