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
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class e
  extends w
{
  public String CAf;
  private aqg KoD;
  private aqh KoE;
  public String KoF;
  public String KoG;
  public int KoH;
  private h callback;
  private c nao;
  public String ytZ;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aqg();
    ((c.a)localObject).otF = new aqh();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.nao = ((c.a)localObject).bEF();
    this.KoD = ((aqg)c.b.b(this.nao.otB));
    this.KoD.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = k.iis();
    if (localObject != null)
    {
      this.KoD.latitude = ((bi)localObject).latitude;
      this.KoD.longitude = ((bi)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65049);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65049);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(283847);
    Log.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.KoE = ((aqh)c.c.b(((c)params).otC));
    this.CAf = this.KoE.CAf;
    this.ytZ = this.KoE.ytZ;
    this.KoH = this.KoE.ZxB;
    this.KoF = this.KoE.KoF;
    this.KoG = this.KoE.KoG;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.KoE.hAV, this.KoE.wYI, this);
    }
    AppMethodBeat.o(283847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */