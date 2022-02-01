package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "msgType", "", "liveId", "", "liveCookies", "", "wechatRoomId", "(Ljava/lang/String;IJ[BLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/PostLiveMessageResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-logic_release"})
public final class r
  extends n
  implements com.tencent.mm.network.k
{
  public static final a Agw;
  private ebm Agv;
  private g callback;
  private com.tencent.mm.al.b iaa;
  private ebl zcX;
  
  static
  {
    AppMethodBeat.i(202759);
    Agw = new a((byte)0);
    AppMethodBeat.o(202759);
  }
  
  public r(String paramString1, int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(202758);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new ebl());
    ((b.a)localObject).d((a)new ebm());
    ((b.a)localObject).nB(904);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/postlivemessage");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((com.tencent.mm.al.b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageRequest");
      AppMethodBeat.o(202758);
      throw paramString1;
    }
    this.zcX = ((ebl)localObject);
    localObject = this.zcX;
    if (localObject != null) {
      ((ebl)localObject).content = paramString1;
    }
    localObject = this.zcX;
    if (localObject != null) {
      ((ebl)localObject).CJZ = paramInt;
    }
    localObject = this.zcX;
    if (localObject != null) {
      ((ebl)localObject).LyM = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    }
    paramArrayOfByte = this.zcX;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.LwA = paramLong;
    }
    paramArrayOfByte = this.zcX;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.EEF = paramString2;
    }
    paramArrayOfByte = this.zcX;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.LwB = (u.aqG() + System.currentTimeMillis());
    }
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "post msg content:" + paramString1 + ", msgType:" + paramInt + ", liveId:" + paramLong + ", roomId:" + paramString2);
    AppMethodBeat.o(202758);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202756);
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202756);
    return i;
  }
  
  public final int getType()
  {
    return 904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202757);
    ad.i("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202757);
      throw paramString;
    }
    paramq = ((com.tencent.mm.al.b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PostLiveMessageResponse");
      AppMethodBeat.o(202757);
      throw paramString;
    }
    this.Agv = ((ebm)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLivePostLiveMessage", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202757);
      return;
    }
    AppMethodBeat.o(202757);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLivePostLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.r
 * JD-Core Version:    0.7.0.1
 */