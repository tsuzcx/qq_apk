package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class l$10
  implements View.OnClickListener
{
  l$10(l paraml) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125143);
    this.gFF.gFq.gEs[1] = 1;
    this.gFF.gFq.fme = 6;
    g.Rc().a(145, this.gFF);
    l.a(this.gFF);
    AppMethodBeat.o(125143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.10
 * JD-Core Version:    0.7.0.1
 */