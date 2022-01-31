package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;

final class i$2
  implements View.OnClickListener
{
  i$2(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88589);
    b.a(this.kxg.jpX, false);
    am.bch().bbR();
    this.kxg.bel();
    h.qsU.e(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(88589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i.2
 * JD-Core Version:    0.7.0.1
 */