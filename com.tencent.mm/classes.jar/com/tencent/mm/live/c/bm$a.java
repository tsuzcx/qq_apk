package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.storage.bk;
import d.g.a.a;
import d.g.a.b;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class bm$a
  implements Runnable
{
  bm$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(190407);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(w.hmU, null, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = q.wb(str);
      d.g.b.k.g(str, "name");
      localArrayList.add(new h(str, i));
    }
    c.g((a)new d.g.b.l(localArrayList) {});
    AppMethodBeat.o(190407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bm.a
 * JD-Core Version:    0.7.0.1
 */