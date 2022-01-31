package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.widget.MMEditText;

final class LuckyMoneyWishFooter$1
  implements TextWatcher
{
  LuckyMoneyWishFooter$1(LuckyMoneyWishFooter paramLuckyMoneyWishFooter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (LuckyMoneyWishFooter.a(this.lXW).getText() == null) {
      return;
    }
    LuckyMoneyWishFooter.a(this.lXW).requestFocus();
    if ((paramEditable.length() > 0) && (paramEditable.toString().trim().length() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.lXW.lXS))
      {
        LuckyMoneyWishFooter.a(this.lXW, true);
        this.lXW.lXS = false;
      }
      if (i != 0) {
        break;
      }
      LuckyMoneyWishFooter.a(this.lXW, false);
      this.lXW.lXS = true;
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.1
 * JD-Core Version:    0.7.0.1
 */