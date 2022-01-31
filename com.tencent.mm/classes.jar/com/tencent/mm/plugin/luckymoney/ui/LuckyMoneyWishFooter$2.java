package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$2
  implements View.OnClickListener
{
  LuckyMoneyWishFooter$2(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void onClick(View paramView)
  {
    this.lXW.setModeClick(true);
    y.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.b(this.lXW));
    if (LuckyMoneyWishFooter.b(this.lXW) == 0)
    {
      LuckyMoneyWishFooter.c(this.lXW).XM();
      LuckyMoneyWishFooter.a(this.lXW).requestFocus();
      LuckyMoneyWishFooter.d(this.lXW);
      LuckyMoneyWishFooter.e(this.lXW).setImageResource(a.h.textfield_icon_emoji_pressed);
      LuckyMoneyWishFooter.a(this.lXW, 1);
      LuckyMoneyWishFooter.f(this.lXW);
      return;
    }
    LuckyMoneyWishFooter.f(this.lXW);
    LuckyMoneyWishFooter.a(this.lXW).requestFocus();
    LuckyMoneyWishFooter.g(this.lXW).setVisibility(8);
    LuckyMoneyWishFooter.c(this.lXW).showVKB();
    LuckyMoneyWishFooter.e(this.lXW).setImageResource(a.h.textfield_icon_emoji_normal);
    LuckyMoneyWishFooter.a(this.lXW, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.2
 * JD-Core Version:    0.7.0.1
 */