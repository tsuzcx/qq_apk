package com.tencent.mm.plugin.kidswatch.ui.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchLoginFirstChooseSceneUI$e
  implements View.OnClickListener
{
  KidsWatchLoginFirstChooseSceneUI$e(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251406);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = this.EcI;
    localObject = KidsWatchLoginFirstChooseSceneUI.c(this.EcI);
    if (localObject == null) {
      p.iCn();
    }
    KidsWatchLoginFirstChooseSceneUI.a(paramView, (String)localObject, KidsWatchLoginFirstChooseSceneUI.d(this.EcI), KidsWatchLoginFirstChooseSceneUI.a(this.EcI));
    a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI.e
 * JD-Core Version:    0.7.0.1
 */