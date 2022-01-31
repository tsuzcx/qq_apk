package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class IPCallShareCouponUI$1$1
  implements Runnable
{
  IPCallShareCouponUI$1$1(IPCallShareCouponUI.1 param1) {}
  
  public final void run()
  {
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.uqm, Boolean.valueOf(false))).booleanValue()) {
      IPCallShareCouponUI.a(this.lyY.lyX).setVisibility(0);
    }
    for (;;)
    {
      au.Hx();
      String str = (String)c.Dz().get(ac.a.uql, "");
      IPCallShareCouponUI.b(this.lyY.lyX).setText(str);
      au.Hx();
      str = (String)c.Dz().get(ac.a.uqn, "");
      IPCallShareCouponUI.c(this.lyY.lyX).setText(str);
      return;
      IPCallShareCouponUI.a(this.lyY.lyX).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.1.1
 * JD-Core Version:    0.7.0.1
 */