package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.q;
import com.tencent.mm.plugin.finder.live.plugin.q.b;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.af;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView;
import com.tencent.mm.plugin.finder.live.view.adapter.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkListPlugin;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionInfo;", "Lkotlin/collections/ArrayList;", "getRoot", "()Landroid/widget/RelativeLayout;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "hidePanel", "", "isVisible", "", "onClick", "v", "prepareData", "prepareViews", "showPanel", "MicConditionAdapter", "MicConditionInfo", "MicConditionViewHolder", "plugin-finder_release"})
public final class ab
  implements View.OnClickListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final View kFA;
  final ArrayList<b> mXB;
  public final RelativeLayout wPB;
  private final RecyclerView xQw;
  final q zoA;
  public final a zpL;
  
  public ab(RelativeLayout paramRelativeLayout, com.tencent.mm.live.c.b paramb, q paramq)
  {
    AppMethodBeat.i(279323);
    this.wPB = paramRelativeLayout;
    this.kCL = paramb;
    this.zoA = paramq;
    this.TAG = "FinderLiveMicConditionWidget";
    this.kFA = this.wPB.findViewById(b.f.finder_live_mic_condition_ui_header_close_btn);
    this.xQw = ((RecyclerView)this.wPB.findViewById(b.f.finder_live_mic_condition_ui_content));
    this.zpL = new a();
    this.mXB = new ArrayList();
    this.wPB.setTranslationY(ax.au(this.wPB.getContext()).y);
    paramRelativeLayout = this.xQw;
    p.j(paramRelativeLayout, "contentView");
    paramRelativeLayout.setAdapter((RecyclerView.a)this.zpL);
    paramRelativeLayout = this.xQw;
    p.j(paramRelativeLayout, "contentView");
    this.wPB.getContext();
    paramRelativeLayout.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    dIy();
    this.kFA.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(279323);
  }
  
  public final void dIy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(279319);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject1 = ((f)this.zoA.business(f.class)).zhx;
    boolean bool1;
    label91:
    boolean bool2;
    label137:
    boolean bool3;
    label183:
    boolean bool4;
    label230:
    boolean bool5;
    boolean bool6;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((cxh)localObject1).TFQ);
      bool1 = com.tencent.mm.plugin.finder.live.utils.a.LJ(((Long)localObject1).longValue());
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = ((f)this.zoA.business(f.class)).zhx;
      if (localObject1 == null) {
        break label737;
      }
      localObject1 = Long.valueOf(((cxh)localObject1).TFQ);
      bool2 = com.tencent.mm.plugin.finder.live.utils.a.LK(((Long)localObject1).longValue());
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = ((f)this.zoA.business(f.class)).zhx;
      if (localObject1 == null) {
        break label743;
      }
      localObject1 = Long.valueOf(((cxh)localObject1).TFQ);
      bool3 = com.tencent.mm.plugin.finder.live.utils.a.LL(((Long)localObject1).longValue());
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = ((f)this.zoA.business(f.class)).zhx;
      if (localObject1 == null) {
        break label749;
      }
      localObject1 = Long.valueOf(((cxh)localObject1).TFP);
      bool4 = com.tencent.mm.plugin.finder.live.utils.a.Ly(((Long)localObject1).longValue());
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = ((f)this.zoA.business(f.class)).zhx;
      if (localObject1 == null) {
        break label755;
      }
      localObject1 = Long.valueOf(((cxh)localObject1).TFP);
      bool5 = com.tencent.mm.plugin.finder.live.utils.a.Lz(((Long)localObject1).longValue());
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      cxh localcxh = ((f)this.zoA.business(f.class)).zhx;
      localObject1 = localObject2;
      if (localcxh != null) {
        localObject1 = Long.valueOf(localcxh.TFP);
      }
      bool6 = com.tencent.mm.plugin.finder.live.utils.a.LA(((Long)localObject1).longValue());
      if (!bool4) {
        break label761;
      }
      localObject1 = this.wPB.getContext();
      p.j(localObject1, "root.context");
      localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_condition_follow);
    }
    for (;;)
    {
      p.j(localObject1, "when {\n            follo…)\n            }\n        }");
      Log.i(this.TAG, "prepareData followSwitchEnable:" + bool1 + " rewardSwitchEnable:" + bool2 + " buyProductSwitchEnable:" + bool3 + "followEnable:" + bool4 + " rewardEnable:" + bool5 + " buyProductEnable:" + bool6);
      this.mXB.clear();
      localObject2 = this.wPB.getContext();
      p.j(localObject2, "root.context");
      localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_mic_condition_all);
      p.j(localObject2, "root.context.resources.g…r_live_mic_condition_all)");
      localObject2 = new b((String)localObject2, (byte)0);
      ((b)localObject2).bBh = p.h(((b)localObject2).title, localObject1);
      this.mXB.add(localObject2);
      if (bool2)
      {
        localObject2 = this.wPB.getContext();
        p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_mic_condition_reward);
        p.j(localObject2, "root.context.resources.g…ive_mic_condition_reward)");
        localObject2 = new b((String)localObject2, (byte)0);
        ((b)localObject2).bBh = p.h(((b)localObject2).title, localObject1);
        this.mXB.add(localObject2);
      }
      if (bool1)
      {
        localObject2 = this.wPB.getContext();
        p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_mic_condition_follow);
        p.j(localObject2, "root.context.resources.g…ive_mic_condition_follow)");
        localObject2 = new b((String)localObject2, (byte)0);
        ((b)localObject2).bBh = p.h(((b)localObject2).title, localObject1);
        this.mXB.add(localObject2);
      }
      if (bool3)
      {
        localObject2 = this.wPB.getContext();
        p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_mic_condition_buy_product);
        p.j(localObject2, "root.context.resources.g…ic_condition_buy_product)");
        localObject2 = new b((String)localObject2, (byte)0);
        ((b)localObject2).bBh = p.h(((b)localObject2).title, localObject1);
        this.mXB.add(localObject2);
      }
      AppMethodBeat.o(279319);
      return;
      localObject1 = null;
      break;
      label737:
      localObject1 = null;
      break label91;
      label743:
      localObject1 = null;
      break label137;
      label749:
      localObject1 = null;
      break label183;
      label755:
      localObject1 = null;
      break label230;
      label761:
      if (bool5)
      {
        localObject1 = this.wPB.getContext();
        p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_condition_reward);
      }
      else if (bool6)
      {
        localObject1 = this.wPB.getContext();
        p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_condition_buy_product);
      }
      else
      {
        localObject1 = this.wPB.getContext();
        p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_mic_condition_all);
      }
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(279321);
    if (this.wPB.getVisibility() == 0)
    {
      AppMethodBeat.o(279321);
      return true;
    }
    AppMethodBeat.o(279321);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(279322);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_mic_condition_ui_header_close_btn;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279322);
      return;
      paramView = null;
      break;
      label87:
      if (paramView.intValue() == i) {
        this.zoA.dAB();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<ab.c>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(279433);
      int i = ab.a(this.zpM).size();
      AppMethodBeat.o(279433);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ab.a parama, ab.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(285464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = ((Iterable)this.zpN.zpM.mXB).iterator();
        while (paramView.hasNext()) {
          ((ab.b)paramView.next()).bBh = false;
        }
        this.zpO.bBh = true;
        paramView = this.zpN.zpM.zoA;
        localObject = this.zpO;
        p.k(localObject, "micConditionInfo");
        localObject = ((ab.b)localObject).title;
        Context localContext = paramView.kiF.getContext();
        p.j(localContext, "root.context");
        long l;
        if (p.h(localObject, localContext.getResources().getString(b.j.finder_live_mic_condition_reward)))
        {
          localObject = k.yBj;
          k.a(s.c.yEy, String.valueOf(s.af.yIo.action));
          localObject = e.h.kkq;
          l = e.h.aKu() | 0x0;
        }
        for (;;)
        {
          localObject = ((Iterable)paramView.ymu.mcZ).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((FinderLiveApplyLinkView)((Iterator)localObject).next()).LN(l);
          }
          localContext = paramView.kiF.getContext();
          p.j(localContext, "root.context");
          if (p.h(localObject, localContext.getResources().getString(b.j.finder_live_mic_condition_follow)))
          {
            localObject = k.yBj;
            k.a(s.c.yEy, String.valueOf(s.af.yIp.action));
            localObject = e.h.kkq;
            l = e.h.aKv() | 0x0;
          }
          else
          {
            localContext = paramView.kiF.getContext();
            p.j(localContext, "root.context");
            if (p.h(localObject, localContext.getResources().getString(b.j.finder_live_mic_condition_buy_product)))
            {
              localObject = k.yBj;
              k.a(s.c.yEy, String.valueOf(s.af.yIq.action));
              localObject = e.h.kkq;
              l = e.h.aKw() | 0x0;
            }
            else
            {
              localObject = k.yBj;
              k.a(s.c.yEy, String.valueOf(s.af.yIn.action));
              l = 0L;
            }
          }
        }
        localObject = q.getFinderLiveAssistant();
        if (localObject != null) {
          ((an)localObject).a(((c)paramView.business(c.class)).liveInfo.liveId, ((c)paramView.business(c.class)).xbk, l, (d.a)new q.b(paramView));
        }
        paramView.dAB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285464);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionInfo;", "", "title", "", "checked", "", "(Ljava/lang/String;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    boolean bBh;
    public String title;
    
    private b(String paramString)
    {
      AppMethodBeat.i(269121);
      this.title = paramString;
      this.bBh = false;
      AppMethodBeat.o(269121);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(269124);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.title, paramObject.title)) || (this.bBh != paramObject.bBh)) {}
        }
      }
      else
      {
        AppMethodBeat.o(269124);
        return true;
      }
      AppMethodBeat.o(269124);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(269122);
      String str = "MicConditionInfo(title=" + this.title + ", checked=" + this.bBh + ")";
      AppMethodBeat.o(269122);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$MicConditionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget;Landroid/view/View;)V", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    final TextView jMg;
    final WeImageView znz;
    
    public c()
    {
      super();
      AppMethodBeat.i(290310);
      this.jMg = ((TextView)localObject.findViewById(b.f.finder_live_mic_condition_title_tv));
      this.znz = ((WeImageView)localObject.findViewById(b.f.finder_live_mic_condition_title_icon));
      AppMethodBeat.o(290310);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveMicConditionWidget$hidePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(288450);
      this.zpM.wPB.setVisibility(8);
      AppMethodBeat.o(288450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ab
 * JD-Core Version:    0.7.0.1
 */