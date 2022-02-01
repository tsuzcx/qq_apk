package com.tencent.mm.plugin.ipcall.model.e;

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
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  private d rr;
  private dfh yrp;
  public dfi yrq;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(25454);
    this.rr = null;
    this.yrp = null;
    this.yrq = null;
    d.a locala = new d.a();
    locala.iLN = new dfh();
    locala.iLO = new dfi();
    locala.funcId = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrp = ((dfh)this.rr.iLK.iLR);
    this.yrp.MKj = paramString1;
    this.yrp.MKl = paramString2;
    this.yrp.MKn = paramString3;
    this.yrp.MKm = paramString4;
    this.yrp.MKo = paramInt;
    Log.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
    AppMethodBeat.o(25454);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25455);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25455);
    return i;
  }
  
  public final int getType()
  {
    return 807;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25456);
    Log.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrq = ((dfi)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.b
 * JD-Core Version:    0.7.0.1
 */