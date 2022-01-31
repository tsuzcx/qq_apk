package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$g$1
  implements Runnable
{
  MultiGestureImageView$g$1(MultiGestureImageView.g paramg) {}
  
  public final void run()
  {
    this.kLo.kLl.getImageMatrix().getValues(this.kLo.kLk);
    float f2 = this.kLo.kLk[2];
    float f1 = this.kLo.kLl.getScale() * this.kLo.kLl.getImageWidth();
    if (f1 < MultiGestureImageView.g(this.kLo.kLj)) {}
    for (f1 = MultiGestureImageView.g(this.kLo.kLj) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if (f1 >= 0.0F) {
        this.kLo.bur = true;
      }
      for (;;)
      {
        this.kLo.kLl.ae(f1, 0.0F);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.kLo.bur = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g.1
 * JD-Core Version:    0.7.0.1
 */