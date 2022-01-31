package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectMainUI$15
  implements m.a
{
  CollectMainUI$15(CollectMainUI paramCollectMainUI) {}
  
  public final void aEP()
  {
    if (CollectMainUI.b(this.iLP) == 1)
    {
      CollectMainUI.c(this.iLP);
      com.tencent.mm.ui.base.h.a(this.iLP.mController.uMN, this.iLP.getString(a.i.collect_material_guide_click_text), "", this.iLP.getString(a.i.collect_material_guide_apply_text2), this.iLP.getString(a.i.app_cancel), true, new CollectMainUI.15.1(this), new CollectMainUI.15.2(this));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(5) });
      return;
      CollectMainUI.e(this.iLP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.15
 * JD-Core Version:    0.7.0.1
 */