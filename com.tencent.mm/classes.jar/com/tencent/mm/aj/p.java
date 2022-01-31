package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class p
  extends m
  implements k
{
  private f callback;
  private String eaX;
  private p.a<p> fwN;
  com.tencent.mm.ai.b rr;
  
  private p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11432);
    this.eaX = paramString1;
    ab.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new b.a();
    paramString1.funcId = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.fsX = new ki();
    paramString1.fsY = new kj();
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.ado();
    paramString1 = (ki)this.rr.fsV.fta;
    paramString1.wxM = this.eaX;
    paramString1.wxN = new com.tencent.mm.bv.b(bo.apQ(bo.nullAsNil(paramString2)));
    AppMethodBeat.o(11432);
  }
  
  public p(String paramString1, String paramString2, p.a<p> parama)
  {
    this(paramString1, paramString2);
    this.fwN = parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11434);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11434);
    return i;
  }
  
  public final int getType()
  {
    return 1075;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11433);
    ab.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.fwN != null) {
      this.fwN.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aj.p
 * JD-Core Version:    0.7.0.1
 */