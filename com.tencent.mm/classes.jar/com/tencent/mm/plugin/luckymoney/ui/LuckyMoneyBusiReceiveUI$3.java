package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;

final class LuckyMoneyBusiReceiveUI$3
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$3(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42618);
    paramView = new Bundle();
    paramView.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
    paramView.putString("realname_verify_process_jump_plugin", "luckymoney");
    if ((LuckyMoneyBusiReceiveUI.d(this.osi) != null) && (LuckyMoneyBusiReceiveUI.d(this.osi).a(this.osi, paramView, null, null, true)))
    {
      LuckyMoneyBusiReceiveUI.e(this.osi);
      AppMethodBeat.o(42618);
      return;
    }
    this.osi.finish();
    AppMethodBeat.o(42618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */