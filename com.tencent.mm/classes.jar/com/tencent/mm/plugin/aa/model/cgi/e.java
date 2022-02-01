package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private g callback;
  private b iaa;
  private d iab;
  public com.tencent.mm.protocal.protobuf.e iac;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63375);
    b.a locala = new b.a();
    locala.gUU = new d();
    locala.gUV = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.iab = ((d)this.iaa.gUS.gUX);
    this.iab.Csj = paramString2;
    this.iab.Csi = paramString1;
    this.iab.scene = paramInt;
    this.scene = paramInt;
    ad.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.iab.Csi, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63375);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63376);
    ad.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iac = ((com.tencent.mm.protocal.protobuf.e)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iac.dcG), this.iac.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */