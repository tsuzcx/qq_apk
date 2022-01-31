package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.LinkedList;

final class f$3
  implements Runnable
{
  f$3(f paramf, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(14172);
    Object localObject1 = z.afo();
    Object localObject2 = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(this.jWD & 0x0));
    localObject1 = ((r)localObject1).fnw.a((String)localObject2, null, 0);
    if (((Cursor)localObject1).moveToFirst()) {}
    for (int j = ((Cursor)localObject1).getInt(0);; j = 0)
    {
      ((Cursor)localObject1).close();
      int n = z.afo().od(this.jWD);
      localObject1 = z.afo();
      long l1 = this.jWD;
      localObject2 = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (l1 & 0x0) + " and placeTop = 1 ";
      localObject1 = ((r)localObject1).fnw.a((String)localObject2, null, 0);
      if (((Cursor)localObject1).moveToFirst()) {}
      for (int k = ((Cursor)localObject1).getInt(0);; k = 0)
      {
        ((Cursor)localObject1).close();
        int i1 = z.afp().bbZ();
        long l2 = 0L;
        int m = 0;
        localObject2 = "";
        as localas = as.eu("brandService", 1);
        localObject1 = localObject2;
        int i = m;
        l1 = l2;
        if (this.jWE > 0)
        {
          localObject1 = localObject2;
          i = m;
          l1 = l2;
          if (localas != null)
          {
            long l3 = localas.aps("LastMsgId");
            localObject1 = localObject2;
            i = m;
            l1 = l2;
            if (l3 > 0L)
            {
              localObject2 = ((j)g.E(j.class)).bPQ().kB(l3);
              localObject1 = ((dd)localObject2).field_talker;
              if (z.afo().C(l3, "msgId") == null) {
                break label639;
              }
              i = 1;
              if (!((bi)localObject2).dvV()) {
                break label695;
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            localObject2 = ((a)g.E(a.class)).b(((dd)localObject2).field_msgId, ((dd)localObject2).field_content);
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (!bo.es(((p)localObject2).fjy))
              {
                localObject2 = (q)((p)localObject2).fjy.get(0);
                l1 = l2;
                if (!bo.isNullOrNil(((q)localObject2).url)) {
                  l1 = bo.getLong(Uri.parse(((q)localObject2).url).getQueryParameter("mid"), 0L);
                }
              }
            }
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            ab.w("MicroMsg.BizTimeLineReport", "reportEnterBiz exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            l1 = l2;
            continue;
          }
          catch (Exception localException)
          {
            label639:
            ab.w("MicroMsg.BizTimeLineReport", "reportEnterBiz exp %s", new Object[] { localException.getMessage() });
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(11404, new Object[] { Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(this.jWC.cnU), Integer.valueOf(this.jWC.cnU), Integer.valueOf(this.jWF), localObject1, Long.valueOf(l1), Integer.valueOf(this.jWG), Integer.valueOf(i) });
          ab.i("MicroMsg.BizTimeLineReport", "reportEnterBiz %d,%d,%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(this.jWC.cnU), Integer.valueOf(this.jWC.cnU), Integer.valueOf(this.jWF), localObject1, Long.valueOf(l1), Integer.valueOf(this.jWG), Integer.valueOf(i) });
          AppMethodBeat.o(14172);
          return;
          i = 2;
          break;
          label695:
          l1 = l2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.3
 * JD-Core Version:    0.7.0.1
 */