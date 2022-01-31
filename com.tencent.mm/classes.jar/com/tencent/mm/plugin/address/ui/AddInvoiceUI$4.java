package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.o.a.b;

final class AddInvoiceUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AddInvoiceUI$4(AddInvoiceUI paramAddInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (AddInvoiceUI.f(this.fuc) == 0) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14199, new Object[] { Integer.valueOf(3) });
    }
    while ((AddInvoiceUI.a(this.fuc) != null) && (AddInvoiceUI.a(this.fuc).isActivated()) && (AddInvoiceUI.g(this.fuc).getText().length() == 0))
    {
      this.fuc.YK();
      return false;
      com.tencent.mm.plugin.report.service.h.nFQ.f(14199, new Object[] { Integer.valueOf(4) });
    }
    if ((AddInvoiceUI.b(this.fuc) != null) && (AddInvoiceUI.b(this.fuc).isActivated()) && (AddInvoiceUI.h(this.fuc).getText().length() == 0))
    {
      this.fuc.YK();
      return false;
    }
    if ((AddInvoiceUI.f(this.fuc) != 0) && (AddInvoiceUI.h(this.fuc).getText().length() == 0) && (AddInvoiceUI.g(this.fuc).getText().length() == 0))
    {
      this.fuc.YK();
      return false;
    }
    if (AddInvoiceUI.i(this.fuc).getText().length() > 100)
    {
      paramMenuItem = this.fuc;
      com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.invoice_bytes_tax_limit_error), paramMenuItem.getString(R.l.app_tip), false, null);
      return false;
    }
    if (!AddInvoiceUI.d(this.fuc))
    {
      if (((AddInvoiceUI.a(this.fuc) != null) && (AddInvoiceUI.a(this.fuc).isActivated())) || ((AddInvoiceUI.j(this.fuc) != null) && (AddInvoiceUI.j(this.fuc).type != null) && (AddInvoiceUI.j(this.fuc).type.equals("0"))))
      {
        if (!AddInvoiceUI.k(this.fuc).YL())
        {
          paramMenuItem = this.fuc;
          com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.invoice_phone_limit_error), paramMenuItem.getString(R.l.app_tip), false, null);
        }
        if (!AddInvoiceUI.l(this.fuc).YL())
        {
          paramMenuItem = this.fuc;
          com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.invoice_bank_number_limit_error), paramMenuItem.getString(R.l.app_tip), false, null);
        }
      }
      return true;
    }
    if (AddInvoiceUI.a(this.fuc).isActivated()) {
      AddInvoiceUI.c(this.fuc).type = "0";
    }
    for (;;)
    {
      if (AddInvoiceUI.j(this.fuc) != null) {
        AddInvoiceUI.c(this.fuc).type = AddInvoiceUI.j(this.fuc).type;
      }
      AddInvoiceUI.c(this.fuc).title = AddInvoiceUI.g(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnQ = AddInvoiceUI.h(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnR = AddInvoiceUI.i(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnP = AddInvoiceUI.f(this.fuc);
      AddInvoiceUI.c(this.fuc).lnV = AddInvoiceUI.k(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnT = AddInvoiceUI.m(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnS = AddInvoiceUI.l(this.fuc).getText();
      AddInvoiceUI.c(this.fuc).lnX = AddInvoiceUI.n(this.fuc).getText();
      AddInvoiceUI.o(this.fuc);
      return true;
      if (AddInvoiceUI.b(this.fuc).isActivated()) {
        AddInvoiceUI.c(this.fuc).type = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI.4
 * JD-Core Version:    0.7.0.1
 */