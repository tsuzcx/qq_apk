package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  private g gfX;
  final com.tencent.mm.ak.b hWC;
  
  public j(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(151081);
    b.a locala = new b.a();
    awu localawu = new awu();
    localawu.DLT = 0;
    localawu.EOE = paramb;
    locala.hvt = localawu;
    locala.hvu = new awv();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.funcId = 1126;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hWC = locala.aAz();
    AppMethodBeat.o(151081);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151082);
    ac.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    setHasCallbackToQueue(true);
    this.gfX = paramg;
    int i = dispatch(parame, this.hWC, this);
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
    ac.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */