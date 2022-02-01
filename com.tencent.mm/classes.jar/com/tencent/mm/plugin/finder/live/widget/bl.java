package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.bv;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.ck;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorVrEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "onClick", "view", "Landroid/view/View;", "setVisible", "visible", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bl
  implements View.OnClickListener
{
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public bl(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361281);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.mJe.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(361281);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361297);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorVrEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.Ccd;
      if (paramView != null) {
        break label77;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorVrEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361297);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label77:
      if (paramView.intValue() == i)
      {
        k.Doi.axw(String.valueOf(q.ck.DFK.action));
        paramView = (bv)this.CwG.getPlugin(bv.class);
        if (paramView != null) {
          paramView.erI();
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361285);
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(361285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bl
 * JD-Core Version:    0.7.0.1
 */