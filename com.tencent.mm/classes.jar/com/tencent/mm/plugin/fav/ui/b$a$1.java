package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.y;

final class b$a$1
  implements Runnable
{
  b$a$1(b.a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.kaU)
    {
      y.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", new Object[] { Integer.valueOf(this.kaV.jZN.field_type) });
      this.kaV.jZN.field_itemStatus = 1;
      this.kaV.jZN.field_xml = com.tencent.mm.plugin.fav.a.g.s(this.kaV.jZN);
      if (!b.k(this.kaV.jZN)) {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().y(this.kaV.jZN);
      }
      for (;;)
      {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getCheckCdnService().run();
        return;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.kaV.jZN, new String[0]);
      }
    }
    y.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", new Object[] { Integer.valueOf(this.kaV.jZN.field_type) });
    this.kaV.jZN.field_itemStatus = 9;
    this.kaV.jZN.field_xml = com.tencent.mm.plugin.fav.a.g.s(this.kaV.jZN);
    if (!b.k(this.kaV.jZN)) {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().y(this.kaV.jZN);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
      return;
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.kaV.jZN, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a.1
 * JD-Core Version:    0.7.0.1
 */