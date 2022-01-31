package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$4$1
  implements Runnable
{
  j$4$1(j.4 param4, int paramInt) {}
  
  public final void run()
  {
    if (j.a(this.iFW.iFU) != j.c.iGu)
    {
      y.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current not in room");
      return;
    }
    if (j.n(this.iFW.iFU) != null) {
      j.n(this.iFW.iFU).a(-10087, this.bEg, "call end", j.m(this.iFW.iFU));
    }
    j.a(this.iFW.iFU, j.c.iGt);
    j.o(this.iFW.iFU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.4.1
 * JD-Core Version:    0.7.0.1
 */