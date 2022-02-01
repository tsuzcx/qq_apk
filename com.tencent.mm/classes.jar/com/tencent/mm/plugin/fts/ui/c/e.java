package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private d iUB;
  private dof xeJ;
  
  public e(doe paramdoe)
  {
    AppMethodBeat.i(112160);
    d.a locala = new d.a();
    locala.iLN = paramdoe;
    this.xeJ = new dof();
    locala.iLO = this.xeJ;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.iUB = locala.aXF();
    Log.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramdoe.jfi, Long.valueOf(paramdoe.MRu), Integer.valueOf(paramdoe.Scene), Long.valueOf(paramdoe.MRu), Long.valueOf(paramdoe.MRz) });
    AppMethodBeat.o(112160);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112161);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.e
 * JD-Core Version:    0.7.0.1
 */