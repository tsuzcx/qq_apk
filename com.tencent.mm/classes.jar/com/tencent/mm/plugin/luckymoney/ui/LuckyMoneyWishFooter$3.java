package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$3
  implements TextWatcher
{
  LuckyMoneyWishFooter$3(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(43049);
    if (LuckyMoneyWishFooter.b(this.oxv).getText() == null)
    {
      AppMethodBeat.o(43049);
      return;
    }
    LuckyMoneyWishFooter.b(this.oxv).requestFocus();
    if ((paramEditable.length() > 0) && (paramEditable.toString().trim().length() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.oxv.oxr))
      {
        LuckyMoneyWishFooter.a(this.oxv, true);
        this.oxv.oxr = false;
      }
      if (i == 0)
      {
        LuckyMoneyWishFooter.a(this.oxv, false);
        this.oxv.oxr = true;
      }
      AppMethodBeat.o(43049);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.3
 * JD-Core Version:    0.7.0.1
 */