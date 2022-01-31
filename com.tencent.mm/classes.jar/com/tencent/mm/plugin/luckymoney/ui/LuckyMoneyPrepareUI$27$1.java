package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyPrepareUI$27$1
  implements n.c
{
  LuckyMoneyPrepareUI$27$1(LuckyMoneyPrepareUI.27 param27, boolean paramBoolean) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142078);
    if (!this.owP)
    {
      if (bo.hl(this.owQ.oqO.opo, 1)) {
        paraml.hx(1, 2131301266);
      }
      paraml.hx(2, 2131301307);
      AppMethodBeat.o(142078);
      return;
    }
    paraml.a(3, this.owQ.owL.getResources().getColor(2131690256), this.owQ.owL.getContext().getString(2131301209));
    AppMethodBeat.o(142078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.27.1
 * JD-Core Version:    0.7.0.1
 */