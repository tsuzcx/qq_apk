package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.az;
import com.tencent.mm.plugin.finder.convert.ba;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.feed.ay.a;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderLbsConfig;", "", "contextId", "", "clickTabContextId", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "getClickTabContextId", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getContextId", "spanCount", "", "getSpanCount", "()I", "canFullSpan", "", "type", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  private final MMActivity lzt;
  private final int spanCount;
  private final String zIB;
  private final String zIO;
  
  private p(String paramString1, String paramString2, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339198);
    this.zIO = paramString1;
    this.zIB = paramString2;
    this.lzt = paramMMActivity;
    this.spanCount = 2;
    AppMethodBeat.o(339198);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/storage/FinderLbsConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    public a(ay.a<c> parama, b<? super Integer, ? extends f<?>> paramb, p paramp) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(339184);
      switch (paramInt)
      {
      default: 
        localObject = this.Bbh;
        if (localObject != null) {
          break;
        }
      }
      for (Object localObject = null; localObject == null; localObject = (f)((b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = av.GiL;
        av.eY("FinderLbsConfig", paramInt);
        localObject = (f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(339184);
        return localObject;
        localObject = (f)new ba(this.FKO);
        AppMethodBeat.o(339184);
        return localObject;
        localObject = (f)new az();
        AppMethodBeat.o(339184);
        return localObject;
        localObject = (f)new z();
        AppMethodBeat.o(339184);
        return localObject;
      }
      AppMethodBeat.o(339184);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.p
 * JD-Core Version:    0.7.0.1
 */