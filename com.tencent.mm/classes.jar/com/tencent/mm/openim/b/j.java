package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f callback;
  public String dCg;
  private final b rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(151206);
    b.a locala = new b.a();
    locala.hNM = new bfi();
    locala.hNN = new bfj();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((bfi)this.rr.hNK.hNQ).userName = paramString;
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
    ad.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151208);
      return;
    }
    this.dCg = ((bfj)this.rr.hNL.hNQ).dCg;
    ad.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.dCg });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */