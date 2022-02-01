package com.tencent.mm.plugin.finder.search.eventsearch;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ci;
import com.tencent.mm.plugin.finder.search.ui.b;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchViewConfig;", "Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchViewConfig;", "()V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "forceDarkMode", "", "getItemDecoration", "", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(342657);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a();
    AppMethodBeat.o(342657);
    return localg;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(342646);
    s.u(paramContext, "context");
    paramContext = (RecyclerView.LayoutManager)new FinderLinearLayoutManager(paramContext);
    AppMethodBeat.o(342646);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchViewConfig$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(342626);
      if (paramInt == 1)
      {
        localObject = (f)new ci();
        AppMethodBeat.o(342626);
        return localObject;
      }
      Object localObject = av.GiL;
      av.eY("FinderActivitySearchViewConfig", paramInt);
      localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(342626);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.eventsearch.a
 * JD-Core Version:    0.7.0.1
 */