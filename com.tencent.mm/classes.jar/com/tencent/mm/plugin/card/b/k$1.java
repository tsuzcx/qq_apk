package com.tencent.mm.plugin.card.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class k$1
  implements Runnable
{
  public final void run()
  {
    y.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
    g.DP().Dz().c(ac.a.uoX, "");
    g.DP().Dz().c(ac.a.upd, Integer.valueOf(0));
    g.DP().Dz().c(ac.a.upa, "");
    g.DP().Dz().c(ac.a.upb, "");
    g.DP().Dz().c(ac.a.upc, "");
    g.DP().Dz().c(ac.a.upo, "");
    g.DP().Dz().c(ac.a.upp, Boolean.valueOf(false));
    if (c.BS().bc(262152, 266256)) {
      c.BS().w(262152, false);
    }
    if (c.BS().bb(262152, 266256)) {
      c.BS().v(262152, false);
    }
    if (c.BS().a(ac.a.uoR, ac.a.uoT)) {
      c.BS().a(ac.a.uoR, false);
    }
    if (c.BS().a(ac.a.uoS, ac.a.uoU)) {
      c.BS().a(ac.a.uoS, false);
    }
    y.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.k.1
 * JD-Core Version:    0.7.0.1
 */