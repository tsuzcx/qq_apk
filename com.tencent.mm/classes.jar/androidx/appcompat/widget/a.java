package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.appcompat.a.j;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class a
  extends ViewGroup
{
  protected final a nD = new a();
  protected final Context nE;
  protected ActionMenuView nF;
  protected ActionMenuPresenter nG;
  protected int nH;
  protected aa nI;
  private boolean nJ;
  private boolean nK;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.nE = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.nE = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
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
  
  protected static int b(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public aa b(int paramInt, long paramLong)
  {
    if (this.nI != null) {
      this.nI.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localaa = w.Q(this).i(1.0F);
      localaa.f(paramLong);
      localaa.b(this.nD.a(localaa, paramInt));
      return localaa;
    }
    aa localaa = w.Q(this).i(0.0F);
    localaa.f(paramLong);
    localaa.b(this.nD.a(localaa, paramInt));
    return localaa;
  }
  
  public boolean cC()
  {
    if (this.nG != null) {
      return this.nG.cC();
    }
    return false;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.nI != null) {
      return this.nD.nL;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.nH;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, a.j.ActionBar, androidx.appcompat.a.a.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(a.j.ActionBar_height, 0));
    paramConfiguration.recycle();
    if (this.nG != null) {
      this.nG.cN();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.nK = false;
    }
    if (!this.nK)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.nK = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.nK = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.nJ = false;
    }
    if (!this.nJ)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.nJ = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.nJ = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.nH = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.nI != null) {
        this.nI.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  protected final class a
    implements ab
  {
    private boolean mCanceled = false;
    int nL;
    
    protected a() {}
    
    public final a a(aa paramaa, int paramInt)
    {
      a.this.nI = paramaa;
      this.nL = paramInt;
      return this;
    }
    
    public final void e(View paramView)
    {
      AppMethodBeat.i(239964);
      a.a(a.this);
      this.mCanceled = false;
      AppMethodBeat.o(239964);
    }
    
    public final void f(View paramView)
    {
      AppMethodBeat.i(239966);
      if (this.mCanceled)
      {
        AppMethodBeat.o(239966);
        return;
      }
      a.this.nI = null;
      a.a(a.this, this.nL);
      AppMethodBeat.o(239966);
    }
    
    public final void k(View paramView)
    {
      this.mCanceled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.a
 * JD-Core Version:    0.7.0.1
 */