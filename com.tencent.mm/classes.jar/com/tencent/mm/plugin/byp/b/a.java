package com.tencent.mm.plugin.byp.b;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "bizType", "", "pack", "Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "(ILcom/tencent/mm/protocal/protobuf/BypMsgPack;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getPack", "()Lcom/tencent/mm/protocal/protobuf/BypMsgPack;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/BypSendRequest;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/BypSendResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onSendFailed", "resp", "onSendSuccessfully", "Companion", "plugin-byp_release"})
public abstract class a
  extends n
  implements k
{
  public static final a ovk = new a((byte)0);
  private f callback;
  b gPp;
  private final rl ovi;
  final rh ovj;
  
  public a(int paramInt, rh paramrh)
  {
    this.ovj = paramrh;
    this.ovi = new rl();
    paramrh = new b.a();
    this.ovi.FNF = this.ovj;
    this.ovi.FNE = paramInt;
    paramrh.c((com.tencent.mm.bx.a)this.ovi);
    rm localrm = new rm();
    localrm.setBaseResponse(new BaseResponse());
    localrm.getBaseResponse().ErrMsg = new cwt();
    paramrh.d((com.tencent.mm.bx.a)localrm);
    paramrh.Dl("/cgi-bin/micromsg-bin/bypsend");
    paramrh.oP(3862);
    paramrh = paramrh.aDC();
    p.g(paramrh, "builder.buildInstance()");
    this.gPp = paramrh;
  }
  
  public void a(int paramInt1, int paramInt2, rm paramrm)
  {
    p.h(paramrm, "resp");
  }
  
  public void a(rm paramrm)
  {
    p.h(paramrm, "resp");
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    return dispatch(parame, (q)this.gPp, (k)this);
  }
  
  public int getType()
  {
    return 3862;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    p.h(paramq, "rr");
    paramq = this.gPp.aEF();
    if (paramq == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BypSendResponse");
    }
    paramq = (rm)paramq;
    ad.i("Byp.CgiBypSend", "[onCgiBack] errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString + " resp=" + paramq);
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
      a(paramInt2, paramInt3, paramq);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSend$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.a
 * JD-Core Version:    0.7.0.1
 */