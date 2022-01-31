package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class g$e$1
  implements View.OnClickListener
{
  g$e$1(g.e parame, ai paramai, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.lWR.lRN) });
    if (this.lWX.lWQ != null) {
      f.eZ(this.lWX.lWQ.lWW, 1);
    }
    if ((this.lWX.lWQ != null) && (this.lWX.lWQ.lWV)) {
      h.nFQ.f(13051, new Object[] { Integer.valueOf(this.lWX.lWQ.lWW), Integer.valueOf(2), "", "", "", this.lWR.content, this.lWR.type, "", "", Integer.valueOf(this.lWX.lWQ.resourceId) });
    }
    if (this.lWR.type.equals("Native"))
    {
      y.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + this.lWR.content);
      if ("weixin://festival/gotoshake".equalsIgnoreCase(this.lWR.content)) {
        y.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
      }
      return;
    }
    e.l(this.val$context, this.lWR.content, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.g.e.1
 * JD-Core Version:    0.7.0.1
 */