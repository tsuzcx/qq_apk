package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.g;
import com.tencent.mm.wallet_core.ui.e;

final class h$a$1
  implements View.OnClickListener
{
  h$a$1(h.a parama, as paramas, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42893);
    h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ovF.opO) });
    if (this.ovG.ovE != null) {
      g.gK(this.ovG.ovE.ovK, 1);
    }
    e.m(this.val$context, this.ovF.content, true);
    AppMethodBeat.o(42893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.a.1
 * JD-Core Version:    0.7.0.1
 */