package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  public String oGs;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(112960);
    b.a locala = new b.a();
    locala.hQF = new bjc();
    locala.hQG = new bjd();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 1051;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((bjc)this.rr.hQD.hQJ).dJb = paramString;
    AppMethodBeat.o(112960);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112962);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112962);
    return i;
  }
  
  public final int getType()
  {
    return 1051;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112961);
    ae.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bjd)this.rr.hQE.hQJ;
      ae.v("MicroMsg.NetSceneGetShareCard", "json:" + paramq.oGs);
      this.oGs = paramq.oGs;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */