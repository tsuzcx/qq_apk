package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyBusiDetailUI$4
  implements View.OnClickListener
{
  LuckyMoneyBusiDetailUI$4(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.lUJ.lNq))
    {
      y.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + this.lUJ.lNq);
      if (this.lUJ.lNq.startsWith("weixin://wxpay"))
      {
        e.Jc(12);
        h.Z(this.lUH.mController.uMN, 1);
        return;
      }
      e.Jc(7);
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.lUJ.lNq);
      d.b(this.lUH.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
      return;
    }
    e.Jc(12);
    h.Z(this.lUH.mController.uMN, 1);
    y.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.4
 * JD-Core Version:    0.7.0.1
 */