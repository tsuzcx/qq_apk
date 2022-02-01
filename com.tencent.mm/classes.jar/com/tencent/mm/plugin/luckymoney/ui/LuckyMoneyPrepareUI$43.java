package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.a.a;

final class LuckyMoneyPrepareUI$43
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$43(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString, l paraml1, l paraml2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(65879);
    if (!a.a.eSf().eSe())
    {
      AppMethodBeat.o(65879);
      return;
    }
    if (LuckyMoneyPrepareUI.f(this.tpT).getText().toString().equals(this.sZJ.toString()))
    {
      this.tqe.onClick(paramView);
      AppMethodBeat.o(65879);
      return;
    }
    this.tqf.onClick(paramView);
    AppMethodBeat.o(65879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.43
 * JD-Core Version:    0.7.0.1
 */