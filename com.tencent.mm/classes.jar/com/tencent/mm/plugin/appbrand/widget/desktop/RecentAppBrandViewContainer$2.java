package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecentAppBrandViewContainer$2
  implements View.OnClickListener
{
  RecentAppBrandViewContainer$2(RecentAppBrandViewContainer paramRecentAppBrandViewContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133951);
    if (RecentAppBrandViewContainer.b(this.jgk) != null) {
      RecentAppBrandViewContainer.b(this.jgk).onClick(paramView);
    }
    AppMethodBeat.o(133951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.2
 * JD-Core Version:    0.7.0.1
 */