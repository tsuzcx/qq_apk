package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends m
  implements k
{
  private f callback;
  public String nXY;
  private final com.tencent.mm.ai.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(22524);
    this.nXY = null;
    b.a locala = new b.a();
    locala.fsX = new ws();
    locala.fsY = new wt();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.nXY = paramString;
    AppMethodBeat.o(22524);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(22526);
    this.callback = paramf;
    ws localws = (ws)this.rr.fsV.fta;
    localws.wOV = this.nXY;
    if ((this.nXY != null) && (!bo.isNullOrNil(this.nXY)))
    {
      localws.wOV = this.nXY;
      localws.wOV = this.nXY;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(22526);
      return i;
    }
    ab.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(22526);
    return 0;
  }
  
  public final int getType()
  {
    return 636;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22525);
    ab.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */