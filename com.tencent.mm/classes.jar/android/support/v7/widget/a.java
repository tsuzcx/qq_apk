package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
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
  protected final a ahq = new a();
  protected final Context ahr;
  protected ActionMenuView ahs;
  protected ActionMenuPresenter aht;
  protected int ahu;
  protected y ahv;
  private boolean ahw;
  private boolean ahx;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(2130968600, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.ahr = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.ahr = paramContext;
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
  
  protected static int j(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public y c(int paramInt, long paramLong)
  {
    if (this.ahv != null) {
      this.ahv.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localy = u.ah(this).y(1.0F);
      localy.j(paramLong);
      localy.a(this.ahq.a(localy, paramInt));
      return localy;
    }
    y localy = u.ah(this).y(0.0F);
    localy.j(paramLong);
    localy.a(this.ahq.a(localy, paramInt));
    return localy;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.ahv != null) {
      return this.ahq.Ed;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.ahu;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, 2130968603, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(13, 0));
    paramConfiguration.recycle();
    if (this.aht != null) {
      this.aht.iE();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.ahx = false;
    }
    if (!this.ahx)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.ahx = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.ahx = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.ahw = false;
    }
    if (!this.ahw)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.ahw = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.ahw = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.ahu = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.ahv != null) {
        this.ahv.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    if (this.aht != null) {
      return this.aht.showOverflowMenu();
    }
    return false;
  }
  
  protected final class a
    implements z
  {
    int Ed;
    private boolean mCanceled = false;
    
    protected a() {}
    
    public final a a(y paramy, int paramInt)
    {
      a.this.ahv = paramy;
      this.Ed = paramInt;
      return this;
    }
    
    public final void aI(View paramView)
    {
      a.a(a.this);
      this.mCanceled = false;
    }
    
    public final void aJ(View paramView)
    {
      if (this.mCanceled) {
        return;
      }
      a.this.ahv = null;
      a.a(a.this, this.Ed);
    }
    
    public final void aK(View paramView)
    {
      this.mCanceled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */