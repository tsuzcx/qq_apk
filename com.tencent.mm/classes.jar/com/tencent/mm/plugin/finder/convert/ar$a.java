package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ar$a
  implements View.OnClickListener
{
  public static final a tEv;
  
  static
  {
    AppMethodBeat.i(243147);
    tEv = new a();
    AppMethodBeat.o(243147);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(243146);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    localObject1 = h.veu;
    h.dnS();
    localObject1 = new Intent();
    Object localObject2 = FinderReporterUIC.wzC;
    p.g(paramView, "it");
    localObject2 = paramView.getContext();
    p.g(localObject2, "it.context");
    FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, true, 60);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243146);
      throw paramView;
    }
    com.tencent.mm.plugin.finder.utils.a.b((MMActivity)paramView, (Intent)localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLbsBarEntranceConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(243146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ar.a
 * JD-Core Version:    0.7.0.1
 */