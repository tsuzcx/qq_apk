package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class ad
  extends n
  implements k
{
  private f callback;
  public boolean oAf;
  public tv oAg;
  public cze oAh;
  public int oAi;
  private final b rr;
  
  public ad(double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(112846);
    this.oAf = false;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ayt();
    ((b.a)localObject).hNN = new ayu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardslayout";
    ((b.a)localObject).funcId = 1054;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ayt)this.rr.hNK.hNQ;
    ((ayt)localObject).latitude = paramDouble1;
    ((ayt)localObject).longitude = paramDouble2;
    ((ayt)localObject).scene = paramInt;
    ((ayt)localObject).GvZ = ((String)g.ajC().ajl().get(al.a.Iru, null));
    AppMethodBeat.o(112846);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112848);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112848);
    return i;
  }
  
  public final int getType()
  {
    return 1054;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 141
    //   7: ldc 143
    //   9: iconst_2
    //   10: anewarray 145	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_2
    //   16: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_3
    //   23: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 156	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 69	com/tencent/mm/plugin/card/model/ad:rr	Lcom/tencent/mm/al/b;
    //   34: getfield 160	com/tencent/mm/al/b:hNL	Lcom/tencent/mm/al/b$c;
    //   37: getfield 163	com/tencent/mm/al/b$c:hNQ	Lcom/tencent/mm/bx/a;
    //   40: checkcast 44	com/tencent/mm/protocal/protobuf/ayu
    //   43: astore 14
    //   45: ldc 141
    //   47: new 165	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 167
    //   53: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload 14
    //   58: getfield 173	com/tencent/mm/protocal/protobuf/ayu:ozQ	Ljava/lang/String;
    //   61: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload 14
    //   73: getfield 188	com/tencent/mm/protocal/protobuf/ayu:Gwa	Lcom/tencent/mm/protocal/protobuf/tv;
    //   76: putfield 190	com/tencent/mm/plugin/card/model/ad:oAg	Lcom/tencent/mm/protocal/protobuf/tv;
    //   79: iload_2
    //   80: ifne +264 -> 344
    //   83: iload_3
    //   84: ifne +260 -> 344
    //   87: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   90: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   93: getstatic 108	com/tencent/mm/storage/al$a:Iru	Lcom/tencent/mm/storage/al$a;
    //   96: aload 14
    //   98: getfield 191	com/tencent/mm/protocal/protobuf/ayu:GvZ	Ljava/lang/String;
    //   101: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   104: aload 14
    //   106: getfield 173	com/tencent/mm/protocal/protobuf/ayu:ozQ	Ljava/lang/String;
    //   109: astore 5
    //   111: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   114: lstore 8
    //   116: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   119: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   122: getstatic 204	com/tencent/mm/storage/al$a:Irt	Lcom/tencent/mm/storage/al$a;
    //   125: aconst_null
    //   126: invokevirtual 114	com/tencent/mm/storage/ai:get	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 116	java/lang/String
    //   132: astore 6
    //   134: aload 6
    //   136: invokestatic 210	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifne +7 -> 146
    //   142: aload 6
    //   144: astore 5
    //   146: aload 5
    //   148: invokestatic 216	com/tencent/mm/plugin/card/d/j:Zg	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ayx;
    //   151: astore 6
    //   153: invokestatic 222	com/tencent/mm/plugin/card/model/am:bUN	()Lcom/tencent/mm/plugin/card/model/c;
    //   156: getfield 228	com/tencent/mm/plugin/card/model/c:db	Lcom/tencent/mm/sdk/e/e;
    //   159: ldc 230
    //   161: ldc 232
    //   163: invokeinterface 238 3 0
    //   168: pop
    //   169: aload 6
    //   171: ifnonnull +193 -> 364
    //   174: ldc 240
    //   176: ldc 242
    //   178: invokestatic 245	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: iconst_0
    //   182: istore 12
    //   184: aload_0
    //   185: iload 12
    //   187: putfield 32	com/tencent/mm/plugin/card/model/ad:oAf	Z
    //   190: aload_0
    //   191: getfield 190	com/tencent/mm/plugin/card/model/ad:oAg	Lcom/tencent/mm/protocal/protobuf/tv;
    //   194: ifnull +1201 -> 1395
    //   197: aload_0
    //   198: getfield 190	com/tencent/mm/plugin/card/model/ad:oAg	Lcom/tencent/mm/protocal/protobuf/tv;
    //   201: invokevirtual 251	com/tencent/mm/protocal/protobuf/tv:toByteArray	()[B
    //   204: astore 5
    //   206: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   209: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   212: getstatic 254	com/tencent/mm/storage/al$a:IrO	Lcom/tencent/mm/storage/al$a;
    //   215: new 116	java/lang/String
    //   218: dup
    //   219: aload 5
    //   221: iconst_0
    //   222: aload 5
    //   224: arraylength
    //   225: ldc_w 256
    //   228: invokespecial 259	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   231: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   234: aload_0
    //   235: aload 14
    //   237: getfield 262	com/tencent/mm/protocal/protobuf/ayu:Gwb	I
    //   240: putfield 264	com/tencent/mm/plugin/card/model/ad:oAi	I
    //   243: aload_0
    //   244: getfield 264	com/tencent/mm/plugin/card/model/ad:oAi	I
    //   247: ifge +8 -> 255
    //   250: aload_0
    //   251: iconst_0
    //   252: putfield 264	com/tencent/mm/plugin/card/model/ad:oAi	I
    //   255: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   258: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   261: getstatic 267	com/tencent/mm/storage/al$a:IrQ	Lcom/tencent/mm/storage/al$a;
    //   264: aload_0
    //   265: getfield 264	com/tencent/mm/plugin/card/model/ad:oAi	I
    //   268: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   274: aload 14
    //   276: getfield 270	com/tencent/mm/protocal/protobuf/ayu:Gwc	Lcom/tencent/mm/protocal/protobuf/cze;
    //   279: ifnull +1153 -> 1432
    //   282: aload_0
    //   283: aload 14
    //   285: getfield 270	com/tencent/mm/protocal/protobuf/ayu:Gwc	Lcom/tencent/mm/protocal/protobuf/cze;
    //   288: putfield 272	com/tencent/mm/plugin/card/model/ad:oAh	Lcom/tencent/mm/protocal/protobuf/cze;
    //   291: aload 14
    //   293: getfield 270	com/tencent/mm/protocal/protobuf/ayu:Gwc	Lcom/tencent/mm/protocal/protobuf/cze;
    //   296: invokevirtual 275	com/tencent/mm/protocal/protobuf/cze:toByteArray	()[B
    //   299: astore 5
    //   301: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   304: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   307: getstatic 278	com/tencent/mm/storage/al$a:IrP	Lcom/tencent/mm/storage/al$a;
    //   310: new 116	java/lang/String
    //   313: dup
    //   314: aload 5
    //   316: iconst_0
    //   317: aload 5
    //   319: arraylength
    //   320: ldc_w 256
    //   323: invokespecial 259	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   326: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   329: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   332: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   335: getstatic 281	com/tencent/mm/storage/al$a:IrR	Lcom/tencent/mm/storage/al$a;
    //   338: getstatic 287	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   341: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   344: aload_0
    //   345: getfield 128	com/tencent/mm/plugin/card/model/ad:callback	Lcom/tencent/mm/al/f;
    //   348: iload_2
    //   349: iload_3
    //   350: aload 4
    //   352: aload_0
    //   353: invokeinterface 293 5 0
    //   358: ldc 139
    //   360: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: return
    //   364: iconst_0
    //   365: istore 12
    //   367: iconst_0
    //   368: istore 13
    //   370: aload 6
    //   372: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   375: ifnull +1096 -> 1471
    //   378: new 301	java/util/HashMap
    //   381: dup
    //   382: invokespecial 302	java/util/HashMap:<init>	()V
    //   385: astore 15
    //   387: aload 15
    //   389: ldc_w 304
    //   392: iconst_2
    //   393: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokeinterface 310 3 0
    //   401: pop
    //   402: aload 15
    //   404: ldc_w 312
    //   407: iconst_2
    //   408: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: invokeinterface 310 3 0
    //   416: pop
    //   417: aload 15
    //   419: ldc_w 314
    //   422: iconst_3
    //   423: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: invokeinterface 310 3 0
    //   431: pop
    //   432: aload 15
    //   434: ldc_w 316
    //   437: iconst_5
    //   438: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: invokeinterface 310 3 0
    //   446: pop
    //   447: aload 6
    //   449: getfield 319	com/tencent/mm/protocal/protobuf/ayx:Gwi	I
    //   452: bipush 100
    //   454: if_icmpne +866 -> 1320
    //   457: aload 15
    //   459: ldc_w 304
    //   462: iconst_4
    //   463: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokeinterface 310 3 0
    //   471: pop
    //   472: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   475: getfield 323	com/tencent/mm/kernel/e:gBq	Lcom/tencent/mm/storagebase/h;
    //   478: invokestatic 329	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   481: invokevirtual 332	java/lang/Thread:getId	()J
    //   484: invokevirtual 338	com/tencent/mm/storagebase/h:xO	(J)J
    //   487: lstore 10
    //   489: aload 6
    //   491: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   494: getfield 344	com/tencent/mm/protocal/protobuf/uv:FUq	Lcom/tencent/mm/protocal/protobuf/uu;
    //   497: ifnull +968 -> 1465
    //   500: aload 6
    //   502: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   505: getfield 344	com/tencent/mm/protocal/protobuf/uv:FUq	Lcom/tencent/mm/protocal/protobuf/uu;
    //   508: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   511: ifnull +954 -> 1465
    //   514: aload 6
    //   516: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   519: getfield 344	com/tencent/mm/protocal/protobuf/uv:FUq	Lcom/tencent/mm/protocal/protobuf/uu;
    //   522: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   525: invokevirtual 355	java/util/LinkedList:size	()I
    //   528: ifle +937 -> 1465
    //   531: iconst_1
    //   532: istore 13
    //   534: aload 15
    //   536: ldc_w 304
    //   539: invokeinterface 358 2 0
    //   544: checkcast 147	java/lang/Integer
    //   547: invokevirtual 361	java/lang/Integer:intValue	()I
    //   550: istore_1
    //   551: aload 6
    //   553: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   556: getfield 344	com/tencent/mm/protocal/protobuf/uv:FUq	Lcom/tencent/mm/protocal/protobuf/uu;
    //   559: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   562: iload_1
    //   563: ldc_w 362
    //   566: imul
    //   567: iconst_3
    //   568: iadd
    //   569: invokestatic 366	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   572: aload 6
    //   574: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   577: getfield 344	com/tencent/mm/protocal/protobuf/uv:FUq	Lcom/tencent/mm/protocal/protobuf/uu;
    //   580: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   583: invokevirtual 355	java/util/LinkedList:size	()I
    //   586: iconst_0
    //   587: iadd
    //   588: istore 7
    //   590: iload 7
    //   592: istore_1
    //   593: iload 13
    //   595: istore 12
    //   597: aload 6
    //   599: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   602: getfield 369	com/tencent/mm/protocal/protobuf/uv:FUr	Lcom/tencent/mm/protocal/protobuf/uu;
    //   605: ifnull +107 -> 712
    //   608: iload 7
    //   610: istore_1
    //   611: iload 13
    //   613: istore 12
    //   615: aload 6
    //   617: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   620: getfield 369	com/tencent/mm/protocal/protobuf/uv:FUr	Lcom/tencent/mm/protocal/protobuf/uu;
    //   623: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   626: ifnull +86 -> 712
    //   629: iload 7
    //   631: istore_1
    //   632: iload 13
    //   634: istore 12
    //   636: aload 6
    //   638: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   641: getfield 369	com/tencent/mm/protocal/protobuf/uv:FUr	Lcom/tencent/mm/protocal/protobuf/uu;
    //   644: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   647: invokevirtual 355	java/util/LinkedList:size	()I
    //   650: ifle +62 -> 712
    //   653: iconst_1
    //   654: istore 12
    //   656: aload 15
    //   658: ldc_w 312
    //   661: invokeinterface 358 2 0
    //   666: checkcast 147	java/lang/Integer
    //   669: invokevirtual 361	java/lang/Integer:intValue	()I
    //   672: istore_1
    //   673: aload 6
    //   675: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   678: getfield 369	com/tencent/mm/protocal/protobuf/uv:FUr	Lcom/tencent/mm/protocal/protobuf/uu;
    //   681: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   684: iload_1
    //   685: ldc_w 362
    //   688: imul
    //   689: iconst_2
    //   690: iadd
    //   691: invokestatic 366	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   694: iload 7
    //   696: aload 6
    //   698: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   701: getfield 369	com/tencent/mm/protocal/protobuf/uv:FUr	Lcom/tencent/mm/protocal/protobuf/uu;
    //   704: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   707: invokevirtual 355	java/util/LinkedList:size	()I
    //   710: iadd
    //   711: istore_1
    //   712: iload_1
    //   713: istore 7
    //   715: iload 12
    //   717: istore 13
    //   719: aload 6
    //   721: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   724: getfield 372	com/tencent/mm/protocal/protobuf/uv:FUs	Lcom/tencent/mm/protocal/protobuf/uu;
    //   727: ifnull +109 -> 836
    //   730: iload_1
    //   731: istore 7
    //   733: iload 12
    //   735: istore 13
    //   737: aload 6
    //   739: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   742: getfield 372	com/tencent/mm/protocal/protobuf/uv:FUs	Lcom/tencent/mm/protocal/protobuf/uu;
    //   745: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   748: ifnull +88 -> 836
    //   751: iload_1
    //   752: istore 7
    //   754: iload 12
    //   756: istore 13
    //   758: aload 6
    //   760: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   763: getfield 372	com/tencent/mm/protocal/protobuf/uv:FUs	Lcom/tencent/mm/protocal/protobuf/uu;
    //   766: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   769: invokevirtual 355	java/util/LinkedList:size	()I
    //   772: ifle +64 -> 836
    //   775: iconst_1
    //   776: istore 13
    //   778: aload 15
    //   780: ldc_w 314
    //   783: invokeinterface 358 2 0
    //   788: checkcast 147	java/lang/Integer
    //   791: invokevirtual 361	java/lang/Integer:intValue	()I
    //   794: istore 7
    //   796: aload 6
    //   798: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   801: getfield 372	com/tencent/mm/protocal/protobuf/uv:FUs	Lcom/tencent/mm/protocal/protobuf/uu;
    //   804: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   807: iload 7
    //   809: ldc_w 362
    //   812: imul
    //   813: iconst_1
    //   814: iadd
    //   815: invokestatic 366	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   818: iload_1
    //   819: aload 6
    //   821: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   824: getfield 372	com/tencent/mm/protocal/protobuf/uv:FUs	Lcom/tencent/mm/protocal/protobuf/uu;
    //   827: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   830: invokevirtual 355	java/util/LinkedList:size	()I
    //   833: iadd
    //   834: istore 7
    //   836: iload 7
    //   838: istore_1
    //   839: iload 13
    //   841: istore 12
    //   843: aload 6
    //   845: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   848: getfield 375	com/tencent/mm/protocal/protobuf/uv:FUt	Lcom/tencent/mm/protocal/protobuf/uu;
    //   851: ifnull +84 -> 935
    //   854: iload 7
    //   856: istore_1
    //   857: iload 13
    //   859: istore 12
    //   861: aload 6
    //   863: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   866: getfield 375	com/tencent/mm/protocal/protobuf/uv:FUt	Lcom/tencent/mm/protocal/protobuf/uu;
    //   869: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   872: ifnull +63 -> 935
    //   875: iload 7
    //   877: istore_1
    //   878: iload 13
    //   880: istore 12
    //   882: aload 6
    //   884: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   887: getfield 375	com/tencent/mm/protocal/protobuf/uv:FUt	Lcom/tencent/mm/protocal/protobuf/uu;
    //   890: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   893: invokevirtual 355	java/util/LinkedList:size	()I
    //   896: ifle +39 -> 935
    //   899: iconst_1
    //   900: istore 12
    //   902: iload 7
    //   904: aload 6
    //   906: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   909: getfield 375	com/tencent/mm/protocal/protobuf/uv:FUt	Lcom/tencent/mm/protocal/protobuf/uu;
    //   912: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   915: invokevirtual 355	java/util/LinkedList:size	()I
    //   918: iadd
    //   919: istore_1
    //   920: aload 6
    //   922: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   925: getfield 375	com/tencent/mm/protocal/protobuf/uv:FUt	Lcom/tencent/mm/protocal/protobuf/uu;
    //   928: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   931: iconst_0
    //   932: invokestatic 378	com/tencent/mm/plugin/card/d/j:e	(Ljava/util/LinkedList;I)V
    //   935: iload_1
    //   936: istore 7
    //   938: iload 12
    //   940: istore 13
    //   942: aload 6
    //   944: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   947: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   950: ifnull +125 -> 1075
    //   953: iload_1
    //   954: istore 7
    //   956: iload 12
    //   958: istore 13
    //   960: aload 6
    //   962: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   965: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   968: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   971: ifnull +104 -> 1075
    //   974: iload_1
    //   975: istore 7
    //   977: iload 12
    //   979: istore 13
    //   981: aload 6
    //   983: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   986: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   989: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   992: invokevirtual 355	java/util/LinkedList:size	()I
    //   995: ifle +80 -> 1075
    //   998: iconst_1
    //   999: istore 13
    //   1001: aload 15
    //   1003: ldc_w 316
    //   1006: invokeinterface 358 2 0
    //   1011: checkcast 147	java/lang/Integer
    //   1014: invokevirtual 361	java/lang/Integer:intValue	()I
    //   1017: ldc_w 362
    //   1020: imul
    //   1021: iconst_4
    //   1022: iadd
    //   1023: istore 7
    //   1025: aload 6
    //   1027: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   1030: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   1033: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   1036: iload 7
    //   1038: invokestatic 366	com/tencent/mm/plugin/card/d/j:d	(Ljava/util/LinkedList;I)V
    //   1041: aload 6
    //   1043: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   1046: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   1049: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   1052: iload 7
    //   1054: invokestatic 378	com/tencent/mm/plugin/card/d/j:e	(Ljava/util/LinkedList;I)V
    //   1057: iload_1
    //   1058: aload 6
    //   1060: getfield 299	com/tencent/mm/protocal/protobuf/ayx:Gwf	Lcom/tencent/mm/protocal/protobuf/uv;
    //   1063: getfield 381	com/tencent/mm/protocal/protobuf/uv:FUu	Lcom/tencent/mm/protocal/protobuf/uu;
    //   1066: getfield 350	com/tencent/mm/protocal/protobuf/uu:FUp	Ljava/util/LinkedList;
    //   1069: invokevirtual 355	java/util/LinkedList:size	()I
    //   1072: iadd
    //   1073: istore 7
    //   1075: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1078: getfield 323	com/tencent/mm/kernel/e:gBq	Lcom/tencent/mm/storagebase/h;
    //   1081: lload 10
    //   1083: invokevirtual 385	com/tencent/mm/storagebase/h:sJ	(J)I
    //   1086: pop
    //   1087: invokestatic 389	com/tencent/mm/plugin/card/model/am:bUS	()Lcom/tencent/mm/plugin/card/b/e;
    //   1090: ldc_w 391
    //   1093: aload 6
    //   1095: invokevirtual 397	com/tencent/mm/plugin/card/b/e:putValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1098: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1101: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1104: getstatic 400	com/tencent/mm/storage/al$a:IrC	Lcom/tencent/mm/storage/al$a;
    //   1107: aload 5
    //   1109: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   1112: iload 13
    //   1114: istore 12
    //   1116: iload 7
    //   1118: ifle -934 -> 184
    //   1121: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   1124: lstore 10
    //   1126: new 402	java/util/ArrayList
    //   1129: dup
    //   1130: invokespecial 403	java/util/ArrayList:<init>	()V
    //   1133: astore 5
    //   1135: new 405	com/tencent/mars/smc/IDKey
    //   1138: dup
    //   1139: invokespecial 406	com/tencent/mars/smc/IDKey:<init>	()V
    //   1142: astore 6
    //   1144: aload 6
    //   1146: sipush 281
    //   1149: invokevirtual 409	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1152: aload 6
    //   1154: bipush 36
    //   1156: invokevirtual 412	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1159: aload 6
    //   1161: lconst_1
    //   1162: invokevirtual 416	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1165: new 405	com/tencent/mars/smc/IDKey
    //   1168: dup
    //   1169: invokespecial 406	com/tencent/mars/smc/IDKey:<init>	()V
    //   1172: astore 15
    //   1174: aload 15
    //   1176: sipush 281
    //   1179: invokevirtual 409	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1182: aload 15
    //   1184: bipush 37
    //   1186: invokevirtual 412	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1189: aload 15
    //   1191: lload 10
    //   1193: lload 8
    //   1195: lsub
    //   1196: l2i
    //   1197: i2l
    //   1198: invokevirtual 416	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1201: new 405	com/tencent/mars/smc/IDKey
    //   1204: dup
    //   1205: invokespecial 406	com/tencent/mars/smc/IDKey:<init>	()V
    //   1208: astore 16
    //   1210: aload 16
    //   1212: sipush 281
    //   1215: invokevirtual 409	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1218: aload 16
    //   1220: bipush 38
    //   1222: invokevirtual 412	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1225: aload 16
    //   1227: iload 7
    //   1229: i2l
    //   1230: invokevirtual 416	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1233: new 405	com/tencent/mars/smc/IDKey
    //   1236: dup
    //   1237: invokespecial 406	com/tencent/mars/smc/IDKey:<init>	()V
    //   1240: astore 17
    //   1242: aload 17
    //   1244: sipush 281
    //   1247: invokevirtual 409	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   1250: aload 17
    //   1252: bipush 40
    //   1254: invokevirtual 412	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   1257: aload 17
    //   1259: lload 10
    //   1261: lload 8
    //   1263: lsub
    //   1264: l2i
    //   1265: iload 7
    //   1267: idiv
    //   1268: i2l
    //   1269: invokevirtual 416	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   1272: aload 5
    //   1274: aload 6
    //   1276: invokevirtual 420	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1279: pop
    //   1280: aload 5
    //   1282: aload 15
    //   1284: invokevirtual 420	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1287: pop
    //   1288: aload 5
    //   1290: aload 16
    //   1292: invokevirtual 420	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1295: pop
    //   1296: aload 5
    //   1298: aload 17
    //   1300: invokevirtual 420	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1303: pop
    //   1304: getstatic 426	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   1307: aload 5
    //   1309: iconst_1
    //   1310: invokevirtual 430	com/tencent/mm/plugin/report/service/g:b	(Ljava/util/ArrayList;Z)V
    //   1313: iload 13
    //   1315: istore 12
    //   1317: goto -1133 -> 184
    //   1320: aload 6
    //   1322: getfield 319	com/tencent/mm/protocal/protobuf/ayx:Gwi	I
    //   1325: bipush 102
    //   1327: if_icmpne +21 -> 1348
    //   1330: aload 15
    //   1332: ldc_w 312
    //   1335: iconst_4
    //   1336: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1339: invokeinterface 310 3 0
    //   1344: pop
    //   1345: goto -873 -> 472
    //   1348: aload 6
    //   1350: getfield 319	com/tencent/mm/protocal/protobuf/ayx:Gwi	I
    //   1353: bipush 101
    //   1355: if_icmpne -883 -> 472
    //   1358: aload 15
    //   1360: ldc_w 314
    //   1363: iconst_4
    //   1364: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1367: invokeinterface 310 3 0
    //   1372: pop
    //   1373: goto -901 -> 472
    //   1376: astore 5
    //   1378: ldc 141
    //   1380: aload 5
    //   1382: ldc_w 432
    //   1385: iconst_0
    //   1386: anewarray 145	java/lang/Object
    //   1389: invokestatic 436	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1392: goto -1158 -> 234
    //   1395: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1398: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1401: getstatic 254	com/tencent/mm/storage/al$a:IrO	Lcom/tencent/mm/storage/al$a;
    //   1404: ldc_w 432
    //   1407: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   1410: goto -1176 -> 234
    //   1413: astore 5
    //   1415: ldc 141
    //   1417: aload 5
    //   1419: ldc_w 432
    //   1422: iconst_0
    //   1423: anewarray 145	java/lang/Object
    //   1426: invokestatic 436	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1429: goto -1100 -> 329
    //   1432: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1435: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1438: getstatic 278	com/tencent/mm/storage/al$a:IrP	Lcom/tencent/mm/storage/al$a;
    //   1441: ldc_w 432
    //   1444: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   1447: invokestatic 96	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   1450: invokevirtual 102	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   1453: getstatic 281	com/tencent/mm/storage/al$a:IrR	Lcom/tencent/mm/storage/al$a;
    //   1456: getstatic 439	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1459: invokevirtual 195	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
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
    //   0	1481	5	paramq	com.tencent.mm.network.q
    //   0	1481	6	paramArrayOfByte	byte[]
    //   588	885	7	i	int
    //   114	1148	8	l1	long
    //   487	773	10	l2	long
    //   182	1293	12	bool1	boolean
    //   368	1109	13	bool2	boolean
    //   43	249	14	localayu	ayu
    //   385	974	15	localObject	Object
    //   1208	83	16	localIDKey1	com.tencent.mars.smc.IDKey
    //   1240	59	17	localIDKey2	com.tencent.mars.smc.IDKey
    // Exception table:
    //   from	to	target	type
    //   197	234	1376	java/io/IOException
    //   291	329	1413	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ad
 * JD-Core Version:    0.7.0.1
 */