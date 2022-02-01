package com.tencent.mm.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveName", "", "wechatRoomId", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveName", "()Ljava/lang/String;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CreateLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "getWechatRoomId", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends p
  implements m
{
  public static final a naX;
  private h callback;
  private final String mIA;
  private final String mXO;
  private final aha naY;
  public ahb naZ;
  private c nao;
  
  static
  {
    AppMethodBeat.i(246889);
    naX = new a((byte)0);
    AppMethodBeat.o(246889);
  }
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246884);
    this.mIA = paramString1;
    this.mXO = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)new aha());
    paramString1.otF = ((a)new ahb());
    paramString1.funcId = 3501;
    paramString1.uri = "/cgi-bin/micromsg-bin/createlive";
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "create live name:" + this.mIA + " roomId:" + this.mXO);
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.nao = paramString1;
    paramString1 = c.b.b(this.nao.otB);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveRequest");
      AppMethodBeat.o(246884);
      throw paramString1;
    }
    this.naY = ((aha)paramString1);
    this.naY.Zqd = this.mIA;
    this.naY.YBL = this.mXO;
    AppMethodBeat.o(246884);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(246902);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(246902);
    return i;
  }
  
  public final int getType()
  {
    return 3501;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(246912);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CreateLiveResponse");
      AppMethodBeat.o(246912);
      throw paramString;
    }
    this.naZ = ((ahb)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCreateLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(246912);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCreateLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.a.l
 * JD-Core Version:    0.7.0.1
 */