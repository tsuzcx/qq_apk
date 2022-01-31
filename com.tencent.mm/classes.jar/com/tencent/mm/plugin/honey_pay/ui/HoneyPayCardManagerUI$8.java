package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardManagerUI$8
  implements View.OnClickListener
{
  HoneyPayCardManagerUI$8(HoneyPayCardManagerUI paramHoneyPayCardManagerUI, bfg parambfg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41800);
    e.m(this.nIw.getContext(), this.nIz.url, false);
    AppMethodBeat.o(41800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.8
 * JD-Core Version:    0.7.0.1
 */