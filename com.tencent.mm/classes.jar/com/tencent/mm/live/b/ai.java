package com.tencent.mm.live.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.view.a.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.by;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/ShareRoomsLoader;", "", "()V", "load", "", "UIcallback", "Lkotlin/Function1;", "", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  private static final void B(b paramb)
  {
    AppMethodBeat.i(247407);
    s.u(paramb, "$UIcallback");
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(5, null, com.tencent.mm.l.a.maX, true, "");
    final ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("username"));
      int i = v.getMembersCountByChatRoomName(str);
      s.s(str, "name");
      localArrayList.add(new g(str, i));
    }
    d.uiThread((kotlin.g.a.a)new a(paramb, localArrayList));
    AppMethodBeat.o(247407);
  }
  
  public static void load(b<? super List<g>, ah> paramb)
  {
    AppMethodBeat.i(247396);
    s.u(paramb, "UIcallback");
    com.tencent.threadpool.h.ahAA.bm(new ai..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(247396);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(b<? super List<g>, ah> paramb, ArrayList<g> paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.ai
 * JD-Core Version:    0.7.0.1
 */