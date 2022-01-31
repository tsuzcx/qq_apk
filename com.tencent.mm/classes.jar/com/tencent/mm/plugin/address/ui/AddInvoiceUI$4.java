package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;

final class AddInvoiceUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AddInvoiceUI$4(AddInvoiceUI paramAddInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(16790);
    if (AddInvoiceUI.f(this.gLE) == 0) {
      com.tencent.mm.plugin.report.service.h.qsU.e(14199, new Object[] { Integer.valueOf(3) });
    }
    while ((AddInvoiceUI.a(this.gLE) != null) && (AddInvoiceUI.a(this.gLE).isActivated()) && (AddInvoiceUI.g(this.gLE).getText().length() == 0))
    {
      this.gLE.asu();
      AppMethodBeat.o(16790);
      return false;
      com.tencent.mm.plugin.report.service.h.qsU.e(14199, new Object[] { Integer.valueOf(4) });
    }
    if ((AddInvoiceUI.b(this.gLE) != null) && (AddInvoiceUI.b(this.gLE).isActivated()) && (AddInvoiceUI.h(this.gLE).getText().length() == 0))
    {
      this.gLE.asu();
      AppMethodBeat.o(16790);
      return false;
    }
    if ((AddInvoiceUI.f(this.gLE) != 0) && (AddInvoiceUI.h(this.gLE).getText().length() == 0) && (AddInvoiceUI.g(this.gLE).getText().length() == 0))
    {
      this.gLE.asu();
      AppMethodBeat.o(16790);
      return false;
    }
    if (AddInvoiceUI.i(this.gLE).getText().length() > 100)
    {
      paramMenuItem = this.gLE;
      com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131300791), paramMenuItem.getString(2131297087), false, null);
      AppMethodBeat.o(16790);
      return false;
    }
    if (!AddInvoiceUI.d(this.gLE))
    {
      if (((AddInvoiceUI.a(this.gLE) != null) && (AddInvoiceUI.a(this.gLE).isActivated())) || ((AddInvoiceUI.j(this.gLE) != null) && (AddInvoiceUI.j(this.gLE).type != null) && (AddInvoiceUI.j(this.gLE).type.equals("0"))))
      {
        if (!AddInvoiceUI.k(this.gLE).asv())
        {
          paramMenuItem = this.gLE;
          com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131300802), paramMenuItem.getString(2131297087), false, null);
        }
        if (!AddInvoiceUI.l(this.gLE).asv())
        {
          paramMenuItem = this.gLE;
          com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131300788), paramMenuItem.getString(2131297087), false, null);
        }
      }
      AppMethodBeat.o(16790);
      return true;
    }
    if (AddInvoiceUI.a(this.gLE).isActivated()) {
      AddInvoiceUI.c(this.gLE).type = "0";
    }
    for (;;)
    {
      if (AddInvoiceUI.j(this.gLE) != null) {
        AddInvoiceUI.c(this.gLE).type = AddInvoiceUI.j(this.gLE).type;
      }
      AddInvoiceUI.c(this.gLE).title = AddInvoiceUI.g(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLn = AddInvoiceUI.h(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLo = AddInvoiceUI.i(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLm = AddInvoiceUI.f(this.gLE);
      AddInvoiceUI.c(this.gLE).nLs = AddInvoiceUI.k(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLq = AddInvoiceUI.m(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLp = AddInvoiceUI.l(this.gLE).getText();
      AddInvoiceUI.c(this.gLE).nLu = AddInvoiceUI.n(this.gLE).getText();
      AddInvoiceUI.o(this.gLE);
      AppMethodBeat.o(16790);
      return true;
      if (AddInvoiceUI.b(this.gLE).isActivated()) {
        AddInvoiceUI.c(this.gLE).type = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI.4
 * JD-Core Version:    0.7.0.1
 */