package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.ak.d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21717);
    Log.i("MicroMsg.NetSceneGetConnectInfo", "BackupGetConnectInfoNetScene init, url[%s], stack[%s]", new Object[] { paramString, Util.getStack() });
    d.a locala = new d.a();
    locala.iLN = new blp();
    locala.iLO = new blq();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.aXF();
    ((blp)this.rr.iLK.iLR).URL = paramString;
    AppMethodBeat.o(21717);
  }
  
  public final blq cgI()
  {
    return (blq)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21718);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(21718);
    return i;
  }
  
  public final int getType()
  {
    return 595;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21719);
    Log.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = cgI();
      com.tencent.mm.plugin.backup.b.d.aS(params.KLU.getBuffer().zy);
      Log.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[] { params.ID, params.KML, params.KMM, params.KME, params.KMF, Integer.valueOf(params.Scene), params.LUt });
      params.KLU.getBuffer();
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.e
 * JD-Core Version:    0.7.0.1
 */