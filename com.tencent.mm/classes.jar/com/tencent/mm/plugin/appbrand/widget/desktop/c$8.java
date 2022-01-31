package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class c$8
  implements Runnable
{
  c$8(c paramc, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void run()
  {
    AppMethodBeat.i(133786);
    ((BaseAppBrandRecentView.c)this.acv).jft.animate().scaleX(1.0F).scaleY(1.0F).setDuration(150L).setListener(new c.8.1(this)).start();
    AppMethodBeat.o(133786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.8
 * JD-Core Version:    0.7.0.1
 */