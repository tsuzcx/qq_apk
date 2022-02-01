package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends q
  implements m, j
{
  private amq EvR;
  public amr EvS;
  public String EvT;
  private i callback;
  public String fwv;
  private com.tencent.mm.an.d kwO;
  public String ybP;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new amq();
    ((d.a)localObject).lBV = new amr();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.kwO = ((d.a)localObject).bgN();
    this.EvR = ((amq)d.b.b(this.kwO.lBR));
    this.EvR.tVd = paramInt1;
    this.EvR.GVj = paramInt2;
    this.EvR.gbo = paramInt3;
    this.EvR.SwS = paramInt4;
    localObject = k.gJe();
    if (localObject != null)
    {
      this.EvR.latitude = ((bd)localObject).latitude;
      this.EvR.longitude = ((bd)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65046);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.EvS = ((amr)d.c.b(((com.tencent.mm.an.d)params).lBS));
    this.fwv = this.EvS.ByI;
    this.ybP = this.EvS.ybP;
    this.EvT = this.EvS.EBP;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */