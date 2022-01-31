package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;

final class SubsamplingScaleImageView$6
  implements Runnable
{
  SubsamplingScaleImageView$6(SubsamplingScaleImageView paramSubsamplingScaleImageView, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    long l1 = System.currentTimeMillis();
    if (this.arb != 0) {
      SubsamplingScaleImageView.b(this.aqZ, this.aqZ.a(this.ara, this.arb));
    }
    long l2 = System.currentTimeMillis();
    y.i(SubsamplingScaleImageView.l(this.aqZ), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[] { Long.valueOf(l2 - l1) });
    this.aqZ.post(new SubsamplingScaleImageView.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.6
 * JD-Core Version:    0.7.0.1
 */