package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends n
  implements k
{
  public static final a gSJ;
  private f callback;
  private final String gJj;
  private final String gPn;
  private b gRX;
  private final acf gSH;
  public acg gSI;
  
  static
  {
    AppMethodBeat.i(215832);
    gSJ = new a((byte)0);
    AppMethodBeat.o(215832);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215831);
    this.gJj = paramString1;
    this.gPn = paramString2;
    paramString1 = new b.a();
    paramString1.c((a)new acf());
    paramString1.d((a)new acg());
    paramString1.oS(3501);
    paramString1.DN("/cgi-bin/micromsg-bin/createlive");
    paramString1.oU(0);
    paramString1.oV(0);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.gJj + " roomId:" + this.gPn);
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.gRX = paramString1;
    paramString1 = this.gRX.aEU();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(215831);
      throw paramString1;
    }
    this.gSH = ((acf)paramString1);
    this.gSH.Gud = this.gJj;
    this.gSH.FKz = this.gPn;
    AppMethodBeat.o(215831);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215829);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215829);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215830);
    p.h(paramq, "rr");
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(215830);
      throw paramString;
    }
    this.gSI = ((acg)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215830);
      return;
    }
    AppMethodBeat.o(215830);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */