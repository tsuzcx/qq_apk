package com.davemorrissey.labs.subscaleview.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SubsamplingScaleImageView$6$1
  implements Runnable
{
  SubsamplingScaleImageView$6$1(SubsamplingScaleImageView.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(115646);
    if ((this.atw.atu) || (this.atw.atv))
    {
      this.atw.ats.invalidate();
      this.atw.ats.requestLayout();
    }
    AppMethodBeat.o(115646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.6.1
 * JD-Core Version:    0.7.0.1
 */