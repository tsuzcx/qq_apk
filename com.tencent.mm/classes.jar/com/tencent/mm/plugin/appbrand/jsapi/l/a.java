package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.widget.input.e.f;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends c<com.tencent.mm.plugin.appbrand.page.ad>
{
  protected static String AL(int paramInt)
  {
    return com.tencent.mm.model.ad.bCb().M("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).getString("passing_data", "");
  }
  
  protected static void a(int paramInt, com.tencent.mm.plugin.appbrand.page.ad paramad)
  {
    if (paramad == null) {
      return;
    }
    com.tencent.mm.model.ad.bCb().M("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).q("webview_reference", new WeakReference(paramad));
  }
  
  protected static void ax(int paramInt, String paramString)
  {
    com.tencent.mm.model.ad.bCb().M("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).aY("passing_data", paramString);
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
    //   20: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 95	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLz	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 97
    //   34: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 100	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLA	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 102
    //   48: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 105	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLB	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 107
    //   62: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 110	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLC	Ljava/lang/Integer;
    //   71: aload 5
    //   73: ifnonnull +76 -> 149
    //   76: aload_0
    //   77: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/l/a:csl	()Z
    //   80: ifne +262 -> 342
    //   83: ldc 116
    //   85: ldc 118
    //   87: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: iload 4
    //   93: aload_0
    //   94: ldc 126
    //   96: invokevirtual 129	com/tencent/mm/plugin/appbrand/jsapi/l/a:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   99: invokevirtual 134	com/tencent/mm/plugin/appbrand/page/ad:callback	(ILjava/lang/String;)V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore 6
    //   106: aconst_null
    //   107: astore 5
    //   109: aload_0
    //   110: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/l/a:csl	()Z
    //   113: ifne -42 -> 71
    //   116: ldc 116
    //   118: ldc 136
    //   120: iconst_1
    //   121: anewarray 138	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 6
    //   128: invokestatic 144	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: iload 4
    //   138: aload_0
    //   139: ldc 126
    //   141: invokevirtual 129	com/tencent/mm/plugin/appbrand/jsapi/l/a:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual 134	com/tencent/mm/plugin/appbrand/page/ad:callback	(ILjava/lang/String;)V
    //   147: iconst_0
    //   148: ireturn
    //   149: aload_1
    //   150: aload 5
    //   152: ldc 149
    //   154: aconst_null
    //   155: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: putfield 156	com/tencent/mm/plugin/appbrand/widget/input/e/f:eJF	Ljava/lang/String;
    //   161: aload_1
    //   162: aload 5
    //   164: ldc 158
    //   166: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   169: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: putfield 161	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLD	Ljava/lang/Integer;
    //   175: aload_1
    //   176: aload 5
    //   178: ldc 163
    //   180: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   183: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: putfield 166	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLE	Ljava/lang/Integer;
    //   189: aload_1
    //   190: aload 5
    //   192: ldc 168
    //   194: aconst_null
    //   195: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: putfield 171	com/tencent/mm/plugin/appbrand/widget/input/e/f:qTN	Ljava/lang/String;
    //   201: aload_1
    //   202: aload 5
    //   204: ldc 173
    //   206: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   209: ldc 174
    //   211: invokestatic 178	com/tencent/mm/plugin/appbrand/af/i:dq	(Ljava/lang/String;I)I
    //   214: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: putfield 181	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLG	Ljava/lang/Integer;
    //   220: aload_1
    //   221: aload 5
    //   223: ldc 183
    //   225: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   228: iconst_0
    //   229: invokestatic 178	com/tencent/mm/plugin/appbrand/af/i:dq	(Ljava/lang/String;I)I
    //   232: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: putfield 186	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLF	Ljava/lang/Integer;
    //   238: aload_1
    //   239: aload 5
    //   241: ldc 188
    //   243: invokestatic 192	com/tencent/mm/plugin/appbrand/af/i:j	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   246: invokestatic 197	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   249: putfield 201	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLH	Ljava/lang/Float;
    //   252: aload_1
    //   253: aload 5
    //   255: ldc 203
    //   257: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   260: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: putfield 206	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLT	Ljava/lang/Integer;
    //   266: aload_1
    //   267: aload 5
    //   269: ldc 208
    //   271: invokevirtual 212	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   274: invokestatic 218	com/tencent/mm/plugin/appbrand/widget/input/e/d:ec	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   277: putfield 221	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLY	Ljava/lang/Integer;
    //   280: aload_1
    //   281: getfield 221	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLY	Ljava/lang/Integer;
    //   284: ifnull +20 -> 304
    //   287: aload_1
    //   288: aload_1
    //   289: getfield 221	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLY	Ljava/lang/Integer;
    //   292: invokevirtual 225	java/lang/Integer:intValue	()I
    //   295: invokestatic 229	com/tencent/mm/plugin/appbrand/af/i:DC	(I)I
    //   298: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: putfield 221	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLY	Ljava/lang/Integer;
    //   304: aload_1
    //   305: aload 5
    //   307: ldc 231
    //   309: invokevirtual 212	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   312: invokestatic 218	com/tencent/mm/plugin/appbrand/widget/input/e/d:ec	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   315: putfield 234	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLZ	Ljava/lang/Integer;
    //   318: aload_1
    //   319: getfield 234	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLZ	Ljava/lang/Integer;
    //   322: ifnull +20 -> 342
    //   325: aload_1
    //   326: aload_1
    //   327: getfield 234	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLZ	Ljava/lang/Integer;
    //   330: invokevirtual 225	java/lang/Integer:intValue	()I
    //   333: invokestatic 229	com/tencent/mm/plugin/appbrand/af/i:DC	(I)I
    //   336: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: putfield 234	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLZ	Ljava/lang/Integer;
    //   342: aload_1
    //   343: aload_2
    //   344: ldc 236
    //   346: invokevirtual 240	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   349: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   352: putfield 249	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLR	Ljava/lang/Boolean;
    //   355: aload_1
    //   356: aload_2
    //   357: ldc 251
    //   359: aload_2
    //   360: ldc 253
    //   362: aconst_null
    //   363: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   366: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   369: putfield 255	com/tencent/mm/plugin/appbrand/widget/input/e/f:defaultValue	Ljava/lang/String;
    //   372: aload_1
    //   373: aload_2
    //   374: ldc_w 257
    //   377: invokevirtual 261	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   380: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: putfield 264	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLI	Ljava/lang/Integer;
    //   386: aload_2
    //   387: ldc_w 266
    //   390: invokevirtual 269	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   393: ifeq +181 -> 574
    //   396: aload_1
    //   397: aload_2
    //   398: ldc_w 266
    //   401: aconst_null
    //   402: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   405: putfield 272	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLJ	Ljava/lang/String;
    //   408: getstatic 278	com/tencent/luggage/l/k:exm	Lcom/tencent/luggage/l/k;
    //   411: aload_3
    //   412: invokevirtual 282	com/tencent/mm/plugin/appbrand/page/ad:getAppId	()Ljava/lang/String;
    //   415: invokevirtual 285	com/tencent/luggage/l/k:fJ	(Ljava/lang/String;)Z
    //   418: ifeq +164 -> 582
    //   421: new 69	org/json/JSONObject
    //   424: dup
    //   425: aload_2
    //   426: ldc_w 287
    //   429: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   435: astore_3
    //   436: aload_1
    //   437: aload_3
    //   438: ldc 173
    //   440: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: invokestatic 290	com/tencent/mm/plugin/appbrand/af/i:agw	(Ljava/lang/String;)I
    //   446: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: putfield 293	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLM	Ljava/lang/Integer;
    //   452: aload_1
    //   453: aload_3
    //   454: ldc 188
    //   456: invokestatic 84	com/tencent/mm/plugin/appbrand/af/i:h	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   459: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: putfield 296	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLL	Ljava/lang/Integer;
    //   465: aload_1
    //   466: aload_3
    //   467: ldc 149
    //   469: ldc_w 298
    //   472: invokevirtual 152	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   475: putfield 301	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLK	Ljava/lang/String;
    //   478: aload_1
    //   479: aload_2
    //   480: ldc_w 303
    //   483: invokevirtual 240	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   486: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   489: putfield 306	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLO	Ljava/lang/Boolean;
    //   492: aload_1
    //   493: aload_2
    //   494: ldc_w 308
    //   497: invokevirtual 240	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   500: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   503: putfield 311	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLN	Ljava/lang/Boolean;
    //   506: aload_1
    //   507: aload_2
    //   508: ldc_w 313
    //   511: invokevirtual 240	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   514: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   517: putfield 316	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLS	Ljava/lang/Boolean;
    //   520: aload_1
    //   521: aload_2
    //   522: ldc_w 318
    //   525: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 326	com/tencent/mm/plugin/appbrand/widget/input/e/b:ahb	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/widget/input/e/b;
    //   531: putfield 330	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLU	Lcom/tencent/mm/plugin/appbrand/widget/input/e/b;
    //   534: aload_1
    //   535: aload_2
    //   536: ldc_w 332
    //   539: invokevirtual 240	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   542: invokestatic 245	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   545: putfield 335	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLV	Ljava/lang/Boolean;
    //   548: aload_1
    //   549: aload_2
    //   550: ldc_w 337
    //   553: invokevirtual 212	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   556: invokestatic 343	com/tencent/luggage/l/d:cf	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   559: putfield 346	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLW	Ljava/lang/Boolean;
    //   562: iconst_1
    //   563: ireturn
    //   564: astore 6
    //   566: aload_1
    //   567: aconst_null
    //   568: putfield 206	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLT	Ljava/lang/Integer;
    //   571: goto -305 -> 266
    //   574: aload_1
    //   575: aconst_null
    //   576: putfield 272	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLJ	Ljava/lang/String;
    //   579: goto -171 -> 408
    //   582: new 69	org/json/JSONObject
    //   585: dup
    //   586: aload_2
    //   587: ldc_w 348
    //   590: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   593: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   596: astore_3
    //   597: goto -161 -> 436
    //   600: astore_3
    //   601: goto -123 -> 478
    //   604: astore_3
    //   605: aload_1
    //   606: aconst_null
    //   607: putfield 306	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLO	Ljava/lang/Boolean;
    //   610: goto -118 -> 492
    //   613: astore_3
    //   614: aload_1
    //   615: aconst_null
    //   616: putfield 311	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLN	Ljava/lang/Boolean;
    //   619: goto -113 -> 506
    //   622: astore_3
    //   623: aload_1
    //   624: aconst_null
    //   625: putfield 316	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLS	Ljava/lang/Boolean;
    //   628: goto -108 -> 520
    //   631: astore_3
    //   632: aload_1
    //   633: aconst_null
    //   634: putfield 335	com/tencent/mm/plugin/appbrand/widget/input/e/f:uLV	Ljava/lang/Boolean;
    //   637: goto -89 -> 548
    //   640: astore 5
    //   642: goto -256 -> 386
    //   645: astore 5
    //   647: goto -292 -> 355
    //   650: astore 6
    //   652: goto -400 -> 252
    //   655: astore 6
    //   657: goto -419 -> 238
    //   660: astore 6
    //   662: goto -442 -> 220
    //   665: astore 6
    //   667: goto -478 -> 189
    //   670: astore 6
    //   672: goto -497 -> 175
    //   675: astore 6
    //   677: goto -568 -> 109
    //   680: astore 6
    //   682: goto -639 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	a
    //   0	685	1	paramP	P
    //   0	685	2	paramJSONObject	org.json.JSONObject
    //   0	685	3	paramad	com.tencent.mm.plugin.appbrand.page.ad
    //   0	685	4	paramInt	int
    //   13	293	5	localJSONObject	org.json.JSONObject
    //   640	1	5	localException1	java.lang.Exception
    //   645	1	5	localException2	java.lang.Exception
    //   104	23	6	localException3	java.lang.Exception
    //   564	1	6	localException4	java.lang.Exception
    //   650	1	6	localException5	java.lang.Exception
    //   655	1	6	localException6	java.lang.Exception
    //   660	1	6	localException7	java.lang.Exception
    //   665	1	6	localException8	java.lang.Exception
    //   670	1	6	localException9	java.lang.Exception
    //   675	1	6	localException10	java.lang.Exception
    //   680	1	6	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	104	java/lang/Exception
    //   252	266	564	java/lang/Exception
    //   408	436	600	java/lang/Exception
    //   436	478	600	java/lang/Exception
    //   582	597	600	java/lang/Exception
    //   478	492	604	org/json/JSONException
    //   492	506	613	java/lang/Exception
    //   506	520	622	java/lang/Exception
    //   534	548	631	java/lang/Exception
    //   372	386	640	java/lang/Exception
    //   342	355	645	java/lang/Exception
    //   238	252	650	java/lang/Exception
    //   220	238	655	java/lang/Exception
    //   201	220	660	java/lang/Exception
    //   175	189	665	java/lang/Exception
    //   161	175	670	java/lang/Exception
    //   15	29	675	java/lang/Exception
    //   43	71	675	java/lang/Exception
    //   29	43	680	java/lang/Exception
  }
  
  protected boolean csl()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a
 * JD-Core Version:    0.7.0.1
 */