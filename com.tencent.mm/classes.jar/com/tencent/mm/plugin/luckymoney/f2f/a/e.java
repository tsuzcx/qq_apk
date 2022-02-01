package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private amo EvU;
  private amp EvV;
  public String EvW;
  public String EvX;
  public int EvY;
  private i callback;
  private d kwO;
  public String vhY;
  public String ybP;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new amo();
    ((d.a)localObject).lBV = new amp();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.kwO = ((d.a)localObject).bgN();
    this.EvU = ((amo)d.b.b(this.kwO.lBR));
    this.EvU.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = k.gJe();
    if (localObject != null)
    {
      this.EvU.latitude = ((bd)localObject).latitude;
      this.EvU.longitude = ((bd)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65049);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(65049);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65048);
    Log.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.EvV = ((amp)d.c.b(((d)params).lBS));
    this.ybP = this.EvV.ybP;
    this.vhY = this.EvV.vhY;
    this.EvY = this.EvV.SwR;
    this.EvW = this.EvV.EvW;
    this.EvX = this.EvV.EvX;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.EvV.fwx, this.EvV.tVo, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */