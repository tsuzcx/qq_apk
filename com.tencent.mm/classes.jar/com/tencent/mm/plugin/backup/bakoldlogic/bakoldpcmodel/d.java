package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q;
import com.tencent.mm.b.g;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d
  implements j
{
  private boolean fEs;
  private Random jXL;
  private boolean kUn;
  Object lock;
  i rTA;
  boolean rTB;
  private long rTC;
  private long rTD;
  int rTE;
  int rTF;
  List<String> rTx;
  HashSet<String> rTy;
  e.d rTz;
  
  public d()
  {
    AppMethodBeat.i(21887);
    this.lock = new Object();
    this.jXL = new Random();
    this.fEs = false;
    this.kUn = false;
    this.rTx = new LinkedList();
    this.rTy = new HashSet();
    this.rTB = false;
    this.rTF = 0;
    AppMethodBeat.o(21887);
  }
  
  private static String b(Random paramRandom)
  {
    AppMethodBeat.i(21893);
    paramRandom = g.getMessageDigest((Util.currentTicks() + paramRandom.nextDouble()).getBytes());
    AppMethodBeat.o(21893);
    return paramRandom;
  }
  
  /* Error */
  public final boolean I(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: sipush 21891
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 118	com/tencent/mm/pointers/PLong
    //   9: dup
    //   10: invokespecial 119	com/tencent/mm/pointers/PLong:<init>	()V
    //   13: astore 8
    //   15: invokestatic 125	com/tencent/mm/plugin/backup/bakoldlogic/d/b:cuH	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/b;
    //   18: invokevirtual 129	com/tencent/mm/plugin/backup/bakoldlogic/d/b:cuI	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/c;
    //   21: invokevirtual 135	com/tencent/mm/plugin/backup/bakoldlogic/d/c:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   24: aload_1
    //   25: invokeinterface 141 2 0
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
    //   55: invokeinterface 147 1 0
    //   60: ifeq +888 -> 948
    //   63: aload 7
    //   65: invokeinterface 150 1 0
    //   70: ifne +1017 -> 1087
    //   73: aload_0
    //   74: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   84: invokevirtual 154	java/util/HashSet:size	()I
    //   87: istore 4
    //   89: iload 4
    //   91: bipush 10
    //   93: if_icmple +10 -> 103
    //   96: aload_0
    //   97: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   100: invokevirtual 157	java/lang/Object:wait	()V
    //   103: aload_0
    //   104: getfield 53	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:fEs	Z
    //   107: ifeq +21 -> 128
    //   110: aload_0
    //   111: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:kUn	Z
    //   114: istore 5
    //   116: iload 5
    //   118: ifne +10 -> 128
    //   121: aload_0
    //   122: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   125: invokevirtual 157	java/lang/Object:wait	()V
    //   128: aload_0
    //   129: getfield 55	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:kUn	Z
    //   132: ifeq +72 -> 204
    //   135: ldc 159
    //   137: ldc 161
    //   139: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: monitorexit
    //   144: aload 7
    //   146: invokeinterface 169 1 0
    //   151: sipush 21891
    //   154: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore 10
    //   161: ldc 159
    //   163: aload 10
    //   165: ldc 171
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   191: invokeinterface 169 1 0
    //   196: sipush 21891
    //   199: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: aload_1
    //   205: monitorexit
    //   206: new 177	com/tencent/mm/storage/ca
    //   209: dup
    //   210: invokespecial 178	com/tencent/mm/storage/ca:<init>	()V
    //   213: astore 10
    //   215: aload 10
    //   217: aload 7
    //   219: invokevirtual 182	com/tencent/mm/storage/ca:convertFrom	(Landroid/database/Cursor;)V
    //   222: iload_3
    //   223: ifle +187 -> 410
    //   226: iconst_1
    //   227: istore 4
    //   229: aload 10
    //   231: getfield 187	com/tencent/mm/f/c/et:field_msgSvrId	J
    //   234: lconst_0
    //   235: lcmp
    //   236: ifne +180 -> 416
    //   239: ldc 189
    //   241: ldc 191
    //   243: iconst_2
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload 10
    //   251: getfield 195	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload 10
    //   259: invokevirtual 198	com/tencent/mm/storage/ca:getType	()I
    //   262: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   282: invokevirtual 212	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload 9
    //   288: invokevirtual 216	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   291: astore 10
    //   293: aload 10
    //   295: invokeinterface 221 1 0
    //   300: ifeq +480 -> 780
    //   303: aload 10
    //   305: invokeinterface 225 1 0
    //   310: checkcast 227	com/tencent/mm/plugin/backup/i/u
    //   313: astore 11
    //   315: new 229	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   318: dup
    //   319: aload 11
    //   321: getfield 232	com/tencent/mm/plugin/backup/i/u:mediaId	Ljava/lang/String;
    //   324: iconst_2
    //   325: aconst_null
    //   326: aload 11
    //   328: getfield 235	com/tencent/mm/plugin/backup/i/u:path	Ljava/lang/String;
    //   331: aload_0
    //   332: invokestatic 241	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cuk	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   335: getfield 247	com/tencent/mm/plugin/backup/b/d:rKQ	[B
    //   338: invokespecial 250	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/an/j;[B)V
    //   341: astore 12
    //   343: aload_0
    //   344: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: aload 12
    //   352: invokevirtual 253	com/tencent/mm/plugin/backup/bakoldlogic/c/c:ctM	()Z
    //   355: pop
    //   356: aload_0
    //   357: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   360: aload 11
    //   362: getfield 232	com/tencent/mm/plugin/backup/i/u:mediaId	Ljava/lang/String;
    //   365: invokevirtual 254	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   368: pop
    //   369: ldc 159
    //   371: ldc_w 256
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_0
    //   381: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   384: invokevirtual 154	java/util/HashSet:size	()I
    //   387: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   416: new 260	com/tencent/mm/protocal/protobuf/ih
    //   419: dup
    //   420: invokespecial 261	com/tencent/mm/protocal/protobuf/ih:<init>	()V
    //   423: astore_1
    //   424: aload_1
    //   425: aload 10
    //   427: getfield 187	com/tencent/mm/f/c/et:field_msgSvrId	J
    //   430: putfield 264	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   433: aload 10
    //   435: getfield 267	com/tencent/mm/f/c/et:field_isSend	I
    //   438: iconst_1
    //   439: if_icmpne +207 -> 646
    //   442: aload_1
    //   443: new 269	com/tencent/mm/protocal/protobuf/eaf
    //   446: dup
    //   447: invokespecial 270	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   450: aload_2
    //   451: invokevirtual 274	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   454: putfield 278	com/tencent/mm/protocal/protobuf/ih:RID	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   457: aload_1
    //   458: new 269	com/tencent/mm/protocal/protobuf/eaf
    //   461: dup
    //   462: invokespecial 270	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   465: aload 10
    //   467: getfield 195	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
    //   470: invokevirtual 274	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   473: putfield 281	com/tencent/mm/protocal/protobuf/ih:RIE	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   476: iconst_2
    //   477: istore 4
    //   479: aload_1
    //   480: iload 4
    //   482: putfield 284	com/tencent/mm/protocal/protobuf/ih:RNH	I
    //   485: aload_1
    //   486: new 286	com/tencent/mm/protocal/protobuf/eae
    //   489: dup
    //   490: invokespecial 287	com/tencent/mm/protocal/protobuf/eae:<init>	()V
    //   493: putfield 291	com/tencent/mm/protocal/protobuf/ih:RNM	Lcom/tencent/mm/protocal/protobuf/eae;
    //   496: aload_1
    //   497: iconst_0
    //   498: putfield 294	com/tencent/mm/protocal/protobuf/ih:RNN	I
    //   501: aload_1
    //   502: iconst_0
    //   503: putfield 297	com/tencent/mm/protocal/protobuf/ih:RNO	I
    //   506: aload_1
    //   507: ldc 171
    //   509: putfield 300	com/tencent/mm/protocal/protobuf/ih:RII	Ljava/lang/String;
    //   512: aload_1
    //   513: aload 10
    //   515: invokevirtual 198	com/tencent/mm/storage/ca:getType	()I
    //   518: invokestatic 306	com/tencent/mm/pluginsdk/model/app/m:apL	(I)I
    //   521: putfield 309	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   524: aload_1
    //   525: aload 10
    //   527: getfield 312	com/tencent/mm/f/c/et:field_createTime	J
    //   530: ldc2_w 313
    //   533: ldiv
    //   534: l2i
    //   535: putfield 317	com/tencent/mm/protocal/protobuf/ih:RNI	I
    //   538: aload_1
    //   539: aload 10
    //   541: getfield 312	com/tencent/mm/f/c/et:field_createTime	J
    //   544: putfield 320	com/tencent/mm/protocal/protobuf/ih:RNQ	J
    //   547: aload_1
    //   548: aload 10
    //   550: getfield 323	com/tencent/mm/f/c/et:field_msgSeq	J
    //   553: l2i
    //   554: putfield 326	com/tencent/mm/protocal/protobuf/ih:RNP	I
    //   557: aload_1
    //   558: aload 10
    //   560: getfield 329	com/tencent/mm/f/c/et:field_flag	I
    //   563: putfield 332	com/tencent/mm/protocal/protobuf/ih:RNR	I
    //   566: new 269	com/tencent/mm/protocal/protobuf/eaf
    //   569: dup
    //   570: invokespecial 270	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   573: astore 11
    //   575: aload 11
    //   577: aload 10
    //   579: getfield 335	com/tencent/mm/f/c/et:field_content	Ljava/lang/String;
    //   582: ldc 171
    //   584: invokestatic 339	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   587: invokevirtual 274	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   590: pop
    //   591: aload_1
    //   592: aload 11
    //   594: putfield 342	com/tencent/mm/protocal/protobuf/ih:RIF	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   597: invokestatic 348	com/tencent/mm/plugin/backup/bakoldlogic/b/d:cuj	()Lcom/tencent/mm/plugin/backup/bakoldlogic/b/d;
    //   600: aload 10
    //   602: invokevirtual 198	com/tencent/mm/storage/ca:getType	()I
    //   605: invokestatic 306	com/tencent/mm/pluginsdk/model/app/m:apL	(I)I
    //   608: invokevirtual 352	com/tencent/mm/plugin/backup/bakoldlogic/b/d:EU	(I)Lcom/tencent/mm/plugin/backup/bakoldlogic/b/j;
    //   611: astore 11
    //   613: aload 11
    //   615: ifnonnull +76 -> 691
    //   618: ldc 189
    //   620: ldc_w 354
    //   623: iconst_1
    //   624: anewarray 4	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: aload 10
    //   631: invokevirtual 198	com/tencent/mm/storage/ca:getType	()I
    //   634: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: invokestatic 357	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aconst_null
    //   642: astore_1
    //   643: goto -372 -> 271
    //   646: aload_1
    //   647: new 269	com/tencent/mm/protocal/protobuf/eaf
    //   650: dup
    //   651: invokespecial 270	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   654: aload 10
    //   656: getfield 195	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
    //   659: invokevirtual 274	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   662: putfield 278	com/tencent/mm/protocal/protobuf/ih:RID	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   665: aload_1
    //   666: new 269	com/tencent/mm/protocal/protobuf/eaf
    //   669: dup
    //   670: invokespecial 270	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   673: aload_2
    //   674: invokevirtual 274	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   677: putfield 281	com/tencent/mm/protocal/protobuf/ih:RIE	Lcom/tencent/mm/protocal/protobuf/eaf;
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
    //   748: ldc 159
    //   750: aload_1
    //   751: ldc 171
    //   753: iconst_0
    //   754: anewarray 4	java/lang/Object
    //   757: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   760: ldc 159
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
    //   800: ldc 159
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
    //   827: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jXL	Ljava/util/Random;
    //   830: invokestatic 394	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   833: astore_1
    //   834: new 229	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   837: dup
    //   838: aload_1
    //   839: iconst_1
    //   840: aload 6
    //   842: ldc 171
    //   844: aload_0
    //   845: invokestatic 241	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cuk	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   848: getfield 247	com/tencent/mm/plugin/backup/b/d:rKQ	[B
    //   851: invokespecial 250	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/an/j;[B)V
    //   854: astore 10
    //   856: aload_0
    //   857: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   860: astore 6
    //   862: aload 6
    //   864: monitorenter
    //   865: aload 10
    //   867: invokevirtual 253	com/tencent/mm/plugin/backup/bakoldlogic/c/c:ctM	()Z
    //   870: pop
    //   871: aload_0
    //   872: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   875: aload_1
    //   876: invokevirtual 254	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   879: pop
    //   880: ldc 159
    //   882: ldc_w 256
    //   885: iconst_1
    //   886: anewarray 4	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: aload_0
    //   892: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   895: invokevirtual 154	java/util/HashSet:size	()I
    //   898: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   901: aastore
    //   902: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   959: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jXL	Ljava/util/Random;
    //   962: invokestatic 394	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   965: astore_2
    //   966: new 229	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   969: dup
    //   970: aload_2
    //   971: iconst_1
    //   972: aload_1
    //   973: ldc 171
    //   975: aload_0
    //   976: invokestatic 241	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:cuk	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   979: getfield 247	com/tencent/mm/plugin/backup/b/d:rKQ	[B
    //   982: invokespecial 250	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/an/j;[B)V
    //   985: astore 6
    //   987: aload_0
    //   988: getfield 46	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   991: astore_1
    //   992: aload_1
    //   993: monitorenter
    //   994: aload 6
    //   996: invokevirtual 253	com/tencent/mm/plugin/backup/bakoldlogic/c/c:ctM	()Z
    //   999: pop
    //   1000: aload_0
    //   1001: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   1004: aload_2
    //   1005: invokevirtual 254	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1008: pop
    //   1009: ldc 159
    //   1011: ldc_w 256
    //   1014: iconst_1
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload_0
    //   1021: getfield 65	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:rTy	Ljava/util/HashSet;
    //   1024: invokevirtual 154	java/util/HashSet:size	()I
    //   1027: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: aastore
    //   1031: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1052: invokeinterface 169 1 0
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
  
  public final void a(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(21894);
    this.rTD += paramInt1;
    if (this.rTC == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.rTD * 100L / this.rTC))
    {
      if (paramInt1 > this.rTE)
      {
        this.rTE = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.rTE);
        if ((!this.fEs) && (!this.kUn) && (this.rTz != null) && (this.rTE >= 0) && (this.rTE <= 100)) {
          this.rTz.EZ(this.rTE);
        }
      }
      AppMethodBeat.o(21894);
      return;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21890);
    Log.i("MicroMsg.BakPCServer", "cancel");
    this.kUn = true;
    com.tencent.mm.plugin.backup.g.b.b(5, this.rTA);
    this.rTz = null;
    this.rTB = false;
    this.rTE = 0;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21890);
      return;
    }
  }
  
  final void cur()
  {
    AppMethodBeat.i(21892);
    if ((!this.rTB) || (this.kUn))
    {
      AppMethodBeat.o(21892);
      return;
    }
    synchronized (this.lock)
    {
      if (this.rTy.isEmpty())
      {
        a.cuk().cul().rTR = 4;
        a.cuk().cul().rTS = 3;
        com.tencent.mm.plugin.backup.g.b.b(5, this.rTA);
        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).ctM();
        c localc = a.cuk().cum();
        localc.rTt += 1;
        if (this.rTz != null)
        {
          this.rTz.cuy();
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
  
  public final void pause()
  {
    AppMethodBeat.i(21888);
    Log.i("MicroMsg.BakPCServer", "pause");
    this.fEs = true;
    AppMethodBeat.o(21888);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21889);
    Log.i("MicroMsg.BakPCServer", "resume");
    this.fEs = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21889);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d
 * JD-Core Version:    0.7.0.1
 */