package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileRegAIOUI$15
  implements Runnable
{
  RegByMobileRegAIOUI$15(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(196926);
    Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.kqp);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.kqp;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((RegByMobileRegAIOUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    g.aAf();
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(this.kqp.getClass().getName()).append(",L14,");
    g.aAf();
    com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",4");
    this.kqp.finish();
    AppMethodBeat.o(196926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.15
 * JD-Core Version:    0.7.0.1
 */