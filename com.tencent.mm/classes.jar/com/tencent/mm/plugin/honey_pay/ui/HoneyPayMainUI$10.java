package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n.a;
import java.util.LinkedList;

final class HoneyPayMainUI$10
  implements n.a
{
  HoneyPayMainUI$10(HoneyPayMainUI paramHoneyPayMainUI, f paramf) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    HoneyPayMainUI.b(this.llJ);
    this.llJ.mController.removeAllOptionMenu();
    if ((this.llN.ljK.tlc == null) || (this.llN.ljK.tlc.isEmpty()))
    {
      y.i(this.llJ.TAG, "empty card");
      HoneyPayMainUI.a(this.llJ, this.llN.ljK.tld);
      HoneyPayMainUI.c(this.llJ).setVisibility(8);
      this.llJ.lkb = a.c.white;
      this.llJ.setMMTitle("");
      this.llJ.baU();
      this.llJ.findViewById(a.f.hpou_root_view).setBackgroundResource(this.llJ.lkb);
      c.a(this.llJ, this.llN.ljK.tle, null, 0, null);
      this.llJ.findViewById(a.f.hpou_block_view).setVisibility(8);
      h.nFQ.h(875L, 0L, 1L);
      return;
    }
    HoneyPayMainUI.d(this.llJ);
    HoneyPayMainUI.a(this.llJ, this.llN.ljK.tlc);
    y.i(this.llJ.TAG, "show open card: %s", new Object[] { Boolean.valueOf(this.llN.ljK.tlf) });
    if (this.llN.ljK.tlf) {
      HoneyPayMainUI.c(this.llJ).setVisibility(0);
    }
    for (;;)
    {
      this.llJ.lkb = a.c.honey_pay_grey_bg_1;
      this.llJ.setMMTitle(a.i.honey_pay_main_title);
      break;
      HoneyPayMainUI.c(this.llJ).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.10
 * JD-Core Version:    0.7.0.1
 */