package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveMoreHeader;", "onClickMoreView", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnClickMoreView", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class af
  extends e<z>
{
  public static final a tDF;
  final kotlin.g.a.b<View, x> tDE;
  private View view;
  
  static
  {
    AppMethodBeat.i(243091);
    tDF = new a((byte)0);
    AppMethodBeat.o(243091);
  }
  
  public af(kotlin.g.a.b<? super View, x> paramb)
  {
    AppMethodBeat.i(243090);
    this.tDE = paramb;
    AppMethodBeat.o(243090);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243088);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aC(true);
    }
    paramh.aus.findViewById(2131304889).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(243088);
  }
  
  public final int getLayoutId()
  {
    return 2131492874;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(af paramaf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243087);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tDG.tDE;
      p.g(paramView, "it");
      ((kotlin.g.a.b)localObject).invoke(paramView);
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.af
 * JD-Core Version:    0.7.0.1
 */