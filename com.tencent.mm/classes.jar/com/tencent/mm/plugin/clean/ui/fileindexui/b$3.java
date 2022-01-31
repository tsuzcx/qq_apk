package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

final class b$3
  implements GridHeadersGridView.c
{
  b$3(b paramb) {}
  
  public final void di(View paramView)
  {
    AppMethodBeat.i(18748);
    paramView = (b.a)paramView.getTag();
    b.a(this.kHM, paramView);
    this.kHM.notifyDataSetChanged();
    AppMethodBeat.o(18748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.3
 * JD-Core Version:    0.7.0.1
 */