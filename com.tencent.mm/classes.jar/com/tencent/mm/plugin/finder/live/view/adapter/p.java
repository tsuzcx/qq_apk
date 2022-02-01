package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "getItemCount", "", "getWinnderData", "pos", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "updateWinnerList", "winnerList", "Companion", "WinnerViewHolder", "plugin-finder_release"})
public final class p
  extends RecyclerView.a<b>
{
  public static final a yXY;
  private LinkedList<bak> syG;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  
  static
  {
    AppMethodBeat.i(290429);
    yXY = new a((byte)0);
    AppMethodBeat.o(290429);
  }
  
  public p(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(290428);
    this.xYp = parama;
    this.syG = new LinkedList();
    AppMethodBeat.o(290428);
  }
  
  private final bak NN(int paramInt)
  {
    AppMethodBeat.i(290427);
    int i = this.syG.size();
    if (paramInt < 0) {}
    while (i <= paramInt)
    {
      AppMethodBeat.o(290427);
      return null;
    }
    bak localbak = (bak)this.syG.get(paramInt);
    AppMethodBeat.o(290427);
    return localbak;
  }
  
  private void a(b paramb, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(290425);
    kotlin.g.b.p.k(paramb, "holder");
    Object localObject3 = NN(paramInt);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject1 = t.ztT;
      localObject2 = t.dJi();
      if (localObject3 != null)
      {
        localObject1 = ((bak)localObject3).lqp;
        localObject1 = new e((String)localObject1);
        ImageView localImageView = paramb.mWb;
        kotlin.g.b.p.j(localImageView, "holder.avatar");
        t localt = t.ztT;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, t.a(t.a.ztZ));
        localObject1 = paramb.txD;
        kotlin.g.b.p.j(localObject1, "holder.nickName");
        paramb = paramb.txD;
        kotlin.g.b.p.j(paramb, "holder.nickName");
        localObject2 = paramb.getContext();
        if (localObject3 == null) {
          break label158;
        }
      }
      label158:
      for (paramb = ((bak)localObject3).nickname;; paramb = null)
      {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)paramb));
        AppMethodBeat.o(290425);
        return;
        localObject1 = null;
        break;
      }
    }
    localObject1 = paramb.mWb;
    kotlin.g.b.p.j(localObject1, "holder.avatar");
    ((ImageView)localObject1).setVisibility(8);
    if (localObject3 != null)
    {
      localObject1 = ((bak)localObject3).nickname;
      if (localObject3 != null) {
        localObject2 = ((bak)localObject3).username;
      }
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label332;
      }
    }
    label332:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) || (!kotlin.g.b.p.h(localObject2, z.bcZ()))) {
        break label337;
      }
      localObject3 = paramb.txD;
      kotlin.g.b.p.j(localObject3, "holder.nickName");
      paramb = paramb.txD;
      kotlin.g.b.p.j(paramb, "holder.nickName");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramb.getContext(), (CharSequence)localObject1));
      Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder username:" + (String)localObject2 + "(nickname:" + (String)localObject1 + ")win the award");
      AppMethodBeat.o(290425);
      return;
      localObject1 = null;
      break;
    }
    label337:
    if ((localObject1 != null) && (((String)localObject1).length() >= 2))
    {
      localObject1 = com.tencent.mm.ae.d.am((String)localObject1, 1);
      localObject1 = (String)localObject1 + "***";
      localObject2 = paramb.txD;
      kotlin.g.b.p.j(localObject2, "holder.nickName");
      paramb = paramb.txD;
      kotlin.g.b.p.j(paramb, "holder.nickName");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramb.getContext(), (CharSequence)localObject1));
      AppMethodBeat.o(290425);
      return;
    }
    Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder invalid nickName:".concat(String.valueOf(localObject1)));
    localObject2 = paramb.txD;
    kotlin.g.b.p.j(localObject2, "holder.nickName");
    localObject2 = String.valueOf(com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject2).getContext(), (CharSequence)((String)localObject1 + "***")));
    localObject1 = (CharSequence)localObject1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localObject1 = localObject2;
      if (paramInt != 0) {
        localObject1 = "***";
      }
      paramb = paramb.txD;
      kotlin.g.b.p.j(paramb, "holder.nickName");
      paramb.setText((CharSequence)localObject1);
      AppMethodBeat.o(290425);
      return;
    }
  }
  
  public final void at(LinkedList<bak> paramLinkedList)
  {
    AppMethodBeat.i(290423);
    Object localObject2 = new StringBuilder("updateWinnerList,ori size:").append(this.syG.size()).append(",new size:");
    if (paramLinkedList != null) {}
    for (Object localObject1 = Integer.valueOf(paramLinkedList.size());; localObject1 = null)
    {
      Log.i("Finder.LiveLotteryWinnerListAdapter", localObject1);
      if (paramLinkedList == null) {
        break label150;
      }
      this.syG.clear();
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bak)((Iterator)localObject1).next();
        paramLinkedList.add(Boolean.valueOf(this.syG.add(localObject2)));
      }
    }
    AppMethodBeat.o(290423);
    return;
    label150:
    AppMethodBeat.o(290423);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(290422);
    int i = this.syG.size();
    AppMethodBeat.o(290422);
    return i;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView mWb;
    TextView txD;
    
    public b()
    {
      super();
      AppMethodBeat.i(275224);
      this.mWb = ((ImageView)localObject.findViewById(b.f.avatar));
      this.txD = ((TextView)localObject.findViewById(b.f.nickname));
      AppMethodBeat.o(275224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.p
 * JD-Core Version:    0.7.0.1
 */