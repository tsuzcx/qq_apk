package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$e$1
  implements Runnable
{
  MultiGestureImageView$e$1(MultiGestureImageView.e parame) {}
  
  public final void run()
  {
    this.kLm.kLl.getImageMatrix().getValues(this.kLm.kLk);
    float f1 = this.kLm.kLl.getScale();
    float f2 = this.kLm.kLl.getImageHeight() * f1;
    float f3 = this.kLm.kLk[5];
    f1 = MultiGestureImageView.i(this.kLm.kLj);
    if (f2 < MultiGestureImageView.i(this.kLm.kLj)) {
      f1 = MultiGestureImageView.i(this.kLm.kLj) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.kLm.bur = true;
    }
    for (;;)
    {
      this.kLm.kLl.ae(0.0F, f1);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.kLm.bur = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e.1
 * JD-Core Version:    0.7.0.1
 */