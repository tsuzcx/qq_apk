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
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private ami EvC;
  private amj EvD;
  private i callback;
  private d kwO;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    d.a locala = new d.a();
    locala.lBU = new ami();
    locala.lBV = new amj();
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.kwO = locala.bgN();
    this.EvC = ((ami)d.b.b(this.kwO.lBR));
    this.EvC.ybP = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65037);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(65037);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65036);
    this.EvD = ((amj)d.c.b(((d)params).lBS));
    Log.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.EvD.fwx), this.EvD.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.EvD.fwx, this.EvD.tVo, this);
    }
    AppMethodBeat.o(65036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */