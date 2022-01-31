package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
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
    b.a(this.iwc.hxN, false);
    am.aAw().aAf();
    this.iwc.aCb();
    h.nFQ.f(11324, new Object[] { "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i.2
 * JD-Core Version:    0.7.0.1
 */