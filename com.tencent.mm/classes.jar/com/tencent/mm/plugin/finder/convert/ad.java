package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveMoreHeader;", "onClickMoreView", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnClickMoreView", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends f<aa>
{
  public static final a AKA;
  private final kotlin.g.a.b<View, ah> AKB;
  private View view;
  
  static
  {
    AppMethodBeat.i(350112);
    AKA = new a((byte)0);
    AppMethodBeat.o(350112);
  }
  
  public ad(kotlin.g.a.b<? super View, ah> paramb)
  {
    AppMethodBeat.i(350100);
    this.AKB = paramb;
    AppMethodBeat.o(350100);
  }
  
  private static final void a(ad paramad, View paramView)
  {
    AppMethodBeat.i(350107);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramad, "this$0");
    paramad = paramad.AKB;
    s.s(paramView, "it");
    paramad.invoke(paramView);
    a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350107);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350130);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    paramj.caK.findViewById(e.e.more_live_cl).setOnClickListener(new ad..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(350130);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_header_same_city_live_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedSameCityLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */