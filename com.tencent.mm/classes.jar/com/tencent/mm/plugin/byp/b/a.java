package com.tencent.mm.plugin.byp.b;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMsgInfoClientId", "", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public abstract class a
  extends q
  implements m
{
  private static final Set<Long> pPw = Collections.synchronizedSet((Set)new HashSet());
  public static final a pPx = new a((byte)0);
  private i callback;
  d hJu;
  private final sq pPu;
  final sm pPv;
  
  public a(int paramInt, sm paramsm)
  {
    this.pPv = paramsm;
    this.pPu = new sq();
    paramsm = new d.a();
    this.pPu.LaH = this.pPv;
    this.pPu.LaG = paramInt;
    paramsm.c((com.tencent.mm.bw.a)this.pPu);
    sr localsr = new sr();
    localsr.setBaseResponse(new BaseResponse());
    localsr.getBaseResponse().ErrMsg = new dqi();
    paramsm.d((com.tencent.mm.bw.a)localsr);
    paramsm.MB("/cgi-bin/micromsg-bin/bypsend");
    paramsm.sG(3862);
    paramsm = paramsm.aXF();
    p.g(paramsm, "builder.buildInstance()");
    this.hJu = paramsm;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, sr paramsr)
  {
    p.h(paramsr, "resp");
  }
  
  public void a(sr paramsr)
  {
    p.h(paramsr, "resp");
  }
  
  public long crU()
  {
    return 0L;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    pPw.add(Long.valueOf(crU()));
    return dispatch(paramg, (s)this.hJu, (m)this);
  }
  
  public int getType()
  {
    return 3862;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    p.h(params, "rr");
    params = this.hJu.aYK();
    if (params == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
    }
    params = (sr)params;
    Log.i("Byp.CgiBypSend", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " resp=" + params);
    pPw.remove(Long.valueOf(crU()));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "sendingSet", "", "", "kotlin.jvm.PlatformType", "", "getSendingSet", "()Ljava/util/Set;", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.a
 * JD-Core Version:    0.7.0.1
 */