package com.tencent.mm.openim.b;

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
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f callback;
  public String dDl;
  private final b rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(151206);
    b.a locala = new b.a();
    locala.hQF = new bfy();
    locala.hQG = new bfz();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((bfy)this.rr.hQD.hQJ).userName = paramString;
    AppMethodBeat.o(151206);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151207);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151207);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151208);
    ae.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151208);
      return;
    }
    this.dDl = ((bfz)this.rr.hQE.hQJ).dDl;
    ae.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.dDl });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */