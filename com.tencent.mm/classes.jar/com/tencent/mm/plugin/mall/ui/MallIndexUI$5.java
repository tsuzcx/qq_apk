package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vf.b;
import com.tencent.mm.plugin.report.service.h;

final class MallIndexUI$5
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexUI$5(MallIndexUI paramMallIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(43209);
    h.qsU.e(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
    h.qsU.e(16500, new Object[] { Integer.valueOf(3) });
    paramMenuItem = this.oAt;
    boolean bool = MallIndexUI.e(this.oAt).cLU;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_default_show_currency", bool);
    d.b(paramMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent);
    AppMethodBeat.o(43209);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.5
 * JD-Core Version:    0.7.0.1
 */