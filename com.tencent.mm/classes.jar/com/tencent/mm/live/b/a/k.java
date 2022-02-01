package com.tencent.mm.live.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "msgId", "micId", "micSdkId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveMicResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gSG;
  private f callback;
  private b gRX;
  private zn gSE;
  private zo gSF;
  
  static
  {
    AppMethodBeat.i(215828);
    gSG = new a((byte)0);
    AppMethodBeat.o(215828);
  }
  
  public k(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(215827);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new zn());
    ((b.a)localObject).d((a)new zo());
    ((b.a)localObject).oS(3509);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/closelivemic");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicRequest");
      AppMethodBeat.o(215827);
      throw paramString1;
    }
    this.gSE = ((zn)localObject);
    this.gSE.FKy = paramLong;
    this.gSE.FKz = paramString1;
    this.gSE.FKA = paramString2;
    if (!TextUtils.isEmpty((CharSequence)paramString3)) {
      this.gSE.FKB = paramString3;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString4)) {
      this.gSE.Grp = paramString4;
    }
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "liveId:" + paramLong + ", wechatRoomId:" + paramString1 + ", msgId:" + paramString2 + ", micId:" + paramString3 + ", micSdkId:" + paramString4);
    AppMethodBeat.o(215827);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215825);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(215825);
    return i;
  }
  
  public final int getType()
  {
    return 3509;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215826);
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(215826);
      throw paramString;
    }
    paramq = ((b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveMicResponse");
      AppMethodBeat.o(215826);
      throw paramString;
    }
    this.gSF = ((zo)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveCloseLiveMic", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(215826);
      return;
    }
    AppMethodBeat.o(215826);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveCloseLiveMic$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.k
 * JD-Core Version:    0.7.0.1
 */