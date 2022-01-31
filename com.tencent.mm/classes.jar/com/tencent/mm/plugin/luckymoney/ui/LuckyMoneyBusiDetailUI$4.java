package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyBusiDetailUI$4
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$4(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42586);
    if (!TextUtils.isEmpty(this.orS.okK))
    {
      ab.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + this.orS.okK);
      if (this.orS.okK.startsWith("weixin://wxpay"))
      {
        e.RX(12);
        h.an(this.orQ.getContext(), 1);
        AppMethodBeat.o(42586);
        return;
      }
      e.RX(7);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.orS.okK);
      d.b(this.orQ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      AppMethodBeat.o(42586);
      return;
    }
    e.RX(12);
    h.an(this.orQ.getContext(), 1);
    ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
    AppMethodBeat.o(42586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.4
 * JD-Core Version:    0.7.0.1
 */