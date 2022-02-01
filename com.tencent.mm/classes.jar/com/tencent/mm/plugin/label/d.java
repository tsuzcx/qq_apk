package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class d
  extends IListener<ps>
{
  public d()
  {
    AppMethodBeat.i(161391);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161391);
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(26134);
    bg.aVF();
    long l = ((Long)com.tencent.mm.model.c.azQ().get(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        bg.azz().a(new com.tencent.mm.plugin.label.b.c(), 0);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
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