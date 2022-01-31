package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNotHookReceiveUI$11
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$11(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42858);
    ((c)g.E(c.class)).eJ(10, 3);
    h.qsU.e(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.yG(LuckyMoneyNotHookReceiveUI.i(this.ovv).cMP)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(this.ovv)), Integer.valueOf(0), Integer.valueOf(2) });
    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
    LuckyMoneyNotHookReceiveUI.k(this.ovv).setClickable(false);
    paramView = this.ovv;
    paramView.doSceneProgress(new an(paramView.opT.msgType, paramView.opT.bWu, paramView.opT.ojA, paramView.opT.cMO, x.bNq(), r.Zp(), paramView.getIntent().getStringExtra("key_username"), "v1.0", paramView.opT.opM), false);
    x.c(paramView.okg);
    AppMethodBeat.o(42858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.11
 * JD-Core Version:    0.7.0.1
 */