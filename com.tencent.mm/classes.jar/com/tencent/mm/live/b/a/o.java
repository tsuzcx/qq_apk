package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveJoinLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "liveCookies", "", "(JLjava/lang/String;[B)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/JoinLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class o
  extends n
  implements com.tencent.mm.network.k
{
  public static final o.a gwz;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b gvE;
  private final bne gwx;
  public bnf gwy;
  
  static
  {
    AppMethodBeat.i(189938);
    gwz = new o.a((byte)0);
    AppMethodBeat.o(189938);
  }
  
  public o(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189937);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bne());
    ((b.a)localObject).d((a)new bnf());
    ((b.a)localObject).op(3797);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/joinlive");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "join live liveId:" + paramLong + ", roomId:" + paramString);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveRequest");
      AppMethodBeat.o(189937);
      throw paramString;
    }
    this.gwx = ((bne)localObject);
    this.gwx.DMV = paramLong;
    this.gwx.DMW = paramString;
    this.gwx.EQB = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    AppMethodBeat.o(189937);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189935);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189935);
    return i;
  }
  
  public final int getType()
  {
    return 3797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(189936);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189936);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.JoinLiveResponse");
      AppMethodBeat.o(189936);
      throw paramString;
    }
    this.gwy = ((bnf)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveJoinLive", "onGYNetEnd error");
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(189936);
        return;
      }
      AppMethodBeat.o(189936);
      return;
    }
    paramq = this.gwy;
    if (paramq != null) {}
    for (paramq = paramq.EQB;; paramq = null)
    {
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
      if (paramq != null) {
        paramArrayOfByte = paramq.getBytes();
      }
      com.tencent.mm.live.b.g.Q(paramArrayOfByte);
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189936);
      return;
    }
    AppMethodBeat.o(189936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a.o
 * JD-Core Version:    0.7.0.1
 */