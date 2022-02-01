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
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dkz;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "isOpened", "", "(Ljava/lang/String;IZ)V", "(Ljava/lang/String;I)V", "getActionType", "()I", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b
  extends a
  implements a.b
{
  public static final b iAV;
  private final int actionType;
  private final List<dku> iAP;
  private a.c iAQ;
  public c iAR;
  private String iAS;
  private SubscribeMsgRequestDialogUiData iAT;
  private byte[] iAU;
  private boolean iAf;
  public final String username;
  
  static
  {
    AppMethodBeat.i(149573);
    iAV = new b((byte)0);
    AppMethodBeat.o(149573);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149571);
    this.username = paramString;
    this.actionType = paramInt;
    this.iAP = ((List)new ArrayList());
    this.iAS = "";
    this.iAU = new byte[0];
    AppMethodBeat.o(149571);
  }
  
  public b(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt);
    AppMethodBeat.i(149572);
    this.iAf = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    p.h(parama, "dispatcher");
    Object localObject1 = a.c.iDX;
    this.iAQ = a.c.a.a((cvc)new dkv(), (cvp)new dkw(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.iAQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = ((a.c)localObject1).aOy();
    if (localObject1 == null)
    {
      parama = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
      AppMethodBeat.o(174564);
      throw parama;
    }
    localObject1 = (dkv)localObject1;
    switch (this.actionType)
    {
    case 4: 
    default: 
      localObject1 = this.iAQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      i = parama.a((a.c)localObject1, (a.b)this, (a)this);
      AppMethodBeat.o(174564);
      return i;
    case 2: 
    case 3: 
    case 5: 
      ((dkv)localObject1).FGE = this.username;
      ((dkv)localObject1).FJz = this.actionType;
      ((dkv)localObject1).ugO.addAll((Collection)this.iAP);
      if (((CharSequence)this.iAS).length() > 0) {}
      while (i != 0)
      {
        ((dkv)localObject1).Hzr = this.iAS;
        break;
        i = 0;
      }
    }
    ((dkv)localObject1).FGE = this.username;
    ((dkv)localObject1).FJz = this.actionType;
    ((dkv)localObject1).FGO = 1;
    if (this.iAf) {}
    for (i = 1;; i = 0)
    {
      ((dkv)localObject1).Hzl = i;
      ((dkv)localObject1).ugO.addAll((Collection)this.iAP);
      if (this.actionType != 6) {
        break;
      }
      ((dkv)localObject1).Buffer = new com.tencent.mm.bx.b(this.iAU);
      ((dkv)localObject1).Hzs = new clb();
      Object localObject2 = this.iAT;
      if (localObject2 == null) {
        break;
      }
      ((dkv)localObject1).Hzs.Heq = ((SubscribeMsgRequestDialogUiData)localObject2).izM;
      ((dkv)localObject1).Hzs.gsV = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
      localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).izN.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
        LinkedList localLinkedList = ((dkv)localObject1).Hzs.Her;
        dky localdky = new dky();
        localdky.GQJ = localItemUiData.hAT;
        localdky.Hzj = localItemUiData.izV;
        localLinkedList.add(localdky);
      }
      break;
    }
  }
  
  public final void af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    p.h(paramArrayOfByte, "<set-?>");
    this.iAU = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    Object localObject2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.iAR;
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
    Object localObject1 = this.iAQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = ((a.c)localObject1).aOz();
    if (localObject1 == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
      AppMethodBeat.o(174565);
      throw paramString;
    }
    dkw localdkw = (dkw)localObject1;
    c localc = this.iAR;
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
      paramString = SubscribeMsgRequestResult.iAo;
      p.h(localdkw, "response");
      localArrayList = new ArrayList();
      paramString = localdkw.ufw;
      p.g(paramString, "response.InfoList");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (dku)paramString.next();
        localObject3 = new ArrayList();
        localObject4 = ((dku)localObject2).FMs;
        p.g(localObject4, "it.KeyWordList");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bsu)((Iterator)localObject4).next();
          ((ArrayList)localObject3).add(new o(((bsu)localObject5).Name, ((bsu)localObject5).yhw));
        }
        p.g(localObject2, "it");
        localArrayList.add(new SubscribeMsgTmpItem((dku)localObject2, (ArrayList)localObject3));
      }
      if (localdkw.Hzx == 1)
      {
        bool1 = true;
        paramString = localdkw.Hzv;
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
      localObject2 = localdkw.Hzu;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        int j = localdkw.Hzy;
        boolean bool2;
        label374:
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        boolean bool3;
        boolean bool4;
        int k;
        if (localdkw.Hzw == 1)
        {
          bool2 = true;
          localObject3 = localdkw.Hzt;
          if (localObject3 != null)
          {
            localObject4 = ((dkz)localObject3).iAy;
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = "";
          }
          localObject4 = localdkw.Hzt;
          if (localObject4 != null)
          {
            localObject5 = ((dkz)localObject4).iAz;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localdkw.Hzt;
          if (localObject5 != null)
          {
            localObject6 = ((dkz)localObject5).iAA;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject6 = localdkw.Hzt;
          if (localObject6 != null)
          {
            localObject7 = ((dkz)localObject6).iAB;
            localObject6 = localObject7;
            if (localObject7 != null) {}
          }
          else
          {
            localObject6 = "";
          }
          localObject7 = localdkw.Hzt;
          if (localObject7 != null)
          {
            localObject8 = ((dkz)localObject7).iAC;
            localObject7 = localObject8;
            if (localObject8 != null) {}
          }
          else
          {
            localObject7 = "";
          }
          localObject8 = localdkw.Hzt;
          if (localObject8 != null)
          {
            localObject9 = ((dkz)localObject8).iAD;
            localObject8 = localObject9;
            if (localObject9 != null) {}
          }
          else
          {
            localObject8 = "";
          }
          localObject9 = localdkw.Hzt;
          if (localObject9 != null)
          {
            localObject10 = ((dkz)localObject9).iAE;
            localObject9 = localObject10;
            if (localObject10 != null) {}
          }
          else
          {
            localObject9 = "";
          }
          Object localObject10 = localdkw.Hzt;
          if (localObject10 != null)
          {
            localObject11 = ((dkz)localObject10).iAF;
            localObject10 = localObject11;
            if (localObject11 != null) {}
          }
          else
          {
            localObject10 = "";
          }
          Object localObject11 = localdkw.Hzt;
          if (localObject11 != null)
          {
            localObject12 = ((dkz)localObject11).iAG;
            localObject11 = localObject12;
            if (localObject12 != null) {}
          }
          else
          {
            localObject11 = "";
          }
          Object localObject12 = localdkw.Hzt;
          if (localObject12 != null)
          {
            localObject13 = ((dkz)localObject12).iAH;
            localObject12 = localObject13;
            if (localObject13 != null) {}
          }
          else
          {
            localObject12 = "";
          }
          Object localObject13 = localdkw.Hzt;
          if (localObject13 != null)
          {
            String str = ((dkz)localObject13).iAI;
            localObject13 = str;
            if (str != null) {}
          }
          else
          {
            localObject13 = "";
          }
          localObject8 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
          if (localdkw.Hzl != 1) {
            break label1045;
          }
          bool3 = true;
          if (localdkw.HzC != 1) {
            break label1051;
          }
          bool4 = true;
          localObject3 = localdkw.Buffer;
          if (localObject3 == null) {
            break label1057;
          }
          localObject3 = ((com.tencent.mm.bx.b)localObject3).toByteArray();
          k = localdkw.HzI;
          localObject4 = localdkw.HzJ;
          if (localObject4 == null) {
            break label1065;
          }
        }
        for (int i = ((dkx)localObject4).GOe;; i = -1)
        {
          localObject4 = localdkw.HzJ;
          if (localObject4 != null)
          {
            localObject5 = ((dkx)localObject4).GFh;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localdkw.HzJ;
          if (localObject5 != null)
          {
            localObject6 = ((dkx)localObject5).HzK;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject9 = new ShowInfo(i, (String)localObject4, (String)localObject5);
          localObject5 = localdkw.HzG;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localObject6 = localdkw.HzH;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          i = localdkw.HzD;
          localObject7 = localdkw.HzE;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          localc.a(paramInt1, paramInt2, (String)localObject1, new SubscribeMsgRequestResult(bool1, paramString, (String)localObject2, j, localArrayList, bool2, (WordingInfo)localObject8, bool3, bool4, (byte[])localObject3, k, (ShowInfo)localObject9, (String)localObject4, (String)localObject5, i, (String)localObject6, localdkw.HzF));
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static final a iAW;
    
    static
    {
      AppMethodBeat.i(149566);
      iAW = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatusByUrlReq", "subscribeUrl", "buildGetSubscribeStatusReq", "templateIds", "", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "wxbiz-msgsubscription-sdk_release"})
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
          paramSubscribeMsgRequestDialogUiData = new dku();
          paramSubscribeMsgRequestDialogUiData.GQJ = paramList.hAT;
          paramSubscribeMsgRequestDialogUiData.Hzg = paramList.iAq;
          paramSubscribeMsgRequestDialogUiData.Hzk = paramList.iAs;
          if (paramList.Vp) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramSubscribeMsgRequestDialogUiData.Hzl = paramInt;
            paramArrayOfByte.add(paramSubscribeMsgRequestDialogUiData);
            break;
          }
        }
        AppMethodBeat.o(149565);
        return paramString;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Companion;", "", "()V", "ACTION_GET_ALL_SUBSCRIBE_STATUS", "", "ACTION_GET_SUBSCRIBE_STATUS", "ACTION_GET_UI_STATUS", "ACTION_SUBSCRIBE", "ACTION_SUBSCRIBE_FOR_DIALOG_REQUEST", "FUNC_FLAG_SET_IS_OPEN", "TAG", "", "URI", "ACTION", "wxbiz-msgsubscription-sdk_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */