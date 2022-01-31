package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

final class e$18
  implements j.a
{
  e$18(e parame) {}
  
  public final void a(final String paramString, l paraml)
  {
    for (;;)
    {
      try
      {
        if ((paraml.obj != null) && ((paraml.obj instanceof Long)))
        {
          long l1 = e.h(this.hhH).get();
          long l2 = e.j(this.hhH).get();
          y.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", new Object[] { (Long)paraml.obj, Long.valueOf(l1), Long.valueOf(l2) });
          final ArrayList localArrayList;
          if (paraml.obj.equals(Long.valueOf(l1)))
          {
            paramString = com.tencent.mm.plugin.appbrand.app.e.aaZ().fJw.cu(9223372036854775807L);
            if (!bk.dk(paramString)) {
              e.k(this.hhH).set(((AppBrandRecentTaskInfo)paramString.get(paramString.size() - 1)).updateTime);
            }
            localArrayList = e.l(this.hhH).n(paramString);
            if (!paraml.obj.equals(Long.valueOf(l1))) {
              continue;
            }
            if (e.g(this.hhH))
            {
              paramString = new ArrayList(0);
              this.hhH.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  e.a(e.18.this.hhH, paramString, localArrayList, true);
                }
              });
            }
          }
          else
          {
            paramString = com.tencent.mm.plugin.appbrand.app.e.aaZ().fJw.cu(e.k(this.hhH).get());
            continue;
          }
          if (!e.m(this.hhH)) {
            break label297;
          }
          paramString = com.tencent.mm.plugin.appbrand.app.e.aba().a(af.a.fJU);
          continue;
          if (paraml.obj.equals(Long.valueOf(l2)))
          {
            this.hhH.runOnUiThread(new e.18.2(this, localArrayList));
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", new Object[] { paramString });
      }
      return;
      label297:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.18
 * JD-Core Version:    0.7.0.1
 */