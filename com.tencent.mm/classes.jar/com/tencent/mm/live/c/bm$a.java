package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.w;
import com.tencent.mm.storage.bq;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.z;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class bm$a
  implements Runnable
{
  bm$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(212697);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().a(w.hFk, null, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = com.tencent.mm.model.q.yS(str);
      p.g(str, "name");
      localArrayList.add(new h(str, i));
    }
    c.g((a)new d.g.b.q(localArrayList) {});
    AppMethodBeat.o(212697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bm.a
 * JD-Core Version:    0.7.0.1
 */