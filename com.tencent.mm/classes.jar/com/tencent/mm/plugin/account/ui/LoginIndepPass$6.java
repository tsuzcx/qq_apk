package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;

final class LoginIndepPass$6
  implements Runnable
{
  LoginIndepPass$6(LoginIndepPass paramLoginIndepPass) {}
  
  public final void run()
  {
    AppMethodBeat.i(128152);
    ad.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
    Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jly);
    ((Intent)localObject).addFlags(67108864);
    LoginIndepPass localLoginIndepPass = this.jly;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localLoginIndepPass.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.jly.finish();
    AppMethodBeat.o(128152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.6
 * JD-Core Version:    0.7.0.1
 */