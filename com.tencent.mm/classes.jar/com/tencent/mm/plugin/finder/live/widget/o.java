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
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.aw;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "giftClickArea", "Landroid/view/View;", "giftIcon", "Landroid/widget/ImageView;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "Companion", "plugin-finder_release"})
public final class o
{
  private static boolean uHC;
  public static final a uHD;
  final com.tencent.mm.live.c.b hOp;
  private final ViewGroup hwr;
  private final d uFw;
  private final ImageView uHA;
  private final View uHB;
  
  static
  {
    AppMethodBeat.i(248161);
    uHD = new a((byte)0);
    AppMethodBeat.o(248161);
  }
  
  public o(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248160);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    paramViewGroup = this.hwr.findViewById(2131300996);
    p.g(paramViewGroup, "root.findViewById(R.id.finder_live_gift_icon)");
    this.uHA = ((ImageView)paramViewGroup);
    paramViewGroup = this.hwr.findViewById(2131300995);
    p.g(paramViewGroup, "root.findViewById(R.id.f…der_live_gift_click_area)");
    this.uHB = paramViewGroup;
    this.uHA.setImageDrawable(ar.m(this.hwr.getContext(), 2131690564, -1));
    this.uHB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248155);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.uHE.hOp, b.c.hMG);
        a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248155);
      }
    });
    this.uHB.setOnLongClickListener((View.OnLongClickListener)2.uHF);
    AppMethodBeat.o(248160);
  }
  
  public final void dju()
  {
    AppMethodBeat.i(248158);
    if ((this.uFw.getLiveData().dja()) && (this.uFw.getLiveData().isLiveStarted())) {
      this.hwr.setVisibility(0);
    }
    for (;;)
    {
      m localm = m.vli;
      m.a(s.aw.vso, "", this.hwr.getVisibility());
      AppMethodBeat.o(248158);
      return;
      this.hwr.setVisibility(8);
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(248159);
    if (this.hwr.getVisibility() == 0)
    {
      AppMethodBeat.o(248159);
      return true;
    }
    AppMethodBeat.o(248159);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget$Companion;", "", "()V", "DEBUG_FLAG", "", "getDEBUG_FLAG", "()Z", "setDEBUG_FLAG", "(Z)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.o
 * JD-Core Version:    0.7.0.1
 */