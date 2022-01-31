package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;

final class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    this.kpk.b(this.eea, this.bEf, this.bEg, this.edL);
    if (this.kpk.dmL != null) {
      this.kpk.dmL.onSceneEnd(this.bEf, this.bEg, this.edL, this.kpk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c.1
 * JD-Core Version:    0.7.0.1
 */