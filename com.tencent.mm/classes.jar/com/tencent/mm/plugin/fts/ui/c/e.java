package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private dxx BQS;
  private i callback;
  private d lKU;
  
  public e(dxw paramdxw)
  {
    AppMethodBeat.i(112160);
    d.a locala = new d.a();
    locala.lBU = paramdxw;
    this.BQS = new dxx();
    locala.lBV = this.BQS;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.lKU = locala.bgN();
    Log.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramdxw.lVG, Long.valueOf(paramdxw.UdA), Integer.valueOf(paramdxw.CPw), Long.valueOf(paramdxw.UdA), Long.valueOf(paramdxw.UdF) });
    AppMethodBeat.o(112160);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112161);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(112161);
    return i;
  }
  
  public final int getType()
  {
    return 2678;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112162);
    Log.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.e
 * JD-Core Version:    0.7.0.1
 */