package com.tencent.mm.plugin.byp.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMsgInfoClientId", "", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public abstract class a
  extends n
  implements k
{
  private static final Set<Long> oBK = Collections.synchronizedSet((Set)new HashSet());
  public static final a oBL = new a((byte)0);
  private f callback;
  b gRX;
  private final rn oBI;
  final rj oBJ;
  
  public a(int paramInt, rj paramrj)
  {
    this.oBJ = paramrj;
    this.oBI = new rn();
    paramrj = new b.a();
    this.oBI.Gge = this.oBJ;
    this.oBI.Ggd = paramInt;
    paramrj.c((com.tencent.mm.bw.a)this.oBI);
    ro localro = new ro();
    localro.setBaseResponse(new BaseResponse());
    localro.getBaseResponse().ErrMsg = new cxn();
    paramrj.d((com.tencent.mm.bw.a)localro);
    paramrj.DN("/cgi-bin/micromsg-bin/bypsend");
    paramrj.oS(3862);
    paramrj = paramrj.aDS();
    p.g(paramrj, "builder.buildInstance()");
    this.gRX = paramrj;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ro paramro)
  {
    p.h(paramro, "resp");
  }
  
  public void a(ro paramro)
  {
    p.h(paramro, "resp");
  }
  
  public long bUh()
  {
    return 0L;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    oBK.add(Long.valueOf(bUh()));
    return dispatch(parame, (q)this.gRX, (k)this);
  }
  
  public int getType()
  {
    return 3862;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    p.h(paramq, "rr");
    paramq = this.gRX.aEV();
    if (paramq == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
    }
    paramq = (ro)paramq;
    ae.i("Byp.CgiBypSend", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " resp=" + paramq);
    oBK.remove(Long.valueOf(bUh()));
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      a(paramq);
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq != null) {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      return;
      a(paramInt2, paramInt3, paramString, paramq);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "sendingSet", "", "", "kotlin.jvm.PlatformType", "", "getSendingSet", "()Ljava/util/Set;", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.a
 * JD-Core Version:    0.7.0.1
 */