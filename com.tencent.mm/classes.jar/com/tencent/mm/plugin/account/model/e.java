package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  private g callback;
  public String eNf;
  private b hEg;
  
  public e(String paramString)
  {
    AppMethodBeat.i(193206);
    b.a locala = new b.a();
    ud localud = new ud();
    localud.eNf = paramString;
    this.eNf = paramString;
    locala.hvt = localud;
    locala.hvu = new ue();
    locala.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
    locala.funcId = getType();
    this.hEg = locala.aAz();
    AppMethodBeat.o(193206);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(193207);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(193207);
    return i;
  }
  
  public final int getType()
  {
    return 3516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193208);
    ac.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(193208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */