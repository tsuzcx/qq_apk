package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Deque;
import java.util.List;

public final class DanmuView$5
  implements Runnable
{
  public DanmuView$5(DanmuView paramDanmuView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(126603);
    synchronized (DanmuView.b(this.ieM))
    {
      int i = DanmuView.a(this.ieM).size() - 1;
      while (i >= 0)
      {
        d locald = (d)DanmuView.a(this.ieM).get(i);
        if (locald.aFK() < this.ieP) {
          break;
        }
        ab.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.aFK()) });
        DanmuView.b(this.ieM).addFirst(locald);
        i -= 1;
      }
      DanmuView.c(this.ieM);
      AppMethodBeat.o(126603);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5
 * JD-Core Version:    0.7.0.1
 */