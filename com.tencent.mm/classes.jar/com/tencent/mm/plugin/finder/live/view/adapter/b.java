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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$RecentPlayItemHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lkotlin/collections/ArrayList;", "itemClickCallback", "Lkotlin/Function1;", "", "getItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "RecentPlayItemHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<a>
{
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.view.convert.b, ah> DPH;
  public final ArrayList<com.tencent.mm.plugin.finder.live.view.convert.b> pUj;
  
  public b()
  {
    AppMethodBeat.i(358524);
    this.pUj = new ArrayList();
    AppMethodBeat.o(358524);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.finder.live.view.convert.b paramb1, View paramView)
  {
    AppMethodBeat.i(358531);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramb1);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramb1, "$item");
    paramb = paramb.DPH;
    if (paramb != null) {
      paramb.invoke(paramb1);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358531);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358547);
    int i = this.pUj.size();
    AppMethodBeat.o(358547);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$RecentPlayItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDescTv", "()Landroid/widget/TextView;", "gameIv", "Landroid/widget/ImageView;", "getGameIv", "()Landroid/widget/ImageView;", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "getGameSearchItem", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "setGameSearchItem", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;)V", "titleTv", "getTitleTv", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView DPI;
    public com.tencent.mm.plugin.finder.live.view.convert.b DPJ;
    final TextView descTv;
    final TextView titleTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(358997);
      this.titleTv = ((TextView)paramView.findViewById(p.e.BVu));
      this.descTv = ((TextView)paramView.findViewById(p.e.BUR));
      this.DPI = ((ImageView)paramView.findViewById(p.e.BUT));
      AppMethodBeat.o(358997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */