package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$7
  implements Runnable
{
  j$7(j paramj) {}
  
  public final void run()
  {
    if ((j.a(this.iFU) == j.c.iGt) && (!j.b(this.iFU)))
    {
      y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
      j.q(this.iFU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.7
 * JD-Core Version:    0.7.0.1
 */