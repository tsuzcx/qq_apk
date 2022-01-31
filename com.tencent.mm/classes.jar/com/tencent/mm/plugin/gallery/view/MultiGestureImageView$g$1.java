package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$g$1
  implements Runnable
{
  MultiGestureImageView$g$1(MultiGestureImageView.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(21627);
    this.nhR.nhO.getImageMatrix().getValues(this.nhR.nhN);
    float f2 = this.nhR.nhN[2];
    float f1 = this.nhR.nhO.getScale() * this.nhR.nhO.getImageWidth();
    if (f1 < MultiGestureImageView.g(this.nhR.nhM)) {}
    for (f1 = MultiGestureImageView.g(this.nhR.nhM) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if (f1 >= 0.0F) {
        this.nhR.bVC = true;
      }
      for (;;)
      {
        this.nhR.nhO.ap(f1, 0.0F);
        AppMethodBeat.o(21627);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.nhR.bVC = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g.1
 * JD-Core Version:    0.7.0.1
 */