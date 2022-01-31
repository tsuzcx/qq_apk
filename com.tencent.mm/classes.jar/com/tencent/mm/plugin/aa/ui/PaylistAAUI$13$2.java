package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class PaylistAAUI$13$2
  implements n.d
{
  PaylistAAUI$13$2(PaylistAAUI.13 param13) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 3;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      if (!bk.bl(PaylistAAUI.a(this.eZR.eZM)))
      {
        paramMenuItem = new Intent(this.eZR.eZM.mController.uMN, LaunchAAUI.class);
        paramMenuItem.putExtra("enter_scene", 3);
        paramMenuItem.putExtra("chatroom_name", PaylistAAUI.a(this.eZR.eZM));
        this.eZR.eZM.startActivity(paramMenuItem);
      }
      if (this.eZR.eZQ.srB == a.eVq) {
        paramInt = 1;
      }
      for (;;)
      {
        y.d("MicroMsg.PaylistAAUI", "test");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(7), Integer.valueOf(paramInt) });
        return;
        if (this.eZR.eZQ.srB == a.eVp) {
          paramInt = 2;
        }
      }
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(5) });
    com.tencent.mm.ui.base.h.a(this.eZR.eZM, a.i.aa_close_confirm, -1, a.i.aa_close_wording, a.i.app_cancel, new PaylistAAUI.13.2.1(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.13.2
 * JD-Core Version:    0.7.0.1
 */