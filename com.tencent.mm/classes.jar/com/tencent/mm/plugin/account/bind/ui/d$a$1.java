package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a$1
  implements View.OnClickListener
{
  d$a$1(d.a parama, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13710);
    if (d.f(this.gvU.gvN) != null) {
      d.f(this.gvU.gvN).c(this.gvU.gvH, this.gvU.account, this.gvU.status);
    }
    AppMethodBeat.o(13710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */