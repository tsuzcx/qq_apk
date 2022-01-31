package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87970);
    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
    h localh = new h();
    g.RK().eHt.a(localh, 0);
    AppMethodBeat.o(87970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a.1
 * JD-Core Version:    0.7.0.1
 */