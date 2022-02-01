package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/ShareLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/ShareLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class t
  extends n
  implements com.tencent.mm.network.k
{
  public static final a AgC;
  private ebt AgA;
  private ebu AgB;
  private g callback;
  private b iaa;
  
  static
  {
    AppMethodBeat.i(202767);
    AgC = new a((byte)0);
    AppMethodBeat.o(202767);
  }
  
  public t(long paramLong, String paramString)
  {
    AppMethodBeat.i(202766);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ebt());
    ((b.a)localObject).d((a)new ebu());
    ((b.a)localObject).nB(3557);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/sharelive");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveRequest");
      AppMethodBeat.o(202766);
      throw paramString;
    }
    this.AgA = ((ebt)localObject);
    this.AgA.LwA = paramLong;
    this.AgA.EEF = paramString;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "liveId:" + paramLong + " wechatRoomId:" + paramString);
    AppMethodBeat.o(202766);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202764);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202764);
    return i;
  }
  
  public final int getType()
  {
    return 3557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202765);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202765);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ShareLiveResponse");
      AppMethodBeat.o(202765);
      throw paramString;
    }
    this.AgB = ((ebu)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveShareLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202765);
      return;
    }
    AppMethodBeat.o(202765);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveShareLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.t
 * JD-Core Version:    0.7.0.1
 */