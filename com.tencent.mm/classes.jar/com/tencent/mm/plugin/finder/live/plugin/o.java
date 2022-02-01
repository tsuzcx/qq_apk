package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLikePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "likeCntTv", "Landroid/widget/TextView;", "likeIcon", "Landroid/widget/ImageView;", "canClearScreen", "", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLikeCnt", "likeCnt", "", "plugin-finder_release"})
public final class o
  extends d
{
  private final com.tencent.mm.live.c.b kCL;
  private final ImageView vsK;
  private final TextView yml;
  
  public o(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(242211);
    this.kCL = paramb;
    paramb = paramViewGroup.findViewById(b.f.finder_live_anchor_like_indicator_icon);
    p.j(paramb, "root.findViewById(R.id.f…chor_like_indicator_icon)");
    this.vsK = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(b.f.finder_live_anchor_like_indicator_tv);
    p.j(paramViewGroup, "root.findViewById(R.id.f…anchor_like_indicator_tv)");
    this.yml = ((TextView)paramViewGroup);
    AppMethodBeat.o(242211);
  }
  
  public final void Lp(final long paramLong)
  {
    AppMethodBeat.i(242206);
    com.tencent.mm.ae.d.uiThread((a)new a(this, paramLong));
    AppMethodBeat.o(242206);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(242208);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (p.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(242208);
      return;
      if ((paramBundle == null) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_LIKE_ENABLE", true)))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfg = true;
        tU(0);
        AppMethodBeat.o(242208);
        return;
      }
      tU(8);
      AppMethodBeat.o(242208);
      return;
      if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zff) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 512)))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfg = true;
        tU(0);
        AppMethodBeat.o(242208);
        return;
      }
      tU(8);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(o paramo, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.o
 * JD-Core Version:    0.7.0.1
 */