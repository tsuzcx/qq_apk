package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.g.a.c.a;
import androidx.core.g.a.c.b;
import androidx.core.g.w;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BaseTransientBottomBar$d
  extends FrameLayout
{
  private final AccessibilityManager bEA;
  private final c.a bEB;
  private BaseTransientBottomBar.c bEC;
  private BaseTransientBottomBar.b bED;
  
  protected BaseTransientBottomBar$d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239302);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    if (paramAttributeSet.hasValue(a.k.SnackbarLayout_elevation)) {
      w.j(this, paramAttributeSet.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
    }
    paramAttributeSet.recycle();
    this.bEA = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.bEB = new c.a()
    {
      public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(239252);
        BaseTransientBottomBar.d.a(BaseTransientBottomBar.d.this, paramAnonymousBoolean);
        AppMethodBeat.o(239252);
      }
    };
    paramContext = this.bEA;
    paramAttributeSet = this.bEB;
    if ((Build.VERSION.SDK_INT >= 19) && (paramAttributeSet != null)) {
      paramContext.addTouchExplorationStateChangeListener(new c.b(paramAttributeSet));
    }
    setClickableOrFocusableBasedOnAccessibility(this.bEA.isTouchExplorationEnabled());
    AppMethodBeat.o(239302);
  }
  
  private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
  {
    AppMethodBeat.i(239304);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      setClickable(bool);
      setFocusable(paramBoolean);
      AppMethodBeat.o(239304);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(239307);
    super.onAttachedToWindow();
    w.Y(this);
    AppMethodBeat.o(239307);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(239308);
    super.onDetachedFromWindow();
    AccessibilityManager localAccessibilityManager = this.bEA;
    c.a locala = this.bEB;
    if ((Build.VERSION.SDK_INT >= 19) && (locala != null)) {
      localAccessibilityManager.removeTouchExplorationStateChangeListener(new c.b(locala));
    }
    AppMethodBeat.o(239308);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239306);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(239306);
  }
  
  void setOnAttachStateChangeListener(BaseTransientBottomBar.b paramb)
  {
    this.bED = paramb;
  }
  
  void setOnLayoutChangeListener(BaseTransientBottomBar.c paramc)
  {
    this.bEC = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.d
 * JD-Core Version:    0.7.0.1
 */