package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.wallet_core.c.z;

final class MallIndexUI$14
  implements View.OnClickListener
{
  MallIndexUI$14(MallIndexUI paramMallIndexUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43219);
    paramView = new Intent();
    paramView.putExtra("key_from_scene", 1);
    d.b(this.oAt.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramView);
    z.id(9, 0);
    h.qsU.e(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    h.qsU.e(14419, new Object[] { this.oAt.eAx, Integer.valueOf(1) });
    AppMethodBeat.o(43219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.14
 * JD-Core Version:    0.7.0.1
 */