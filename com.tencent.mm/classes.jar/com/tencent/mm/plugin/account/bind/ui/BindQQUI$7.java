package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;

final class BindQQUI$7
  implements MenuItem.OnMenuItemClickListener
{
  BindQQUI$7(BindQQUI paramBindQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new j(this.fcO.mController.uMN);
    paramMenuItem.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        paramAnonymousl.setHeaderTitle(a.i.bind_mcontact_list_menu_title);
        paramAnonymousl.fq(0, a.i.unbind_qq);
      }
    };
    paramMenuItem.phI = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        }
        paramAnonymousMenuItem = BindQQUI.7.this.fcO;
        y localy = new y(y.fgp);
        g.Dk().a(localy, 0);
        paramAnonymousMenuItem.getString(a.i.app_tip);
        paramAnonymousMenuItem.tipDialog = h.b(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(a.i.app_loading), true, new BindQQUI.2(paramAnonymousMenuItem));
      }
    };
    paramMenuItem.bJQ();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.7
 * JD-Core Version:    0.7.0.1
 */