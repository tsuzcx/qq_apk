package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.e.e;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TestUI$i
  implements View.OnClickListener
{
  public static final i ydD;
  
  static
  {
    AppMethodBeat.i(241543);
    ydD = new i();
    AppMethodBeat.o(241543);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(241542);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = ((PluginGameLife)g.ah(PluginGameLife.class)).getConversationStorage();
    ((c)g.af(c.class)).aAT(((com.tencent.mm.plugin.gamelife.e.a)paramView.dP(0, 1).get(0)).field_sessionId);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI.i
 * JD-Core Version:    0.7.0.1
 */