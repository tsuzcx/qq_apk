package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class bm$a
  implements Runnable
{
  bm$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(188808);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(5, null, com.tencent.mm.o.a.jxD, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = v.Pu(str);
      p.j(str, "name");
      localArrayList.add(new com.tencent.mm.live.view.a.h(str, i));
    }
    d.uiThread((kotlin.g.a.a)new q(localArrayList) {});
    AppMethodBeat.o(188808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.c.bm.a
 * JD-Core Version:    0.7.0.1
 */