package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i heq;
  final d jof;
  
  public j(b paramb)
  {
    AppMethodBeat.i(151081);
    d.a locala = new d.a();
    bmx localbmx = new bmx();
    localbmx.KCO = 0;
    localbmx.LVy = paramb;
    locala.iLN = localbmx;
    locala.iLO = new bmy();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.funcId = 1126;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.jof = locala.aXF();
    AppMethodBeat.o(151081);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151082);
    Log.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    setHasCallbackToQueue(true);
    this.heq = parami;
    int i = dispatch(paramg, this.jof, this);
    AppMethodBeat.o(151082);
    return i;
  }
  
  public final int getType()
  {
    return 1126;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151083);
    Log.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, params.toString() });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */