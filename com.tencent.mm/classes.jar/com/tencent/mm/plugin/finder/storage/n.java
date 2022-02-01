package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.bb;
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class n
{
  private final int att;
  private final MMActivity gte;
  private final String sGE;
  private final String sGQ;
  
  private n(String paramString1, String paramString2, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(251765);
    this.sGQ = paramString1;
    this.sGE = paramString2;
    this.gte = paramMMActivity;
    this.att = 2;
    AppMethodBeat.o(251765);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public a(aj.a parama, b paramb) {}
    
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(251764);
      switch (paramInt)
      {
      default: 
        localObject = this.uTz;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = y.vXH;
          y.dQ("FinderLbsConfig", paramInt);
          localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        }
        AppMethodBeat.o(251764);
        return localObject;
      case 1001: 
        localObject = (e)new bc(this.vDY);
        AppMethodBeat.o(251764);
        return localObject;
      case 1002: 
        localObject = (e)new bb();
        AppMethodBeat.o(251764);
        return localObject;
      }
      Object localObject = (e)new ab();
      AppMethodBeat.o(251764);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.n
 * JD-Core Version:    0.7.0.1
 */