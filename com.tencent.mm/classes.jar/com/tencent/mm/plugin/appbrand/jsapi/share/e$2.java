package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class e$2
  implements Runnable
{
  e$2(e parame, MMActivity paramMMActivity, Intent paramIntent, MMActivity.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131448);
    d.a(this.cae, ".ui.transmit.SelectConversationUI", this.val$intent, 1, this.hZv);
    AppMethodBeat.o(131448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.e.2
 * JD-Core Version:    0.7.0.1
 */