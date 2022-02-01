package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchRegRebindUI$c
  implements View.OnClickListener
{
  KidsWatchRegRebindUI$c(KidsWatchRegRebindUI paramKidsWatchRegRebindUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256361);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    KidsWatchRegRebindUI.a(this.yBI);
    a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegRebindUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegRebindUI.c
 * JD-Core Version:    0.7.0.1
 */