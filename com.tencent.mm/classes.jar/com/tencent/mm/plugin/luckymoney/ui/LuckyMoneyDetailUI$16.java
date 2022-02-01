package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.d.a;

final class LuckyMoneyDetailUI$16
  implements d.a
{
  LuckyMoneyDetailUI$16(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, Dialog paramDialog) {}
  
  public final void cc(Object paramObject)
  {
    AppMethodBeat.i(163729);
    if (this.qLa != null) {
      this.qLa.dismiss();
    }
    ac.i("MicroMsg.LuckyMoneyDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label71;
      }
    }
    label71:
    for (paramObject = paramObject.toString();; paramObject = this.uux.getString(2131765420))
    {
      Toast.makeText(this.uux.getContext(), paramObject, 1).show();
      AppMethodBeat.o(163729);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.16
 * JD-Core Version:    0.7.0.1
 */