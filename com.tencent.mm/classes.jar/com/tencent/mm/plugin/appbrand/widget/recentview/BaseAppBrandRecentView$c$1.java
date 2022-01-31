package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseAppBrandRecentView$c$1
  implements View.OnClickListener
{
  BaseAppBrandRecentView$c$1(BaseAppBrandRecentView.c paramc, BaseAppBrandRecentView paramBaseAppBrandRecentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134350);
    a locala = (a)paramView.getTag();
    locala.position = this.jvw.jN();
    if (this.jvw.jvt.getOnItemClickListener() != null) {
      this.jvw.jvt.getOnItemClickListener().a(paramView, locala, BaseAppBrandRecentView.c(this.jvw.jvt), BaseAppBrandRecentView.d(this.jvw.jvt));
    }
    AppMethodBeat.o(134350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c.1
 * JD-Core Version:    0.7.0.1
 */