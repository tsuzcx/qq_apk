package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TestUI$f
  implements View.OnClickListener
{
  public static final f Djg;
  
  static
  {
    AppMethodBeat.i(202705);
    Djg = new f();
    AppMethodBeat.o(202705);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202704);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ((PluginGameLife)h.ag(PluginGameLife.class)).clearDB();
    a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(202704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI.f
 * JD-Core Version:    0.7.0.1
 */