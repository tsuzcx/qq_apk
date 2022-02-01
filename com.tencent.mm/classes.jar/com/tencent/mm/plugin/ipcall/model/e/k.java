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
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i callback;
  private d rr;
  public dfo yrI;
  public dfp yrJ;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25481);
    this.rr = null;
    this.yrI = null;
    this.yrJ = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new dfo();
    locala.iLO = new dfp();
    locala.funcId = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrI = ((dfo)this.rr.iLK.iLR);
    this.yrI.LsZ = paramInt;
    this.yrI.Lta = paramLong1;
    this.yrI.MKi = paramLong2;
    AppMethodBeat.o(25481);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25482);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25482);
    return i;
  }
  
  public final int getType()
  {
    return 726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25483);
    Log.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrJ = ((dfp)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.k
 * JD-Core Version:    0.7.0.1
 */