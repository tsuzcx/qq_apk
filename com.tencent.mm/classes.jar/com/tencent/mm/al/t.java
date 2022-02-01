package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
  extends n
  implements k
{
  private g callback;
  private String foE;
  private a<t> hys;
  com.tencent.mm.ak.b rr;
  
  private t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124117);
    this.foE = paramString1;
    ac.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new b.a();
    paramString1.funcId = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.hvt = new md();
    paramString1.hvu = new me();
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.aAz();
    paramString1 = (md)this.rr.hvr.hvw;
    paramString1.EaV = this.foE;
    paramString1.EaW = new com.tencent.mm.bw.b(bs.aLu(bs.nullAsNil(paramString2)));
    AppMethodBeat.o(124117);
  }
  
  public t(String paramString1, String paramString2, a<t> parama)
  {
    this(paramString1, paramString2);
    this.hys = parama;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124119);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124119);
    return i;
  }
  
  public final int getType()
  {
    return 1075;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124118);
    ac.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hys != null) {
      this.hys.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124118);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.t
 * JD-Core Version:    0.7.0.1
 */