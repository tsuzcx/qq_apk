package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;

final class SubsamplingScaleImageView$7
  implements Runnable
{
  SubsamplingScaleImageView$7(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final void run()
  {
    if ((SubsamplingScaleImageView.u(this.aqZ) != null) && (!SubsamplingScaleImageView.u(this.aqZ).isRecycled()))
    {
      y.i(SubsamplingScaleImageView.l(this.aqZ), "alvinluo rotateAndScale fullImageBitmap");
      SubsamplingScaleImageView.a(this.aqZ, this.aqZ.a(SubsamplingScaleImageView.u(this.aqZ), SubsamplingScaleImageView.t(this.aqZ)));
    }
    this.aqZ.post(new SubsamplingScaleImageView.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.7
 * JD-Core Version:    0.7.0.1
 */