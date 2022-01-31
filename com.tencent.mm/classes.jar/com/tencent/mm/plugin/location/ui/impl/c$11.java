package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ab;

final class c$11
  implements View.OnClickListener
{
  c$11(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113606);
    ab.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.g(this.ogD)), Double.valueOf(c.h(this.ogD)) });
    if ((c.g(this.ogD) == -85.0D) || (c.h(this.ogD) == -1000.0D))
    {
      ab.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
      AppMethodBeat.o(113606);
      return;
    }
    this.ogD.ocL.getIController().animateTo(c.g(this.ogD), c.h(this.ogD));
    c.a(this.ogD, c.g(this.ogD));
    c.b(this.ogD, c.h(this.ogD));
    c.k(this.ogD).l(c.i(this.ogD), c.j(this.ogD));
    c.l(this.ogD).setBackgroundResource(2130839296);
    c.l(this.ogD).setEnabled(true);
    c.m(this.ogD);
    c.n(this.ogD);
    c.o(this.ogD).ogy = false;
    AppMethodBeat.o(113606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.11
 * JD-Core Version:    0.7.0.1
 */