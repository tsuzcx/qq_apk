package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dax;

public final class h
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public h(daw paramdaw)
  {
    AppMethodBeat.i(127835);
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = paramdaw;
    locala.hQG = new dax();
    locala.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
    locala.funcId = 433;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(127835);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127836);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127836);
    return i;
  }
  
  public final int getType()
  {
    return 433;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127837);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h
 * JD-Core Version:    0.7.0.1
 */