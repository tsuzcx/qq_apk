package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.ui.base.h;

final class g$1
  implements View.OnLongClickListener
{
  g$1(g paramg) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(88744);
    if (paramView.getId() == 2131822013)
    {
      p.xJ(this.kBd.klk.bbe().code);
      h.bO(this.kBd.jpX, this.kBd.getString(2131296896));
    }
    AppMethodBeat.o(88744);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g.1
 * JD-Core Version:    0.7.0.1
 */