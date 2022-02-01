package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  private g callback;
  public String dqt;
  private final b rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(151206);
    b.a locala = new b.a();
    locala.hvt = new bbe();
    locala.hvu = new bbf();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((bbe)this.rr.hvr.hvw).userName = paramString;
    AppMethodBeat.o(151206);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151207);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151208);
      return;
    }
    this.dqt = ((bbf)this.rr.hvs.hvw).dqt;
    ac.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.dqt });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */