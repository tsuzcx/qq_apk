package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.n;

final class FacebookLoginUI$10
  implements Runnable
{
  FacebookLoginUI$10(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(124843);
    Object localObject = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gDq);
    ((Intent)localObject).addFlags(67108864);
    this.gDq.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gDq.getClass().getName()).append(",L14,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",4");
    this.gDq.finish();
    AppMethodBeat.o(124843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.10
 * JD-Core Version:    0.7.0.1
 */