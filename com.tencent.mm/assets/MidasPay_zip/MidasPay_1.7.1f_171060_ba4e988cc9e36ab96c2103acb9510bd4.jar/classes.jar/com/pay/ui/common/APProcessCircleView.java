package com.pay.ui.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class APProcessCircleView
  extends View
{
  private long A = 800L;
  private int B;
  private int C;
  Context a;
  private Paint b;
  private int c = 0;
  private RectF d;
  private Rect e;
  private Rect f;
  private Bitmap g;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private float k;
  private float l;
  private float m;
  private int n = 4;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private float t;
  private ValueAnimator u;
  private ValueAnimator v;
  private ValueAnimator w;
  private AnimatorSet x;
  private float y = 40.0F;
  private float z = 0.0F;
  
  public APProcessCircleView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public APProcessCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a(paramAttributeSet, 0);
  }
  
  public APProcessCircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    return (int)(paramInt * f1 + 0.5F);
  }
  
  private AnimatorSet a(float paramFloat)
  {
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { this.B, this.B + 300 });
    localValueAnimator1.setDuration(this.p / 2);
    localValueAnimator1.setInterpolator(new LinearInterpolator());
    localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        APProcessCircleView.this.invalidate();
      }
    });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { this.B + 20, this.B + 270 + 360 });
    localValueAnimator2.setDuration(this.p / 2);
    localValueAnimator2.setInterpolator(new LinearInterpolator());
    localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { this.B + 300, this.B + 720 });
    localValueAnimator3.setDuration(this.p / 2);
    localValueAnimator3.setInterpolator(new LinearInterpolator());
    localValueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        APProcessCircleView.this.invalidate();
      }
    });
    ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { this.B + 270 + 360, this.B + 720 + 20 });
    localValueAnimator4.setDuration(this.p / 2);
    localValueAnimator4.setInterpolator(new LinearInterpolator());
    localValueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
    localAnimatorSet.play(localValueAnimator3).with(localValueAnimator4).after(localValueAnimator1);
    return localAnimatorSet;
  }
  
  private void b(AttributeSet paramAttributeSet, int paramInt)
  {
    this.k = 0.0F;
    this.l = 100.0F;
    this.n = a(this.n);
    this.h = true;
    this.i = false;
    this.y = -90.0F;
    this.t = this.y;
    this.o = Color.argb(255, 51, 138, 236);
    this.p = 4000;
    this.q = 1500;
    this.r = 500;
    this.s = 1;
  }
  
  private void c()
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    this.d.set(this.n + i1, this.n + i2, this.c - i1 - this.n, this.c - i2 - this.n);
  }
  
  private void d()
  {
    this.b.setColor(this.o);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.n);
    this.b.setStrokeCap(Paint.Cap.BUTT);
  }
  
  private void e()
  {
    this.j = false;
    this.z = 0.0F;
  }
  
  public void a()
  {
    b();
  }
  
  protected void a(AttributeSet paramAttributeSet, int paramInt)
  {
    b(paramAttributeSet, paramInt);
    this.b = new Paint(1);
    d();
    this.d = new RectF();
    this.g = BitmapFactory.decodeResource(getContext().getResources(), 2131034312);
  }
  
  public void b()
  {
    if ((this.u != null) && (this.u.isRunning())) {
      this.u.cancel();
    }
    if ((this.v != null) && (this.v.isRunning())) {
      this.v.cancel();
    }
    if ((this.x != null) && (this.x.isRunning())) {
      this.x.cancel();
    }
    if ((this.w != null) && (this.w.isRunning())) {
      this.w.cancel();
    }
    boolean bool = this.h;
    int i1 = 0;
    if (!bool)
    {
      int i2 = 320 - this.B % 360;
      i1 = i2;
      if (i2 <= 0) {
        i1 = i2 + 360;
      }
      i2 = this.B + i1;
      i1 = (int)(i1 / 320.0F * this.q);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start=");
      ((StringBuilder)localObject).append(this.B);
      ((StringBuilder)localObject).append("  toStart=");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" animSwoopDuration=");
      ((StringBuilder)localObject).append(i1);
      Log.d("reset", ((StringBuilder)localObject).toString());
      this.u = ValueAnimator.ofFloat(new float[] { this.B, i2 });
      localObject = this.u;
      long l1 = i1;
      ((ValueAnimator)localObject).setDuration(l1);
      this.u.setInterpolator(new LinearInterpolator());
      this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        }
      });
      this.v = ValueAnimator.ofFloat(new float[] { this.C, i2 + 340 });
      this.v.setDuration(l1);
      this.v.setInterpolator(new LinearInterpolator());
      this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          paramAnonymousValueAnimator = new StringBuilder();
          paramAnonymousValueAnimator.append("end=");
          paramAnonymousValueAnimator.append(APProcessCircleView.a(APProcessCircleView.this));
          Log.d("endValue", paramAnonymousValueAnimator.toString());
          APProcessCircleView.this.invalidate();
        }
      });
      this.w = ValueAnimator.ofFloat(new float[] { 0.0F, this.g.getWidth() });
      this.w.setDuration(this.A);
      this.w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          APProcessCircleView.a(APProcessCircleView.this, true);
          APProcessCircleView.a(APProcessCircleView.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          APProcessCircleView.this.invalidate();
        }
      });
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).play(this.u).with(this.v);
      ((AnimatorSet)localObject).play(this.w).after(this.u);
      ((AnimatorSet)localObject).start();
      return;
    }
    this.t = this.y;
    this.m = 15.0F;
    this.x = new AnimatorSet();
    AnimatorSet localAnimatorSet;
    for (Object localObject = null; i1 < this.s; localObject = localAnimatorSet)
    {
      localAnimatorSet = a(i1);
      AnimatorSet.Builder localBuilder = this.x.play(localAnimatorSet);
      if (localObject != null) {
        localBuilder.after((Animator)localObject);
      }
      i1 += 1;
    }
    this.x.addListener(new AnimatorListenerAdapter()
    {
      boolean a = false;
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.a = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!this.a) {
          APProcessCircleView.this.b();
        }
      }
    });
    this.x.start();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.i) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.u != null)
    {
      this.u.cancel();
      this.u = null;
    }
    if (this.v != null)
    {
      this.v.cancel();
      this.v = null;
    }
    if (this.x != null)
    {
      this.x.cancel();
      this.x = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start=");
    ((StringBuilder)localObject).append(this.B);
    ((StringBuilder)localObject).append("  end=");
    ((StringBuilder)localObject).append(this.C);
    ((StringBuilder)localObject).append("  sweep=");
    ((StringBuilder)localObject).append(this.C - this.B);
    ((StringBuilder)localObject).append("  paint=");
    ((StringBuilder)localObject).append(this.b.getStrokeWidth());
    Log.d("arw", ((StringBuilder)localObject).toString());
    paramCanvas.drawArc(this.d, this.B, this.C - this.B, false, this.b);
    if (this.j)
    {
      this.e.right = ((int)this.z);
      localObject = this.f;
      double d1 = this.z * this.c / this.g.getWidth();
      Double.isNaN(d1);
      ((Rect)localObject).right = ((int)(d1 * 0.87D));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.f.right);
      ((StringBuilder)localObject).append("   size=");
      ((StringBuilder)localObject).append(this.c);
      Log.d("tickDes", ((StringBuilder)localObject).toString());
      paramCanvas.drawBitmap(this.g, this.e, this.f, null);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getPaddingLeft() + getPaddingRight();
    int i2 = getPaddingTop() + getPaddingBottom();
    paramInt1 = getMeasuredWidth() - i1;
    paramInt2 = getMeasuredHeight() - i2;
    if (paramInt1 >= paramInt2) {
      paramInt1 = paramInt2;
    }
    this.c = paramInt1;
    this.e = new Rect(0, 0, 0, this.g.getHeight());
    double d1 = i1;
    double d2 = this.c;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramInt1 = (int)(d2 * 0.2D + d1);
    d2 = i2;
    double d3 = this.c;
    Double.isNaN(d3);
    Double.isNaN(d2);
    paramInt2 = (int)(d3 * 0.2D + d2);
    d3 = this.c;
    Double.isNaN(d3);
    Double.isNaN(d1);
    int i3 = (int)(d1 + d3 * 1.3D);
    d1 = this.c;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.f = new Rect(paramInt1, paramInt2, i3, (int)(d2 + d1 * 0.8D));
    setMeasuredDimension(this.c + i1, this.c + i2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 >= paramInt2) {
      paramInt1 = paramInt2;
    }
    this.c = paramInt1;
    c();
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    boolean bool = this.h;
    int i1;
    if (this.h == paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.h = paramBoolean;
    e();
    if (i1 != 0) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APProcessCircleView
 * JD-Core Version:    0.7.0.1
 */