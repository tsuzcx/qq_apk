package com.tencent.mm.plugin.kidswatch.ui.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchLoginFirstChooseSceneUI$e
  implements View.OnClickListener
{
  KidsWatchLoginFirstChooseSceneUI$e(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256271);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = this.yBs;
    localObject = KidsWatchLoginFirstChooseSceneUI.c(this.yBs);
    if (localObject == null) {
      p.hyc();
    }
    KidsWatchLoginFirstChooseSceneUI.a(paramView, (String)localObject, KidsWatchLoginFirstChooseSceneUI.d(this.yBs), KidsWatchLoginFirstChooseSceneUI.a(this.yBs));
    a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI.e
 * JD-Core Version:    0.7.0.1
 */