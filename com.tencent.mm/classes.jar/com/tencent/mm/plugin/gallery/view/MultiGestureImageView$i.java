package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import android.os.Handler;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$i
  extends MultiGestureImageView.a
{
  float[] kLk = new float[9];
  MultiTouchImageView kLl;
  
  public MultiGestureImageView$i(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    this.kLl = paramMultiTouchImageView;
  }
  
  public final void play()
  {
    MultiGestureImageView.h(this.kLj).getHandler().post(new Runnable()
    {
      public final void run()
      {
        MultiGestureImageView.i.this.kLl.getImageMatrix().getValues(MultiGestureImageView.i.this.kLk);
        float f2 = MultiGestureImageView.i.this.kLk[5];
        float f1 = MultiGestureImageView.i.this.kLl.getScale() * MultiGestureImageView.i.this.kLl.getImageHeight();
        if (f1 < MultiGestureImageView.i(MultiGestureImageView.i.this.kLj)) {}
        for (f1 = MultiGestureImageView.i(MultiGestureImageView.i.this.kLj) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
        {
          f1 -= f2;
          if (f1 >= 0.0F) {
            MultiGestureImageView.i.this.bur = true;
          }
          for (;;)
          {
            MultiGestureImageView.i.this.kLl.ae(0.0F, f1);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.i.this.bur = true;
            } else {
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.i
 * JD-Core Version:    0.7.0.1
 */