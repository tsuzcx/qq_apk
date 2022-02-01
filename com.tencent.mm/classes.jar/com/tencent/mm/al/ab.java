package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.sdk.platformtools.ac;

public final class ab
  extends n
  implements k
{
  private g callback;
  public String hyx;
  public b rr;
  
  public final bns aCS()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (bns)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124139);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124139);
    return i;
  }
  
  public final int getType()
  {
    return 672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124138);
    ac.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.ab
 * JD-Core Version:    0.7.0.1
 */