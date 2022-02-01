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
  private int qwW;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(242901);
    setClickable(false);
    this.qwW = 0;
    AppMethodBeat.o(242901);
  }
  
  public final void BF(int paramInt)
  {
    AppMethodBeat.i(242904);
    super.BF(paramInt);
    this.qwW = paramInt;
    AppMethodBeat.o(242904);
  }
  
  public final void aD(Context paramContext)
  {
    boolean bool = false;
    AppMethodBeat.i(242903);
    if ((getContext() instanceof MutableContextWrapper))
    {
      if (this.qwW <= 0) {
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
      AppMethodBeat.o(242903);
      return;
      label55:
      setLayoutFrozen(false);
    }
  }
  
  public final void cfw()
  {
    AppMethodBeat.i(242902);
    super.cfw();
    super.setWillNotDraw(true);
    AppMethodBeat.o(242902);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(242906);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
    AppMethodBeat.o(242906);
    return localLayoutParams;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(242905);
    super.onViewAdded(paramView);
    if (!(paramView instanceof g)) {
      Assert.fail("Cant add non CapsuleBar instance here !");
    }
    AppMethodBeat.o(242905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.c
 * JD-Core Version:    0.7.0.1
 */