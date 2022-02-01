package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.bd;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.feed.ar.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class o
{
  private final MMActivity iXq;
  private final int spanCount;
  private final String wmL;
  private final String wmz;
  
  private o(String paramString1, String paramString2, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(264592);
    this.wmL = paramString1;
    this.wmz = paramString2;
    this.iXq = paramMMActivity;
    this.spanCount = 2;
    AppMethodBeat.o(264592);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public a(ar.a parama, b paramb) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(232564);
      switch (paramInt)
      {
      default: 
        localObject = this.zJM;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = aj.AGc;
          aj.em("FinderLbsConfig", paramInt);
          localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        }
        AppMethodBeat.o(232564);
        return localObject;
      case 1001: 
        localObject = (e)new be(this.Alo);
        AppMethodBeat.o(232564);
        return localObject;
      case 1002: 
        localObject = (e)new bd();
        AppMethodBeat.o(232564);
        return localObject;
      }
      Object localObject = (e)new ad();
      AppMethodBeat.o(232564);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */