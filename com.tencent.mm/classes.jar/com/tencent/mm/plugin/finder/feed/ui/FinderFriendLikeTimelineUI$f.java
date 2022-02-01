package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class FinderFriendLikeTimelineUI$f
  implements q.f
{
  public static final f xNp;
  
  static
  {
    AppMethodBeat.i(285302);
    xNp = new f();
    AppMethodBeat.o(285302);
  }
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(285301);
    paramo.mn(0, b.j.finder_recent_like_setting_tips);
    AppMethodBeat.o(285301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI.f
 * JD-Core Version:    0.7.0.1
 */