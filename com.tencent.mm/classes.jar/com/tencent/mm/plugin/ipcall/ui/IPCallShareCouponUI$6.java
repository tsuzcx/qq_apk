package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class IPCallShareCouponUI$6
  implements MenuItem.OnMenuItemClickListener
{
  IPCallShareCouponUI$6(IPCallShareCouponUI paramIPCallShareCouponUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22324);
    paramMenuItem = c.bKP();
    int i;
    if ((paramMenuItem != null) && (!bo.isNullOrNil(paramMenuItem.xhz))) {
      if (g.Nq().getInt("WCOWebPayListSwitch", 0) > 0)
      {
        i = 1;
        if (i == 0) {
          break label134;
        }
        i = 1;
        label44:
        if (i == 0) {
          break label139;
        }
        paramMenuItem = new String[3];
        paramMenuItem[0] = this.nWj.getString(2131300906);
        paramMenuItem[1] = this.nWj.getString(2131300849);
        paramMenuItem[2] = this.nWj.getString(2131300828);
        IPCallShareCouponUI.a(this.nWj, true);
      }
    }
    for (;;)
    {
      h.a(this.nWj.getContext(), null, paramMenuItem, null, false, new IPCallShareCouponUI.6.1(this));
      AppMethodBeat.o(22324);
      return true;
      i = 0;
      break;
      label134:
      i = 0;
      break label44;
      label139:
      paramMenuItem = new String[2];
      paramMenuItem[0] = this.nWj.getString(2131300849);
      paramMenuItem[1] = this.nWj.getString(2131300828);
      IPCallShareCouponUI.a(this.nWj, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.6
 * JD-Core Version:    0.7.0.1
 */