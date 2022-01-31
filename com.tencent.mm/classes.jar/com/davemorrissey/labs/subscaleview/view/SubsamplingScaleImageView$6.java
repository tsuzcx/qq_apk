package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SubsamplingScaleImageView$6
  implements Runnable
{
  SubsamplingScaleImageView$6(SubsamplingScaleImageView paramSubsamplingScaleImageView, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(115647);
    long l1 = System.currentTimeMillis();
    if (this.att != 0) {
      SubsamplingScaleImageView.b(this.ats, this.ats.a(this.val$bitmap, this.att));
    }
    long l2 = System.currentTimeMillis();
    ab.i(SubsamplingScaleImageView.l(this.ats), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
    this.ats.post(new SubsamplingScaleImageView.6.1(this));
    AppMethodBeat.o(115647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.6
 * JD-Core Version:    0.7.0.1
 */