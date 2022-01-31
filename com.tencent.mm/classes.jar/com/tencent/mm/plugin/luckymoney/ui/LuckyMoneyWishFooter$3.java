package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class LuckyMoneyWishFooter$3
  implements View.OnTouchListener
{
  LuckyMoneyWishFooter$3(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    LuckyMoneyWishFooter.f(this.lXW);
    LuckyMoneyWishFooter.g(this.lXW).setVisibility(8);
    LuckyMoneyWishFooter.g(this.lXW).onPause();
    LuckyMoneyWishFooter.e(this.lXW).setImageResource(a.e.chatting_setmode_biaoqing_btn);
    LuckyMoneyWishFooter.a(this.lXW, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.3
 * JD-Core Version:    0.7.0.1
 */