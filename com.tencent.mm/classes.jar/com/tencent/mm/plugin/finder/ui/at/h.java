package com.tencent.mm.plugin.finder.ui.at;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.mm.w.a.a.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneSearchItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "forceDarkMode", "", "(Ljava/lang/Boolean;)V", "getForceDarkMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f<g>
{
  private final Boolean DHP;
  
  public h(Boolean paramBoolean)
  {
    this.DHP = paramBoolean;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(347940);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(347940);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(347935);
    if (a.mp(MMApplicationContext.getContext()))
    {
      i = a.f.select_ui_listcontactitem_large;
      AppMethodBeat.o(347935);
      return i;
    }
    int i = a.f.select_ui_listcontactitem;
    AppMethodBeat.o(347935);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.h
 * JD-Core Version:    0.7.0.1
 */