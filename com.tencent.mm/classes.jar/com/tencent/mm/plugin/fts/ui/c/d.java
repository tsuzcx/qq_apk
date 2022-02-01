package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d iUB;
  public dsz xeI;
  
  public d(dsy paramdsy)
  {
    AppMethodBeat.i(112157);
    d.a locala = new d.a();
    locala.iLN = paramdsy;
    locala.iLO = new dsz();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/searchwxa";
    locala.funcId = 2599;
    this.iUB = locala.aXF();
    Log.i("MicroMsg.FTS.NetSceneWeAppSearch", "Query %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramdsy.KXA, Long.valueOf(paramdsy.MVa), Long.valueOf(paramdsy.MRu), Long.valueOf(paramdsy.MRz) });
    AppMethodBeat.o(112157);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112158);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(112158);
    return i;
  }
  
  public final int getType()
  {
    return 2599;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112159);
    Log.i("MicroMsg.FTS.NetSceneWeAppSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xeI = ((dsz)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.d
 * JD-Core Version:    0.7.0.1
 */