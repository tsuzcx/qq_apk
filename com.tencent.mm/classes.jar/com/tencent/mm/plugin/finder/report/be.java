package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.b;
import com.tencent.mm.plugin.finder.conv.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "attachRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isStatistic", "", "detachRecyclerView", "getData", "index", "", "getId", "isSystemMsgExpose", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends bc<String, b>
{
  private f FuN;
  
  public be()
  {
    AppMethodBeat.i(331064);
    a locala = new a();
    locala.Fnp = ((at)new a());
    ah localah = ah.aiuX;
    this.FuL = locala;
    AppMethodBeat.o(331064);
  }
  
  private b Ta(int paramInt)
  {
    AppMethodBeat.i(331067);
    Object localObject = this.FuN;
    if (localObject == null)
    {
      AppMethodBeat.o(331067);
      return null;
    }
    localObject = ((f)localObject).Ne(paramInt);
    AppMethodBeat.o(331067);
    return localObject;
  }
  
  public final void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    AppMethodBeat.i(331074);
    s.u(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramBoolean);
    if ((paramRecyclerView.getAdapter() instanceof f))
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
        AppMethodBeat.o(331074);
        throw paramRecyclerView;
      }
      this.FuN = ((f)paramRecyclerView);
    }
    AppMethodBeat.o(331074);
  }
  
  public final void eNY()
  {
    AppMethodBeat.i(331086);
    super.eNY();
    this.FuN = null;
    AppMethodBeat.o(331086);
  }
  
  public final boolean eNZ()
  {
    AppMethodBeat.i(331081);
    Object localObject = getRecyclerView();
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if ((localObject instanceof LinearLayoutManager))
      {
        SX(k.qu(0, ((LinearLayoutManager)localObject).Ju()));
        SY(k.qu(0, ((LinearLayoutManager)localObject).Jw()));
        i = dYN();
        j = dYO();
        if (i > j) {}
      }
    }
    for (;;)
    {
      localObject = Ta(i);
      if ((localObject != null) && (s.p(((b)localObject).field_sessionId, "finder_system_message")))
      {
        AppMethodBeat.o(331081);
        return true;
      }
      if (i == j)
      {
        AppMethodBeat.o(331081);
        return false;
      }
      i += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/SystemMsgScrollListener$1$condition$1", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "", "filter", "", "id", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements at<String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.be
 * JD-Core Version:    0.7.0.1
 */