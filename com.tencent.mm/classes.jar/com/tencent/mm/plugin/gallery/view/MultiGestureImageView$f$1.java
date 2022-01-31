package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$f$1
  implements Runnable
{
  MultiGestureImageView$f$1(MultiGestureImageView.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(21624);
    this.nhQ.nhO.getImageMatrix().getValues(this.nhQ.nhN);
    float f5 = this.nhQ.nhO.getScale() * this.nhQ.nhO.getImageWidth();
    float f1 = this.nhQ.nhO.getScale();
    float f8 = this.nhQ.nhO.getImageHeight() * f1;
    float f7 = this.nhQ.nhN[2];
    float f10 = this.nhQ.nhN[5];
    float f6 = this.nhQ.nhN[2];
    float f9 = this.nhQ.nhN[5];
    float f2 = 0.0F;
    f1 = MultiGestureImageView.i(this.nhQ.nhM);
    float f3 = 0.0F;
    float f4 = MultiGestureImageView.g(this.nhQ.nhM);
    if (f8 < MultiGestureImageView.i(this.nhQ.nhM))
    {
      f2 = MultiGestureImageView.i(this.nhQ.nhM) / 2.0F - f8 / 2.0F;
      f1 = MultiGestureImageView.i(this.nhQ.nhM) / 2.0F + f8 / 2.0F;
    }
    for (;;)
    {
      f2 -= f10;
      f1 -= f9 + f8;
      if (f2 < 0.0F) {
        f1 = f2;
      }
      for (;;)
      {
        if (f5 < MultiGestureImageView.g(this.nhQ.nhM))
        {
          f3 = MultiGestureImageView.g(this.nhQ.nhM) / 2.0F;
          f4 = f5 / 2.0F;
          f2 = MultiGestureImageView.g(this.nhQ.nhM) / 2.0F + f5 / 2.0F;
          f3 -= f4;
        }
        for (;;)
        {
          f3 -= f7;
          f2 -= f6 + f5;
          if (f3 < 0.0F) {
            f2 = f3;
          }
          for (;;)
          {
            label307:
            if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
              this.nhQ.bVC = true;
            }
            for (;;)
            {
              this.nhQ.nhO.ap(f2, f1);
              AppMethodBeat.o(21624);
              return;
              if (f1 <= 0.0F) {
                break label510;
              }
              break;
              if (f2 <= 0.0F) {
                break label499;
              }
              break label307;
              if (f2 >= 0.0F) {}
              for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
              {
                if (f1 < 0.0F) {
                  break label469;
                }
                f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                break;
              }
              label469:
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
            label499:
            f2 = 0.0F;
          }
          f2 = f4;
        }
        label510:
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.f.1
 * JD-Core Version:    0.7.0.1
 */