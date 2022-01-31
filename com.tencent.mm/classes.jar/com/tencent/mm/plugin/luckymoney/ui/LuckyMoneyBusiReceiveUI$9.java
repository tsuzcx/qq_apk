package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyBusiReceiveUI$9
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$9(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, t paramt) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.lUZ.mController.uMN, LuckyMoneyBusiDetailUI.class);
    if (this.lVb.lMW != null) {
      paramView.putExtra("key_realname_guide_helper", this.lVb.lMW);
    }
    paramView.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(this.lUZ));
    paramView.putExtra("key_sendid", this.lVb.lMg);
    paramView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(this.lUZ));
    this.lUZ.startActivity(paramView);
    this.lUZ.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.9
 * JD-Core Version:    0.7.0.1
 */