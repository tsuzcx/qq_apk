package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "idList", "", "", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRemoteUserList", "Lcom/tencent/mm/protocal/protobuf/OnlineMemberInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  public static final a gSP;
  private f callback;
  private b gRX;
  private bed gSN;
  public bee gSO;
  
  static
  {
    AppMethodBeat.i(215840);
    gSP = new a((byte)0);
    AppMethodBeat.o(215840);
  }
  
  public n(long paramLong, List<String> paramList)
  {
    AppMethodBeat.i(215839);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bed());
    ((b.a)localObject).d((a)new bee());
    ((b.a)localObject).oS(3816);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/getliveonlinememberbyid");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdRequest");
      AppMethodBeat.o(215839);
      throw paramList;
    }
    this.gSN = ((bed)localObject);
    this.gSN.FKy = paramLong;
    localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.gSN.GTB;
        if (localObject != null) {
          ((LinkedList)localObject).addAll((Collection)paramList);
        }
      }
      ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "get live info liveId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(215839);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215837);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215837);
    return i;
  }
  
  public final int getType()
  {
    return 3816;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215838);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215838);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdResponse");
      AppMethodBeat.o(215838);
      throw paramString;
    }
    this.gSO = ((bee)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(215838);
      return;
    }
    AppMethodBeat.o(215838);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.n
 * JD-Core Version:    0.7.0.1
 */