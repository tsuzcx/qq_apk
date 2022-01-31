package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.wallet_core.ui.e;

final class h$b$1
  implements View.OnClickListener
{
  h$b$1(h.b paramb, as paramas, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42896);
    h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ovF.opO) });
    if (this.ovF.opP != 1)
    {
      ((com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.g.class)).a(this.val$context, this.ovF.content, new h.b.1.1(this)).show();
      AppMethodBeat.o(42896);
      return;
    }
    e.ad(this.val$context, this.ovF.content);
    AppMethodBeat.o(42896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.b.1
 * JD-Core Version:    0.7.0.1
 */