package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public b hWL;
  
  public f()
  {
    AppMethodBeat.i(207105);
    b.a locala = new b.a();
    locala.hNM = new wp();
    locala.hNN = new wq();
    locala.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
    locala.funcId = getType();
    this.hWL = locala.aDC();
    AppMethodBeat.o(207105);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(207106);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(207106);
    return i;
  }
  
  public final int getType()
  {
    return 926;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207107);
    ad.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(207107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */