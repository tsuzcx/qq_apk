package com.tencent.mm.plugin.luckymoney.sns;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.wallet_core.ui.e;

final class SnsLuckyMoneyPrepareUI$15
  implements j.a
{
  SnsLuckyMoneyPrepareUI$15(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, SpannableString paramSpannableString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42524);
    int i = this.oqN.ojG.getInput();
    double d = this.oqN.oqE.getInput();
    SnsLuckyMoneyPrepareUI.a(this.oqN, 1);
    this.oqN.oqE.setType(SnsLuckyMoneyPrepareUI.a(this.oqN));
    this.oqN.oqE.setTitle(this.oqN.getString(2131301333));
    this.oqN.oqE.setShowGroupIcon(true);
    if ((d > 0.0D) && (i > 0)) {
      this.oqN.oqE.setAmount(e.E(d * i));
    }
    this.oqN.oqE.setMaxAmount(SnsLuckyMoneyPrepareUI.b(this.oqN).oiu);
    SnsLuckyMoneyPrepareUI.c(this.oqN).setText(this.ojW);
    h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.oqN)), Integer.valueOf(2) });
    AppMethodBeat.o(42524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.15
 * JD-Core Version:    0.7.0.1
 */