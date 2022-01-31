package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;

final class g$3
  implements Runnable
{
  g$3(g paramg, long paramLong) {}
  
  public final void run()
  {
    Object localObject = z.ME();
    long l = this.igL;
    String str = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (l & 0x0);
    localObject = ((r)localObject).dXo.a(str, null, 0);
    if (((Cursor)localObject).moveToFirst()) {}
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      int k = z.ME().hy(this.igL);
      localObject = z.ME();
      l = this.igL;
      str = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (l & 0x0) + " and placeTop = 1 ";
      localObject = ((r)localObject).dXo.a(str, null, 0);
      if (((Cursor)localObject).moveToFirst()) {}
      for (int j = ((Cursor)localObject).getInt(0);; j = 0)
      {
        ((Cursor)localObject).close();
        int m = z.MF().aAo();
        com.tencent.mm.plugin.report.service.h.nFQ.f(11404, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(this.igK.igH), Integer.valueOf(this.igK.igH) });
        y.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(this.igK.igH), Integer.valueOf(this.igK.igH) });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g.3
 * JD-Core Version:    0.7.0.1
 */