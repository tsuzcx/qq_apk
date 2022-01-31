package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.b;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static c maT;
  public final com.tencent.mm.sdk.b.c maU;
  
  private c()
  {
    AppMethodBeat.i(152359);
    this.maU = new c.1(this);
    AppMethodBeat.o(152359);
  }
  
  /* Error */
  private static com.tencent.mm.vending.j.e<List<com.tencent.mm.protocal.protobuf.cab>, List<com.tencent.mm.protocal.protobuf.bzy>, com.tencent.mm.protocal.protobuf.caa, List<com.tencent.mm.protocal.protobuf.cad>> MD(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 39	org/json/JSONObject
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 42	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: ldc 44
    //   15: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   18: astore 9
    //   20: new 50	java/util/LinkedList
    //   23: dup
    //   24: invokespecial 51	java/util/LinkedList:<init>	()V
    //   27: astore 6
    //   29: new 50	java/util/LinkedList
    //   32: dup
    //   33: invokespecial 51	java/util/LinkedList:<init>	()V
    //   36: astore 7
    //   38: aconst_null
    //   39: astore_0
    //   40: new 50	java/util/LinkedList
    //   43: dup
    //   44: invokespecial 51	java/util/LinkedList:<init>	()V
    //   47: astore 8
    //   49: aload 9
    //   51: invokevirtual 57	org/json/JSONArray:length	()I
    //   54: istore_3
    //   55: iconst_0
    //   56: istore_1
    //   57: iload_1
    //   58: iload_3
    //   59: if_icmpge +677 -> 736
    //   62: aload 9
    //   64: iload_1
    //   65: invokevirtual 61	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   68: astore 10
    //   70: aload 10
    //   72: ifnull +661 -> 733
    //   75: aload 10
    //   77: ldc 63
    //   79: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 11
    //   84: aload 11
    //   86: invokestatic 73	com/tencent/mm/plugin/expt/hellhound/a/b/a/b:Mw	(Ljava/lang/String;)Z
    //   89: ifeq +151 -> 240
    //   92: new 75	com/tencent/mm/protocal/protobuf/bzy
    //   95: dup
    //   96: invokespecial 76	com/tencent/mm/protocal/protobuf/bzy:<init>	()V
    //   99: astore 5
    //   101: aload 5
    //   103: aload 11
    //   105: putfield 79	com/tencent/mm/protocal/protobuf/bzy:sid	Ljava/lang/String;
    //   108: aload 5
    //   110: aload 10
    //   112: ldc 81
    //   114: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 84	com/tencent/mm/protocal/protobuf/bzy:xLx	Ljava/lang/String;
    //   120: aload 5
    //   122: aload 10
    //   124: ldc 86
    //   126: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: putfield 89	com/tencent/mm/protocal/protobuf/bzy:xkf	Ljava/lang/String;
    //   132: aload 10
    //   134: ldc 91
    //   136: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   139: astore 11
    //   141: aload 11
    //   143: ifnull +27 -> 170
    //   146: aload 11
    //   148: invokevirtual 57	org/json/JSONArray:length	()I
    //   151: ifle +19 -> 170
    //   154: aload 5
    //   156: aload 11
    //   158: iconst_0
    //   159: invokevirtual 61	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   162: ldc 93
    //   164: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: putfield 96	com/tencent/mm/protocal/protobuf/bzy:xLy	Ljava/lang/String;
    //   170: aload 10
    //   172: invokestatic 100	com/tencent/mm/plugin/expt/hellhound/a/b/a/c:Z	(Lorg/json/JSONObject;)Ljava/util/List;
    //   175: astore 10
    //   177: aload 10
    //   179: ifnull +24 -> 203
    //   182: aload 10
    //   184: invokeinterface 106 1 0
    //   189: ifne +14 -> 203
    //   192: aload 5
    //   194: getfield 110	com/tencent/mm/protocal/protobuf/bzy:xLz	Ljava/util/LinkedList;
    //   197: aload 10
    //   199: invokevirtual 114	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   202: pop
    //   203: aload 7
    //   205: aload 5
    //   207: invokeinterface 118 2 0
    //   212: pop
    //   213: iload_1
    //   214: iconst_1
    //   215: iadd
    //   216: istore_1
    //   217: goto -160 -> 57
    //   220: astore_0
    //   221: ldc 120
    //   223: aload_0
    //   224: ldc 122
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: ldc 37
    //   235: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aconst_null
    //   239: areturn
    //   240: aload 11
    //   242: invokestatic 131	com/tencent/mm/plugin/expt/hellhound/a/b/a/b:MA	(Ljava/lang/String;)Z
    //   245: ifeq +169 -> 414
    //   248: new 133	com/tencent/mm/protocal/protobuf/caa
    //   251: dup
    //   252: invokespecial 134	com/tencent/mm/protocal/protobuf/caa:<init>	()V
    //   255: astore 5
    //   257: aload 5
    //   259: aload 11
    //   261: putfield 135	com/tencent/mm/protocal/protobuf/caa:sid	Ljava/lang/String;
    //   264: aload 5
    //   266: aload 10
    //   268: ldc 81
    //   270: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   273: putfield 136	com/tencent/mm/protocal/protobuf/caa:xLx	Ljava/lang/String;
    //   276: aload 5
    //   278: aload 10
    //   280: ldc 86
    //   282: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: putfield 137	com/tencent/mm/protocal/protobuf/caa:xkf	Ljava/lang/String;
    //   288: aload 10
    //   290: ldc 91
    //   292: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   295: astore 11
    //   297: aload 11
    //   299: ifnull +50 -> 349
    //   302: aload 11
    //   304: invokevirtual 57	org/json/JSONArray:length	()I
    //   307: iconst_1
    //   308: if_icmple +41 -> 349
    //   311: aload 11
    //   313: iconst_0
    //   314: invokevirtual 61	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   317: astore_0
    //   318: aload 11
    //   320: iconst_1
    //   321: invokevirtual 61	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   324: astore 11
    //   326: aload 5
    //   328: aload_0
    //   329: ldc 93
    //   331: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: putfield 140	com/tencent/mm/protocal/protobuf/caa:xLE	Ljava/lang/String;
    //   337: aload 5
    //   339: aload 11
    //   341: ldc 93
    //   343: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 143	com/tencent/mm/protocal/protobuf/caa:xLF	Ljava/lang/String;
    //   349: aload 10
    //   351: invokestatic 100	com/tencent/mm/plugin/expt/hellhound/a/b/a/c:Z	(Lorg/json/JSONObject;)Ljava/util/List;
    //   354: astore 10
    //   356: aload 5
    //   358: astore_0
    //   359: aload 10
    //   361: ifnull -148 -> 213
    //   364: aload 5
    //   366: astore_0
    //   367: aload 10
    //   369: invokeinterface 106 1 0
    //   374: ifne -161 -> 213
    //   377: aload 5
    //   379: getfield 144	com/tencent/mm/protocal/protobuf/caa:xLz	Ljava/util/LinkedList;
    //   382: aload 10
    //   384: invokevirtual 114	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   387: pop
    //   388: aload 5
    //   390: astore_0
    //   391: goto -178 -> 213
    //   394: astore_0
    //   395: ldc 120
    //   397: aload_0
    //   398: ldc 146
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: ldc 37
    //   409: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aconst_null
    //   413: areturn
    //   414: aload 10
    //   416: ldc 91
    //   418: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   421: astore 12
    //   423: aload 12
    //   425: ifnull +225 -> 650
    //   428: aload 12
    //   430: invokevirtual 57	org/json/JSONArray:length	()I
    //   433: ifle +217 -> 650
    //   436: new 148	com/tencent/mm/protocal/protobuf/cad
    //   439: dup
    //   440: invokespecial 149	com/tencent/mm/protocal/protobuf/cad:<init>	()V
    //   443: astore 5
    //   445: aload 5
    //   447: aload 11
    //   449: putfield 150	com/tencent/mm/protocal/protobuf/cad:sid	Ljava/lang/String;
    //   452: aload 5
    //   454: aload 10
    //   456: ldc 81
    //   458: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 151	com/tencent/mm/protocal/protobuf/cad:xLx	Ljava/lang/String;
    //   464: aload 5
    //   466: aload 10
    //   468: ldc 86
    //   470: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   473: putfield 152	com/tencent/mm/protocal/protobuf/cad:xkf	Ljava/lang/String;
    //   476: aload 12
    //   478: invokevirtual 57	org/json/JSONArray:length	()I
    //   481: istore 4
    //   483: new 154	java/util/ArrayList
    //   486: dup
    //   487: invokespecial 155	java/util/ArrayList:<init>	()V
    //   490: astore 11
    //   492: iconst_0
    //   493: istore_2
    //   494: iload_2
    //   495: iload 4
    //   497: if_icmpge +86 -> 583
    //   500: aload 12
    //   502: iload_2
    //   503: invokevirtual 61	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   506: astore 13
    //   508: aload 13
    //   510: ifnull +276 -> 786
    //   513: new 157	com/tencent/mm/protocal/protobuf/cac
    //   516: dup
    //   517: invokespecial 158	com/tencent/mm/protocal/protobuf/cac:<init>	()V
    //   520: astore 14
    //   522: aload 14
    //   524: aload 13
    //   526: ldc 160
    //   528: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: putfield 162	com/tencent/mm/protocal/protobuf/cac:className	Ljava/lang/String;
    //   534: aload 14
    //   536: aload 13
    //   538: ldc 164
    //   540: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   543: putfield 166	com/tencent/mm/protocal/protobuf/cac:dataPath	Ljava/lang/String;
    //   546: aload 14
    //   548: aload 13
    //   550: ldc 93
    //   552: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   555: putfield 167	com/tencent/mm/protocal/protobuf/cac:xLy	Ljava/lang/String;
    //   558: aload 14
    //   560: aload 13
    //   562: ldc 169
    //   564: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   567: putfield 176	com/tencent/mm/protocal/protobuf/cac:action	I
    //   570: aload 11
    //   572: aload 14
    //   574: invokeinterface 118 2 0
    //   579: pop
    //   580: goto +206 -> 786
    //   583: aload 11
    //   585: invokeinterface 106 1 0
    //   590: ifne +14 -> 604
    //   593: aload 5
    //   595: getfield 179	com/tencent/mm/protocal/protobuf/cad:xLG	Ljava/util/LinkedList;
    //   598: aload 11
    //   600: invokevirtual 114	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   603: pop
    //   604: aload 10
    //   606: invokestatic 100	com/tencent/mm/plugin/expt/hellhound/a/b/a/c:Z	(Lorg/json/JSONObject;)Ljava/util/List;
    //   609: astore 10
    //   611: aload 10
    //   613: ifnull +24 -> 637
    //   616: aload 10
    //   618: invokeinterface 106 1 0
    //   623: ifne +14 -> 637
    //   626: aload 5
    //   628: getfield 180	com/tencent/mm/protocal/protobuf/cad:xLz	Ljava/util/LinkedList;
    //   631: aload 10
    //   633: invokevirtual 114	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   636: pop
    //   637: aload 8
    //   639: aload 5
    //   641: invokeinterface 118 2 0
    //   646: pop
    //   647: goto -434 -> 213
    //   650: new 182	com/tencent/mm/protocal/protobuf/cab
    //   653: dup
    //   654: invokespecial 183	com/tencent/mm/protocal/protobuf/cab:<init>	()V
    //   657: astore 5
    //   659: aload 5
    //   661: aload 11
    //   663: putfield 184	com/tencent/mm/protocal/protobuf/cab:sid	Ljava/lang/String;
    //   666: aload 5
    //   668: aload 10
    //   670: ldc 81
    //   672: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   675: putfield 185	com/tencent/mm/protocal/protobuf/cab:xLx	Ljava/lang/String;
    //   678: aload 5
    //   680: aload 10
    //   682: ldc 86
    //   684: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   687: putfield 186	com/tencent/mm/protocal/protobuf/cab:xkf	Ljava/lang/String;
    //   690: aload 10
    //   692: invokestatic 100	com/tencent/mm/plugin/expt/hellhound/a/b/a/c:Z	(Lorg/json/JSONObject;)Ljava/util/List;
    //   695: astore 10
    //   697: aload 10
    //   699: ifnull +24 -> 723
    //   702: aload 10
    //   704: invokeinterface 106 1 0
    //   709: ifne +14 -> 723
    //   712: aload 5
    //   714: getfield 187	com/tencent/mm/protocal/protobuf/cab:xLz	Ljava/util/LinkedList;
    //   717: aload 10
    //   719: invokevirtual 114	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   722: pop
    //   723: aload 6
    //   725: aload 5
    //   727: invokeinterface 118 2 0
    //   732: pop
    //   733: goto -520 -> 213
    //   736: new 189	com/tencent/mm/vending/j/e
    //   739: dup
    //   740: invokespecial 190	com/tencent/mm/vending/j/e:<init>	()V
    //   743: astore 5
    //   745: aload 5
    //   747: iconst_4
    //   748: anewarray 4	java/lang/Object
    //   751: dup
    //   752: iconst_0
    //   753: aload 6
    //   755: aastore
    //   756: dup
    //   757: iconst_1
    //   758: aload 7
    //   760: aastore
    //   761: dup
    //   762: iconst_2
    //   763: aload_0
    //   764: aastore
    //   765: dup
    //   766: iconst_3
    //   767: aload 8
    //   769: aastore
    //   770: putfield 196	com/tencent/mm/vending/j/a:a	[Ljava/lang/Object;
    //   773: aload 5
    //   775: checkcast 189	com/tencent/mm/vending/j/e
    //   778: astore_0
    //   779: ldc 37
    //   781: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   784: aload_0
    //   785: areturn
    //   786: iload_2
    //   787: iconst_1
    //   788: iadd
    //   789: istore_2
    //   790: goto -296 -> 494
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	paramString	java.lang.String
    //   56	161	1	i	int
    //   493	297	2	j	int
    //   54	6	3	k	int
    //   481	17	4	m	int
    //   99	675	5	localObject1	Object
    //   27	727	6	localLinkedList1	LinkedList
    //   36	723	7	localLinkedList2	LinkedList
    //   47	721	8	localLinkedList3	LinkedList
    //   18	45	9	localJSONArray1	JSONArray
    //   68	650	10	localObject2	Object
    //   82	580	11	localObject3	Object
    //   421	80	12	localJSONArray2	JSONArray
    //   506	55	13	localJSONObject	JSONObject
    //   520	53	14	localcac	com.tencent.mm.protocal.protobuf.cac
    // Exception table:
    //   from	to	target	type
    //   5	20	220	org/json/JSONException
    //   62	70	394	java/lang/Exception
    //   75	141	394	java/lang/Exception
    //   146	170	394	java/lang/Exception
    //   170	177	394	java/lang/Exception
    //   182	203	394	java/lang/Exception
    //   203	213	394	java/lang/Exception
    //   240	297	394	java/lang/Exception
    //   302	349	394	java/lang/Exception
    //   349	356	394	java/lang/Exception
    //   367	388	394	java/lang/Exception
    //   414	423	394	java/lang/Exception
    //   428	492	394	java/lang/Exception
    //   500	508	394	java/lang/Exception
    //   513	580	394	java/lang/Exception
    //   583	604	394	java/lang/Exception
    //   604	611	394	java/lang/Exception
    //   616	637	394	java/lang/Exception
    //   637	647	394	java/lang/Exception
    //   650	697	394	java/lang/Exception
    //   702	723	394	java/lang/Exception
    //   723	733	394	java/lang/Exception
  }
  
  private static List<cae> Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(152365);
    paramJSONObject = paramJSONObject.optJSONArray("pagePaths");
    int j;
    if (paramJSONObject != null)
    {
      j = paramJSONObject.length();
      if (j > 0) {}
    }
    else
    {
      ab.i("HellSessionCloudConfig", "HABBYGE-MALI, getSessionPages == NULL");
      AppMethodBeat.o(152365);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramJSONObject.optJSONObject(i);
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).optJSONArray("pagePathUnits");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(0);
          localObject1 = new cae();
          ((cae)localObject1).xkf = ((JSONObject)localObject2).optString("pageName");
          localObject2 = ((JSONObject)localObject2).optJSONArray("businessParams");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            localObject2 = t((JSONArray)localObject2);
            ((cae)localObject1).xLH.addAll((Collection)localObject2);
          }
          localLinkedList.add(localObject1);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(152365);
    return localLinkedList;
  }
  
  public static c bsb()
  {
    AppMethodBeat.i(152360);
    if (maT == null) {}
    try
    {
      if (maT == null) {
        maT = new c();
      }
      c localc = maT;
      AppMethodBeat.o(152360);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(152360);
    }
  }
  
  public static bzz bsc()
  {
    AppMethodBeat.i(152361);
    bzz localbzz = b.bsn();
    AppMethodBeat.o(152361);
    return localbzz;
  }
  
  public static boolean bsd()
  {
    AppMethodBeat.i(152362);
    bzz localbzz = b.bsn();
    if (localbzz == null)
    {
      AppMethodBeat.o(152362);
      return true;
    }
    boolean bool = localbzz.eht;
    AppMethodBeat.o(152362);
    return bool;
  }
  
  public static boolean bse()
  {
    AppMethodBeat.i(152363);
    bzz localbzz = b.bsn();
    if (localbzz == null)
    {
      AppMethodBeat.o(152363);
      return false;
    }
    boolean bool = localbzz.mzI;
    AppMethodBeat.o(152363);
    return bool;
  }
  
  private static List<bkh> t(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(152366);
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        bkh localbkh = new bkh();
        localbkh.className = localJSONObject.optString("className");
        localbkh.dataPath = localJSONObject.optString("dataPath");
        localbkh.action = localJSONObject.optString("action");
        localArrayList.add(localbkh);
      }
      i += 1;
    }
    AppMethodBeat.o(152366);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */