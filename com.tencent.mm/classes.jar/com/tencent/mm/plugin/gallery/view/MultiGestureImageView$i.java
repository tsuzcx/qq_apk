package com.tencent.mm.plugin.gallery.view;

import android.graphics.Matrix;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$i
  extends MultiGestureImageView.a
{
  float[] nhN;
  MultiTouchImageView nhO;
  
  public MultiGestureImageView$i(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    AppMethodBeat.i(21634);
    this.nhN = new float[9];
    this.nhO = paramMultiTouchImageView;
    AppMethodBeat.o(21634);
  }
  
  public final void play()
  {
    AppMethodBeat.i(21635);
    MultiGestureImageView.h(this.nhM).getHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21633);
        MultiGestureImageView.i.this.nhO.getImageMatrix().getValues(MultiGestureImageView.i.this.nhN);
        float f2 = MultiGestureImageView.i.this.nhN[5];
        float f1 = MultiGestureImageView.i.this.nhO.getScale() * MultiGestureImageView.i.this.nhO.getImageHeight();
        if (f1 < MultiGestureImageView.i(MultiGestureImageView.i.this.nhM)) {}
        for (f1 = MultiGestureImageView.i(MultiGestureImageView.i.this.nhM) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
        {
          f1 -= f2;
          if (f1 >= 0.0F) {
            MultiGestureImageView.i.this.bVC = true;
          }
          for (;;)
          {
            MultiGestureImageView.i.this.nhO.ap(0.0F, f1);
            AppMethodBeat.o(21633);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.i.this.bVC = true;
            } else {
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      }
    });
    AppMethodBeat.o(21635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.i
 * JD-Core Version:    0.7.0.1
 */