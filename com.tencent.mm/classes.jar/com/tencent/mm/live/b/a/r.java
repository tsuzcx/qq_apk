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
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableOpenReplay", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class r
  extends n
  implements k
{
  public static final a gQt;
  private f callback;
  private b gPp;
  private cfs gQr;
  private cft gQs;
  
  static
  {
    AppMethodBeat.i(212236);
    gQt = new a((byte)0);
    AppMethodBeat.o(212236);
  }
  
  public r(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212235);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new cfs());
    ((b.a)localObject).d((a)new cft());
    ((b.a)localObject).oP(3712);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/openlivereplay");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayRequest");
      AppMethodBeat.o(212235);
      throw paramString;
    }
    this.gQr = ((cfs)localObject);
    localObject = this.gQr;
    if (localObject != null) {
      ((cfs)localObject).Fsa = paramLong;
    }
    localObject = this.gQr;
    if (localObject != null) {
      ((cfs)localObject).Fsb = paramString;
    }
    localObject = this.gQr;
    if (localObject != null) {
      ((cfs)localObject).GOH = paramBoolean;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "open live replay liveId:" + paramLong + " roomId:" + paramString + " enableLiveReplay:" + paramBoolean);
    AppMethodBeat.o(212235);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(212233);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212233);
    return i;
  }
  
  public final int getType()
  {
    return 3712;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212234);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212234);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayResponse");
      AppMethodBeat.o(212234);
      throw paramString;
    }
    this.gQs = ((cft)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212234);
      return;
    }
    AppMethodBeat.o(212234);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.r
 * JD-Core Version:    0.7.0.1
 */