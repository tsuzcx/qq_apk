package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class HoneyPayCheckPwdUI$1
  implements EditHintPasswdView.a
{
  HoneyPayCheckPwdUI$1(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(41833);
    if (paramBoolean)
    {
      if (HoneyPayCheckPwdUI.a(this.nII) != 1) {
        break label40;
      }
      HoneyPayCheckPwdUI.b(this.nII);
    }
    for (;;)
    {
      this.nII.hideTenpayKB();
      AppMethodBeat.o(41833);
      return;
      label40:
      if (HoneyPayCheckPwdUI.a(this.nII) == 2) {
        HoneyPayCheckPwdUI.c(this.nII);
      } else if (HoneyPayCheckPwdUI.a(this.nII) == 3) {
        HoneyPayCheckPwdUI.d(this.nII);
      } else {
        ab.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", new Object[] { Integer.valueOf(HoneyPayCheckPwdUI.a(this.nII)) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.1
 * JD-Core Version:    0.7.0.1
 */