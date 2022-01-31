package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$h$1
  implements Runnable
{
  MultiGestureImageView$h$1(MultiGestureImageView.h paramh) {}
  
  public final void run()
  {
    this.kLp.kLl.getImageMatrix().getValues(this.kLp.kLk);
    float f1 = this.kLp.kLl.getScale();
    float f2 = this.kLp.kLl.getImageWidth() * f1;
    float f3 = this.kLp.kLk[2];
    f1 = MultiGestureImageView.g(this.kLp.kLj);
    if (f2 < MultiGestureImageView.g(this.kLp.kLj)) {
      f1 = MultiGestureImageView.g(this.kLp.kLj) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.kLp.bur = true;
    }
    for (;;)
    {
      this.kLp.kLl.ae(f1, 0.0F);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.kLp.bur = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h.1
 * JD-Core Version:    0.7.0.1
 */