package com.tencent.mm.live.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "msgId", "micId", "micSdkId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class k
  extends q
  implements m
{
  public static final a hKd;
  private i callback;
  private d hJu;
  private abd hKb;
  private abe hKc;
  
  static
  {
    AppMethodBeat.i(207781);
    hKd = new a((byte)0);
    AppMethodBeat.o(207781);
  }
  
  public k(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207780);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new abd());
    ((d.a)localObject).d((a)new abe());
    ((d.a)localObject).sG(3509);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/closelivemic");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicRequest");
      AppMethodBeat.o(207780);
      throw paramString1;
    }
    this.hKb = ((abd)localObject);
    this.hKb.hyH = paramLong;
    this.hKb.KDQ = paramString1;
    this.hKb.KDR = paramString2;
    if (!TextUtils.isEmpty((CharSequence)paramString3)) {
      this.hKb.KDS = paramString3;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString4)) {
      this.hKb.Lmn = paramString4;
    }
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", msgId:" + paramString2 + ", micId:" + paramString3 + ", micSdkId:" + paramString4);
    AppMethodBeat.o(207780);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207778);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207778);
    return i;
  }
  
  public final int getType()
  {
    return 3509;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207779);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207779);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicResponse");
      AppMethodBeat.o(207779);
      throw paramString;
    }
    this.hKc = ((abe)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207779);
      return;
    }
    AppMethodBeat.o(207779);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.k
 * JD-Core Version:    0.7.0.1
 */