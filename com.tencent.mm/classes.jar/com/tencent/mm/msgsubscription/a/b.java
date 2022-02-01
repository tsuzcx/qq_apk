package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.msgsubscription.util.a.c.a;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.dlu;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "isOpened", "", "(Ljava/lang/String;IZ)V", "(Ljava/lang/String;I)V", "getActionType", "()I", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b
  extends a
  implements a.b
{
  public static final b iDO;
  private final int actionType;
  private boolean iCY;
  private final List<dlp> iDI;
  private a.c iDJ;
  public c iDK;
  private String iDL;
  private SubscribeMsgRequestDialogUiData iDM;
  private byte[] iDN;
  public final String username;
  
  static
  {
    AppMethodBeat.i(149573);
    iDO = new b((byte)0);
    AppMethodBeat.o(149573);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149571);
    this.username = paramString;
    this.actionType = paramInt;
    this.iDI = ((List)new ArrayList());
    this.iDL = "";
    this.iDN = new byte[0];
    AppMethodBeat.o(149571);
  }
  
  public b(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt);
    AppMethodBeat.i(149572);
    this.iCY = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    p.h(parama, "dispatcher");
    Object localObject1 = a.c.iGQ;
    this.iDJ = a.c.a.a((cvw)new dlq(), (cwj)new dlr(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.iDJ;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = ((a.c)localObject1).aOV();
    if (localObject1 == null)
    {
      parama = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
      AppMethodBeat.o(174564);
      throw parama;
    }
    localObject1 = (dlq)localObject1;
    switch (this.actionType)
    {
    case 4: 
    default: 
      localObject1 = this.iDJ;
      if (localObject1 == null) {
        p.gkB();
      }
      i = parama.a((a.c)localObject1, (a.b)this, (a)this);
      AppMethodBeat.o(174564);
      return i;
    case 2: 
    case 3: 
    case 5: 
      ((dlq)localObject1).FZa = this.username;
      ((dlq)localObject1).GbY = this.actionType;
      ((dlq)localObject1).usl.addAll((Collection)this.iDI);
      if (((CharSequence)this.iDL).length() > 0) {}
      while (i != 0)
      {
        ((dlq)localObject1).HTc = this.iDL;
        break;
        i = 0;
      }
    }
    ((dlq)localObject1).FZa = this.username;
    ((dlq)localObject1).GbY = this.actionType;
    ((dlq)localObject1).FZk = 1;
    if (this.iCY) {}
    for (i = 1;; i = 0)
    {
      ((dlq)localObject1).HSW = i;
      ((dlq)localObject1).usl.addAll((Collection)this.iDI);
      if (this.actionType != 6) {
        break;
      }
      ((dlq)localObject1).Buffer = new com.tencent.mm.bw.b(this.iDN);
      ((dlq)localObject1).HTd = new clv();
      Object localObject2 = this.iDM;
      if (localObject2 == null) {
        break;
      }
      ((dlq)localObject1).HTd.HxQ = ((SubscribeMsgRequestDialogUiData)localObject2).iCF;
      ((dlq)localObject1).HTd.gvx = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
      localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).iCG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
        LinkedList localLinkedList = ((dlq)localObject1).HTd.HxR;
        dlt localdlt = new dlt();
        localdlt.Hkk = localItemUiData.hDH;
        localdlt.HSU = localItemUiData.iCO;
        localLinkedList.add(localdlt);
      }
      break;
    }
  }
  
  public final void af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    p.h(paramArrayOfByte, "<set-?>");
    this.iDN = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    Object localObject2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.iDK;
      if (localObject2 != null)
      {
        localObject1 = paramString;
        if (paramString == null) {
          localObject1 = "";
        }
        ((c)localObject2).a(paramInt1, paramInt2, (String)localObject1, null);
        AppMethodBeat.o(174565);
        return;
      }
      AppMethodBeat.o(174565);
      return;
    }
    Object localObject1 = this.iDJ;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = ((a.c)localObject1).aOW();
    if (localObject1 == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
      AppMethodBeat.o(174565);
      throw paramString;
    }
    dlr localdlr = (dlr)localObject1;
    c localc = this.iDK;
    ArrayList localArrayList;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    boolean bool1;
    if (localc != null)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = SubscribeMsgRequestResult.iDh;
      p.h(localdlr, "response");
      localArrayList = new ArrayList();
      paramString = localdlr.uqO;
      p.g(paramString, "response.InfoList");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (dlp)paramString.next();
        localObject3 = new ArrayList();
        localObject4 = ((dlp)localObject2).GeR;
        p.g(localObject4, "it.KeyWordList");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bto)((Iterator)localObject4).next();
          ((ArrayList)localObject3).add(new o(((bto)localObject5).Name, ((bto)localObject5).yxn));
        }
        p.g(localObject2, "it");
        localArrayList.add(new SubscribeMsgTmpItem((dlp)localObject2, (ArrayList)localObject3));
      }
      if (localdlr.HTi == 1)
      {
        bool1 = true;
        paramString = localdlr.HTg;
        if (paramString != null) {
          break label1081;
        }
        paramString = "";
      }
    }
    label769:
    label781:
    label800:
    label1057:
    label1065:
    label1081:
    for (;;)
    {
      localObject2 = localdlr.HTf;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        int j = localdlr.HTj;
        boolean bool2;
        label374:
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        boolean bool3;
        boolean bool4;
        int k;
        if (localdlr.HTh == 1)
        {
          bool2 = true;
          localObject3 = localdlr.HTe;
          if (localObject3 != null)
          {
            localObject4 = ((dlu)localObject3).iDr;
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = "";
          }
          localObject4 = localdlr.HTe;
          if (localObject4 != null)
          {
            localObject5 = ((dlu)localObject4).iDs;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localdlr.HTe;
          if (localObject5 != null)
          {
            localObject6 = ((dlu)localObject5).iDt;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject6 = localdlr.HTe;
          if (localObject6 != null)
          {
            localObject7 = ((dlu)localObject6).iDu;
            localObject6 = localObject7;
            if (localObject7 != null) {}
          }
          else
          {
            localObject6 = "";
          }
          localObject7 = localdlr.HTe;
          if (localObject7 != null)
          {
            localObject8 = ((dlu)localObject7).iDv;
            localObject7 = localObject8;
            if (localObject8 != null) {}
          }
          else
          {
            localObject7 = "";
          }
          localObject8 = localdlr.HTe;
          if (localObject8 != null)
          {
            localObject9 = ((dlu)localObject8).iDw;
            localObject8 = localObject9;
            if (localObject9 != null) {}
          }
          else
          {
            localObject8 = "";
          }
          localObject9 = localdlr.HTe;
          if (localObject9 != null)
          {
            localObject10 = ((dlu)localObject9).iDx;
            localObject9 = localObject10;
            if (localObject10 != null) {}
          }
          else
          {
            localObject9 = "";
          }
          Object localObject10 = localdlr.HTe;
          if (localObject10 != null)
          {
            localObject11 = ((dlu)localObject10).iDy;
            localObject10 = localObject11;
            if (localObject11 != null) {}
          }
          else
          {
            localObject10 = "";
          }
          Object localObject11 = localdlr.HTe;
          if (localObject11 != null)
          {
            localObject12 = ((dlu)localObject11).iDz;
            localObject11 = localObject12;
            if (localObject12 != null) {}
          }
          else
          {
            localObject11 = "";
          }
          Object localObject12 = localdlr.HTe;
          if (localObject12 != null)
          {
            localObject13 = ((dlu)localObject12).iDA;
            localObject12 = localObject13;
            if (localObject13 != null) {}
          }
          else
          {
            localObject12 = "";
          }
          Object localObject13 = localdlr.HTe;
          if (localObject13 != null)
          {
            String str = ((dlu)localObject13).iDB;
            localObject13 = str;
            if (str != null) {}
          }
          else
          {
            localObject13 = "";
          }
          localObject8 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
          if (localdlr.HSW != 1) {
            break label1045;
          }
          bool3 = true;
          if (localdlr.HTn != 1) {
            break label1051;
          }
          bool4 = true;
          localObject3 = localdlr.Buffer;
          if (localObject3 == null) {
            break label1057;
          }
          localObject3 = ((com.tencent.mm.bw.b)localObject3).toByteArray();
          k = localdlr.HTt;
          localObject4 = localdlr.HTu;
          if (localObject4 == null) {
            break label1065;
          }
        }
        for (int i = ((dls)localObject4).HhE;; i = -1)
        {
          localObject4 = localdlr.HTu;
          if (localObject4 != null)
          {
            localObject5 = ((dls)localObject4).GYJ;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localdlr.HTu;
          if (localObject5 != null)
          {
            localObject6 = ((dls)localObject5).HTv;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject9 = new ShowInfo(i, (String)localObject4, (String)localObject5);
          localObject5 = localdlr.HTr;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localObject6 = localdlr.HTs;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          i = localdlr.HTo;
          localObject7 = localdlr.HTp;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          localc.a(paramInt1, paramInt2, (String)localObject1, new SubscribeMsgRequestResult(bool1, paramString, (String)localObject2, j, localArrayList, bool2, (WordingInfo)localObject8, bool3, bool4, (byte[])localObject3, k, (ShowInfo)localObject9, (String)localObject4, (String)localObject5, i, (String)localObject6, localdlr.HTq));
          AppMethodBeat.o(174565);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label374;
          bool3 = false;
          break label769;
          bool4 = false;
          break label781;
          localObject3 = new byte[0];
          break label800;
        }
        AppMethodBeat.o(174565);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static final a iDP;
    
    static
    {
      AppMethodBeat.i(149566);
      iDP = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatusByUrlReq", "subscribeUrl", "buildGetSubscribeStatusReq", "templateIds", "", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      public static b a(String paramString, b.c paramc)
      {
        AppMethodBeat.i(149564);
        p.h(paramString, "username");
        paramString = new b(paramString, 3);
        b.a(paramString, paramc);
        AppMethodBeat.o(149564);
        return paramString;
      }
      
      public static b a(String paramString, List<SubscribeMsgTmpItem> paramList, b.c paramc, boolean paramBoolean)
      {
        AppMethodBeat.i(149561);
        p.h(paramString, "username");
        p.h(paramList, "templates");
        paramString = a(paramString, paramBoolean, paramc, paramList, 1, new byte[0], null);
        AppMethodBeat.o(149561);
        return paramString;
      }
      
      public static b a(String paramString, List<SubscribeMsgTmpItem> paramList, b.c paramc, boolean paramBoolean, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(149562);
        p.h(paramString, "username");
        p.h(paramList, "templates");
        p.h(paramArrayOfByte, "byteArray");
        paramString = a(paramString, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData);
        AppMethodBeat.o(149562);
        return paramString;
      }
      
      private static b a(String paramString, boolean paramBoolean, b.c paramc, List<SubscribeMsgTmpItem> paramList, int paramInt, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(149565);
        paramString = new b(paramString, paramInt, paramBoolean);
        b.a(paramString, paramc);
        paramString.af(paramArrayOfByte);
        b.a(paramString, paramSubscribeMsgRequestDialogUiData);
        paramc = paramList.iterator();
        if (paramc.hasNext())
        {
          paramList = (SubscribeMsgTmpItem)paramc.next();
          paramArrayOfByte = b.a(paramString);
          paramSubscribeMsgRequestDialogUiData = new dlp();
          paramSubscribeMsgRequestDialogUiData.Hkk = paramList.hDH;
          paramSubscribeMsgRequestDialogUiData.HSR = paramList.iDj;
          paramSubscribeMsgRequestDialogUiData.HSV = paramList.iDl;
          if (paramList.Vp) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramSubscribeMsgRequestDialogUiData.HSW = paramInt;
            paramArrayOfByte.add(paramSubscribeMsgRequestDialogUiData);
            break;
          }
        }
        AppMethodBeat.o(149565);
        return paramString;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Companion;", "", "()V", "ACTION_GET_ALL_SUBSCRIBE_STATUS", "", "ACTION_GET_SUBSCRIBE_STATUS", "ACTION_GET_UI_STATUS", "ACTION_SUBSCRIBE", "ACTION_SUBSCRIBE_FOR_DIALOG_REQUEST", "FUNC_FLAG_SET_IS_OPEN", "TAG", "", "URI", "ACTION", "wxbiz-msgsubscription-sdk_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */