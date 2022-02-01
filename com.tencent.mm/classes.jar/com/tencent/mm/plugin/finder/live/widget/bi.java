package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "onClick", "", "v", "Landroid/view/View;", "setVisible", "visibility", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
  implements View.OnClickListener
{
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final String TAG;
  private final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public bi(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361298);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveVisitorLuckyMoneyEntranceWidget";
    this.mJe.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(361298);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361316);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BNA;
      if (paramView != null) {
        break label77;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361316);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label77:
      if (paramView.intValue() == i)
      {
        ce.a.a((ce)j.Dob, q.s.DuU);
        paramView = h.baE().ban().get(at.a.acNa, Integer.valueOf(0));
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(361316);
          throw paramView;
        }
        switch (((Integer)paramView).intValue())
        {
        default: 
          aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.CmY), 0).show();
          break;
        case 0: 
        case 1: 
          if ((this.mJe.getContext() instanceof Activity))
          {
            paramView = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
            if (paramView != null)
            {
              localObject = this.mJe.getContext();
              if (localObject == null)
              {
                paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(361316);
                throw paramView;
              }
              paramView.aA((Activity)localObject);
            }
          }
          break;
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361306);
    if (((d)h.ax(d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(361306);
      return;
    }
    if ((this.mJe.getVisibility() != 0) && (paramInt == 0)) {
      ce.a.a((ce)j.Dob, q.t.Dwg);
    }
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(361306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bi
 * JD-Core Version:    0.7.0.1
 */