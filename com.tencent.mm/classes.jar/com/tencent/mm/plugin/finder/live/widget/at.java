package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.cj;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "globalLayoutCallbackCount", "", "globalLayoutCallbackFrequency", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "plugin-finder_release"})
public final class at
{
  final String TAG;
  final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  int zma;
  final int zmb;
  
  public at(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(271864);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveVisitorShoppingEntranceWidget";
    paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
    this.zmb = ((Number)com.tencent.c.a.a.a.a.a.imO().aSr()).intValue();
    this.kiF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268980);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ((j)this.zsz.xYq.business(j.class)).ziK;
        localObject = new Bundle();
        if ((paramAnonymousView instanceof f)) {
          ((Bundle)localObject).putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((f)paramAnonymousView).zaO);
        }
        for (;;)
        {
          this.zsz.kCL.statusChange(b.c.kAl, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268980);
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
        AppMethodBeat.i(289825);
        if (this.zsz.xYq.isFinished())
        {
          this.zsz.kiF.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
          Log.i(this.zsz.TAG, "watchShoppingEntrancePosition removeOnGlobalLayoutListener:".concat(String.valueOf(this)));
          AppMethodBeat.o(289825);
          return;
        }
        Object localObject = this.zsz;
        int i = ((at)localObject).zma;
        ((at)localObject).zma = (i + 1);
        if (i >= 2147483647) {
          this.zsz.zma = 0;
        }
        if (this.zsz.zma % this.zsz.zmb == 0)
        {
          localObject = (cj)this.zsz.xYq.getPlugin(cj.class);
          if (localObject != null)
          {
            ((cj)localObject).dCz();
            AppMethodBeat.o(289825);
            return;
          }
        }
        AppMethodBeat.o(289825);
      }
    });
    Log.i(this.TAG, "init globalLayoutCallbackFrequency:" + this.zmb);
    AppMethodBeat.o(271864);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(271863);
    if (this.kiF.getVisibility() == 0)
    {
      AppMethodBeat.o(271863);
      return true;
    }
    AppMethodBeat.o(271863);
    return false;
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(271862);
    Object localObject = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(271862);
      return;
    }
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) && (paramInt == 0))
    {
      localObject = d.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((an)localObject).aj((View)this.kiF, paramInt);
        AppMethodBeat.o(271862);
        return;
      }
      AppMethodBeat.o(271862);
      return;
    }
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(271862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.at
 * JD-Core Version:    0.7.0.1
 */