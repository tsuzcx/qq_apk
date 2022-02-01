package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.m;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  private f callback;
  private final q hON;
  
  public l()
  {
    AppMethodBeat.i(134154);
    this.hON = new m();
    AppMethodBeat.o(134154);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(134155);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(134155);
    return i;
  }
  
  public final int getType()
  {
    return 381;
  }
  
  public final boolean needCheckCallback()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134156);
    ad.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.l
 * JD-Core Version:    0.7.0.1
 */