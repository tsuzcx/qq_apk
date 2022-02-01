package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private alh yRE;
  private ali yRF;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    d.a locala = new d.a();
    locala.iLN = new alh();
    locala.iLO = new ali();
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.hJu = locala.aXF();
    this.yRE = ((alh)this.hJu.iLK.iLR);
    this.yRE.yQE = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65037);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
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
    this.yRF = ((ali)((d)params).iLL.iLR);
    Log.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.yRF.dDN), this.yRF.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.yRF.dDN, this.yRF.qwn, this);
    }
    AppMethodBeat.o(65036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */