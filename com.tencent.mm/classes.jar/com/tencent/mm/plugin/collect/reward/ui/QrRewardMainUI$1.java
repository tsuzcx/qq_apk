package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class QrRewardMainUI$1
  implements TextWatcher
{
  int xba = 0;
  
  QrRewardMainUI$1(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(63942);
    Log.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramEditable.toString(), Integer.valueOf(paramEditable.length()) });
    String str = paramEditable.toString();
    if (Util.isNullOrNil(str)) {
      this.xba = 0;
    }
    for (;;)
    {
      paramEditable.delete(this.xba, paramEditable.length());
      AppMethodBeat.o(63942);
      return;
      if (this.xba == 0) {
        if ((((a)h.ax(a.class)).aa(str)) || (((a)h.ax(a.class)).ab(str))) {
          this.xba = paramEditable.length();
        } else {
          this.xba = 1;
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.1
 * JD-Core Version:    0.7.0.1
 */