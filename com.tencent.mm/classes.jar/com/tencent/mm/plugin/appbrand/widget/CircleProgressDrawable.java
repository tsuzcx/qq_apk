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
  private static final RectF nbO;
  private static final RectF nbT;
  private Paint mPaint;
  private int mSV;
  private int nbU;
  private int nbV;
  private boolean nbW;
  private int nbX;
  private RingPathTransform nca;
  private RingRotation ncb;
  private ArrayList<Animator> wW;
  
  static
  {
    AppMethodBeat.i(131466);
    nbO = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
    nbT = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
    AppMethodBeat.o(131466);
  }
  
  public CircleProgressDrawable(Context paramContext)
  {
    AppMethodBeat.i(131457);
    this.mSV = 4;
    this.nbV = -16777216;
    this.nbW = false;
    this.nbX = 0;
    this.nca = new RingPathTransform((byte)0);
    this.ncb = new RingRotation((byte)0);
    this.nbU = Math.round(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    this.wW = new ArrayList();
    AppMethodBeat.o(131457);
  }
  
  private static Animator a(RingPathTransform paramRingPathTransform)
  {
    AppMethodBeat.i(131464);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(c.mTb);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(b.mTb);
    localObjectAnimator2.setRepeatCount(-1);
    paramRingPathTransform = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathOffset", new float[] { 0.0F, 0.25F });
    paramRingPathTransform.setDuration(1333L);
    paramRingPathTransform.setInterpolator(CircleProgressDrawable.a.mTb);
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
    paramRingRotation.setInterpolator(CircleProgressDrawable.a.mTb);
    paramRingRotation.setRepeatCount(-1);
    AppMethodBeat.o(131465);
    return paramRingRotation;
  }
  
  private boolean isStarted()
  {
    AppMethodBeat.i(131461);
    Iterator localIterator = this.wW.iterator();
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
  
  public final void Mx()
  {
    AppMethodBeat.i(131459);
    stop();
    this.wW.clear();
    this.wW.add(a(this.nca));
    this.wW.add(a(this.ncb));
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
      this.mPaint.setStrokeWidth(this.mSV);
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setStrokeJoin(Paint.Join.MITER);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(((Rect)localObject).left, ((Rect)localObject).top);
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    localObject = this.mPaint;
    paramCanvas.scale(j / nbO.width(), k / nbO.height());
    paramCanvas.translate(nbO.width() / 2.0F, nbO.height() / 2.0F);
    if (this.nbW)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.nbX);
      paramCanvas.drawArc(nbT, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.nbV);
    paramCanvas.rotate(RingRotation.b(this.ncb));
    float f1 = this.nca.xx;
    float f2 = this.nca.xv;
    float f3 = this.nca.xw;
    float f4 = this.nca.xv;
    paramCanvas.drawArc(nbT, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(131463);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.nbU;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.nbU;
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
    this.nbV = paramInt;
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
    Iterator localIterator = this.wW.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
    AppMethodBeat.o(131460);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(131462);
    Iterator localIterator = this.wW.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
    AppMethodBeat.o(131462);
  }
  
  static class RingPathTransform
  {
    public float xv = 0.0F;
    public float xw = 0.0F;
    public float xx = 0.0F;
    
    @Keep
    public void setTrimPathEnd(float paramFloat)
    {
      this.xw = paramFloat;
    }
    
    @Keep
    public void setTrimPathOffset(float paramFloat)
    {
      this.xx = paramFloat;
    }
    
    @Keep
    public void setTrimPathStart(float paramFloat)
    {
      this.xv = paramFloat;
    }
  }
  
  static class RingRotation
  {
    private float Sz;
    
    @Keep
    public void setRotation(float paramFloat)
    {
      this.Sz = paramFloat;
    }
  }
  
  static final class b
  {
    public static final Interpolator mTb;
    private static final Path mTc;
    
    static
    {
      AppMethodBeat.i(131455);
      Path localPath = new Path();
      mTc = localPath;
      localPath.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
      mTc.lineTo(1.0F, 1.0F);
      mTb = f.c(mTc);
      AppMethodBeat.o(131455);
    }
  }
  
  static final class c
  {
    public static final Interpolator mTb;
    private static final Path mTd;
    
    static
    {
      AppMethodBeat.i(131456);
      Path localPath = new Path();
      mTd = localPath;
      localPath.lineTo(0.5F, 0.0F);
      mTd.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
      mTb = f.c(mTd);
      AppMethodBeat.o(131456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */