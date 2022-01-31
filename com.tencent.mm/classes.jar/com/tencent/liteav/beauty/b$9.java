package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$9
  implements Runnable
{
  b$9(b paramb, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    AppMethodBeat.i(146330);
    if (this.a != null) {
      a.a().e();
    }
    if (this.a == null)
    {
      if (b.b(this.e) != null)
      {
        b.b(this.e).d();
        b.a(this.e, null);
      }
      AppMethodBeat.o(146330);
      return;
    }
    if (b.b(this.e) == null)
    {
      if ((b.c(this.e) <= 0) || (b.d(this.e) <= 0))
      {
        TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
        AppMethodBeat.o(146330);
        return;
      }
      b.a(this.e, new x());
      b.b(this.e).a(true);
      if (!b.b(this.e).a())
      {
        TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
        b.b(this.e).d();
        b.a(this.e, null);
        AppMethodBeat.o(146330);
        return;
      }
      b.b(this.e).a(b.c(this.e), b.d(this.e));
    }
    b.b(this.e).c(true);
    b.b(this.e).a(this.a, this.b, this.c, this.d);
    AppMethodBeat.o(146330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.9
 * JD-Core Version:    0.7.0.1
 */