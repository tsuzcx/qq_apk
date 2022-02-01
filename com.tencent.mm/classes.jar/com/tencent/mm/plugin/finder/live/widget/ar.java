package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.p;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionInfo;", "Lkotlin/collections/ArrayList;", "getRoot", "()Landroid/widget/RelativeLayout;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "hidePanel", "", "isVisible", "", "onClick", "v", "prepareData", "prepareViews", "showPanel", "MicConditionAdapter", "MicConditionInfo", "MicConditionViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  implements View.OnClickListener
{
  public final RelativeLayout Amd;
  private final RecyclerView BpW;
  final p EqT;
  public final a Esv;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final View niB;
  private final ArrayList<ar.b> pUj;
  
  public ar(RelativeLayout paramRelativeLayout, com.tencent.mm.live.b.b paramb, p paramp)
  {
    AppMethodBeat.i(361527);
    this.Amd = paramRelativeLayout;
    this.nfT = paramb;
    this.EqT = paramp;
    this.TAG = "FinderLiveMicConditionWidget";
    this.niB = this.Amd.findViewById(p.e.BOv);
    this.BpW = ((RecyclerView)this.Amd.findViewById(p.e.BOu));
    this.Esv = new a();
    this.pUj = new ArrayList();
    this.Amd.setTranslationY(bf.bf(this.Amd.getContext()).y);
    this.BpW.setAdapter((RecyclerView.a)this.Esv);
    paramRelativeLayout = this.BpW;
    this.Amd.getContext();
    paramRelativeLayout.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    eBg();
    this.niB.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(361527);
  }
  
  public final void eBg()
  {
    long l2 = 0L;
    AppMethodBeat.i(361551);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject1 = ((j)this.EqT.business(j.class)).Cvf;
    long l1;
    boolean bool1;
    label71:
    boolean bool2;
    label106:
    boolean bool3;
    label141:
    boolean bool4;
    label176:
    boolean bool5;
    label211:
    boolean bool6;
    if (localObject1 == null)
    {
      l1 = 0L;
      bool1 = com.tencent.mm.plugin.finder.live.utils.a.oR(l1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)this.EqT.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label615;
      }
      l1 = 0L;
      bool2 = com.tencent.mm.plugin.finder.live.utils.a.oS(l1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)this.EqT.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label624;
      }
      l1 = 0L;
      bool3 = com.tencent.mm.plugin.finder.live.utils.a.oT(l1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)this.EqT.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label633;
      }
      l1 = 0L;
      bool4 = com.tencent.mm.plugin.finder.live.utils.a.oG(l1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)this.EqT.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label642;
      }
      l1 = 0L;
      bool5 = com.tencent.mm.plugin.finder.live.utils.a.oH(l1);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((j)this.EqT.business(j.class)).Cvf;
      if (localObject1 != null) {
        break label651;
      }
      l1 = l2;
      bool6 = com.tencent.mm.plugin.finder.live.utils.a.oI(l1);
      if (!bool4) {
        break label660;
      }
      localObject1 = this.Amd.getContext().getResources().getString(p.h.CnE);
    }
    for (;;)
    {
      s.s(localObject1, "when {\n            follo…)\n            }\n        }");
      Log.i(this.TAG, "prepareData followSwitchEnable:" + bool1 + " rewardSwitchEnable:" + bool2 + " buyProductSwitchEnable:" + bool3 + "followEnable:" + bool4 + " rewardEnable:" + bool5 + " buyProductEnable:" + bool6);
      this.pUj.clear();
      Object localObject2 = this.Amd.getContext().getResources().getString(p.h.CnB);
      s.s(localObject2, "root.context.resources.g…r_live_mic_condition_all)");
      localObject2 = new ar.b((String)localObject2, (byte)0);
      ((ar.b)localObject2).duj = s.p(((ar.b)localObject2).title, localObject1);
      this.pUj.add(localObject2);
      if (bool2)
      {
        localObject2 = this.Amd.getContext().getResources().getString(p.h.CnG);
        s.s(localObject2, "root.context.resources.g…ive_mic_condition_reward)");
        localObject2 = new ar.b((String)localObject2, (byte)0);
        ((ar.b)localObject2).duj = s.p(((ar.b)localObject2).title, localObject1);
        this.pUj.add(localObject2);
      }
      if (bool1)
      {
        localObject2 = this.Amd.getContext().getResources().getString(p.h.CnE);
        s.s(localObject2, "root.context.resources.g…ive_mic_condition_follow)");
        localObject2 = new ar.b((String)localObject2, (byte)0);
        ((ar.b)localObject2).duj = s.p(((ar.b)localObject2).title, localObject1);
        this.pUj.add(localObject2);
      }
      if (bool3)
      {
        localObject2 = this.Amd.getContext().getResources().getString(p.h.CnC);
        s.s(localObject2, "root.context.resources.g…ic_condition_buy_product)");
        localObject2 = new ar.b((String)localObject2, (byte)0);
        ((ar.b)localObject2).duj = s.p(((ar.b)localObject2).title, localObject1);
        this.pUj.add(localObject2);
      }
      AppMethodBeat.o(361551);
      return;
      l1 = ((dom)localObject1).aaVw;
      break;
      label615:
      l1 = ((dom)localObject1).aaVw;
      break label71;
      label624:
      l1 = ((dom)localObject1).aaVw;
      break label106;
      label633:
      l1 = ((dom)localObject1).CJK;
      break label141;
      label642:
      l1 = ((dom)localObject1).CJK;
      break label176;
      label651:
      l1 = ((dom)localObject1).CJK;
      break label211;
      label660:
      if (bool5) {
        localObject1 = this.Amd.getContext().getResources().getString(p.h.CnG);
      } else if (bool6) {
        localObject1 = this.Amd.getContext().getResources().getString(p.h.CnC);
      } else {
        localObject1 = this.Amd.getContext().getResources().getString(p.h.CnB);
      }
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(361558);
    if (this.Amd.getVisibility() == 0)
    {
      AppMethodBeat.o(361558);
      return true;
    }
    AppMethodBeat.o(361558);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361565);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BOv;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361565);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i) {
        this.EqT.epd();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<ar.c>
  {
    public a()
    {
      AppMethodBeat.i(361844);
      AppMethodBeat.o(361844);
    }
    
    private static final void a(ar paramar, ar.b paramb, View paramView)
    {
      AppMethodBeat.i(361858);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramar);
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramar, "this$0");
      s.u(paramb, "$micInfo");
      paramView = ((Iterable)ar.a(paramar)).iterator();
      while (paramView.hasNext()) {
        ((ar.b)paramView.next()).duj = false;
      }
      paramb.duj = true;
      paramar.EqT.a(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361858);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(361870);
      int i = ar.a(this.Esw).size();
      AppMethodBeat.o(361870);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;Landroid/view/View;)V", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    final WeImageView EoD;
    final TextView mll;
    
    public c()
    {
      super();
      AppMethodBeat.i(361894);
      this.mll = ((TextView)localObject.findViewById(p.e.BOt));
      this.EoD = ((WeImageView)localObject.findViewById(p.e.BOs));
      AppMethodBeat.o(361894);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$hidePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    public d(ar paramar) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361888);
      this.Esw.Amd.setVisibility(8);
      AppMethodBeat.o(361888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ar
 * JD-Core Version:    0.7.0.1
 */