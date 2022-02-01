package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$p
  implements View.OnClickListener
{
  FinderSelfUI$p(FinderSelfUI paramFinderSelfUI, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199384);
    int i;
    if (this.KZF > 0)
    {
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
        break label246;
      }
      i = 0;
      if (this.KZG <= 0) {
        break label256;
      }
      paramView = com.tencent.mm.plugin.finder.report.b.qFq;
      j = this.KZG;
      paramView = FinderReporterUIC.Ljl;
      paramView = FinderReporterUIC.a.lB((Context)this.qPI);
      if (paramView == null) {
        break label251;
      }
      paramView = paramView.fXs();
      com.tencent.mm.plugin.finder.report.b.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 1472);
    }
    label246:
    label251:
    while (this.KZH <= 0) {
      for (;;)
      {
        paramView = g.ad(PluginFinder.class);
        k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().YU("ProfileEntrance");
        paramView = new Intent();
        localObject = com.tencent.mm.plugin.finder.api.b.qnX;
        localObject = u.aqO();
        k.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
        localObject = b.a.YL((String)localObject);
        if (localObject == null) {
          k.fvU();
        }
        if (!((f)localObject).isBlock()) {
          break label322;
        }
        paramView.setClass((Context)this.qPI.getContext(), FinderExposeUI.class);
        localObject = this.qPI;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(199384);
        return;
        i = 2;
        break;
        paramView = null;
      }
    }
    label256:
    paramView = com.tencent.mm.plugin.finder.report.b.qFq;
    int j = this.KZH;
    paramView = FinderReporterUIC.Ljl;
    paramView = FinderReporterUIC.a.lB((Context)this.qPI);
    if (paramView != null) {}
    for (paramView = paramView.fXs();; paramView = null)
    {
      com.tencent.mm.plugin.finder.report.b.a("4", 4, 2, 5, i, j, null, null, 0L, paramView, 0, 1472);
      break;
    }
    label322:
    Object localObject = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a((Context)this.qPI, paramView, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.ak((Context)this.qPI, paramView);
    AppMethodBeat.o(199384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.p
 * JD-Core Version:    0.7.0.1
 */