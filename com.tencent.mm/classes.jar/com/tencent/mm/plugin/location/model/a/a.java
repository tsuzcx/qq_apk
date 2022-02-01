package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  private Runnable hTh;
  public final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(55785);
    b.a locala = new b.a();
    locala.hvt = new aev();
    locala.hvu = new aew();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.funcId = 491;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((aev)this.rr.hvr.hvw).Exq = paramString;
    ac.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55785);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55786);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55786);
    return i;
  }
  
  public final int getType()
  {
    return 491;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55787);
    ac.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hTh != null) {
      this.hTh.run();
    }
    AppMethodBeat.o(55787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */