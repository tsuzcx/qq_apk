package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class n$2
  implements View.OnClickListener
{
  n$2(n paramn, uo paramuo, com.tencent.mm.plugin.card.base.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88763);
    if ((!bo.isNullOrNil(this.kBs.wFM)) && (!bo.isNullOrNil(this.kBs.wFL)))
    {
      int i;
      if (this.kBr.jpX.getIntent() != null)
      {
        i = this.kBr.jpX.getIntent().getIntExtra("key_from_scene", 3);
        if (this.kBr.jpX.getIntent() == null) {
          break label181;
        }
      }
      label181:
      for (int j = this.kBr.jpX.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
      {
        com.tencent.mm.plugin.card.d.b.a(this.kBt.bbh(), this.kBs, i, j);
        h.qsU.e(11941, new Object[] { Integer.valueOf(20), this.kBt.bbh(), this.kBt.bbi(), "", this.kBs.title });
        AppMethodBeat.o(88763);
        return;
        i = 3;
        break;
      }
    }
    if (!bo.isNullOrNil(this.kBs.url))
    {
      paramView = l.H(this.kBs.url, this.kBs.wGZ);
      com.tencent.mm.plugin.card.d.b.a(this.kBr.jpX, paramView, 1);
      h localh = h.qsU;
      String str1 = this.kBt.bbh();
      String str2 = this.kBt.bbi();
      if (this.kBs.title != null) {}
      for (paramView = this.kBs.title;; paramView = "")
      {
        localh.e(11941, new Object[] { Integer.valueOf(9), str1, str2, "", paramView });
        AppMethodBeat.o(88763);
        return;
      }
    }
    d.a(this.kBr.jpX, this.kBr.jpX.getString(2131298085), true);
    AppMethodBeat.o(88763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n.2
 * JD-Core Version:    0.7.0.1
 */