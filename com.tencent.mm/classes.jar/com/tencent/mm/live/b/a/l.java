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
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends n
  implements k
{
  public static final a gQb;
  private f callback;
  private final String gGA;
  private final String gME;
  private final abw gPZ;
  private b gPp;
  public abx gQa;
  
  static
  {
    AppMethodBeat.i(212212);
    gQb = new a((byte)0);
    AppMethodBeat.o(212212);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212211);
    this.gGA = paramString1;
    this.gME = paramString2;
    paramString1 = new b.a();
    paramString1.c((a)new abw());
    paramString1.d((a)new abx());
    paramString1.oP(3501);
    paramString1.Dl("/cgi-bin/micromsg-bin/createlive");
    paramString1.oR(0);
    paramString1.oS(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.gGA + " roomId:" + this.gME);
    paramString1 = paramString1.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.gPp = paramString1;
    paramString1 = this.gPp.aEE();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(212211);
      throw paramString1;
    }
    this.gPZ = ((abw)paramString1);
    this.gPZ.Gbw = this.gGA;
    this.gPZ.Fsb = this.gME;
    AppMethodBeat.o(212211);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212209);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212209);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212210);
    p.h(paramq, "rr");
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(212210);
      throw paramString;
    }
    this.gQa = ((abx)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212210);
      return;
    }
    AppMethodBeat.o(212210);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */