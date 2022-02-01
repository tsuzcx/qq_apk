package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends n
  implements k
{
  private g callback;
  public b hEg;
  
  public f()
  {
    AppMethodBeat.i(193209);
    b.a locala = new b.a();
    locala.hvt = new uq();
    locala.hvu = new ur();
    locala.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
    locala.funcId = getType();
    this.hEg = locala.aAz();
    AppMethodBeat.o(193209);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(193210);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(193210);
    return i;
  }
  
  public final int getType()
  {
    return 926;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193211);
    ac.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(193211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */