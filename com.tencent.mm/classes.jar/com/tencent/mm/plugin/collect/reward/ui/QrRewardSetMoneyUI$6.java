package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class QrRewardSetMoneyUI$6
  implements TextWatcher
{
  QrRewardSetMoneyUI$6(QrRewardSetMoneyUI paramQrRewardSetMoneyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(41154);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 3)) {
      paramEditable.delete(i + 3, j);
    }
    for (;;)
    {
      al.ae(QrRewardSetMoneyUI.d(this.kQu));
      al.p(QrRewardSetMoneyUI.d(this.kQu), 50L);
      AppMethodBeat.o(41154);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.6
 * JD-Core Version:    0.7.0.1
 */