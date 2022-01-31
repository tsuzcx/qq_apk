package com.tencent.mm.plugin.exdevice.model;

final class g$4
  implements j.a
{
  g$4(g paramg) {}
  
  /* Error */
  public final void g(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: sipush 19254
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: bipush 14
    //   9: if_icmpne +21 -> 30
    //   12: aload_2
    //   13: ifnull +17 -> 30
    //   16: aload_2
    //   17: arraylength
    //   18: ifle +12 -> 30
    //   21: aload_2
    //   22: iconst_0
    //   23: aaload
    //   24: instanceof 30
    //   27: ifne +10 -> 37
    //   30: sipush 19254
    //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload_2
    //   38: iconst_0
    //   39: aaload
    //   40: checkcast 30	[B
    //   43: checkcast 30	[B
    //   46: astore_2
    //   47: new 35	org/json/JSONObject
    //   50: dup
    //   51: new 37	java/lang/String
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 40	java/lang/String:<init>	([B)V
    //   59: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 45
    //   68: invokevirtual 49	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   71: astore_2
    //   72: aload_2
    //   73: ldc 51
    //   75: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_2
    //   81: ldc 57
    //   83: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 4
    //   88: aload 6
    //   90: ldc 59
    //   92: invokevirtual 63	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   95: ifeq +17 -> 112
    //   98: ldc 65
    //   100: ldc 67
    //   102: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: sipush 19254
    //   108: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: ldc 65
    //   114: ldc 75
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload 6
    //   124: ldc 59
    //   126: invokevirtual 79	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   129: invokevirtual 85	org/json/JSONArray:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: astore 6
    //   139: aload 5
    //   141: ifnull +29 -> 170
    //   144: aload 4
    //   146: ifnull +24 -> 170
    //   149: ldc 65
    //   151: ldc 90
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 5
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 4
    //   166: aastore
    //   167: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_0
    //   171: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   174: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   177: invokeinterface 102 1 0
    //   182: istore_3
    //   183: iconst_0
    //   184: istore_1
    //   185: iload_1
    //   186: iload_3
    //   187: if_icmpge +205 -> 392
    //   190: aload_0
    //   191: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   194: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   197: iload_1
    //   198: invokeinterface 106 2 0
    //   203: checkcast 108	com/tencent/mm/plugin/exdevice/h/b
    //   206: getfield 112	com/tencent/mm/plugin/exdevice/h/b:field_deviceID	Ljava/lang/String;
    //   209: aload 4
    //   211: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifeq +139 -> 353
    //   217: aload_0
    //   218: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   221: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   224: iload_1
    //   225: invokeinterface 106 2 0
    //   230: checkcast 108	com/tencent/mm/plugin/exdevice/h/b
    //   233: getfield 119	com/tencent/mm/plugin/exdevice/h/b:field_deviceType	Ljava/lang/String;
    //   236: aload 5
    //   238: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +112 -> 353
    //   244: aload_0
    //   245: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   248: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   251: iload_1
    //   252: invokeinterface 106 2 0
    //   257: checkcast 108	com/tencent/mm/plugin/exdevice/h/b
    //   260: getfield 124	com/tencent/mm/g/c/ch:dCP	Ljava/lang/String;
    //   263: ldc 126
    //   265: invokevirtual 130	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +85 -> 353
    //   271: aload_0
    //   272: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   275: getfield 133	com/tencent/mm/plugin/exdevice/model/g:lEB	Ljava/util/List;
    //   278: aload_0
    //   279: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   282: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   285: iload_1
    //   286: invokeinterface 106 2 0
    //   291: invokeinterface 135 2 0
    //   296: ifne +57 -> 353
    //   299: aload_0
    //   300: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   303: getfield 139	com/tencent/mm/plugin/exdevice/model/g:lEC	Ljava/util/HashMap;
    //   306: aload 4
    //   308: aload 6
    //   310: invokevirtual 140	org/json/JSONObject:toString	()Ljava/lang/String;
    //   313: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   316: pop
    //   317: aload_0
    //   318: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   321: getfield 133	com/tencent/mm/plugin/exdevice/model/g:lEB	Ljava/util/List;
    //   324: aload_0
    //   325: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   328: getfield 96	com/tencent/mm/plugin/exdevice/model/g:lEA	Ljava/util/List;
    //   331: iload_1
    //   332: invokeinterface 106 2 0
    //   337: invokeinterface 149 2 0
    //   342: pop
    //   343: aload_0
    //   344: getfield 14	com/tencent/mm/plugin/exdevice/model/g$4:lEP	Lcom/tencent/mm/plugin/exdevice/model/g;
    //   347: getfield 133	com/tencent/mm/plugin/exdevice/model/g:lEB	Ljava/util/List;
    //   350: invokestatic 153	com/tencent/mm/plugin/exdevice/model/g:bu	(Ljava/util/List;)V
    //   353: iload_1
    //   354: iconst_1
    //   355: iadd
    //   356: istore_1
    //   357: goto -172 -> 185
    //   360: astore 4
    //   362: aconst_null
    //   363: astore 6
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore 5
    //   370: ldc 65
    //   372: ldc 155
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload 4
    //   382: aastore
    //   383: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: aload_2
    //   387: astore 4
    //   389: goto -250 -> 139
    //   392: sipush 19254
    //   395: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: return
    //   399: astore 4
    //   401: aconst_null
    //   402: astore 7
    //   404: aconst_null
    //   405: astore 5
    //   407: aload_2
    //   408: astore 6
    //   410: aload 7
    //   412: astore_2
    //   413: goto -43 -> 370
    //   416: astore 4
    //   418: aconst_null
    //   419: astore 7
    //   421: aload_2
    //   422: astore 6
    //   424: aload 7
    //   426: astore_2
    //   427: goto -57 -> 370
    //   430: astore 6
    //   432: aload 4
    //   434: astore 7
    //   436: aload 6
    //   438: astore 4
    //   440: aload_2
    //   441: astore 6
    //   443: aload 7
    //   445: astore_2
    //   446: goto -76 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	4
    //   0	449	1	paramInt	int
    //   0	449	2	paramVarArgs	Object[]
    //   182	6	3	i	int
    //   86	221	4	str1	java.lang.String
    //   360	21	4	localException1	java.lang.Exception
    //   387	1	4	arrayOfObject1	Object[]
    //   399	1	4	localException2	java.lang.Exception
    //   416	17	4	localException3	java.lang.Exception
    //   438	1	4	localException4	java.lang.Exception
    //   78	328	5	str2	java.lang.String
    //   62	361	6	localObject	Object
    //   430	7	6	localException5	java.lang.Exception
    //   441	1	6	arrayOfObject2	Object[]
    //   402	42	7	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   47	72	360	java/lang/Exception
    //   72	80	399	java/lang/Exception
    //   80	88	416	java/lang/Exception
    //   88	105	430	java/lang/Exception
    //   112	136	430	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.4
 * JD-Core Version:    0.7.0.1
 */