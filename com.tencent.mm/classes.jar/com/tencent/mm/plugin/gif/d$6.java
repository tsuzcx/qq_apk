package com.tencent.mm.plugin.gif;

import android.os.Process;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    if (d.h(this.lil))
    {
      y.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
      return;
    }
    long l = System.currentTimeMillis();
    if (d.b(this.lil) + 1 > d.i(this.lil) - 1) {
      d.a(this.lil, -1);
    }
    d.a(this.lil, d.b(this.lil) + 1);
    if (MMGIFJNI.drawFramePixels(d.e(this.lil), d.j(this.lil), d.k(this.lil))) {
      d.l(this.lil);
    }
    d.b(this.lil, System.currentTimeMillis() - l);
    boolean bool;
    int i;
    if (d.m(this.lil) != 0L)
    {
      d.c(this.lil, d.m(this.lil) - d.n(this.lil) - d.o(this.lil));
      if (d.g(this.lil) < 0L)
      {
        y.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.n(this.lil)), Long.valueOf(d.o(this.lil)), Long.valueOf(d.g(this.lil)), Long.valueOf(d.m(this.lil)), Integer.valueOf(d.k(this.lil)[5]) });
        h.nFQ.a(401L, 0L, 1L, false);
        h.nFQ.a(401L, 1L, Math.abs(d.g(this.lil)), false);
        if (d.g(this.lil) < -100L)
        {
          if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
            break label458;
          }
          bool = true;
          WXHardCoderJNI.stopPerformace(bool, d.p(this.lil));
          locald = this.lil;
          bool = WXHardCoderJNI.hcGifFrameEnable;
          int j = WXHardCoderJNI.hcGifFrameDelay;
          int k = WXHardCoderJNI.hcGifFrameCPU;
          int m = WXHardCoderJNI.hcGifFrameIO;
          if (!WXHardCoderJNI.hcGifFrameThr) {
            break label464;
          }
          i = Process.myTid();
          label361:
          d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
        }
      }
    }
    d locald = this.lil;
    Runnable localRunnable = d.f(this.lil);
    if (d.g(this.lil) > 0L) {}
    for (l = d.g(this.lil);; l = 0L)
    {
      d.a(locald, localRunnable, l);
      if (d.k(this.lil)[2] != 1) {
        break label475;
      }
      d.d(this.lil, 5000L);
      return;
      label458:
      bool = false;
      break;
      label464:
      i = 0;
      break label361;
    }
    label475:
    d.d(this.lil, d.k(this.lil)[4]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.6
 * JD-Core Version:    0.7.0.1
 */