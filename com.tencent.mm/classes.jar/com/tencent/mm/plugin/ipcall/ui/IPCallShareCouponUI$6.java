package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class IPCallShareCouponUI$6
  implements MenuItem.OnMenuItemClickListener
{
  IPCallShareCouponUI$6(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = c.bdt();
    int i;
    if ((paramMenuItem != null) && (!bk.bl(paramMenuItem.tiN))) {
      if (g.AA().getInt("WCOWebPayListSwitch", 0) > 0)
      {
        i = 1;
        if (i == 0) {
          break label128;
        }
        i = 1;
        label38:
        if (i == 0) {
          break label133;
        }
        paramMenuItem = new String[3];
        paramMenuItem[0] = this.lyX.getString(R.l.ip_call_webview_recharge_title);
        paramMenuItem[1] = this.lyX.getString(R.l.ip_call_help);
        paramMenuItem[2] = this.lyX.getString(R.l.ip_call_agreement);
        IPCallShareCouponUI.a(this.lyX, true);
      }
    }
    for (;;)
    {
      h.a(this.lyX.mController.uMN, null, paramMenuItem, null, false, new IPCallShareCouponUI.6.1(this));
      return true;
      i = 0;
      break;
      label128:
      i = 0;
      break label38;
      label133:
      paramMenuItem = new String[2];
      paramMenuItem[0] = this.lyX.getString(R.l.ip_call_help);
      paramMenuItem[1] = this.lyX.getString(R.l.ip_call_agreement);
      IPCallShareCouponUI.a(this.lyX, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.6
 * JD-Core Version:    0.7.0.1
 */