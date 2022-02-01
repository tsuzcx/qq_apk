package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f gCo;
  final com.tencent.mm.ak.b isS;
  
  public j(com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(151081);
    b.a locala = new b.a();
    bbi localbbi = new bbi();
    localbbi.FJw = 0;
    localbbi.GRi = paramb;
    locala.hQF = localbbi;
    locala.hQG = new bbj();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.funcId = 1126;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.isS = locala.aDS();
    AppMethodBeat.o(151081);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151082);
    ae.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    setHasCallbackToQueue(true);
    this.gCo = paramf;
    int i = dispatch(parame, this.isS, this);
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
    ae.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */