package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$4
  implements View.OnClickListener
{
  HoneyPayMainUI$4(HoneyPayMainUI paramHoneyPayMainUI, hj paramhj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41884);
    e.m(this.nJe.getContext(), this.nJg.url, true);
    AppMethodBeat.o(41884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.4
 * JD-Core Version:    0.7.0.1
 */