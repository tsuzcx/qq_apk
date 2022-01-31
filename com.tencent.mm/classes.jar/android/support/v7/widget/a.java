package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a
  extends ViewGroup
{
  protected final a Xn = new a();
  protected final Context Xo;
  protected ActionMenuView Xp;
  protected ActionMenuPresenter Xq;
  protected int Xr;
  protected x Xs;
  private boolean Xt;
  private boolean Xu;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(2130772138, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.Xo = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.Xo = paramContext;
  }
  
  protected static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 = (paramInt3 - j) / 2 + paramInt2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramBoolean) {
        paramInt1 = -i;
      }
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
  }
  
  protected static int c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected static int k(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public x c(int paramInt, long paramLong)
  {
    if (this.Xs != null) {
      this.Xs.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localx = t.ab(this).s(1.0F);
      localx.h(paramLong);
      localx.a(this.Xn.a(localx, paramInt));
      return localx;
    }
    x localx = t.ab(this).s(0.0F);
    localx.h(paramLong);
    localx.a(this.Xn.a(localx, paramInt));
    return localx;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.Xs != null) {
      return this.Xn.uQ;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.Xr;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, 2130772139, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(0, 0));
    paramConfiguration.recycle();
    if (this.Xq != null) {
      this.Xq.gA();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.Xu = false;
    }
    if (!this.Xu)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.Xu = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.Xu = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.Xt = false;
    }
    if (!this.Xt)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.Xt = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.Xt = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.Xr = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.Xs != null) {
        this.Xs.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    if (this.Xq != null) {
      return this.Xq.showOverflowMenu();
    }
    return false;
  }
  
  protected final class a
    implements y
  {
    private boolean qM = false;
    int uQ;
    
    protected a() {}
    
    public final a a(x paramx, int paramInt)
    {
      a.this.Xs = paramx;
      this.uQ = paramInt;
      return this;
    }
    
    public final void aB(View paramView)
    {
      a.a(a.this);
      this.qM = false;
    }
    
    public final void aC(View paramView)
    {
      if (this.qM) {
        return;
      }
      a.this.Xs = null;
      a.a(a.this, this.uQ);
    }
    
    public final void aD(View paramView)
    {
      this.qM = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */