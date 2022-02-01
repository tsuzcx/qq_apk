package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "audience", "", "roomId", "liveMicId", "msgId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/AcceptLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class f
  extends n
  implements k
{
  public static final a gPJ;
  private com.tencent.mm.al.f callback;
  private ar gPH;
  private as gPI;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212188);
    gPJ = new a((byte)0);
    AppMethodBeat.o(212188);
  }
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(212187);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ar());
    ((b.a)localObject).d((a)new as());
    ((b.a)localObject).oP(3800);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/acceptlivemic");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicRequest");
      AppMethodBeat.o(212187);
      throw paramString1;
    }
    this.gPH = ((ar)localObject);
    this.gPH.Fsa = paramLong;
    this.gPH.gQT = paramString1;
    this.gPH.Fsb = paramString2;
    this.gPH.Fsd = paramString3;
    this.gPH.Fsc = paramString4;
    AppMethodBeat.o(212187);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(212185);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212185);
    return i;
  }
  
  public final int getType()
  {
    return 3800;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212186);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212186);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AcceptLiveMicResponse");
      AppMethodBeat.o(212186);
      throw paramString;
    }
    this.gPI = ((as)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveAcceptLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212186);
      return;
    }
    AppMethodBeat.o(212186);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveAcceptLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.f
 * JD-Core Version:    0.7.0.1
 */