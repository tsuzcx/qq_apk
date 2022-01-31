package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ac;

final class LuckyMoneyBusiReceiveUI$9
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$9(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42626);
    paramView = new Intent();
    paramView.setClass(this.osi.getContext(), LuckyMoneyBusiDetailUI.class);
    if (this.osk.okp != null) {
      paramView.putExtra("key_realname_guide_helper", this.osk.okp);
    }
    paramView.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(this.osi));
    paramView.putExtra("key_sendid", this.osk.ojA);
    paramView.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(this.osi));
    this.osi.startActivity(paramView);
    this.osi.finish();
    AppMethodBeat.o(42626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.9
 * JD-Core Version:    0.7.0.1
 */