package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", "packageName", "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class a
  extends n
  implements k
{
  private final String duW;
  private f gzH;
  private final String packageName;
  public bjv rcT;
  private final f rcU;
  private final String signature;
  
  public a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(39602);
    this.duW = paramString1;
    this.packageName = paramString2;
    this.signature = paramString3;
    this.rcU = paramf;
    AppMethodBeat.o(39602);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(39601);
    this.gzH = paramf;
    paramf = new b.a();
    bju localbju = new bju();
    localbju.duW = this.duW;
    localbju.pkf = this.packageName;
    localbju.signature = this.signature;
    paramf.c((com.tencent.mm.bx.a)localbju);
    this.rcT = new bjv();
    paramf.d((com.tencent.mm.bx.a)this.rcT);
    paramf.Dl("/cgi-bin/mmbiz-bin/getuserauth");
    paramf.oP(getType());
    paramf.oR(0);
    paramf.oS(0);
    paramf = paramf.aDC();
    p.g(paramf, "builder.buildInstance()");
    int i = dispatch(parame, (q)paramf, (k)this);
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
    paramq = this.rcU;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    paramq = this.gzH;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(39600);
      return;
    }
    AppMethodBeat.o(39600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.a
 * JD-Core Version:    0.7.0.1
 */