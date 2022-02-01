package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private ait vxp;
  private aiu vxq;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    b.a locala = new b.a();
    locala.hQF = new ait();
    locala.hQG = new aiu();
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.gRX = locala.aDS();
    this.vxp = ((ait)this.gRX.hQD.hQJ);
    this.vxp.vwq = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65037);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(65037);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65036);
    this.vxq = ((aiu)((b)paramq).hQE.hQJ);
    ae.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.vxq.dmy), this.vxq.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vxq.dmy, this.vxq.phe, this);
    }
    AppMethodBeat.o(65036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */