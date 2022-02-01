package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "isClose", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class j
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwk;
  private g callback;
  private b gvE;
  private xh gwi;
  private xi gwj;
  
  static
  {
    AppMethodBeat.i(189918);
    gwk = new a((byte)0);
    AppMethodBeat.o(189918);
  }
  
  public j(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189917);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new xh());
    ((b.a)localObject).d((a)new xi());
    ((b.a)localObject).op(3530);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/closeapplylivemic");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "close live id:" + paramLong + " wechatRoomId:" + paramString + " isClose:" + paramBoolean);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicRequest");
      AppMethodBeat.o(189917);
      throw paramString;
    }
    this.gwi = ((xh)localObject);
    this.gwi.DMV = paramLong;
    this.gwi.DMW = paramString;
    paramString = this.gwi;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.ErE = paramBoolean;
      AppMethodBeat.o(189917);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189915);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189915);
    return i;
  }
  
  public final int getType()
  {
    return 3530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189916);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189916);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicResponse");
      AppMethodBeat.o(189916);
      throw paramString;
    }
    this.gwj = ((xi)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189916);
      return;
    }
    AppMethodBeat.o(189916);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.j
 * JD-Core Version:    0.7.0.1
 */