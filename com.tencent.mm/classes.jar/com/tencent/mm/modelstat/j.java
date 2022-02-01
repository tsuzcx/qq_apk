package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f gzH;
  final com.tencent.mm.al.b ipX;
  
  public j(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(151081);
    b.a locala = new b.a();
    bas localbas = new bas();
    localbas.FqY = 0;
    localbas.GxI = paramb;
    locala.hNM = localbas;
    locala.hNN = new bat();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.funcId = 1126;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.ipX = locala.aDC();
    AppMethodBeat.o(151081);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151082);
    ad.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    setHasCallbackToQueue(true);
    this.gzH = paramf;
    int i = dispatch(parame, this.ipX, this);
    AppMethodBeat.o(151082);
    return i;
  }
  
  public final int getType()
  {
    return 1126;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151083);
    ad.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */