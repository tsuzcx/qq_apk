package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.MMActivity;

final class g$3
  implements Runnable
{
  g$3(g paramg, MMActivity paramMMActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(125083);
    Intent localIntent = a.gmO.bm(this.cae);
    localIntent.addFlags(67108864);
    this.cae.startActivity(localIntent);
    this.cae.finish();
    AppMethodBeat.o(125083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g.3
 * JD-Core Version:    0.7.0.1
 */