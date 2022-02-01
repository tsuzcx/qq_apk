package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.g.a.c;
import androidx.core.g.a.c.a;
import androidx.core.g.z;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseTransientBottomBar$d
  extends FrameLayout
{
  private final AccessibilityManager accessibilityManager;
  private final c.a dxB;
  private BaseTransientBottomBar.c dxC;
  private BaseTransientBottomBar.b dxD;
  
  protected BaseTransientBottomBar$d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209771);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    if (paramAttributeSet.hasValue(a.k.SnackbarLayout_elevation)) {
      z.k(this, paramAttributeSet.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
    }
    paramAttributeSet.recycle();
    this.accessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.dxB = new c.a()
    {
      public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(209829);
        BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
        AppMethodBeat.o(209829);
      }
    };
    c.a(this.accessibilityManager, this.dxB);
    setClickableOrFocusableBasedOnAccessibility(this.accessibilityManager.isTouchExplorationEnabled());
    AppMethodBeat.o(209771);
  }
  
  private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
  {
    AppMethodBeat.i(209777);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      setClickable(bool);
      setFocusable(paramBoolean);
      AppMethodBeat.o(209777);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(209803);
    super.onAttachedToWindow();
    z.ak(this);
    AppMethodBeat.o(209803);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(209811);
    super.onDetachedFromWindow();
    c.b(this.accessibilityManager, this.dxB);
    AppMethodBeat.o(209811);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209793);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(209793);
  }
  
  void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
  {
    this.dxD = paramb;
  }
  
  void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
  {
    this.dxC = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.d
 * JD-Core Version:    0.7.0.1
 */