package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "cutLive", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class a
  extends q
  implements m
{
  public static final a hJx;
  private i callback;
  private d hJu;
  private abf hJv;
  private abg hJw;
  
  static
  {
    AppMethodBeat.i(207741);
    hJx = new a((byte)0);
    AppMethodBeat.o(207741);
  }
  
  public a(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207740);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new abf());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new abg());
    ((d.a)localObject).sG(3583);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/closelive");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    Log.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "close live id:" + paramLong + " wechatRoomId:" + paramString + " cutLive:" + paramBoolean);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveRequest");
      AppMethodBeat.o(207740);
      throw paramString;
    }
    this.hJv = ((abf)localObject);
    this.hJv.hyH = paramLong;
    this.hJv.KDQ = paramString;
    this.hJv.Lmo = paramBoolean;
    AppMethodBeat.o(207740);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207738);
    Log.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207738);
    return i;
  }
  
  public final int getType()
  {
    return 3583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207739);
    Log.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207739);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveResponse");
      AppMethodBeat.o(207739);
      throw paramString;
    }
    this.hJw = ((abg)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd error");
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207739);
      return;
    }
    AppMethodBeat.o(207739);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.a
 * JD-Core Version:    0.7.0.1
 */