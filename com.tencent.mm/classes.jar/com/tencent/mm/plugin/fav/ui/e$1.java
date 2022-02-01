package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class e$1
  implements a.b
{
  public final void bDZ()
  {
    AppMethodBeat.i(106670);
    hb localhb = new hb();
    localhb.dLm.type = 35;
    EventCenter.instance.publish(localhb);
    AppMethodBeat.o(106670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.1
 * JD-Core Version:    0.7.0.1
 */