package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class d
  extends com.tencent.mm.sdk.b.c<oq>
{
  public d()
  {
    AppMethodBeat.i(161391);
    this.__eventId = oq.class.getName().hashCode();
    AppMethodBeat.o(161391);
  }
  
  private static boolean aGM()
  {
    AppMethodBeat.i(26134);
    az.ayM();
    long l = ((Long)com.tencent.mm.model.c.agA().get(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        az.agi().a(new com.tencent.mm.plugin.label.b.c(), 0);
        az.ayM();
        com.tencent.mm.model.c.agA().set(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
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