package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhd;
import java.util.HashMap;
import java.util.List;

final class BizTimeLineHotListView$1
  implements Runnable
{
  BizTimeLineHotListView$1(BizTimeLineHotListView paramBizTimeLineHotListView, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(14280);
    int m = this.jZc.getCurrentPage();
    int j = f.qU(m);
    int k = f.qV(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < this.jZb.size()))
    {
      b localb = (b)this.jZb.get(i);
      e locale;
      bhd localbhd;
      if (localb != null)
      {
        locale = BizTimeLineHotListView.a(this.jZc);
        if (localb != null)
        {
          localbhd = (bhd)locale.jZv.get(localb.wqR);
          if (localbhd != null) {
            break label207;
          }
          localbhd = new bhd();
          localbhd.wyW = localb.wqR;
          if (!localb.jZt) {
            break label202;
          }
        }
      }
      label202:
      for (j = 1;; j = 0)
      {
        localbhd.xwe = j;
        localbhd.xwf = ((int)(System.currentTimeMillis() / 1000L));
        localbhd.nox = (localb.position - 1);
        localbhd.kkY = 1;
        locale.jZv.put(localb.wqR, localbhd);
        i += 1;
        break;
      }
      label207:
      if (localb.jZt) {}
      for (j = 1;; j = 0)
      {
        localbhd.xwe = j;
        localbhd.xwf = ((int)(System.currentTimeMillis() / 1000L));
        localbhd.nox = (localb.position - 1);
        localbhd.kkY += 1;
        break;
      }
    }
    AppMethodBeat.o(14280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.1
 * JD-Core Version:    0.7.0.1
 */