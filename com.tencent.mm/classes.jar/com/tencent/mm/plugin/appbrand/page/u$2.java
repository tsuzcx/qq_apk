package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$2
  implements Runnable
{
  u$2(u paramu, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(47800);
    this.lam.setVisibility(8);
    if ((this.lam.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.lam.getParent()).removeView(this.lam);
    }
    AppMethodBeat.o(47800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.2
 * JD-Core Version:    0.7.0.1
 */