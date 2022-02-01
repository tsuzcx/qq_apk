package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class g
  extends w
{
  public int KJh;
  private cdx KJi;
  private cdy KJj;
  private h callback;
  private final c rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(262371);
    c.a locala = new c.a();
    locala.otE = new cdx();
    locala.otF = new cdy();
    locala.funcId = 4362;
    locala.uri = "/cgi-bin/micromsg-bin/getallfunction";
    this.rr = locala.bEF();
    this.KJi = ((cdx)c.b.b(this.rr.otB));
    this.KJh = paramInt;
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", new Object[] { Integer.valueOf(this.KJh) });
    this.KJi.YMC = this.KJh;
    AppMethodBeat.o(262371);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(262377);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(262377);
    return i;
  }
  
  public final int getType()
  {
    return 4362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(262379);
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.KJj = ((cdy)c.c.b(((c)params).otC));
      if (this.KJj != null) {
        b.a(this.KJj);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(262379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */