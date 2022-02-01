package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;

final class LuckyMoneyDetailUI$22
  implements d.a
{
  LuckyMoneyDetailUI$22(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, Dialog paramDialog) {}
  
  public final void cn(Object paramObject)
  {
    AppMethodBeat.i(213375);
    if (this.tcT != null) {
      this.tcT.dismiss();
    }
    Log.i("MicroMsg.LuckyMoneyDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label71;
      }
    }
    label71:
    for (paramObject = paramObject.toString();; paramObject = this.zee.getString(2131767869))
    {
      Toast.makeText(this.zee.getContext(), paramObject, 1).show();
      AppMethodBeat.o(213375);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.22
 * JD-Core Version:    0.7.0.1
 */