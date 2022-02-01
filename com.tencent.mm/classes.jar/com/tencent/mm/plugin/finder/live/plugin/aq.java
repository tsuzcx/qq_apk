package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.ae;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameGuideBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "gameWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bubbleWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "getBubbleWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "canClearScreen", "", "setVisible", "", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  extends b
{
  public static final aq.a CZm;
  private static final String TAG;
  private final ViewGroup CZn;
  public final ae CZo;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354763);
    CZm = new aq.a((byte)0);
    TAG = "Finder.FinderLiveGameGuideBubblePlugin";
    AppMethodBeat.o(354763);
  }
  
  public aq(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(354754);
    this.CZn = paramViewGroup2;
    this.nfT = paramb;
    paramViewGroup2 = paramViewGroup1.getContext();
    s.s(paramViewGroup2, "entranceRoot.context");
    this.CZo = new ae(paramViewGroup2, paramViewGroup1, this.CZn, this.nfT, (b)this);
    AppMethodBeat.o(354754);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354781);
    s.u(paramc, "status");
    AppMethodBeat.o(354781);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354792);
    if ((!((e)business(e.class)).isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((ap)localObject).at((View)this.CZo, paramInt);
        AppMethodBeat.o(354792);
      }
    }
    else
    {
      super.tO(paramInt);
    }
    AppMethodBeat.o(354792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq
 * JD-Core Version:    0.7.0.1
 */