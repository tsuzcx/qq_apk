package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
  extends m
  implements k
{
  private f callback;
  public String fwO;
  public b rr;
  
  public final ayq afe()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (ayq)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11454);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11454);
    return i;
  }
  
  public final int getType()
  {
    return 672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11453);
    ab.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.v
 * JD-Core Version:    0.7.0.1
 */