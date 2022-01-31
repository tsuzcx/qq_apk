package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.vending.g.d.a;

final class LaunchAAUI$9
  implements d.a
{
  LaunchAAUI$9(LaunchAAUI paramLaunchAAUI) {}
  
  public final void aE(Object paramObject)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[] { paramObject });
    if (LaunchAAUI.k(this.eZt) != null) {
      LaunchAAUI.k(this.eZt).dismiss();
    }
    if ((paramObject != null) && ((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok"))) {
      Toast.makeText(this.eZt, paramObject.toString(), 1).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13722, new Object[] { Integer.valueOf(5) });
      return;
      if ((paramObject != null) && ((paramObject instanceof com.tencent.mm.protocal.c.y))) {
        com.tencent.mm.plugin.aa.a.h.a(this.eZt.mController.uMN, (com.tencent.mm.protocal.c.y)paramObject);
      } else {
        Toast.makeText(this.eZt, a.i.launch_aa_failed, 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.9
 * JD-Core Version:    0.7.0.1
 */