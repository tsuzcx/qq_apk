package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class t
{
  static void b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(121069);
    if (paramMMActivity.getSupportActionBar() == null)
    {
      AppMethodBeat.o(121069);
      return;
    }
    paramMMActivity = paramMMActivity.getSupportActionBar().getCustomView().findViewById(2131296416);
    if ((paramMMActivity != null) && (paramMMActivity.getLayoutParams() != null) && ((paramMMActivity.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)paramMMActivity.getLayoutParams()).rightMargin = 0;
      paramMMActivity.requestLayout();
    }
    AppMethodBeat.o(121069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.t
 * JD-Core Version:    0.7.0.1
 */