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
import midas.x.gp;
import midas.x.gq;
import midas.x.gr;
import midas.x.gs;

public class APWheelView
  extends View
{
  private static final int[] c = { -15658735, 11184810, 11184810 };
  private static int d = 20;
  private static int e = 30;
  private Scroller A;
  private int B;
  private List<gq> C = new LinkedList();
  private List<gr> D = new LinkedList();
  private a E = new a(this);
  private GestureDetector.SimpleOnGestureListener F = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      if (APWheelView.e(APWheelView.this))
      {
        APWheelView.a(APWheelView.this).forceFinished(true);
        APWheelView.f(APWheelView.this);
        return true;
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      APWheelView.a(APWheelView.this, APWheelView.h(APWheelView.this) * APWheelView.i(APWheelView.this) + APWheelView.j(APWheelView.this));
      int i;
      if (APWheelView.this.b) {
        i = 2147483647;
      } else {
        i = APWheelView.k(APWheelView.this).a() * APWheelView.i(APWheelView.this);
      }
      int j;
      if (APWheelView.this.b) {
        j = -i;
      } else {
        j = 0;
      }
      APWheelView.a(APWheelView.this).fling(0, APWheelView.b(APWheelView.this), 0, (int)-paramAnonymousFloat2 / 2, 0, 0, j, i);
      APWheelView.c(APWheelView.this, 0);
      return true;
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      APWheelView.g(APWheelView.this);
      APWheelView.b(APWheelView.this, (int)-paramAnonymousFloat2);
      return true;
    }
  };
  public int a;
  boolean b = false;
  private final int f = 0;
  private final int g = 1;
  private final int h = this.a / 5;
  private gs i = null;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 7;
  private int n = 0;
  private TextPaint o;
  private TextPaint p;
  private StaticLayout q;
  private StaticLayout r;
  private StaticLayout s;
  private String t;
  private Drawable u;
  private GradientDrawable v;
  private GradientDrawable w;
  private boolean x;
  private int y;
  private GestureDetector z;
  
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
  
  private int a(Layout paramLayout)
  {
    if (paramLayout == null) {
      return 0;
    }
    return Math.max(getItemHeight() * this.m - this.h * 2 - 15, getSuggestedMinimumHeight());
  }
  
  private String a(int paramInt)
  {
    if (this.i != null)
    {
      if (this.i.a() == 0) {
        return null;
      }
      int i2 = this.i.a();
      int i1;
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < i2) {}
      }
      else
      {
        i1 = paramInt;
        if (!this.b) {
          return null;
        }
      }
      while (i1 < 0) {
        i1 += i2;
      }
      return this.i.a(i1 % i2);
    }
    return null;
  }
  
  private String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.m / 2 + 1;
    int i1 = this.j - i2;
    while (i1 <= this.j + i2)
    {
      if ((paramBoolean) || (i1 != this.j))
      {
        String str = a(i1);
        if (str != null) {
          localStringBuilder.append(str);
        }
      }
      if (i1 < this.j + i2) {
        localStringBuilder.append("\n");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(Context paramContext)
  {
    this.z = new GestureDetector(paramContext, this.F);
    this.z.setIsLongpressEnabled(false);
    e = gp.a(paramContext, d);
    this.A = new Scroller(paramContext);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.p.setColor(-10066330);
    this.p.drawableState = getDrawableState();
    Rect localRect = new Rect();
    this.q.getLineBounds(this.m / 2, localRect);
    if (this.r != null)
    {
      paramCanvas.save();
      paramCanvas.translate(this.q.getWidth() + e, localRect.top);
      this.r.draw(paramCanvas);
      paramCanvas.restore();
    }
    if (this.s != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, localRect.top + this.y);
      this.s.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private void b(int paramInt)
  {
    this.y += paramInt;
    int i1 = this.y / getItemHeight();
    int i2 = this.j - i1;
    if ((this.b) && (this.i.a() > 0))
    {
      while (i2 < 0) {
        i2 += this.i.a();
      }
      paramInt = i2 % this.i.a();
    }
    else if (this.x)
    {
      if (i2 < 0)
      {
        i1 = this.j;
        paramInt = 0;
      }
      else
      {
        paramInt = i2;
        if (i2 >= this.i.a())
        {
          i1 = this.j - this.i.a() + 1;
          paramInt = this.i.a() - 1;
        }
      }
    }
    else
    {
      paramInt = Math.min(Math.max(i2, 0), this.i.a() - 1);
    }
    i2 = this.y;
    if (paramInt != this.j) {
      setCurrentItem(paramInt, false);
    } else {
      invalidate();
    }
    this.y = (i2 - i1 * getItemHeight());
    if (this.y > getHeight()) {
      this.y = (this.y % getHeight() + getHeight());
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(0.0F, -this.q.getLineTop(1) + this.y);
    this.o.setColor(-10066330);
    this.o.drawableState = getDrawableState();
    this.q.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    e();
    int i1 = getMaxTextLength();
    if (i1 > 0)
    {
      float f1 = (float)Math.ceil(Layout.getDesiredWidth("0", this.o));
      this.k = ((int)(i1 * f1));
    }
    else
    {
      this.k = 0;
    }
    this.k += 2;
    this.l = 0;
    if ((this.t != null) && (this.t.length() > 0)) {
      this.l = ((int)(float)Math.ceil(Layout.getDesiredWidth(this.t, this.p)));
    }
    int i2 = 1;
    if (paramInt2 == 1073741824)
    {
      paramInt2 = i2;
    }
    else
    {
      int i3 = this.k + this.l + 20;
      i1 = i3;
      if (this.l > 0) {
        i1 = i3 + e;
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
      paramInt2 = paramInt1 - e - 20;
      if (paramInt2 <= 0)
      {
        this.l = 0;
        this.k = 0;
      }
      if (this.l > 0)
      {
        double d1 = this.k;
        double d2 = paramInt2;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3 = this.k + this.l;
        Double.isNaN(d3);
        this.k = ((int)(d1 * d2 / d3));
        this.l = (paramInt2 - this.k);
      }
      else
      {
        this.k = (paramInt2 + e);
      }
    }
    if (this.k > 0) {
      d(this.k, this.l);
    }
    return paramInt1;
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getItemHeight() / 2;
    this.u.setBounds(0, i1 - i2, getWidth(), i1 + i2);
    this.u.draw(paramCanvas);
  }
  
  private void d()
  {
    this.q = null;
    this.s = null;
    this.y = 0;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if ((this.q != null) && (this.q.getWidth() <= paramInt1)) {
      this.q.increaseWidthTo(paramInt1);
    } else {
      this.q = new StaticLayout(a(this.x), this.o, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 15.0F, false);
    }
    boolean bool = this.x;
    String str = null;
    if ((!bool) && ((this.s == null) || (this.s.getWidth() > paramInt1)))
    {
      if (getAdapter() != null) {
        str = getAdapter().a(this.j);
      }
      if (str == null) {
        for (;;)
        {
          str = "";
        }
      }
      this.s = new StaticLayout(str, this.p, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 15.0F, false);
    }
    else if (this.x)
    {
      this.s = null;
    }
    else
    {
      this.s.increaseWidthTo(paramInt1);
    }
    if (paramInt2 > 0)
    {
      if ((this.r != null) && (this.r.getWidth() <= paramInt2))
      {
        this.r.increaseWidthTo(paramInt2);
        return;
      }
      this.r = new StaticLayout(this.t, this.p, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 15.0F, false);
    }
  }
  
  private void e()
  {
    if (this.o == null)
    {
      this.o = new TextPaint(1);
      this.o.setTextSize(this.a);
      this.o.setColor(-10066330);
    }
    if (this.p == null)
    {
      this.p = new TextPaint(5);
      this.p.setTextSize(this.a);
    }
    if (this.u == null) {
      this.u = getContext().getResources().getDrawable(2131034344);
    }
    if (this.v == null) {
      this.v = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, c);
    }
    if (this.w == null) {
      this.w = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, c);
    }
  }
  
  private void f()
  {
    this.E.removeMessages(0);
    this.E.removeMessages(1);
  }
  
  private void g()
  {
    if (this.i == null) {
      return;
    }
    int i2 = 0;
    this.B = 0;
    int i3 = this.y;
    int i4 = getItemHeight();
    if (i3 > 0)
    {
      if (this.j >= this.i.a()) {}
    }
    else {
      while (this.j > 0)
      {
        i2 = 1;
        break;
      }
    }
    int i1;
    if (!this.b)
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
      this.A.startScroll(0, 0, 0, i1, 400);
      setNextMessage(1);
      return;
    }
    c();
  }
  
  private int getItemHeight()
  {
    if (this.n != 0) {
      return this.n;
    }
    if ((this.q != null) && (this.q.getLineCount() > 2))
    {
      this.n = (this.q.getLineTop(2) - this.q.getLineTop(1));
      return this.n;
    }
    return getHeight() / this.m;
  }
  
  private int getMaxTextLength()
  {
    gs localgs = getAdapter();
    int i2 = 0;
    if (localgs == null) {
      return 0;
    }
    int i1 = localgs.b();
    if (i1 > 0) {
      return i1;
    }
    Object localObject1 = null;
    i1 = this.m / 2;
    i1 = Math.max(this.j - i1, 0);
    while (i1 < Math.min(this.j + this.m, localgs.a()))
    {
      String str = localgs.a(i1);
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
  
  private void h()
  {
    if (!this.x)
    {
      this.x = true;
      a();
    }
  }
  
  private void setNextMessage(int paramInt)
  {
    f();
    this.E.sendEmptyMessage(paramInt);
  }
  
  protected void a()
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext()) {
      ((gr)localIterator.next()).a(this);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.C.iterator();
    while (localIterator.hasNext()) {
      ((gq)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(gq paramgq)
  {
    this.C.add(paramgq);
  }
  
  protected void b()
  {
    Iterator localIterator = this.D.iterator();
    while (localIterator.hasNext()) {
      ((gr)localIterator.next()).b(this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.A.forceFinished(true);
    this.B = this.y;
    int i1 = getItemHeight();
    this.A.startScroll(0, this.B, 0, paramInt1 * i1 - this.B, paramInt2);
    setNextMessage(0);
    h();
  }
  
  void c()
  {
    if (this.x)
    {
      b();
      this.x = false;
    }
    d();
    invalidate();
  }
  
  public gs getAdapter()
  {
    return this.i;
  }
  
  public int getCurrentItem()
  {
    return this.j;
  }
  
  public String getLabel()
  {
    return this.t;
  }
  
  public int getVisibleItems()
  {
    return this.m;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    c(paramCanvas);
    if (this.q == null) {
      if (this.k == 0) {
        c(getWidth(), 1073741824);
      } else {
        d(this.k, this.l);
      }
    }
    if (this.k > 0)
    {
      paramCanvas.save();
      paramCanvas.translate(10.0F, -this.h);
      b(paramCanvas);
      a(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    i2 = c(i3, i2);
    if (i1 != 1073741824)
    {
      paramInt2 = a(this.q);
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
    if ((!this.z.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
      g();
    }
    return true;
  }
  
  public void setAdapter(gs paramgs)
  {
    this.i = paramgs;
    d();
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (this.i != null)
    {
      if (this.i.a() == 0) {
        return;
      }
      int i1;
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < this.i.a()) {}
      }
      else
      {
        if (!this.b) {
          break label131;
        }
        while (paramInt < 0) {
          paramInt += this.i.a();
        }
        i1 = paramInt % this.i.a();
      }
      if (i1 != this.j)
      {
        if (paramBoolean)
        {
          b(i1 - this.j, 400);
          return;
        }
        d();
        paramInt = this.j;
        this.j = i1;
        a(paramInt, this.j);
        invalidate();
      }
      return;
      label131:
      return;
    }
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.b = paramBoolean;
    invalidate();
    d();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.A.forceFinished(true);
    this.A = new Scroller(getContext(), paramInterpolator);
  }
  
  public void setLabel(String paramString)
  {
    if ((this.t == null) || (!this.t.equals(paramString)))
    {
      this.t = paramString;
      this.r = null;
      invalidate();
    }
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<APWheelView> a;
    
    public a(APWheelView paramAPWheelView)
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
        APWheelView.b(localAPWheelView, j);
      }
      if (Math.abs(i - APWheelView.a(localAPWheelView).getFinalY()) < 1)
      {
        APWheelView.a(localAPWheelView).getFinalY();
        APWheelView.a(localAPWheelView).forceFinished(true);
      }
      if (!APWheelView.a(localAPWheelView).isFinished())
      {
        APWheelView.c(localAPWheelView).sendEmptyMessage(paramMessage.what);
        return;
      }
      if (paramMessage.what == 0)
      {
        APWheelView.d(localAPWheelView);
        return;
      }
      localAPWheelView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.pickview.APWheelView
 * JD-Core Version:    0.7.0.1
 */