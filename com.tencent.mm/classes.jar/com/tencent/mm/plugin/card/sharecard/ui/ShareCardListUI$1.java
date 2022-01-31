package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ShareCardListUI$1
  implements Runnable
{
  ShareCardListUI$1(ShareCardListUI paramShareCardListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(88166);
    ShareCardListUI.a(this.krQ);
    ShareCardListUI.b(this.krQ);
    this.krQ.krO = true;
    ab.d("MicroMsg.ShareCardListUI", "initLocation end");
    AppMethodBeat.o(88166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.1
 * JD-Core Version:    0.7.0.1
 */