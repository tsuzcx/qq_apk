package com.tencent.mm.plugin.honey_pay.ui;

import android.widget.TextView;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$4
  implements Runnable
{
  HoneyPayMainUI$4(HoneyPayMainUI paramHoneyPayMainUI, ti paramti) {}
  
  public final void run()
  {
    if (!bk.bl(this.iLQ.ccV.ccW))
    {
      y.i(this.llJ.TAG, "show notice banner");
      e.a((TextView)this.llJ.findViewById(a.f.banner_tips), this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.4
 * JD-Core Version:    0.7.0.1
 */