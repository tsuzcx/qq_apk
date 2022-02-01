package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d
  implements com.tencent.mm.ak.g
{
  private boolean dus;
  private Random gzo;
  private boolean hmD;
  Object lock;
  List<String> nGB;
  HashSet<String> nGC;
  e.d nGD;
  f nGE;
  boolean nGF;
  private long nGG;
  private long nGH;
  int nGI;
  int nGJ;
  
  public d()
  {
    AppMethodBeat.i(21887);
    this.lock = new Object();
    this.gzo = new Random();
    this.dus = false;
    this.hmD = false;
    this.nGB = new LinkedList();
    this.nGC = new HashSet();
    this.nGF = false;
    this.nGJ = 0;
    AppMethodBeat.o(21887);
  }
  
  private static String b(Random paramRandom)
  {
    AppMethodBeat.i(21893);
    paramRandom = com.tencent.mm.b.g.getMessageDigest((bu.HQ() + paramRandom.nextDouble()).getBytes());
    AppMethodBeat.o(21893);
    return paramRandom;
  }
  
  /* Error */
  public final boolean G(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: sipush 21891
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 119	com/tencent/mm/pointers/PLong
    //   9: dup
    //   10: invokespecial 120	com/tencent/mm/pointers/PLong:<init>	()V
    //   13: astore 8
    //   15: invokestatic 126	com/tencent/mm/plugin/backup/bakoldlogic/d/b:bKD	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/b;
    //   18: invokevirtual 130	com/tencent/mm/plugin/backup/bakoldlogic/d/b:bKE	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/c;
    //   21: invokevirtual 136	com/tencent/mm/plugin/backup/bakoldlogic/d/c:azI	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
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
    //   60: ifeq +887 -> 947
    //   63: aload 7
    //   65: invokeinterface 151 1 0
    //   70: ifne +1016 -> 1086
    //   73: aload_0
    //   74: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   84: invokevirtual 155	java/util/HashSet:size	()I
    //   87: istore 4
    //   89: iload 4
    //   91: bipush 10
    //   93: if_icmple +10 -> 103
    //   96: aload_0
    //   97: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   100: invokevirtual 158	java/lang/Object:wait	()V
    //   103: aload_0
    //   104: getfield 53	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:dus	Z
    //   107: ifeq +21 -> 128
    //   110: aload_0
    //   111: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hmD	Z
    //   114: istore 5
    //   116: iload 5
    //   118: ifne +10 -> 128
    //   121: aload_0
    //   122: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   125: invokevirtual 158	java/lang/Object:wait	()V
    //   128: aload_0
    //   129: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hmD	Z
    //   132: ifeq +72 -> 204
    //   135: ldc 160
    //   137: ldc 162
    //   139: invokestatic 167	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   171: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   206: new 178	com/tencent/mm/storage/bv
    //   209: dup
    //   210: invokespecial 179	com/tencent/mm/storage/bv:<init>	()V
    //   213: astore 10
    //   215: aload 10
    //   217: aload 7
    //   219: invokevirtual 183	com/tencent/mm/storage/bv:convertFrom	(Landroid/database/Cursor;)V
    //   222: iload_3
    //   223: ifle +187 -> 410
    //   226: iconst_1
    //   227: istore 4
    //   229: aload 10
    //   231: getfield 188	com/tencent/mm/g/c/ei:field_msgSvrId	J
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
    //   251: getfield 196	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload 10
    //   259: invokevirtual 199	com/tencent/mm/storage/bv:getType	()I
    //   262: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 209	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   300: ifeq +479 -> 779
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
    //   332: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:bKg	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   335: getfield 248	com/tencent/mm/plugin/backup/b/d:nyc	[B
    //   338: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ak/g;[B)V
    //   341: astore 12
    //   343: aload_0
    //   344: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: aload 12
    //   352: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:bJH	()Z
    //   355: pop
    //   356: aload_0
    //   357: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
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
    //   381: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   384: invokevirtual 155	java/util/HashSet:size	()I
    //   387: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   416: new 261	com/tencent/mm/protocal/protobuf/if
    //   419: dup
    //   420: invokespecial 262	com/tencent/mm/protocal/protobuf/if:<init>	()V
    //   423: astore_1
    //   424: aload_1
    //   425: aload 10
    //   427: getfield 188	com/tencent/mm/g/c/ei:field_msgSvrId	J
    //   430: putfield 265	com/tencent/mm/protocal/protobuf/if:xrk	J
    //   433: aload 10
    //   435: getfield 268	com/tencent/mm/g/c/ei:field_isSend	I
    //   438: iconst_1
    //   439: if_icmpne +207 -> 646
    //   442: aload_1
    //   443: new 270	com/tencent/mm/protocal/protobuf/cxn
    //   446: dup
    //   447: invokespecial 271	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   450: aload_2
    //   451: invokevirtual 275	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   454: putfield 279	com/tencent/mm/protocal/protobuf/if:FNG	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   457: aload_1
    //   458: new 270	com/tencent/mm/protocal/protobuf/cxn
    //   461: dup
    //   462: invokespecial 271	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   465: aload 10
    //   467: getfield 196	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
    //   470: invokevirtual 275	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   473: putfield 282	com/tencent/mm/protocal/protobuf/if:FNH	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   476: iconst_2
    //   477: istore 4
    //   479: aload_1
    //   480: iload 4
    //   482: putfield 285	com/tencent/mm/protocal/protobuf/if:FTe	I
    //   485: aload_1
    //   486: new 287	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   489: dup
    //   490: invokespecial 288	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   493: putfield 292	com/tencent/mm/protocal/protobuf/if:FTj	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   496: aload_1
    //   497: iconst_0
    //   498: putfield 295	com/tencent/mm/protocal/protobuf/if:FTk	I
    //   501: aload_1
    //   502: iconst_0
    //   503: putfield 298	com/tencent/mm/protocal/protobuf/if:FTl	I
    //   506: aload_1
    //   507: ldc 172
    //   509: putfield 301	com/tencent/mm/protocal/protobuf/if:FNL	Ljava/lang/String;
    //   512: aload_1
    //   513: aload 10
    //   515: invokevirtual 199	com/tencent/mm/storage/bv:getType	()I
    //   518: invokestatic 307	com/tencent/mm/pluginsdk/model/app/m:Zb	(I)I
    //   521: putfield 310	com/tencent/mm/protocal/protobuf/if:nJA	I
    //   524: aload_1
    //   525: aload 10
    //   527: getfield 313	com/tencent/mm/g/c/ei:field_createTime	J
    //   530: ldc2_w 314
    //   533: ldiv
    //   534: l2i
    //   535: putfield 318	com/tencent/mm/protocal/protobuf/if:FTf	I
    //   538: aload_1
    //   539: aload 10
    //   541: getfield 313	com/tencent/mm/g/c/ei:field_createTime	J
    //   544: putfield 321	com/tencent/mm/protocal/protobuf/if:FTn	J
    //   547: aload_1
    //   548: aload 10
    //   550: getfield 324	com/tencent/mm/g/c/ei:field_msgSeq	J
    //   553: l2i
    //   554: putfield 327	com/tencent/mm/protocal/protobuf/if:FTm	I
    //   557: aload_1
    //   558: aload 10
    //   560: getfield 330	com/tencent/mm/g/c/ei:field_flag	I
    //   563: putfield 333	com/tencent/mm/protocal/protobuf/if:FTo	I
    //   566: new 270	com/tencent/mm/protocal/protobuf/cxn
    //   569: dup
    //   570: invokespecial 271	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   573: astore 11
    //   575: aload 11
    //   577: aload 10
    //   579: getfield 336	com/tencent/mm/g/c/ei:field_content	Ljava/lang/String;
    //   582: ldc 172
    //   584: invokestatic 340	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   587: invokevirtual 275	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   590: pop
    //   591: aload_1
    //   592: aload 11
    //   594: putfield 343	com/tencent/mm/protocal/protobuf/if:FNI	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   597: invokestatic 349	com/tencent/mm/plugin/backup/bakoldlogic/b/d:bKf	()Lcom/tencent/mm/plugin/backup/bakoldlogic/b/d;
    //   600: aload 10
    //   602: invokevirtual 199	com/tencent/mm/storage/bv:getType	()I
    //   605: invokestatic 307	com/tencent/mm/pluginsdk/model/app/m:Zb	(I)I
    //   608: invokevirtual 353	com/tencent/mm/plugin/backup/bakoldlogic/b/d:xN	(I)Lcom/tencent/mm/plugin/backup/bakoldlogic/b/j;
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
    //   631: invokevirtual 199	com/tencent/mm/storage/bv:getType	()I
    //   634: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: invokestatic 358	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aconst_null
    //   642: astore_1
    //   643: goto -372 -> 271
    //   646: aload_1
    //   647: new 270	com/tencent/mm/protocal/protobuf/cxn
    //   650: dup
    //   651: invokespecial 271	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   654: aload 10
    //   656: getfield 196	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
    //   659: invokevirtual 275	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   662: putfield 279	com/tencent/mm/protocal/protobuf/if:FNG	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   665: aload_1
    //   666: new 270	com/tencent/mm/protocal/protobuf/cxn
    //   669: dup
    //   670: invokespecial 271	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   673: aload_2
    //   674: invokevirtual 275	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   677: putfield 282	com/tencent/mm/protocal/protobuf/if:FNH	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   680: iload 4
    //   682: ifeq +398 -> 1080
    //   685: iconst_3
    //   686: istore 4
    //   688: goto -209 -> 479
    //   691: aload 11
    //   693: aload_1
    //   694: aload 10
    //   696: aload 9
    //   698: invokeinterface 364 4 0
    //   703: istore 4
    //   705: iload 4
    //   707: ifge +8 -> 715
    //   710: aconst_null
    //   711: astore_1
    //   712: goto -441 -> 271
    //   715: aload 8
    //   717: aload 8
    //   719: getfield 367	com/tencent/mm/pointers/PLong:value	J
    //   722: iload 4
    //   724: i2l
    //   725: ladd
    //   726: putfield 367	com/tencent/mm/pointers/PLong:value	J
    //   729: aload 8
    //   731: aload 8
    //   733: getfield 367	com/tencent/mm/pointers/PLong:value	J
    //   736: ldc2_w 368
    //   739: ladd
    //   740: putfield 367	com/tencent/mm/pointers/PLong:value	J
    //   743: goto -472 -> 271
    //   746: astore_1
    //   747: ldc 160
    //   749: aload_1
    //   750: ldc 172
    //   752: iconst_0
    //   753: anewarray 4	java/lang/Object
    //   756: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: ldc 160
    //   761: ldc_w 371
    //   764: aload_1
    //   765: invokestatic 374	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   768: invokevirtual 378	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   771: invokestatic 381	com/tencent/mm/sdk/platformtools/ae:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: aconst_null
    //   775: astore_1
    //   776: goto -501 -> 275
    //   779: aload 9
    //   781: invokevirtual 384	java/util/LinkedList:clear	()V
    //   784: aload 6
    //   786: astore_1
    //   787: aload 8
    //   789: getfield 367	com/tencent/mm/pointers/PLong:value	J
    //   792: ldc2_w 385
    //   795: lcmp
    //   796: ifle +125 -> 921
    //   799: ldc 160
    //   801: new 77	java/lang/StringBuilder
    //   804: dup
    //   805: ldc_w 388
    //   808: invokespecial 391	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   811: aload 8
    //   813: getfield 367	com/tencent/mm/pointers/PLong:value	J
    //   816: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 393	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload_0
    //   826: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:gzo	Ljava/util/Random;
    //   829: invokestatic 395	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   832: astore_1
    //   833: new 230	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   836: dup
    //   837: aload_1
    //   838: iconst_1
    //   839: aload 6
    //   841: ldc 172
    //   843: aload_0
    //   844: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:bKg	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   847: getfield 248	com/tencent/mm/plugin/backup/b/d:nyc	[B
    //   850: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ak/g;[B)V
    //   853: astore 10
    //   855: aload_0
    //   856: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   859: astore 6
    //   861: aload 6
    //   863: monitorenter
    //   864: aload 10
    //   866: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:bJH	()Z
    //   869: pop
    //   870: aload_0
    //   871: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   874: aload_1
    //   875: invokevirtual 255	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   878: pop
    //   879: ldc 160
    //   881: ldc_w 257
    //   884: iconst_1
    //   885: anewarray 4	java/lang/Object
    //   888: dup
    //   889: iconst_0
    //   890: aload_0
    //   891: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   894: invokevirtual 155	java/util/HashSet:size	()I
    //   897: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   900: aastore
    //   901: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   904: aload 6
    //   906: monitorexit
    //   907: new 57	java/util/LinkedList
    //   910: dup
    //   911: invokespecial 58	java/util/LinkedList:<init>	()V
    //   914: astore_1
    //   915: aload 8
    //   917: lconst_0
    //   918: putfield 367	com/tencent/mm/pointers/PLong:value	J
    //   921: aload 7
    //   923: invokeinterface 398 1 0
    //   928: pop
    //   929: aload_1
    //   930: astore 6
    //   932: goto -869 -> 63
    //   935: astore_1
    //   936: aload 6
    //   938: monitorexit
    //   939: sipush 21891
    //   942: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   945: aload_1
    //   946: athrow
    //   947: aload 8
    //   949: getfield 367	com/tencent/mm/pointers/PLong:value	J
    //   952: lconst_0
    //   953: lcmp
    //   954: ifle +95 -> 1049
    //   957: aload_0
    //   958: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:gzo	Ljava/util/Random;
    //   961: invokestatic 395	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   964: astore_2
    //   965: new 230	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   968: dup
    //   969: aload_2
    //   970: iconst_1
    //   971: aload_1
    //   972: ldc 172
    //   974: aload_0
    //   975: invokestatic 242	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:bKg	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   978: getfield 248	com/tencent/mm/plugin/backup/b/d:nyc	[B
    //   981: invokespecial 251	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ak/g;[B)V
    //   984: astore 6
    //   986: aload_0
    //   987: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   990: astore_1
    //   991: aload_1
    //   992: monitorenter
    //   993: aload 6
    //   995: invokevirtual 254	com/tencent/mm/plugin/backup/bakoldlogic/c/c:bJH	()Z
    //   998: pop
    //   999: aload_0
    //   1000: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   1003: aload_2
    //   1004: invokevirtual 255	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1007: pop
    //   1008: ldc 160
    //   1010: ldc_w 257
    //   1013: iconst_1
    //   1014: anewarray 4	java/lang/Object
    //   1017: dup
    //   1018: iconst_0
    //   1019: aload_0
    //   1020: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:nGC	Ljava/util/HashSet;
    //   1023: invokevirtual 155	java/util/HashSet:size	()I
    //   1026: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: aastore
    //   1030: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1033: aload_1
    //   1034: monitorexit
    //   1035: aload 8
    //   1037: lconst_0
    //   1038: putfield 367	com/tencent/mm/pointers/PLong:value	J
    //   1041: new 57	java/util/LinkedList
    //   1044: dup
    //   1045: invokespecial 58	java/util/LinkedList:<init>	()V
    //   1048: pop
    //   1049: aload 7
    //   1051: invokeinterface 170 1 0
    //   1056: sipush 21891
    //   1059: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1062: iconst_1
    //   1063: ireturn
    //   1064: astore_2
    //   1065: aload_1
    //   1066: monitorexit
    //   1067: sipush 21891
    //   1070: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1073: aload_2
    //   1074: athrow
    //   1075: astore 10
    //   1077: goto -974 -> 103
    //   1080: iconst_4
    //   1081: istore 4
    //   1083: goto -604 -> 479
    //   1086: aload 6
    //   1088: astore_1
    //   1089: goto -142 -> 947
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1092	0	this	d
    //   0	1092	2	paramString2	String
    //   0	1092	3	paramInt	int
    //   87	995	4	i	int
    //   114	3	5	bool	boolean
    //   30	1020	7	localCursor	android.database.Cursor
    //   13	1023	8	localPLong	com.tencent.mm.pointers.PLong
    //   48	732	9	localLinkedList	LinkedList
    //   159	5	10	localInterruptedException1	java.lang.InterruptedException
    //   213	652	10	localObject2	Object
    //   1075	1	10	localInterruptedException2	java.lang.InterruptedException
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
    //   178	180	177	finally
    //   204	206	177	finally
    //   53	63	188	finally
    //   63	80	188	finally
    //   180	188	188	finally
    //   206	222	188	finally
    //   229	269	188	finally
    //   279	286	188	finally
    //   286	293	188	finally
    //   293	350	188	finally
    //   402	410	188	finally
    //   416	476	188	finally
    //   479	613	188	finally
    //   618	641	188	finally
    //   646	680	188	finally
    //   691	705	188	finally
    //   715	743	188	finally
    //   747	774	188	finally
    //   779	784	188	finally
    //   787	864	188	finally
    //   907	921	188	finally
    //   921	929	188	finally
    //   939	947	188	finally
    //   947	993	188	finally
    //   1035	1049	188	finally
    //   1067	1075	188	finally
    //   350	396	399	finally
    //   400	402	399	finally
    //   229	269	746	java/lang/Exception
    //   416	476	746	java/lang/Exception
    //   479	613	746	java/lang/Exception
    //   618	641	746	java/lang/Exception
    //   646	680	746	java/lang/Exception
    //   691	705	746	java/lang/Exception
    //   715	743	746	java/lang/Exception
    //   864	907	935	finally
    //   936	939	935	finally
    //   993	1035	1064	finally
    //   1065	1067	1064	finally
    //   96	103	1075	java/lang/InterruptedException
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(21894);
    this.nGH += paramInt1;
    if (this.nGG == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.nGH * 100L / this.nGG))
    {
      if (paramInt1 > this.nGI)
      {
        this.nGI = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.nGI);
        if ((!this.dus) && (!this.hmD) && (this.nGD != null) && (this.nGI >= 0) && (this.nGI <= 100)) {
          this.nGD.xS(this.nGI);
        }
      }
      AppMethodBeat.o(21894);
      return;
    }
  }
  
  final void bKn()
  {
    AppMethodBeat.i(21892);
    if ((!this.nGF) || (this.hmD))
    {
      AppMethodBeat.o(21892);
      return;
    }
    synchronized (this.lock)
    {
      if (this.nGC.isEmpty())
      {
        a.bKg().bKh().nGV = 4;
        a.bKg().bKh().nGW = 3;
        com.tencent.mm.plugin.backup.g.b.b(5, this.nGE);
        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).bJH();
        c localc = a.bKg().bKi();
        localc.nGx += 1;
        if (this.nGD != null)
        {
          this.nGD.bKu();
          cancel();
          ae.i("MicroMsg.BakPCServer", "send backup finish cmd");
        }
      }
      else
      {
        AppMethodBeat.o(21892);
        return;
      }
      ae.i("MicroMsg.BakPCServer", "operatorCallback is null");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21890);
    ae.i("MicroMsg.BakPCServer", "cancel");
    this.hmD = true;
    com.tencent.mm.plugin.backup.g.b.b(5, this.nGE);
    this.nGD = null;
    this.nGF = false;
    this.nGI = 0;
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
    ae.i("MicroMsg.BakPCServer", "pause");
    this.dus = true;
    AppMethodBeat.o(21888);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21889);
    ae.i("MicroMsg.BakPCServer", "resume");
    this.dus = false;
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