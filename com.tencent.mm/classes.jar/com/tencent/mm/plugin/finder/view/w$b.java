package com.tencent.mm.plugin.finder.view;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet$GameTeamConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "isLast", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class w$b
  extends e<k.a<cny>>
{
  private final b<Integer, Boolean> Bct;
  
  public w$b(b<? super Integer, Boolean> paramb)
  {
    AppMethodBeat.i(276565);
    this.Bct = paramb;
    AppMethodBeat.o(276565);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(276563);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(276563);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_gameteam_condition_item_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.w.b
 * JD-Core Version:    0.7.0.1
 */