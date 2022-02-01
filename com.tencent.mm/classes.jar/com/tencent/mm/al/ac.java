package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac
  extends q
  implements m
{
  public String brandUsername;
  private i callback;
  public d rr;
  
  public final cfq bad()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (cfq)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124139);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124139);
    return i;
  }
  
  public final int getType()
  {
    return 672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124138);
    Log.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.ac
 * JD-Core Version:    0.7.0.1
 */