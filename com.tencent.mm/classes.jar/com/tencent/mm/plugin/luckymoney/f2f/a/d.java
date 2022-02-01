package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends n
  implements com.tencent.mm.network.k, j
{
  private f callback;
  public String dmw;
  private b gRX;
  public String vwq;
  private ajb vxG;
  public ajc vxH;
  public String vxI;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ajb();
    ((b.a)localObject).hQG = new ajc();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.gRX = ((b.a)localObject).aDS();
    this.vxG = ((ajb)this.gRX.hQD.hQJ);
    this.vxG.pgV = paramInt1;
    this.vxG.xdJ = paramInt2;
    this.vxG.dPc = paramInt3;
    this.vxG.GyG = paramInt4;
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (localObject != null)
    {
      this.vxG.latitude = ((bb)localObject).latitude;
      this.vxG.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65046);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vxH = ((ajc)((b)paramq).hQE.hQJ);
    this.dmw = this.vxH.tsf;
    this.vwq = this.vxH.vwq;
    this.vxI = this.vxH.vCI;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */