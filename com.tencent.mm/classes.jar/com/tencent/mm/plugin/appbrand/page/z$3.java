package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

final class z$3
  implements View.OnAttachStateChangeListener
{
  z$3(z paramz) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(143496);
    if ((this.ixG.getRuntime() != null) && (this.ixG.getRuntime().mResumed))
    {
      AppMethodBeat.o(143496);
      return;
    }
    this.ixG.ap(paramView.getContext().getApplicationContext());
    AppMethodBeat.o(143496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.3
 * JD-Core Version:    0.7.0.1
 */