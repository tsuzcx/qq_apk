package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable
  extends Drawable
{
  private static final RectF jap;
  private static final RectF jaq;
  private int jar;
  private int jas;
  private int jat;
  private boolean jau;
  private int jav;
  private CircleProgressDrawable.RingPathTransform jaw;
  private CircleProgressDrawable.RingRotation jax;
  private Paint mPaint;
  private ArrayList<Animator> nD;
  
  static
  {
    AppMethodBeat.i(77393);
    jap = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
    jaq = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
    AppMethodBeat.o(77393);
  }
  
  public CircleProgressDrawable(Context paramContext)
  {
    AppMethodBeat.i(143020);
    this.jas = 4;
    this.jat = -16777216;
    this.jau = false;
    this.jav = 0;
    this.jaw = new CircleProgressDrawable.RingPathTransform((byte)0);
    this.jax = new CircleProgressDrawable.RingRotation((byte)0);
    this.jar = Math.round(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    this.nD = new ArrayList();
    AppMethodBeat.o(143020);
  }
  
  private static Animator a(CircleProgressDrawable.RingPathTransform paramRingPathTransform)
  {
    AppMethodBeat.i(143023);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(CircleProgressDrawable.c.jay);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(CircleProgressDrawable.b.jay);
    localObjectAnimator2.setRepeatCount(-1);
    paramRingPathTransform = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathOffset", new float[] { 0.0F, 0.25F });
    paramRingPathTransform.setDuration(1333L);
    paramRingPathTransform.setInterpolator(CircleProgressDrawable.a.jay);
    paramRingPathTransform.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramRingPathTransform });
    AppMethodBeat.o(143023);
    return localAnimatorSet;
  }
  
  private static Animator a(CircleProgressDrawable.RingRotation paramRingRotation)
  {
    AppMethodBeat.i(143024);
    paramRingRotation = ObjectAnimator.ofFloat(paramRingRotation, "rotation", new float[] { 0.0F, 720.0F });
    paramRingRotation.setDuration(6665L);
    paramRingRotation.setInterpolator(CircleProgressDrawable.a.jay);
    paramRingRotation.setRepeatCount(-1);
    AppMethodBeat.o(143024);
    return paramRingRotation;
  }
  
  private boolean isStarted()
  {
    AppMethodBeat.i(143022);
    Iterator localIterator = this.nD.iterator();
    while (localIterator.hasNext()) {
      if (((Animator)localIterator.next()).isStarted())
      {
        AppMethodBeat.o(143022);
        return true;
      }
    }
    AppMethodBeat.o(143022);
    return false;
  }
  
  public final void aQG()
  {
    AppMethodBeat.i(143021);
    this.nD.clear();
    this.nD.add(a(this.jaw));
    this.nD.add(a(this.jax));
    AppMethodBeat.o(143021);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(77392);
    Object localObject = getBounds();
    if ((((Rect)localObject).width() == 0) || (((Rect)localObject).height() == 0))
    {
      AppMethodBeat.o(77392);
      return;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.jas);
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setStrokeJoin(Paint.Join.MITER);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(((Rect)localObject).left, ((Rect)localObject).top);
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    localObject = this.mPaint;
    paramCanvas.scale(j / jap.width(), k / jap.height());
    paramCanvas.translate(jap.width() / 2.0F, jap.height() / 2.0F);
    if (this.jau)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.jav);
      paramCanvas.drawArc(jaq, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.jat);
    paramCanvas.rotate(CircleProgressDrawable.RingRotation.b(this.jax));
    float f1 = this.jaw.oe;
    float f2 = this.jaw.oc;
    float f3 = this.jaw.od;
    float f4 = this.jaw.oc;
    paramCanvas.drawArc(jaq, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(77392);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.jar;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.jar;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(77389);
    this.jat = paramInt;
    invalidateSelf();
    AppMethodBeat.o(77389);
  }
  
  public final void start()
  {
    AppMethodBeat.i(77390);
    if (isStarted())
    {
      AppMethodBeat.o(77390);
      return;
    }
    Iterator localIterator = this.nD.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
    AppMethodBeat.o(77390);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(77391);
    Iterator localIterator = this.nD.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
    AppMethodBeat.o(77391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */