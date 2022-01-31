package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$16
  implements View.OnClickListener
{
  c$16(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113612);
    if (!c.q(this.ogD)) {
      c.u(this.ogD);
    }
    c.v(this.ogD).clean();
    c.w(this.ogD).setAdapter(c.v(this.ogD));
    c.v(this.ogD).notifyDataSetChanged();
    c.x(this.ogD).setVisibility(8);
    AppMethodBeat.o(113612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.16
 * JD-Core Version:    0.7.0.1
 */