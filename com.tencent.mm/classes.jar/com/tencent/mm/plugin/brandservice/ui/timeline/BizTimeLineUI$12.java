package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.q;
import java.util.List;

final class BizTimeLineUI$12
  implements Runnable
{
  BizTimeLineUI$12(BizTimeLineUI paramBizTimeLineUI, int paramInt, List paramList) {}
  
  public final void run()
  {
    if ((BizTimeLineUI.b(this.ihl)) && (this.ihm != 0))
    {
      BizTimeLineUI.c(this.ihl);
      this.ihl.aya();
    }
    if ((BizTimeLineUI.b(this.ihl)) && (this.ihm == 0)) {
      BizTimeLineUI.a(this.ihl, BizTimeLineUI.d(this.ihl).oy(0));
    }
    if (!bk.dk(this.gFL))
    {
      long l = ((q)this.gFL.get(0)).field_orderFlag;
      g localg = BizTimeLineUI.e(this.ihl);
      com.tencent.mm.kernel.g.DS().O(new g.3(localg, l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.12
 * JD-Core Version:    0.7.0.1
 */