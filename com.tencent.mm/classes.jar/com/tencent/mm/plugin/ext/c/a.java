package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", "packageName", "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private final String djj;
  private g gfX;
  private final String packageName;
  public bfn qtf;
  private final g qtg;
  private final String signature;
  
  public a(String paramString1, String paramString2, String paramString3, g paramg)
  {
    AppMethodBeat.i(39602);
    this.djj = paramString1;
    this.packageName = paramString2;
    this.signature = paramString3;
    this.qtg = paramg;
    AppMethodBeat.o(39602);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(39601);
    this.gfX = paramg;
    paramg = new b.a();
    bfm localbfm = new bfm();
    localbfm.djj = this.djj;
    localbfm.oGB = this.packageName;
    localbfm.signature = this.signature;
    paramg.c((com.tencent.mm.bw.a)localbfm);
    this.qtf = new bfn();
    paramg.d((com.tencent.mm.bw.a)this.qtf);
    paramg.Am("/cgi-bin/mmbiz-bin/getuserauth");
    paramg.op(getType());
    paramg.or(0);
    paramg.os(0);
    paramg = paramg.aAz();
    d.g.b.k.g(paramg, "builder.buildInstance()");
    int i = dispatch(parame, (q)paramg, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(39601);
    return i;
  }
  
  public final int getType()
  {
    return 2711;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39600);
    paramq = this.qtg;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramq = this.gfX;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(39600);
      return;
    }
    AppMethodBeat.o(39600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.a
 * JD-Core Version:    0.7.0.1
 */