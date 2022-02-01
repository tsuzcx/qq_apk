package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.axg;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  final com.tencent.mm.live.c.b hOp;
  public final ViewGroup hwr;
  public final d uFw;
  
  public c(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248030);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveAnchorShoppingEntranceWidget";
    this.hwr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new Bundle();
        localObject = this.uFE.uFw.getLiveData();
        if (localObject != null)
        {
          localObject = ((g)localObject).uEm;
          if (localObject == null) {}
        }
        for (long l = ((axg)localObject).uko;; l = 0L)
        {
          paramAnonymousView.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", l);
          this.uFE.hOp.statusChange(b.c.hMZ, paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248028);
          return;
        }
      }
    });
    AppMethodBeat.o(248030);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(248029);
    if ((!this.uFw.getLiveData().isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = o.ujN;
      localObject = o.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((s)localObject).ag((View)this.hwr, paramInt);
        AppMethodBeat.o(248029);
        return;
      }
      AppMethodBeat.o(248029);
      return;
    }
    this.hwr.setVisibility(paramInt);
    AppMethodBeat.o(248029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.c
 * JD-Core Version:    0.7.0.1
 */