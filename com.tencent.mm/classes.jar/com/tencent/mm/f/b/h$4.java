package com.tencent.mm.f.b;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.y;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    y.e("MicroMsg.SceneVoice.Recorder", "start record timeout");
    com.tencent.mm.plugin.report.service.h.nFQ.a(357L, 51L, 1L, true);
    if (!h.access$1000())
    {
      if (d.spd) {
        com.tencent.mm.plugin.report.service.h.nFQ.d("Record", "start record timeout", null);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(357L, 52L, 1L, true);
    }
    h.bAz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.h.4
 * JD-Core Version:    0.7.0.1
 */