package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    boolean bool = ((Boolean)c.Dz().get(ac.a.uqf, Boolean.valueOf(false))).booleanValue();
    if (bool)
    {
      au.Hx();
      i = ((Integer)c.Dz().get(ac.a.uqg, Integer.valueOf(-1))).intValue();
      i.M(2, i, -1);
      au.Hx();
      c.Dz().c(ac.a.uqg, Integer.valueOf(-1));
      y.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", new Object[] { Integer.valueOf(i) });
    }
    if (bool)
    {
      paramView = "true";
      au.Hx();
      y.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", new Object[] { paramView, (String)c.Dz().get(ac.a.uqh, "") });
      au.Hx();
      c.Dz().c(ac.a.uqf, Boolean.valueOf(false));
      au.Hx();
      c.Dz().c(ac.a.uqh, "");
      au.Hx();
      if (((Integer)c.Dz().get(ac.a.uqj, Integer.valueOf(0))).intValue() != 1) {
        break label351;
      }
    }
    label351:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        au.Hx();
        y.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", new Object[] { (String)c.Dz().get(ac.a.uqi, "") });
        au.Hx();
        c.Dz().c(ac.a.uqi, "");
      }
      h.nFQ.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      this.lup.bcT();
      paramView = new Intent();
      paramView.setClass(this.lup.lui, IPCallShareCouponUI.class);
      this.lup.lui.startActivity(paramView);
      return;
      paramView = "false";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.1
 * JD-Core Version:    0.7.0.1
 */