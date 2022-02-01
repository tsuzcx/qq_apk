package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/IFinderLiveShoppingEntranceWidget;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "firstShow", "", "globalLayoutCallbackCount", "", "globalLayoutCallbackFrequency", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "setVisible", "visible", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements bn
{
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private boolean ElK;
  int Emw;
  final int Emx;
  final String TAG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public o(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(362162);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "FinderLiveAnchorShoppingEntranceWidget";
    this.Emx = 3;
    this.ElK = true;
    this.mJe.setOnClickListener(new o..ExternalSyntheticLambda0(this));
    this.mJe.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(361230);
        if (this.Emy.CwG.isFinished())
        {
          this.Emy.mJe.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
          Log.i(this.Emy.TAG, s.X("watchShoppingEntrancePosition removeOnGlobalLayoutListener:", this));
          AppMethodBeat.o(361230);
          return;
        }
        Object localObject = this.Emy;
        int i = ((o)localObject).Emw;
        ((o)localObject).Emw = (i + 1);
        if (i >= 2147483647) {
          this.Emy.Emw = 0;
        }
        if (this.Emy.Emw % this.Emy.Emx == 0)
        {
          localObject = (by)this.Emy.CwG.getPlugin(by.class);
          if (localObject != null) {
            ((by)localObject).erX();
          }
        }
        AppMethodBeat.o(361230);
      }
    });
    AppMethodBeat.o(362162);
  }
  
  private static final void a(o paramo, View paramView)
  {
    AppMethodBeat.i(362171);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramo);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramo, "this$0");
    localObject1 = ((q)paramo.CwG.business(q.class)).Eie;
    paramView = new Bundle();
    if ((localObject1 instanceof k)) {
      paramView.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((k)localObject1).DVk);
    }
    for (;;)
    {
      paramView.putBoolean("PARAM_FINDER_LIVE_SHOPPING_SOURCE_CLICK", true);
      localObject1 = j.Dob;
      localObject2 = q.s.DuQ;
      j localj = j.Dob;
      ((j)localObject1).a((q.s)localObject2, j.a(q.r.Duf));
      paramo.nfT.statusChange(b.c.ndB, paramView);
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362171);
      return;
      if ((localObject1 instanceof i)) {
        paramView.putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((i)localObject1).DUP);
      }
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(362185);
    if (((q)this.CwG.business(q.class)).CEZ)
    {
      if ((this.mJe.getVisibility() != 0) || (this.ElK))
      {
        this.ElK = false;
        j localj1 = j.Dob;
        q.t localt = q.t.Dwc;
        j localj2 = j.Dob;
        localj1.a(localt, j.a(q.r.Duf));
      }
      tO(0);
      AppMethodBeat.o(362185);
      return;
    }
    tO(8);
    AppMethodBeat.o(362185);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(362199);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(362199);
      return true;
    }
    AppMethodBeat.o(362199);
    return false;
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(362190);
    if ((!((e)this.CwG.business(e.class)).isLiveStarted()) && (paramInt == 0))
    {
      ap localap = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (localap != null)
      {
        localap.at((View)this.mJe, paramInt);
        AppMethodBeat.o(362190);
      }
    }
    else
    {
      this.mJe.setVisibility(paramInt);
    }
    AppMethodBeat.o(362190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.o
 * JD-Core Version:    0.7.0.1
 */