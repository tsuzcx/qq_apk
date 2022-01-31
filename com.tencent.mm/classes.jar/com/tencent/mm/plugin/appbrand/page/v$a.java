package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;

final class v$a
  extends RelativeLayout
  implements bg
{
  public v$a(v paramv, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(141694);
    this.ixv.ixk.draw(paramCanvas);
    Bitmap localBitmap = this.ixv.aAK();
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, v.g(this.ixv).getTop(), null);
    }
    AppMethodBeat.o(141694);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v.a
 * JD-Core Version:    0.7.0.1
 */