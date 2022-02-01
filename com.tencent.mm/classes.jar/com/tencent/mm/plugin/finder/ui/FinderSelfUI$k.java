package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.plugin.i.a.j;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$k
  implements View.OnClickListener
{
  FinderSelfUI$k(FinderSelfUI paramFinderSelfUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199379);
    paramView = g.ad(PluginFinder.class);
    k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
    paramView = ((PluginFinder)paramView).getRedDotManager().YV("FinderFirstFav");
    Object localObject = g.ad(PluginFinder.class);
    k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().YW("FinderFirstFav");
    i locali = i.qTa;
    if ((paramView != null) && (localObject != null))
    {
      paramView = b.qFq;
      paramView = FinderReporterUIC.Ljl;
      paramView = FinderReporterUIC.a.lB((Context)this.qPI);
      if (paramView == null) {
        break label202;
      }
    }
    label202:
    for (paramView = paramView.fXs();; paramView = null)
    {
      b.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 1472);
      paramView = g.ad(j.class);
      k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((j)paramView).getRedDotManager().YU("FinderFirstFav");
      paramView = new Intent();
      localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.qPI, paramView, 0L, 0, false, 124);
      localObject = a.qSb;
      localObject = this.qPI.getContext();
      k.g(localObject, "context");
      a.ab((Context)localObject, paramView);
      AppMethodBeat.o(199379);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.k
 * JD-Core Version:    0.7.0.1
 */