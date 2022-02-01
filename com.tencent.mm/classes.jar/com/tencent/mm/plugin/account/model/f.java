package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private g callback;
  public b hdD;
  
  public f()
  {
    AppMethodBeat.i(193621);
    b.a locala = new b.a();
    locala.gUU = new ug();
    locala.gUV = new uh();
    locala.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
    locala.funcId = getType();
    this.hdD = locala.atI();
    AppMethodBeat.o(193621);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(193622);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(193622);
    return i;
  }
  
  public final int getType()
  {
    return 926;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193623);
    ad.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(193623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */