package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.plugin.findersdk.a.ax;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSelfUIC;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveSelfUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
  implements ax
{
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356884);
    AppMethodBeat.o(356884);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(356890);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramView = new Intent();
    localObject = a.e.HbQ;
    paramView.putExtra(a.e.frp(), 1);
    localObject = com.tencent.mm.plugin.finder.order.a.ESd;
    com.tencent.mm.plugin.finder.order.a.Q((Context)paramf.getActivity(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356890);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356907);
    super.onCreate(paramBundle);
    paramBundle = d.FAy;
    if (((Number)d.eRU().bmg()).intValue() == 1)
    {
      paramBundle = findViewById(p.e.jump_finder_order_center);
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener(new f..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(356907);
      }
    }
    else
    {
      paramBundle = findViewById(p.e.jump_finder_order_center);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    AppMethodBeat.o(356907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.f
 * JD-Core Version:    0.7.0.1
 */