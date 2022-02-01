package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;

public final class aa
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65275);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65275);
    return i;
  }
  
  public final int getType()
  {
    return 980;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65276);
    ac.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aa
 * JD-Core Version:    0.7.0.1
 */