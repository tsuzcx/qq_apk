package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import java.util.List;

final class BizTimeLineUI$14
  implements Runnable
{
  BizTimeLineUI$14(BizTimeLineUI paramBizTimeLineUI, int paramInt, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(14198);
    if ((BizTimeLineUI.e(this.jXh)) && (this.jXi != 0))
    {
      BizTimeLineUI.f(this.jXh);
      this.jXh.aWS();
    }
    if ((BizTimeLineUI.e(this.jXh)) && (this.jXi == 0)) {
      BizTimeLineUI.a(this.jXh, BizTimeLineUI.c(this.jXh).se(0));
    }
    if (!bo.es(this.ieO))
    {
      long l = ((q)this.ieO.get(0)).field_orderFlag;
      f localf = BizTimeLineUI.h(this.jXh);
      int i = BizTimeLineUI.g(this.jXh);
      int j = this.jXh.getIntent().getIntExtra("Main_IndexInSessionList", 0);
      b.a("BrandServiceWorkerThread", new f.3(localf, l, this.jXh.getIntent().getIntExtra("Main_UnreadCount", 0), i, j), 0L);
    }
    AppMethodBeat.o(14198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.14
 * JD-Core Version:    0.7.0.1
 */