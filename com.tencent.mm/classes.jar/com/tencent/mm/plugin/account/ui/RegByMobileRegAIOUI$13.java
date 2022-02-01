package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileRegAIOUI$13
  implements Runnable
{
  RegByMobileRegAIOUI$13(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(128526);
    Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jpj);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.jpj;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$20", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((RegByMobileRegAIOUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$20", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    g.ajA();
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(this.jpj.getClass().getName()).append(",L14,");
    g.ajA();
    com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("L14") + ",4");
    this.jpj.finish();
    AppMethodBeat.o(128526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.13
 * JD-Core Version:    0.7.0.1
 */