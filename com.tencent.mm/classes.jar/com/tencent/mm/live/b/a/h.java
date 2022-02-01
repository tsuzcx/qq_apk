package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "msgId", "(JLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/ApplyLiveMicResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class h
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwe;
  private g callback;
  private b gvE;
  private gc gwc;
  public gd gwd;
  
  static
  {
    AppMethodBeat.i(189910);
    gwe = new a((byte)0);
    AppMethodBeat.o(189910);
  }
  
  public h(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189909);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new gc());
    ((b.a)localObject).d((a)new gd());
    ((b.a)localObject).op(3995);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/applylivemic");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicRequest");
      AppMethodBeat.o(189909);
      throw paramString1;
    }
    this.gwc = ((gc)localObject);
    this.gwc.DMV = paramLong;
    this.gwc.DMW = paramString1;
    this.gwc.DMX = paramString2;
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "apply live mic, liveId:" + paramLong + ", roomId:" + paramString1 + ", msgId:" + paramString2);
    AppMethodBeat.o(189909);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189907);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189907);
    return i;
  }
  
  public final int getType()
  {
    return 3995;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189908);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189908);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ApplyLiveMicResponse");
      AppMethodBeat.o(189908);
      throw paramString;
    }
    this.gwd = ((gd)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveApplyLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189908);
      return;
    }
    AppMethodBeat.o(189908);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveApplyLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.h
 * JD-Core Version:    0.7.0.1
 */