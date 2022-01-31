package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class i$4
  implements View.OnClickListener
{
  i$4(i parami, d paramd, List paramList, m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125098);
    this.gFx.gFq.hideVKB();
    this.gEx.crd();
    if (this.gEz.contains(this.gFy))
    {
      this.gFx.gDn.cXw = 1L;
      this.gFx.gDn.cRH = 9L;
      this.gFx.gDn.ake();
    }
    AppMethodBeat.o(125098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.4
 * JD-Core Version:    0.7.0.1
 */