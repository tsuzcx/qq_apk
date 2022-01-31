package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.sdk.platformtools.ab;

final class HoneyPaySelectCardTypeUI$a$2
  implements View.OnClickListener
{
  HoneyPaySelectCardTypeUI$a$2(HoneyPaySelectCardTypeUI.a parama, aua paramaua) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41954);
    ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
    if (HoneyPaySelectCardTypeUI.a(this.nJS.nJM) != null)
    {
      HoneyPaySelectCardTypeUI.a(this.nJS.nJM, HoneyPaySelectCardTypeUI.a(this.nJS.nJM));
      AppMethodBeat.o(41954);
      return;
    }
    HoneyPaySelectCardTypeUI.a(this.nJS.nJM, this.nJR.iFL);
    HoneyPaySelectCardTypeUI.b(this.nJS.nJM);
    AppMethodBeat.o(41954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.2
 * JD-Core Version:    0.7.0.1
 */