package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderSelfUI$o
  implements View.OnClickListener
{
  FinderSelfUI$o(FinderSelfUI paramFinderSelfUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199383);
    paramView = new Intent();
    Object localObject = b.qnX;
    localObject = u.aqO();
    k.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = b.a.YL((String)localObject);
    if (localObject == null) {
      k.fvU();
    }
    if (((f)localObject).isBlock())
    {
      paramView.setClass((Context)this.qPI.getContext(), FinderExposeUI.class);
      localObject = this.qPI;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((FinderSelfUI)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199383);
      return;
    }
    paramView.putExtra("finder_username", FinderSelfUI.b(this.qPI));
    paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
    localObject = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a((Context)this.qPI, paramView, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.qPI, paramView);
    AppMethodBeat.o(199383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI.o
 * JD-Core Version:    0.7.0.1
 */