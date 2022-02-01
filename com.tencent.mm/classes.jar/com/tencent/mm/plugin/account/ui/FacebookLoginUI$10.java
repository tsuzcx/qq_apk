package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;

final class FacebookLoginUI$10
  implements Runnable
{
  FacebookLoginUI$10(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(127993);
    Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.klb);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.klb;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/FacebookLoginUI$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((FacebookLoginUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/FacebookLoginUI$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    g.aAf();
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(this.klb.getClass().getName()).append(",L14,");
    g.aAf();
    com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",4");
    this.klb.finish();
    AppMethodBeat.o(127993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.10
 * JD-Core Version:    0.7.0.1
 */