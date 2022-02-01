package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class LuckyMoneyPrepareUI$10
  implements q.f
{
  LuckyMoneyPrepareUI$10(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(211114);
    paramo.add(0, 0, 0, this.ENG.getString(a.i.lucky_money_check_mine_title_opt));
    paramo.add(0, 1, 0, this.ENG.getString(a.i.wallet_index_ui_opt_common_questions));
    AppMethodBeat.o(211114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */