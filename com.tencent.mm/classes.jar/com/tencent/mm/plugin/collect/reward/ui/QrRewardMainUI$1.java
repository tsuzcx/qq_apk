package com.tencent.mm.plugin.collect.reward.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$1
  implements TextWatcher
{
  int iJh = 0;
  
  QrRewardMainUI$1(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    y.d("MicroMsg.QrRewardMainUI", "s: %s, %s", new Object[] { paramEditable.toString(), Integer.valueOf(paramEditable.length()) });
    String str = paramEditable.toString();
    if (bk.bl(str)) {
      this.iJh = 0;
    }
    for (;;)
    {
      paramEditable.delete(this.iJh, paramEditable.length());
      return;
      if (this.iJh == 0) {
        if ((((a)g.r(a.class)).v(str)) || (((a)g.r(a.class)).w(str))) {
          this.iJh = paramEditable.length();
        } else {
          this.iJh = 1;
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.1
 * JD-Core Version:    0.7.0.1
 */