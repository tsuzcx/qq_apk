package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.os.Process;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.y;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    if (h.h(this.liD))
    {
      y.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
      return;
    }
    if (h.a(this.liD))
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
      return;
    }
    if ((h.i(this.liD) == null) || (h.i(this.liD).isRecycled()))
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
      return;
    }
    if (h.g(this.liD) == 0L)
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
      com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 18L, 1L, false);
      return;
    }
    h.a(this.liD, true);
    long l = System.currentTimeMillis();
    int i = MMWXGFJNI.nativeDecodeBufferFrame(h.g(this.liD), null, 0, h.i(this.liD), h.j(this.liD));
    if (i == -904)
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
      com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 8L, 1L, false);
      return;
    }
    if (i == -909)
    {
      y.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
      com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 11L, 1L, false);
    }
    while (i != -1)
    {
      h.a(this.liD, h.b(this.liD) + 1);
      if ((h.b(this.liD) < h.k(this.liD) - 1) && (i != 1)) {
        break;
      }
      h.a(this.liD, -1);
      i = MMWXGFJNI.nativeRewindBuffer(h.g(this.liD));
      if (i == 0) {
        break;
      }
      if (i == -905) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(711L, 9L, 1L, false);
      }
      y.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
      return;
    }
    y.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
    return;
    h.b(this.liD, System.currentTimeMillis() - l);
    boolean bool;
    if (h.l(this.liD) != 0L)
    {
      h.c(this.liD, h.l(this.liD) - h.m(this.liD) - h.n(this.liD));
      if (h.f(this.liD) < 0L)
      {
        y.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(h.m(this.liD)), Long.valueOf(h.n(this.liD)), Long.valueOf(h.f(this.liD)), Long.valueOf(h.l(this.liD)), Integer.valueOf(h.b(this.liD)) });
        if (h.f(this.liD) < -100L)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 16L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.a(401L, 17L, Math.abs(h.f(this.liD)), false);
          if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
            break label678;
          }
          bool = true;
          WXHardCoderJNI.stopPerformace(bool, h.o(this.liD));
          localh = this.liD;
          bool = WXHardCoderJNI.hcGifFrameEnable;
          int j = WXHardCoderJNI.hcGifFrameDelay;
          int k = WXHardCoderJNI.hcGifFrameCPU;
          int m = WXHardCoderJNI.hcGifFrameIO;
          if (!WXHardCoderJNI.hcGifFrameThr) {
            break label684;
          }
          i = Process.myTid();
          label564:
          h.b(localh, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable"));
        }
      }
    }
    h localh = this.liD;
    Runnable localRunnable = h.e(this.liD);
    if (h.f(this.liD) > 0L)
    {
      l = h.f(this.liD);
      label627:
      h.a(localh, localRunnable, l);
      if (h.j(this.liD)[0] <= 0) {
        break label695;
      }
    }
    label678:
    label684:
    label695:
    for (i = h.j(this.liD)[0];; i = 100)
    {
      h.d(this.liD, i);
      h.a(this.liD, false);
      return;
      bool = false;
      break;
      i = 0;
      break label564;
      l = 0L;
      break label627;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h.4
 * JD-Core Version:    0.7.0.1
 */