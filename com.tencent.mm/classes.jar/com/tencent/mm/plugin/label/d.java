package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class d
  extends com.tencent.mm.sdk.b.c<pa>
{
  public d()
  {
    AppMethodBeat.i(161391);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(161391);
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(26134);
    bc.aCg();
    long l = ((Long)com.tencent.mm.model.c.ajA().get(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        bc.ajj().a(new com.tencent.mm.plugin.label.b.c(), 0);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
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