package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.e.e;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TestUI$i
  implements View.OnClickListener
{
  public static final i Djh;
  
  static
  {
    AppMethodBeat.i(203263);
    Djh = new i();
    AppMethodBeat.o(203263);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203260);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
    ((c)h.ae(c.class)).aKG(((com.tencent.mm.plugin.gamelife.e.a)paramView.en(0, 1).get(0)).field_sessionId);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI.i
 * JD-Core Version:    0.7.0.1
 */