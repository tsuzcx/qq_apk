package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$8
  implements Runnable
{
  j$8(j paramj, a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    if (j.a(this.iFU) != j.c.iGu)
    {
      y.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
      if (this.iFY != null) {
        this.iFY.a(-10086, -1001, "not in room", "");
      }
    }
    do
    {
      return;
      j.j(this.iFU).iEB = this.iFZ;
    } while (this.iFY == null);
    this.iFY.a(0, 0, "ok", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.8
 * JD-Core Version:    0.7.0.1
 */