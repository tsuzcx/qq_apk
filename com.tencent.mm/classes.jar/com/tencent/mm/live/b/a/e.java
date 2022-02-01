package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveMicAudienceInfo", "", "Lcom/tencent/mm/protocal/protobuf/LiveMicAudience;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class e
  extends n
  implements k
{
  public static final a gSo;
  private f callback;
  private b gRX;
  private bdz gSm;
  public bea gSn;
  
  static
  {
    AppMethodBeat.i(215804);
    gSo = new a((byte)0);
    AppMethodBeat.o(215804);
  }
  
  public e(long paramLong, String paramString)
  {
    AppMethodBeat.i(215803);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bdz());
    ((b.a)localObject).d((a)new bea());
    ((b.a)localObject).oS(589);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/getlivemicaudienceinfo");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "get mic audience info id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoRequest");
      AppMethodBeat.o(215803);
      throw paramString;
    }
    this.gSm = ((bdz)localObject);
    this.gSm.FKy = paramLong;
    this.gSm.FKz = paramString;
    AppMethodBeat.o(215803);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215801);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215801);
    return i;
  }
  
  public final int getType()
  {
    return 589;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215802);
    ae.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215802);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoResponse");
      AppMethodBeat.o(215802);
      throw paramString;
    }
    this.gSn = ((bea)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215802);
      return;
    }
    AppMethodBeat.o(215802);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.e
 * JD-Core Version:    0.7.0.1
 */