package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a$1
  implements Runnable
{
  b$a$1(b.a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(73917);
    if (this.mvq)
    {
      ab.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", new Object[] { Integer.valueOf(this.mvr.muk.field_type) });
      this.mvr.muk.field_itemStatus = 1;
      this.mvr.muk.field_xml = com.tencent.mm.plugin.fav.a.g.s(this.mvr.muk);
      if (!b.k(this.mvr.muk)) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(this.mvr.muk);
      }
      for (;;)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getCheckCdnService().run();
        AppMethodBeat.o(73917);
        return;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.mvr.muk, new String[0]);
      }
    }
    ab.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", new Object[] { Integer.valueOf(this.mvr.muk.field_type) });
    this.mvr.muk.field_itemStatus = 9;
    this.mvr.muk.field_xml = com.tencent.mm.plugin.fav.a.g.s(this.mvr.muk);
    if (!b.k(this.mvr.muk)) {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(this.mvr.muk);
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
      AppMethodBeat.o(73917);
      return;
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.mvr.muk, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a.1
 * JD-Core Version:    0.7.0.1
 */