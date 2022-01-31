package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.isQ.ikk == null)
    {
      y.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11582, new Object[] { "CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.isQ.ikk.azx().ilo), this.isQ.ikk.azC(), this.isQ.ikk.azB(), this.isQ.isN.irV });
    paramView = (String[])this.isQ.isL.toArray(new String[this.isQ.isL.size()]);
    com.tencent.mm.ui.base.h.a(this.isQ.isl.mController.uMN, null, paramView, null, false, new e.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.5
 * JD-Core Version:    0.7.0.1
 */