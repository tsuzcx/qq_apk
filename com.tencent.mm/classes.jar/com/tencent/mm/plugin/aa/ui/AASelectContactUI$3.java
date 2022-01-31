package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class AASelectContactUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AASelectContactUI$3(AASelectContactUI paramAASelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (AASelectContactUI.b(this.eXY).size() > AASelectContactUI.d(this.eXY))
    {
      com.tencent.mm.ui.base.h.b(this.eXY.mController.uMN, this.eXY.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Long.valueOf(AASelectContactUI.d(this.eXY)) }), "", true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(13722, new Object[] { Integer.valueOf(3) });
      return true;
    }
    if (AASelectContactUI.b(this.eXY).size() <= 0)
    {
      com.tencent.mm.ui.base.h.b(this.eXY.mController.uMN, this.eXY.getString(a.i.aa_select_min_usernumber_hint, new Object[] { Integer.valueOf(1) }), "", true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(9) });
      return true;
    }
    paramMenuItem = new LinkedList();
    paramMenuItem.addAll(AASelectContactUI.b(this.eXY));
    paramMenuItem = bk.c(paramMenuItem, ",");
    this.eXY.setResult(-1, this.eXY.getIntent().putExtra("Select_Contact", paramMenuItem));
    this.eXY.finish();
    this.eXY.XM();
    com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(8) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.3
 * JD-Core Version:    0.7.0.1
 */