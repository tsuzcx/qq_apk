package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SubsamplingScaleImageView$5
  implements Runnable
{
  SubsamplingScaleImageView$5(SubsamplingScaleImageView paramSubsamplingScaleImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(115645);
    if (this.val$bitmap != null)
    {
      long l1 = System.currentTimeMillis();
      SubsamplingScaleImageView.a(this.ats, this.ats.a(this.val$bitmap, SubsamplingScaleImageView.t(this.ats)));
      long l2 = System.currentTimeMillis();
      ab.i(SubsamplingScaleImageView.l(this.ats), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[] { Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(115645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.5
 * JD-Core Version:    0.7.0.1
 */