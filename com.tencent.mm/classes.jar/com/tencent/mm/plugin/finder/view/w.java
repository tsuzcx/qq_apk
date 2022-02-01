package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "selectListener", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "getSelectListener", "()Lkotlin/jvm/functions/Function1;", "createData", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "source", "createItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "onItemClick", "", "position", "data", "Companion", "GameTeamConvert", "TeamInfoData", "plugin-finder_release"})
public final class w
  extends k<cny>
{
  public static final a Bcs;
  private final b<cny, x> Bcr;
  
  static
  {
    AppMethodBeat.i(281363);
    Bcs = new a((byte)0);
    AppMethodBeat.o(281363);
  }
  
  public w(b<? super cny, x> paramb)
  {
    AppMethodBeat.i(281362);
    this.Bcr = paramb;
    AppMethodBeat.o(281362);
  }
  
  public final boolean a(k.a<cny> parama)
  {
    AppMethodBeat.i(281360);
    p.k(parama, "data");
    this.Bcr.invoke(parama.bnW);
    AppMethodBeat.o(281360);
    return true;
  }
  
  public final e<?> ejb()
  {
    AppMethodBeat.i(281357);
    e locale = (e)new w.b((b)new d(this));
    AppMethodBeat.o(281357);
    return locale;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet$Companion;", "", "()V", "ITEM_TYPE_TEAM_INFO", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "index", "", "invoke"})
  static final class d
    extends q
    implements b<Integer, Boolean>
  {
    d(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.w
 * JD-Core Version:    0.7.0.1
 */