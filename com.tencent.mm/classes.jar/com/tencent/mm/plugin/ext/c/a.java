package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cem;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ext/net/NetSceneGetUserAuth;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "appid", "", "packageName", "signature", "mIOnNetSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "mCallback", "<set-?>", "Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "resp", "getResp", "()Lcom/tencent/mm/protocal/protobuf/GetUserAuthResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class a
  extends q
  implements m
{
  private final String appid;
  private i jQg;
  private final String packageName;
  private final String signature;
  private final i wsA;
  public cem wsz;
  
  public a(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(39602);
    this.appid = paramString1;
    this.packageName = paramString2;
    this.signature = paramString3;
    this.wsA = parami;
    AppMethodBeat.o(39602);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(39601);
    this.jQg = parami;
    parami = new d.a();
    cel localcel = new cel();
    localcel.appid = this.appid;
    localcel.ufq = this.packageName;
    localcel.signature = this.signature;
    parami.c((com.tencent.mm.cd.a)localcel);
    this.wsz = new cem();
    parami.d((com.tencent.mm.cd.a)this.wsz);
    parami.TW("/cgi-bin/mmbiz-bin/getuserauth");
    parami.vD(getType());
    parami.vF(0);
    parami.vG(0);
    parami = parami.bgN();
    p.j(parami, "builder.buildInstance()");
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
    params = this.wsA;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    params = this.jQg;
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