package com.pay.ui.common.pickview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import midas.x.e7;
import midas.x.f7;
import midas.x.g7;
import midas.x.h7;

public class APWheelView
  extends View
{
  public static final int[] B = { -15658735, 11184810, 11184810 };
  public static int C = 20;
  public static int D = 30;
  public GestureDetector.SimpleOnGestureListener A = new a();
  public int a;
  public final int b = this.a / 5;
  public boolean c = false;
  public h7 d = null;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 7;
  public int i = 0;
  public TextPaint j;
  public TextPaint k;
  public StaticLayout l;
  public StaticLayout m;
  public StaticLayout n;
  public String o;
  public Drawable p;
  public GradientDrawable q;
  public GradientDrawable r;
  public boolean s;
  public int t;
  public GestureDetector u;
  public Scroller v;
  public int w;
  public List<f7> x = new LinkedList();
  public List<g7> y = new LinkedList();
  public b z = new b(this);
  
  public APWheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public APWheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public APWheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int getItemHeight()
  {
    int i1 = this.i;
    if (i1 != 0) {
      return i1;
    }
    StaticLayout localStaticLayout = this.l;
    if ((localStaticLayout != null) && (localStaticLayout.getLineCount() > 2))
    {
      this.i = (this.l.getLineTop(2) - this.l.getLineTop(1));
      return this.i;
    }
    return getHeight() / this.h;
  }
  
  private int getMaxTextLength()
  {
    h7 localh7 = getAdapter();
    int i2 = 0;
    if (localh7 == null) {
      return 0;
    }
    int i1 = localh7.b();
    if (i1 > 0) {
      return i1;
    }
    Object localObject1 = null;
    i1 = this.h / 2;
    i1 = Math.max(this.e - i1, 0);
    while (i1 < Math.min(this.e + this.h, localh7.a()))
    {
      String str = localh7.getItem(i1);
      Object localObject2 = localObject1;
      if (str != null) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localObject1.length() >= str.length()) {}
        }
        else
        {
          localObject2 = str;
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    i1 = i2;
    if (localObject1 != null) {
      i1 = localObject1.length();
    }
    return i1;
  }
  
  private void setNextMessage(int paramInt)
  {
    a();
    this.z.sendEmptyMessage(paramInt);
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    c();
    int i1 = getMaxTextLength();
    if (i1 > 0)
    {
      float f1 = (float)Math.ceil(Layout.getDesiredWidth("0", this.j));
      this.f = ((int)(i1 * f1));
    }
    else
    {
      this.f = 0;
    }
    this.f += 2;
    this.g = 0;
    String str = this.o;
    if ((str != null) && (str.length() > 0)) {
      this.g = ((int)(float)Math.ceil(Layout.getDesiredWidth(this.o, this.k)));
    }
    int i2 = 1;
    if (paramInt2 == 1073741824)
    {
      paramInt2 = i2;
    }
    else
    {
      i1 = this.f;
      int i4 = this.g;
      int i3 = i1 + i4 + 20;
      i1 = i3;
      if (i4 > 0) {
        i1 = i3 + D;
      }
      i1 = Math.max(i1, getSuggestedMinimumWidth());
      if ((paramInt2 == -2147483648) && (paramInt1 < i1))
      {
        paramInt2 = i2;
      }
      else
      {
        paramInt1 = i1;
        paramInt2 = 0;
      }
    }
    if (paramInt2 != 0)
    {
      paramInt2 = paramInt1 - D - 20;
      if (paramInt2 <= 0)
      {
        this.g = 0;
        this.f = 0;
      }
      i1 = this.g;
      if (i1 > 0)
      {
        i2 = this.f;
        double d1 = i2;
        double d2 = paramInt2;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3 = i2 + i1;
        Double.isNaN(d3);
        this.f = ((int)(d1 * d2 / d3));
        this.g = (paramInt2 - this.f);
      }
      else
      {
        this.f = (paramInt2 + D);
      }
    }
    paramInt2 = this.f;
    if (paramInt2 > 0) {
      b(paramInt2, this.g);
    }
    return paramInt1;
  }
  
  public final int a(Layout paramLayout)
  {
    if (paramLayout == null) {
      return 0;
    }
    return Math.max(getItemHeight() * this.h - this.b * 2 - 15, getSuggestedMinimumHeight());
  }
  
  public final String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.h / 2 + 1;
    int i1 = this.e - i2;
    for (;;)
    {
      int i3 = this.e;
      if (i1 > i3 + i2) {
        break;
      }
      if ((paramBoolean) || (i1 != i3))
      {
        String str = b(i1);
        if (str != null) {
          localStringBuilder.append(str);
        }
      }
      if (i1 < this.e + i2) {
        localStringBuilder.append("\n");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    this.z.removeMessages(0);
    this.z.removeMessages(1);
  }
  
  public final void a(int paramInt)
  {
    this.t += paramInt;
    int i1 = this.t / getItemHeight();
    int i2 = this.e - i1;
    if ((this.c) && (this.d.a() > 0))
    {
      while (i2 < 0) {
        i2 += this.d.a();
      }
      paramInt = i2 % this.d.a();
    }
    else if (this.s)
    {
      if (i2 < 0)
      {
        i1 = this.e;
        paramInt = 0;
      }
      else
      {
        paramInt = i2;
        if (i2 >= this.d.a())
        {
          i1 = this.e - this.d.a() + 1;
          paramInt = this.d.a() - 1;
        }
      }
    }
    else
    {
      paramInt = Math.min(Math.max(i2, 0), this.d.a() - 1);
    }
    i2 = this.t;
    if (paramInt != this.e) {
      setCurrentItem(paramInt, false);
    } else {
      invalidate();
    }
    this.t = (i2 - i1 * getItemHeight());
    if (this.t > getHeight()) {
      this.t = (this.t % getHeight() + getHeight());
    }
  }
  
  public final void a(Context paramContext)
  {
    this.u = new GestureDetector(paramContext, this.A);
    this.u.setIsLongpressEnabled(false);
    D = e7.a(paramContext, C);
    this.v = new Scroller(paramContext);
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getItemHeight() / 2;
    this.p.setBounds(0, i1 - i2, getWidth(), i1 + i2);
    this.p.draw(paramCanvas);
  }
  
  public void a(f7 paramf7)
  {
    this.x.add(paramf7);
  }
  
  public final String b(int paramInt)
  {
    h7 localh7 = this.d;
    if (localh7 != null)
    {
      if (localh7.a() == 0) {
        return null;
      }
      int i2 = this.d.a();
      int i1;
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < i2) {}
      }
      else
      {
        i1 = paramInt;
        if (!this.c) {
          return null;
        }
      }
      while (i1 < 0) {
        i1 += i2;
      }
      return this.d.getItem(i1 % i2);
    }
    return null;
  }
  
  public void b()
  {
    if (this.s)
    {
      f();
      this.s = false;
    }
    d();
    invalidate();
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.l;
    if ((localObject != null) && (((StaticLayout)localObject).getWidth() <= paramInt1)) {
      this.l.increaseWidthTo(paramInt1);
    } else {
      this.l = new StaticLayout(a(this.s), this.j, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 15.0F, false);
    }
    boolean bool = this.s;
    localObject = null;
    if (!bool)
    {
      StaticLayout localStaticLayout = this.n;
      if ((localStaticLayout == null) || (localStaticLayout.getWidth() > paramInt1))
      {
        if (getAdapter() != null) {
          localObject = getAdapter().getItem(this.e);
        }
        if (localObject == null) {
          localObject = "";
        }
        this.n = new StaticLayout((CharSequence)localObject, this.k, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 15.0F, false);
        break label185;
      }
    }
    if (this.s) {
      this.n = null;
    } else {
      this.n.increaseWidthTo(paramInt1);
    }
    label185:
    if (paramInt2 > 0)
    {
      localObject = this.m;
      if ((localObject != null) && (((StaticLayout)localObject).getWidth() <= paramInt2))
      {
        this.m.increaseWidthTo(paramInt2);
        return;
      }
      this.m = new StaticLayout(this.o, this.k, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 15.0F, false);
    }
  }
  
  public final void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(0.0F, -this.l.getLineTop(1) + this.t);
    this.j.setColor(-10066330);
    this.j.drawableState = getDrawableState();
    this.l.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public final void c()
  {
    if (this.j == null)
    {
      this.j = new TextPaint(1);
      this.j.setTextSize(this.a);
      this.j.setColor(-10066330);
    }
    if (this.k == null)
    {
      this.k = new TextPaint(5);
      this.k.setTextSize(this.a);
    }
    if (this.p == null) {
      this.p = getContext().getResources().getDrawable(2131034345);
    }
    if (this.q == null) {
      this.q = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, B);
    }
    if (this.r == null) {
      this.r = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, B);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((f7)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }
  
  public final void c(Canvas paramCanvas)
  {
    this.k.setColor(-10066330);
    this.k.drawableState = getDrawableState();
    Rect localRect = new Rect();
    this.l.getLineBounds(this.h / 2, localRect);
    if (this.m != null)
    {
      paramCanvas.save();
      paramCanvas.translate(this.l.getWidth() + D, localRect.top);
      this.m.draw(paramCanvas);
      paramCanvas.restore();
    }
    if (this.n != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, localRect.top + this.t);
      this.n.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public final void d()
  {
    this.l = null;
    this.n = null;
    this.t = 0;
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.v.forceFinished(true);
    this.w = this.t;
    int i1 = getItemHeight();
    Scroller localScroller = this.v;
    int i2 = this.w;
    localScroller.startScroll(0, i2, 0, paramInt1 * i1 - i2, paramInt2);
    setNextMessage(0);
    h();
  }
  
  public final void e()
  {
    if (this.d == null) {
      return;
    }
    int i2 = 0;
    this.w = 0;
    int i3 = this.t;
    int i4 = getItemHeight();
    if (i3 > 0 ? this.e < this.d.a() : this.e > 0) {
      i2 = 1;
    }
    int i1;
    if (!this.c)
    {
      i1 = i3;
      if (i2 == 0) {}
    }
    else
    {
      i1 = i3;
      if (Math.abs(i3) > i4 / 2.0F) {
        if (i3 < 0) {
          i1 = i3 + (i4 + 1);
        } else {
          i1 = i3 - (i4 + 1);
        }
      }
    }
    if (Math.abs(i1) > 1)
    {
      this.v.startScroll(0, 0, 0, i1, 400);
      setNextMessage(1);
      return;
    }
    b();
  }
  
  public void f()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext()) {
      ((g7)localIterator.next()).a(this);
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext()) {
      ((g7)localIterator.next()).b(this);
    }
  }
  
  public h7 getAdapter()
  {
    return this.d;
  }
  
  public int getCurrentItem()
  {
    return this.e;
  }
  
  public String getLabel()
  {
    return this.o;
  }
  
  public int getVisibleItems()
  {
    return this.h;
  }
  
  public final void h()
  {
    if (!this.s)
    {
      this.s = true;
      g();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    if (this.l == null)
    {
      int i1 = this.f;
      if (i1 == 0) {
        a(getWidth(), 1073741824);
      } else {
        b(i1, this.g);
      }
    }
    if (this.f > 0)
    {
      paramCanvas.save();
      paramCanvas.translate(10.0F, -this.b);
      b(paramCanvas);
      c(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    i2 = a(i3, i2);
    if (i1 != 1073741824)
    {
      paramInt2 = a(this.l);
      if (i1 == -2147483648) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
    setMeasuredDimension(i2, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getAdapter() == null) {
      return true;
    }
    if ((!this.u.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
      e();
    }
    return true;
  }
  
  public void setAdapter(h7 paramh7)
  {
    this.d = paramh7;
    d();
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    h7 localh7 = this.d;
    if (localh7 != null)
    {
      if (localh7.a() == 0) {
        return;
      }
      int i1;
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < this.d.a()) {}
      }
      else
      {
        if (!this.c) {
          return;
        }
        while (paramInt < 0) {
          paramInt += this.d.a();
        }
        i1 = paramInt % this.d.a();
      }
      paramInt = this.e;
      if (i1 != paramInt)
      {
        if (paramBoolean)
        {
          d(i1 - paramInt, 400);
          return;
        }
        d();
        paramInt = this.e;
        this.e = i1;
        c(paramInt, this.e);
        invalidate();
      }
    }
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.c = paramBoolean;
    invalidate();
    d();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.v.forceFinished(true);
    this.v = new Scroller(getContext(), paramInterpolator);
  }
  
  public void setLabel(String paramString)
  {
    String str = this.o;
    if ((str == null) || (!str.equals(paramString)))
    {
      this.o = paramString;
      this.m = null;
      invalidate();
    }
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.h = paramInt;
    invalidate();
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    public a() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      if (APWheelView.g(APWheelView.this))
      {
        APWheelView.a(APWheelView.this).forceFinished(true);
        APWheelView.h(APWheelView.this);
        return true;
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      paramMotionEvent1 = APWheelView.this;
      APWheelView.a(paramMotionEvent1, APWheelView.j(paramMotionEvent1) * APWheelView.k(APWheelView.this) + APWheelView.c(APWheelView.this));
      paramMotionEvent1 = APWheelView.this;
      int i;
      if (paramMotionEvent1.c) {
        i = 2147483647;
      } else {
        i = APWheelView.d(paramMotionEvent1).a() * APWheelView.k(APWheelView.this);
      }
      int j;
      if (APWheelView.this.c) {
        j = -i;
      } else {
        j = 0;
      }
      APWheelView.a(APWheelView.this).fling(0, APWheelView.b(APWheelView.this), 0, (int)-paramFloat2 / 2, 0, 0, j, i);
      APWheelView.b(APWheelView.this, 0);
      return true;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      APWheelView.i(APWheelView.this);
      APWheelView.c(APWheelView.this, (int)-paramFloat2);
      return true;
    }
  }
  
  public static class b
    extends Handler
  {
    public final WeakReference<APWheelView> a;
    
    public b(APWheelView paramAPWheelView)
    {
      this.a = new WeakReference(paramAPWheelView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      APWheelView localAPWheelView = (APWheelView)this.a.get();
      if (localAPWheelView == null) {
        return;
      }
      APWheelView.a(localAPWheelView).computeScrollOffset();
      int i = APWheelView.a(localAPWheelView).getCurrY();
      int j = APWheelView.b(localAPWheelView) - i;
      APWheelView.a(localAPWheelView, i);
      if (j != 0) {
        APWheelView.c(localAPWheelView, j);
      }
      if (Math.abs(i - APWheelView.a(localAPWheelView).getFinalY()) < 1)
      {
        APWheelView.a(localAPWheelView).getFinalY();
        APWheelView.a(localAPWheelView).forceFinished(true);
      }
      if (!APWheelView.a(localAPWheelView).isFinished())
      {
        APWheelView.e(localAPWheelView).sendEmptyMessage(paramMessage.what);
        return;
      }
      if (paramMessage.what == 0)
      {
        APWheelView.f(localAPWheelView);
        return;
      }
      localAPWheelView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.pickview.APWheelView
 * JD-Core Version:    0.7.0.1
 */