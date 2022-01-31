package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.an;

final class LuckyMoneyNotHookReceiveUI$5
  implements View.OnClickListener
{
  LuckyMoneyNotHookReceiveUI$5(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI, an paraman) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42852);
    paramView = new Intent();
    if (this.ouG.okp != null) {
      paramView.putExtra("key_realname_guide_helper", this.ouG.okp);
    }
    paramView.setClass(this.ovv.getContext(), LuckyMoneyBeforeDetailUI.class);
    paramView.putExtra("key_lucky_money_can_received", true);
    paramView.putExtra("key_native_url", this.ouG.cMO);
    paramView.putExtra("key_sendid", this.ouG.ojA);
    paramView.putExtra("key_username", this.ovv.getIntent().getStringExtra("key_username"));
    paramView.putExtra("key_emoji_switch", this.ouG.opd);
    paramView.putExtra("key_detail_emoji_md5", this.ouG.opb);
    paramView.putExtra("key_detail_emoji_type", this.ouG.opc);
    this.ovv.startActivity(paramView);
    this.ovv.finish();
    AppMethodBeat.o(42852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.5
 * JD-Core Version:    0.7.0.1
 */