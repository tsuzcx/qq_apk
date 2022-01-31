package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SubsamplingScaleImageView$7
  implements Runnable
{
  SubsamplingScaleImageView$7(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(115649);
    if ((SubsamplingScaleImageView.u(this.ats) != null) && (!SubsamplingScaleImageView.u(this.ats).isRecycled()))
    {
      ab.i(SubsamplingScaleImageView.l(this.ats), "alvinluo rotateAndScale fullImageBitmap");
      SubsamplingScaleImageView.a(this.ats, this.ats.a(SubsamplingScaleImageView.u(this.ats), SubsamplingScaleImageView.t(this.ats)));
    }
    this.ats.post(new SubsamplingScaleImageView.7.1(this));
    AppMethodBeat.o(115649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.7
 * JD-Core Version:    0.7.0.1
 */