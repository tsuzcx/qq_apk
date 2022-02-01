package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b gRX;
  public String qlv;
  public String vwq;
  private aiz vxJ;
  private aja vxK;
  public String vxL;
  public String vxM;
  public int vxN;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new aiz();
    ((b.a)localObject).hQG = new aja();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.gRX = ((b.a)localObject).aDS();
    this.vxJ = ((aiz)this.gRX.hQD.hQJ);
    this.vxJ.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (localObject != null)
    {
      this.vxJ.latitude = ((bb)localObject).latitude;
      this.vxJ.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(65049);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(65049);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65048);
    ae.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vxK = ((aja)((b)paramq).hQE.hQJ);
    this.vwq = this.vxK.vwq;
    this.qlv = this.vxK.qlv;
    this.vxN = this.vxK.GyF;
    this.vxL = this.vxK.vxL;
    this.vxM = this.vxK.vxM;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vxK.dmy, this.vxK.phe, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */