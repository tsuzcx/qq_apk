package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;

final class v$18
  implements f.b
{
  v$18(v paramv) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(141690);
    this.ixv.getActionBar().getCapsuleBar().pause();
    this.ixv.ixk.setActuallyVisible(false);
    AppMethodBeat.o(141690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v.18
 * JD-Core Version:    0.7.0.1
 */