package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public b hZD;
  
  public f()
  {
    AppMethodBeat.i(188396);
    b.a locala = new b.a();
    locala.hQF = new ws();
    locala.hQG = new wt();
    locala.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
    locala.funcId = getType();
    this.hZD = locala.aDS();
    AppMethodBeat.o(188396);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(188397);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(188397);
    return i;
  }
  
  public final int getType()
  {
    return 926;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188398);
    ae.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(188398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */