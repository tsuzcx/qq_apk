package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;

@CoordinatorLayout.b(FloatingActionButton.Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
{
  private ColorStateList jf;
  private PorterDuff.Mode jg;
  private int jh;
  private int ji;
  private int jj;
  int jk;
  private int jl;
  boolean jm;
  final Rect jn = new Rect();
  private final Rect jo = new Rect();
  private android.support.v7.widget.i jp;
  private h jq;
  private int mSize;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n.F(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton, paramInt, 2131493839);
    this.jf = paramContext.getColorStateList(7);
    this.jg = p.R(paramContext.getInt(8, -1));
    this.ji = paramContext.getColor(1, 0);
    this.mSize = paramContext.getInt(2, -1);
    this.jj = paramContext.getDimensionPixelSize(3, 0);
    this.jh = paramContext.getDimensionPixelSize(5, 0);
    float f1 = paramContext.getDimension(0, 0.0F);
    float f2 = paramContext.getDimension(4, 0.0F);
    this.jm = paramContext.getBoolean(6, false);
    paramContext.recycle();
    this.jp = new android.support.v7.widget.i(this);
    this.jp.a(paramAttributeSet, paramInt);
    this.jl = ((int)getResources().getDimension(2131428291));
    getImpl().a(this.jf, this.jg, this.ji, this.jh);
    getImpl().setElevation(f1);
    paramContext = getImpl();
    if (paramContext.jE != f2)
    {
      paramContext.jE = f2;
      paramContext.o(paramContext.jD, f2);
    }
  }
  
  private h.c c(FloatingActionButton.a parama)
  {
    if (parama == null) {
      return null;
    }
    return new FloatingActionButton.1(this, parama);
  }
  
  private h getImpl()
  {
    if (this.jq == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new FloatingActionButton.b(this));; localObject = new h(this, new FloatingActionButton.b(this)))
    {
      this.jq = ((h)localObject);
      return this.jq;
    }
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  final void a(FloatingActionButton.a parama)
  {
    int i = 1;
    h localh = getImpl();
    parama = c(parama);
    if (localh.jG.getVisibility() != 0) {
      if (localh.jw != 2) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        localh.jG.animate().cancel();
        if (!localh.bz()) {
          break;
        }
        localh.jw = 2;
        if (localh.jG.getVisibility() != 0)
        {
          localh.jG.setAlpha(0.0F);
          localh.jG.setScaleY(0.0F);
          localh.jG.setScaleX(0.0F);
        }
        localh.jG.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(a.fl).setListener(new h.2(localh, parama));
      }
      return;
      i = 0;
      continue;
      if (localh.jw == 1) {
        i = 0;
      }
    }
    localh.jG.f(0, false);
    localh.jG.setAlpha(1.0F);
    localh.jG.setScaleY(1.0F);
    localh.jG.setScaleX(1.0F);
  }
  
  final void b(FloatingActionButton.a parama)
  {
    h localh = getImpl();
    parama = c(parama);
    int i;
    if (localh.jG.getVisibility() == 0) {
      if (localh.jw == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localh.jG.animate().cancel();
        if (!localh.bz()) {
          break;
        }
        localh.jw = 1;
        localh.jG.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(a.fk).setListener(new h.1(localh, parama));
      }
      return;
      i = 0;
      continue;
      if (localh.jw != 2) {
        i = 1;
      } else {
        i = 0;
      }
    }
    localh.jG.f(4, false);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().c(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.jf;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.jg;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().jC;
  }
  
  public int getCustomSize()
  {
    return this.jj;
  }
  
  public int getRippleColor()
  {
    return this.ji;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  int getSizeDimension()
  {
    int i = this.mSize;
    Resources localResources;
    for (;;)
    {
      localResources = getResources();
      if (this.jj != 0) {
        return this.jj;
      }
      switch (i)
      {
      case 0: 
      default: 
        return localResources.getDimensionPixelSize(2131428293);
      case -1: 
        if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      }
    }
    return localResources.getDimensionPixelSize(2131428292);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.jm;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().bs();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.bv())
    {
      if (localh.jI == null) {
        localh.jI = new h.3(localh);
      }
      localh.jG.getViewTreeObserver().addOnPreDrawListener(localh.jI);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.jI != null)
    {
      localh.jG.getViewTreeObserver().removeOnPreDrawListener(localh.jI);
      localh.jI = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.jk = ((i - this.jl) / 2);
    getImpl().bu();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.jn.left + paramInt1 + this.jn.right, paramInt1 + this.jn.top + this.jn.bottom);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      Rect localRect = this.jo;
      if (t.as(this))
      {
        localRect.set(0, 0, getWidth(), getHeight());
        localRect.left += this.jn.left;
        localRect.top += this.jn.top;
        localRect.right -= this.jn.right;
        localRect.bottom -= this.jn.bottom;
      }
      for (int i = 1; (i != 0) && (!this.jo.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())); i = 0) {
        return false;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.jf != paramColorStateList)
    {
      this.jf = paramColorStateList;
      h localh = getImpl();
      if (localh.jz != null) {
        android.support.v4.graphics.drawable.a.a(localh.jz, paramColorStateList);
      }
      if (localh.jB != null) {
        localh.jB.a(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.jg != paramMode)
    {
      this.jg = paramMode;
      h localh = getImpl();
      if (localh.jz != null) {
        android.support.v4.graphics.drawable.a.a(localh.jz, paramMode);
      }
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Custom size should be non-negative.");
    }
    this.jj = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.jp.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    if (this.ji != paramInt)
    {
      this.ji = paramInt;
      getImpl().setRippleColor(paramInt);
    }
  }
  
  public void setSize(int paramInt)
  {
    if (paramInt != this.mSize)
    {
      this.mSize = paramInt;
      requestLayout();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.jm != paramBoolean)
    {
      this.jm = paramBoolean;
      getImpl().bt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */