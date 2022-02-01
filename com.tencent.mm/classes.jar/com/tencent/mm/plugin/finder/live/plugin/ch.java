package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "canClearScreen", "", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class ch
  extends d
{
  private static final double ywU = 0.463D;
  private static final double ywV = 0.232D;
  public static final a ywW;
  private final String TAG;
  private final b kCU;
  private final View kGR;
  private final View kGS;
  
  static
  {
    AppMethodBeat.i(277451);
    ywW = new a((byte)0);
    ywU = 0.463D;
    ywV = 0.232D;
    AppMethodBeat.o(277451);
  }
  
  public ch(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(277450);
    this.kCU = paramb;
    this.TAG = "FinderLiveShadowPlugin";
    this.kGR = paramViewGroup.findViewById(b.e.live_shadow_down);
    this.kGS = paramViewGroup.findViewById(b.e.live_shadow_up);
    if (!isLandscape())
    {
      paramb = this.kGR;
      p.j(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += ax.aB(paramViewGroup.getContext());
      AppMethodBeat.o(277450);
      return;
    }
    int i = ax.au(paramViewGroup.getContext()).y;
    paramViewGroup = this.kGR;
    p.j(paramViewGroup, "shadowDown");
    paramViewGroup.getLayoutParams().height = ((int)(i * ywU));
    paramViewGroup = this.kGS;
    p.j(paramViewGroup, "shadowUp");
    paramViewGroup.getLayoutParams().height = ((int)(i * ywV));
    paramViewGroup = this.TAG;
    paramb = new StringBuilder("screenHeight:").append(i).append(",shadowDown.height:");
    View localView = this.kGR;
    p.j(localView, "shadowDown");
    paramb = paramb.append(localView.getLayoutParams().height).append(",shadowUp.height:");
    localView = this.kGS;
    p.j(localView, "shadowUp");
    Log.i(paramViewGroup, localView.getLayoutParams().height);
    AppMethodBeat.o(277450);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(277449);
    p.k(paramc, "status");
    switch (ci.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(277449);
      return;
      tU(4);
      AppMethodBeat.o(277449);
      return;
      if (this.kCU.getLiveRole() != 1)
      {
        tU(4);
        AppMethodBeat.o(277449);
        return;
        tU(0);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin$Companion;", "", "()V", "LANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "", "getLANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "()D", "LANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "getLANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ch
 * JD-Core Version:    0.7.0.1
 */