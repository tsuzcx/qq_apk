package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$7
  implements View.OnClickListener
{
  LuckyMoneyWishFooter$7(LuckyMoneyWishFooter paramLuckyMoneyWishFooter, LuckyMoneyWishFooter.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43054);
    this.oxw.Sw(LuckyMoneyWishFooter.b(this.oxv).getText().toString());
    LuckyMoneyWishFooter.b(this.oxv).setText("");
    AppMethodBeat.o(43054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.7
 * JD-Core Version:    0.7.0.1
 */