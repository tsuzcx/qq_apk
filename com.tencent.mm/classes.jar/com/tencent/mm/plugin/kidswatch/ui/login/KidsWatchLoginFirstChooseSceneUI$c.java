package com.tencent.mm.plugin.kidswatch.ui.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchLoginFirstChooseSceneUI$c
  implements View.OnClickListener
{
  KidsWatchLoginFirstChooseSceneUI$c(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256269);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    KidsWatchLoginFirstChooseSceneUI.a(this.yBs, 1);
    KidsWatchLoginFirstChooseSceneUI.b(this.yBs);
    a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI.c
 * JD-Core Version:    0.7.0.1
 */