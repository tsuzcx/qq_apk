package com.tencent.luggage.game.page;

import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.ar;

final class h$3
  implements ar
{
  h$3(h paramh) {}
  
  public final void a(AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(140508);
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null)) {
      h.b(this.bCd).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(140508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.h.3
 * JD-Core Version:    0.7.0.1
 */