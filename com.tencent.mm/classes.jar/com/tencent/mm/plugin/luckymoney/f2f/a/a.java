package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class a
  extends w
{
  private aqa Kok;
  private aqb Kol;
  private h callback;
  private c nao;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    c.a locala = new c.a();
    locala.otE = new aqa();
    locala.otF = new aqb();
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.nao = locala.bEF();
    this.Kok = ((aqa)c.b.b(this.nao.otB));
    this.Kok.CAf = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65037);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(65037);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(283849);
    this.Kol = ((aqb)c.c.b(((c)params).otC));
    Log.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.Kol.hAV), this.Kol.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.Kol.hAV, this.Kol.wYI, this);
    }
    AppMethodBeat.o(283849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */