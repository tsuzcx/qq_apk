package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPaySelectCardTypeUI$a$1
  implements o.a
{
  HoneyPaySelectCardTypeUI$a$1(HoneyPaySelectCardTypeUI.a parama, aua paramaua, Context paramContext) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41953);
    ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
    if (!bo.isNullOrNil(this.nJR.xch.url)) {
      e.m(this.val$context, this.nJR.xch.url, false);
    }
    AppMethodBeat.o(41953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.1
 * JD-Core Version:    0.7.0.1
 */