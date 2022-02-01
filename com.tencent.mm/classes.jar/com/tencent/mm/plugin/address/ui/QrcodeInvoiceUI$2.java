package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrcodeInvoiceUI$2
  implements MenuItem.OnMenuItemClickListener
{
  QrcodeInvoiceUI$2(QrcodeInvoiceUI paramQrcodeInvoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20958);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.jaz, AddInvoiceUI.class);
    ((Intent)localObject).putExtra("invoice_id", QrcodeInvoiceUI.a(this.jaz));
    paramMenuItem = this.jaz;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20958);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.2
 * JD-Core Version:    0.7.0.1
 */