package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "canClearScreen", "", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bb
  extends d
{
  public static final a utA;
  private static final double uty = 0.463D;
  private static final double utz = 0.232D;
  private final String TAG;
  private final b hOy;
  private final View hSu;
  private final View hSv;
  
  static
  {
    AppMethodBeat.i(246969);
    utA = new a((byte)0);
    uty = 0.463D;
    utz = 0.232D;
    AppMethodBeat.o(246969);
  }
  
  public bb(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246968);
    this.hOy = paramb;
    this.TAG = "FinderLiveShadowPlugin";
    this.hSu = paramViewGroup.findViewById(2131303556);
    this.hSv = paramViewGroup.findViewById(2131303558);
    if (!isLandscape())
    {
      paramb = this.hSu;
      p.g(paramb, "shadowDown");
      paramb = paramb.getLayoutParams();
      paramb.height += au.aD(paramViewGroup.getContext());
      AppMethodBeat.o(246968);
      return;
    }
    int i = au.az(paramViewGroup.getContext()).y;
    paramViewGroup = this.hSu;
    p.g(paramViewGroup, "shadowDown");
    paramViewGroup.getLayoutParams().height = ((int)(i * uty));
    paramViewGroup = this.hSv;
    p.g(paramViewGroup, "shadowUp");
    paramViewGroup.getLayoutParams().height = ((int)(i * utz));
    paramViewGroup = this.TAG;
    paramb = new StringBuilder("screenHeight:").append(i).append(",shadowDown.height:");
    View localView = this.hSu;
    p.g(localView, "shadowDown");
    paramb = paramb.append(localView.getLayoutParams().height).append(",shadowUp.height:");
    localView = this.hSv;
    p.g(localView, "shadowUp");
    Log.i(paramViewGroup, localView.getLayoutParams().height);
    AppMethodBeat.o(246968);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246967);
    p.h(paramc, "status");
    switch (bc.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246967);
      return;
      rg(4);
      AppMethodBeat.o(246967);
      return;
      if (this.hOy.getLiveRole() != 1)
      {
        rg(4);
        AppMethodBeat.o(246967);
        return;
        rg(0);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin$Companion;", "", "()V", "LANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "", "getLANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "()D", "LANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "getLANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bb
 * JD-Core Version:    0.7.0.1
 */