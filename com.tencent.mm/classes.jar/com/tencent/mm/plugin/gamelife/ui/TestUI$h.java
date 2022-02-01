package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TestUI$h
  implements View.OnClickListener
{
  TestUI$h(TestUI paramTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203186);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ((PluginGameLife)h.ag(PluginGameLife.class)).enterChattingUI((Context)this.Dje, this.Dje.DiY, this.Dje.DiX, 0, null);
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI.h
 * JD-Core Version:    0.7.0.1
 */