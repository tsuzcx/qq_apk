package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "enableOpenReplay", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/OpenLiveReplayResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class q
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zcn;
  private g callback;
  private b iaa;
  private ebg zcl;
  private ebh zcm;
  
  static
  {
    AppMethodBeat.i(202755);
    zcn = new a((byte)0);
    AppMethodBeat.o(202755);
  }
  
  public q(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202754);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ebg());
    ((b.a)localObject).d((a)new ebh());
    ((b.a)localObject).nB(3712);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/openlivereplay");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayRequest");
      AppMethodBeat.o(202754);
      throw paramString;
    }
    this.zcl = ((ebg)localObject);
    localObject = this.zcl;
    if (localObject != null) {
      ((ebg)localObject).LwA = paramLong;
    }
    localObject = this.zcl;
    if (localObject != null) {
      ((ebg)localObject).EEF = paramString;
    }
    localObject = this.zcl;
    if (localObject != null) {
      ((ebg)localObject).Lzd = paramBoolean;
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "open live replay liveId:" + paramLong + " roomId:" + paramString + " enableLiveReplay:" + paramBoolean);
    AppMethodBeat.o(202754);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202752);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202752);
    return i;
  }
  
  public final int getType()
  {
    return 3712;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202753);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202753);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OpenLiveReplayResponse");
      AppMethodBeat.o(202753);
      throw paramString;
    }
    this.zcm = ((ebh)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveOpenReplay", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202753);
      return;
    }
    AppMethodBeat.o(202753);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveOpenReplay$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.q
 * JD-Core Version:    0.7.0.1
 */