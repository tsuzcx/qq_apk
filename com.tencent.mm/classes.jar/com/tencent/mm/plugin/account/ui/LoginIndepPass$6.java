package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

final class LoginIndepPass$6
  implements Runnable
{
  LoginIndepPass$6(LoginIndepPass paramLoginIndepPass) {}
  
  public final void run()
  {
    AppMethodBeat.i(124974);
    ab.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
    Intent localIntent = a.gmO.bm(this.gEE);
    localIntent.addFlags(67108864);
    this.gEE.startActivity(localIntent);
    this.gEE.finish();
    AppMethodBeat.o(124974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.6
 * JD-Core Version:    0.7.0.1
 */