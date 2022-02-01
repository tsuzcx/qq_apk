package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.model.w;

public final class d
  extends w
  implements j
{
  public String CAf;
  private aqi KoA;
  public aqj KoB;
  public String KoC;
  private h callback;
  public String hAT;
  private c nao;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aqi();
    ((c.a)localObject).otF = new aqj();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.nao = ((c.a)localObject).bEF();
    this.KoA = ((aqi)c.b.b(this.nao.otB));
    this.KoA.wYz = paramInt1;
    this.KoA.MSL = paramInt2;
    this.KoA.ihy = paramInt3;
    this.KoA.ZxC = paramInt4;
    localObject = k.iis();
    if (localObject != null)
    {
      this.KoA.latitude = ((bi)localObject).latitude;
      this.KoA.longitude = ((bi)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65046);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65046);
    return i;
  }
  
  public final int getType()
  {
    return 1970;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(283848);
    Log.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.KoB = ((aqj)c.c.b(((c)params).otC));
    this.hAT = this.KoB.Hgk;
    this.CAf = this.KoB.CAf;
    this.KoC = this.KoB.KuQ;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(283848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */