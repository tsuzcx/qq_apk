package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b gvE;
  public String pBl;
  public String uhB;
  private afz uiW;
  private aga uiX;
  public String uiY;
  public String uiZ;
  public int uja;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new afz();
    ((b.a)localObject).hvu = new aga();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.gvE = ((b.a)localObject).aAz();
    this.uiW = ((afz)this.gvE.hvr.hvw);
    this.uiW.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (localObject != null)
    {
      this.uiW.latitude = ((bb)localObject).latitude;
      this.uiW.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(65049);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uiX = ((aga)((b)paramq).hvs.hvw);
    this.uhB = this.uiX.uhB;
    this.pBl = this.uiX.pBl;
    this.uja = this.uiX.Eyk;
    this.uiY = this.uiX.uiY;
    this.uiZ = this.uiX.uiZ;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.uiX.dae, this.uiX.oxf, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */