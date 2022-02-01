package com.tencent.mm.plugin.kidswatch.ui.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchHeadComponent$c
  implements View.OnClickListener
{
  KidsWatchHeadComponent$c(KidsWatchHeadComponent paramKidsWatchHeadComponent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251581);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("KidsWatchHeadComponent", "click help icon");
    paramView = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    paramView = this.Ecu.getContext();
    p.j(paramView, "context");
    com.tencent.mm.plugin.kidswatch.b.a.g(paramView, "wxaaff6b96fc2cd3c6", "pages/help/help.html", "1");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent$prepareViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent.c
 * JD-Core Version:    0.7.0.1
 */