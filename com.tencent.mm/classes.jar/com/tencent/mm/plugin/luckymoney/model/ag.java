package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65275);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(65275);
    return i;
  }
  
  public final int getType()
  {
    return 980;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65276);
    Log.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ag
 * JD-Core Version:    0.7.0.1
 */