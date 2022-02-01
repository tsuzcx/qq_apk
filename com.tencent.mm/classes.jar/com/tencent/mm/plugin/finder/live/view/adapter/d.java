package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "()V", "MAX_COUNT", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "getDataList", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class d
  extends RecyclerView.a<a>
{
  private final int MAX_COUNT;
  private final ArrayList<h> mXB;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  public kotlin.g.a.b<? super h, x> yVS;
  
  public d()
  {
    AppMethodBeat.i(274449);
    this.mXB = new ArrayList();
    this.MAX_COUNT = 300;
    AppMethodBeat.o(274449);
  }
  
  public final void aa(List<h> paramList)
  {
    AppMethodBeat.i(274448);
    p.k(paramList, "data");
    this.mXB.clear();
    ArrayList localArrayList = this.mXB;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      if (i < this.MAX_COUNT) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          paramList.add(localObject2);
        }
        i += 1;
        break;
      }
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(274448);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(274446);
    int i = this.mXB.size();
    AppMethodBeat.o(274446);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final ImageView mWb;
    final TextView xoK;
    final ImageView yVT;
    final TextView yVU;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(291208);
      this.mWb = ((ImageView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_avatar_icon));
      this.xoK = ((TextView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_nickname_tv));
      this.yVT = ((ImageView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_type_icon));
      this.yVU = ((TextView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_action_btn));
      this.kEs = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_desc_tv));
      AppMethodBeat.o(291208);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272832);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = (h)j.M((List)d.a(this.yVV), this.jEN);
      if (paramView != null)
      {
        localObject = this.yVV.yVS;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.d
 * JD-Core Version:    0.7.0.1
 */