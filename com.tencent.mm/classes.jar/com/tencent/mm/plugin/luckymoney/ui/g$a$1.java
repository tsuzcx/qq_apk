package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.wallet_core.ui.e;

final class g$a$1
  implements View.OnClickListener
{
  g$a$1(g.a parama, ai paramai, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.lWR.lRN) });
    if (this.lWS.lWQ != null) {
      f.eZ(this.lWS.lWQ.lWW, 1);
    }
    e.l(this.val$context, this.lWR.content, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.a.1
 * JD-Core Version:    0.7.0.1
 */