package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  public String pTY;
  private final d rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(112960);
    d.a locala = new d.a();
    locala.iLN = new bvf();
    locala.iLO = new bvg();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 1051;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bvf)this.rr.iLK.iLR).eaO = paramString;
    AppMethodBeat.o(112960);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112962);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112962);
    return i;
  }
  
  public final int getType()
  {
    return 1051;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112961);
    Log.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bvg)this.rr.iLL.iLR;
      Log.v("MicroMsg.NetSceneGetShareCard", "json:" + params.pTY);
      this.pTY = params.pTY;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */