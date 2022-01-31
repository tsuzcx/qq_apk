package com.tencent.mm.plugin.luckymoney.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$4
  implements ChatFooterPanel.a
{
  LuckyMoneyWishFooter$4(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void append(String paramString)
  {
    try
    {
      LuckyMoneyWishFooter.a(this.lXW).aex(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
    }
  }
  
  public final void asj()
  {
    LuckyMoneyWishFooter.a(this.lXW).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    LuckyMoneyWishFooter.a(this.lXW).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
  }
  
  public final void bgv() {}
  
  public final void hp(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.4
 * JD-Core Version:    0.7.0.1
 */