package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Deque;
import java.util.List;

public final class DanmuView$5
  implements Runnable
{
  public DanmuView$5(DanmuView paramDanmuView, int paramInt) {}
  
  public final void run()
  {
    synchronized (DanmuView.b(this.gFJ))
    {
      int i = DanmuView.a(this.gFJ).size() - 1;
      while (i >= 0)
      {
        d locald = (d)DanmuView.a(this.gFJ).get(i);
        if (locald.akZ() < this.gFM) {
          break;
        }
        y.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locald.akZ()) });
        DanmuView.b(this.gFJ).addFirst(locald);
        i -= 1;
      }
      DanmuView.c(this.gFJ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5
 * JD-Core Version:    0.7.0.1
 */