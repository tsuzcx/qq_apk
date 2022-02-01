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
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "msgId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class h
  extends n
  implements k
{
  public static final a gPP;
  private f callback;
  private gj gPN;
  public gk gPO;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212196);
    gPP = new a((byte)0);
    AppMethodBeat.o(212196);
  }
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212195);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new gj());
    ((b.a)localObject).d((a)new gk());
    ((b.a)localObject).oP(3995);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/applylivemic");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicRequest");
      AppMethodBeat.o(212195);
      throw paramString1;
    }
    this.gPN = ((gj)localObject);
    this.gPN.Fsa = paramLong;
    this.gPN.Fsb = paramString1;
    this.gPN.Fsc = paramString2;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "apply live mic, liveId:" + paramLong + ", roomId:" + paramString1 + ", msgId:" + paramString2);
    AppMethodBeat.o(212195);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212193);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212193);
    return i;
  }
  
  public final int getType()
  {
    return 3995;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212194);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212194);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicResponse");
      AppMethodBeat.o(212194);
      throw paramString;
    }
    this.gPO = ((gk)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212194);
      return;
    }
    AppMethodBeat.o(212194);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.h
 * JD-Core Version:    0.7.0.1
 */