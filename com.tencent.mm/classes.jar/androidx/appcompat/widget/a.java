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
import androidx.core.g.ad;
import androidx.core.g.ae;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class a
  extends ViewGroup
{
  protected final a oC = new a();
  protected final Context oD;
  protected ActionMenuView oE;
  protected ActionMenuPresenter oF;
  protected int oG;
  protected ad oH;
  private boolean oI;
  private boolean oJ;
  
  a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(androidx.appcompat.a.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.oD = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.oD = paramContext;
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
  
  protected static int b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected static int b(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public ad b(int paramInt, long paramLong)
  {
    if (this.oH != null) {
      this.oH.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localad = z.ac(this).ao(1.0F);
      localad.bu(paramLong);
      localad.b(this.oC.a(localad, paramInt));
      return localad;
    }
    ad localad = z.ac(this).ao(0.0F);
    localad.bu(paramLong);
    localad.b(this.oC.a(localad, paramInt));
    return localad;
  }
  
  public boolean dv()
  {
    if (this.oF != null) {
      return this.oF.dv();
    }
    return false;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.oH != null) {
      return this.oC.oK;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.oG;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, a.j.ActionBar, androidx.appcompat.a.a.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(a.j.ActionBar_height, 0));
    paramConfiguration.recycle();
    if (this.oF != null) {
      this.oF.dG();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.oJ = false;
    }
    if (!this.oJ)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.oJ = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.oJ = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.oI = false;
    }
    if (!this.oI)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.oI = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.oI = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.oG = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (this.oH != null) {
        this.oH.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  protected final class a
    implements ae
  {
    private boolean mCanceled = false;
    int oK;
    
    protected a() {}
    
    public final a a(ad paramad, int paramInt)
    {
      a.this.oH = paramad;
      this.oK = paramInt;
      return this;
    }
    
    public final void e(View paramView)
    {
      AppMethodBeat.i(199303);
      a.a(a.this);
      this.mCanceled = false;
      AppMethodBeat.o(199303);
    }
    
    public final void f(View paramView)
    {
      AppMethodBeat.i(199313);
      if (this.mCanceled)
      {
        AppMethodBeat.o(199313);
        return;
      }
      a.this.oH = null;
      a.a(a.this, this.oK);
      AppMethodBeat.o(199313);
    }
    
    public final void k(View paramView)
    {
      this.mCanceled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.a
 * JD-Core Version:    0.7.0.1
 */