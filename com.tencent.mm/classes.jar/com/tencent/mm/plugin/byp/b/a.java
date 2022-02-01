package com.tencent.mm.plugin.byp.b;

import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMsgInfoClientId", "", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends p
  implements m
{
  public static final a waG = new a((byte)0);
  private static final Set<Long> waJ = Collections.synchronizedSet((Set)new HashSet());
  private h callback;
  private c nao;
  private final tv waH;
  private final tz waI;
  
  public a(int paramInt, tv paramtv)
  {
    this.waH = paramtv;
    this.waI = new tz();
    paramtv = new c.a();
    this.waI.YZJ = this.waH;
    this.waI.YZI = paramInt;
    paramtv.otE = ((com.tencent.mm.bx.a)this.waI);
    ua localua = new ua();
    localua.setBaseResponse(new kd());
    localua.getBaseResponse().akjO = new etl();
    paramtv.otF = ((com.tencent.mm.bx.a)localua);
    paramtv.uri = "/cgi-bin/micromsg-bin/bypsend";
    paramtv.funcId = 3862;
    paramtv = paramtv.bEF();
    kotlin.g.b.s.s(paramtv, "builder.buildInstance()");
    this.nao = paramtv;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ua paramua)
  {
    kotlin.g.b.s.u(paramua, "resp");
  }
  
  public void a(ua paramua)
  {
    kotlin.g.b.s.u(paramua, "resp");
  }
  
  public final tv din()
  {
    return this.waH;
  }
  
  public final c dio()
  {
    return this.nao;
  }
  
  public long dip()
  {
    return 0L;
  }
  
  public int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    waJ.add(Long.valueOf(dip()));
    return dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
  }
  
  public int getType()
  {
    return 3862;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    kotlin.g.b.s.u(params, "rr");
    params = c.c.b(this.nao.otC);
    if (params == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
    }
    params = (ua)params;
    Log.i("Byp.CgiBypSend", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " resp=" + params);
    waJ.remove(Long.valueOf(dip()));
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      a(params);
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      return;
      a(paramInt2, paramInt3, paramString, params);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "sendingSet", "", "", "kotlin.jvm.PlatformType", "", "getSendingSet", "()Ljava/util/Set;", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.a
 * JD-Core Version:    0.7.0.1
 */