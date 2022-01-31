package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.cic;
import com.tencent.mm.protocal.c.cid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

final class MallIndexOSUI$4
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexOSUI$4(MallIndexOSUI paramMallIndexOSUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    cic localcic = MallIndexOSUI.e(this.lZX).qyS;
    boolean bool = MallIndexOSUI.e(this.lZX).qyT;
    if (bool)
    {
      paramMenuItem = new String[localcic.taW.size() + 1];
      paramMenuItem[localcic.taW.size()] = this.lZX.getString(a.i.wallet_index_ui_opt_wallet_switch);
    }
    for (;;)
    {
      int i = 0;
      while (i < localcic.taW.size())
      {
        paramMenuItem[i] = aa.a(((cid)localcic.taW.get(i)).tWw);
        i += 1;
      }
      paramMenuItem = new String[localcic.taW.size()];
    }
    h.a(this.lZX.mController.uMN, null, paramMenuItem, null, false, new MallIndexOSUI.4.1(this, localcic, bool));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.4
 * JD-Core Version:    0.7.0.1
 */