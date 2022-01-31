package com.tencent.mm.plugin.gif;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(62385);
    if (d.h(this.nFG))
    {
      ab.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
      AppMethodBeat.o(62385);
      return;
    }
    long l = System.currentTimeMillis();
    if (d.b(this.nFG) + 1 > d.i(this.nFG) - 1) {
      d.a(this.nFG, -1);
    }
    d.a(this.nFG, d.b(this.nFG) + 1);
    if (MMGIFJNI.drawFramePixels(d.e(this.nFG), d.j(this.nFG), d.k(this.nFG))) {
      d.l(this.nFG);
    }
    d.b(this.nFG, System.currentTimeMillis() - l);
    boolean bool;
    int i;
    if (d.m(this.nFG) != 0L)
    {
      d.c(this.nFG, d.m(this.nFG) - d.n(this.nFG) - d.o(this.nFG));
      if (d.g(this.nFG) < 0L)
      {
        ab.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(d.n(this.nFG)), Long.valueOf(d.o(this.nFG)), Long.valueOf(d.g(this.nFG)), Long.valueOf(d.m(this.nFG)), Integer.valueOf(d.k(this.nFG)[5]) });
        h.qsU.idkeyStat(401L, 0L, 1L, false);
        h.qsU.idkeyStat(401L, 1L, Math.abs(d.g(this.nFG)), false);
        if (d.g(this.nFG) < -100L)
        {
          if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
            break label473;
          }
          bool = true;
          WXHardCoderJNI.stopPerformance(bool, d.p(this.nFG));
          locald = this.nFG;
          bool = WXHardCoderJNI.hcGifFrameEnable;
          int j = WXHardCoderJNI.hcGifFrameDelay;
          int k = WXHardCoderJNI.hcGifFrameCPU;
          int m = WXHardCoderJNI.hcGifFrameIO;
          if (!WXHardCoderJNI.hcGifFrameThr) {
            break label479;
          }
          i = Process.myTid();
          label371:
          d.b(locald, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMGIFDrawable"));
        }
      }
    }
    d locald = this.nFG;
    Runnable localRunnable = d.f(this.nFG);
    if (d.g(this.nFG) > 0L) {}
    for (l = d.g(this.nFG);; l = 0L)
    {
      d.a(locald, localRunnable, l);
      if (d.k(this.nFG)[2] != 1) {
        break label490;
      }
      d.d(this.nFG, 5000L);
      AppMethodBeat.o(62385);
      return;
      label473:
      bool = false;
      break;
      label479:
      i = 0;
      break label371;
    }
    label490:
    d.d(this.nFG, d.k(this.nFG)[4]);
    AppMethodBeat.o(62385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.6
 * JD-Core Version:    0.7.0.1
 */