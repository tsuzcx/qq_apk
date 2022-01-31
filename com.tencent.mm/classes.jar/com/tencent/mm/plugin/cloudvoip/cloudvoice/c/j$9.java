package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$9
  implements Runnable
{
  j$9(j paramj, a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    if (j.a(this.iFU) != j.c.iGu)
    {
      y.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
      if (this.iFY != null) {
        this.iFY.a(-10086, -1001, "not in room", "");
      }
    }
    for (;;)
    {
      return;
      c localc = j.j(this.iFU);
      boolean bool = this.iFZ;
      if (localc.iEq != null) {
        localc.iEq.aZ(bool);
      }
      for (int i = 1; this.iFY != null; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        this.iFY.a(0, 0, "ok", "");
        return;
      }
    }
    label109:
    this.iFY.a(-10086, -15, "set mute failed", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.9
 * JD-Core Version:    0.7.0.1
 */