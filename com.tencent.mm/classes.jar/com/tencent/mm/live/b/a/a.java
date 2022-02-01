package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class a
  extends n
  implements k
{
  public static final a gPs;
  private f callback;
  private b gPp;
  private zm gPq;
  private zn gPr;
  
  static
  {
    AppMethodBeat.i(212168);
    gPs = new a((byte)0);
    AppMethodBeat.o(212168);
  }
  
  public a(long paramLong, String paramString)
  {
    AppMethodBeat.i(212167);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bx.a)new zm());
    ((b.a)localObject).d((com.tencent.mm.bx.a)new zn());
    ((b.a)localObject).oP(3583);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/closelive");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "close live id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveRequest");
      AppMethodBeat.o(212167);
      throw paramString;
    }
    this.gPq = ((zm)localObject);
    this.gPq.Fsa = paramLong;
    this.gPq.Fsb = paramString;
    AppMethodBeat.o(212167);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212165);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212165);
    return i;
  }
  
  public final int getType()
  {
    return 3583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212166);
    ad.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212166);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveResponse");
      AppMethodBeat.o(212166);
      throw paramString;
    }
    this.gPr = ((zn)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212166);
      return;
    }
    AppMethodBeat.o(212166);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.a
 * JD-Core Version:    0.7.0.1
 */