package com.tencent.mm.plugin.ipcall.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class IPCallShareCouponUI$1$1
  implements Runnable
{
  IPCallShareCouponUI$1$1(IPCallShareCouponUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(22315);
    aw.aaz();
    if (((Boolean)c.Ru().get(ac.a.yAm, Boolean.FALSE)).booleanValue()) {
      IPCallShareCouponUI.a(this.nWk.nWj).setVisibility(0);
    }
    for (;;)
    {
      aw.aaz();
      String str = (String)c.Ru().get(ac.a.yAl, "");
      IPCallShareCouponUI.b(this.nWk.nWj).setText(str);
      aw.aaz();
      str = (String)c.Ru().get(ac.a.yAn, "");
      IPCallShareCouponUI.c(this.nWk.nWj).setText(str);
      AppMethodBeat.o(22315);
      return;
      IPCallShareCouponUI.a(this.nWk.nWj).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI.1.1
 * JD-Core Version:    0.7.0.1
 */