package com.tencent.mm.plugin.expt.hellhound.ext.session.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.b;
import com.tencent.mm.protocal.protobuf.eyu;
import com.tencent.mm.sdk.event.IListener;

public final class c
{
  private static c zKB;
  public final IListener zKC;
  
  private c()
  {
    AppMethodBeat.i(122100);
    this.zKC = new HellSessionCloudConfig.1(this, f.hfK);
    AppMethodBeat.o(122100);
  }
  
  /* Error */
  private static com.tencent.mm.vending.j.e<java.util.List<com.tencent.mm.protocal.protobuf.eyw>, java.util.List<com.tencent.mm.protocal.protobuf.eyt>, com.tencent.mm.protocal.protobuf.eyv, java.util.List<com.tencent.mm.protocal.protobuf.eyy>> asH(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 45	org/json/JSONObject
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 48	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: ldc 50
    //   15: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   18: astore 6
    //   20: new 56	java/util/LinkedList
    //   23: dup
    //   24: invokespecial 57	java/util/LinkedList:<init>	()V
    //   27: astore 7
    //   29: new 56	java/util/LinkedList
    //   32: dup
    //   33: invokespecial 57	java/util/LinkedList:<init>	()V
    //   36: astore 8
    //   38: aconst_null
    //   39: astore_0
    //   40: new 56	java/util/LinkedList
    //   43: dup
    //   44: invokespecial 57	java/util/LinkedList:<init>	()V
    //   47: astore 9
    //   49: aload 6
    //   51: invokevirtual 63	org/json/JSONArray:length	()I
    //   54: istore_3
    //   55: iconst_0
    //   56: istore_1
    //   57: iload_1
    //   58: iload_3
    //   59: if_icmpge +544 -> 603
    //   62: aload 6
    //   64: iload_1
    //   65: invokevirtual 67	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   68: astore 10
    //   70: aload_0
    //   71: astore 5
    //   73: aload 10
    //   75: ifnull +111 -> 186
    //   78: aload 10
    //   80: ldc 69
    //   82: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload 5
    //   89: invokestatic 79	com/tencent/mm/plugin/expt/hellhound/ext/session/config/b:asw	(Ljava/lang/String;)Z
    //   92: ifeq +124 -> 216
    //   95: new 81	com/tencent/mm/protocal/protobuf/eyt
    //   98: dup
    //   99: invokespecial 82	com/tencent/mm/protocal/protobuf/eyt:<init>	()V
    //   102: astore 11
    //   104: aload 11
    //   106: aload 5
    //   108: putfield 86	com/tencent/mm/protocal/protobuf/eyt:zIC	Ljava/lang/String;
    //   111: aload 11
    //   113: aload 10
    //   115: ldc 88
    //   117: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 91	com/tencent/mm/protocal/protobuf/eyt:abzW	Ljava/lang/String;
    //   123: aload 11
    //   125: aload 10
    //   127: ldc 93
    //   129: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 96	com/tencent/mm/protocal/protobuf/eyt:hJW	Ljava/lang/String;
    //   135: aload 10
    //   137: ldc 98
    //   139: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   142: astore 5
    //   144: aload 5
    //   146: ifnull +27 -> 173
    //   149: aload 5
    //   151: invokevirtual 63	org/json/JSONArray:length	()I
    //   154: ifle +19 -> 173
    //   157: aload 11
    //   159: aload 5
    //   161: iconst_0
    //   162: invokevirtual 67	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   165: ldc 100
    //   167: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   170: putfield 103	com/tencent/mm/protocal/protobuf/eyt:abzX	Ljava/lang/String;
    //   173: aload 8
    //   175: aload 11
    //   177: invokeinterface 109 2 0
    //   182: pop
    //   183: aload_0
    //   184: astore 5
    //   186: iload_1
    //   187: iconst_1
    //   188: iadd
    //   189: istore_1
    //   190: aload 5
    //   192: astore_0
    //   193: goto -136 -> 57
    //   196: astore_0
    //   197: ldc 111
    //   199: aload_0
    //   200: ldc 113
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: ldc 43
    //   211: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aconst_null
    //   215: areturn
    //   216: aload 5
    //   218: invokestatic 122	com/tencent/mm/plugin/expt/hellhound/ext/session/config/b:asA	(Ljava/lang/String;)Z
    //   221: ifeq +132 -> 353
    //   224: new 124	com/tencent/mm/protocal/protobuf/eyv
    //   227: dup
    //   228: invokespecial 125	com/tencent/mm/protocal/protobuf/eyv:<init>	()V
    //   231: astore_0
    //   232: aload_0
    //   233: aload 5
    //   235: putfield 126	com/tencent/mm/protocal/protobuf/eyv:zIC	Ljava/lang/String;
    //   238: aload_0
    //   239: aload 10
    //   241: ldc 88
    //   243: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: putfield 127	com/tencent/mm/protocal/protobuf/eyv:abzW	Ljava/lang/String;
    //   249: aload_0
    //   250: aload 10
    //   252: ldc 93
    //   254: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   257: putfield 128	com/tencent/mm/protocal/protobuf/eyv:hJW	Ljava/lang/String;
    //   260: aload 10
    //   262: ldc 98
    //   264: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   267: astore 10
    //   269: aload_0
    //   270: astore 5
    //   272: aload 10
    //   274: ifnull -88 -> 186
    //   277: aload_0
    //   278: astore 5
    //   280: aload 10
    //   282: invokevirtual 63	org/json/JSONArray:length	()I
    //   285: iconst_1
    //   286: if_icmple -100 -> 186
    //   289: aload 10
    //   291: iconst_0
    //   292: invokevirtual 67	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   295: astore 5
    //   297: aload 10
    //   299: iconst_1
    //   300: invokevirtual 67	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   303: astore 10
    //   305: aload_0
    //   306: aload 5
    //   308: ldc 100
    //   310: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   313: putfield 131	com/tencent/mm/protocal/protobuf/eyv:abAb	Ljava/lang/String;
    //   316: aload_0
    //   317: aload 10
    //   319: ldc 100
    //   321: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 134	com/tencent/mm/protocal/protobuf/eyv:abAc	Ljava/lang/String;
    //   327: aload_0
    //   328: astore 5
    //   330: goto -144 -> 186
    //   333: astore_0
    //   334: ldc 111
    //   336: aload_0
    //   337: ldc 136
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: ldc 43
    //   348: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: aconst_null
    //   352: areturn
    //   353: aload 10
    //   355: ldc 98
    //   357: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   360: astore 11
    //   362: aload 11
    //   364: ifnull +183 -> 547
    //   367: aload 11
    //   369: invokevirtual 63	org/json/JSONArray:length	()I
    //   372: ifle +175 -> 547
    //   375: new 138	com/tencent/mm/protocal/protobuf/eyy
    //   378: dup
    //   379: invokespecial 139	com/tencent/mm/protocal/protobuf/eyy:<init>	()V
    //   382: astore 12
    //   384: aload 12
    //   386: aload 5
    //   388: putfield 140	com/tencent/mm/protocal/protobuf/eyy:zIC	Ljava/lang/String;
    //   391: aload 12
    //   393: aload 10
    //   395: ldc 88
    //   397: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 141	com/tencent/mm/protocal/protobuf/eyy:abzW	Ljava/lang/String;
    //   403: aload 12
    //   405: aload 10
    //   407: ldc 93
    //   409: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: putfield 142	com/tencent/mm/protocal/protobuf/eyy:hJW	Ljava/lang/String;
    //   415: aload 11
    //   417: invokevirtual 63	org/json/JSONArray:length	()I
    //   420: istore 4
    //   422: new 144	java/util/ArrayList
    //   425: dup
    //   426: invokespecial 145	java/util/ArrayList:<init>	()V
    //   429: astore 5
    //   431: iconst_0
    //   432: istore_2
    //   433: iload_2
    //   434: iload 4
    //   436: if_icmpge +74 -> 510
    //   439: aload 11
    //   441: iload_2
    //   442: invokevirtual 67	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   445: astore 10
    //   447: aload 10
    //   449: ifnull +172 -> 621
    //   452: new 147	com/tencent/mm/protocal/protobuf/eyx
    //   455: dup
    //   456: invokespecial 148	com/tencent/mm/protocal/protobuf/eyx:<init>	()V
    //   459: astore 13
    //   461: aload 13
    //   463: aload 10
    //   465: ldc 150
    //   467: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   470: putfield 152	com/tencent/mm/protocal/protobuf/eyx:className	Ljava/lang/String;
    //   473: aload 13
    //   475: aload 10
    //   477: ldc 154
    //   479: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   482: putfield 156	com/tencent/mm/protocal/protobuf/eyx:dataPath	Ljava/lang/String;
    //   485: aload 13
    //   487: aload 10
    //   489: ldc 100
    //   491: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   494: putfield 157	com/tencent/mm/protocal/protobuf/eyx:abzX	Ljava/lang/String;
    //   497: aload 5
    //   499: aload 13
    //   501: invokeinterface 109 2 0
    //   506: pop
    //   507: goto +114 -> 621
    //   510: aload 5
    //   512: invokeinterface 161 1 0
    //   517: ifne +14 -> 531
    //   520: aload 12
    //   522: getfield 165	com/tencent/mm/protocal/protobuf/eyy:abAd	Ljava/util/LinkedList;
    //   525: aload 5
    //   527: invokevirtual 169	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   530: pop
    //   531: aload 9
    //   533: aload 12
    //   535: invokeinterface 109 2 0
    //   540: pop
    //   541: aload_0
    //   542: astore 5
    //   544: goto -358 -> 186
    //   547: new 171	com/tencent/mm/protocal/protobuf/eyw
    //   550: dup
    //   551: invokespecial 172	com/tencent/mm/protocal/protobuf/eyw:<init>	()V
    //   554: astore 11
    //   556: aload 11
    //   558: aload 5
    //   560: putfield 173	com/tencent/mm/protocal/protobuf/eyw:zIC	Ljava/lang/String;
    //   563: aload 11
    //   565: aload 10
    //   567: ldc 88
    //   569: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   572: putfield 174	com/tencent/mm/protocal/protobuf/eyw:abzW	Ljava/lang/String;
    //   575: aload 11
    //   577: aload 10
    //   579: ldc 93
    //   581: invokevirtual 73	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   584: putfield 175	com/tencent/mm/protocal/protobuf/eyw:hJW	Ljava/lang/String;
    //   587: aload 7
    //   589: aload 11
    //   591: invokeinterface 109 2 0
    //   596: pop
    //   597: aload_0
    //   598: astore 5
    //   600: goto -414 -> 186
    //   603: aload 7
    //   605: aload 8
    //   607: aload_0
    //   608: aload 9
    //   610: invokestatic 181	com/tencent/mm/vending/j/a:c	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/e;
    //   613: astore_0
    //   614: ldc 43
    //   616: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   619: aload_0
    //   620: areturn
    //   621: iload_2
    //   622: iconst_1
    //   623: iadd
    //   624: istore_2
    //   625: goto -192 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	paramString	java.lang.String
    //   56	134	1	i	int
    //   432	193	2	j	int
    //   54	6	3	k	int
    //   420	17	4	m	int
    //   71	528	5	localObject1	Object
    //   18	45	6	localJSONArray	org.json.JSONArray
    //   27	577	7	localLinkedList1	java.util.LinkedList
    //   36	570	8	localLinkedList2	java.util.LinkedList
    //   47	562	9	localLinkedList3	java.util.LinkedList
    //   68	510	10	localObject2	Object
    //   102	488	11	localObject3	Object
    //   382	152	12	localeyy	com.tencent.mm.protocal.protobuf.eyy
    //   459	41	13	localeyx	com.tencent.mm.protocal.protobuf.eyx
    // Exception table:
    //   from	to	target	type
    //   5	20	196	org/json/JSONException
    //   62	70	333	java/lang/Exception
    //   78	144	333	java/lang/Exception
    //   149	173	333	java/lang/Exception
    //   173	183	333	java/lang/Exception
    //   216	269	333	java/lang/Exception
    //   280	327	333	java/lang/Exception
    //   353	362	333	java/lang/Exception
    //   367	431	333	java/lang/Exception
    //   439	447	333	java/lang/Exception
    //   452	507	333	java/lang/Exception
    //   510	531	333	java/lang/Exception
    //   531	541	333	java/lang/Exception
    //   547	597	333	java/lang/Exception
  }
  
  public static c dLJ()
  {
    AppMethodBeat.i(122101);
    if (zKB == null) {}
    try
    {
      if (zKB == null) {
        zKB = new c();
      }
      c localc = zKB;
      AppMethodBeat.o(122101);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122101);
    }
  }
  
  public static eyu dLK()
  {
    AppMethodBeat.i(122102);
    eyu localeyu = b.dLU();
    AppMethodBeat.o(122102);
    return localeyu;
  }
  
  public static boolean dLL()
  {
    AppMethodBeat.i(122103);
    eyu localeyu = b.dLU();
    if (localeyu == null)
    {
      AppMethodBeat.o(122103);
      return true;
    }
    boolean bool = localeyu.lKI;
    AppMethodBeat.o(122103);
    return bool;
  }
  
  public static boolean dLM()
  {
    AppMethodBeat.i(122104);
    eyu localeyu = b.dLU();
    if (localeyu == null)
    {
      AppMethodBeat.o(122104);
      return false;
    }
    boolean bool = localeyu.Akx;
    AppMethodBeat.o(122104);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.config.c
 * JD-Core Version:    0.7.0.1
 */