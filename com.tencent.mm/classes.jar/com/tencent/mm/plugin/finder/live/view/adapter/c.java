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
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$GameSelectItemHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lkotlin/collections/ArrayList;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "itemClickCallback", "Lkotlin/Function1;", "", "getItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "initLines", "holder", "position", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "GameSelectItemHolder", "plugin-finder_release"})
public final class c
  extends RecyclerView.a<a>
{
  private boolean hasMore;
  private final ArrayList<com.tencent.mm.plugin.finder.live.view.convert.b> mXB;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.view.convert.b, x> yVM;
  
  public c()
  {
    AppMethodBeat.i(283740);
    this.mXB = new ArrayList();
    AppMethodBeat.o(283740);
  }
  
  public final void e(List<com.tencent.mm.plugin.finder.live.view.convert.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(283739);
    p.k(paramList, "data");
    this.mXB.clear();
    this.mXB.addAll((Collection)paramList);
    this.hasMore = paramBoolean;
    AppMethodBeat.o(283739);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(283737);
    int i = this.mXB.size();
    AppMethodBeat.o(283737);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$GameSelectItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bottomLine", "kotlin.jvm.PlatformType", "getBottomLine", "()Landroid/view/View;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "gameIv", "Landroid/widget/ImageView;", "getGameIv", "()Landroid/widget/ImageView;", "gameSearchItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "getGameSearchItem", "()Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "setGameSearchItem", "(Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;)V", "titleTv", "getTitleTv", "topLine", "getTopLine", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final View mrE;
    final View rcN;
    final TextView titleTv;
    final ImageView yVN;
    public com.tencent.mm.plugin.finder.live.view.convert.b yVO;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(279162);
      this.titleTv = ((TextView)paramView.findViewById(b.f.game_title_tv));
      this.kEs = ((TextView)paramView.findViewById(b.f.game_desc_tv));
      this.yVN = ((ImageView)paramView.findViewById(b.f.game_icon_iv));
      this.mrE = paramView.findViewById(b.f.top_line);
      this.rcN = paramView.findViewById(b.f.bottom_line);
      AppMethodBeat.o(279162);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, com.tencent.mm.plugin.finder.live.view.convert.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.yVR.yVM;
      if (paramView != null) {
        paramView.invoke(this.yVQ);
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderGameLiveSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(238999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.c
 * JD-Core Version:    0.7.0.1
 */