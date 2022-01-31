package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class HoneyPayCheckPwdUI$1
  implements EditHintPasswdView.a
{
  HoneyPayCheckPwdUI$1(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (HoneyPayCheckPwdUI.a(this.llm) != 1) {
        break label30;
      }
      HoneyPayCheckPwdUI.b(this.llm);
    }
    for (;;)
    {
      this.llm.VH();
      return;
      label30:
      if (HoneyPayCheckPwdUI.a(this.llm) == 2) {
        HoneyPayCheckPwdUI.c(this.llm);
      } else if (HoneyPayCheckPwdUI.a(this.llm) == 3) {
        HoneyPayCheckPwdUI.d(this.llm);
      } else {
        y.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", new Object[] { Integer.valueOf(HoneyPayCheckPwdUI.a(this.llm)) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.1
 * JD-Core Version:    0.7.0.1
 */