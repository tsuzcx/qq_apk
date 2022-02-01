package com.tencent.mm.plugin.lite.c;

import com.tencent.mm.plugin.lite.jsapi.a;

public class e
  extends a
{
  public final int cZP()
  {
    return 1;
  }
  
  /* Error */
  public final void j(java.lang.String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 26
    //   8: invokevirtual 32	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11: ifne +18 -> 29
    //   14: aload_0
    //   15: getfield 36	com/tencent/mm/plugin/lite/c/e:vko	Lcom/tencent/mm/plugin/lite/jsapi/a$a;
    //   18: ldc 38
    //   20: invokevirtual 44	com/tencent/mm/plugin/lite/jsapi/a$a:ZC	(Ljava/lang/String;)V
    //   23: ldc 18
    //   25: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: new 49	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   36: astore 6
    //   38: aconst_null
    //   39: astore 5
    //   41: iconst_1
    //   42: istore 4
    //   44: new 52	android/content/Intent
    //   47: dup
    //   48: invokespecial 53	android/content/Intent:<init>	()V
    //   51: astore 7
    //   53: aload_2
    //   54: ldc 26
    //   56: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 8
    //   61: aload 8
    //   63: ldc 59
    //   65: invokevirtual 64	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   68: ifne +11 -> 79
    //   71: aload 6
    //   73: ldc 66
    //   75: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: aload 8
    //   83: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc 72
    //   90: invokevirtual 32	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   93: ifeq +413 -> 506
    //   96: aload_2
    //   97: ldc 72
    //   99: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   102: istore_3
    //   103: aload_2
    //   104: ldc 78
    //   106: invokevirtual 32	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   109: ifeq +11 -> 120
    //   112: aload_2
    //   113: ldc 78
    //   115: invokevirtual 57	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 5
    //   120: aload_2
    //   121: ldc 80
    //   123: invokevirtual 32	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   126: ifeq +11 -> 137
    //   129: aload_2
    //   130: ldc 80
    //   132: invokevirtual 83	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   135: istore 4
    //   137: aload 7
    //   139: ldc 85
    //   141: aload_0
    //   142: aload_2
    //   143: invokevirtual 89	com/tencent/mm/plugin/lite/c/e:ay	(Lorg/json/JSONObject;)I
    //   146: invokevirtual 93	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   149: pop
    //   150: aload 7
    //   152: ldc 95
    //   154: aload_0
    //   155: aload_2
    //   156: invokevirtual 98	com/tencent/mm/plugin/lite/c/e:az	(Lorg/json/JSONObject;)I
    //   159: invokevirtual 93	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   162: pop
    //   163: iload 4
    //   165: ifeq +195 -> 360
    //   168: aload 6
    //   170: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: ldc 104
    //   175: invokevirtual 108	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +297 -> 475
    //   181: aload 6
    //   183: ldc 110
    //   185: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 6
    //   191: ldc 112
    //   193: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: getstatic 118	com/tencent/mm/protocal/d:DEVICE_NAME	Ljava/lang/String;
    //   199: ldc 120
    //   201: invokestatic 126	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 6
    //   210: ldc 128
    //   212: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 6
    //   218: ldc 130
    //   220: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: getstatic 135	android/os/Build:BRAND	Ljava/lang/String;
    //   226: ldc 120
    //   228: invokestatic 126	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: ldc 137
    //   239: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: getstatic 140	android/os/Build:MODEL	Ljava/lang/String;
    //   245: ldc 120
    //   247: invokestatic 126	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: ldc 142
    //   258: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 144
    //   263: aload_1
    //   264: invokestatic 148	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   267: invokevirtual 151	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   270: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 6
    //   276: ldc 153
    //   278: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: astore_1
    //   282: invokestatic 159	com/tencent/mm/kernel/g:ajP	()Lcom/tencent/mm/kernel/a;
    //   285: pop
    //   286: aload_1
    //   287: invokestatic 164	com/tencent/mm/kernel/a:aiF	()Ljava/lang/String;
    //   290: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: ldc 166
    //   298: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: getstatic 170	com/tencent/mm/protocal/d:FFH	I
    //   304: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: ldc 175
    //   312: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:fom	()Ljava/lang/String;
    //   318: ldc 120
    //   320: invokestatic 126	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   323: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 6
    //   329: ldc 182
    //   331: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: getstatic 185	com/tencent/mm/protocal/d:FFD	Ljava/lang/String;
    //   337: ldc 120
    //   339: invokestatic 126	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 6
    //   348: ldc 187
    //   350: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokestatic 192	com/tencent/mm/sdk/platformtools/bu:fpH	()Ljava/lang/String;
    //   356: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 7
    //   362: ldc 194
    //   364: aload 6
    //   366: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokevirtual 197	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   372: pop
    //   373: aload 7
    //   375: ldc 199
    //   377: iconst_0
    //   378: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   381: pop
    //   382: aload 7
    //   384: ldc 204
    //   386: iload_3
    //   387: invokevirtual 93	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   390: pop
    //   391: aload 7
    //   393: ldc 206
    //   395: aload 5
    //   397: invokevirtual 197	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   400: pop
    //   401: aload 7
    //   403: ldc 208
    //   405: ldc 210
    //   407: invokevirtual 197	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   410: pop
    //   411: aload 7
    //   413: ldc 212
    //   415: ldc 210
    //   417: invokevirtual 197	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   420: pop
    //   421: aload 7
    //   423: ldc 213
    //   425: invokevirtual 217	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   428: pop
    //   429: invokestatic 223	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   432: ldc 225
    //   434: ldc 227
    //   436: aload 7
    //   438: invokestatic 233	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   441: ldc 18
    //   443: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: return
    //   447: astore_1
    //   448: ldc 235
    //   450: aload_1
    //   451: ldc 237
    //   453: iconst_0
    //   454: anewarray 239	java/lang/Object
    //   457: invokestatic 245	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload_0
    //   461: getfield 36	com/tencent/mm/plugin/lite/c/e:vko	Lcom/tencent/mm/plugin/lite/jsapi/a$a;
    //   464: ldc 247
    //   466: invokevirtual 44	com/tencent/mm/plugin/lite/jsapi/a$a:ZC	(Ljava/lang/String;)V
    //   469: ldc 18
    //   471: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: aload 6
    //   477: ldc 104
    //   479: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   0	511	0	this	e
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.e
 * JD-Core Version:    0.7.0.1
 */