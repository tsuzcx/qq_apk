package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$b
  implements View.OnClickListener
{
  FinderSelfUI$b(FinderSelfUI paramFinderSelfUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204741);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfUI$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    this.sRH.getIntent().putExtra("finder_username", FinderSelfUI.f(this.sRH));
    this.sRH.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
    paramView = FinderReporterUIC.tnG;
    paramView = (Context)this.sRH;
    localObject = this.sRH.getIntent();
    p.g(localObject, "intent");
    FinderReporterUIC.a.a(paramView, (Intent)localObject, 0L, 0, false, 124);
    paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.sRH, this.sRH.getIntent());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$accountAbnormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.b
 * JD-Core Version:    0.7.0.1
 */