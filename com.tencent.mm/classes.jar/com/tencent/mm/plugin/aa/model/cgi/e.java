package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private d iAe;
  public com.tencent.mm.protocal.protobuf.e iAf;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63375);
    b.a locala = new b.a();
    locala.hvt = new d();
    locala.hvu = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAe = ((d)this.gvE.hvr.hvw);
    this.iAe.DKB = paramString2;
    this.iAe.DKA = paramString1;
    this.iAe.scene = paramInt;
    this.scene = paramInt;
    ac.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.iAe.DKA, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63375);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63376);
    ac.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAf = ((com.tencent.mm.protocal.protobuf.e)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iAf.dae), this.iAf.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */