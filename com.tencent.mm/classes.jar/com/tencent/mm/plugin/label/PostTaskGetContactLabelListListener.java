package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public class PostTaskGetContactLabelListListener
  extends IListener<se>
{
  public PostTaskGetContactLabelListListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161391);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161391);
  }
  
  private static boolean bLF()
  {
    AppMethodBeat.i(26134);
    bh.bCz();
    long l = ((Long)c.ban().d(209408, Long.valueOf(0L))).longValue();
    if (System.currentTimeMillis() - l > 86400000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
        bh.aZW().a(new d(), 0);
        bh.bCz();
        c.ban().B(209408, Long.valueOf(System.currentTimeMillis() - 86400000L + 1800000L));
      }
      AppMethodBeat.o(26134);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.PostTaskGetContactLabelListListener
 * JD-Core Version:    0.7.0.1
 */