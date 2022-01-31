package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$3
  implements View.OnClickListener
{
  g$3(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22153);
    if (paramView == g.b(this.nTF))
    {
      g.a(this.nTF, 1);
      AppMethodBeat.o(22153);
      return;
    }
    if (paramView == g.c(this.nTF))
    {
      g.a(this.nTF, 2);
      AppMethodBeat.o(22153);
      return;
    }
    if (paramView == g.d(this.nTF)) {
      g.a(this.nTF, 3);
    }
    AppMethodBeat.o(22153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.3
 * JD-Core Version:    0.7.0.1
 */