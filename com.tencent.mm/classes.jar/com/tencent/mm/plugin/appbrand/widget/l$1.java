package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$1
  implements View.OnApplyWindowInsetsListener
{
  l$1(l paraml, View paramView) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(49370);
    this.olC.olz.set(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    u.X(paramView);
    if (this.nFs == paramView)
    {
      AppMethodBeat.o(49370);
      return paramWindowInsets;
    }
    paramView = paramView.onApplyWindowInsets(paramWindowInsets);
    AppMethodBeat.o(49370);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.l.1
 * JD-Core Version:    0.7.0.1
 */