package com.tencent.mm.contact.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  n ghA;
  f ghB;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(221711);
    this.ghB = new f()
    {
      /* Error */
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   9: getfield 33	com/tencent/mm/contact/a/a/b:ghA	Lcom/tencent/mm/ak/n;
        //   12: aload 4
        //   14: invokevirtual 37	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   17: ifeq +683 -> 700
        //   20: invokestatic 43	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
        //   23: pop
        //   24: invokestatic 47	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
        //   27: getfield 53	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
        //   30: aload 4
        //   32: invokevirtual 59	com/tencent/mm/ak/n:getType	()I
        //   35: aload_0
        //   36: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   39: getfield 63	com/tencent/mm/contact/a/a/b:ghB	Lcom/tencent/mm/ak/f;
        //   42: invokevirtual 69	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
        //   45: aload_0
        //   46: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   49: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/p;
        //   52: ifnull +13 -> 65
        //   55: aload_0
        //   56: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   59: getfield 73	com/tencent/mm/contact/a/a/b:tipDialog	Lcom/tencent/mm/ui/base/p;
        //   62: invokevirtual 78	com/tencent/mm/ui/base/p:dismiss	()V
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
        //   88: invokevirtual 59	com/tencent/mm/ak/n:getType	()I
        //   91: sipush 806
        //   94: if_icmpne +153 -> 247
        //   97: aload 6
        //   99: astore_3
        //   100: iload_2
        //   101: istore_1
        //   102: aload 4
        //   104: invokevirtual 84	com/tencent/mm/ak/n:getReqResp	()Lcom/tencent/mm/network/q;
        //   107: checkcast 86	com/tencent/mm/ak/b
        //   110: getfield 90	com/tencent/mm/ak/b:hQE	Lcom/tencent/mm/ak/b$c;
        //   113: getfield 96	com/tencent/mm/ak/b$c:hQJ	Lcom/tencent/mm/bw/a;
        //   116: checkcast 98	com/tencent/mm/protocal/protobuf/cge
        //   119: astore 4
        //   121: aload 4
        //   123: invokevirtual 102	com/tencent/mm/protocal/protobuf/cge:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/BaseResponse;
        //   126: ifnull +625 -> 751
        //   129: aload 4
        //   131: invokevirtual 102	com/tencent/mm/protocal/protobuf/cge:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/BaseResponse;
        //   134: getfield 108	com/tencent/mm/protocal/protobuf/BaseResponse:Ret	I
        //   137: istore_1
        //   138: iload_1
        //   139: istore_2
        //   140: aload 7
        //   142: astore 4
        //   144: aload 6
        //   146: astore_3
        //   147: aload_0
        //   148: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   151: getfield 112	com/tencent/mm/contact/a/a/b:ghy	Ljava/util/List;
        //   154: invokeinterface 118 1 0
        //   159: ifne +361 -> 520
        //   162: aload_0
        //   163: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   166: getfield 112	com/tencent/mm/contact/a/a/b:ghy	Ljava/util/List;
        //   169: invokeinterface 122 1 0
        //   174: astore 6
        //   176: aload 6
        //   178: invokeinterface 127 1 0
        //   183: ifeq +337 -> 520
        //   186: aload 6
        //   188: invokeinterface 131 1 0
        //   193: checkcast 133	com/tencent/mm/model/p
        //   196: astore 7
        //   198: aload 7
        //   200: instanceof 135
        //   203: ifeq +29 -> 232
        //   206: aload 7
        //   208: checkcast 135	com/tencent/mm/contact/a/b
        //   211: astore 8
        //   213: aload 8
        //   215: iload_2
        //   216: putfield 138	com/tencent/mm/contact/a/b:ret	I
        //   219: aload 8
        //   221: aload 4
        //   223: putfield 142	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   226: aload 8
        //   228: aload_3
        //   229: putfield 145	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   232: aload 7
        //   234: iload_2
        //   235: ldc 80
        //   237: aload 7
        //   239: invokeinterface 149 4 0
        //   244: goto -68 -> 176
        //   247: aload 6
        //   249: astore_3
        //   250: iload_2
        //   251: istore_1
        //   252: aload 4
        //   254: checkcast 151	com/tencent/mm/ba/b
        //   257: getfield 155	com/tencent/mm/ba/b:ilc	Lcom/tencent/mm/ba/b$a;
        //   260: invokevirtual 161	com/tencent/mm/ba/b$a:getRespObj	()Lcom/tencent/mm/protocal/l$e;
        //   263: checkcast 163	com/tencent/mm/ba/b$c
        //   266: checkcast 163	com/tencent/mm/ba/b$c
        //   269: getfield 167	com/tencent/mm/ba/b$c:ilh	Lcom/tencent/mm/protocal/protobuf/chg;
        //   272: astore 4
        //   274: aload 6
        //   276: astore_3
        //   277: iload_2
        //   278: istore_1
        //   279: aload 4
        //   281: getfield 173	com/tencent/mm/protocal/protobuf/chg:Htc	Lcom/tencent/mm/protocal/protobuf/chh;
        //   284: getfield 179	com/tencent/mm/protocal/protobuf/chh:GNm	Ljava/util/LinkedList;
        //   287: invokevirtual 184	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   290: checkcast 186	java/lang/Integer
        //   293: invokevirtual 189	java/lang/Integer:intValue	()I
        //   296: istore_2
        //   297: aload 6
        //   299: astore_3
        //   300: iload_2
        //   301: istore_1
        //   302: aload 4
        //   304: getfield 173	com/tencent/mm/protocal/protobuf/chg:Htc	Lcom/tencent/mm/protocal/protobuf/chh;
        //   307: getfield 192	com/tencent/mm/protocal/protobuf/chh:Htd	Ljava/util/LinkedList;
        //   310: invokevirtual 184	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   313: checkcast 194	com/tencent/mm/protocal/protobuf/che
        //   316: astore 8
        //   318: aload 8
        //   320: ifnull +421 -> 741
        //   323: aload 6
        //   325: astore_3
        //   326: iload_2
        //   327: istore_1
        //   328: aload 8
        //   330: getfield 197	com/tencent/mm/protocal/protobuf/che:hFS	Ljava/lang/String;
        //   333: invokestatic 203	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   336: ifne +405 -> 741
        //   339: aload 6
        //   341: astore_3
        //   342: iload_2
        //   343: istore_1
        //   344: aload 8
        //   346: getfield 197	com/tencent/mm/protocal/protobuf/che:hFS	Ljava/lang/String;
        //   349: astore 4
        //   351: aload 4
        //   353: astore_3
        //   354: iload_2
        //   355: istore_1
        //   356: aload 8
        //   358: getfield 206	com/tencent/mm/protocal/protobuf/che:Title	Ljava/lang/String;
        //   361: ldc 80
        //   363: invokestatic 210	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
        //   386: ldc 212
        //   388: ldc 214
        //   390: iconst_1
        //   391: anewarray 4	java/lang/Object
        //   394: dup
        //   395: iconst_0
        //   396: aload 4
        //   398: invokevirtual 218	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   401: aastore
        //   402: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   405: aload 7
        //   407: astore 4
        //   409: iload_1
        //   410: istore_2
        //   411: goto -264 -> 147
        //   414: aload 4
        //   416: invokevirtual 59	com/tencent/mm/ak/n:getType	()I
        //   419: sipush 806
        //   422: if_icmpne +312 -> 734
        //   425: aload 4
        //   427: invokevirtual 84	com/tencent/mm/ak/n:getReqResp	()Lcom/tencent/mm/network/q;
        //   430: checkcast 86	com/tencent/mm/ak/b
        //   433: getfield 90	com/tencent/mm/ak/b:hQE	Lcom/tencent/mm/ak/b$c;
        //   436: getfield 96	com/tencent/mm/ak/b$c:hQJ	Lcom/tencent/mm/bw/a;
        //   439: checkcast 98	com/tencent/mm/protocal/protobuf/cge
        //   442: astore 4
        //   444: aload 4
        //   446: ifnull +288 -> 734
        //   449: aload 4
        //   451: invokevirtual 102	com/tencent/mm/protocal/protobuf/cge:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/BaseResponse;
        //   454: ifnull +280 -> 734
        //   457: aload 4
        //   459: invokevirtual 102	com/tencent/mm/protocal/protobuf/cge:getBaseResponse	()Lcom/tencent/mm/protocal/protobuf/BaseResponse;
        //   462: getfield 228	com/tencent/mm/protocal/protobuf/BaseResponse:ErrMsg	Lcom/tencent/mm/protocal/protobuf/cxn;
        //   465: invokestatic 233	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/cxn;)Ljava/lang/String;
        //   468: astore 4
        //   470: aload 4
        //   472: invokestatic 203	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   475: istore 5
        //   477: iload 5
        //   479: ifeq +249 -> 728
        //   482: aload 7
        //   484: astore 4
        //   486: goto -339 -> 147
        //   489: astore 4
        //   491: aload 6
        //   493: astore_3
        //   494: ldc 212
        //   496: ldc 214
        //   498: iconst_1
        //   499: anewarray 4	java/lang/Object
        //   502: dup
        //   503: iconst_0
        //   504: aload 4
        //   506: invokevirtual 218	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   509: aastore
        //   510: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   513: aload 7
        //   515: astore 4
        //   517: goto -370 -> 147
        //   520: iload_2
        //   521: ifne +94 -> 615
        //   524: aload_0
        //   525: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   528: getfield 236	com/tencent/mm/contact/a/a/b:ghw	Ljava/util/List;
        //   531: invokeinterface 122 1 0
        //   536: astore 6
        //   538: aload 6
        //   540: invokeinterface 127 1 0
        //   545: ifeq +64 -> 609
        //   548: aload 6
        //   550: invokeinterface 131 1 0
        //   555: checkcast 133	com/tencent/mm/model/p
        //   558: astore 7
        //   560: aload 7
        //   562: instanceof 135
        //   565: ifeq +29 -> 594
        //   568: aload 7
        //   570: checkcast 135	com/tencent/mm/contact/a/b
        //   573: astore 8
        //   575: aload 8
        //   577: iload_2
        //   578: putfield 138	com/tencent/mm/contact/a/b:ret	I
        //   581: aload 8
        //   583: aload 4
        //   585: putfield 142	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   588: aload 8
        //   590: aload_3
        //   591: putfield 145	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   594: aload 7
        //   596: iload_2
        //   597: ldc 80
        //   599: aload 7
        //   601: invokeinterface 149 4 0
        //   606: goto -68 -> 538
        //   609: ldc 23
        //   611: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   614: return
        //   615: aload_0
        //   616: getfield 14	com/tencent/mm/contact/a/a/b$1:ghC	Lcom/tencent/mm/contact/a/a/b;
        //   619: getfield 242	com/tencent/mm/contact/a/a/b:ghx	Ljava/util/List;
        //   622: invokeinterface 122 1 0
        //   627: astore 6
        //   629: aload 6
        //   631: invokeinterface 127 1 0
        //   636: ifeq +64 -> 700
        //   639: aload 6
        //   641: invokeinterface 131 1 0
        //   646: checkcast 133	com/tencent/mm/model/p
        //   649: astore 7
        //   651: aload 7
        //   653: instanceof 135
        //   656: ifeq +29 -> 685
        //   659: aload 7
        //   661: checkcast 135	com/tencent/mm/contact/a/b
        //   664: astore 8
        //   666: aload 8
        //   668: iload_2
        //   669: putfield 138	com/tencent/mm/contact/a/b:ret	I
        //   672: aload 8
        //   674: aload 4
        //   676: putfield 142	com/tencent/mm/contact/a/b:title	Ljava/lang/String;
        //   679: aload 8
        //   681: aload_3
        //   682: putfield 145	com/tencent/mm/contact/a/b:content	Ljava/lang/String;
        //   685: aload 7
        //   687: iload_2
        //   688: ldc 80
        //   690: aload 7
        //   692: invokeinterface 149 4 0
        //   697: goto -68 -> 629
        //   700: ldc 23
        //   702: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        //   0	756	4	paramAnonymousn	n
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
    this.ghz = paramBoolean;
    AppMethodBeat.o(221711);
  }
  
  public final void E(Context paramContext, String paramString)
  {
    AppMethodBeat.i(221713);
    if (this.ghA == null)
    {
      AppMethodBeat.o(221713);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, false, null);
    if (this.ghA != null)
    {
      ae.i("MicroMsg.ContactSyncOpLogCallbackFactory", "request scene %s", new Object[] { this.ghA });
      if ((this.tipDialog != null) || (!this.ghw.isEmpty()) || (!this.ghx.isEmpty()) || (!this.ghy.isEmpty()))
      {
        g.ajS();
        g.ajQ().gDv.a(this.ghA.getType(), this.ghB);
      }
      g.ajS();
      g.ajQ().gDv.a(this.ghA, 0);
    }
    AppMethodBeat.o(221713);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(221712);
    if (this.ghz)
    {
      this.ghA = new l(paramb);
      AppMethodBeat.o(221712);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.ghA = new c(localLinkedList);
    AppMethodBeat.o(221712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.b
 * JD-Core Version:    0.7.0.1
 */