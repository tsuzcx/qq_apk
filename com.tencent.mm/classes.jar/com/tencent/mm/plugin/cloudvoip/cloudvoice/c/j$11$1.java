package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$11$1
  implements Runnable
{
  j$11$1(j.11 param11) {}
  
  public final void run()
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
    if (j.a(this.iGa.iFU) == j.c.iGu) {
      j.a(this.iGa.iFU, j.a.iGo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.11.1
 * JD-Core Version:    0.7.0.1
 */