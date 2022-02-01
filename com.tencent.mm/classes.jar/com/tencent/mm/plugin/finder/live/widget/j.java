package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "firstShow", "", "luckyMoneyGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "luckyMoneyIcon", "Landroid/widget/ImageView;", "luckyMoneyTip", "Landroid/widget/TextView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "lotteryVisible", "isVisible", "setClickListener", "listener", "Landroid/view/View$OnClickListener;", "setVisible", "visible", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public boolean ElK;
  public final View ElZ;
  private final TextView Ema;
  private final ImageView Emb;
  private final String TAG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public j(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361049);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchorLuckyMoneyEntranceWidget";
    this.ElZ = this.mJe.findViewById(p.e.BFY);
    this.Ema = ((TextView)this.mJe.findViewById(p.e.BFZ));
    this.Emb = ((ImageView)this.mJe.findViewById(p.e.BFX));
    this.ElK = true;
    this.Emb.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.icon_finder_post_lucky_money), -1));
    AppMethodBeat.o(361049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.j
 * JD-Core Version:    0.7.0.1
 */