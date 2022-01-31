package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class QrRewardMainUI$1
  implements TextWatcher
{
  int kPM = 0;
  
  QrRewardMainUI$1(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(41083);
    ab.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramEditable.toString(), Integer.valueOf(paramEditable.length()) });
    String str = paramEditable.toString();
    if (bo.isNullOrNil(str)) {
      this.kPM = 0;
    }
    for (;;)
    {
      paramEditable.delete(this.kPM, paramEditable.length());
      AppMethodBeat.o(41083);
      return;
      if (this.kPM == 0) {
        if ((((a)g.E(a.class)).E(str)) || (((a)g.E(a.class)).F(str))) {
          this.kPM = paramEditable.length();
        } else {
          this.kPM = 1;
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.1
 * JD-Core Version:    0.7.0.1
 */