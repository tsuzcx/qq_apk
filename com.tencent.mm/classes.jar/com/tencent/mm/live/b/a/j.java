package com.tencent.mm.live.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "msgId", "micId", "micSdkId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class j
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbM;
  private g callback;
  private b iaa;
  private dxr zbK;
  private dxs zbL;
  
  static
  {
    AppMethodBeat.i(202727);
    zbM = new a((byte)0);
    AppMethodBeat.o(202727);
  }
  
  public j(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202726);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new dxr());
    ((b.a)localObject).d((a)new dxs());
    ((b.a)localObject).nB(3509);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/closelivemic");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicRequest");
      AppMethodBeat.o(202726);
      throw paramString1;
    }
    this.zbK = ((dxr)localObject);
    this.zbK.LwA = paramLong;
    this.zbK.EEF = paramString1;
    this.zbK.LwB = paramString2;
    if (!TextUtils.isEmpty((CharSequence)paramString3)) {
      this.zbK.LwC = paramString3;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString4)) {
      this.zbK.LwP = paramString4;
    }
    AppMethodBeat.o(202726);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202724);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202724);
    return i;
  }
  
  public final int getType()
  {
    return 3509;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(202725);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(202725);
      throw paramString;
    }
    paramq = ((b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicResponse");
      AppMethodBeat.o(202725);
      throw paramString;
    }
    this.zbL = ((dxs)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(202725);
      return;
    }
    AppMethodBeat.o(202725);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.j
 * JD-Core Version:    0.7.0.1
 */