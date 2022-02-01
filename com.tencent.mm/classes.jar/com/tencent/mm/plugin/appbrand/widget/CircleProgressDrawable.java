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
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.support.v4.view.b.f;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable
  extends Drawable
{
  private static final RectF qoY;
  private static final RectF soR;
  private Paint mPaint;
  private int mStrokeColor;
  private int mStrokeWidth;
  private int thZ;
  private ArrayList<Animator> xd;
  private boolean zpO;
  private int zpP;
  private RingPathTransform zpQ;
  private RingRotation zpR;
  
  static
  {
    AppMethodBeat.i(131466);
    qoY = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
    soR = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
    AppMethodBeat.o(131466);
  }
  
  public CircleProgressDrawable(Context paramContext)
  {
    AppMethodBeat.i(131457);
    this.mStrokeWidth = 4;
    this.mStrokeColor = -16777216;
    this.zpO = false;
    this.zpP = 0;
    this.zpQ = new RingPathTransform((byte)0);
    this.zpR = new RingRotation((byte)0);
    this.thZ = Math.round(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    this.xd = new ArrayList();
    AppMethodBeat.o(131457);
  }
  
  private static Animator a(RingPathTransform paramRingPathTransform)
  {
    AppMethodBeat.i(131464);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(c.olo);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(b.olo);
    localObjectAnimator2.setRepeatCount(-1);
    paramRingPathTransform = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathOffset", new float[] { 0.0F, 0.25F });
    paramRingPathTransform.setDuration(1333L);
    paramRingPathTransform.setInterpolator(CircleProgressDrawable.a.olo);
    paramRingPathTransform.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramRingPathTransform });
    AppMethodBeat.o(131464);
    return localAnimatorSet;
  }
  
  private static Animator a(RingRotation paramRingRotation)
  {
    AppMethodBeat.i(131465);
    paramRingRotation = ObjectAnimator.ofFloat(paramRingRotation, "rotation", new float[] { 0.0F, 720.0F });
    paramRingRotation.setDuration(6665L);
    paramRingRotation.setInterpolator(CircleProgressDrawable.a.olo);
    paramRingRotation.setRepeatCount(-1);
    AppMethodBeat.o(131465);
    return paramRingRotation;
  }
  
  private boolean isStarted()
  {
    AppMethodBeat.i(131461);
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext()) {
      if (((Animator)localIterator.next()).isStarted())
      {
        AppMethodBeat.o(131461);
        return true;
      }
    }
    AppMethodBeat.o(131461);
    return false;
  }
  
  public final void caK()
  {
    AppMethodBeat.i(131459);
    stop();
    this.xd.clear();
    this.xd.add(a(this.zpQ));
    this.xd.add(a(this.zpR));
    AppMethodBeat.o(131459);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(131463);
    Object localObject = getBounds();
    if ((((Rect)localObject).width() == 0) || (((Rect)localObject).height() == 0))
    {
      AppMethodBeat.o(131463);
      return;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setStrokeJoin(Paint.Join.MITER);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(((Rect)localObject).left, ((Rect)localObject).top);
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    localObject = this.mPaint;
    paramCanvas.scale(j / qoY.width(), k / qoY.height());
    paramCanvas.translate(qoY.width() / 2.0F, qoY.height() / 2.0F);
    if (this.zpO)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.zpP);
      paramCanvas.drawArc(soR, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.mStrokeColor);
    paramCanvas.rotate(RingRotation.b(this.zpR));
    float f1 = this.zpQ.xD;
    float f2 = this.zpQ.xB;
    float f3 = this.zpQ.xC;
    float f4 = this.zpQ.xB;
    paramCanvas.drawArc(soR, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(131463);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.thZ;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.thZ;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(131458);
    this.mStrokeColor = paramInt;
    invalidateSelf();
    AppMethodBeat.o(131458);
  }
  
  public final void start()
  {
    AppMethodBeat.i(131460);
    if (isStarted())
    {
      AppMethodBeat.o(131460);
      return;
    }
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
    AppMethodBeat.o(131460);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(131462);
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
    AppMethodBeat.o(131462);
  }
  
  static class RingPathTransform
  {
    public float xB = 0.0F;
    public float xC = 0.0F;
    public float xD = 0.0F;
    
    @Keep
    public void setTrimPathEnd(float paramFloat)
    {
      this.xC = paramFloat;
    }
    
    @Keep
    public void setTrimPathOffset(float paramFloat)
    {
      this.xD = paramFloat;
    }
    
    @Keep
    public void setTrimPathStart(float paramFloat)
    {
      this.xB = paramFloat;
    }
  }
  
  static class RingRotation
  {
    private float SM;
    
    @Keep
    public void setRotation(float paramFloat)
    {
      this.SM = paramFloat;
    }
  }
  
  static final class b
  {
    public static final Interpolator olo;
    private static final Path olp;
    
    static
    {
      AppMethodBeat.i(131455);
      Path localPath = new Path();
      olp = localPath;
      localPath.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
      olp.lineTo(1.0F, 1.0F);
      olo = f.c(olp);
      AppMethodBeat.o(131455);
    }
  }
  
  static final class c
  {
    public static final Interpolator olo;
    private static final Path olq;
    
    static
    {
      AppMethodBeat.i(131456);
      Path localPath = new Path();
      olq = localPath;
      localPath.lineTo(0.5F, 0.0F);
      olq.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
      olo = f.c(olq);
      AppMethodBeat.o(131456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */