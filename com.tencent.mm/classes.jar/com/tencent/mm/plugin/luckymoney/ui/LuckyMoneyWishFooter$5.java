package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class LuckyMoneyWishFooter$5
  implements View.OnTouchListener
{
  LuckyMoneyWishFooter$5(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(43051);
    LuckyMoneyWishFooter.e(this.oxv);
    LuckyMoneyWishFooter.a(this.oxv).setVisibility(8);
    LuckyMoneyWishFooter.a(this.oxv).onPause();
    LuckyMoneyWishFooter.d(this.oxv).setImageResource(2130838345);
    if (LuckyMoneyWishFooter.g(this.oxv) != null) {
      LuckyMoneyWishFooter.g(this.oxv);
    }
    LuckyMoneyWishFooter.a(this.oxv, 0);
    AppMethodBeat.o(43051);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.5
 * JD-Core Version:    0.7.0.1
 */