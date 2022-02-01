package com.tencent.mm.plugin.finder.nearby.person;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class NearbyPersonV1UIC$d
  implements View.OnClickListener
{
  NearbyPersonV1UIC$d(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249279);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = NearbyPersonV1UIC.p(this.uSA);
    if (paramView == null) {
      p.hyc();
    }
    paramView.removeHeaderView(NearbyPersonV1UIC.q(this.uSA));
    NearbyPersonV1UIC.r(this.uSA);
    paramView = new Intent((Context)this.uSA.getActivity(), NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.uSA.getActivity().startActivityForResult(paramView, 2009);
    paramView = i.tLi;
    paramView = com.tencent.mm.ui.component.a.PRN;
    i.a.c(2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(this.uSA.getActivity()).get(FinderReporterUIC.class)).dIx());
    paramView = g.ah(aj.class);
    p.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
    ((aj)paramView).getRedDotManager().asV("NearbyPeopleBubble");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$getSayHiLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.d
 * JD-Core Version:    0.7.0.1
 */