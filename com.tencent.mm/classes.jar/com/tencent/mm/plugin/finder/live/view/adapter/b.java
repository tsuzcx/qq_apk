package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import java.util.ArrayList;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$RecentPlayItemHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lkotlin/collections/ArrayList;", "itemClickCallback", "Lkotlin/Function1;", "", "getItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "RecentPlayItemHolder", "plugin-finder_release"})
public final class b
  extends RecyclerView.a<a>
{
  public final ArrayList<com.tencent.mm.plugin.finder.live.view.convert.b> mXB;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.view.convert.b, x> yVM;
  
  public b()
  {
    AppMethodBeat.i(225148);
    this.mXB = new ArrayList();
    AppMethodBeat.o(225148);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(225142);
    int i = this.mXB.size();
    AppMethodBeat.o(225142);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$RecentPlayItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDescTv", "()Landroid/widget/TextView;", "gameIv", "Landroid/widget/ImageView;", "getGameIv", "()Landroid/widget/ImageView;", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "getGameSearchItem", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "setGameSearchItem", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;)V", "titleTv", "getTitleTv", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final TextView titleTv;
    final ImageView yVN;
    public com.tencent.mm.plugin.finder.live.view.convert.b yVO;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(281520);
      this.titleTv = ((TextView)paramView.findViewById(b.f.game_title_tv));
      this.kEs = ((TextView)paramView.findViewById(b.f.game_desc_tv));
      this.yVN = ((ImageView)paramView.findViewById(b.f.game_icon_iv));
      AppMethodBeat.o(281520);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, com.tencent.mm.plugin.finder.live.view.convert.b paramb1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252336);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.yVP.yVM;
      if (paramView != null) {
        paramView.invoke(this.yVQ);
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveRecentPlayAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */