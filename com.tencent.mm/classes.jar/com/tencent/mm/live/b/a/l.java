package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwq;
  private g callback;
  private final String gmR;
  private final String gsT;
  private b gvE;
  private final zw gwo;
  public zx gwp;
  
  static
  {
    AppMethodBeat.i(189926);
    gwq = new a((byte)0);
    AppMethodBeat.o(189926);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189925);
    this.gmR = paramString1;
    this.gsT = paramString2;
    paramString1 = new b.a();
    paramString1.c((a)new zw());
    paramString1.d((a)new zx());
    paramString1.op(3501);
    paramString1.Am("/cgi-bin/micromsg-bin/createlive");
    paramString1.or(0);
    paramString1.os(0);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.gmR + " roomId:" + this.gsT);
    paramString1 = paramString1.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.gvE = paramString1;
    paramString1 = this.gvE.aBC();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(189925);
      throw paramString1;
    }
    this.gwo = ((zw)paramString1);
    this.gwo.Eud = this.gmR;
    this.gwo.DMW = this.gsT;
    AppMethodBeat.o(189925);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189923);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189923);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189924);
    d.g.b.k.h(paramq, "rr");
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(189924);
      throw paramString;
    }
    this.gwp = ((zx)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189924);
      return;
    }
    AppMethodBeat.o(189924);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */