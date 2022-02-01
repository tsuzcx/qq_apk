package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f callback;
  private b gPp;
  public ue pav;
  
  public j()
  {
    AppMethodBeat.i(63822);
    b.a locala = new b.a();
    locala.hNM = new ud();
    locala.hNN = new ue();
    locala.funcId = 1256;
    locala.uri = "/cgi-bin/mmpay-bin/f2fannounce";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    ad.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    AppMethodBeat.o(63822);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63823);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(63823);
    return i;
  }
  
  public final int getType()
  {
    return 1256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63824);
    ad.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.pav = ((ue)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.j
 * JD-Core Version:    0.7.0.1
 */