package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "globalLayoutCallbackCount", "", "globalLayoutCallbackFrequency", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "plugin-finder_release"})
public final class j
{
  final String TAG;
  final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  int zma;
  final int zmb;
  
  public j(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(278476);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "FinderLiveAnchorShoppingEntranceWidget";
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    this.zmb = ((Number)com.tencent.c.a.a.a.a.a.imO().aSr()).intValue();
    this.kiF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271335);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.zmc.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK;
        localObject = new Bundle();
        if ((paramAnonymousView instanceof f)) {
          ((Bundle)localObject).putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((f)paramAnonymousView).zaO);
        }
        for (;;)
        {
          ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_SHOPPING_SOURCE_CLICK", true);
          this.zmc.kCL.statusChange(b.c.kAl, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271335);
          return;
          if ((paramAnonymousView instanceof e)) {
            ((Bundle)localObject).putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((e)paramAnonymousView).zaI);
          }
        }
      }
    });
    this.kiF.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(267270);
        if (this.zmc.xYq.isFinished())
        {
          this.zmc.kiF.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
          Log.i(this.zmc.TAG, "watchShoppingEntrancePosition removeOnGlobalLayoutListener:".concat(String.valueOf(this)));
          AppMethodBeat.o(267270);
          return;
        }
        Object localObject = this.zmc;
        int i = ((j)localObject).zma;
        ((j)localObject).zma = (i + 1);
        if (i >= 2147483647) {
          this.zmc.zma = 0;
        }
        if (this.zmc.zma % this.zmc.zmb == 0)
        {
          localObject = (cj)this.zmc.xYq.getPlugin(cj.class);
          if (localObject != null)
          {
            ((cj)localObject).dCz();
            AppMethodBeat.o(267270);
            return;
          }
        }
        AppMethodBeat.o(267270);
      }
    });
    AppMethodBeat.o(278476);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(278475);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) && (paramInt == 0))
    {
      an localan = d.getFinderLiveAssistant();
      if (localan != null)
      {
        localan.aj((View)this.kiF, paramInt);
        AppMethodBeat.o(278475);
        return;
      }
      AppMethodBeat.o(278475);
      return;
    }
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(278475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.j
 * JD-Core Version:    0.7.0.1
 */