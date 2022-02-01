package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(90685);
    b.a locala = new b.a();
    locala.hNM = new adw();
    locala.hNN = new adx();
    locala.uri = "/cgi-bin/micromsg-bin/deletecardimg";
    locala.funcId = 576;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((adw)this.rr.hNK.hNQ).Gcl = paramString;
    AppMethodBeat.o(90685);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(90686);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(90686);
    return i;
  }
  
  public final int getType()
  {
    return 576;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90687);
    ad.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */