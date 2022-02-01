package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ad
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public boolean tqo;
  public ve tqp;
  public eda tqq;
  public int tqr;
  
  public ad(double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(112846);
    this.tqo = false;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bsc();
    ((d.a)localObject).lBV = new bsd();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardslayout";
    ((d.a)localObject).funcId = 1054;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bsc)d.b.b(this.rr.lBR);
    ((bsc)localObject).latitude = paramDouble1;
    ((bsc)localObject).longitude = paramDouble2;
    ((bsc)localObject).scene = paramInt;
    ((bsc)localObject).Tco = ((String)h.aHG().aHp().get(ar.a.VhS, null));
    AppMethodBeat.o(112846);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112848);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112848);
    return i;
  }
  
  public final int getType()
  {
    return 1054;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 142
    //   7: ldc 144
    //   9: iconst_2
    //   10: anewarray 146	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_2
    //   16: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_3
    //   23: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 69	com/tencent/mm/plugin/card/model/ad:rr	Lcom/tencent/mm/an/d;
    //   34: getfield 161	com/tencent/mm/an/d:lBS	Lcom/tencent/mm/an/d$c;
    //   37: invokestatic 166	com/tencent/mm/an/d$c:b	(Lcom/tencent/mm/an/d$c;)Lcom/tencent/mm/cd/a;
    //   40: checkcast 44	com/tencent/mm/protocal/protobuf/bsd
    //   43: astore 14
    //   45: ldc 142
    //   47: new 168	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 170
    //   53: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload 14
    //   58: getfield 176	com/tencent/mm/protocal/protobuf/bsd:tpZ	Ljava/lang/String;
    //   61: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload 14
    //   73: getfield 191	com/tencent/mm/protocal/protobuf/bsd:Tcp	Lcom/tencent/mm/protocal/protobuf/ve;
    //   76: putfield 193	com/tencent/mm/plugin/card/model/ad:tqp	Lcom/tencent/mm/protocal/protobuf/ve;
    //   79: iload_2
    //   80: ifne +264 -> 344
    //   83: iload_3
    //   84: ifne +260 -> 344
    //   87: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   90: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   93: getstatic 109	com/tencent/mm/storage/ar$a:VhS	Lcom/tencent/mm/storage/ar$a;
    //   96: aload 14
    //   98: getfield 194	com/tencent/mm/protocal/protobuf/bsd:Tco	Ljava/lang/String;
    //   101: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   104: aload 14
    //   106: getfield 176	com/tencent/mm/protocal/protobuf/bsd:tpZ	Ljava/lang/String;
    //   109: astore 5
    //   111: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   114: lstore 8
    //   116: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   119: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   122: getstatic 207	com/tencent/mm/storage/ar$a:VhR	Lcom/tencent/mm/storage/ar$a;
    //   125: aconst_null
    //   126: invokevirtual 115	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 117	java/lang/String
    //   132: astore 6
    //   134: aload 6
    //   136: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +7 -> 146
    //   142: aload 6
    //   144: astore 5
    //   146: aload 5
    //   148: invokestatic 219	com/tencent/mm/plugin/card/d/j:arQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bsg;
    //   151: astore 6
    //   153: invokestatic 225	com/tencent/mm/plugin/card/model/am:cHs	()Lcom/tencent/mm/plugin/card/model/c;
    //   156: getfield 231	com/tencent/mm/plugin/card/model/c:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   159: ldc 233
    //   161: ldc 235
    //   163: invokeinterface 241 3 0
    //   168: pop
    //   169: aload 6
    //   171: ifnonnull +193 -> 364
    //   174: ldc 243
    //   176: ldc 245
    //   178: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: iconst_0
    //   182: istore 12
    //   184: aload_0
    //   185: iload 12
    //   187: putfield 32	com/tencent/mm/plugin/card/model/ad:tqo	Z
    //   190: aload_0
    //   191: getfield 193	com/tencent/mm/plugin/card/model/ad:tqp	Lcom/tencent/mm/protocal/protobuf/ve;
    //   194: ifnull +1201 -> 1395
    //   197: aload_0
    //   198: getfield 193	com/tencent/mm/plugin/card/model/ad:tqp	Lcom/tencent/mm/protocal/protobuf/ve;
    //   201: invokevirtual 254	com/tencent/mm/protocal/protobuf/ve:toByteArray	()[B
    //   204: astore 5
    //   206: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   209: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   212: getstatic 257	com/tencent/mm/storage/ar$a:Vim	Lcom/tencent/mm/storage/ar$a;
    //   215: new 117	java/lang/String
    //   218: dup
    //   219: aload 5
    //   221: iconst_0
    //   222: aload 5
    //   224: arraylength
    //   225: ldc_w 259
    //   228: invokespecial 262	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   231: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   234: aload_0
    //   235: aload 14
    //   237: getfield 265	com/tencent/mm/protocal/protobuf/bsd:Tcq	I
    //   240: putfield 267	com/tencent/mm/plugin/card/model/ad:tqr	I
    //   243: aload_0
    //   244: getfield 267	com/tencent/mm/plugin/card/model/ad:tqr	I
    //   247: ifge +8 -> 255
    //   250: aload_0
    //   251: iconst_0
    //   252: putfield 267	com/tencent/mm/plugin/card/model/ad:tqr	I
    //   255: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   258: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   261: getstatic 270	com/tencent/mm/storage/ar$a:Vio	Lcom/tencent/mm/storage/ar$a;
    //   264: aload_0
    //   265: getfield 267	com/tencent/mm/plugin/card/model/ad:tqr	I
    //   268: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   274: aload 14
    //   276: getfield 273	com/tencent/mm/protocal/protobuf/bsd:Tcr	Lcom/tencent/mm/protocal/protobuf/eda;
    //   279: ifnull +1153 -> 1432
    //   282: aload_0
    //   283: aload 14
    //   285: getfield 273	com/tencent/mm/protocal/protobuf/bsd:Tcr	Lcom/tencent/mm/protocal/protobuf/eda;
    //   288: putfield 275	com/tencent/mm/plugin/card/model/ad:tqq	Lcom/tencent/mm/protocal/protobuf/eda;
    //   291: aload 14
    //   293: getfield 273	com/tencent/mm/protocal/protobuf/bsd:Tcr	Lcom/tencent/mm/protocal/protobuf/eda;
    //   296: invokevirtual 278	com/tencent/mm/protocal/protobuf/eda:toByteArray	()[B
    //   299: astore 5
    //   301: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   304: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   307: getstatic 281	com/tencent/mm/storage/ar$a:Vin	Lcom/tencent/mm/storage/ar$a;
    //   310: new 117	java/lang/String
    //   313: dup
    //   314: aload 5
    //   316: iconst_0
    //   317: aload 5
    //   319: arraylength
    //   320: ldc_w 259
    //   323: invokespecial 262	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   326: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   329: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   332: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   335: getstatic 284	com/tencent/mm/storage/ar$a:Vip	Lcom/tencent/mm/storage/ar$a;
    //   338: getstatic 290	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   341: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   344: aload_0
    //   345: getfield 129	com/tencent/mm/plugin/card/model/ad:callback	Lcom/tencent/mm/an/i;
    //   348: iload_2
    //   349: iload_3
    //   350: aload 4
    //   352: aload_0
    //   353: invokeinterface 296 5 0
    //   358: ldc 140
    //   360: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: return
    //   364: iconst_0
    //   365: istore 12
    //   367: iconst_0
    //   368: istore 13
    //   370: aload 6
    //   372: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   375: ifnull +1096 -> 1471
    //   378: new 304	java/util/HashMap
    //   381: dup
    //   382: invokespecial 305	java/util/HashMap:<init>	()V
    //   385: astore 15
    //   387: aload 15
    //   389: ldc_w 307
    //   392: iconst_2
    //   393: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokeinterface 313 3 0
    //   401: pop
    //   402: aload 15
    //   404: ldc_w 315
    //   407: iconst_2
    //   408: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: invokeinterface 313 3 0
    //   416: pop
    //   417: aload 15
    //   419: ldc_w 317
    //   422: iconst_3
    //   423: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: invokeinterface 313 3 0
    //   431: pop
    //   432: aload 15
    //   434: ldc_w 319
    //   437: iconst_5
    //   438: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: invokeinterface 313 3 0
    //   446: pop
    //   447: aload 6
    //   449: getfield 322	com/tencent/mm/protocal/protobuf/bsg:Tcx	I
    //   452: bipush 100
    //   454: if_icmpne +866 -> 1320
    //   457: aload 15
    //   459: ldc_w 307
    //   462: iconst_4
    //   463: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokeinterface 313 3 0
    //   471: pop
    //   472: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   475: getfield 326	com/tencent/mm/kernel/f:kcF	Lcom/tencent/mm/storagebase/h;
    //   478: invokestatic 332	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   481: invokevirtual 335	java/lang/Thread:getId	()J
    //   484: invokevirtual 341	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   487: lstore 10
    //   489: aload 6
    //   491: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   494: getfield 347	com/tencent/mm/protocal/protobuf/wg:SiH	Lcom/tencent/mm/protocal/protobuf/wf;
    //   497: ifnull +968 -> 1465
    //   500: aload 6
    //   502: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   505: getfield 347	com/tencent/mm/protocal/protobuf/wg:SiH	Lcom/tencent/mm/protocal/protobuf/wf;
    //   508: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   511: ifnull +954 -> 1465
    //   514: aload 6
    //   516: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   519: getfield 347	com/tencent/mm/protocal/protobuf/wg:SiH	Lcom/tencent/mm/protocal/protobuf/wf;
    //   522: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   525: invokevirtual 358	java/util/LinkedList:size	()I
    //   528: ifle +937 -> 1465
    //   531: iconst_1
    //   532: istore 13
    //   534: aload 15
    //   536: ldc_w 307
    //   539: invokeinterface 361 2 0
    //   544: checkcast 148	java/lang/Integer
    //   547: invokevirtual 364	java/lang/Integer:intValue	()I
    //   550: istore_1
    //   551: aload 6
    //   553: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   556: getfield 347	com/tencent/mm/protocal/protobuf/wg:SiH	Lcom/tencent/mm/protocal/protobuf/wf;
    //   559: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   562: iload_1
    //   563: ldc_w 365
    //   566: imul
    //   567: iconst_3
    //   568: iadd
    //   569: invokestatic 369	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   572: aload 6
    //   574: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   577: getfield 347	com/tencent/mm/protocal/protobuf/wg:SiH	Lcom/tencent/mm/protocal/protobuf/wf;
    //   580: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   583: invokevirtual 358	java/util/LinkedList:size	()I
    //   586: iconst_0
    //   587: iadd
    //   588: istore 7
    //   590: iload 7
    //   592: istore_1
    //   593: iload 13
    //   595: istore 12
    //   597: aload 6
    //   599: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   602: getfield 372	com/tencent/mm/protocal/protobuf/wg:SiI	Lcom/tencent/mm/protocal/protobuf/wf;
    //   605: ifnull +107 -> 712
    //   608: iload 7
    //   610: istore_1
    //   611: iload 13
    //   613: istore 12
    //   615: aload 6
    //   617: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   620: getfield 372	com/tencent/mm/protocal/protobuf/wg:SiI	Lcom/tencent/mm/protocal/protobuf/wf;
    //   623: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   626: ifnull +86 -> 712
    //   629: iload 7
    //   631: istore_1
    //   632: iload 13
    //   634: istore 12
    //   636: aload 6
    //   638: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   641: getfield 372	com/tencent/mm/protocal/protobuf/wg:SiI	Lcom/tencent/mm/protocal/protobuf/wf;
    //   644: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   647: invokevirtual 358	java/util/LinkedList:size	()I
    //   650: ifle +62 -> 712
    //   653: iconst_1
    //   654: istore 12
    //   656: aload 15
    //   658: ldc_w 315
    //   661: invokeinterface 361 2 0
    //   666: checkcast 148	java/lang/Integer
    //   669: invokevirtual 364	java/lang/Integer:intValue	()I
    //   672: istore_1
    //   673: aload 6
    //   675: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   678: getfield 372	com/tencent/mm/protocal/protobuf/wg:SiI	Lcom/tencent/mm/protocal/protobuf/wf;
    //   681: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   684: iload_1
    //   685: ldc_w 365
    //   688: imul
    //   689: iconst_2
    //   690: iadd
    //   691: invokestatic 369	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   694: iload 7
    //   696: aload 6
    //   698: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   701: getfield 372	com/tencent/mm/protocal/protobuf/wg:SiI	Lcom/tencent/mm/protocal/protobuf/wf;
    //   704: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   707: invokevirtual 358	java/util/LinkedList:size	()I
    //   710: iadd
    //   711: istore_1
    //   712: iload_1
    //   713: istore 7
    //   715: iload 12
    //   717: istore 13
    //   719: aload 6
    //   721: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   724: getfield 375	com/tencent/mm/protocal/protobuf/wg:SiJ	Lcom/tencent/mm/protocal/protobuf/wf;
    //   727: ifnull +109 -> 836
    //   730: iload_1
    //   731: istore 7
    //   733: iload 12
    //   735: istore 13
    //   737: aload 6
    //   739: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   742: getfield 375	com/tencent/mm/protocal/protobuf/wg:SiJ	Lcom/tencent/mm/protocal/protobuf/wf;
    //   745: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   748: ifnull +88 -> 836
    //   751: iload_1
    //   752: istore 7
    //   754: iload 12
    //   756: istore 13
    //   758: aload 6
    //   760: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   763: getfield 375	com/tencent/mm/protocal/protobuf/wg:SiJ	Lcom/tencent/mm/protocal/protobuf/wf;
    //   766: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   769: invokevirtual 358	java/util/LinkedList:size	()I
    //   772: ifle +64 -> 836
    //   775: iconst_1
    //   776: istore 13
    //   778: aload 15
    //   780: ldc_w 317
    //   783: invokeinterface 361 2 0
    //   788: checkcast 148	java/lang/Integer
    //   791: invokevirtual 364	java/lang/Integer:intValue	()I
    //   794: istore 7
    //   796: aload 6
    //   798: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   801: getfield 375	com/tencent/mm/protocal/protobuf/wg:SiJ	Lcom/tencent/mm/protocal/protobuf/wf;
    //   804: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   807: iload 7
    //   809: ldc_w 365
    //   812: imul
    //   813: iconst_1
    //   814: iadd
    //   815: invokestatic 369	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   818: iload_1
    //   819: aload 6
    //   821: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   824: getfield 375	com/tencent/mm/protocal/protobuf/wg:SiJ	Lcom/tencent/mm/protocal/protobuf/wf;
    //   827: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   830: invokevirtual 358	java/util/LinkedList:size	()I
    //   833: iadd
    //   834: istore 7
    //   836: iload 7
    //   838: istore_1
    //   839: iload 13
    //   841: istore 12
    //   843: aload 6
    //   845: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   848: getfield 378	com/tencent/mm/protocal/protobuf/wg:SiK	Lcom/tencent/mm/protocal/protobuf/wf;
    //   851: ifnull +84 -> 935
    //   854: iload 7
    //   856: istore_1
    //   857: iload 13
    //   859: istore 12
    //   861: aload 6
    //   863: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   866: getfield 378	com/tencent/mm/protocal/protobuf/wg:SiK	Lcom/tencent/mm/protocal/protobuf/wf;
    //   869: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   872: ifnull +63 -> 935
    //   875: iload 7
    //   877: istore_1
    //   878: iload 13
    //   880: istore 12
    //   882: aload 6
    //   884: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   887: getfield 378	com/tencent/mm/protocal/protobuf/wg:SiK	Lcom/tencent/mm/protocal/protobuf/wf;
    //   890: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   893: invokevirtual 358	java/util/LinkedList:size	()I
    //   896: ifle +39 -> 935
    //   899: iconst_1
    //   900: istore 12
    //   902: iload 7
    //   904: aload 6
    //   906: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   909: getfield 378	com/tencent/mm/protocal/protobuf/wg:SiK	Lcom/tencent/mm/protocal/protobuf/wf;
    //   912: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   915: invokevirtual 358	java/util/LinkedList:size	()I
    //   918: iadd
    //   919: istore_1
    //   920: aload 6
    //   922: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   925: getfield 378	com/tencent/mm/protocal/protobuf/wg:SiK	Lcom/tencent/mm/protocal/protobuf/wf;
    //   928: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   931: iconst_0
    //   932: invokestatic 381	com/tencent/mm/plugin/card/d/j:e	(Ljava/util/LinkedList;I)V
    //   935: iload_1
    //   936: istore 7
    //   938: iload 12
    //   940: istore 13
    //   942: aload 6
    //   944: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   947: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   950: ifnull +125 -> 1075
    //   953: iload_1
    //   954: istore 7
    //   956: iload 12
    //   958: istore 13
    //   960: aload 6
    //   962: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   965: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   968: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   971: ifnull +104 -> 1075
    //   974: iload_1
    //   975: istore 7
    //   977: iload 12
    //   979: istore 13
    //   981: aload 6
    //   983: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   986: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   989: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   992: invokevirtual 358	java/util/LinkedList:size	()I
    //   995: ifle +80 -> 1075
    //   998: iconst_1
    //   999: istore 13
    //   1001: aload 15
    //   1003: ldc_w 319
    //   1006: invokeinterface 361 2 0
    //   1011: checkcast 148	java/lang/Integer
    //   1014: invokevirtual 364	java/lang/Integer:intValue	()I
    //   1017: ldc_w 365
    //   1020: imul
    //   1021: iconst_4
    //   1022: iadd
    //   1023: istore 7
    //   1025: aload 6
    //   1027: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   1030: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   1033: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   1036: iload 7
    //   1038: invokestatic 369	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   1041: aload 6
    //   1043: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   1046: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   1049: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   1052: iload 7
    //   1054: invokestatic 381	com/tencent/mm/plugin/card/d/j:e	(Ljava/util/LinkedList;I)V
    //   1057: iload_1
    //   1058: aload 6
    //   1060: getfield 302	com/tencent/mm/protocal/protobuf/bsg:Tcu	Lcom/tencent/mm/protocal/protobuf/wg;
    //   1063: getfield 384	com/tencent/mm/protocal/protobuf/wg:SiL	Lcom/tencent/mm/protocal/protobuf/wf;
    //   1066: getfield 353	com/tencent/mm/protocal/protobuf/wf:SiG	Ljava/util/LinkedList;
    //   1069: invokevirtual 358	java/util/LinkedList:size	()I
    //   1072: iadd
    //   1073: istore 7
    //   1075: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1078: getfield 326	com/tencent/mm/kernel/f:kcF	Lcom/tencent/mm/storagebase/h;
    //   1081: lload 10
    //   1083: invokevirtual 388	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   1086: pop
    //   1087: invokestatic 392	com/tencent/mm/plugin/card/model/am:cHx	()Lcom/tencent/mm/plugin/card/b/e;
    //   1090: ldc_w 394
    //   1093: aload 6
    //   1095: invokevirtual 400	com/tencent/mm/plugin/card/b/e:r	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1098: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1101: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1104: getstatic 403	com/tencent/mm/storage/ar$a:Via	Lcom/tencent/mm/storage/ar$a;
    //   1107: aload 5
    //   1109: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1112: iload 13
    //   1114: istore 12
    //   1116: iload 7
    //   1118: ifle -934 -> 184
    //   1121: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1124: lstore 10
    //   1126: new 405	java/util/ArrayList
    //   1129: dup
    //   1130: invokespecial 406	java/util/ArrayList:<init>	()V
    //   1133: astore 5
    //   1135: new 408	com/tencent/mars/smc/IDKey
    //   1138: dup
    //   1139: invokespecial 409	com/tencent/mars/smc/IDKey:<init>	()V
    //   1142: astore 6
    //   1144: aload 6
    //   1146: sipush 281
    //   1149: invokevirtual 412	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1152: aload 6
    //   1154: bipush 36
    //   1156: invokevirtual 415	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1159: aload 6
    //   1161: lconst_1
    //   1162: invokevirtual 419	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1165: new 408	com/tencent/mars/smc/IDKey
    //   1168: dup
    //   1169: invokespecial 409	com/tencent/mars/smc/IDKey:<init>	()V
    //   1172: astore 15
    //   1174: aload 15
    //   1176: sipush 281
    //   1179: invokevirtual 412	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1182: aload 15
    //   1184: bipush 37
    //   1186: invokevirtual 415	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1189: aload 15
    //   1191: lload 10
    //   1193: lload 8
    //   1195: lsub
    //   1196: l2i
    //   1197: i2l
    //   1198: invokevirtual 419	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1201: new 408	com/tencent/mars/smc/IDKey
    //   1204: dup
    //   1205: invokespecial 409	com/tencent/mars/smc/IDKey:<init>	()V
    //   1208: astore 16
    //   1210: aload 16
    //   1212: sipush 281
    //   1215: invokevirtual 412	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1218: aload 16
    //   1220: bipush 38
    //   1222: invokevirtual 415	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1225: aload 16
    //   1227: iload 7
    //   1229: i2l
    //   1230: invokevirtual 419	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1233: new 408	com/tencent/mars/smc/IDKey
    //   1236: dup
    //   1237: invokespecial 409	com/tencent/mars/smc/IDKey:<init>	()V
    //   1240: astore 17
    //   1242: aload 17
    //   1244: sipush 281
    //   1247: invokevirtual 412	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1250: aload 17
    //   1252: bipush 40
    //   1254: invokevirtual 415	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1257: aload 17
    //   1259: lload 10
    //   1261: lload 8
    //   1263: lsub
    //   1264: l2i
    //   1265: iload 7
    //   1267: idiv
    //   1268: i2l
    //   1269: invokevirtual 419	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1272: aload 5
    //   1274: aload 6
    //   1276: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1279: pop
    //   1280: aload 5
    //   1282: aload 15
    //   1284: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1287: pop
    //   1288: aload 5
    //   1290: aload 16
    //   1292: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1295: pop
    //   1296: aload 5
    //   1298: aload 17
    //   1300: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1303: pop
    //   1304: getstatic 429	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1307: aload 5
    //   1309: iconst_1
    //   1310: invokevirtual 432	com/tencent/mm/plugin/report/service/h:b	(Ljava/util/ArrayList;Z)V
    //   1313: iload 13
    //   1315: istore 12
    //   1317: goto -1133 -> 184
    //   1320: aload 6
    //   1322: getfield 322	com/tencent/mm/protocal/protobuf/bsg:Tcx	I
    //   1325: bipush 102
    //   1327: if_icmpne +21 -> 1348
    //   1330: aload 15
    //   1332: ldc_w 315
    //   1335: iconst_4
    //   1336: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1339: invokeinterface 313 3 0
    //   1344: pop
    //   1345: goto -873 -> 472
    //   1348: aload 6
    //   1350: getfield 322	com/tencent/mm/protocal/protobuf/bsg:Tcx	I
    //   1353: bipush 101
    //   1355: if_icmpne -883 -> 472
    //   1358: aload 15
    //   1360: ldc_w 317
    //   1363: iconst_4
    //   1364: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1367: invokeinterface 313 3 0
    //   1372: pop
    //   1373: goto -901 -> 472
    //   1376: astore 5
    //   1378: ldc 142
    //   1380: aload 5
    //   1382: ldc_w 434
    //   1385: iconst_0
    //   1386: anewarray 146	java/lang/Object
    //   1389: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1392: goto -1158 -> 234
    //   1395: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1398: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1401: getstatic 257	com/tencent/mm/storage/ar$a:Vim	Lcom/tencent/mm/storage/ar$a;
    //   1404: ldc_w 434
    //   1407: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1410: goto -1176 -> 234
    //   1413: astore 5
    //   1415: ldc 142
    //   1417: aload 5
    //   1419: ldc_w 434
    //   1422: iconst_0
    //   1423: anewarray 146	java/lang/Object
    //   1426: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1429: goto -1100 -> 329
    //   1432: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1435: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1438: getstatic 281	com/tencent/mm/storage/ar$a:Vin	Lcom/tencent/mm/storage/ar$a;
    //   1441: ldc_w 434
    //   1444: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1447: invokestatic 97	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   1450: invokevirtual 103	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   1453: getstatic 284	com/tencent/mm/storage/ar$a:Vip	Lcom/tencent/mm/storage/ar$a;
    //   1456: getstatic 441	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1459: invokevirtual 198	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   1462: goto -1118 -> 344
    //   1465: iconst_0
    //   1466: istore 7
    //   1468: goto -878 -> 590
    //   1471: iconst_0
    //   1472: istore 7
    //   1474: iload 12
    //   1476: istore 13
    //   1478: goto -391 -> 1087
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1481	0	this	ad
    //   0	1481	1	paramInt1	int
    //   0	1481	2	paramInt2	int
    //   0	1481	3	paramInt3	int
    //   0	1481	4	paramString	String
    //   0	1481	5	params	com.tencent.mm.network.s
    //   0	1481	6	paramArrayOfByte	byte[]
    //   588	885	7	i	int
    //   114	1148	8	l1	long
    //   487	773	10	l2	long
    //   182	1293	12	bool1	boolean
    //   368	1109	13	bool2	boolean
    //   43	249	14	localbsd	bsd
    //   385	974	15	localObject	Object
    //   1208	83	16	localIDKey1	com.tencent.mars.smc.IDKey
    //   1240	59	17	localIDKey2	com.tencent.mars.smc.IDKey
    // Exception table:
    //   from	to	target	type
    //   197	234	1376	java/io/IOException
    //   291	329	1413	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ad
 * JD-Core Version:    0.7.0.1
 */