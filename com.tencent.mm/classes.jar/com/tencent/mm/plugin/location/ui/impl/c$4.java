package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c$4
  implements Runnable
{
  c$4(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(182053);
    ad.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", new Object[] { Integer.valueOf(c.w(this.vgy)) });
    c.b(this.vgy, c.x(this.vgy).getHeight());
    c.x(this.vgy).setVisibility(8);
    AppMethodBeat.o(182053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.4
 * JD-Core Version:    0.7.0.1
 */