package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88342);
    if (this.ktX.klk == null)
    {
      ab.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
      AppMethodBeat.o(88342);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbi(), this.ktX.klk.bbh(), this.ktX.ktU.ktc });
    paramView = (String[])this.ktX.ktS.toArray(new String[this.ktX.ktS.size()]);
    com.tencent.mm.ui.base.h.a(this.ktX.kts.getContext(), null, paramView, null, false, new e.5.1(this));
    AppMethodBeat.o(88342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.5
 * JD-Core Version:    0.7.0.1
 */