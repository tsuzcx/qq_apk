package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyReceiveUI$8
  implements View.OnClickListener
{
  LuckyMoneyReceiveUI$8(LuckyMoneyReceiveUI paramLuckyMoneyReceiveUI, ad paramad) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    if (this.lWv.lMW != null) {
      paramView.putExtra("key_realname_guide_helper", this.lWv.lMW);
    }
    paramView.setClass(this.lXA.mController.uMN, LuckyMoneyDetailUI.class);
    paramView.putExtra("key_native_url", this.lWv.ceb);
    paramView.putExtra("key_sendid", this.lWv.lMg);
    this.lXA.startActivity(paramView);
    this.lXA.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI.8
 * JD-Core Version:    0.7.0.1
 */