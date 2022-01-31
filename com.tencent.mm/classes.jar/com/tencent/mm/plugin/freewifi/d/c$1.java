package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;

final class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(20778);
    this.mKX.b(this.fuc, this.val$errType, this.val$errCode, this.ftO);
    if (this.mKX.callback != null) {
      this.mKX.callback.onSceneEnd(this.val$errType, this.val$errCode, this.ftO, this.mKX);
    }
    AppMethodBeat.o(20778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c.1
 * JD-Core Version:    0.7.0.1
 */