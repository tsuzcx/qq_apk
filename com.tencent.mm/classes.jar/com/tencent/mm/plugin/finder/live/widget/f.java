package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "luckyMoneyGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "Landroid/widget/ImageView;", "luckyMoneyTip", "Landroid/widget/TextView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setClickListener", "listener", "Landroid/view/View$OnClickListener;", "setVisible", "visible", "", "plugin-finder_release"})
public final class f
{
  private final String TAG;
  private final b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  public final View zlD;
  private final TextView zlE;
  private final ImageView zlF;
  
  public f(ViewGroup paramViewGroup, b paramb, d paramd)
  {
    AppMethodBeat.i(269378);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchorLuckyMoneyEntranceWidget";
    this.zlD = this.kiF.findViewById(b.f.finder_live_anchor_lucky_money_entrance_icon_group);
    this.zlE = ((TextView)this.kiF.findViewById(b.f.finder_live_anchor_lucky_money_entrance_tip));
    this.zlF = ((ImageView)this.kiF.findViewById(b.f.finder_live_anchor_lucky_money_entrance_icon));
    paramViewGroup = this.zlF;
    paramb = this.kiF.getContext();
    p.j(paramb, "root.context");
    paramViewGroup.setImageDrawable(au.e(paramb.getResources().getDrawable(b.i.icon_finder_post_lucky_money), -1));
    AppMethodBeat.o(269378);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(269376);
    if (this.kiF.getVisibility() == 0)
    {
      AppMethodBeat.o(269376);
      return true;
    }
    AppMethodBeat.o(269376);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.f
 * JD-Core Version:    0.7.0.1
 */