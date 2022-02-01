package com.tencent.mm.plugin.appbrand.jsapi.aa;

public final class f
{
  /* Error */
  public static void b(android.view.View paramView, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: ldc 11
    //   15: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_1
    //   20: ldc 22
    //   22: invokevirtual 28	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 34	com/tencent/mm/plugin/appbrand/y/g:VH	(Ljava/lang/String;)I
    //   28: istore 6
    //   30: aload_1
    //   31: ldc 36
    //   33: invokevirtual 28	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 34	com/tencent/mm/plugin/appbrand/y/g:VH	(Ljava/lang/String;)I
    //   39: istore 7
    //   41: aload_1
    //   42: ldc 38
    //   44: fconst_0
    //   45: invokestatic 42	com/tencent/mm/plugin/appbrand/y/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   48: fstore_2
    //   49: aload_1
    //   50: ldc 44
    //   52: fconst_0
    //   53: invokestatic 42	com/tencent/mm/plugin/appbrand/y/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   56: fstore_3
    //   57: iconst_4
    //   58: newarray float
    //   60: astore 9
    //   62: aload_1
    //   63: ldc 44
    //   65: invokevirtual 48	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   68: ifeq +332 -> 400
    //   71: aload_1
    //   72: ldc 44
    //   74: invokevirtual 52	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   77: astore 10
    //   79: aload 10
    //   81: ifnull +311 -> 392
    //   84: aload 10
    //   86: invokevirtual 58	org/json/JSONArray:length	()I
    //   89: ifle +303 -> 392
    //   92: iconst_0
    //   93: istore 5
    //   95: iload 5
    //   97: aload 10
    //   99: invokevirtual 58	org/json/JSONArray:length	()I
    //   102: if_icmpge +38 -> 140
    //   105: aload 10
    //   107: iload 5
    //   109: invokevirtual 62	org/json/JSONArray:getDouble	(I)D
    //   112: d2f
    //   113: fstore 4
    //   115: iload 5
    //   117: iconst_4
    //   118: if_icmpge +22 -> 140
    //   121: aload 9
    //   123: iload 5
    //   125: fload 4
    //   127: invokestatic 66	com/tencent/mm/plugin/appbrand/y/g:aJ	(F)F
    //   130: fastore
    //   131: iload 5
    //   133: iconst_1
    //   134: iadd
    //   135: istore 5
    //   137: goto -42 -> 95
    //   140: aload_0
    //   141: instanceof 68
    //   144: ifeq +271 -> 415
    //   147: aload_0
    //   148: checkcast 68	com/tencent/mm/plugin/appbrand/jsapi/aa/g
    //   151: astore 10
    //   153: aload 10
    //   155: iload 6
    //   157: invokeinterface 71 2 0
    //   162: aload 10
    //   164: iload 7
    //   166: invokeinterface 74 2 0
    //   171: aload 10
    //   173: fload_3
    //   174: invokeinterface 78 2 0
    //   179: aload 10
    //   181: fload_2
    //   182: invokeinterface 81 2 0
    //   187: aload 10
    //   189: aload 9
    //   191: invokeinterface 84 2 0
    //   196: iconst_1
    //   197: istore 6
    //   199: aload_1
    //   200: ldc 86
    //   202: invokevirtual 89	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   205: d2f
    //   206: fstore_2
    //   207: iload 6
    //   209: istore 5
    //   211: fload_2
    //   212: fconst_0
    //   213: fcmpl
    //   214: iflt +21 -> 235
    //   217: iload 6
    //   219: istore 5
    //   221: fload_2
    //   222: fconst_1
    //   223: fcmpg
    //   224: ifgt +11 -> 235
    //   227: aload_0
    //   228: fload_2
    //   229: invokevirtual 94	android/view/View:setAlpha	(F)V
    //   232: iconst_1
    //   233: istore 5
    //   235: aload_1
    //   236: ldc 96
    //   238: invokevirtual 99	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   241: astore 9
    //   243: aload 9
    //   245: ifnull +52 -> 297
    //   248: aload 9
    //   250: invokevirtual 58	org/json/JSONArray:length	()I
    //   253: iconst_4
    //   254: if_icmpne +43 -> 297
    //   257: aload 9
    //   259: iconst_0
    //   260: invokestatic 103	com/tencent/mm/plugin/appbrand/y/g:c	(Lorg/json/JSONArray;I)I
    //   263: istore 6
    //   265: aload 9
    //   267: iconst_1
    //   268: invokestatic 103	com/tencent/mm/plugin/appbrand/y/g:c	(Lorg/json/JSONArray;I)I
    //   271: istore 7
    //   273: aload 9
    //   275: iconst_2
    //   276: invokestatic 103	com/tencent/mm/plugin/appbrand/y/g:c	(Lorg/json/JSONArray;I)I
    //   279: istore 8
    //   281: aload_0
    //   282: aload 9
    //   284: iconst_3
    //   285: invokestatic 103	com/tencent/mm/plugin/appbrand/y/g:c	(Lorg/json/JSONArray;I)I
    //   288: iload 6
    //   290: iload 7
    //   292: iload 8
    //   294: invokevirtual 107	android/view/View:setPadding	(IIII)V
    //   297: aload_1
    //   298: ldc 109
    //   300: dconst_0
    //   301: invokevirtual 113	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   304: d2f
    //   305: fstore_2
    //   306: aload_1
    //   307: ldc 115
    //   309: dconst_1
    //   310: invokevirtual 113	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   313: d2f
    //   314: fstore_3
    //   315: aload_1
    //   316: ldc 117
    //   318: dconst_1
    //   319: invokevirtual 113	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   322: d2f
    //   323: fstore 4
    //   325: aload_1
    //   326: ldc 109
    //   328: invokevirtual 48	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   331: ifeq +11 -> 342
    //   334: aload_0
    //   335: fload_2
    //   336: invokevirtual 120	android/view/View:setRotation	(F)V
    //   339: iconst_1
    //   340: istore 5
    //   342: aload_1
    //   343: ldc 115
    //   345: invokevirtual 48	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   348: ifeq +11 -> 359
    //   351: aload_0
    //   352: fload_3
    //   353: invokevirtual 123	android/view/View:setScaleX	(F)V
    //   356: iconst_1
    //   357: istore 5
    //   359: aload_1
    //   360: ldc 117
    //   362: invokevirtual 48	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   365: ifeq +12 -> 377
    //   368: aload_0
    //   369: fload 4
    //   371: invokevirtual 126	android/view/View:setScaleY	(F)V
    //   374: iconst_1
    //   375: istore 5
    //   377: iload 5
    //   379: ifeq +7 -> 386
    //   382: aload_0
    //   383: invokevirtual 130	android/view/View:invalidate	()V
    //   386: ldc 11
    //   388: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: return
    //   392: aconst_null
    //   393: astore 9
    //   395: goto -255 -> 140
    //   398: astore 9
    //   400: aconst_null
    //   401: astore 9
    //   403: goto -263 -> 140
    //   406: astore 9
    //   408: iload 6
    //   410: istore 5
    //   412: goto -177 -> 235
    //   415: iconst_0
    //   416: istore 6
    //   418: goto -219 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramView	android.view.View
    //   0	421	1	paramJSONObject	org.json.JSONObject
    //   48	288	2	f1	float
    //   56	297	3	f2	float
    //   113	257	4	f3	float
    //   93	318	5	i	int
    //   28	389	6	j	int
    //   39	252	7	k	int
    //   279	14	8	m	int
    //   60	334	9	localObject1	Object
    //   398	1	9	localException	java.lang.Exception
    //   401	1	9	localObject2	Object
    //   406	1	9	localJSONException	org.json.JSONException
    //   77	111	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	79	398	java/lang/Exception
    //   84	92	398	java/lang/Exception
    //   95	115	398	java/lang/Exception
    //   121	131	398	java/lang/Exception
    //   199	207	406	org/json/JSONException
    //   227	232	406	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.f
 * JD-Core Version:    0.7.0.1
 */