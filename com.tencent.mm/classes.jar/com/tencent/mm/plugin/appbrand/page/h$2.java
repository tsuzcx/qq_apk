package com.tencent.mm.plugin.appbrand.page;

import android.support.v4.view.t;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.i.a;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(87038);
    if ((t.aw(this.ivQ)) && ((h.b(this.ivQ).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (((ViewGroup.MarginLayoutParams)h.b(this.ivQ).getLayoutParams()).topMargin != h.b(this.ivQ).getTop())) {
      h.b(this.ivQ).requestLayout();
    }
    AppMethodBeat.o(87038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.2
 * JD-Core Version:    0.7.0.1
 */