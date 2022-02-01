package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.sport.a.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SportProfileUIC$d
  implements View.OnClickListener
{
  SportProfileUIC$d(SportProfileUIC paramSportProfileUIC) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230639);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    c.pl(8);
    paramView = new AppBrandStatObject();
    paramView.scene = 1063;
    ((r)g.af(r.class)).a((Context)this.rMU.getActivity(), null, "wx3fca79fc5715b185", 0, 0, "", paramView);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.d
 * JD-Core Version:    0.7.0.1
 */