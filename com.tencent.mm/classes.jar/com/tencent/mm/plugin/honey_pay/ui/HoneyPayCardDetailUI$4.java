package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardDetailUI$4
  implements View.OnClickListener
{
  HoneyPayCardDetailUI$4(HoneyPayCardDetailUI paramHoneyPayCardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41780);
    ab.d(this.nHU.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(this.nHU).url });
    if (!bo.isNullOrNil(HoneyPayCardDetailUI.b(this.nHU).url)) {
      e.m(this.nHU.getContext(), HoneyPayCardDetailUI.b(this.nHU).url, false);
    }
    AppMethodBeat.o(41780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.4
 * JD-Core Version:    0.7.0.1
 */