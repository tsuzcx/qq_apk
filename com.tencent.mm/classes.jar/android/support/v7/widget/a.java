package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.h;
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
  protected final a WA = new a();
  protected final Context WB;
  protected ActionMenuView WC;
  protected ActionMenuPresenter WD;
  protected int WE;
  protected u WF;
  private boolean WG;
  private boolean WH;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.WB = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.WB = paramContext;
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
  
  protected static int g(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public u c(int paramInt, long paramLong)
  {
    if (this.WF != null) {
      this.WF.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localu = q.Y(this).s(1.0F);
      localu.k(paramLong);
      localu.a(this.WA.a(localu, paramInt));
      return localu;
    }
    u localu = q.Y(this).s(0.0F);
    localu.k(paramLong);
    localu.a(this.WA.a(localu, paramInt));
    return localu;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.WF != null) {
      return this.WA.tP;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.WE;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, a.j.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(a.j.ActionBar_height, 0));
    paramConfiguration.recycle();
    if (this.WD != null)
    {
      paramConfiguration = this.WD;
      if (!paramConfiguration.XK) {
        paramConfiguration.XJ = android.support.v7.view.a.T(paramConfiguration.mContext).eL();
      }
      if (paramConfiguration.dm != null) {
        paramConfiguration.dm.q(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.WH = false;
    }
    if (!this.WH)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.WH = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.WH = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.WG = false;
    }
    if (!this.WG)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.WG = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.WG = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.WE = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.WF != null) {
        this.WF.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    if (this.WD != null) {
      return this.WD.showOverflowMenu();
    }
    return false;
  }
  
  protected final class a
    implements v
  {
    private boolean pP = false;
    int tP;
    
    protected a() {}
    
    public final a a(u paramu, int paramInt)
    {
      a.this.WF = paramu;
      this.tP = paramInt;
      return this;
    }
    
    public final void au(View paramView)
    {
      a.a(a.this);
      this.pP = false;
    }
    
    public final void av(View paramView)
    {
      if (this.pP) {
        return;
      }
      a.this.WF = null;
      a.a(a.this, this.tP);
    }
    
    public final void aw(View paramView)
    {
      this.pP = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */