package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
    h localh = new h();
    g.DO().dJT.a(localh, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.a.1
 * JD-Core Version:    0.7.0.1
 */