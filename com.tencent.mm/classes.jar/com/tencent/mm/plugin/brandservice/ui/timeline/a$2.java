package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.util.List;

final class a$2
  implements Runnable
{
  a$2(a parama, int paramInt) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(14099);
    if ((this.gxr == this.jVZ.getCount() - 1) && (!this.jVZ.jVY))
    {
      ab.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(this.gxr), Integer.valueOf(this.jVZ.getCount()) });
      a locala = this.jVZ;
      Object localObject = locala.aWH();
      int i = j;
      if (localObject != null)
      {
        localObject = z.afo().al(10, ((q)localObject).field_orderFlag);
        com.tencent.mm.plugin.brandservice.ui.b.c.aU((List)localObject);
        locala.aT((List)localObject);
        locala.notifyDataSetChanged();
        i = j;
        if (((List)localObject).size() > 0) {
          i = 1;
        }
      }
      if (i == 0)
      {
        this.jVZ.jVY = true;
        a.a(this.jVZ).aWR();
        AppMethodBeat.o(14099);
        return;
      }
      this.jVZ.jVJ.Kt();
    }
    AppMethodBeat.o(14099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.2
 * JD-Core Version:    0.7.0.1
 */