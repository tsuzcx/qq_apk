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
  public Paint a;
  public int b = 0;
  public RectF c;
  public Rect d;
  public Rect e;
  public Bitmap f;
  public boolean g = true;
  public boolean h = false;
  public boolean i = false;
  public int j = 4;
  public int k;
  public int l;
  public int m;
  public int n;
  public ValueAnimator o;
  public ValueAnimator p;
  public ValueAnimator q;
  public AnimatorSet r;
  public float s = 40.0F;
  public float t = 0.0F;
  public long u = 800L;
  public int v;
  public int w;
  
  public APProcessCircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public APProcessCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public APProcessCircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  public final int a(int paramInt)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    return (int)(paramInt * f1 + 0.5F);
  }
  
  public final AnimatorSet a(float paramFloat)
  {
    int i1 = this.v;
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { i1, i1 + 300 });
    localValueAnimator1.setDuration(this.l / 2);
    localValueAnimator1.setInterpolator(new LinearInterpolator());
    localValueAnimator1.addUpdateListener(new e());
    i1 = this.v;
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { i1 + 20, i1 + 270 + 360 });
    localValueAnimator2.setDuration(this.l / 2);
    localValueAnimator2.setInterpolator(new LinearInterpolator());
    localValueAnimator2.addUpdateListener(new f());
    i1 = this.v;
    ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { i1 + 300, i1 + 720 });
    localValueAnimator3.setDuration(this.l / 2);
    localValueAnimator3.setInterpolator(new LinearInterpolator());
    localValueAnimator3.addUpdateListener(new g());
    i1 = this.v;
    ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { i1 + 270 + 360, i1 + 720 + 20 });
    localValueAnimator4.setDuration(this.l / 2);
    localValueAnimator4.setInterpolator(new LinearInterpolator());
    localValueAnimator4.addUpdateListener(new h());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
    localAnimatorSet.play(localValueAnimator3).with(localValueAnimator4).after(localValueAnimator1);
    return localAnimatorSet;
  }
  
  public final void a()
  {
    this.i = false;
    this.t = 0.0F;
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    b(paramAttributeSet, paramInt);
    this.a = new Paint(1);
    e();
    this.c = new RectF();
    this.f = BitmapFactory.decodeResource(getContext().getResources(), 2131034313);
  }
  
  public void b()
  {
    Object localObject = this.o;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.o.cancel();
    }
    localObject = this.p;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.p.cancel();
    }
    localObject = this.r;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning())) {
      this.r.cancel();
    }
    localObject = this.q;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.q.cancel();
    }
    boolean bool = this.g;
    int i1 = 0;
    if (!bool)
    {
      int i2 = 320 - this.v % 360;
      i1 = i2;
      if (i2 <= 0) {
        i1 = i2 + 360;
      }
      i2 = this.v + i1;
      i1 = (int)(i1 / 320.0F * this.m);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start=");
      ((StringBuilder)localObject).append(this.v);
      ((StringBuilder)localObject).append("  toStart=");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" animSwoopDuration=");
      ((StringBuilder)localObject).append(i1);
      Log.d("reset", ((StringBuilder)localObject).toString());
      this.o = ValueAnimator.ofFloat(new float[] { this.v, i2 });
      localObject = this.o;
      long l1 = i1;
      ((ValueAnimator)localObject).setDuration(l1);
      this.o.setInterpolator(new LinearInterpolator());
      this.o.addUpdateListener(new a());
      this.p = ValueAnimator.ofFloat(new float[] { this.w, i2 + 340 });
      this.p.setDuration(l1);
      this.p.setInterpolator(new LinearInterpolator());
      this.p.addUpdateListener(new b());
      this.q = ValueAnimator.ofFloat(new float[] { 0.0F, this.f.getWidth() });
      this.q.setDuration(this.u);
      this.q.addUpdateListener(new c());
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).play(this.o).with(this.p);
      ((AnimatorSet)localObject).play(this.q).after(this.o);
      ((AnimatorSet)localObject).start();
      return;
    }
    this.r = new AnimatorSet();
    AnimatorSet localAnimatorSet;
    for (localObject = null; i1 < this.n; localObject = localAnimatorSet)
    {
      localAnimatorSet = a(i1);
      AnimatorSet.Builder localBuilder = this.r.play(localAnimatorSet);
      if (localObject != null) {
        localBuilder.after((Animator)localObject);
      }
      i1 += 1;
    }
    this.r.addListener(new d());
    this.r.start();
  }
  
  public final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    this.j = a(this.j);
    this.g = true;
    this.h = false;
    this.s = -90.0F;
    this.k = Color.argb(255, 51, 138, 236);
    this.l = 4000;
    this.m = 1500;
    this.n = 1;
  }
  
  public void c()
  {
    b();
  }
  
  public final void d()
  {
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    RectF localRectF = this.c;
    int i3 = this.j;
    float f1 = i1 + i3;
    float f2 = i2 + i3;
    int i4 = this.b;
    localRectF.set(f1, f2, i4 - i1 - i3, i4 - i2 - i3);
  }
  
  public final void e()
  {
    this.a.setColor(this.k);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.j);
    this.a.setStrokeCap(Paint.Cap.BUTT);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.h) {
      c();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.o;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.o = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.p = null;
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.r = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start=");
    ((StringBuilder)localObject).append(this.v);
    ((StringBuilder)localObject).append("  end=");
    ((StringBuilder)localObject).append(this.w);
    ((StringBuilder)localObject).append("  sweep=");
    ((StringBuilder)localObject).append(this.w - this.v);
    ((StringBuilder)localObject).append("  paint=");
    ((StringBuilder)localObject).append(this.a.getStrokeWidth());
    Log.d("arw", ((StringBuilder)localObject).toString());
    localObject = this.c;
    int i1 = this.v;
    paramCanvas.drawArc((RectF)localObject, i1, this.w - i1, false, this.a);
    if (this.i)
    {
      localObject = this.d;
      float f1 = this.t;
      ((Rect)localObject).right = ((int)f1);
      localObject = this.e;
      double d1 = f1 * this.b / this.f.getWidth();
      Double.isNaN(d1);
      ((Rect)localObject).right = ((int)(d1 * 0.87D));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.e.right);
      ((StringBuilder)localObject).append("   size=");
      ((StringBuilder)localObject).append(this.b);
      Log.d("tickDes", ((StringBuilder)localObject).toString());
      paramCanvas.drawBitmap(this.f, this.d, this.e, null);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getPaddingLeft() + getPaddingRight();
    int i2 = getPaddingTop() + getPaddingBottom();
    paramInt1 = getMeasuredWidth() - i1;
    paramInt2 = getMeasuredHeight() - i2;
    if (paramInt1 >= paramInt2) {
      paramInt1 = paramInt2;
    }
    this.b = paramInt1;
    this.d = new Rect(0, 0, 0, this.f.getHeight());
    double d1 = i1;
    paramInt1 = this.b;
    double d2 = paramInt1;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramInt2 = (int)(d2 * 0.2D + d1);
    d2 = i2;
    double d3 = paramInt1;
    Double.isNaN(d3);
    Double.isNaN(d2);
    int i3 = (int)(d3 * 0.2D + d2);
    d3 = paramInt1;
    Double.isNaN(d3);
    Double.isNaN(d1);
    int i4 = (int)(d1 + d3 * 1.3D);
    d1 = paramInt1;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.e = new Rect(paramInt2, i3, i4, (int)(d2 + d1 * 0.8D));
    paramInt1 = this.b;
    setMeasuredDimension(i1 + paramInt1, paramInt1 + i2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 >= paramInt2) {
      paramInt1 = paramInt2;
    }
    this.b = paramInt1;
    d();
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    int i1;
    if (this.g == paramBoolean) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.g = paramBoolean;
    a();
    if (i1 != 0) {
      b();
    }
  }
  
  public class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    public a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
  
  public class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("end=");
      paramValueAnimator.append(APProcessCircleView.a(APProcessCircleView.this));
      Log.d("endValue", paramValueAnimator.toString());
      APProcessCircleView.this.invalidate();
    }
  }
  
  public class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public c() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.a(APProcessCircleView.this, true);
      APProcessCircleView.a(APProcessCircleView.this, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
      APProcessCircleView.this.invalidate();
    }
  }
  
  public class d
    extends AnimatorListenerAdapter
  {
    public boolean a = false;
    
    public d() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.a) {
        APProcessCircleView.this.b();
      }
    }
  }
  
  public class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    public e() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
      APProcessCircleView.this.invalidate();
    }
  }
  
  public class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    public f() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
  
  public class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    public g() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.a(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
      APProcessCircleView.this.invalidate();
    }
  }
  
  public class h
    implements ValueAnimator.AnimatorUpdateListener
  {
    public h() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      APProcessCircleView.b(APProcessCircleView.this, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APProcessCircleView
 * JD-Core Version:    0.7.0.1
 */