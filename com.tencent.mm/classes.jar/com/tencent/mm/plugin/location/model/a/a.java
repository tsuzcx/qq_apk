package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private Runnable jkz;
  public final d rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(55785);
    d.a locala = new d.a();
    locala.iLN = new aka();
    locala.iLO = new akb();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.funcId = 491;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((aka)this.rr.iLK.iLR).Ltk = paramString;
    Log.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55785);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(55786);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55786);
    return i;
  }
  
  public final int getType()
  {
    return 491;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55787);
    Log.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.jkz != null) {
      this.jkz.run();
    }
    AppMethodBeat.o(55787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */