package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.bww;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", "packageName", "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class a
  extends q
  implements m
{
  private final String dNI;
  private i heq;
  private final String packageName;
  public bww sME;
  private final i sMF;
  private final String signature;
  
  public a(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(39602);
    this.dNI = paramString1;
    this.packageName = paramString2;
    this.signature = paramString3;
    this.sMF = parami;
    AppMethodBeat.o(39602);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(39601);
    this.heq = parami;
    parami = new d.a();
    bwv localbwv = new bwv();
    localbwv.dNI = this.dNI;
    localbwv.qGp = this.packageName;
    localbwv.signature = this.signature;
    parami.c((com.tencent.mm.bw.a)localbwv);
    this.sME = new bww();
    parami.d((com.tencent.mm.bw.a)this.sME);
    parami.MB("/cgi-bin/mmbiz-bin/getuserauth");
    parami.sG(getType());
    parami.sI(0);
    parami.sJ(0);
    parami = parami.aXF();
    p.g(parami, "builder.buildInstance()");
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(39601);
    return i;
  }
  
  public final int getType()
  {
    return 2711;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(39600);
    params = this.sMF;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    params = this.heq;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
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