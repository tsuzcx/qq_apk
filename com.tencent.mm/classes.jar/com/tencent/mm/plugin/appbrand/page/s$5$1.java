package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$5$1
  implements Runnable
{
  s$5$1(s.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(143469);
    this.iwV.iwU.setVisibility(8);
    if ((this.iwV.iwU.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.iwV.iwU.getParent()).removeView(this.iwV.iwU);
    }
    AppMethodBeat.o(143469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.5.1
 * JD-Core Version:    0.7.0.1
 */