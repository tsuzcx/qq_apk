package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class d
  extends com.tencent.mm.sdk.b.c<mv>
{
  public d()
  {
    AppMethodBeat.i(22511);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(22511);
  }
  
  private static boolean aiN()
  {
    AppMethodBeat.i(22512);
    aw.aaz();
    long l = ((Long)com.tencent.mm.model.c.Ru().get(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        aw.Rc().a(new com.tencent.mm.plugin.label.b.c(), 0);
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
      }
      AppMethodBeat.o(22512);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.d
 * JD-Core Version:    0.7.0.1
 */