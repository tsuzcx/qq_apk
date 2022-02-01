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
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import androidx.core.g.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class CircleProgressDrawable
  extends Drawable
{
  private static final RectF rrG;
  private static final RectF rrH;
  private ArrayList<Animator> kF;
  private Paint mPaint;
  private int mStrokeColor;
  private int mStrokeWidth;
  private int rrI;
  private boolean rrJ;
  private int rrK;
  private RingPathTransform rrL;
  private RingRotation rrQ;
  
  static
  {
    AppMethodBeat.i(131466);
    rrG = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
    rrH = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
    AppMethodBeat.o(131466);
  }
  
  public CircleProgressDrawable(Context paramContext)
  {
    AppMethodBeat.i(131457);
    this.mStrokeWidth = 4;
    this.mStrokeColor = -16777216;
    this.rrJ = false;
    this.rrK = 0;
    this.rrL = new RingPathTransform((byte)0);
    this.rrQ = new RingRotation((byte)0);
    this.rrI = Math.round(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    this.kF = new ArrayList();
    AppMethodBeat.o(131457);
  }
  
  private static Animator a(RingPathTransform paramRingPathTransform)
  {
    AppMethodBeat.i(131464);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(c.rnH);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(b.rnH);
    localObjectAnimator2.setRepeatCount(-1);
    paramRingPathTransform = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathOffset", new float[] { 0.0F, 0.25F });
    paramRingPathTransform.setDuration(1333L);
    paramRingPathTransform.setInterpolator(CircleProgressDrawable.a.rnH);
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
    paramRingRotation.setInterpolator(CircleProgressDrawable.a.rnH);
    paramRingRotation.setRepeatCount(-1);
    AppMethodBeat.o(131465);
    return paramRingRotation;
  }
  
  private boolean isStarted()
  {
    AppMethodBeat.i(131461);
    Iterator localIterator = this.kF.iterator();
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
  
  public final void cmW()
  {
    AppMethodBeat.i(131459);
    stop();
    this.kF.clear();
    this.kF.add(a(this.rrL));
    this.kF.add(a(this.rrQ));
    AppMethodBeat.o(131459);
  }
  
  public void draw(Canvas paramCanvas)
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
    paramCanvas.scale(j / rrG.width(), k / rrG.height());
    paramCanvas.translate(rrG.width() / 2.0F, rrG.height() / 2.0F);
    if (this.rrJ)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.rrK);
      paramCanvas.drawArc(rrH, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.mStrokeColor);
    paramCanvas.rotate(RingRotation.b(this.rrQ));
    float f1 = this.rrL.aup;
    float f2 = this.rrL.aun;
    float f3 = this.rrL.auo;
    float f4 = this.rrL.aun;
    paramCanvas.drawArc(rrH, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(131463);
  }
  
  public int getIntrinsicHeight()
  {
    return this.rrI;
  }
  
  public int getIntrinsicWidth()
  {
    return this.rrI;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
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
    Iterator localIterator = this.kF.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
    AppMethodBeat.o(131460);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(131462);
    Iterator localIterator = this.kF.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
    AppMethodBeat.o(131462);
  }
  
  static class RingPathTransform
  {
    public float aun = 0.0F;
    public float auo = 0.0F;
    public float aup = 0.0F;
    
    @Keep
    public void setTrimPathEnd(float paramFloat)
    {
      this.auo = paramFloat;
    }
    
    @Keep
    public void setTrimPathOffset(float paramFloat)
    {
      this.aup = paramFloat;
    }
    
    @Keep
    public void setTrimPathStart(float paramFloat)
    {
      this.aun = paramFloat;
    }
  }
  
  static class RingRotation
  {
    private float aoj;
    
    @Keep
    public void setRotation(float paramFloat)
    {
      this.aoj = paramFloat;
    }
  }
  
  static final class b
  {
    public static final Interpolator rnH;
    private static final Path rnI;
    
    static
    {
      AppMethodBeat.i(131455);
      Path localPath = new Path();
      rnI = localPath;
      localPath.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
      rnI.lineTo(1.0F, 1.0F);
      rnH = b.a(rnI);
      AppMethodBeat.o(131455);
    }
  }
  
  static final class c
  {
    public static final Interpolator rnH;
    private static final Path rnJ;
    
    static
    {
      AppMethodBeat.i(131456);
      Path localPath = new Path();
      rnJ = localPath;
      localPath.lineTo(0.5F, 0.0F);
      rnJ.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
      rnH = b.a(rnJ);
      AppMethodBeat.o(131456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */