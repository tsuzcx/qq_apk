package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "audience", "", "roomId", "liveMicId", "msgId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gvY;
  private g callback;
  private b gvE;
  private ar gvW;
  private as gvX;
  
  static
  {
    AppMethodBeat.i(189902);
    gvY = new a((byte)0);
    AppMethodBeat.o(189902);
  }
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189901);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ar());
    ((b.a)localObject).d((a)new as());
    ((b.a)localObject).op(3800);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/acceptlivemic");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicRequest");
      AppMethodBeat.o(189901);
      throw paramString1;
    }
    this.gvW = ((ar)localObject);
    this.gvW.DMV = paramLong;
    this.gvW.gxi = paramString1;
    this.gvW.DMW = paramString2;
    this.gvW.DMY = paramString3;
    this.gvW.DMX = paramString4;
    AppMethodBeat.o(189901);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189899);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189899);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189900);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189900);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicResponse");
      AppMethodBeat.o(189900);
      throw paramString;
    }
    this.gvX = ((as)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189900);
      return;
    }
    AppMethodBeat.o(189900);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.f
 * JD-Core Version:    0.7.0.1
 */