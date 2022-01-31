package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class c$2
  implements Runnable
{
  c$2(c paramc, MMActivity paramMMActivity, Intent paramIntent, MMActivity.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131440);
    d.a(this.cae, ".ui.transmit.SelectConversationUI", this.val$intent, 1, this.hZv);
    AppMethodBeat.o(131440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.c.2
 * JD-Core Version:    0.7.0.1
 */