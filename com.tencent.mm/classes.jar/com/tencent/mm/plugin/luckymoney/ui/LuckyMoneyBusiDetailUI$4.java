package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;

final class LuckyMoneyBusiDetailUI$4
  extends k
{
  LuckyMoneyBusiDetailUI$4(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, q paramq, Context paramContext) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(284091);
    if (!TextUtils.isEmpty(this.KAd.Kot))
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + this.KAd.Kot);
      if (this.KAd.Kot.startsWith("weixin://wxpay"))
      {
        i.aGA(12);
        f.bq(this.KAb.getContext(), 1);
        AppMethodBeat.o(284091);
        return;
      }
      i.aGA(7);
      i.bC(this.val$context, this.KAd.Kot);
      AppMethodBeat.o(284091);
      return;
    }
    i.aGA(12);
    f.bq(this.KAb.getContext(), 1);
    Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
    AppMethodBeat.o(284091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.4
 * JD-Core Version:    0.7.0.1
 */