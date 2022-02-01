package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;

final class LuckyMoneyDetailUI$25
  implements d.a
{
  LuckyMoneyDetailUI$25(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, Dialog paramDialog) {}
  
  public final void cm(Object paramObject)
  {
    AppMethodBeat.i(275029);
    if (this.wJe != null) {
      this.wJe.dismiss();
    }
    Log.i("MicroMsg.LuckyMoneyDetailUI", "fetch detail failed: %s", new Object[] { paramObject });
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label71;
      }
    }
    label71:
    for (paramObject = paramObject.toString();; paramObject = this.EIF.getString(a.i.wallet_lqt_network_error))
    {
      Toast.makeText(this.EIF.getContext(), paramObject, 1).show();
      AppMethodBeat.o(275029);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.25
 * JD-Core Version:    0.7.0.1
 */