package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$e$1
  implements Runnable
{
  MultiGestureImageView$e$1(MultiGestureImageView.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(21621);
    this.nhP.nhO.getImageMatrix().getValues(this.nhP.nhN);
    float f1 = this.nhP.nhO.getScale();
    float f2 = this.nhP.nhO.getImageHeight() * f1;
    float f3 = this.nhP.nhN[5];
    f1 = MultiGestureImageView.i(this.nhP.nhM);
    if (f2 < MultiGestureImageView.i(this.nhP.nhM)) {
      f1 = MultiGestureImageView.i(this.nhP.nhM) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.nhP.bVC = true;
    }
    for (;;)
    {
      this.nhP.nhO.ap(0.0F, f1);
      AppMethodBeat.o(21621);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.nhP.bVC = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e.1
 * JD-Core Version:    0.7.0.1
 */