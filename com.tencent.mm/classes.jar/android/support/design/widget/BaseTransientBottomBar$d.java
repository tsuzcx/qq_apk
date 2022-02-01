package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.view.a.b.a;
import android.support.v4.view.a.b.b;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;

public class BaseTransientBottomBar$d
  extends FrameLayout
{
  private final AccessibilityManager nC;
  private final b.a nJ;
  private BaseTransientBottomBar.c nK;
  private BaseTransientBottomBar.b nL;
  
  protected BaseTransientBottomBar$d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
    if (paramAttributeSet.hasValue(1)) {
      u.l(this, paramAttributeSet.getDimensionPixelSize(1, 0));
    }
    paramAttributeSet.recycle();
    this.nC = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.nJ = new b.a()
    {
      public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
      {
        BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
      }
    };
    paramContext = this.nC;
    paramAttributeSet = this.nJ;
    if ((Build.VERSION.SDK_INT >= 19) && (paramAttributeSet != null)) {
      paramContext.addTouchExplorationStateChangeListener(new b.b(paramAttributeSet));
    }
    setClickableOrFocusableBasedOnAccessibility(this.nC.isTouchExplorationEnabled());
  }
  
  private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      setClickable(bool);
      setFocusable(paramBoolean);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    u.ap(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.nL != null) {
      this.nL.ca();
    }
    AccessibilityManager localAccessibilityManager = this.nC;
    b.a locala = this.nJ;
    if ((Build.VERSION.SDK_INT >= 19) && (locala != null)) {
      localAccessibilityManager.removeTouchExplorationStateChangeListener(new b.b(locala));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.nK != null) {
      this.nK.cb();
    }
  }
  
  void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
  {
    this.nL = paramb;
  }
  
  void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
  {
    this.nK = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.BaseTransientBottomBar.d
 * JD-Core Version:    0.7.0.1
 */