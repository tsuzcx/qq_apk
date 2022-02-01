package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends q
  implements m, j
{
  private i callback;
  public String dDL;
  private com.tencent.mm.ak.d hJu;
  public String yQE;
  private alp yRU;
  public alq yRV;
  public String yRW;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new alp();
    ((d.a)localObject).iLO = new alq();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.hJu = ((d.a)localObject).aXF();
    this.yRU = ((alp)this.hJu.iLK.iLR);
    this.yRU.qwe = paramInt1;
    this.yRU.Bbl = paramInt2;
    this.yRU.egY = paramInt3;
    this.yRU.Luu = paramInt4;
    localObject = k.fQy();
    if (localObject != null)
    {
      this.yRU.latitude = ((bf)localObject).latitude;
      this.yRU.longitude = ((bf)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65046);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(65046);
    return i;
  }
  
  public final int getType()
  {
    return 1970;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65045);
    Log.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.yRV = ((alq)((com.tencent.mm.ak.d)params).iLL.iLR);
    this.dDL = this.yRV.wFL;
    this.yQE = this.yRV.yQE;
    this.yRW = this.yRV.yXL;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */