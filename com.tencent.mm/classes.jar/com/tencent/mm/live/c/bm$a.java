package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.storage.br;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class bm$a
  implements Runnable
{
  bm$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(216325);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a(x.hIc, null, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = r.zC(str);
      p.g(str, "name");
      localArrayList.add(new h(str, i));
    }
    c.h((a)new q(localArrayList) {});
    AppMethodBeat.o(216325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bm.a
 * JD-Core Version:    0.7.0.1
 */