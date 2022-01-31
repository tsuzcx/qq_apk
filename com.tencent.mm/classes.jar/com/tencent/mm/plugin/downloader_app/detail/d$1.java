package com.tencent.mm.plugin.downloader_app.detail;

import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.game.luggage.i.a;
import com.tencent.mm.sdk.platformtools.ae;

final class d$1
  implements i.a
{
  public final void pQ()
  {
    if (d.aGg() != null) {
      d.destroy();
    }
    d.a(i.ah(ae.getContext(), d.access$100()));
    if (d.aGg() != null) {
      d.aGg().aG(d.access$100(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d.1
 * JD-Core Version:    0.7.0.1
 */