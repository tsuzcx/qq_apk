package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  public int EOJ;
  private bpg EOK;
  private bph EOL;
  private i callback;
  private final d rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(187192);
    d.a locala = new d.a();
    locala.lBU = new bpg();
    locala.lBV = new bph();
    locala.funcId = 4362;
    locala.uri = "/cgi-bin/micromsg-bin/getallfunction";
    this.rr = locala.bgN();
    this.EOK = ((bpg)d.b.b(this.rr.lBR));
    this.EOJ = paramInt;
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", new Object[] { Integer.valueOf(this.EOJ) });
    this.EOK.RPp = this.EOJ;
    AppMethodBeat.o(187192);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(187195);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(187195);
    return i;
  }
  
  public final int getType()
  {
    return 4362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187208);
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.EOL = ((bph)d.c.b(((d)params).lBS));
      if (this.EOL != null) {
        b.a(this.EOL);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */