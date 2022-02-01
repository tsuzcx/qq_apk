package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.buy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter$AnchorLinkViewHolder;", "()V", "curPkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "localApplyMicMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onInviteAnchor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "invitetUser", "", "getOnInviteAnchor", "()Lkotlin/jvm/functions/Function1;", "setOnInviteAnchor", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateCurPkUser", "updateData", "data", "", "updateLocalApplyMicList", "AnchorLinkViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends RecyclerView.a<a>
{
  public HashMap<String, h> DRx;
  public h DRy;
  public kotlin.g.a.b<? super buy, ah> DRz;
  private final ArrayList<buy> pUj;
  
  public u()
  {
    AppMethodBeat.i(358646);
    this.pUj = new ArrayList();
    this.DRx = new HashMap();
    AppMethodBeat.o(358646);
  }
  
  private static final void a(u paramu, int paramInt, View paramView)
  {
    AppMethodBeat.i(358655);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramu);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    paramView = (buy)p.ae((List)paramu.pUj, paramInt);
    if (paramView != null)
    {
      paramu = paramu.DRz;
      if (paramu != null) {
        paramu.invoke(paramView);
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358655);
  }
  
  public final void bz(List<? extends buy> paramList)
  {
    AppMethodBeat.i(358680);
    s.u(paramList, "data");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    AppMethodBeat.o(358680);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358671);
    int i = this.pUj.size();
    AppMethodBeat.o(358671);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorSearchAdapter$AnchorLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "inviteBtn", "getInviteBtn", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView DPL;
    final TextView DRA;
    final ImageView avatar;
    final TextView descTv;
    final TextView nicknameTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(359049);
      this.avatar = ((ImageView)paramView.findViewById(p.e.BMI));
      this.nicknameTv = ((TextView)paramView.findViewById(p.e.BMJ));
      this.DPL = ((ImageView)paramView.findViewById(p.e.BMK));
      this.DRA = ((TextView)paramView.findViewById(p.e.BMH));
      this.descTv = ((TextView)paramView.findViewById(p.e.BMM));
      AppMethodBeat.o(359049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.u
 * JD-Core Version:    0.7.0.1
 */