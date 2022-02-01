package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private Runnable ips;
  public final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(55785);
    b.a locala = new b.a();
    locala.hQF = new aho();
    locala.hQG = new ahp();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.funcId = 491;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((aho)this.rr.hQD.hQJ).GxB = paramString;
    ae.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55785);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55786);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.ips != null) {
      this.ips.run();
    }
    AppMethodBeat.o(55787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */