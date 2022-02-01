package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.ag;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class l
{
  private final int atv;
  final String rfA;
  final String rfo;
  
  private l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204252);
    this.rfA = paramString1;
    this.rfo = paramString2;
    this.atv = 2;
    AppMethodBeat.o(204252);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(204251);
      switch (paramInt)
      {
      default: 
        localObject = this.sIN;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          p.gkB();
          localObject = null;
        }
        AppMethodBeat.o(204251);
        return localObject;
      case 1001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ag(this.sJk.rfA, this.sJk.rfo);
        AppMethodBeat.o(204251);
        return localObject;
      case 1002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new af();
        AppMethodBeat.o(204251);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new o();
      AppMethodBeat.o(204251);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */