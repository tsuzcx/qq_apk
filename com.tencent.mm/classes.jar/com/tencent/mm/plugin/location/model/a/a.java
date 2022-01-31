package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private Runnable fQa;
  public final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(113409);
    b.a locala = new b.a();
    locala.fsX = new aah();
    locala.fsY = new aai();
    locala.uri = "/cgi-bin/micromsg-bin/exittrackroom";
    locala.funcId = 491;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((aah)this.rr.fsV.fta).wQX = paramString;
    ab.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(113409);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(113410);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(113410);
    return i;
  }
  
  public final int getType()
  {
    return 491;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113411);
    ab.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.fQa != null) {
      this.fQa.run();
    }
    AppMethodBeat.o(113411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.a
 * JD-Core Version:    0.7.0.1
 */