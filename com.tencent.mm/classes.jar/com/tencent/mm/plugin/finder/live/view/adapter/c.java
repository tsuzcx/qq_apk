package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$GameSelectItemHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lkotlin/collections/ArrayList;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "itemClickCallback", "Lkotlin/Function1;", "", "getItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "initLines", "holder", "position", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "GameSelectItemHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<a>
{
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.view.convert.b, ah> DPH;
  private boolean hasMore;
  private final ArrayList<com.tencent.mm.plugin.finder.live.view.convert.b> pUj;
  
  public c()
  {
    AppMethodBeat.i(358526);
    this.pUj = new ArrayList();
    AppMethodBeat.o(358526);
  }
  
  private static final void a(c paramc, com.tencent.mm.plugin.finder.live.view.convert.b paramb, View paramView)
  {
    AppMethodBeat.i(358536);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    s.u(paramb, "$item");
    paramc = paramc.DPH;
    if (paramc != null) {
      paramc.invoke(paramb);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358536);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358550);
    int i = this.pUj.size();
    AppMethodBeat.o(358550);
    return i;
  }
  
  public final void l(List<com.tencent.mm.plugin.finder.live.view.convert.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(358563);
    s.u(paramList, "data");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    this.hasMore = paramBoolean;
    AppMethodBeat.o(358563);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$GameSelectItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bottomLine", "kotlin.jvm.PlatformType", "getBottomLine", "()Landroid/view/View;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "gameIv", "Landroid/widget/ImageView;", "getGameIv", "()Landroid/widget/ImageView;", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "getGameSearchItem", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "setGameSearchItem", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;)V", "titleTv", "getTitleTv", "topLine", "getTopLine", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView DPI;
    public com.tencent.mm.plugin.finder.live.view.convert.b DPJ;
    final TextView descTv;
    final View plj;
    final TextView titleTv;
    final View uix;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(358530);
      this.titleTv = ((TextView)paramView.findViewById(p.e.BVu));
      this.descTv = ((TextView)paramView.findViewById(p.e.BUR));
      this.DPI = ((ImageView)paramView.findViewById(p.e.BUT));
      this.plj = paramView.findViewById(p.e.top_line);
      this.uix = paramView.findViewById(p.e.bottom_line);
      AppMethodBeat.o(358530);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.c
 * JD-Core Version:    0.7.0.1
 */