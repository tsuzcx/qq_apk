package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

final class PaylistAAUI$13
  implements MenuItem.OnMenuItemClickListener
{
  PaylistAAUI$13(PaylistAAUI paramPaylistAAUI, v paramv) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.eZM, 1, false);
    paramMenuItem.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        paramAnonymousl.add(0, 1, 1, a.i.paylist_launch_new_aa);
        if ((!bk.bl(PaylistAAUI.g(PaylistAAUI.13.this.eZM))) && (PaylistAAUI.g(PaylistAAUI.13.this.eZM).equals(q.Gj())) && (PaylistAAUI.13.this.eZQ.state == a.eVm) && (PaylistAAUI.13.this.eZQ.srS < PaylistAAUI.13.this.eZQ.srQ)) {
          paramAnonymousl.add(0, 2, 1, a.i.aa_close_paylist);
        }
      }
    };
    paramMenuItem.phI = new PaylistAAUI.13.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.13
 * JD-Core Version:    0.7.0.1
 */