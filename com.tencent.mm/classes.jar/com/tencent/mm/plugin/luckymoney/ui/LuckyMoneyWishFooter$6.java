package com.tencent.mm.plugin.luckymoney.ui;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$6
  implements ChatFooterPanel.a
{
  LuckyMoneyWishFooter$6(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(43052);
    LuckyMoneyWishFooter.b(this.oxv).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    LuckyMoneyWishFooter.b(this.oxv).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(43052);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(43053);
    try
    {
      LuckyMoneyWishFooter.b(this.oxv).avk(paramString);
      AppMethodBeat.o(43053);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsCommentFooter", paramString, "", new Object[0]);
      AppMethodBeat.o(43053);
    }
  }
  
  public final void bag() {}
  
  public final void fT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.6
 * JD-Core Version:    0.7.0.1
 */