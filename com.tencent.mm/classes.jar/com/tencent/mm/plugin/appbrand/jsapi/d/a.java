package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import java.lang.ref.WeakReference;

abstract class a<P extends f>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.page.v>
{
  protected static void T(int paramInt, String paramString)
  {
    com.tencent.mm.model.v.aae().z("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).ai("passing_data", paramString);
  }
  
  protected static void a(int paramInt, com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    if (paramv == null) {
      return;
    }
    com.tencent.mm.model.v.aae().z("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).i("webview_reference", new WeakReference(paramv));
  }
  
  protected static String ob(int paramInt)
  {
    return com.tencent.mm.model.v.aae().z("AppBrandJsInput@".concat(String.valueOf(paramInt)), true).getString("passing_data", "");
  }
  
  /* Error */
  protected boolean a(P paramP, org.json.JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.v paramv, int paramInt)
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
    //   20: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   23: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: putfield 95	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqI	Ljava/lang/Integer;
    //   29: aload_1
    //   30: aload 5
    //   32: ldc 97
    //   34: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   37: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: putfield 100	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqJ	Ljava/lang/Integer;
    //   43: aload_1
    //   44: aload 5
    //   46: ldc 102
    //   48: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   51: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: putfield 105	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqK	Ljava/lang/Integer;
    //   57: aload_1
    //   58: aload 5
    //   60: ldc 107
    //   62: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   65: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putfield 110	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqL	Ljava/lang/Integer;
    //   71: aload 5
    //   73: ifnonnull +78 -> 151
    //   76: aload_0
    //   77: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/d/a:aCZ	()Z
    //   80: ifne +264 -> 344
    //   83: ldc 116
    //   85: ldc 118
    //   87: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: iload 4
    //   93: aload_0
    //   94: ldc 126
    //   96: aconst_null
    //   97: invokevirtual 132	com/tencent/mm/plugin/appbrand/jsapi/m:j	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   100: invokevirtual 137	com/tencent/mm/plugin/appbrand/page/v:h	(ILjava/lang/String;)V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_0
    //   111: invokevirtual 114	com/tencent/mm/plugin/appbrand/jsapi/d/a:aCZ	()Z
    //   114: ifne -43 -> 71
    //   117: ldc 116
    //   119: ldc 139
    //   121: iconst_1
    //   122: anewarray 141	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload 6
    //   129: invokestatic 147	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_3
    //   137: iload 4
    //   139: aload_0
    //   140: ldc 126
    //   142: aconst_null
    //   143: invokevirtual 132	com/tencent/mm/plugin/appbrand/jsapi/m:j	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   146: invokevirtual 137	com/tencent/mm/plugin/appbrand/page/v:h	(ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: aload 5
    //   154: ldc 152
    //   156: aconst_null
    //   157: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   160: putfield 159	com/tencent/mm/plugin/appbrand/widget/input/d/f:hfd	Ljava/lang/String;
    //   163: aload_1
    //   164: aload 5
    //   166: ldc 161
    //   168: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   171: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: putfield 164	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqM	Ljava/lang/Integer;
    //   177: aload_1
    //   178: aload 5
    //   180: ldc 166
    //   182: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   185: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: putfield 169	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqN	Ljava/lang/Integer;
    //   191: aload_1
    //   192: aload 5
    //   194: ldc 171
    //   196: aconst_null
    //   197: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 174	com/tencent/mm/plugin/appbrand/widget/input/d/f:hfl	Ljava/lang/String;
    //   203: aload_1
    //   204: aload 5
    //   206: ldc 176
    //   208: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: ldc 177
    //   213: invokestatic 181	com/tencent/mm/plugin/appbrand/s/g:bA	(Ljava/lang/String;I)I
    //   216: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: putfield 184	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqP	Ljava/lang/Integer;
    //   222: aload_1
    //   223: aload 5
    //   225: ldc 186
    //   227: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 181	com/tencent/mm/plugin/appbrand/s/g:bA	(Ljava/lang/String;I)I
    //   234: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: putfield 189	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqO	Ljava/lang/Integer;
    //   240: aload_1
    //   241: aload 5
    //   243: ldc 191
    //   245: invokestatic 194	com/tencent/mm/plugin/appbrand/s/g:i	(Lorg/json/JSONObject;Ljava/lang/String;)F
    //   248: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   251: putfield 203	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqQ	Ljava/lang/Float;
    //   254: aload_1
    //   255: aload 5
    //   257: ldc 205
    //   259: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   262: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: putfield 208	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrc	Ljava/lang/Integer;
    //   268: aload_1
    //   269: aload 5
    //   271: ldc 210
    //   273: invokevirtual 214	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: invokestatic 220	com/tencent/mm/plugin/appbrand/widget/input/d/d:bk	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   279: putfield 223	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrg	Ljava/lang/Integer;
    //   282: aload_1
    //   283: getfield 223	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrg	Ljava/lang/Integer;
    //   286: ifnull +20 -> 306
    //   289: aload_1
    //   290: aload_1
    //   291: getfield 223	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrg	Ljava/lang/Integer;
    //   294: invokevirtual 227	java/lang/Integer:intValue	()I
    //   297: invokestatic 231	com/tencent/mm/plugin/appbrand/s/g:pO	(I)I
    //   300: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: putfield 223	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrg	Ljava/lang/Integer;
    //   306: aload_1
    //   307: aload 5
    //   309: ldc 233
    //   311: invokevirtual 214	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: invokestatic 220	com/tencent/mm/plugin/appbrand/widget/input/d/d:bk	(Ljava/lang/Object;)Ljava/lang/Integer;
    //   317: putfield 236	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrh	Ljava/lang/Integer;
    //   320: aload_1
    //   321: getfield 236	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrh	Ljava/lang/Integer;
    //   324: ifnull +20 -> 344
    //   327: aload_1
    //   328: aload_1
    //   329: getfield 236	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrh	Ljava/lang/Integer;
    //   332: invokevirtual 227	java/lang/Integer:intValue	()I
    //   335: invokestatic 231	com/tencent/mm/plugin/appbrand/s/g:pO	(I)I
    //   338: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: putfield 236	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrh	Ljava/lang/Integer;
    //   344: aload_1
    //   345: aload_2
    //   346: ldc 238
    //   348: invokevirtual 242	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   351: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: putfield 251	com/tencent/mm/plugin/appbrand/widget/input/d/f:jra	Ljava/lang/Boolean;
    //   357: aload_1
    //   358: aload_2
    //   359: ldc 253
    //   361: aload_2
    //   362: ldc 255
    //   364: aconst_null
    //   365: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   368: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   371: putfield 258	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqH	Ljava/lang/String;
    //   374: aload_1
    //   375: aload_2
    //   376: ldc_w 260
    //   379: invokevirtual 264	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   382: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: putfield 267	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqR	Ljava/lang/Integer;
    //   388: aload_1
    //   389: aload_2
    //   390: ldc_w 269
    //   393: invokevirtual 271	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: putfield 274	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqS	Ljava/lang/String;
    //   399: new 69	org/json/JSONObject
    //   402: dup
    //   403: aload_2
    //   404: ldc_w 276
    //   407: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   413: astore_3
    //   414: aload_1
    //   415: aload_3
    //   416: ldc 176
    //   418: invokevirtual 73	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   421: invokestatic 279	com/tencent/mm/plugin/appbrand/s/g:Fn	(Ljava/lang/String;)I
    //   424: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   427: putfield 282	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqV	Ljava/lang/Integer;
    //   430: aload_1
    //   431: aload_3
    //   432: ldc 191
    //   434: invokestatic 84	com/tencent/mm/plugin/appbrand/s/g:g	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   437: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: putfield 285	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqU	Ljava/lang/Integer;
    //   443: aload_1
    //   444: aload_3
    //   445: ldc 152
    //   447: ldc_w 287
    //   450: invokevirtual 155	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   453: putfield 290	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqT	Ljava/lang/String;
    //   456: aload_1
    //   457: aload_2
    //   458: ldc_w 292
    //   461: invokevirtual 242	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   464: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   467: putfield 295	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqX	Ljava/lang/Boolean;
    //   470: aload_1
    //   471: aload_2
    //   472: ldc_w 297
    //   475: invokevirtual 242	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   478: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   481: putfield 300	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqW	Ljava/lang/Boolean;
    //   484: aload_1
    //   485: aload_2
    //   486: ldc_w 302
    //   489: invokevirtual 242	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   492: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   495: putfield 305	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrb	Ljava/lang/Boolean;
    //   498: aload_1
    //   499: aload_2
    //   500: ldc_w 307
    //   503: invokevirtual 271	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokestatic 313	com/tencent/mm/plugin/appbrand/widget/input/d/b:FP	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   509: putfield 317	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrd	Lcom/tencent/mm/plugin/appbrand/widget/input/d/b;
    //   512: aload_1
    //   513: aload_2
    //   514: ldc_w 319
    //   517: invokevirtual 242	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   520: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   523: putfield 322	com/tencent/mm/plugin/appbrand/widget/input/d/f:jre	Ljava/lang/Boolean;
    //   526: aload_1
    //   527: aload_2
    //   528: ldc_w 324
    //   531: invokevirtual 214	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   534: invokestatic 330	com/tencent/mm/plugin/appbrand/t/l:bv	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   537: putfield 333	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrf	Ljava/lang/Boolean;
    //   540: iconst_1
    //   541: ireturn
    //   542: astore_3
    //   543: aload_1
    //   544: aconst_null
    //   545: putfield 208	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrc	Ljava/lang/Integer;
    //   548: goto -280 -> 268
    //   551: astore_3
    //   552: aload_1
    //   553: aconst_null
    //   554: putfield 295	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqX	Ljava/lang/Boolean;
    //   557: goto -87 -> 470
    //   560: astore_3
    //   561: aload_1
    //   562: aconst_null
    //   563: putfield 300	com/tencent/mm/plugin/appbrand/widget/input/d/f:jqW	Ljava/lang/Boolean;
    //   566: goto -82 -> 484
    //   569: astore_3
    //   570: aload_1
    //   571: aconst_null
    //   572: putfield 305	com/tencent/mm/plugin/appbrand/widget/input/d/f:jrb	Ljava/lang/Boolean;
    //   575: goto -77 -> 498
    //   578: astore_3
    //   579: aload_1
    //   580: aconst_null
    //   581: putfield 322	com/tencent/mm/plugin/appbrand/widget/input/d/f:jre	Ljava/lang/Boolean;
    //   584: goto -58 -> 526
    //   587: astore_3
    //   588: goto -132 -> 456
    //   591: astore_3
    //   592: goto -204 -> 388
    //   595: astore_3
    //   596: goto -239 -> 357
    //   599: astore_3
    //   600: goto -346 -> 254
    //   603: astore_3
    //   604: goto -364 -> 240
    //   607: astore_3
    //   608: goto -386 -> 222
    //   611: astore_3
    //   612: goto -421 -> 191
    //   615: astore_3
    //   616: goto -439 -> 177
    //   619: astore 6
    //   621: goto -511 -> 110
    //   624: astore 6
    //   626: goto -583 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	a
    //   0	629	1	paramP	P
    //   0	629	2	paramJSONObject	org.json.JSONObject
    //   0	629	3	paramv	com.tencent.mm.plugin.appbrand.page.v
    //   0	629	4	paramInt	int
    //   13	295	5	localJSONObject	org.json.JSONObject
    //   105	23	6	localException1	java.lang.Exception
    //   619	1	6	localException2	java.lang.Exception
    //   624	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	105	java/lang/Exception
    //   254	268	542	java/lang/Exception
    //   456	470	551	org/json/JSONException
    //   470	484	560	java/lang/Exception
    //   484	498	569	java/lang/Exception
    //   512	526	578	java/lang/Exception
    //   399	456	587	java/lang/Exception
    //   374	388	591	java/lang/Exception
    //   344	357	595	java/lang/Exception
    //   240	254	599	java/lang/Exception
    //   222	240	603	java/lang/Exception
    //   203	222	607	java/lang/Exception
    //   177	191	611	java/lang/Exception
    //   163	177	615	java/lang/Exception
    //   15	29	619	java/lang/Exception
    //   43	71	619	java/lang/Exception
    //   29	43	624	java/lang/Exception
  }
  
  protected boolean aCZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */