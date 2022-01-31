package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicLong;

final class e$15
  implements j.a
{
  e$15(e parame) {}
  
  public final void a(String paramString, l paraml)
  {
    if ("single".equals(paramString)) {
      if (((5 == paraml.gbI) && (e.g(this.hhH))) || (2 == paraml.gbI) || (3 == paraml.gbI))
      {
        y.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", new Object[] { Integer.valueOf(paraml.gbI) });
        e.a(this.hhH, false, -1L, true);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!"batch".equals(paramString)) || (3 != paraml.gbI));
      paramString = paraml.obj;
    } while (((paramString instanceof Long)) && (((Long)paramString).longValue() == e.h(this.hhH).get()));
    y.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
    e.a(this.hhH, false, 9223372036854775807L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.15
 * JD-Core Version:    0.7.0.1
 */