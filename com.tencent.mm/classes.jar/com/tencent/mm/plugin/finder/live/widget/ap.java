package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bk;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "giftClickArea", "Landroid/view/View;", "giftIcon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "Companion", "plugin-finder_release"})
public final class ap
{
  private static final String TAG = "Finder.FinderLiveVisitorGiftWidget";
  private static boolean zsm;
  public static final a zsn;
  final com.tencent.mm.live.c.b kCL;
  private final ViewGroup kiF;
  private final d xYq;
  private final ImageView zsk;
  private final View zsl;
  
  static
  {
    AppMethodBeat.i(288746);
    zsn = new a((byte)0);
    TAG = "Finder.FinderLiveVisitorGiftWidget";
    AppMethodBeat.o(288746);
  }
  
  public ap(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(288745);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_gift_icon);
    p.j(paramViewGroup, "root.findViewById(R.id.finder_live_gift_icon)");
    this.zsk = ((ImageView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_gift_click_area);
    p.j(paramViewGroup, "root.findViewById(R.id.f…der_live_gift_click_area)");
    this.zsl = paramViewGroup;
    this.zsk.setImageDrawable(au.o(this.kiF.getContext(), b.i.icons_filled_gift, -1));
    this.zsl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(224925);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(this.zso.kCL, b.c.kAa);
        a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(224925);
      }
    });
    this.zsl.setOnLongClickListener((View.OnLongClickListener)2.zsp);
    AppMethodBeat.o(288745);
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(288743);
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())) {
      this.kiF.setVisibility(0);
    }
    for (;;)
    {
      m localm = m.yCt;
      m.a(s.bk.yMm, "", this.kiF.getVisibility());
      AppMethodBeat.o(288743);
      return;
      this.kiF.setVisibility(8);
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(288744);
    if (this.kiF.getVisibility() == 0)
    {
      AppMethodBeat.o(288744);
      return true;
    }
    AppMethodBeat.o(288744);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$Companion;", "", "()V", "DEBUG_FLAG", "", "getDEBUG_FLAG", "()Z", "setDEBUG_FLAG", "(Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ap
 * JD-Core Version:    0.7.0.1
 */