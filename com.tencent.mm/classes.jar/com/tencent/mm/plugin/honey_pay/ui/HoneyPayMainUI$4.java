package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$4
  implements View.OnClickListener
{
  HoneyPayMainUI$4(HoneyPayMainUI paramHoneyPayMainUI, in paramin) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64773);
    e.n(this.tEA.getContext(), this.tEC.url, true);
    AppMethodBeat.o(64773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.4
 * JD-Core Version:    0.7.0.1
 */