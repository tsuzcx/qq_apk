package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a$1
  implements View.OnClickListener
{
  i$a$1(i.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22344);
    if (i.a.a(this.nWr) != null) {
      i.a.a(this.nWr).onClick(paramView);
    }
    AppMethodBeat.o(22344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.a.1
 * JD-Core Version:    0.7.0.1
 */