package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.util.Collection;
import java.util.List;

final class a$17
  implements Runnable
{
  a$17(a parama, int paramInt) {}
  
  public final void run()
  {
    int j = 0;
    if ((this.ffJ == this.ifl.getCount() - 1) && (!this.ifl.ifk))
    {
      y.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(this.ffJ), Integer.valueOf(this.ifl.getCount()) });
      a locala = this.ifl;
      Object localObject = locala.axL();
      int i = j;
      if (localObject != null)
      {
        localObject = z.ME().W(10, ((q)localObject).field_orderFlag);
        c.aM((List)localObject);
        locala.hfb.addAll((Collection)localObject);
        locala.notifyDataSetChanged();
        i = j;
        if (((List)localObject).size() > 0) {
          i = 1;
        }
      }
      if (i == 0)
      {
        this.ifl.ifk = true;
        a.a(this.ifl).axZ();
      }
    }
    else
    {
      return;
    }
    a.g(this.ifl).yb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.17
 * JD-Core Version:    0.7.0.1
 */