package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d
  implements i
{
  private boolean hJi;
  Object lock;
  private Random mxF;
  private boolean nzW;
  List<String> veN;
  HashSet<String> veO;
  e.d veP;
  com.tencent.mm.am.h veQ;
  boolean veR;
  private long veS;
  private long veT;
  int veU;
  int veV;
  
  public d()
  {
    AppMethodBeat.i(21887);
    this.lock = new Object();
    this.mxF = new Random();
    this.hJi = false;
    this.nzW = false;
    this.veN = new LinkedList();
    this.veO = new HashSet();
    this.veR = false;
    this.veV = 0;
    AppMethodBeat.o(21887);
  }
  
  private static String a(Random paramRandom)
  {
    AppMethodBeat.i(21893);
    paramRandom = g.getMessageDigest((Util.currentTicks() + paramRandom.nextDouble()).getBytes());
    AppMethodBeat.o(21893);
    return paramRandom;
  }
  
  /* Error */
  public final boolean P(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: sipush 21891
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 119	com/tencent/mm/pointers/PLong
    //   9: dup
    //   10: invokespecial 120	com/tencent/mm/pointers/PLong:<init>	()V
    //   13: astore 8
    //   15: invokestatic 126	com/tencent/mm/plugin/backup/bakoldlogic/d/b:cXr	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/b;
    //   18: invokevirtual 130	com/tencent/mm/plugin/backup/bakoldlogic/d/b:cXs	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/c;
    //   21: invokevirtual 136	com/tencent/mm/plugin/backup/bakoldlogic/d/c:bzD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   24: aload_1
    //   25: invokeinterface 142 2 0
    //   30: astore 7
    //   32: new 57	java/util/LinkedList
    //   35: dup
    //   36: invokespecial 58	java/util/LinkedList:<init>	()V
    //   39: astore 6
    //   41: new 57	java/util/LinkedList
    //   44: dup
    //   45: invokespecial 58	java/util/LinkedList:<init>	()V
    //   48: astore 9
    //   50: aload 6
    //   52: astore_1
    //   53: aload 7
    //   55: invokeinterface 148 1 0
    //   60: ifeq +888 -> 948
    //   63: aload 7
    //   65: invokeinterface 151 1 0
    //   70: ifne +1017 -> 1087
    //   73: aload_0
    //   74: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   84: invokevirtual 155	java/util/HashSet:size	()I
    //   87: istore 4
    //   89: iload 4
    //   91: bipush 10
    //   93: if_icmple +10 -> 103
    //   96: aload_0
    //   97: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   100: invokevirtual 158	java/lang/Object:wait	()V
    //   103: aload_0
    //   104: getfield 53	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hJi	Z
    //   107: ifeq +21 -> 128
    //   110: aload_0
    //   111: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nzW	Z
    //   114: istore 5
    //   116: iload 5
    //   118: ifne +10 -> 128
    //   121: aload_0
    //   122: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   125: invokevirtual 158	java/lang/Object:wait	()V
    //   128: aload_0
    //   129: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nzW	Z
    //   132: ifeq +72 -> 204
    //   135: ldc 160
    //   137: ldc 162
    //   139: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: monitorexit
    //   144: aload 7
    //   146: invokeinterface 170 1 0
    //   151: sipush 21891
    //   154: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore 10
    //   161: ldc 160
    //   163: aload 10
    //   165: ldc 172
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -46 -> 128
    //   177: astore_2
    //   178: aload_1
    //   179: monitorexit
    //   180: sipush 21891
    //   183: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_2
    //   187: athrow
    //   188: astore_1
    //   189: aload 7
    //   191: invokeinterface 170 1 0
    //   196: sipush 21891
    //   199: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: aload_1
    //   205: monitorexit
    //   206: new 178	com/tencent/mm/storage/cc
    //   209: dup
    //   210: invokespecial 179	com/tencent/mm/storage/cc:<init>	()V
    //   213: astore 10
    //   215: aload 10
    //   217: aload 7
    //   219: invokevirtual 183	com/tencent/mm/storage/cc:convertFrom	(Landroid/database/Cursor;)V
    //   222: iload_3
    //   223: ifle +187 -> 410
    //   226: iconst_1
    //   227: istore 4
    //   229: aload 10
    //   231: getfield 188	com/tencent/mm/autogen/b/fi:field_msgSvrId	J
    //   234: lconst_0
    //   235: lcmp
    //   236: ifne +180 -> 416
    //   239: ldc 190
    //   241: ldc 192
    //   243: iconst_2
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload 10
    //   251: getfield 196	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload 10
    //   259: invokevirtual 199	com/tencent/mm/storage/cc:getType	()I
    //   262: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aconst_null
    //   270: astore_1
    //   271: iload_3
    //   272: iconst_1
    //   273: isub
    //   274: istore_3
    //   275: aload_1
    //   276: ifnull +10 -> 286
    //   279: aload 6
    //   281: aload_1
    //   282: invokevirtual 213	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload 9
    //   288: invokevirtual 217	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   291: astore 10
    //   293: aload 10
    //   295: invokeinterface 222 1 0
    //   300: ifeq +480 -> 780
    //   303: aload 10
    //   305: invokeinterface 226 1 0
    //   310: checkcast 228	com/tencent/mm/plugin/backup/i/u
    //   313: astore 11
    //   315: new 230	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   318: dup
    //   319: aload 11
    //   321: getfield 233	com/tencent/mm/plugin/backup/i/u:mediaId	Ljava/lang/String;
    //   324: iconst_2
    //   325: aconst_null
    //   326: aload 11
    //   328: getfield 236	com/tencent/mm/plugin/backup/i/u:path	Ljava/lang/String;
    //   331: aload_0
    //   332: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cWU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   335: getfield 248	com/tencent/mm/plugin/backup/b/d:uWe	[B
    //   338: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/am/i;[B)V
    //   341: astore 12
    //   343: aload_0
    //   344: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: aload 12
    //   352: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:cWw	()Z
    //   355: pop
    //   356: aload_0
    //   357: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   360: aload 11
    //   362: getfield 233	com/tencent/mm/plugin/backup/i/u:mediaId	Ljava/lang/String;
    //   365: invokevirtual 255	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   368: pop
    //   369: ldc 160
    //   371: ldc_w 257
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_0
    //   381: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   384: invokevirtual 155	java/util/HashSet:size	()I
    //   387: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload_1
    //   395: monitorexit
    //   396: goto -103 -> 293
    //   399: astore_2
    //   400: aload_1
    //   401: monitorexit
    //   402: sipush 21891
    //   405: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload_2
    //   409: athrow
    //   410: iconst_0
    //   411: istore 4
    //   413: goto -184 -> 229
    //   416: new 261	com/tencent/mm/protocal/protobuf/jd
    //   419: dup
    //   420: invokespecial 262	com/tencent/mm/protocal/protobuf/jd:<init>	()V
    //   423: astore_1
    //   424: aload_1
    //   425: aload 10
    //   427: getfield 188	com/tencent/mm/autogen/b/fi:field_msgSvrId	J
    //   430: putfield 265	com/tencent/mm/protocal/protobuf/jd:Njv	J
    //   433: aload 10
    //   435: getfield 268	com/tencent/mm/autogen/b/fi:field_isSend	I
    //   438: iconst_1
    //   439: if_icmpne +207 -> 646
    //   442: aload_1
    //   443: new 270	com/tencent/mm/protocal/protobuf/etl
    //   446: dup
    //   447: invokespecial 271	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   450: aload_2
    //   451: invokevirtual 275	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   454: putfield 279	com/tencent/mm/protocal/protobuf/jd:YFE	Lcom/tencent/mm/protocal/protobuf/etl;
    //   457: aload_1
    //   458: new 270	com/tencent/mm/protocal/protobuf/etl
    //   461: dup
    //   462: invokespecial 271	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   465: aload 10
    //   467: getfield 196	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   470: invokevirtual 275	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   473: putfield 282	com/tencent/mm/protocal/protobuf/jd:YFF	Lcom/tencent/mm/protocal/protobuf/etl;
    //   476: iconst_2
    //   477: istore 4
    //   479: aload_1
    //   480: iload 4
    //   482: putfield 285	com/tencent/mm/protocal/protobuf/jd:YKV	I
    //   485: aload_1
    //   486: new 287	com/tencent/mm/protocal/protobuf/gol
    //   489: dup
    //   490: invokespecial 288	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   493: putfield 292	com/tencent/mm/protocal/protobuf/jd:YLa	Lcom/tencent/mm/protocal/protobuf/gol;
    //   496: aload_1
    //   497: iconst_0
    //   498: putfield 295	com/tencent/mm/protocal/protobuf/jd:YLb	I
    //   501: aload_1
    //   502: iconst_0
    //   503: putfield 298	com/tencent/mm/protocal/protobuf/jd:YLc	I
    //   506: aload_1
    //   507: ldc 172
    //   509: putfield 301	com/tencent/mm/protocal/protobuf/jd:YFJ	Ljava/lang/String;
    //   512: aload_1
    //   513: aload 10
    //   515: invokevirtual 199	com/tencent/mm/storage/cc:getType	()I
    //   518: invokestatic 307	com/tencent/mm/pluginsdk/model/app/n:va	(I)I
    //   521: putfield 310	com/tencent/mm/protocal/protobuf/jd:vhJ	I
    //   524: aload_1
    //   525: aload 10
    //   527: invokevirtual 313	com/tencent/mm/storage/cc:getCreateTime	()J
    //   530: ldc2_w 314
    //   533: ldiv
    //   534: l2i
    //   535: putfield 318	com/tencent/mm/protocal/protobuf/jd:YKW	I
    //   538: aload_1
    //   539: aload 10
    //   541: invokevirtual 313	com/tencent/mm/storage/cc:getCreateTime	()J
    //   544: putfield 321	com/tencent/mm/protocal/protobuf/jd:YLe	J
    //   547: aload_1
    //   548: aload 10
    //   550: getfield 324	com/tencent/mm/autogen/b/fi:field_msgSeq	J
    //   553: l2i
    //   554: putfield 327	com/tencent/mm/protocal/protobuf/jd:YLd	I
    //   557: aload_1
    //   558: aload 10
    //   560: getfield 330	com/tencent/mm/autogen/b/fi:field_flag	I
    //   563: putfield 333	com/tencent/mm/protocal/protobuf/jd:YLf	I
    //   566: new 270	com/tencent/mm/protocal/protobuf/etl
    //   569: dup
    //   570: invokespecial 271	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   573: astore 11
    //   575: aload 11
    //   577: aload 10
    //   579: getfield 336	com/tencent/mm/autogen/b/fi:field_content	Ljava/lang/String;
    //   582: ldc 172
    //   584: invokestatic 340	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   587: invokevirtual 275	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   590: pop
    //   591: aload_1
    //   592: aload 11
    //   594: putfield 343	com/tencent/mm/protocal/protobuf/jd:YFG	Lcom/tencent/mm/protocal/protobuf/etl;
    //   597: invokestatic 349	com/tencent/mm/plugin/backup/bakoldlogic/b/d:cWT	()Lcom/tencent/mm/plugin/backup/bakoldlogic/b/d;
    //   600: aload 10
    //   602: invokevirtual 199	com/tencent/mm/storage/cc:getType	()I
    //   605: invokestatic 307	com/tencent/mm/pluginsdk/model/app/n:va	(I)I
    //   608: invokevirtual 353	com/tencent/mm/plugin/backup/bakoldlogic/b/d:Fv	(I)Lcom/tencent/mm/plugin/backup/bakoldlogic/b/j;
    //   611: astore 11
    //   613: aload 11
    //   615: ifnonnull +76 -> 691
    //   618: ldc 190
    //   620: ldc_w 355
    //   623: iconst_1
    //   624: anewarray 4	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: aload 10
    //   631: invokevirtual 199	com/tencent/mm/storage/cc:getType	()I
    //   634: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aconst_null
    //   642: astore_1
    //   643: goto -372 -> 271
    //   646: aload_1
    //   647: new 270	com/tencent/mm/protocal/protobuf/etl
    //   650: dup
    //   651: invokespecial 271	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   654: aload 10
    //   656: getfield 196	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   659: invokevirtual 275	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   662: putfield 279	com/tencent/mm/protocal/protobuf/jd:YFE	Lcom/tencent/mm/protocal/protobuf/etl;
    //   665: aload_1
    //   666: new 270	com/tencent/mm/protocal/protobuf/etl
    //   669: dup
    //   670: invokespecial 271	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   673: aload_2
    //   674: invokevirtual 275	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   677: putfield 282	com/tencent/mm/protocal/protobuf/jd:YFF	Lcom/tencent/mm/protocal/protobuf/etl;
    //   680: iload 4
    //   682: ifeq +399 -> 1081
    //   685: iconst_3
    //   686: istore 4
    //   688: goto -209 -> 479
    //   691: aload 11
    //   693: aload_1
    //   694: aload 10
    //   696: aload_2
    //   697: aload 9
    //   699: invokeinterface 363 5 0
    //   704: istore 4
    //   706: iload 4
    //   708: ifge +8 -> 716
    //   711: aconst_null
    //   712: astore_1
    //   713: goto -442 -> 271
    //   716: aload 8
    //   718: aload 8
    //   720: getfield 366	com/tencent/mm/pointers/PLong:value	J
    //   723: iload 4
    //   725: i2l
    //   726: ladd
    //   727: putfield 366	com/tencent/mm/pointers/PLong:value	J
    //   730: aload 8
    //   732: aload 8
    //   734: getfield 366	com/tencent/mm/pointers/PLong:value	J
    //   737: ldc2_w 367
    //   740: ladd
    //   741: putfield 366	com/tencent/mm/pointers/PLong:value	J
    //   744: goto -473 -> 271
    //   747: astore_1
    //   748: ldc 160
    //   750: aload_1
    //   751: ldc 172
    //   753: iconst_0
    //   754: anewarray 4	java/lang/Object
    //   757: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   760: ldc 160
    //   762: ldc_w 370
    //   765: aload_1
    //   766: invokestatic 373	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   769: invokevirtual 377	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   772: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   775: aconst_null
    //   776: astore_1
    //   777: goto -502 -> 275
    //   780: aload 9
    //   782: invokevirtual 383	java/util/LinkedList:clear	()V
    //   785: aload 6
    //   787: astore_1
    //   788: aload 8
    //   790: getfield 366	com/tencent/mm/pointers/PLong:value	J
    //   793: ldc2_w 384
    //   796: lcmp
    //   797: ifle +125 -> 922
    //   800: ldc 160
    //   802: new 77	java/lang/StringBuilder
    //   805: dup
    //   806: ldc_w 387
    //   809: invokespecial 390	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   812: aload 8
    //   814: getfield 366	com/tencent/mm/pointers/PLong:value	J
    //   817: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   820: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 392	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: aload_0
    //   827: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:mxF	Ljava/util/Random;
    //   830: invokestatic 394	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:a	(Ljava/util/Random;)Ljava/lang/String;
    //   833: astore_1
    //   834: new 230	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   837: dup
    //   838: aload_1
    //   839: iconst_1
    //   840: aload 6
    //   842: ldc 172
    //   844: aload_0
    //   845: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cWU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   848: getfield 248	com/tencent/mm/plugin/backup/b/d:uWe	[B
    //   851: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/am/i;[B)V
    //   854: astore 10
    //   856: aload_0
    //   857: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   860: astore 6
    //   862: aload 6
    //   864: monitorenter
    //   865: aload 10
    //   867: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:cWw	()Z
    //   870: pop
    //   871: aload_0
    //   872: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   875: aload_1
    //   876: invokevirtual 255	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   879: pop
    //   880: ldc 160
    //   882: ldc_w 257
    //   885: iconst_1
    //   886: anewarray 4	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: aload_0
    //   892: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   895: invokevirtual 155	java/util/HashSet:size	()I
    //   898: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   901: aastore
    //   902: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: aload 6
    //   907: monitorexit
    //   908: new 57	java/util/LinkedList
    //   911: dup
    //   912: invokespecial 58	java/util/LinkedList:<init>	()V
    //   915: astore_1
    //   916: aload 8
    //   918: lconst_0
    //   919: putfield 366	com/tencent/mm/pointers/PLong:value	J
    //   922: aload 7
    //   924: invokeinterface 397 1 0
    //   929: pop
    //   930: aload_1
    //   931: astore 6
    //   933: goto -870 -> 63
    //   936: astore_1
    //   937: aload 6
    //   939: monitorexit
    //   940: sipush 21891
    //   943: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: aload_1
    //   947: athrow
    //   948: aload 8
    //   950: getfield 366	com/tencent/mm/pointers/PLong:value	J
    //   953: lconst_0
    //   954: lcmp
    //   955: ifle +95 -> 1050
    //   958: aload_0
    //   959: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:mxF	Ljava/util/Random;
    //   962: invokestatic 394	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:a	(Ljava/util/Random;)Ljava/lang/String;
    //   965: astore_2
    //   966: new 230	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   969: dup
    //   970: aload_2
    //   971: iconst_1
    //   972: aload_1
    //   973: ldc 172
    //   975: aload_0
    //   976: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cWU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   979: getfield 248	com/tencent/mm/plugin/backup/b/d:uWe	[B
    //   982: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/am/i;[B)V
    //   985: astore 6
    //   987: aload_0
    //   988: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   991: astore_1
    //   992: aload_1
    //   993: monitorenter
    //   994: aload 6
    //   996: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:cWw	()Z
    //   999: pop
    //   1000: aload_0
    //   1001: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   1004: aload_2
    //   1005: invokevirtual 255	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1008: pop
    //   1009: ldc 160
    //   1011: ldc_w 257
    //   1014: iconst_1
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload_0
    //   1021: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:veO	Ljava/util/HashSet;
    //   1024: invokevirtual 155	java/util/HashSet:size	()I
    //   1027: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: aastore
    //   1031: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: aload_1
    //   1035: monitorexit
    //   1036: aload 8
    //   1038: lconst_0
    //   1039: putfield 366	com/tencent/mm/pointers/PLong:value	J
    //   1042: new 57	java/util/LinkedList
    //   1045: dup
    //   1046: invokespecial 58	java/util/LinkedList:<init>	()V
    //   1049: pop
    //   1050: aload 7
    //   1052: invokeinterface 170 1 0
    //   1057: sipush 21891
    //   1060: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1063: iconst_1
    //   1064: ireturn
    //   1065: astore_2
    //   1066: aload_1
    //   1067: monitorexit
    //   1068: sipush 21891
    //   1071: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1074: aload_2
    //   1075: athrow
    //   1076: astore 10
    //   1078: goto -975 -> 103
    //   1081: iconst_4
    //   1082: istore 4
    //   1084: goto -605 -> 479
    //   1087: aload 6
    //   1089: astore_1
    //   1090: goto -142 -> 948
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1093	0	this	d
    //   0	1093	2	paramString2	String
    //   0	1093	3	paramInt	int
    //   87	996	4	i	int
    //   114	3	5	bool	boolean
    //   30	1021	7	localCursor	android.database.Cursor
    //   13	1024	8	localPLong	com.tencent.mm.pointers.PLong
    //   48	733	9	localLinkedList	LinkedList
    //   159	5	10	localInterruptedException1	java.lang.InterruptedException
    //   213	653	10	localObject2	Object
    //   1076	1	10	localInterruptedException2	java.lang.InterruptedException
    //   313	379	11	localObject3	Object
    //   341	10	12	localc	com.tencent.mm.plugin.backup.bakoldlogic.c.c
    // Exception table:
    //   from	to	target	type
    //   121	128	159	java/lang/InterruptedException
    //   80	89	177	finally
    //   96	103	177	finally
    //   103	116	177	finally
    //   121	128	177	finally
    //   128	144	177	finally
    //   161	174	177	finally
    //   53	63	188	finally
    //   63	80	188	finally
    //   178	188	188	finally
    //   204	222	188	finally
    //   229	269	188	finally
    //   279	286	188	finally
    //   286	293	188	finally
    //   293	350	188	finally
    //   400	410	188	finally
    //   416	476	188	finally
    //   479	613	188	finally
    //   618	641	188	finally
    //   646	680	188	finally
    //   691	706	188	finally
    //   716	744	188	finally
    //   748	775	188	finally
    //   780	785	188	finally
    //   788	865	188	finally
    //   908	922	188	finally
    //   922	930	188	finally
    //   937	948	188	finally
    //   948	994	188	finally
    //   1036	1050	188	finally
    //   1066	1076	188	finally
    //   350	396	399	finally
    //   229	269	747	java/lang/Exception
    //   416	476	747	java/lang/Exception
    //   479	613	747	java/lang/Exception
    //   618	641	747	java/lang/Exception
    //   646	680	747	java/lang/Exception
    //   691	706	747	java/lang/Exception
    //   716	744	747	java/lang/Exception
    //   865	908	936	finally
    //   994	1036	1065	finally
    //   96	103	1076	java/lang/InterruptedException
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(21894);
    this.veT += paramInt1;
    if (this.veS == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.veT * 100L / this.veS))
    {
      if (paramInt1 > this.veU)
      {
        this.veU = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.veU);
        if ((!this.hJi) && (!this.nzW) && (this.veP != null) && (this.veU >= 0) && (this.veU <= 100)) {
          this.veP.FA(this.veU);
        }
      }
      AppMethodBeat.o(21894);
      return;
    }
  }
  
  final void cXb()
  {
    AppMethodBeat.i(21892);
    if ((!this.veR) || (this.nzW))
    {
      AppMethodBeat.o(21892);
      return;
    }
    synchronized (this.lock)
    {
      if (this.veO.isEmpty())
      {
        a.cWU().cWV().vfh = 4;
        a.cWU().cWV().vfi = 3;
        com.tencent.mm.plugin.backup.g.b.b(5, this.veQ);
        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).cWw();
        c localc = a.cWU().cWW();
        localc.veJ += 1;
        if (this.veP != null)
        {
          this.veP.cXi();
          cancel();
          Log.i("MicroMsg.BakPCServer", "send backup finish cmd");
        }
      }
      else
      {
        AppMethodBeat.o(21892);
        return;
      }
      Log.i("MicroMsg.BakPCServer", "operatorCallback is null");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21890);
    Log.i("MicroMsg.BakPCServer", "cancel");
    this.nzW = true;
    com.tencent.mm.plugin.backup.g.b.b(5, this.veQ);
    this.veP = null;
    this.veR = false;
    this.veU = 0;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21890);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(21888);
    Log.i("MicroMsg.BakPCServer", "pause");
    this.hJi = true;
    AppMethodBeat.o(21888);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21889);
    Log.i("MicroMsg.BakPCServer", "resume");
    this.hJi = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21889);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d
 * JD-Core Version:    0.7.0.1
 */