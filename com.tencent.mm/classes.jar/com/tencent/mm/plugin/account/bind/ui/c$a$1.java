package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a$1
  implements View.OnClickListener
{
  c$a$1(c.a parama, c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13698);
    if (c.f(this.gvM.gvE) != null) {
      c.f(this.gvM.gvE).c(this.gvM.gvH, this.gvM.cqq, this.gvM.status);
    }
    AppMethodBeat.o(13698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.a.1
 * JD-Core Version:    0.7.0.1
 */