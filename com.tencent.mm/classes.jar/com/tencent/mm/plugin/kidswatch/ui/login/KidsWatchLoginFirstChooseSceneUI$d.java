package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchLoginFirstChooseSceneUI$d
  implements View.OnClickListener
{
  KidsWatchLoginFirstChooseSceneUI$d(KidsWatchLoginFirstChooseSceneUI paramKidsWatchLoginFirstChooseSceneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256270);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent((Context)this.yBs, KidsWatchLoginFirstChooseHelpUI.class);
    paramView = this.yBs;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI.d
 * JD-Core Version:    0.7.0.1
 */