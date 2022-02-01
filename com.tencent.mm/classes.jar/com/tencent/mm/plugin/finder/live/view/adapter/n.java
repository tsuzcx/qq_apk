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
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.aza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$AnchorLinkViewHolder;", "()V", "curPkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "localApplyMicMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onInviteAnchor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "invitetUser", "", "getOnInviteAnchor", "()Lkotlin/jvm/functions/Function1;", "setOnInviteAnchor", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateCurPkUser", "updateData", "data", "", "updateLocalApplyMicList", "AnchorLinkViewHolder", "plugin-finder_release"})
public final class n
  extends RecyclerView.a<a>
{
  private final ArrayList<aza> mXB;
  public HashMap<String, h> yXS;
  public h yXT;
  public kotlin.g.a.b<? super aza, x> yXU;
  
  public n()
  {
    AppMethodBeat.i(287527);
    this.mXB = new ArrayList();
    this.yXS = new HashMap();
    AppMethodBeat.o(287527);
  }
  
  public final void aa(List<? extends aza> paramList)
  {
    AppMethodBeat.i(287526);
    p.k(paramList, "data");
    this.mXB.clear();
    this.mXB.addAll((Collection)paramList);
    AppMethodBeat.o(287526);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(287524);
    int i = this.mXB.size();
    AppMethodBeat.o(287524);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$AnchorLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "inviteBtn", "getInviteBtn", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final ImageView mWb;
    final TextView xoK;
    final ImageView yVT;
    final TextView yXV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(277969);
      this.mWb = ((ImageView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_avatar_icon));
      this.xoK = ((TextView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_nickname_tv));
      this.yVT = ((ImageView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_type_icon));
      this.yXV = ((TextView)paramView.findViewById(b.f.finder_live_link_anchor_apply_item_action_btn));
      this.kEs = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_desc_tv));
      AppMethodBeat.o(277969);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(267890);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = (aza)j.M((List)n.a(this.yXW), this.jEN);
      if (paramView != null)
      {
        localObject = this.yXW.yXU;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.n
 * JD-Core Version:    0.7.0.1
 */