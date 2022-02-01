package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveMicAudienceInfo", "", "Lcom/tencent/mm/protocal/protobuf/LiveMicAudience;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class e
  extends n
  implements k
{
  public static final a gPG;
  private f callback;
  private bdj gPE;
  public bdk gPF;
  private b gPp;
  
  static
  {
    AppMethodBeat.i(212184);
    gPG = new a((byte)0);
    AppMethodBeat.o(212184);
  }
  
  public e(long paramLong, String paramString)
  {
    AppMethodBeat.i(212183);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bdj());
    ((b.a)localObject).d((a)new bdk());
    ((b.a)localObject).oP(589);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/getlivemicaudienceinfo");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "get mic audience info id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoRequest");
      AppMethodBeat.o(212183);
      throw paramString;
    }
    this.gPE = ((bdj)localObject);
    this.gPE.Fsa = paramLong;
    this.gPE.Fsb = paramString;
    AppMethodBeat.o(212183);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(212181);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212181);
    return i;
  }
  
  public final int getType()
  {
    return 589;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212182);
    ad.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(212182);
      throw paramString;
    }
    paramq = ((b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoResponse");
      AppMethodBeat.o(212182);
      throw paramString;
    }
    this.gPF = ((bdk)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(212182);
      return;
    }
    AppMethodBeat.o(212182);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.e
 * JD-Core Version:    0.7.0.1
 */