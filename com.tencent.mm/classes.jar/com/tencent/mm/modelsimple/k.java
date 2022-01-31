package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.l;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private final q ftU;
  
  public k()
  {
    AppMethodBeat.i(123430);
    this.ftU = new l();
    AppMethodBeat.o(123430);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(123431);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(123431);
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
    AppMethodBeat.i(123432);
    ab.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(123432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k
 * JD-Core Version:    0.7.0.1
 */