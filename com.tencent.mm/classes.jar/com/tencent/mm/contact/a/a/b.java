package com.tencent.mm.contact.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  q jxA;
  i jxB;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(188746);
    this.jxB = new i()
    {
      /* Error */
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   9: getfield 33	com/tencent/mm/contact/a/a/b:jxA	Lcom/tencent/mm/an/q;
        //   12: aload 4
        //   14: invokevirtual 37	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   17: ifeq +683 -> 700
        //   20: invokestatic 43	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
        //   23: pop
        //   24: invokestatic 47	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
        //   27: getfield 53	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
        //   30: aload 4
        //   32: invokevirtual 59	com/tencent/mm/an/q:getType	()I
        //   35: aload_0
        //   36: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   39: getfield 63	com/tencent/mm/contact/a/a/b:jxB	Lcom/tencent/mm/an/i;
        //   42: invokevirtual 69	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
        //   45: aload_0
        //   46: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   49: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/s;
        //   52: ifnull +13 -> 65
        //   55: aload_0
        //   56: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   59: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/s;
        //   62: invokevirtual 78	com/tencent/mm/ui/base/s:dismiss	()V
        //   65: ldc 80
        //   67: astore 7
        //   69: ldc 80
        //   71: astore 6
        //   73: iload_1
        //   74: ifne +340 -> 414
        //   77: iload_2
        //   78: ifne +336 -> 414
        //   81: aload 6
        //   83: astore_3
        //   84: iload_2
        //   85: istore_1
        //   86: aload 4
        //   88: invokevirtual 59	com/tencent/mm/an/q:getType	()I
        //   91: sipush 806
        //   94: if_icmpne +153 -> 247
        //   97: aload 6
        //   99: astore_3
        //   100: iload_2
        //   101: istore_1
        //   102: aload 4
        //   104: invokevirtual 84	com/tencent/mm/an/q:getReqResp	()Lcom/tencent/mm/network/s;
        //   107: checkcast 86	com/tencent/mm/an/d
        //   110: getfield 90	com/tencent/mm/an/d:lBS	Lcom/tencent/mm/an/d$c;
        //   113: invokestatic 95	com/tencent/mm/an/d$c:b	(Lcom/tencent/mm/an/d$c;)Lcom/tencent/mm/cd/a;
        //   116: checkcast 97	com/tencent/mm/protocal/protobuf/dfv
        //   119: astore 4
        //   121: aload 4
        //   123: invokevirtual 101	com/tencent/mm/protocal/protobuf/dfv:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/jh;
        //   126: ifnull +625 -> 751
        //   129: aload 4
        //   131: invokevirtual 101	com/tencent/mm/protocal/protobuf/dfv:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/jh;
        //   134: getfield 107	com/tencent/mm/protocal/protobuf/jh:CqV	I
        //   137: istore_1
        //   138: iload_1
        //   139: istore_2
        //   140: aload 7
        //   142: astore 4
        //   144: aload 6
        //   146: astore_3
        //   147: aload_0
        //   148: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   151: getfield 111	com/tencent/mm/contact/a/a/b:jxy	Ljava/util/List;
        //   154: invokeinterface 117 1 0
        //   159: ifne +361 -> 520
        //   162: aload_0
        //   163: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   166: getfield 111	com/tencent/mm/contact/a/a/b:jxy	Ljava/util/List;
        //   169: invokeinterface 121 1 0
        //   174: astore 6
        //   176: aload 6
        //   178: invokeinterface 126 1 0
        //   183: ifeq +337 -> 520
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
        //   254: checkcast 150	com/tencent/mm/bd/b
        //   257: getfield 154	com/tencent/mm/bd/b:lWE	Lcom/tencent/mm/bd/b$a;
        //   260: invokevirtual 160	com/tencent/mm/bd/b$a:getRespObj	()Lcom/tencent/mm/protocal/l$e;
        //   263: checkcast 162	com/tencent/mm/bd/b$c
        //   266: checkcast 162	com/tencent/mm/bd/b$c
        //   269: getfield 166	com/tencent/mm/bd/b$c:lWJ	Lcom/tencent/mm/protocal/protobuf/dgx;
        //   272: astore 4
        //   274: aload 6
        //   276: astore_3
        //   277: iload_2
        //   278: istore_1
        //   279: aload 4
        //   281: getfield 172	com/tencent/mm/protocal/protobuf/dgx:TNE	Lcom/tencent/mm/protocal/protobuf/dgy;
        //   284: getfield 178	com/tencent/mm/protocal/protobuf/dgy:SZW	Ljava/util/LinkedList;
        //   287: invokevirtual 183	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   290: checkcast 185	java/lang/Integer
        //   293: invokevirtual 188	java/lang/Integer:intValue	()I
        //   296: istore_2
        //   297: aload 6
        //   299: astore_3
        //   300: iload_2
        //   301: istore_1
        //   302: aload 4
        //   304: getfield 172	com/tencent/mm/protocal/protobuf/dgx:TNE	Lcom/tencent/mm/protocal/protobuf/dgy;
        //   307: getfield 191	com/tencent/mm/protocal/protobuf/dgy:TNF	Ljava/util/LinkedList;
        //   310: invokevirtual 183	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   313: checkcast 193	com/tencent/mm/protocal/protobuf/dgv
        //   316: astore 8
        //   318: aload 8
        //   320: ifnull +421 -> 741
        //   323: aload 6
        //   325: astore_3
        //   326: iload_2
        //   327: istore_1
        //   328: aload 8
        //   330: getfield 196	com/tencent/mm/protocal/protobuf/dgv:lpy	Ljava/lang/String;
        //   333: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   336: ifne +405 -> 741
        //   339: aload 6
        //   341: astore_3
        //   342: iload_2
        //   343: istore_1
        //   344: aload 8
        //   346: getfield 196	com/tencent/mm/protocal/protobuf/dgv:lpy	Ljava/lang/String;
        //   349: astore 4
        //   351: aload 4
        //   353: astore_3
        //   354: iload_2
        //   355: istore_1
        //   356: aload 8
        //   358: getfield 205	com/tencent/mm/protocal/protobuf/dgv:fwr	Ljava/lang/String;
        //   361: ldc 80
        //   363: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   366: astore 6
        //   368: aload 6
        //   370: astore_3
        //   371: aload_3
        //   372: astore 6
        //   374: aload 4
        //   376: astore_3
        //   377: aload 6
        //   379: astore 4
        //   381: goto -234 -> 147
        //   384: astore 4
        //   386: ldc 211
        //   388: ldc 213
        //   390: iconst_1
        //   391: anewarray 4	java/lang/Object
        //   394: dup
        //   395: iconst_0
        //   396: aload 4
        //   398: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   401: aastore
        //   402: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   405: aload 7
        //   407: astore 4
        //   409: iload_1
        //   410: istore_2
        //   411: goto -264 -> 147
        //   414: aload 4
        //   416: invokevirtual 59	com/tencent/mm/an/q:getType	()I
        //   419: sipush 806
        //   422: if_icmpne +312 -> 734
        //   425: aload 4
        //   427: invokevirtual 84	com/tencent/mm/an/q:getReqResp	()Lcom/tencent/mm/network/s;
        //   430: checkcast 86	com/tencent/mm/an/d
        //   433: getfield 90	com/tencent/mm/an/d:lBS	Lcom/tencent/mm/an/d$c;
        //   436: invokestatic 95	com/tencent/mm/an/d$c:b	(Lcom/tencent/mm/an/d$c;)Lcom/tencent/mm/cd/a;
        //   439: checkcast 97	com/tencent/mm/protocal/protobuf/dfv
        //   442: astore 4
        //   444: aload 4
        //   446: ifnull +288 -> 734
        //   449: aload 4
        //   451: invokevirtual 101	com/tencent/mm/protocal/protobuf/dfv:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/jh;
        //   454: ifnull +280 -> 734
        //   457: aload 4
        //   459: invokevirtual 101	com/tencent/mm/protocal/protobuf/dfv:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/jh;
        //   462: getfield 227	com/tencent/mm/protocal/protobuf/jh:Tef	Lcom/tencent/mm/protocal/protobuf/eaf;
        //   465: invokestatic 232	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/eaf;)Ljava/lang/String;
        //   468: astore 4
        //   470: aload 4
        //   472: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   475: istore 5
        //   477: iload 5
        //   479: ifeq +249 -> 728
        //   482: aload 7
        //   484: astore 4
        //   486: goto -339 -> 147
        //   489: astore 4
        //   491: aload 6
        //   493: astore_3
        //   494: ldc 211
        //   496: ldc 213
        //   498: iconst_1
        //   499: anewarray 4	java/lang/Object
        //   502: dup
        //   503: iconst_0
        //   504: aload 4
        //   506: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   509: aastore
        //   510: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   513: aload 7
        //   515: astore 4
        //   517: goto -370 -> 147
        //   520: iload_2
        //   521: ifne +94 -> 615
        //   524: aload_0
        //   525: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   528: getfield 235	com/tencent/mm/contact/a/a/b:jxw	Ljava/util/List;
        //   531: invokeinterface 121 1 0
        //   536: astore 6
        //   538: aload 6
        //   540: invokeinterface 126 1 0
        //   545: ifeq +64 -> 609
        //   548: aload 6
        //   550: invokeinterface 130 1 0
        //   555: checkcast 132	com/tencent/mm/model/t
        //   558: astore 7
        //   560: aload 7
        //   562: instanceof 134
        //   565: ifeq +29 -> 594
        //   568: aload 7
        //   570: checkcast 134	com/tencent/mm/contact/a/b
        //   573: astore 8
        //   575: aload 8
        //   577: iload_2
        //   578: putfield 137	com/tencent/mm/contact/a/b:ret	I
        //   581: aload 8
        //   583: aload 4
        //   585: putfield 141	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   588: aload 8
        //   590: aload_3
        //   591: putfield 144	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   594: aload 7
        //   596: iload_2
        //   597: ldc 80
        //   599: aload 7
        //   601: invokeinterface 148 4 0
        //   606: goto -68 -> 538
        //   609: ldc 23
        //   611: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   614: return
        //   615: aload_0
        //   616: getfield 14	com/tencent/mm/contact/a/a/b$1:jxC	Lcom/tencent/mm/contact/a/a/b;
        //   619: getfield 241	com/tencent/mm/contact/a/a/b:jxx	Ljava/util/List;
        //   622: invokeinterface 121 1 0
        //   627: astore 6
        //   629: aload 6
        //   631: invokeinterface 126 1 0
        //   636: ifeq +64 -> 700
        //   639: aload 6
        //   641: invokeinterface 130 1 0
        //   646: checkcast 132	com/tencent/mm/model/t
        //   649: astore 7
        //   651: aload 7
        //   653: instanceof 134
        //   656: ifeq +29 -> 685
        //   659: aload 7
        //   661: checkcast 134	com/tencent/mm/contact/a/b
        //   664: astore 8
        //   666: aload 8
        //   668: iload_2
        //   669: putfield 137	com/tencent/mm/contact/a/b:ret	I
        //   672: aload 8
        //   674: aload 4
        //   676: putfield 141	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   679: aload 8
        //   681: aload_3
        //   682: putfield 144	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   685: aload 7
        //   687: iload_2
        //   688: ldc 80
        //   690: aload 7
        //   692: invokeinterface 148 4 0
        //   697: goto -68 -> 629
        //   700: ldc 23
        //   702: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   705: return
        //   706: astore 6
        //   708: aload 4
        //   710: astore_3
        //   711: aload 6
        //   713: astore 4
        //   715: goto -221 -> 494
        //   718: astore 4
        //   720: iconst_0
        //   721: istore_1
        //   722: aload 6
        //   724: astore_3
        //   725: goto -339 -> 386
        //   728: aload 4
        //   730: astore_3
        //   731: goto -249 -> 482
        //   734: ldc 80
        //   736: astore 4
        //   738: goto -268 -> 470
        //   741: ldc 80
        //   743: astore 4
        //   745: ldc 80
        //   747: astore_3
        //   748: goto -377 -> 371
        //   751: iconst_0
        //   752: istore_1
        //   753: goto -615 -> 138
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	756	0	this	1
        //   0	756	1	paramAnonymousInt1	int
        //   0	756	2	paramAnonymousInt2	int
        //   0	756	3	paramAnonymousString	String
        //   0	756	4	paramAnonymousq	q
        //   475	3	5	bool	boolean
        //   71	569	6	localObject1	Object
        //   706	17	6	localException	java.lang.Exception
        //   67	624	7	localObject2	Object
        //   211	469	8	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   86	97	384	java/lang/Exception
        //   102	121	384	java/lang/Exception
        //   252	274	384	java/lang/Exception
        //   279	297	384	java/lang/Exception
        //   302	318	384	java/lang/Exception
        //   328	339	384	java/lang/Exception
        //   344	351	384	java/lang/Exception
        //   356	368	384	java/lang/Exception
        //   414	444	489	java/lang/Exception
        //   449	470	489	java/lang/Exception
        //   470	477	706	java/lang/Exception
        //   121	138	718	java/lang/Exception
      }
    };
    this.jxz = paramBoolean;
    AppMethodBeat.o(188746);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(188748);
    if (this.jxz)
    {
      this.jxA = new l(paramb);
      AppMethodBeat.o(188748);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.jxA = new com.tencent.mm.bd.c(localLinkedList);
    AppMethodBeat.o(188748);
  }
  
  public final void i(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188750);
    if (this.jxA == null)
    {
      AppMethodBeat.o(188750);
      return;
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, false, null);
    if (this.jxA != null)
    {
      Log.i("MicroMsg.ContactSyncOpLogCallbackFactory", "request scene %s", new Object[] { this.jxA });
      if ((this.tipDialog != null) || (!this.jxw.isEmpty()) || (!this.jxx.isEmpty()) || (!this.jxy.isEmpty()))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(this.jxA.getType(), this.jxB);
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(this.jxA, 0);
    }
    AppMethodBeat.o(188750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.b
 * JD-Core Version:    0.7.0.1
 */