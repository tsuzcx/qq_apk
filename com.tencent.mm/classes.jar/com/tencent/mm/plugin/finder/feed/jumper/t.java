package com.tencent.mm.plugin.finder.feed.jumper;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/OlympicsEventHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/BaseJumperEventHandler;", "()V", "getReportType", "", "onClickDo", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "Landroid/view/View;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends d
{
  public final void a(j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364169);
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    AppMethodBeat.o(364169);
  }
  
  public final int edC()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.t
 * JD-Core Version:    0.7.0.1
 */