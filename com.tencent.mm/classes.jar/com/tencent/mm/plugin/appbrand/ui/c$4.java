package com.tencent.mm.plugin.appbrand.ui;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class c$4
  implements Runnable
{
  c$4(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(132937);
    if (c.g(this.iMp))
    {
      AppMethodBeat.o(132937);
      return;
    }
    c.h(this.iMp);
    c.i(this.iMp).setVisibility(0);
    c.j(this.iMp).setVisibility(0);
    c.k(this.iMp).setVisibility(0);
    c.l(this.iMp);
    AppMethodBeat.o(132937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.4
 * JD-Core Version:    0.7.0.1
 */