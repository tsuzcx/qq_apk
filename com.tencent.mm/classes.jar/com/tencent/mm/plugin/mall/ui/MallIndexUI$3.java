package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.plugin.report.service.h;

final class MallIndexUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexUI$3(MallIndexUI paramMallIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(66101);
    h.IzE.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
    h.IzE.a(16500, new Object[] { Integer.valueOf(3) });
    paramMenuItem = this.ERF;
    boolean bool = MallIndexUI.g(this.ERF).gas;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_default_show_currency", bool);
    c.b(paramMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
    AppMethodBeat.o(66101);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.3
 * JD-Core Version:    0.7.0.1
 */