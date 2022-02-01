package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/CloseLiveRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/CloseLiveResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  public static final a gvH;
  private g callback;
  private b gvE;
  private xn gvF;
  private xo gvG;
  
  static
  {
    AppMethodBeat.i(189882);
    gvH = new a((byte)0);
    AppMethodBeat.o(189882);
  }
  
  public a(long paramLong, String paramString)
  {
    AppMethodBeat.i(189881);
    Object localObject = new b.a();
    ((b.a)localObject).c((com.tencent.mm.bw.a)new xn());
    ((b.a)localObject).d((com.tencent.mm.bw.a)new xo());
    ((b.a)localObject).op(3583);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/closelive");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    ac.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "close live id:" + paramLong + " wechatRoomId:" + paramString);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveRequest");
      AppMethodBeat.o(189881);
      throw paramString;
    }
    this.gvF = ((xn)localObject);
    this.gvF.DMV = paramLong;
    this.gvF.DMW = paramString;
    AppMethodBeat.o(189881);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(189879);
    ac.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189879);
    return i;
  }
  
  public final int getType()
  {
    return 3583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189880);
    ac.i("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(189880);
      throw paramString;
    }
    paramq = ((b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CloseLiveResponse");
      AppMethodBeat.o(189880);
      throw paramString;
    }
    this.gvG = ((xo)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.LiveNetScene.NetSceneCloseLive", "onGYNetEnd error");
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(189880);
      return;
    }
    AppMethodBeat.o(189880);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneCloseLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.a
 * JD-Core Version:    0.7.0.1
 */