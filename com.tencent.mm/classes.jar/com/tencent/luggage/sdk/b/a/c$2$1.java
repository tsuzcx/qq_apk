package com.tencent.luggage.sdk.b.a;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;

final class c$2$1
  implements Runnable
{
  c$2$1(c.2 param2, int paramInt1, int paramInt2, b paramb, View paramView, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    int j = -1;
    AppMethodBeat.i(140684);
    Bitmap localBitmap = this.bDU.bDQ.aAK();
    int i;
    if ((localBitmap != null) && (localBitmap.getWidth() > 0) && (localBitmap.getHeight() > 0))
    {
      i = Math.min(localBitmap.getWidth(), this.val$w);
      j = Math.min(localBitmap.getHeight(), this.val$h);
      this.bDR.C(new Object[] { Bitmap.createBitmap(localBitmap, 0, 0, i, j) });
      localBitmap.recycle();
      this.bDU.bDQ.a(new c.2.1.1(this));
      AppMethodBeat.o(140684);
      return;
    }
    if (localBitmap == null)
    {
      i = -1;
      label118:
      if (localBitmap != null) {
        break label175;
      }
    }
    for (;;)
    {
      d.e("MicroMsg.AppBrandPageViewLU", "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.bDR.C(new Object[] { null });
      break;
      i = localBitmap.getWidth();
      break label118;
      label175:
      j = localBitmap.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.2.1
 * JD-Core Version:    0.7.0.1
 */