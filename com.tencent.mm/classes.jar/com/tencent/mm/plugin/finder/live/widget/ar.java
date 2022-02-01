package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "luckyMoneyGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "onClick", "", "v", "setVisible", "visibility", "", "plugin-finder_release"})
public final class ar
  implements View.OnClickListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final ViewGroup kiF;
  private final d xYq;
  private final View zlD;
  
  public ar(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(291718);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveVisitorLuckyMoneyEntranceWidget";
    this.zlD = this.kiF.findViewById(b.f.lucky_money_entrance_container);
    this.zlD.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(291718);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(291717);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.lucky_money_entrance_container;
      if (paramView != null) {
        break label77;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291717);
      return;
      paramView = null;
      break;
      label77:
      if (paramView.intValue() == i)
      {
        paramView = h.aHG();
        p.j(paramView, "MMKernel.storage()");
        paramView = paramView.aHp().get(ar.a.VlG, Integer.valueOf(0));
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(291717);
          throw paramView;
        }
        i = ((Integer)paramView).intValue();
        if ((i == 0) || (i == 1))
        {
          if ((this.kiF.getContext() instanceof Activity))
          {
            paramView = d.getFinderLiveAssistant();
            if (paramView != null)
            {
              localObject = this.kiF.getContext();
              if (localObject == null)
              {
                paramView = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(291717);
                throw paramView;
              }
              paramView.ap((Activity)localObject);
            }
          }
        }
        else
        {
          paramView = this.kiF.getContext();
          localObject = this.kiF.getContext();
          p.j(localObject, "root.context");
          w.makeText(paramView, (CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_lucky_money_err_tip_not_mainland), 0).show();
        }
      }
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(291716);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(291716);
      return;
    }
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(291716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ar
 * JD-Core Version:    0.7.0.1
 */