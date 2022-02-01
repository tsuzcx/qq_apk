package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class u
  extends n
  implements k
{
  private f callback;
  private String fGM;
  private a<u> hQM;
  com.tencent.mm.al.b rr;
  
  private u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124117);
    this.fGM = paramString1;
    ad.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new b.a();
    paramString1.funcId = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.hNM = new ms();
    paramString1.hNN = new mt();
    paramString1.hNO = 0;
    paramString1.respCmdId = 0;
    this.rr = paramString1.aDC();
    paramString1 = (ms)this.rr.hNK.hNQ;
    paramString1.FGE = this.fGM;
    paramString1.FGF = new com.tencent.mm.bx.b(bt.aRa(bt.nullAsNil(paramString2)));
    AppMethodBeat.o(124117);
  }
  
  public u(String paramString1, String paramString2, a<u> parama)
  {
    this(paramString1, paramString2);
    this.hQM = parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124119);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hQM != null) {
      this.hQM.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124118);
  }
  
  public static abstract interface a<T extends n>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.u
 * JD-Core Version:    0.7.0.1
 */