package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "getItemCount", "", "getWinnderData", "pos", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "updateWinnerList", "winnerList", "Companion", "WinnerViewHolder", "plugin-finder_release"})
public final class f
  extends RecyclerView.a<b>
{
  public static final a uAU;
  private final g liveData;
  private LinkedList<awh> ppH;
  
  static
  {
    AppMethodBeat.i(247794);
    uAU = new a((byte)0);
    AppMethodBeat.o(247794);
  }
  
  public f(g paramg)
  {
    AppMethodBeat.i(247793);
    this.liveData = paramg;
    this.ppH = new LinkedList();
    AppMethodBeat.o(247793);
  }
  
  private final awh Jo(int paramInt)
  {
    AppMethodBeat.i(247792);
    int i = this.ppH.size();
    if (paramInt < 0) {}
    while (i <= paramInt)
    {
      AppMethodBeat.o(247792);
      return null;
    }
    awh localawh = (awh)this.ppH.get(paramInt);
    AppMethodBeat.o(247792);
    return localawh;
  }
  
  private void a(b paramb, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247790);
    p.h(paramb, "holder");
    Object localObject3 = Jo(paramInt);
    Object localObject1 = b.hCo;
    if (b.a.aDp())
    {
      localObject1 = paramb.keC;
      p.g(localObject1, "holder.avatar");
      ((ImageView)localObject1).setVisibility(8);
      if (localObject3 != null)
      {
        localObject1 = ((awh)localObject3).nickname;
        if (localObject3 != null) {
          localObject2 = ((awh)localObject3).username;
        }
        localObject3 = (CharSequence)localObject2;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label200;
        }
      }
      label200:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt != 0) || (!p.j(localObject2, z.aTY()))) {
          break label205;
        }
        localObject3 = paramb.qbF;
        p.g(localObject3, "holder.nickName");
        paramb = paramb.qbF;
        p.g(paramb, "holder.nickName");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramb.getContext(), (CharSequence)localObject1));
        Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder username:" + (String)localObject2 + "(nickname:" + (String)localObject1 + ")win the award");
        AppMethodBeat.o(247790);
        return;
        localObject1 = null;
        break;
      }
      label205:
      if ((localObject1 != null) && (((String)localObject1).length() >= 2))
      {
        localObject1 = com.tencent.mm.ac.d.Gb((String)localObject1);
        localObject3 = (String)localObject1 + "***";
        localObject2 = paramb.qbF;
        p.g(localObject2, "holder.nickName");
        paramb = paramb.qbF;
        p.g(paramb, "holder.nickName");
        localObject1 = paramb.getContext();
        paramb = (b)localObject3;
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)paramb));
      AppMethodBeat.o(247790);
      return;
      Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder invalid nickName:".concat(String.valueOf(localObject1)));
      localObject2 = paramb.qbF;
      p.g(localObject2, "holder.nickName");
      localObject2 = String.valueOf(com.tencent.mm.pluginsdk.ui.span.l.c(((TextView)localObject2).getContext(), (CharSequence)((String)localObject1 + "***")));
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localObject1 = localObject2;
        if (paramInt != 0) {
          localObject1 = "***";
        }
        paramb = paramb.qbF;
        p.g(paramb, "holder.nickName");
        paramb.setText((CharSequence)localObject1);
        AppMethodBeat.o(247790);
        return;
      }
      localObject1 = m.uJa;
      localObject2 = m.dkb();
      if (localObject3 != null) {}
      for (localObject1 = ((awh)localObject3).iAR;; localObject1 = null)
      {
        localObject1 = new a((String)localObject1);
        ImageView localImageView = paramb.keC;
        p.g(localImageView, "holder.avatar");
        m localm = m.uJa;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, m.a(m.a.uJg));
        localObject2 = paramb.qbF;
        p.g(localObject2, "holder.nickName");
        paramb = paramb.qbF;
        p.g(paramb, "holder.nickName");
        localObject1 = paramb.getContext();
        if (localObject3 == null) {
          break label528;
        }
        paramb = ((awh)localObject3).nickname;
        break;
      }
      label528:
      paramb = null;
    }
  }
  
  public final void an(LinkedList<awh> paramLinkedList)
  {
    AppMethodBeat.i(247788);
    Object localObject2 = new StringBuilder("updateWinnerList,ori size:").append(this.ppH.size()).append(",new size:");
    if (paramLinkedList != null) {}
    for (Object localObject1 = Integer.valueOf(paramLinkedList.size());; localObject1 = null)
    {
      Log.i("Finder.LiveShoppingListAdapter", localObject1);
      if (paramLinkedList == null) {
        break label151;
      }
      this.ppH.clear();
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (awh)((Iterator)localObject1).next();
        paramLinkedList.add(Boolean.valueOf(this.ppH.add(localObject2)));
      }
    }
    AppMethodBeat.o(247788);
    return;
    label151:
    AppMethodBeat.o(247788);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247787);
    int i = this.ppH.size();
    AppMethodBeat.o(247787);
    return i;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    ImageView keC;
    TextView qbF;
    
    public b()
    {
      super();
      AppMethodBeat.i(247785);
      this.keC = ((ImageView)localObject.findViewById(2131297119));
      this.qbF = ((TextView)localObject.findViewById(2131305436));
      AppMethodBeat.o(247785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.f
 * JD-Core Version:    0.7.0.1
 */