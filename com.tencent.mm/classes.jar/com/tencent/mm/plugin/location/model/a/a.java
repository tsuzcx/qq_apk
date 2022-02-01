package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private Runnable imy;
  public final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(55785);
    b.a locala = new b.a();
    locala.hNM = new ahe();
    locala.hNN = new ahf();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.funcId = 491;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((ahe)this.rr.hNK.hNQ).GeT = paramString;
    ad.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(paramString)));
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
    ad.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.imy != null) {
      this.imy.run();
    }
    AppMethodBeat.o(55787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */