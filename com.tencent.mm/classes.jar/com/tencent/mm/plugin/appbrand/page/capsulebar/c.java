package com.tencent.mm.plugin.appbrand.page.capsulebar;

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
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219473);
    setClickable(false);
    AppMethodBeat.o(219473);
  }
  
  public final void aG(Context paramContext)
  {
    AppMethodBeat.i(219475);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    AppMethodBeat.o(219475);
  }
  
  public final void bSw()
  {
    AppMethodBeat.i(219474);
    super.bSw();
    super.setWillNotDraw(true);
    AppMethodBeat.o(219474);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(219477);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
    AppMethodBeat.o(219477);
    return localLayoutParams;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(219476);
    super.onViewAdded(paramView);
    if (!(paramView instanceof g)) {
      Assert.fail("Cant add non CapsuleBar instance here !");
    }
    AppMethodBeat.o(219476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.c
 * JD-Core Version:    0.7.0.1
 */