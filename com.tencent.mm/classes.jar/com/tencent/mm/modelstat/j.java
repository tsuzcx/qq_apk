package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends m
  implements k
{
  private f eGj;
  final com.tencent.mm.ai.b fTs;
  
  public j(com.tencent.mm.bv.b paramb)
  {
    AppMethodBeat.i(78737);
    b.a locala = new b.a();
    akc localakc = new akc();
    localakc.wlo = 0;
    localakc.xbn = paramb;
    locala.fsX = localakc;
    locala.fsY = new akd();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.funcId = 1126;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fTs = locala.ado();
    AppMethodBeat.o(78737);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78738);
    ab.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    setHasCallbackToQueue(true);
    this.eGj = paramf;
    int i = dispatch(parame, this.fTs, this);
    AppMethodBeat.o(78738);
    return i;
  }
  
  public final int getType()
  {
    return 1126;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78739);
    ab.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */