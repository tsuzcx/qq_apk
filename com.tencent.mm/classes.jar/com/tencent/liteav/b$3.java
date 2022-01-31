package com.tencent.liteav;

import android.os.Handler;
import com.tencent.liteav.basic.d.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.capturer.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(146329);
    try
    {
      if ((this.a.d()) && (b.e(this.a)) && (b.b(this.a).g() == null))
      {
        TXCLog.w("CameraCapture", "camera monitor restart capture");
        b.b(this.a).b();
        b.f(this.a).a(false);
        b.b(this.a).b(b.a(this.a).h);
        b.b(this.a).a(b.a(this.a).P, b.a(this.a).a, b.a(this.a).b);
        b.b(this.a).a(b.f(this.a).getSurfaceTexture());
        b.b(this.a).c(b.a(this.a).m);
        AppMethodBeat.o(146329);
        return;
      }
      if (b.g(this.a) != null) {
        b.g(this.a).postDelayed(this, 2000L);
      }
      AppMethodBeat.o(146329);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.w("CameraCapture", "camera monitor exception ");
      AppMethodBeat.o(146329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.b.3
 * JD-Core Version:    0.7.0.1
 */