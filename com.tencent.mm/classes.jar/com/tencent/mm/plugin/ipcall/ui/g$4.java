package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.d;

final class g$4
  implements View.OnClickListener
{
  g$4(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22154);
    this.nTF.dismiss();
    d.a(-1, 1, -1, "", 0, -1, -1, g.e(this.nTF), g.f(this.nTF));
    AppMethodBeat.o(22154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.4
 * JD-Core Version:    0.7.0.1
 */