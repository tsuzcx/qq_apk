package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(62428);
    if (h.h(this.nFY))
    {
      ab.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
      AppMethodBeat.o(62428);
      return;
    }
    if (h.a(this.nFY))
    {
      ab.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
      AppMethodBeat.o(62428);
      return;
    }
    if (h.g(this.nFY) == 0L)
    {
      ab.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 18L, 1L, false);
      AppMethodBeat.o(62428);
      return;
    }
    h.a(this.nFY, true);
    long l = System.currentTimeMillis();
    int i = (h.i(this.nFY) + 1) % h.j(this.nFY).length;
    Object localObject2 = h.j(this.nFY)[i];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Bitmap.createBitmap(h.k(this.nFY), h.l(this.nFY), Bitmap.Config.ARGB_8888);
      h.j(this.nFY)[i] = localObject1;
    }
    i = MMWXGFJNI.nativeDecodeBufferFrame(h.g(this.nFY), null, 0, (Bitmap)localObject1, h.m(this.nFY));
    if (i == -904)
    {
      ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 8L, 1L, false);
      AppMethodBeat.o(62428);
      return;
    }
    if (i == -909)
    {
      ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 11L, 1L, false);
    }
    while (i != -1)
    {
      h.a(this.nFY, h.b(this.nFY) + 1);
      if ((h.b(this.nFY) < h.n(this.nFY) - 1) && (i != 1)) {
        break;
      }
      h.a(this.nFY, -1);
      i = MMWXGFJNI.nativeRewindBuffer(h.g(this.nFY));
      if (i == 0) {
        break;
      }
      if (i == -905) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(711L, 9L, 1L, false);
      }
      ab.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
      AppMethodBeat.o(62428);
      return;
    }
    ab.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
    AppMethodBeat.o(62428);
    return;
    h.b(this.nFY, System.currentTimeMillis() - l);
    boolean bool;
    if (h.o(this.nFY) != 0L)
    {
      h.c(this.nFY, h.o(this.nFY) - h.p(this.nFY) - h.q(this.nFY));
      if (h.f(this.nFY) < 0L)
      {
        ab.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[] { Long.valueOf(h.p(this.nFY)), Long.valueOf(h.q(this.nFY)), Long.valueOf(h.f(this.nFY)), Long.valueOf(h.o(this.nFY)), Integer.valueOf(h.b(this.nFY)) });
        if (h.f(this.nFY) < -100L)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 16L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(401L, 17L, Math.abs(h.f(this.nFY)), false);
          if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
            break label754;
          }
          bool = true;
          WXHardCoderJNI.stopPerformance(bool, h.r(this.nFY));
          localObject1 = this.nFY;
          bool = WXHardCoderJNI.hcGifFrameEnable;
          int j = WXHardCoderJNI.hcGifFrameDelay;
          int k = WXHardCoderJNI.hcGifFrameCPU;
          int m = WXHardCoderJNI.hcGifFrameIO;
          if (!WXHardCoderJNI.hcGifFrameThr) {
            break label760;
          }
          i = Process.myTid();
          label635:
          h.b((h)localObject1, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifFrameTimeout, 602, WXHardCoderJNI.hcGifFrameAction, "MicroMsg.GIF.MMWXGFDrawable"));
        }
      }
    }
    localObject1 = this.nFY;
    localObject2 = h.e(this.nFY);
    if (h.f(this.nFY) > 0L)
    {
      l = h.f(this.nFY);
      label698:
      h.a((h)localObject1, (Runnable)localObject2, l);
      if (h.m(this.nFY)[0] <= 0) {
        break label771;
      }
    }
    label771:
    for (i = h.m(this.nFY)[0];; i = 100)
    {
      h.d(this.nFY, i);
      h.a(this.nFY, false);
      AppMethodBeat.o(62428);
      return;
      label754:
      bool = false;
      break;
      label760:
      i = 0;
      break label635;
      l = 0L;
      break label698;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h.4
 * JD-Core Version:    0.7.0.1
 */