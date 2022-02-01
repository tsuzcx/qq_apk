package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "idList", "", "", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRemoteUserList", "Lcom/tencent/mm/protocal/protobuf/OnlineMemberInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class n
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static final a gww;
  private g callback;
  private b gvE;
  private azj gwu;
  public azk gwv;
  
  static
  {
    AppMethodBeat.i(189934);
    gww = new a((byte)0);
    AppMethodBeat.o(189934);
  }
  
  public n(long paramLong, List<String> paramList)
  {
    AppMethodBeat.i(189933);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new azj());
    ((b.a)localObject).d((a)new azk());
    ((b.a)localObject).op(3816);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/getliveonlinememberbyid");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdRequest");
      AppMethodBeat.o(189933);
      throw paramList;
    }
    this.gwu = ((azj)localObject);
    this.gwu.DMV = paramLong;
    localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.gwu.EQK;
        if (localObject != null) {
          ((LinkedList)localObject).addAll((Collection)paramList);
        }
      }
      ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "get live info liveId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(189933);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189931);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189931);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189932);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189932);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdResponse");
      AppMethodBeat.o(189932);
      throw paramString;
    }
    this.gwv = ((azk)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(189932);
      return;
    }
    AppMethodBeat.o(189932);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.n
 * JD-Core Version:    0.7.0.1
 */