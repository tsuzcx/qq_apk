package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.h;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "attachRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isStatistic", "", "detachRecyclerView", "getData", "index", "", "getId", "isSystemMsgExpose", "plugin-finder_release"})
public final class ap
  extends an<String, d>
{
  private h zZR;
  
  public ap()
  {
    AppMethodBeat.i(285396);
    a locala = new a();
    locala.zTE = ((af)new a());
    this.zZO = locala;
    AppMethodBeat.o(285396);
  }
  
  private d PT(int paramInt)
  {
    AppMethodBeat.i(285395);
    Object localObject = this.zZR;
    if (localObject != null)
    {
      localObject = ((h)localObject).Ma(paramInt);
      AppMethodBeat.o(285395);
      return localObject;
    }
    AppMethodBeat.o(285395);
    return null;
  }
  
  public final void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    AppMethodBeat.i(285391);
    p.k(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramBoolean);
    if ((paramRecyclerView.getAdapter() instanceof h))
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
        AppMethodBeat.o(285391);
        throw paramRecyclerView;
      }
      this.zZR = ((h)paramRecyclerView);
    }
    AppMethodBeat.o(285391);
  }
  
  public final void dQB()
  {
    AppMethodBeat.i(285393);
    super.dQB();
    this.zZR = null;
    AppMethodBeat.o(285393);
  }
  
  public final boolean dQC()
  {
    AppMethodBeat.i(285392);
    Object localObject = getRecyclerView();
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        this.xrh = i.ov(0, ((LinearLayoutManager)localObject).kJ());
        this.xrj = i.ov(0, ((LinearLayoutManager)localObject).kL());
        int i = this.xrh;
        int j = this.xrj;
        if (i <= j) {
          for (;;)
          {
            localObject = PT(i);
            if ((localObject != null) && (p.h(((d)localObject).field_sessionId, "finder_system_message")))
            {
              AppMethodBeat.o(285392);
              return true;
            }
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(285392);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/report/SystemMsgScrollListener$1$condition$1", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "", "filter", "", "id", "plugin-finder_release"})
  public static final class a
    implements af<String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ap
 * JD-Core Version:    0.7.0.1
 */