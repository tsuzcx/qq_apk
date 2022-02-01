package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveMicAudienceInfo", "", "Lcom/tencent/mm/protocal/protobuf/LiveMicAudience;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gvV;
  private g callback;
  private b gvE;
  private azf gvT;
  public azg gvU;
  
  static
  {
    AppMethodBeat.i(189898);
    gvV = new a((byte)0);
    AppMethodBeat.o(189898);
  }
  
  public e(long paramLong, String paramString)
  {
    AppMethodBeat.i(189897);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new azf());
    ((b.a)localObject).d((a)new azg());
    ((b.a)localObject).op(589);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/getlivemicaudienceinfo");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "get mic audience info id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoRequest");
      AppMethodBeat.o(189897);
      throw paramString;
    }
    this.gvT = ((azf)localObject);
    this.gvT.DMV = paramLong;
    this.gvT.DMW = paramString;
    AppMethodBeat.o(189897);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(189895);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189895);
    return i;
  }
  
  public final int getType()
  {
    return 589;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189896);
    ac.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189896);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoResponse");
      AppMethodBeat.o(189896);
      throw paramString;
    }
    this.gvU = ((azg)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189896);
      return;
    }
    AppMethodBeat.o(189896);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.e
 * JD-Core Version:    0.7.0.1
 */