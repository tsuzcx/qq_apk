package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21717);
    Log.i("MicroMsg.NetSceneGetConnectInfo", "BackupGetConnectInfoNetScene init, url[%s], stack[%s]", new Object[] { paramString, Util.getStack() });
    d.a locala = new d.a();
    locala.lBU = new bsy();
    locala.lBV = new bsz();
    locala.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
    locala.lBW = 0;
    locala.respCmdId = 0;
    locala.funcId = 595;
    this.rr = locala.bgN();
    ((bsy)d.b.b(this.rr.lBR)).URL = paramString;
    AppMethodBeat.o(21717);
  }
  
  public final bsz ctU()
  {
    AppMethodBeat.i(288447);
    bsz localbsz = (bsz)d.c.b(this.rr.lBS);
    AppMethodBeat.o(288447);
    return localbsz;
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
      params = ctU();
      com.tencent.mm.plugin.backup.b.d.bf(params.RMR.Tkb.UH);
      Log.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", new Object[] { params.ID, params.RNF, params.RNG, params.RNy, params.RNz, Integer.valueOf(params.CPw), params.Tdb });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.e
 * JD-Core Version:    0.7.0.1
 */