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
import android.support.design.a.d;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v7.widget.j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;

@CoordinatorLayout.b(FloatingActionButton.Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
{
  private ColorStateList ij;
  private PorterDuff.Mode ik;
  private int il;
  private int im;
  private int io;
  int iq;
  private int ir;
  boolean is;
  final Rect it = new Rect();
  private final Rect iu = new Rect();
  private j iw;
  private h ix;
  private int mSize;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o.G(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.FloatingActionButton, paramInt, a.j.Widget_Design_FloatingActionButton);
    this.ij = paramContext.getColorStateList(a.k.FloatingActionButton_backgroundTint);
    this.ik = q.T(paramContext.getInt(a.k.FloatingActionButton_backgroundTintMode, -1));
    this.im = paramContext.getColor(a.k.FloatingActionButton_rippleColor, 0);
    this.mSize = paramContext.getInt(a.k.FloatingActionButton_fabSize, -1);
    this.io = paramContext.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
    this.il = paramContext.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
    float f1 = paramContext.getDimension(a.k.FloatingActionButton_elevation, 0.0F);
    float f2 = paramContext.getDimension(a.k.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.is = paramContext.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
    paramContext.recycle();
    this.iw = new j(this);
    this.iw.b(paramAttributeSet, paramInt);
    this.ir = ((int)getResources().getDimension(a.d.design_fab_image_size));
    getImpl().a(this.ij, this.ik, this.im, this.il);
    getImpl().setElevation(f1);
    paramContext = getImpl();
    if (paramContext.iL != f2)
    {
      paramContext.iL = f2;
      paramContext.o(paramContext.iK, f2);
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
    if (this.ix == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new FloatingActionButton.b(this));; localObject = new h(this, new FloatingActionButton.b(this)))
    {
      this.ix = ((h)localObject);
      return this.ix;
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
    if (localh.iN.getVisibility() != 0) {
      if (localh.iD != 2) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        localh.iN.animate().cancel();
        if (!localh.aQ()) {
          break;
        }
        localh.iD = 2;
        if (localh.iN.getVisibility() != 0)
        {
          localh.iN.setAlpha(0.0F);
          localh.iN.setScaleY(0.0F);
          localh.iN.setScaleX(0.0F);
        }
        localh.iN.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(a.eo).setListener(new h.2(localh, parama));
      }
      return;
      i = 0;
      continue;
      if (localh.iD == 1) {
        i = 0;
      }
    }
    localh.iN.j(0, false);
    localh.iN.setAlpha(1.0F);
    localh.iN.setScaleY(1.0F);
    localh.iN.setScaleX(1.0F);
  }
  
  final void b(FloatingActionButton.a parama)
  {
    h localh = getImpl();
    parama = c(parama);
    int i;
    if (localh.iN.getVisibility() == 0) {
      if (localh.iD == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localh.iN.animate().cancel();
        if (!localh.aQ()) {
          break;
        }
        localh.iD = 1;
        localh.iN.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(a.em).setListener(new h.1(localh, parama));
      }
      return;
      i = 0;
      continue;
      if (localh.iD != 2) {
        i = 1;
      } else {
        i = 0;
      }
    }
    localh.iN.j(4, false);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().c(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.ij;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.ik;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().iJ;
  }
  
  public int getCustomSize()
  {
    return this.io;
  }
  
  public int getRippleColor()
  {
    return this.im;
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
      if (this.io != 0) {
        return this.io;
      }
      switch (i)
      {
      case 0: 
      default: 
        return localResources.getDimensionPixelSize(a.d.design_fab_size_normal);
      case -1: 
        if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      }
    }
    return localResources.getDimensionPixelSize(a.d.design_fab_size_mini);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.is;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().aJ();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.aM())
    {
      if (localh.iP == null) {
        localh.iP = new h.3(localh);
      }
      localh.iN.getViewTreeObserver().addOnPreDrawListener(localh.iP);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.iP != null)
    {
      localh.iN.getViewTreeObserver().removeOnPreDrawListener(localh.iP);
      localh.iP = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.iq = ((i - this.ir) / 2);
    getImpl().aL();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.it.left + paramInt1 + this.it.right, paramInt1 + this.it.top + this.it.bottom);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      Rect localRect = this.iu;
      if (android.support.v4.view.q.al(this))
      {
        localRect.set(0, 0, getWidth(), getHeight());
        localRect.left += this.it.left;
        localRect.top += this.it.top;
        localRect.right -= this.it.right;
        localRect.bottom -= this.it.bottom;
      }
      for (int i = 1; (i != 0) && (!this.iu.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())); i = 0) {
        return false;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ij != paramColorStateList)
    {
      this.ij = paramColorStateList;
      h localh = getImpl();
      if (localh.iG != null) {
        android.support.v4.a.a.a.a(localh.iG, paramColorStateList);
      }
      if (localh.iI != null) {
        localh.iI.a(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ik != paramMode)
    {
      this.ik = paramMode;
      h localh = getImpl();
      if (localh.iG != null) {
        android.support.v4.a.a.a.a(localh.iG, paramMode);
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
    this.io = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.iw.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    if (this.im != paramInt)
    {
      this.im = paramInt;
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
    if (this.is != paramBoolean)
    {
      this.is = paramBoolean;
      getImpl().aK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */