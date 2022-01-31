package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.HashSet;

final class AASelectContactUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AASelectContactUI$4(AASelectContactUI paramAASelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((AASelectContactUI.b(this.eXY) != null) && (AASelectContactUI.b(this.eXY).size() > 0) && (AASelectContactUI.b(this.eXY).size() <= AASelectContactUI.d(this.eXY)) && ((AASelectContactUI.b(this.eXY).size() != 1) || (!AASelectContactUI.b(this.eXY).contains(q.Gj())))) {
      com.tencent.mm.ui.base.h.a(this.eXY, this.eXY.getString(a.i.aa_select_contact_back_confirm), null, this.eXY.getString(a.i.aa_select_contact_save), this.eXY.getString(a.i.aa_select_contact_not_save), false, new AASelectContactUI.4.1(this), new AASelectContactUI.4.2(this));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(7) });
      return true;
      this.eXY.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */