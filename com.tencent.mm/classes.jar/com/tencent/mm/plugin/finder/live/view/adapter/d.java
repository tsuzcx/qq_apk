package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "()V", "MAX_COUNT", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "getDataList", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "ApplyLinkViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<a>
{
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public kotlin.g.a.b<? super h, ah> DPK;
  private final int MAX_COUNT;
  private final ArrayList<h> pUj;
  
  public d()
  {
    AppMethodBeat.i(358539);
    this.pUj = new ArrayList();
    this.MAX_COUNT = 300;
    AppMethodBeat.o(358539);
  }
  
  private static final void a(d paramd, int paramInt, View paramView)
  {
    AppMethodBeat.i(358551);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = (h)p.ae((List)paramd.pUj, paramInt);
    if (paramView != null)
    {
      paramd = paramd.DPK;
      if (paramd != null) {
        paramd.invoke(paramView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358551);
  }
  
  public final void bz(List<h> paramList)
  {
    AppMethodBeat.i(358585);
    s.u(paramList, "data");
    this.pUj.clear();
    ArrayList localArrayList = this.pUj;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
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
    AppMethodBeat.o(358585);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358571);
    int i = this.pUj.size();
    AppMethodBeat.o(358571);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorApplyLinkAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView DPL;
    final TextView DPM;
    final ImageView avatar;
    final TextView descTv;
    final TextView nicknameTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(358972);
      this.avatar = ((ImageView)paramView.findViewById(p.e.BMI));
      this.nicknameTv = ((TextView)paramView.findViewById(p.e.BMJ));
      this.DPL = ((ImageView)paramView.findViewById(p.e.BMK));
      this.DPM = ((TextView)paramView.findViewById(p.e.BMH));
      this.descTv = ((TextView)paramView.findViewById(p.e.BMM));
      AppMethodBeat.o(358972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.d
 * JD-Core Version:    0.7.0.1
 */