package com.davemorrissey.labs.subscaleview.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SubsamplingScaleImageView$4
  extends GestureDetector.SimpleOnGestureListener
{
  SubsamplingScaleImageView$4(SubsamplingScaleImageView paramSubsamplingScaleImageView) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115644);
    this.ats.performClick();
    AppMethodBeat.o(115644);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.4
 * JD-Core Version:    0.7.0.1
 */