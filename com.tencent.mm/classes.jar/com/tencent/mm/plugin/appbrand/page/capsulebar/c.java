package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
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
    AppMethodBeat.i(207874);
    setClickable(false);
    AppMethodBeat.o(207874);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(207876);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
    AppMethodBeat.o(207876);
    return localLayoutParams;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(207875);
    super.onViewAdded(paramView);
    if (!(paramView instanceof g)) {
      Assert.fail("Cant add non CapsuleBar instance here !");
    }
    AppMethodBeat.o(207875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.c
 * JD-Core Version:    0.7.0.1
 */