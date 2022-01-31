package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.af;

final class p$3
  implements View.OnAttachStateChangeListener
{
  p$3(p paramp) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(141660);
    if (af.dDl())
    {
      View localView = paramView.getRootView().findViewById(2131826157);
      if (localView == null)
      {
        AppMethodBeat.o(141660);
        return;
      }
      try
      {
        int i = localView.getLayoutParams().width;
        int j = a.fromDPToPix(paramView.getContext(), 400);
        localView.getLayoutParams().width = Math.min(i, j);
        localView.setLayoutParams(localView.getLayoutParams());
        localView.requestLayout();
        AppMethodBeat.o(141660);
        return;
      }
      catch (Exception paramView)
      {
        d.e("MicroMsg.AppBrandPageActionSheet", "onViewAttachedToWindow, try modify sheet width for landscape tablet, e=%s", new Object[] { paramView });
      }
    }
    AppMethodBeat.o(141660);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p.3
 * JD-Core Version:    0.7.0.1
 */