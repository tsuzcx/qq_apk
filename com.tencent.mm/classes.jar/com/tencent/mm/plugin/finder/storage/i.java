package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.ac;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class i
{
  private final int arE;
  final String qom;
  final String qox;
  
  private i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202959);
    this.qox = paramString1;
    this.qom = paramString2;
    this.arE = 2;
    AppMethodBeat.o(202959);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(202958);
      switch (paramInt)
      {
      default: 
        localObject = this.rDn;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).ay(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          k.fOy();
          localObject = null;
        }
        AppMethodBeat.o(202958);
        return localObject;
      case 1001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ae(this.rDH.qox, this.rDH.qom);
        AppMethodBeat.o(202958);
        return localObject;
      case 1002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ad();
        AppMethodBeat.o(202958);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new n();
        AppMethodBeat.o(202958);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ac();
        AppMethodBeat.o(202958);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new aa();
      AppMethodBeat.o(202958);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */