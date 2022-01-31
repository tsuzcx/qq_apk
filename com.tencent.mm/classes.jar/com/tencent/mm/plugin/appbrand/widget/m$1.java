package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$1
  implements View.OnApplyWindowInsetsListener
{
  m$1(m paramm, View paramView) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(143621);
    this.jaL.fa.set(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    t.R(paramView);
    if (this.jaM == paramView)
    {
      AppMethodBeat.o(143621);
      return paramWindowInsets;
    }
    paramView = paramView.onApplyWindowInsets(paramWindowInsets);
    AppMethodBeat.o(143621);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.m.1
 * JD-Core Version:    0.7.0.1
 */