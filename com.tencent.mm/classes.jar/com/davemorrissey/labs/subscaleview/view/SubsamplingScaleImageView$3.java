package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class SubsamplingScaleImageView$3
  extends GestureDetector.SimpleOnGestureListener
{
  SubsamplingScaleImageView$3(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((SubsamplingScaleImageView.k(this.aqZ)) && (SubsamplingScaleImageView.f(this.aqZ)) && (SubsamplingScaleImageView.g(this.aqZ) != null))
    {
      SubsamplingScaleImageView.a(this.aqZ, this.val$context);
      y.i(SubsamplingScaleImageView.l(this.aqZ), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[] { Boolean.valueOf(SubsamplingScaleImageView.m(this.aqZ)) });
      if (SubsamplingScaleImageView.m(this.aqZ))
      {
        SubsamplingScaleImageView.a(this.aqZ, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        SubsamplingScaleImageView.b(this.aqZ, new PointF(SubsamplingScaleImageView.g(this.aqZ).x, SubsamplingScaleImageView.g(this.aqZ).y));
        SubsamplingScaleImageView.a(this.aqZ, SubsamplingScaleImageView.i(this.aqZ));
        SubsamplingScaleImageView.n(this.aqZ);
        SubsamplingScaleImageView.o(this.aqZ);
        SubsamplingScaleImageView.p(this.aqZ);
        SubsamplingScaleImageView.c(this.aqZ, this.aqZ.b(SubsamplingScaleImageView.q(this.aqZ)));
        SubsamplingScaleImageView.d(this.aqZ, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        SubsamplingScaleImageView.e(this.aqZ, new PointF(SubsamplingScaleImageView.r(this.aqZ).x, SubsamplingScaleImageView.r(this.aqZ).y));
        SubsamplingScaleImageView.s(this.aqZ);
        return false;
      }
      SubsamplingScaleImageView.a(this.aqZ, this.aqZ.b(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY())), new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
      return true;
    }
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((SubsamplingScaleImageView.e(this.aqZ)) && (SubsamplingScaleImageView.f(this.aqZ)) && (SubsamplingScaleImageView.g(this.aqZ) != null) && (paramMotionEvent1 != null) && (paramMotionEvent2 != null) && ((Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX()) > 50.0F) || (Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY()) > 50.0F)) && ((Math.abs(paramFloat1) > 500.0F) || (Math.abs(paramFloat2) > 500.0F)) && (!SubsamplingScaleImageView.h(this.aqZ)))
    {
      paramMotionEvent1 = new PointF(SubsamplingScaleImageView.g(this.aqZ).x + paramFloat1 * 0.25F, SubsamplingScaleImageView.g(this.aqZ).y + 0.25F * paramFloat2);
      paramFloat1 = (this.aqZ.getWidth() / 2 - paramMotionEvent1.x) / SubsamplingScaleImageView.i(this.aqZ);
      paramFloat2 = (this.aqZ.getHeight() / 2 - paramMotionEvent1.y) / SubsamplingScaleImageView.i(this.aqZ);
      paramMotionEvent1 = new SubsamplingScaleImageView.b(this.aqZ, new PointF(paramFloat1, paramFloat2), (byte)0);
      if (!SubsamplingScaleImageView.jK().contains(Integer.valueOf(1))) {
        throw new IllegalArgumentException("Unknown easing type: 1");
      }
      paramMotionEvent1.arn = 1;
      paramMotionEvent1.art = false;
      SubsamplingScaleImageView.b.a(paramMotionEvent1, 3).start();
      return true;
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (SubsamplingScaleImageView.j(this.aqZ) != null)
    {
      boolean bool = SubsamplingScaleImageView.j(this.aqZ).onSingleTapConfirmed(paramMotionEvent);
      if (bool) {
        return bool;
      }
    }
    this.aqZ.performClick();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.3
 * JD-Core Version:    0.7.0.1
 */