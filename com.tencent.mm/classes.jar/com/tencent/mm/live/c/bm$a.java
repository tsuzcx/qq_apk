package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class bm$a
  implements Runnable
{
  bm$a(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(208286);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().b(ab.iCM, null, com.tencent.mm.o.a.gNj, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = v.Ie(str);
      p.g(str, "name");
      localArrayList.add(new h(str, i));
    }
    d.h((kotlin.g.a.a)new q(localArrayList) {});
    AppMethodBeat.o(208286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.c.bm.a
 * JD-Core Version:    0.7.0.1
 */