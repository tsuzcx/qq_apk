package com.tencent.mm.plugin.byp.b;

import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMsgInfoClientId", "", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public abstract class a
  extends q
  implements m
{
  private static final Set<Long> sWy = Collections.synchronizedSet((Set)new HashSet());
  public static final a sWz = new a((byte)0);
  private i callback;
  private d kwO;
  private final sj sWw;
  private final sf sWx;
  
  public a(int paramInt, sf paramsf)
  {
    this.sWx = paramsf;
    this.sWw = new sj();
    paramsf = new d.a();
    this.sWw.SbQ = this.sWx;
    this.sWw.SbP = paramInt;
    paramsf.c((com.tencent.mm.cd.a)this.sWw);
    sk localsk = new sk();
    localsk.setBaseResponse(new jh());
    localsk.getBaseResponse().Tef = new eaf();
    paramsf.d((com.tencent.mm.cd.a)localsk);
    paramsf.TW("/cgi-bin/micromsg-bin/bypsend");
    paramsf.vD(3862);
    paramsf = paramsf.bgN();
    p.j(paramsf, "builder.buildInstance()");
    this.kwO = paramsf;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, sk paramsk)
  {
    p.k(paramsk, "resp");
  }
  
  public void a(sk paramsk)
  {
    p.k(paramsk, "resp");
  }
  
  public final d bhU()
  {
    return this.kwO;
  }
  
  public long cFd()
  {
    return 0L;
  }
  
  public final sf cFe()
  {
    return this.sWx;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    sWy.add(Long.valueOf(cFd()));
    return dispatch(paramg, (s)this.kwO, (m)this);
  }
  
  public int getType()
  {
    return 3862;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    p.k(params, "rr");
    params = this.kwO.bhY();
    if (params == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
    }
    params = (sk)params;
    Log.i("Byp.CgiBypSend", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " resp=" + params);
    sWy.remove(Long.valueOf(cFd()));
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      a(params);
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      return;
      a(paramInt2, paramInt3, paramString, params);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "sendingSet", "", "", "kotlin.jvm.PlatformType", "", "getSendingSet", "()Ljava/util/Set;", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.a
 * JD-Core Version:    0.7.0.1
 */