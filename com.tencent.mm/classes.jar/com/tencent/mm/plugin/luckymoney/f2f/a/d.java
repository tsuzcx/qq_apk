package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends n
  implements com.tencent.mm.network.k, j
{
  private g callback;
  public String dac;
  private b gvE;
  public String uhB;
  private agb uiT;
  private agc uiU;
  public String uiV;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new agb();
    ((b.a)localObject).hvu = new agc();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.gvE = ((b.a)localObject).aAz();
    this.uiT = ((agb)this.gvE.hvr.hvw);
    this.uiT.owW = paramInt1;
    this.uiT.vGO = paramInt2;
    this.uiT.dBz = paramInt3;
    this.uiT.Eyl = paramInt4;
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (localObject != null)
    {
      this.uiT.latitude = ((bb)localObject).latitude;
      this.uiT.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65046);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(65046);
    return i;
  }
  
  public final int getType()
  {
    return 1970;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65045);
    ac.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uiU = ((agc)((b)paramq).hvs.hvw);
    this.dac = this.uiU.skK;
    this.uhB = this.uiU.uhB;
    this.uiV = this.uiU.unZ;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */