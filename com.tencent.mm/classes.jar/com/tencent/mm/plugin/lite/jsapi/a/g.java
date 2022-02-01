package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.mm.plugin.lite.jsapi.b;

public class g
  extends b
{
  /* Error */
  public final void a(java.lang.String paramString, org.json.JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 16
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 24
    //   8: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11: ifne +18 -> 29
    //   14: aload_0
    //   15: getfield 34	com/tencent/mm/plugin/lite/jsapi/a/g:Ega	Lcom/tencent/mm/plugin/lite/jsapi/b$a;
    //   18: ldc 36
    //   20: invokevirtual 42	com/tencent/mm/plugin/lite/jsapi/b$a:aNa	(Ljava/lang/String;)V
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
    //   42: istore_3
    //   43: new 50	android/content/Intent
    //   46: dup
    //   47: invokespecial 51	android/content/Intent:<init>	()V
    //   50: astore 7
    //   52: aload_2
    //   53: ldc 24
    //   55: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 8
    //   60: aload 8
    //   62: ldc 57
    //   64: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifne +11 -> 78
    //   70: aload 6
    //   72: ldc 64
    //   74: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 6
    //   80: aload 8
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: ldc 70
    //   89: invokevirtual 30	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   92: ifeq +413 -> 505
    //   95: aload_2
    //   96: ldc 70
    //   98: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 4
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
    //   126: ifeq +10 -> 136
    //   129: aload_2
    //   130: ldc 78
    //   132: invokevirtual 81	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   135: istore_3
    //   136: aload 7
    //   138: ldc 83
    //   140: aload_0
    //   141: aload_2
    //   142: invokevirtual 87	com/tencent/mm/plugin/lite/jsapi/a/g:bb	(Lorg/json/JSONObject;)I
    //   145: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   148: pop
    //   149: aload 7
    //   151: ldc 93
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual 96	com/tencent/mm/plugin/lite/jsapi/a/g:bc	(Lorg/json/JSONObject;)I
    //   158: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   161: pop
    //   162: iload_3
    //   163: ifeq +195 -> 358
    //   166: aload 6
    //   168: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: ldc 102
    //   173: invokevirtual 106	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +298 -> 474
    //   179: aload 6
    //   181: ldc 108
    //   183: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 6
    //   189: ldc 110
    //   191: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: getstatic 116	com/tencent/mm/protocal/d:RAB	Ljava/lang/String;
    //   197: ldc 118
    //   199: invokestatic 124	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: ldc 126
    //   210: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 6
    //   216: ldc 128
    //   218: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: getstatic 133	android/os/Build:BRAND	Ljava/lang/String;
    //   224: ldc 118
    //   226: invokestatic 124	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 6
    //   235: ldc 135
    //   237: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: getstatic 138	android/os/Build:MODEL	Ljava/lang/String;
    //   243: ldc 118
    //   245: invokestatic 124	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 6
    //   254: ldc 140
    //   256: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 142
    //   261: aload_1
    //   262: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   265: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: ldc 151
    //   276: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: astore_1
    //   280: invokestatic 157	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   283: pop
    //   284: aload_1
    //   285: invokestatic 162	com/tencent/mm/kernel/b:aGq	()Ljava/lang/String;
    //   288: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 6
    //   294: ldc 164
    //   296: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: getstatic 168	com/tencent/mm/protocal/d:RAD	I
    //   302: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 6
    //   308: ldc 173
    //   310: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokestatic 178	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   316: ldc 118
    //   318: invokestatic 124	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   321: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 6
    //   327: ldc 180
    //   329: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: getstatic 183	com/tencent/mm/protocal/d:RAy	Ljava/lang/String;
    //   335: ldc 118
    //   337: invokestatic 124	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   340: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 6
    //   346: ldc 185
    //   348: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:getTimeZoneOffset	()Ljava/lang/String;
    //   354: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 7
    //   360: ldc 192
    //   362: aload 6
    //   364: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   370: pop
    //   371: aload 7
    //   373: ldc 197
    //   375: iconst_0
    //   376: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   379: pop
    //   380: aload 7
    //   382: ldc 202
    //   384: iload 4
    //   386: invokevirtual 91	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   389: pop
    //   390: aload 7
    //   392: ldc 204
    //   394: aload 5
    //   396: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   399: pop
    //   400: aload 7
    //   402: ldc 206
    //   404: ldc 208
    //   406: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   409: pop
    //   410: aload 7
    //   412: ldc 210
    //   414: ldc 208
    //   416: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   419: pop
    //   420: aload 7
    //   422: ldc 211
    //   424: invokevirtual 215	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   427: pop
    //   428: invokestatic 221	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   431: ldc 223
    //   433: ldc 225
    //   435: aload 7
    //   437: invokestatic 231	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   440: ldc 16
    //   442: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: return
    //   446: astore_1
    //   447: ldc 233
    //   449: aload_1
    //   450: ldc 235
    //   452: iconst_0
    //   453: anewarray 237	java/lang/Object
    //   456: invokestatic 243	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: aload_0
    //   460: getfield 34	com/tencent/mm/plugin/lite/jsapi/a/g:Ega	Lcom/tencent/mm/plugin/lite/jsapi/b$a;
    //   463: ldc 245
    //   465: invokevirtual 42	com/tencent/mm/plugin/lite/jsapi/b$a:aNa	(Ljava/lang/String;)V
    //   468: ldc 16
    //   470: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: return
    //   474: aload 6
    //   476: ldc 102
    //   478: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: goto -295 -> 187
    //   485: astore_1
    //   486: goto -142 -> 344
    //   489: astore_1
    //   490: goto -165 -> 325
    //   493: astore_2
    //   494: goto -242 -> 252
    //   497: astore_2
    //   498: goto -265 -> 233
    //   501: astore_2
    //   502: goto -296 -> 206
    //   505: iconst_0
    //   506: istore 4
    //   508: goto -405 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	g
    //   0	511	1	paramString	java.lang.String
    //   0	511	2	paramJSONObject	org.json.JSONObject
    //   0	511	3	paramBoolean	boolean
    //   101	406	4	i	int
    //   39	356	5	str1	java.lang.String
    //   36	439	6	localStringBuilder	java.lang.StringBuilder
    //   50	386	7	localIntent	android.content.Intent
    //   58	23	8	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   52	78	446	org/json/JSONException
    //   78	103	446	org/json/JSONException
    //   103	120	446	org/json/JSONException
    //   120	136	446	org/json/JSONException
    //   136	162	446	org/json/JSONException
    //   325	344	485	java/lang/Exception
    //   306	325	489	java/lang/Exception
    //   233	252	493	java/lang/Exception
    //   214	233	497	java/lang/Exception
    //   187	206	501	java/lang/Exception
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.g
 * JD-Core Version:    0.7.0.1
 */