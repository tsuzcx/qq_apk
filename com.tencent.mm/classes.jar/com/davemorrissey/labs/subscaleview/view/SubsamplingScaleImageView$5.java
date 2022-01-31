package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;

final class SubsamplingScaleImageView$5
  implements Runnable
{
  SubsamplingScaleImageView$5(SubsamplingScaleImageView paramSubsamplingScaleImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if (this.ara != null)
    {
      long l1 = System.currentTimeMillis();
      SubsamplingScaleImageView.a(this.aqZ, this.aqZ.a(this.ara, SubsamplingScaleImageView.t(this.aqZ)));
      long l2 = System.currentTimeMillis();
      y.i(SubsamplingScaleImageView.l(this.aqZ), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.5
 * JD-Core Version:    0.7.0.1
 */