package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class x
  extends n
  implements k
{
  private f callback;
  private String oGC;
  private final b rr;
  
  public x()
  {
    AppMethodBeat.i(112828);
    this.oGC = "";
    b.a locala = new b.a();
    locala.hQF = new ayr();
    locala.hQG = new ays();
    locala.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
    locala.funcId = 1046;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(112828);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112829);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112829);
    return i;
  }
  
  public final int getType()
  {
    return 1046;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112830);
    ae.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.oGC = ((ays)this.rr.hQE.hQJ).oGs;
      g.ajR().ajA().set(282885, this.oGC);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.x
 * JD-Core Version:    0.7.0.1
 */