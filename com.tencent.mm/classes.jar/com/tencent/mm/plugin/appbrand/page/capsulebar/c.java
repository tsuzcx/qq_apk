package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;
import junit.framework.Assert;

public final class c
  extends b
{
  private int tBV;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(325290);
    setClickable(false);
    this.tBV = 0;
    AppMethodBeat.o(325290);
  }
  
  public final void bm(Context paramContext)
  {
    boolean bool = false;
    AppMethodBeat.i(325306);
    if ((getContext() instanceof MutableContextWrapper))
    {
      if (this.tBV <= 0) {
        break label55;
      }
      if (!(paramContext instanceof Activity)) {
        bool = true;
      }
      setLayoutFrozen(bool);
    }
    for (;;)
    {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
      AppMethodBeat.o(325306);
      return;
      label55:
      setLayoutFrozen(false);
    }
  }
  
  public final void cGh()
  {
    AppMethodBeat.i(325299);
    super.cGh();
    super.setWillNotDraw(true);
    AppMethodBeat.o(325299);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(325321);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
    AppMethodBeat.o(325321);
    return localLayoutParams;
  }
  
  public final void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(325310);
    super.onStatusBarHeightChange(paramInt);
    this.tBV = paramInt;
    AppMethodBeat.o(325310);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(325316);
    super.onViewAdded(paramView);
    if (!(paramView instanceof k)) {
      Assert.fail("Cant add non CapsuleBar instance here !");
    }
    AppMethodBeat.o(325316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.c
 * JD-Core Version:    0.7.0.1
 */