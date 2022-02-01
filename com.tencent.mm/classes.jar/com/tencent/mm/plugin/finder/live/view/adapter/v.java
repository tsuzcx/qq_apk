package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "getItemCount", "", "getWinnderData", "pos", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "updateWinnerList", "winnerList", "Companion", "WinnerViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends RecyclerView.a<b>
{
  public static final a DRB;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private LinkedList<bjb> vEn;
  
  static
  {
    AppMethodBeat.i(358693);
    DRB = new a((byte)0);
    AppMethodBeat.o(358693);
  }
  
  public v(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(358660);
    this.CvU = parama;
    this.vEn = new LinkedList();
    AppMethodBeat.o(358660);
  }
  
  private void a(b paramb, int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(358684);
    s.u(paramb, "holder");
    int i;
    if (paramInt >= 0) {
      if (paramInt < this.vEn.size())
      {
        i = 1;
        if (i == 0) {
          break label176;
        }
        localObject1 = (bjb)this.vEn.get(paramInt);
        label48:
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          break label201;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCq();
        if (localObject1 != null) {
          break label182;
        }
        localObject2 = null;
        label77:
        localObject2 = new b((String)localObject2);
        ImageView localImageView = paramb.avatar;
        s.s(localImageView, "holder.avatar");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
        localObject2 = paramb.wBZ;
        localObject3 = paramb.wBZ.getContext();
        if (localObject1 != null) {
          break label192;
        }
      }
    }
    label176:
    label182:
    label192:
    for (paramb = null;; paramb = ((bjb)localObject1).nickname)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)paramb));
      AppMethodBeat.o(358684);
      return;
      i = 0;
      break;
      i = 0;
      break;
      localObject1 = null;
      break label48;
      localObject2 = ((bjb)localObject1).nVs;
      break label77;
    }
    label201:
    paramb.avatar.setVisibility(8);
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject1 != null) {
        break label344;
      }
      localObject1 = localObject3;
      label227:
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label354;
      }
    }
    label344:
    label354:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) || (!s.p(localObject1, z.bAM()))) {
        break label359;
      }
      paramb.wBZ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramb.wBZ.getContext(), (CharSequence)localObject2));
      Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder username:" + localObject1 + "(nickname:" + localObject2 + ")win the award");
      AppMethodBeat.o(358684);
      return;
      localObject2 = ((bjb)localObject1).nickname;
      break;
      localObject1 = ((bjb)localObject1).username;
      break label227;
    }
    label359:
    if ((localObject2 != null) && (((String)localObject2).length() >= 2))
    {
      localObject1 = s.X(com.tencent.mm.ae.d.av((String)localObject2, 1), "***");
      paramb.wBZ.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramb.wBZ.getContext(), (CharSequence)localObject1));
      AppMethodBeat.o(358684);
      return;
    }
    Log.i("Finder.LiveLotteryWinnerListAdapter", s.X("onBindViewHolder invalid nickName:", localObject2));
    Object localObject1 = String.valueOf(com.tencent.mm.pluginsdk.ui.span.p.b(paramb.wBZ.getContext(), (CharSequence)s.X((String)localObject2, "***")));
    Object localObject2 = (CharSequence)localObject2;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        localObject1 = "***";
      }
      paramb.wBZ.setText((CharSequence)localObject1);
      AppMethodBeat.o(358684);
      return;
    }
  }
  
  public final void av(LinkedList<bjb> paramLinkedList)
  {
    AppMethodBeat.i(358709);
    Object localObject2 = new StringBuilder("updateWinnerList,ori size:").append(this.vEn.size()).append(",new size:");
    if (paramLinkedList == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramLinkedList.size()))
    {
      Log.i("Finder.LiveLotteryWinnerListAdapter", localObject1);
      if (paramLinkedList == null) {
        break;
      }
      this.vEn.clear();
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bjb)((Iterator)localObject1).next();
        paramLinkedList.add(Boolean.valueOf(this.vEn.add(localObject2)));
      }
    }
    AppMethodBeat.o(358709);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358699);
    int i = this.vEn.size();
    AppMethodBeat.o(358699);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    ImageView avatar;
    TextView wBZ;
    
    public b()
    {
      super();
      AppMethodBeat.i(358644);
      this.avatar = ((ImageView)localObject.findViewById(p.e.avatar));
      this.wBZ = ((TextView)localObject.findViewById(p.e.nickname));
      AppMethodBeat.o(358644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.v
 * JD-Core Version:    0.7.0.1
 */