package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.b.a;

final class c$6
  implements b.a
{
  c$6(c paramc) {}
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(182055);
    ad.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramBoolean) });
    c.e(this.vgy, paramBoolean);
    AppMethodBeat.o(182055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.6
 * JD-Core Version:    0.7.0.1
 */