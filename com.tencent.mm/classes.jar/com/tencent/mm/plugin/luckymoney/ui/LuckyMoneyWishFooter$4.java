package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyWishFooter$4
  implements View.OnClickListener
{
  LuckyMoneyWishFooter$4(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43050);
    ab.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.c(this.oxv));
    if (LuckyMoneyWishFooter.c(this.oxv) == 0)
    {
      this.oxv.setModeClick(true);
      LuckyMoneyWishFooter.d(this.oxv).setImageResource(2131231506);
      LuckyMoneyWishFooter.a(this.oxv, 1);
      LuckyMoneyWishFooter.e(this.oxv);
    }
    for (;;)
    {
      LuckyMoneyWishFooter.f(this.oxv);
      AppMethodBeat.o(43050);
      return;
      this.oxv.setModeClick(false);
      LuckyMoneyWishFooter.e(this.oxv);
      LuckyMoneyWishFooter.d(this.oxv).setImageResource(2131231506);
      LuckyMoneyWishFooter.a(this.oxv, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.4
 * JD-Core Version:    0.7.0.1
 */