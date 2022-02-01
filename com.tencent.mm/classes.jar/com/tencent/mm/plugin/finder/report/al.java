package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.g;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "attachRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "isStatistic", "", "detachRecyclerView", "getData", "index", "", "getId", "isSystemMsgExpose", "plugin-finder_release"})
public final class al
  extends ak<String, c>
{
  private g viX;
  
  public al()
  {
    AppMethodBeat.i(250890);
    a locala = new a();
    locala.vcN = ((ab)new a());
    this.viV = locala;
    AppMethodBeat.o(250890);
  }
  
  private c KH(int paramInt)
  {
    AppMethodBeat.i(250889);
    Object localObject = this.viX;
    if (localObject != null)
    {
      localObject = ((g)localObject).Ip(paramInt);
      AppMethodBeat.o(250889);
      return localObject;
    }
    AppMethodBeat.o(250889);
    return null;
  }
  
  public final void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    AppMethodBeat.i(250885);
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramBoolean);
    if ((paramRecyclerView.getAdapter() instanceof g))
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
        AppMethodBeat.o(250885);
        throw paramRecyclerView;
      }
      this.viX = ((g)paramRecyclerView);
    }
    AppMethodBeat.o(250885);
  }
  
  public final void doY()
  {
    AppMethodBeat.i(250887);
    super.doY();
    this.viX = null;
    AppMethodBeat.o(250887);
  }
  
  public final boolean doZ()
  {
    AppMethodBeat.i(250886);
    Object localObject = this.hak;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        this.tIy = j.mZ(0, ((LinearLayoutManager)localObject).ks());
        this.tIA = j.mZ(0, ((LinearLayoutManager)localObject).ku());
        int i = this.tIy;
        int j = this.tIA;
        if (i <= j) {
          for (;;)
          {
            localObject = KH(i);
            if ((localObject != null) && (p.j(((c)localObject).field_sessionId, "finder_system_message")))
            {
              AppMethodBeat.o(250886);
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
    AppMethodBeat.o(250886);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/SystemMsgScrollListener$1$condition$1", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "", "filter", "", "id", "plugin-finder_release"})
  public static final class a
    implements ab<String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.al
 * JD-Core Version:    0.7.0.1
 */