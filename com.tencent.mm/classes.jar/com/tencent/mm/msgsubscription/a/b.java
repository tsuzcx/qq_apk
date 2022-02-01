package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.msgsubscription.util.a.c.a;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czz;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "isOpened", "", "(Ljava/lang/String;IZ)V", "(Ljava/lang/String;I)V", "getActionType", "()I", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b
  extends a
  implements a.b
{
  public static final b.b hGZ;
  private final int actionType;
  private final List<czv> hGT;
  private a.c hGU;
  public c hGV;
  private String hGW;
  private SubscribeMsgRequestDialogUiData hGX;
  private byte[] hGY;
  private boolean hGj;
  public final String username;
  
  static
  {
    AppMethodBeat.i(149573);
    hGZ = new b.b((byte)0);
    AppMethodBeat.o(149573);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149571);
    this.username = paramString;
    this.actionType = paramInt;
    this.hGT = ((List)new ArrayList());
    this.hGW = "";
    this.hGY = new byte[0];
    AppMethodBeat.o(149571);
  }
  
  public b(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt);
    AppMethodBeat.i(149572);
    this.hGj = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    k.h(parama, "dispatcher");
    Object localObject1 = a.c.hKj;
    this.hGU = a.c.a.a((ckq)new czw(), (cld)new czx(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.hGU;
    if (localObject1 == null) {
      k.fvU();
    }
    localObject1 = ((a.c)localObject1).aEx();
    if (localObject1 == null)
    {
      parama = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
      AppMethodBeat.o(174564);
      throw parama;
    }
    localObject1 = (czw)localObject1;
    switch (this.actionType)
    {
    case 4: 
    default: 
      localObject1 = this.hGU;
      if (localObject1 == null) {
        k.fvU();
      }
      i = parama.a((a.c)localObject1, (a.b)this, (a)this);
      AppMethodBeat.o(174564);
      return i;
    case 2: 
    case 3: 
    case 5: 
      ((czw)localObject1).CIt = this.username;
      ((czw)localObject1).CKO = this.actionType;
      ((czw)localObject1).saZ.addAll((Collection)this.hGT);
      if (((CharSequence)this.hGW).length() > 0) {}
      while (i != 0)
      {
        ((czw)localObject1).ErE = this.hGW;
        break;
        i = 0;
      }
    }
    ((czw)localObject1).CIt = this.username;
    ((czw)localObject1).CKO = this.actionType;
    ((czw)localObject1).CID = 1;
    if (this.hGj) {}
    for (i = 1;; i = 0)
    {
      ((czw)localObject1).Ery = i;
      ((czw)localObject1).saZ.addAll((Collection)this.hGT);
      if (this.actionType != 6) {
        break;
      }
      ((czw)localObject1).Buffer = new com.tencent.mm.bx.b(this.hGY);
      ((czw)localObject1).ErF = new cbc();
      Object localObject2 = this.hGX;
      if (localObject2 == null) {
        break;
      }
      ((czw)localObject1).ErF.DXr = ((SubscribeMsgRequestDialogUiData)localObject2).hFQ;
      ((czw)localObject1).ErF.fVE = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
      localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).hFR.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
        LinkedList localLinkedList = ((czw)localObject1).ErF.DXs;
        czz localczz = new czz();
        localczz.DKS = localItemUiData.gIj;
        localczz.Erw = localItemUiData.hFZ;
        localLinkedList.add(localczz);
      }
      break;
    }
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    k.h(paramArrayOfByte, "<set-?>");
    this.hGY = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.hGV;
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
    Object localObject1 = this.hGU;
    if (localObject1 == null) {
      k.fvU();
    }
    localObject1 = ((a.c)localObject1).aEy();
    if (localObject1 == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
      AppMethodBeat.o(174565);
      throw paramString;
    }
    Object localObject2 = (czx)localObject1;
    c localc = this.hGV;
    if (localc != null)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = SubscribeMsgRequestResult.hGs;
      localc.a(paramInt1, paramInt2, (String)localObject1, SubscribeMsgRequestResult.a.a((czx)localObject2));
      AppMethodBeat.o(174565);
      return;
    }
    AppMethodBeat.o(174565);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static final a hHa;
    
    static
    {
      AppMethodBeat.i(149566);
      hHa = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatusByUrlReq", "subscribeUrl", "buildGetSubscribeStatusReq", "templateIds", "", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      public static b a(String paramString, b.c paramc)
      {
        AppMethodBeat.i(149564);
        k.h(paramString, "username");
        paramString = new b(paramString, 3);
        b.a(paramString, paramc);
        AppMethodBeat.o(149564);
        return paramString;
      }
      
      public static b a(String paramString, List<SubscribeMsgTmpItem> paramList, b.c paramc, boolean paramBoolean)
      {
        AppMethodBeat.i(149561);
        k.h(paramString, "username");
        k.h(paramList, "templates");
        paramString = a(paramString, paramBoolean, paramc, paramList, 1, new byte[0], null);
        AppMethodBeat.o(149561);
        return paramString;
      }
      
      public static b a(String paramString, List<SubscribeMsgTmpItem> paramList, b.c paramc, boolean paramBoolean, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(149562);
        k.h(paramString, "username");
        k.h(paramList, "templates");
        k.h(paramArrayOfByte, "byteArray");
        paramString = a(paramString, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData);
        AppMethodBeat.o(149562);
        return paramString;
      }
      
      private static b a(String paramString, boolean paramBoolean, b.c paramc, List<SubscribeMsgTmpItem> paramList, int paramInt, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(149565);
        paramString = new b(paramString, paramInt, paramBoolean);
        b.a(paramString, paramc);
        paramString.ag(paramArrayOfByte);
        b.a(paramString, paramSubscribeMsgRequestDialogUiData);
        paramc = paramList.iterator();
        if (paramc.hasNext())
        {
          paramList = (SubscribeMsgTmpItem)paramc.next();
          paramArrayOfByte = b.a(paramString);
          paramSubscribeMsgRequestDialogUiData = new czv();
          paramSubscribeMsgRequestDialogUiData.DKS = paramList.gIj;
          paramSubscribeMsgRequestDialogUiData.Ert = paramList.hGu;
          paramSubscribeMsgRequestDialogUiData.Erx = paramList.hGw;
          if (paramList.SE) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramSubscribeMsgRequestDialogUiData.Ery = paramInt;
            paramArrayOfByte.add(paramSubscribeMsgRequestDialogUiData);
            break;
          }
        }
        AppMethodBeat.o(149565);
        return paramString;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */