package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.cny;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/GameTeamConditionBottomSheet$TeamInfoData;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "source", "(Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class w$c
  extends k.a<cny>
{
  public w$c(cny paramcny)
  {
    super(paramcny, (byte)0);
    AppMethodBeat.i(291538);
    AppMethodBeat.o(291538);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(291537);
    p.k(paramk, "obj");
    if ((paramk instanceof c))
    {
      if (((cny)this.bnW).value == ((cny)((c)paramk).bnW).value)
      {
        AppMethodBeat.o(291537);
        return 0;
      }
      AppMethodBeat.o(291537);
      return 1;
    }
    AppMethodBeat.o(291537);
    return 1;
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    return ((cny)this.bnW).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.w.c
 * JD-Core Version:    0.7.0.1
 */