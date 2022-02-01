package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMicAudienceInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveMicAudienceInfo", "", "Lcom/tencent/mm/protocal/protobuf/LiveMicAudience;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class e
  extends q
  implements m
{
  public static final a hJL;
  private i callback;
  private bpn hJJ;
  public bpo hJK;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(207757);
    hJL = new a((byte)0);
    AppMethodBeat.o(207757);
  }
  
  public e(long paramLong, String paramString)
  {
    AppMethodBeat.i(207756);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bpn());
    ((d.a)localObject).d((a)new bpo());
    ((d.a)localObject).sG(589);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/getlivemicaudienceinfo");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "get mic audience info id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoRequest");
      AppMethodBeat.o(207756);
      throw paramString;
    }
    this.hJJ = ((bpn)localObject);
    this.hJJ.hyH = paramLong;
    this.hJJ.KDQ = paramString;
    AppMethodBeat.o(207756);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207754);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207754);
    return i;
  }
  
  public final int getType()
  {
    return 589;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207755);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207755);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMicAudienceInfoResponse");
      AppMethodBeat.o(207755);
      throw paramString;
    }
    this.hJK = ((bpo)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneGetMicAudienceInfo", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207755);
      return;
    }
    AppMethodBeat.o(207755);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetMicAudienceInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.e
 * JD-Core Version:    0.7.0.1
 */