package com.tencent.mm.live.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "msgId", "micId", "micSdkId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gwn;
  private g callback;
  private b gvE;
  private xl gwl;
  private xm gwm;
  
  static
  {
    AppMethodBeat.i(189922);
    gwn = new a((byte)0);
    AppMethodBeat.o(189922);
  }
  
  public k(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189921);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new xl());
    ((b.a)localObject).d((a)new xm());
    ((b.a)localObject).op(3509);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/closelivemic");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicRequest");
      AppMethodBeat.o(189921);
      throw paramString1;
    }
    this.gwl = ((xl)localObject);
    this.gwl.DMV = paramLong;
    this.gwl.DMW = paramString1;
    this.gwl.DMX = paramString2;
    if (!TextUtils.isEmpty((CharSequence)paramString3)) {
      this.gwl.DMY = paramString3;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString4)) {
      this.gwl.ErH = paramString4;
    }
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", msgId:" + paramString2 + ", micId:" + paramString3 + ", micSdkId:" + paramString4);
    AppMethodBeat.o(189921);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189919);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189919);
    return i;
  }
  
  public final int getType()
  {
    return 3509;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189920);
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189920);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicResponse");
      AppMethodBeat.o(189920);
      throw paramString;
    }
    this.gwm = ((xm)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189920);
      return;
    }
    AppMethodBeat.o(189920);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.k
 * JD-Core Version:    0.7.0.1
 */