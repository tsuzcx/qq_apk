package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.k;

final class EnterpriseBizContactListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseBizContactListUI$2(EnterpriseBizContactListUI paramEnterpriseBizContactListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (EnterpriseBizContactListUI.a(this.ids) != null)
    {
      EnterpriseBizContactListUI.a(this.ids).dismiss();
      EnterpriseBizContactListUI.a(this.ids, null);
    }
    EnterpriseBizContactListUI.a(this.ids, new k(this.ids.mController.uMN));
    EnterpriseBizContactListUI.a(this.ids).phH = new EnterpriseBizContactListUI.2.1(this);
    EnterpriseBizContactListUI.a(this.ids).phI = new EnterpriseBizContactListUI.2.2(this);
    EnterpriseBizContactListUI.a(this.ids).fy();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.2
 * JD-Core Version:    0.7.0.1
 */