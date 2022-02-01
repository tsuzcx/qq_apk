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
  protected final a afm = new a();
  protected final Context afn;
  protected ActionMenuView afo;
  protected ActionMenuPresenter afp;
  protected int afq;
  protected x afr;
  private boolean afs;
  private boolean aft;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(2130968599, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.afn = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.afn = paramContext;
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
  
  public x c(int paramInt, long paramLong)
  {
    if (this.afr != null) {
      this.afr.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localx = t.ag(this).A(1.0F);
      localx.j(paramLong);
      localx.a(this.afm.a(localx, paramInt));
      return localx;
    }
    x localx = t.ag(this).A(0.0F);
    localx.j(paramLong);
    localx.a(this.afm.a(localx, paramInt));
    return localx;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.afr != null) {
      return this.afm.Cc;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.afq;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, 2130968602, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(13, 0));
    paramConfiguration.recycle();
    if (this.afp != null) {
      this.afp.ie();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.aft = false;
    }
    if (!this.aft)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.aft = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.aft = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.afs = false;
    }
    if (!this.afs)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.afs = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.afs = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.afq = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.afr != null) {
        this.afr.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    if (this.afp != null) {
      return this.afp.showOverflowMenu();
    }
    return false;
  }
  
  protected final class a
    implements y
  {
    int Cc;
    private boolean mCanceled = false;
    
    protected a() {}
    
    public final a a(x paramx, int paramInt)
    {
      a.this.afr = paramx;
      this.Cc = paramInt;
      return this;
    }
    
    public final void aH(View paramView)
    {
      a.a(a.this);
      this.mCanceled = false;
    }
    
    public final void aI(View paramView)
    {
      if (this.mCanceled) {
        return;
      }
      a.this.afr = null;
      a.a(a.this, this.Cc);
    }
    
    public final void aJ(View paramView)
    {
      this.mCanceled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.a
 * JD-Core Version:    0.7.0.1
 */