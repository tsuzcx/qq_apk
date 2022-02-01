package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class l
{
  private final int atv;
  final String qXj;
  final String qXu;
  
  private l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203684);
    this.qXu = paramString1;
    this.qXj = paramString2;
    this.atv = 2;
    AppMethodBeat.o(203684);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(203683);
      switch (paramInt)
      {
      default: 
        localObject = this.sxW;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          p.gfZ();
          localObject = null;
        }
        AppMethodBeat.o(203683);
        return localObject;
      case 1001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new af(this.syt.qXu, this.syt.qXj);
        AppMethodBeat.o(203683);
        return localObject;
      case 1002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ae();
        AppMethodBeat.o(203683);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new o();
      AppMethodBeat.o(203683);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */