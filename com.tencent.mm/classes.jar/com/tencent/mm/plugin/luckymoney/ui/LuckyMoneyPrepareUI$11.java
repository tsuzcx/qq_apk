package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class LuckyMoneyPrepareUI$11
  implements TextWatcher
{
  LuckyMoneyPrepareUI$11(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(65837);
    String str = paramEditable.toString();
    int i;
    int j;
    if (str.startsWith("."))
    {
      paramEditable.insert(0, "0");
      str = paramEditable.toString();
      i = str.indexOf(".");
      j = str.length();
      if ((i < 0) || (j - i <= 3)) {
        break label108;
      }
      paramEditable.delete(i + 3, j);
    }
    for (;;)
    {
      this.val$hintTv.setContentDescription(paramEditable.toString());
      AppMethodBeat.o(65837);
      return;
      if (!WalletFormView.a(str, this.val$hintTv)) {
        break;
      }
      AppMethodBeat.o(65837);
      return;
      label108:
      if (i > 6) {
        paramEditable.delete(6, i);
      } else if ((i == -1) && (j > 6)) {
        paramEditable.delete(6, j);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.11
 * JD-Core Version:    0.7.0.1
 */