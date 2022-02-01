package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;

final class aa$a
  extends RelativeLayout
  implements bz
{
  public aa$a(aa paramaa, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(135142);
    this.lbk.laU.draw(paramCanvas);
    Bitmap localBitmap = this.lbk.bjW();
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, aa.k(this.lbk).getTop(), null);
    }
    AppMethodBeat.o(135142);
    return true;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(178578);
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(178578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa.a
 * JD-Core Version:    0.7.0.1
 */