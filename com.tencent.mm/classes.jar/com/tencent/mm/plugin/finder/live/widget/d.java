package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.view.w;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "tv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkVisible", "", "getIndex", "", "value", "modeList", "", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "isVisible", "", "plugin-finder_release"})
public final class d
{
  final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  final TextView zlv;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(292188);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchorGameTeamWidget";
    this.zlv = ((TextView)this.kiF.findViewById(b.f.finder_live_game_team_tv));
    this.kiF.setVisibility(8);
    AppMethodBeat.o(292188);
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(292187);
    final azh localazh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfD;
    Object localObject1;
    int i;
    if (localazh != null)
    {
      localObject1 = localazh.SLd;
      if (localObject1 != null)
      {
        localObject1 = ((bns)localObject1).SYM;
        if (localObject1 != null)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          label127:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (((cny)localObject3).value != 1) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label127;
              }
              ((Collection)localObject1).add(localObject3);
              break;
            }
          }
          localObject1 = (List)localObject1;
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("gamteam checkVisible gameInfo.show_teamup_button:");
          if (localazh == null) {
            break label303;
          }
          localObject2 = Integer.valueOf(localazh.SLg);
          label166:
          localObject4 = ((StringBuilder)localObject4).append(localObject2).append(", modeList size:");
          if (localObject1 == null) {
            break label309;
          }
          localObject2 = Integer.valueOf(((List)localObject1).size());
          label195:
          localObject4 = ((StringBuilder)localObject4).append(localObject2).append(", last:");
          if (localazh == null) {
            break label315;
          }
        }
      }
    }
    label303:
    label309:
    label315:
    for (Object localObject2 = Integer.valueOf(localazh.SLe);; localObject2 = null)
    {
      Log.i((String)localObject3, localObject2);
      if ((localazh != null) && (localazh.SLg == 1) && (localObject1 != null) && (((List)localObject1).size() > 0) && (localazh.SLe != 1) && (localazh.SLe != 0)) {
        break label321;
      }
      this.kiF.setVisibility(8);
      AppMethodBeat.o(292187);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label166;
      localObject2 = null;
      break label195;
    }
    label321:
    this.kiF.setVisibility(0);
    Object localObject4 = this.zlv;
    kotlin.g.b.p.j(localObject4, "tv");
    localObject2 = com.tencent.mm.plugin.finder.utils.p.ADF;
    int j = localazh.SLe;
    Context localContext = this.kiF.getContext();
    kotlin.g.b.p.j(localContext, "root.context");
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (((cny)localObject2).value == localazh.SLe)
      {
        i = 1;
        label417:
        if (i == 0) {
          break label499;
        }
      }
    }
    for (;;)
    {
      localObject2 = (cny)localObject2;
      if (localObject2 != null)
      {
        localObject3 = ((cny)localObject2).tsf;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.plugin.finder.utils.p.a(j, localContext, (String)localObject2));
      this.kiF.setOnClickListener((View.OnClickListener)new a(this, localazh, (List)localObject1));
      AppMethodBeat.o(292187);
      return;
      i = 0;
      break label417;
      label499:
      break;
      localObject2 = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, azh paramazh, List paramList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285179);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget$checkVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new w((kotlin.g.a.b)new a(this));
      localObject = this.zlw.kiF.getContext().getString(b.j.finder_game_live_team_condition_title);
      kotlin.g.b.p.j(localObject, "root.context.getString(R…ive_team_condition_title)");
      List localList = this.zlx;
      int k = localazh.SLe;
      Iterator localIterator = this.zlx.iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext()) {
        if (((cny)localIterator.next()).value == k)
        {
          j = 1;
          label139:
          if (j == 0) {
            break label206;
          }
        }
      }
      for (;;)
      {
        paramView.b((String)localObject, localList, i);
        paramView.AZM = true;
        localObject = this.zlw.kiF.getContext();
        kotlin.g.b.p.j(localObject, "root.context");
        paramView.fX((Context)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget$checkVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285179);
        return;
        j = 0;
        break label139;
        label206:
        i += 1;
        break;
        i = -1;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<cny, x>
    {
      a(d.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.d
 * JD-Core Version:    0.7.0.1
 */