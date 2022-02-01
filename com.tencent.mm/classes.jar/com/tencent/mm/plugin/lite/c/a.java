package com.tencent.mm.plugin.lite.c;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  /* Error */
  public void invoke(java.lang.String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 16
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 24
    //   8: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11: ifne +18 -> 29
    //   14: aload_0
    //   15: getfield 34	com/tencent/mm/plugin/lite/c/a:mInvokeCallback	Lcom/tencent/mm/plugin/lite/jsapi/a$a;
    //   18: ldc 36
    //   20: invokevirtual 42	com/tencent/mm/plugin/lite/jsapi/a$a:Vc	(Ljava/lang/String;)V
    //   23: ldc 16
    //   25: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: new 47	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   36: astore 6
    //   38: aconst_null
    //   39: astore 5
    //   41: iconst_1
    //   42: istore 4
    //   44: new 50	android/content/Intent
    //   47: dup
    //   48: invokespecial 51	android/content/Intent:<init>	()V
    //   51: astore 7
    //   53: aload_2
    //   54: ldc 24
    //   56: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 8
    //   61: aload 8
    //   63: ldc 57
    //   65: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   68: ifne +11 -> 79
    //   71: aload 6
    //   73: ldc 64
    //   75: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: aload 8
    //   83: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc 70
    //   90: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   93: ifeq +413 -> 506
    //   96: aload_2
    //   97: ldc 70
    //   99: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   102: istore_3
    //   103: aload_2
    //   104: ldc 76
    //   106: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +11 -> 120
    //   112: aload_2
    //   113: ldc 76
    //   115: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 5
    //   120: aload_2
    //   121: ldc 78
    //   123: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   126: ifeq +11 -> 137
    //   129: aload_2
    //   130: ldc 78
    //   132: invokevirtual 81	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   135: istore 4
    //   137: aload 7
    //   139: ldc 83
    //   141: aload_0
    //   142: aload_2
    //   143: invokevirtual 87	com/tencent/mm/plugin/lite/c/a:getAnimIn	(Lorg/json/JSONObject;)I
    //   146: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   149: pop
    //   150: aload 7
    //   152: ldc 93
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 96	com/tencent/mm/plugin/lite/c/a:getAnimOut	(Lorg/json/JSONObject;)I
    //   159: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   162: pop
    //   163: iload 4
    //   165: ifeq +195 -> 360
    //   168: aload 6
    //   170: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: ldc 102
    //   175: invokevirtual 106	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +297 -> 475
    //   181: aload 6
    //   183: ldc 108
    //   185: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 6
    //   191: ldc 110
    //   193: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: getstatic 116	com/tencent/mm/protocal/d:DEVICE_NAME	Ljava/lang/String;
    //   199: ldc 118
    //   201: invokestatic 124	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 6
    //   210: ldc 126
    //   212: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 6
    //   218: ldc 128
    //   220: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: getstatic 133	android/os/Build:BRAND	Ljava/lang/String;
    //   226: ldc 118
    //   228: invokestatic 124	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: ldc 135
    //   239: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: getstatic 138	android/os/Build:MODEL	Ljava/lang/String;
    //   245: ldc 118
    //   247: invokestatic 124	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: ldc 140
    //   258: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 142
    //   263: aload_1
    //   264: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   267: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   270: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: ldc 151
    //   278: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: astore_1
    //   282: invokestatic 157	com/tencent/mm/kernel/g:agP	()Lcom/tencent/mm/kernel/a;
    //   285: pop
    //   286: aload_1
    //   287: invokestatic 162	com/tencent/mm/kernel/a:afE	()Ljava/lang/String;
    //   290: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: ldc 164
    //   298: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: getstatic 168	com/tencent/mm/protocal/d:DIc	I
    //   304: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: ldc 173
    //   312: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:eUO	()Ljava/lang/String;
    //   318: ldc 118
    //   320: invokestatic 124	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   323: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 6
    //   329: ldc 180
    //   331: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: getstatic 183	com/tencent/mm/protocal/d:DHY	Ljava/lang/String;
    //   337: ldc 118
    //   339: invokestatic 124	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 6
    //   348: ldc 185
    //   350: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokestatic 190	com/tencent/mm/sdk/platformtools/bs:eWc	()Ljava/lang/String;
    //   356: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 7
    //   362: ldc 192
    //   364: aload 6
    //   366: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   372: pop
    //   373: aload 7
    //   375: ldc 197
    //   377: iconst_0
    //   378: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   381: pop
    //   382: aload 7
    //   384: ldc 202
    //   386: iload_3
    //   387: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   390: pop
    //   391: aload 7
    //   393: ldc 204
    //   395: aload 5
    //   397: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   400: pop
    //   401: aload 7
    //   403: ldc 206
    //   405: ldc 208
    //   407: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   410: pop
    //   411: aload 7
    //   413: ldc 210
    //   415: ldc 208
    //   417: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   420: pop
    //   421: aload 7
    //   423: ldc 211
    //   425: invokevirtual 215	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   428: pop
    //   429: invokestatic 221	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   432: ldc 223
    //   434: ldc 225
    //   436: aload 7
    //   438: invokestatic 231	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   441: ldc 16
    //   443: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: return
    //   447: astore_1
    //   448: ldc 233
    //   450: aload_1
    //   451: ldc 235
    //   453: iconst_0
    //   454: anewarray 237	java/lang/Object
    //   457: invokestatic 243	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload_0
    //   461: getfield 34	com/tencent/mm/plugin/lite/c/a:mInvokeCallback	Lcom/tencent/mm/plugin/lite/jsapi/a$a;
    //   464: ldc 245
    //   466: invokevirtual 42	com/tencent/mm/plugin/lite/jsapi/a$a:Vc	(Ljava/lang/String;)V
    //   469: ldc 16
    //   471: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: aload 6
    //   477: ldc 102
    //   479: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: goto -294 -> 189
    //   486: astore_1
    //   487: goto -141 -> 346
    //   490: astore_1
    //   491: goto -164 -> 327
    //   494: astore_2
    //   495: goto -241 -> 254
    //   498: astore_2
    //   499: goto -264 -> 235
    //   502: astore_2
    //   503: goto -295 -> 208
    //   506: iconst_0
    //   507: istore_3
    //   508: goto -405 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	a
    //   0	511	1	paramString	java.lang.String
    //   0	511	2	paramJSONObject	org.json.JSONObject
    //   102	406	3	i	int
    //   42	122	4	bool	boolean
    //   39	357	5	str1	java.lang.String
    //   36	440	6	localStringBuilder	java.lang.StringBuilder
    //   51	386	7	localIntent	android.content.Intent
    //   59	23	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   53	79	447	org/json/JSONException
    //   79	103	447	org/json/JSONException
    //   103	120	447	org/json/JSONException
    //   120	137	447	org/json/JSONException
    //   137	163	447	org/json/JSONException
    //   327	346	486	java/lang/Exception
    //   308	327	490	java/lang/Exception
    //   235	254	494	java/lang/Exception
    //   216	235	498	java/lang/Exception
    //   189	208	502	java/lang/Exception
  }
  
  public int runModel()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.a
 * JD-Core Version:    0.7.0.1
 */