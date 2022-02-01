package com.tencent.mm.plugin.appbrand.jsapi.ad;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 895;
  public static final String NAME = "checkTrafficCardConditions";
  
  /* Error */
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, com.b.b.a.a.a parama, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload 4
    //   7: ifnonnull +104 -> 111
    //   10: new 29	java/util/HashMap
    //   13: dup
    //   14: invokespecial 30	java/util/HashMap:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc 32
    //   21: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSZ	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   24: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorCode	I
    //   27: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokeinterface 53 3 0
    //   35: pop
    //   36: aload_1
    //   37: iload_2
    //   38: aload_0
    //   39: new 55	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 57
    //   45: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSZ	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   51: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorMsg	Ljava/lang/String;
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aload_3
    //   61: invokevirtual 75	com/tencent/mm/plugin/appbrand/jsapi/ad/c:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   64: invokeinterface 81 3 0
    //   69: ldc 83
    //   71: ldc 85
    //   73: iconst_3
    //   74: anewarray 87	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSZ	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   82: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorMsg	Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: invokeinterface 90 1 0
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: iload_2
    //   98: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: ldc 21
    //   107: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: new 29	java/util/HashMap
    //   114: dup
    //   115: invokespecial 30	java/util/HashMap:<init>	()V
    //   118: astore 15
    //   120: aload 4
    //   122: ldc 101
    //   124: invokevirtual 107	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 11
    //   129: aload 4
    //   131: ldc 109
    //   133: invokevirtual 107	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 17
    //   138: ldc 111
    //   140: aload 17
    //   142: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: istore 10
    //   147: aload 15
    //   149: ldc 101
    //   151: aload 11
    //   153: invokevirtual 118	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aconst_null
    //   158: astore 4
    //   160: aconst_null
    //   161: astore 14
    //   163: aconst_null
    //   164: astore 11
    //   166: aconst_null
    //   167: astore 12
    //   169: aload_3
    //   170: invokeinterface 123 1 0
    //   175: astore 16
    //   177: new 103	org/json/JSONObject
    //   180: dup
    //   181: aload 16
    //   183: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   186: astore 13
    //   188: aload 11
    //   190: astore 4
    //   192: iload 10
    //   194: ifeq +48 -> 242
    //   197: aload 14
    //   199: astore 11
    //   201: aload_3
    //   202: aload 15
    //   204: invokeinterface 128 2 0
    //   209: astore 18
    //   211: aload 14
    //   213: astore 11
    //   215: new 103	org/json/JSONObject
    //   218: dup
    //   219: aload 18
    //   221: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   224: astore 4
    //   226: ldc 83
    //   228: ldc 130
    //   230: iconst_1
    //   231: anewarray 87	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 18
    //   238: aastore
    //   239: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload 4
    //   244: astore 11
    //   246: aload 15
    //   248: ldc 109
    //   250: aload 17
    //   252: invokevirtual 118	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   255: pop
    //   256: aload 4
    //   258: astore 11
    //   260: aload_3
    //   261: aload 15
    //   263: invokeinterface 136 2 0
    //   268: astore 14
    //   270: aload 4
    //   272: astore 11
    //   274: new 103	org/json/JSONObject
    //   277: dup
    //   278: aload 14
    //   280: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   283: astore_3
    //   284: ldc 83
    //   286: ldc 138
    //   288: iconst_3
    //   289: anewarray 87	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload 16
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload 14
    //   301: aastore
    //   302: dup
    //   303: iconst_2
    //   304: new 103	org/json/JSONObject
    //   307: dup
    //   308: aload 15
    //   310: invokespecial 141	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   313: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 133	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: aload 13
    //   322: astore 11
    //   324: aload 11
    //   326: ifnull +17 -> 343
    //   329: iload 10
    //   331: ifeq +8 -> 339
    //   334: aload 4
    //   336: ifnull +7 -> 343
    //   339: aload_3
    //   340: ifnonnull +96 -> 436
    //   343: new 29	java/util/HashMap
    //   346: dup
    //   347: invokespecial 30	java/util/HashMap:<init>	()V
    //   350: astore_3
    //   351: aload_3
    //   352: ldc 32
    //   354: getstatic 145	com/tencent/mm/plugin/appbrand/jsapi/ad/b:naY	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   357: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorCode	I
    //   360: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: invokeinterface 53 3 0
    //   368: pop
    //   369: aload_1
    //   370: iload_2
    //   371: aload_0
    //   372: new 55	java/lang/StringBuilder
    //   375: dup
    //   376: ldc 57
    //   378: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: getstatic 145	com/tencent/mm/plugin/appbrand/jsapi/ad/b:naY	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   384: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorMsg	Ljava/lang/String;
    //   387: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: aload_3
    //   394: invokevirtual 75	com/tencent/mm/plugin/appbrand/jsapi/ad/c:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   397: invokeinterface 81 3 0
    //   402: ldc 21
    //   404: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: return
    //   408: astore_3
    //   409: aconst_null
    //   410: astore 11
    //   412: ldc 83
    //   414: ldc 147
    //   416: iconst_1
    //   417: anewarray 87	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_3
    //   423: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: aastore
    //   427: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: aload 12
    //   432: astore_3
    //   433: goto -109 -> 324
    //   436: aload 11
    //   438: ldc 152
    //   440: invokevirtual 156	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   443: istore 7
    //   445: aload_3
    //   446: ldc 152
    //   448: invokevirtual 156	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   451: istore 8
    //   453: iconst_0
    //   454: istore 5
    //   456: iload 10
    //   458: ifeq +12 -> 470
    //   461: aload 4
    //   463: ldc 152
    //   465: invokevirtual 156	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   468: istore 5
    //   470: iconst_0
    //   471: istore 6
    //   473: iload 6
    //   475: iconst_3
    //   476: if_icmpge +189 -> 665
    //   479: iconst_3
    //   480: newarray int
    //   482: dup
    //   483: iconst_0
    //   484: iload 7
    //   486: iastore
    //   487: dup
    //   488: iconst_1
    //   489: iload 5
    //   491: iastore
    //   492: dup
    //   493: iconst_2
    //   494: iload 8
    //   496: iastore
    //   497: iload 6
    //   499: iaload
    //   500: istore 9
    //   502: iload 9
    //   504: getstatic 159	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSY	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   507: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorCode	I
    //   510: if_icmpeq +146 -> 656
    //   513: iload 9
    //   515: invokestatic 163	com/tencent/mm/plugin/appbrand/jsapi/ad/b:wk	(I)Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   518: astore 4
    //   520: aload 4
    //   522: astore_3
    //   523: aload 4
    //   525: getstatic 166	com/tencent/mm/plugin/appbrand/jsapi/ad/b:nbC	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   528: if_acmpne +7 -> 535
    //   531: getstatic 169	com/tencent/mm/plugin/appbrand/jsapi/ad/b:nbo	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   534: astore_3
    //   535: new 29	java/util/HashMap
    //   538: dup
    //   539: invokespecial 30	java/util/HashMap:<init>	()V
    //   542: astore 4
    //   544: aload 4
    //   546: ldc 32
    //   548: aload_3
    //   549: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorCode	I
    //   552: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: invokeinterface 53 3 0
    //   560: pop
    //   561: iload 7
    //   563: ifne +20 -> 583
    //   566: aload 4
    //   568: ldc 171
    //   570: aload 11
    //   572: ldc 171
    //   574: invokevirtual 175	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   577: invokeinterface 53 3 0
    //   582: pop
    //   583: aload_1
    //   584: iload_2
    //   585: aload_0
    //   586: new 55	java/lang/StringBuilder
    //   589: dup
    //   590: ldc 57
    //   592: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: aload_3
    //   596: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorMsg	Ljava/lang/String;
    //   599: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: aload 4
    //   607: invokevirtual 75	com/tencent/mm/plugin/appbrand/jsapi/ad/c:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   610: invokeinterface 81 3 0
    //   615: ldc 83
    //   617: ldc 177
    //   619: iconst_3
    //   620: anewarray 87	java/lang/Object
    //   623: dup
    //   624: iconst_0
    //   625: iload 7
    //   627: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: aastore
    //   631: dup
    //   632: iconst_1
    //   633: iload 5
    //   635: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   638: aastore
    //   639: dup
    //   640: iconst_2
    //   641: iload 8
    //   643: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: aastore
    //   647: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: ldc 21
    //   652: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   655: return
    //   656: iload 6
    //   658: iconst_1
    //   659: iadd
    //   660: istore 6
    //   662: goto -189 -> 473
    //   665: new 29	java/util/HashMap
    //   668: dup
    //   669: invokespecial 30	java/util/HashMap:<init>	()V
    //   672: astore_3
    //   673: aload_3
    //   674: ldc 32
    //   676: getstatic 159	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSY	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   679: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorCode	I
    //   682: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   685: invokeinterface 53 3 0
    //   690: pop
    //   691: aload_3
    //   692: ldc 171
    //   694: aload 11
    //   696: ldc 171
    //   698: invokevirtual 175	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   701: invokeinterface 53 3 0
    //   706: pop
    //   707: aload_1
    //   708: iload_2
    //   709: aload_0
    //   710: getstatic 159	com/tencent/mm/plugin/appbrand/jsapi/ad/b:mSY	Lcom/tencent/mm/plugin/appbrand/jsapi/ad/b;
    //   713: getfield 63	com/tencent/mm/plugin/appbrand/jsapi/ad/b:errorMsg	Ljava/lang/String;
    //   716: aload_3
    //   717: invokevirtual 75	com/tencent/mm/plugin/appbrand/jsapi/ad/c:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   720: invokeinterface 81 3 0
    //   725: ldc 21
    //   727: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   730: return
    //   731: astore_3
    //   732: aload 11
    //   734: astore 4
    //   736: aload 13
    //   738: astore 11
    //   740: goto -328 -> 412
    //   743: astore_3
    //   744: aload 13
    //   746: astore 11
    //   748: goto -336 -> 412
    //   751: astore 11
    //   753: aload_3
    //   754: astore 12
    //   756: aload 11
    //   758: astore_3
    //   759: aload 13
    //   761: astore 11
    //   763: goto -351 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	c
    //   0	766	1	paramh	com.tencent.mm.plugin.appbrand.jsapi.h
    //   0	766	2	paramInt	int
    //   0	766	3	parama	com.b.b.a.a.a
    //   0	766	4	paramJSONObject	org.json.JSONObject
    //   454	180	5	i	int
    //   471	190	6	j	int
    //   443	183	7	k	int
    //   451	191	8	m	int
    //   500	14	9	n	int
    //   145	312	10	bool	boolean
    //   127	620	11	localObject1	java.lang.Object
    //   751	6	11	localException	java.lang.Exception
    //   761	1	11	localObject2	java.lang.Object
    //   167	588	12	locala	com.b.b.a.a.a
    //   186	574	13	localJSONObject	org.json.JSONObject
    //   161	139	14	str1	String
    //   118	191	15	localHashMap	java.util.HashMap
    //   175	120	16	str2	String
    //   136	115	17	str3	String
    //   209	28	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   169	188	408	java/lang/Exception
    //   201	211	731	java/lang/Exception
    //   215	226	731	java/lang/Exception
    //   246	256	731	java/lang/Exception
    //   260	270	731	java/lang/Exception
    //   274	284	731	java/lang/Exception
    //   226	242	743	java/lang/Exception
    //   284	320	751	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c
 * JD-Core Version:    0.7.0.1
 */