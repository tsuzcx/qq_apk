package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

final class l$4
  implements Runnable
{
  l$4(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(125136);
    ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
    Intent localIntent = a.gmO.bm(this.gFF.gFq);
    localIntent.addFlags(67108864);
    this.gFF.gFq.startActivity(localIntent);
    this.gFF.gFq.finish();
    AppMethodBeat.o(125136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.4
 * JD-Core Version:    0.7.0.1
 */