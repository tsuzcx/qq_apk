package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private d iWh;
  public com.tencent.mm.protocal.protobuf.e iWi;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63375);
    b.a locala = new b.a();
    locala.hQF = new d();
    locala.hQG = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.iWh = ((d)this.gRX.hQD.hQJ);
    this.iWh.FIf = paramString2;
    this.iWh.FIe = paramString1;
    this.iWh.scene = paramInt;
    this.scene = paramInt;
    ae.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.iWh.FIe, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63375);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63376);
    ae.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(63376);
    return i;
  }
  
  public final int getType()
  {
    return 1530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63377);
    ae.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iWi = ((com.tencent.mm.protocal.protobuf.e)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iWi.dmy), this.iWi.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */