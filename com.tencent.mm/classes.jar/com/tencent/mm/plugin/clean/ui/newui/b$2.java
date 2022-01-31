package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

final class b$2
  implements GridHeadersGridView.c
{
  b$2(b paramb) {}
  
  public final void di(View paramView)
  {
    AppMethodBeat.i(18848);
    paramView = (b.a)paramView.getTag();
    b.a(this.kJe, paramView);
    this.kJe.notifyDataSetChanged();
    AppMethodBeat.o(18848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.2
 * JD-Core Version:    0.7.0.1
 */