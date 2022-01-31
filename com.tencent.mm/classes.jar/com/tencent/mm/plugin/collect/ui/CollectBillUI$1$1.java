package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectBillUI$1$1
  implements View.OnClickListener
{
  CollectBillUI$1$1(CollectBillUI.1 param1, dg paramdg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41210);
    if (!bo.isNullOrNil(this.kRj.url)) {
      e.m(this.kRk.kRi.getContext(), this.kRj.url, true);
    }
    AppMethodBeat.o(41210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.1.1
 * JD-Core Version:    0.7.0.1
 */