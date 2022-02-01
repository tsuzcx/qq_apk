package com.tencent.mm.contact.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.openim.model.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  p maU;
  com.tencent.mm.am.h maV;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(233776);
    this.maV = new com.tencent.mm.am.h()
    {
      /* Error */
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   9: getfield 33	com/tencent/mm/contact/a/a/b:maU	Lcom/tencent/mm/am/p;
        //   12: aload 4
        //   14: invokevirtual 37	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   17: ifeq +680 -> 697
        //   20: invokestatic 43	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
        //   23: pop
        //   24: invokestatic 47	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
        //   27: getfield 53	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
        //   30: aload 4
        //   32: invokevirtual 59	com/tencent/mm/am/p:getType	()I
        //   35: aload_0
        //   36: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   39: getfield 63	com/tencent/mm/contact/a/a/b:maV	Lcom/tencent/mm/am/h;
        //   42: invokevirtual 69	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
        //   45: aload_0
        //   46: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   49: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/w;
        //   52: ifnull +13 -> 65
        //   55: aload_0
        //   56: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   59: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/w;
        //   62: invokevirtual 78	com/tencent/mm/ui/base/w:dismiss	()V
        //   65: ldc 80
        //   67: astore 7
        //   69: ldc 80
        //   71: astore 6
        //   73: iload_1
        //   74: ifne +337 -> 411
        //   77: iload_2
        //   78: ifne +333 -> 411
        //   81: aload 6
        //   83: astore_3
        //   84: iload_2
        //   85: istore_1
        //   86: aload 4
        //   88: invokevirtual 59	com/tencent/mm/am/p:getType	()I
        //   91: sipush 806
        //   94: if_icmpne +153 -> 247
        //   97: aload 6
        //   99: astore_3
        //   100: iload_2
        //   101: istore_1
        //   102: aload 4
        //   104: invokevirtual 84	com/tencent/mm/am/p:getReqResp	()Lcom/tencent/mm/network/s;
        //   107: checkcast 86	com/tencent/mm/am/c
        //   110: getfield 90	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
        //   113: invokestatic 95	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
        //   116: checkcast 97	com/tencent/mm/protocal/protobuf/dyb
        //   119: astore 4
        //   121: aload 4
        //   123: invokevirtual 101	com/tencent/mm/protocal/protobuf/dyb:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/kd;
        //   126: ifnull +622 -> 748
        //   129: aload 4
        //   131: invokevirtual 101	com/tencent/mm/protocal/protobuf/dyb:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/kd;
        //   134: getfield 107	com/tencent/mm/protocal/protobuf/kd:Idd	I
        //   137: istore_1
        //   138: iload_1
        //   139: istore_2
        //   140: aload 7
        //   142: astore 4
        //   144: aload 6
        //   146: astore_3
        //   147: aload_0
        //   148: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   151: getfield 111	com/tencent/mm/contact/a/a/b:maS	Ljava/util/List;
        //   154: invokeinterface 117 1 0
        //   159: ifne +358 -> 517
        //   162: aload_0
        //   163: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   166: getfield 111	com/tencent/mm/contact/a/a/b:maS	Ljava/util/List;
        //   169: invokeinterface 121 1 0
        //   174: astore 6
        //   176: aload 6
        //   178: invokeinterface 126 1 0
        //   183: ifeq +334 -> 517
        //   186: aload 6
        //   188: invokeinterface 130 1 0
        //   193: checkcast 132	com/tencent/mm/model/t
        //   196: astore 7
        //   198: aload 7
        //   200: instanceof 134
        //   203: ifeq +29 -> 232
        //   206: aload 7
        //   208: checkcast 134	com/tencent/mm/contact/a/b
        //   211: astore 8
        //   213: aload 8
        //   215: iload_2
        //   216: putfield 137	com/tencent/mm/contact/a/b:ret	I
        //   219: aload 8
        //   221: aload 4
        //   223: putfield 141	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   226: aload 8
        //   228: aload_3
        //   229: putfield 144	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   232: aload 7
        //   234: iload_2
        //   235: ldc 80
        //   237: aload 7
        //   239: invokeinterface 148 4 0
        //   244: goto -68 -> 176
        //   247: aload 6
        //   249: astore_3
        //   250: iload_2
        //   251: istore_1
        //   252: aload 4
        //   254: checkcast 150	com/tencent/mm/ay/b
        //   257: getfield 154	com/tencent/mm/ay/b:oPG	Lcom/tencent/mm/ay/b$a;
        //   260: invokevirtual 160	com/tencent/mm/ay/b$a:getRespObj	()Lcom/tencent/mm/protocal/l$e;
        //   263: checkcast 162	com/tencent/mm/ay/b$c
        //   266: getfield 166	com/tencent/mm/ay/b$c:oPL	Lcom/tencent/mm/protocal/protobuf/dze;
        //   269: astore 4
        //   271: aload 6
        //   273: astore_3
        //   274: iload_2
        //   275: istore_1
        //   276: aload 4
        //   278: getfield 172	com/tencent/mm/protocal/protobuf/dze:abdX	Lcom/tencent/mm/protocal/protobuf/dzf;
        //   281: getfield 178	com/tencent/mm/protocal/protobuf/dzf:aamU	Ljava/util/LinkedList;
        //   284: invokevirtual 183	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   287: checkcast 185	java/lang/Integer
        //   290: invokevirtual 188	java/lang/Integer:intValue	()I
        //   293: istore_2
        //   294: aload 6
        //   296: astore_3
        //   297: iload_2
        //   298: istore_1
        //   299: aload 4
        //   301: getfield 172	com/tencent/mm/protocal/protobuf/dze:abdX	Lcom/tencent/mm/protocal/protobuf/dzf;
        //   304: getfield 191	com/tencent/mm/protocal/protobuf/dzf:abdY	Ljava/util/LinkedList;
        //   307: invokevirtual 183	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   310: checkcast 193	com/tencent/mm/protocal/protobuf/dzc
        //   313: astore 8
        //   315: aload 8
        //   317: ifnull +421 -> 738
        //   320: aload 6
        //   322: astore_3
        //   323: iload_2
        //   324: istore_1
        //   325: aload 8
        //   327: getfield 196	com/tencent/mm/protocal/protobuf/dzc:nUB	Ljava/lang/String;
        //   330: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   333: ifne +405 -> 738
        //   336: aload 6
        //   338: astore_3
        //   339: iload_2
        //   340: istore_1
        //   341: aload 8
        //   343: getfield 196	com/tencent/mm/protocal/protobuf/dzc:nUB	Ljava/lang/String;
        //   346: astore 4
        //   348: aload 4
        //   350: astore_3
        //   351: iload_2
        //   352: istore_1
        //   353: aload 8
        //   355: getfield 205	com/tencent/mm/protocal/protobuf/dzc:hAP	Ljava/lang/String;
        //   358: ldc 80
        //   360: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   363: astore 6
        //   365: aload 6
        //   367: astore_3
        //   368: aload_3
        //   369: astore 6
        //   371: aload 4
        //   373: astore_3
        //   374: aload 6
        //   376: astore 4
        //   378: goto -231 -> 147
        //   381: astore 4
        //   383: ldc 211
        //   385: ldc 213
        //   387: iconst_1
        //   388: anewarray 4	java/lang/Object
        //   391: dup
        //   392: iconst_0
        //   393: aload 4
        //   395: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   398: aastore
        //   399: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   402: aload 7
        //   404: astore 4
        //   406: iload_1
        //   407: istore_2
        //   408: goto -261 -> 147
        //   411: aload 4
        //   413: invokevirtual 59	com/tencent/mm/am/p:getType	()I
        //   416: sipush 806
        //   419: if_icmpne +312 -> 731
        //   422: aload 4
        //   424: invokevirtual 84	com/tencent/mm/am/p:getReqResp	()Lcom/tencent/mm/network/s;
        //   427: checkcast 86	com/tencent/mm/am/c
        //   430: getfield 90	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
        //   433: invokestatic 95	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
        //   436: checkcast 97	com/tencent/mm/protocal/protobuf/dyb
        //   439: astore 4
        //   441: aload 4
        //   443: ifnull +288 -> 731
        //   446: aload 4
        //   448: invokevirtual 101	com/tencent/mm/protocal/protobuf/dyb:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/kd;
        //   451: ifnull +280 -> 731
        //   454: aload 4
        //   456: invokevirtual 101	com/tencent/mm/protocal/protobuf/dyb:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/kd;
        //   459: getfield 227	com/tencent/mm/protocal/protobuf/kd:akjO	Lcom/tencent/mm/protocal/protobuf/etl;
        //   462: invokestatic 232	com/tencent/mm/platformtools/w:a	(Lcom/tencent/mm/protocal/protobuf/etl;)Ljava/lang/String;
        //   465: astore 4
        //   467: aload 4
        //   469: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   472: istore 5
        //   474: iload 5
        //   476: ifeq +249 -> 725
        //   479: aload 7
        //   481: astore 4
        //   483: goto -336 -> 147
        //   486: astore 4
        //   488: aload 6
        //   490: astore_3
        //   491: ldc 211
        //   493: ldc 213
        //   495: iconst_1
        //   496: anewarray 4	java/lang/Object
        //   499: dup
        //   500: iconst_0
        //   501: aload 4
        //   503: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   506: aastore
        //   507: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   510: aload 7
        //   512: astore 4
        //   514: goto -367 -> 147
        //   517: iload_2
        //   518: ifne +94 -> 612
        //   521: aload_0
        //   522: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   525: getfield 235	com/tencent/mm/contact/a/a/b:maQ	Ljava/util/List;
        //   528: invokeinterface 121 1 0
        //   533: astore 6
        //   535: aload 6
        //   537: invokeinterface 126 1 0
        //   542: ifeq +64 -> 606
        //   545: aload 6
        //   547: invokeinterface 130 1 0
        //   552: checkcast 132	com/tencent/mm/model/t
        //   555: astore 7
        //   557: aload 7
        //   559: instanceof 134
        //   562: ifeq +29 -> 591
        //   565: aload 7
        //   567: checkcast 134	com/tencent/mm/contact/a/b
        //   570: astore 8
        //   572: aload 8
        //   574: iload_2
        //   575: putfield 137	com/tencent/mm/contact/a/b:ret	I
        //   578: aload 8
        //   580: aload 4
        //   582: putfield 141	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   585: aload 8
        //   587: aload_3
        //   588: putfield 144	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   591: aload 7
        //   593: iload_2
        //   594: ldc 80
        //   596: aload 7
        //   598: invokeinterface 148 4 0
        //   603: goto -68 -> 535
        //   606: ldc 23
        //   608: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   611: return
        //   612: aload_0
        //   613: getfield 14	com/tencent/mm/contact/a/a/b$1:maW	Lcom/tencent/mm/contact/a/a/b;
        //   616: getfield 241	com/tencent/mm/contact/a/a/b:maR	Ljava/util/List;
        //   619: invokeinterface 121 1 0
        //   624: astore 6
        //   626: aload 6
        //   628: invokeinterface 126 1 0
        //   633: ifeq +64 -> 697
        //   636: aload 6
        //   638: invokeinterface 130 1 0
        //   643: checkcast 132	com/tencent/mm/model/t
        //   646: astore 7
        //   648: aload 7
        //   650: instanceof 134
        //   653: ifeq +29 -> 682
        //   656: aload 7
        //   658: checkcast 134	com/tencent/mm/contact/a/b
        //   661: astore 8
        //   663: aload 8
        //   665: iload_2
        //   666: putfield 137	com/tencent/mm/contact/a/b:ret	I
        //   669: aload 8
        //   671: aload 4
        //   673: putfield 141	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   676: aload 8
        //   678: aload_3
        //   679: putfield 144	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   682: aload 7
        //   684: iload_2
        //   685: ldc 80
        //   687: aload 7
        //   689: invokeinterface 148 4 0
        //   694: goto -68 -> 626
        //   697: ldc 23
        //   699: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   702: return
        //   703: astore 6
        //   705: aload 4
        //   707: astore_3
        //   708: aload 6
        //   710: astore 4
        //   712: goto -221 -> 491
        //   715: astore 4
        //   717: iconst_0
        //   718: istore_1
        //   719: aload 6
        //   721: astore_3
        //   722: goto -339 -> 383
        //   725: aload 4
        //   727: astore_3
        //   728: goto -249 -> 479
        //   731: ldc 80
        //   733: astore 4
        //   735: goto -268 -> 467
        //   738: ldc 80
        //   740: astore 4
        //   742: ldc 80
        //   744: astore_3
        //   745: goto -377 -> 368
        //   748: iconst_0
        //   749: istore_1
        //   750: goto -612 -> 138
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	753	0	this	1
        //   0	753	1	paramAnonymousInt1	int
        //   0	753	2	paramAnonymousInt2	int
        //   0	753	3	paramAnonymousString	String
        //   0	753	4	paramAnonymousp	p
        //   472	3	5	bool	boolean
        //   71	566	6	localObject1	Object
        //   703	17	6	localException	java.lang.Exception
        //   67	621	7	localObject2	Object
        //   211	466	8	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   86	97	381	java/lang/Exception
        //   102	121	381	java/lang/Exception
        //   252	271	381	java/lang/Exception
        //   276	294	381	java/lang/Exception
        //   299	315	381	java/lang/Exception
        //   325	336	381	java/lang/Exception
        //   341	348	381	java/lang/Exception
        //   353	365	381	java/lang/Exception
        //   411	441	486	java/lang/Exception
        //   446	467	486	java/lang/Exception
        //   467	474	703	java/lang/Exception
        //   121	138	715	java/lang/Exception
      }
    };
    this.maT = paramBoolean;
    AppMethodBeat.o(233776);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(233782);
    if (this.maT)
    {
      this.maU = new o(paramb);
      AppMethodBeat.o(233782);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.maU = new com.tencent.mm.ay.c(localLinkedList);
    AppMethodBeat.o(233782);
  }
  
  public final void m(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(233788);
    if (this.maU == null)
    {
      AppMethodBeat.o(233788);
      return;
    }
    this.tipDialog = k.a(paramContext, paramString2, false, null);
    if (this.maU != null)
    {
      Log.i("MicroMsg.ContactSyncOpLogCallbackFactory", "request scene %s", new Object[] { this.maU });
      if ((this.tipDialog != null) || (!this.maQ.isEmpty()) || (!this.maR.isEmpty()) || (!this.maS.isEmpty()))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(this.maU.getType(), this.maV);
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(this.maU, 0);
    }
    AppMethodBeat.o(233788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.b
 * JD-Core Version:    0.7.0.1
 */