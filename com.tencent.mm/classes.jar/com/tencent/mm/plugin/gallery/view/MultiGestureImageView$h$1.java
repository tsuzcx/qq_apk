package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$h$1
  implements Runnable
{
  MultiGestureImageView$h$1(MultiGestureImageView.h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(21630);
    this.nhS.nhO.getImageMatrix().getValues(this.nhS.nhN);
    float f1 = this.nhS.nhO.getScale();
    float f2 = this.nhS.nhO.getImageWidth() * f1;
    float f3 = this.nhS.nhN[2];
    f1 = MultiGestureImageView.g(this.nhS.nhM);
    if (f2 < MultiGestureImageView.g(this.nhS.nhM)) {
      f1 = MultiGestureImageView.g(this.nhS.nhM) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.nhS.bVC = true;
    }
    for (;;)
    {
      this.nhS.nhO.ap(f1, 0.0F);
      AppMethodBeat.o(21630);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.nhS.bVC = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h.1
 * JD-Core Version:    0.7.0.1
 */