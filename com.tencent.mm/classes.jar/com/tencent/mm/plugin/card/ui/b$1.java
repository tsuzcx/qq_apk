package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
    g localg = am.aAI();
    if (localg != null) {
      localg.a(q.izl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.b.1
 * JD-Core Version:    0.7.0.1
 */