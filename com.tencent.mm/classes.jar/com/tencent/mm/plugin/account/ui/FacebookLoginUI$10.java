package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.m;

final class FacebookLoginUI$10
  implements Runnable
{
  FacebookLoginUI$10(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(127993);
    Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.ncR);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.ncR;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/FacebookLoginUI$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((FacebookLoginUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/FacebookLoginUI$8", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    h.aHE();
    localObject1 = ((StringBuilder)localObject1).append(b.aGR()).append(",").append(this.ncR.getClass().getName()).append(",L14,");
    h.aHE();
    com.tencent.mm.plugin.b.a.KP(b.MN("L14") + ",4");
    this.ncR.finish();
    AppMethodBeat.o(127993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.10
 * JD-Core Version:    0.7.0.1
 */