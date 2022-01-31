package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.mm.protocal.c.baa;
import java.util.HashMap;
import java.util.List;

final class BizTimeLineHotListView$1
  implements Runnable
{
  BizTimeLineHotListView$1(BizTimeLineHotListView paramBizTimeLineHotListView, List paramList) {}
  
  public final void run()
  {
    int m = this.ihu.getCurrentPage();
    int j = f.nn(m);
    int k = f.no(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < this.iht.size()))
    {
      b localb = (b)this.iht.get(i);
      e locale;
      baa localbaa;
      if (localb != null)
      {
        locale = BizTimeLineHotListView.a(this.ihu);
        if (localb != null)
        {
          localbaa = (baa)locale.ihI.get(localb.sxi);
          if (localbaa != null) {
            break label201;
          }
          localbaa = new baa();
          localbaa.sDq = localb.sxi;
          if (!localb.ihG) {
            break label196;
          }
        }
      }
      label196:
      for (j = 1;; j = 0)
      {
        localbaa.tvT = j;
        localbaa.tvU = ((int)(System.currentTimeMillis() / 1000L));
        localbaa.kQt = (localb.position - 1);
        localbaa.ijY = 1;
        locale.ihI.put(localb.sxi, localbaa);
        i += 1;
        break;
      }
      label201:
      if (localb.ihG) {}
      for (j = 1;; j = 0)
      {
        localbaa.tvT = j;
        localbaa.tvU = ((int)(System.currentTimeMillis() / 1000L));
        localbaa.kQt = (localb.position - 1);
        localbaa.ijY += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.1
 * JD-Core Version:    0.7.0.1
 */