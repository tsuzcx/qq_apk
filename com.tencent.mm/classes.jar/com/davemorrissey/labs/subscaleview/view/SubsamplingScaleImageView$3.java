package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class SubsamplingScaleImageView$3
  extends GestureDetector.SimpleOnGestureListener
{
  SubsamplingScaleImageView$3(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115643);
    if ((SubsamplingScaleImageView.k(this.ats)) && (SubsamplingScaleImageView.f(this.ats)) && (SubsamplingScaleImageView.g(this.ats) != null))
    {
      SubsamplingScaleImageView.a(this.ats, this.val$context);
      ab.i(SubsamplingScaleImageView.l(this.ats), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.m(this.ats)) });
      if (SubsamplingScaleImageView.m(this.ats))
      {
        SubsamplingScaleImageView.a(this.ats, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        SubsamplingScaleImageView.b(this.ats, new PointF(SubsamplingScaleImageView.g(this.ats).x, SubsamplingScaleImageView.g(this.ats).y));
        SubsamplingScaleImageView.a(this.ats, SubsamplingScaleImageView.i(this.ats));
        SubsamplingScaleImageView.n(this.ats);
        SubsamplingScaleImageView.o(this.ats);
        SubsamplingScaleImageView.p(this.ats);
        SubsamplingScaleImageView.c(this.ats, this.ats.b(SubsamplingScaleImageView.q(this.ats)));
        SubsamplingScaleImageView.d(this.ats, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        SubsamplingScaleImageView.e(this.ats, new PointF(SubsamplingScaleImageView.r(this.ats).x, SubsamplingScaleImageView.r(this.ats).y));
        SubsamplingScaleImageView.s(this.ats);
        AppMethodBeat.o(115643);
        return false;
      }
      SubsamplingScaleImageView.a(this.ats, this.ats.b(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY())), new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
      AppMethodBeat.o(115643);
      return true;
    }
    boolean bool = super.onDoubleTapEvent(paramMotionEvent);
    AppMethodBeat.o(115643);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(115641);
    if ((SubsamplingScaleImageView.e(this.ats)) && (SubsamplingScaleImageView.f(this.ats)) && (SubsamplingScaleImageView.g(this.ats) != null) && (paramMotionEvent1 != null) && (paramMotionEvent2 != null) && ((Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX()) > 50.0F) || (Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY()) > 50.0F)) && ((Math.abs(paramFloat1) > 500.0F) || (Math.abs(paramFloat2) > 500.0F)) && (!SubsamplingScaleImageView.h(this.ats)))
    {
      paramMotionEvent1 = new PointF(SubsamplingScaleImageView.g(this.ats).x + paramFloat1 * 0.25F, SubsamplingScaleImageView.g(this.ats).y + 0.25F * paramFloat2);
      paramFloat1 = (this.ats.getWidth() / 2 - paramMotionEvent1.x) / SubsamplingScaleImageView.i(this.ats);
      paramFloat2 = (this.ats.getHeight() / 2 - paramMotionEvent1.y) / SubsamplingScaleImageView.i(this.ats);
      paramMotionEvent1 = new SubsamplingScaleImageView.b(this.ats, new PointF(paramFloat1, paramFloat2), (byte)0);
      if (!SubsamplingScaleImageView.lE().contains(Integer.valueOf(1)))
      {
        paramMotionEvent1 = new IllegalArgumentException("Unknown easing type: 1");
        AppMethodBeat.o(115641);
        throw paramMotionEvent1;
      }
      paramMotionEvent1.atF = 1;
      paramMotionEvent1.atL = false;
      paramMotionEvent1.atG = 3;
      paramMotionEvent1.start();
      AppMethodBeat.o(115641);
      return true;
    }
    boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(115641);
    return bool;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115642);
    if (SubsamplingScaleImageView.j(this.ats) != null)
    {
      boolean bool = SubsamplingScaleImageView.j(this.ats).onSingleTapConfirmed(paramMotionEvent);
      if (bool)
      {
        AppMethodBeat.o(115642);
        return bool;
      }
    }
    this.ats.performClick();
    AppMethodBeat.o(115642);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.3
 * JD-Core Version:    0.7.0.1
 */