package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "isClose", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseApplyLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class j
  extends n
  implements k
{
  public static final a gPV;
  private f callback;
  private zg gPT;
  private zh gPU;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212204);
    gPV = new a((byte)0);
    AppMethodBeat.o(212204);
  }
  
  public j(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212203);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new zg());
    ((b.a)localObject).d((a)new zh());
    ((b.a)localObject).oP(3530);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/closeapplylivemic");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "close live id:" + paramLong + " wechatRoomId:" + paramString + " isClose:" + paramBoolean);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicRequest");
      AppMethodBeat.o(212203);
      throw paramString;
    }
    this.gPT = ((zg)localObject);
    this.gPT.Fsa = paramLong;
    this.gPT.Fsb = paramString;
    paramString = this.gPT;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.FYO = paramBoolean;
      AppMethodBeat.o(212203);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212201);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212201);
    return i;
  }
  
  public final int getType()
  {
    return 3530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212202);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212202);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseApplyLiveMicResponse");
      AppMethodBeat.o(212202);
      throw paramString;
    }
    this.gPU = ((zh)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveCloseApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212202);
      return;
    }
    AppMethodBeat.o(212202);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.j
 * JD-Core Version:    0.7.0.1
 */