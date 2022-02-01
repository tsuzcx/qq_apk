package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameGuideBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "gameWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bubbleWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "getBubbleWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameJoinGuideBubbleWidget;", "canClearScreen", "", "setVisible", "", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class ax
  extends d
{
  private static final String TAG = "Finder.FinderLiveGameGuideBubblePlugin";
  public static final a ypY;
  private final com.tencent.mm.live.c.b kCL;
  public final com.tencent.mm.plugin.finder.live.widget.p ypW;
  private final ViewGroup ypX;
  
  static
  {
    AppMethodBeat.i(279627);
    ypY = new a((byte)0);
    TAG = "Finder.FinderLiveGameGuideBubblePlugin";
    AppMethodBeat.o(279627);
  }
  
  public ax(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(279626);
    this.ypX = paramViewGroup2;
    this.kCL = paramb;
    paramViewGroup2 = paramViewGroup1.getContext();
    kotlin.g.b.p.j(paramViewGroup2, "entranceRoot.context");
    this.ypW = new com.tencent.mm.plugin.finder.live.widget.p(paramViewGroup2, paramViewGroup1, this.ypX, this.kCL, (d)this);
    AppMethodBeat.o(279626);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(279624);
    kotlin.g.b.p.k(paramc, "status");
    paramBundle = ay.$EnumSwitchMapping$0;
    paramc.ordinal();
    AppMethodBeat.o(279624);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(279625);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((an)localObject).aj((View)this.ypW, paramInt);
        AppMethodBeat.o(279625);
        return;
      }
      AppMethodBeat.o(279625);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(279625);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameGuideBubblePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ax
 * JD-Core Version:    0.7.0.1
 */