package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class q
{
  static void b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(93755);
    if (paramMMActivity.getSupportActionBar() == null)
    {
      AppMethodBeat.o(93755);
      return;
    }
    paramMMActivity = paramMMActivity.getSupportActionBar().getCustomView().findViewById(2131820988);
    if ((paramMMActivity != null) && (paramMMActivity.getLayoutParams() != null) && ((paramMMActivity.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)paramMMActivity.getLayoutParams()).rightMargin = 0;
      paramMMActivity.requestLayout();
    }
    AppMethodBeat.o(93755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.q
 * JD-Core Version:    0.7.0.1
 */