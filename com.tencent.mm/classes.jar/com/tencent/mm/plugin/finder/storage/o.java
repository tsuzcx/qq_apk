package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.aj;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.al;
import com.tencent.mm.view.recyclerview.c;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "(Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getIfReachBottom", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class o
{
  final String KHW;
  private final int aqI;
  final String qwV;
  
  private o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198995);
    this.qwV = paramString1;
    this.KHW = paramString2;
    this.aqI = 2;
    AppMethodBeat.o(198995);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public a(d.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(198994);
      switch (paramInt)
      {
      default: 
        localObject = this.KWv;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)((d.g.a.b)localObject).aA(Integer.valueOf(paramInt));
          localObject = localb;
          if (localb != null) {}
        }
        else
        {
          d.g.b.k.fvU();
          localObject = null;
        }
        AppMethodBeat.o(198994);
        return localObject;
      case 1001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new al(this.KWH.qwV, this.KWH.KHW);
        AppMethodBeat.o(198994);
        return localObject;
      case 1002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new ak();
        AppMethodBeat.o(198994);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(198994);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new aj();
        AppMethodBeat.o(198994);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.b)new ah();
      AppMethodBeat.o(198994);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */