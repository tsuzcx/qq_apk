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
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends q
  implements m
{
  public static final a hKg;
  private i callback;
  private final String hFW;
  private d hJu;
  private final aeh hKe;
  public aei hKf;
  private final String hwb;
  
  static
  {
    AppMethodBeat.i(207785);
    hKg = new a((byte)0);
    AppMethodBeat.o(207785);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207784);
    this.hwb = paramString1;
    this.hFW = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)new aeh());
    paramString1.d((a)new aei());
    paramString1.sG(3501);
    paramString1.MB("/cgi-bin/micromsg-bin/createlive");
    paramString1.sI(0);
    paramString1.sJ(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.hwb + " roomId:" + this.hFW);
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.hJu = paramString1;
    paramString1 = this.hJu.aYJ();
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(207784);
      throw paramString1;
    }
    this.hKe = ((aeh)paramString1);
    this.hKe.LpF = this.hwb;
    this.hKe.KDQ = this.hFW;
    AppMethodBeat.o(207784);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207782);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207782);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207783);
    p.h(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(207783);
      throw paramString;
    }
    this.hKf = ((aei)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207783);
      return;
    }
    AppMethodBeat.o(207783);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */