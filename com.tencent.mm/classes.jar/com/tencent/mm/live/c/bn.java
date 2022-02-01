package com.tencent.mm.live.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.storage.bh;
import d.g.a.a;
import d.g.a.b;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/ShareRoomsLoader;", "", "()V", "load", "", "UIcallback", "Lkotlin/Function1;", "", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "plugin-logic_release"})
public final class bn
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(203166);
      Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a(w.gMu, null, true, "");
      final ArrayList localArrayList = new ArrayList();
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("username"));
        int i = q.rY(str);
        d.g.b.k.g(str, "name");
        localArrayList.add(new h(str, i));
      }
      c.g((a)new d.g.b.l(localArrayList) {});
      AppMethodBeat.o(203166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.bn
 * JD-Core Version:    0.7.0.1
 */