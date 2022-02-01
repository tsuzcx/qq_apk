package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class d
  extends com.tencent.mm.sdk.b.c<oz>
{
  public d()
  {
    AppMethodBeat.i(161391);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(161391);
  }
  
  private static boolean aJX()
  {
    AppMethodBeat.i(26134);
    ba.aBQ();
    long l = ((Long)com.tencent.mm.model.c.ajl().get(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        ba.aiU().a(new com.tencent.mm.plugin.label.b.c(), 0);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
      }
      AppMethodBeat.o(26134);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.d
 * JD-Core Version:    0.7.0.1
 */