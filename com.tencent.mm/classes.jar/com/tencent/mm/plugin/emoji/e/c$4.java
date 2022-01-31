package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$4
  extends com.tencent.mm.sdk.b.c<jw>
{
  c$4(c paramc)
  {
    AppMethodBeat.i(52830);
    this.__eventId = jw.class.getName().hashCode();
    AppMethodBeat.o(52830);
  }
  
  private static boolean a(jw paramjw)
  {
    AppMethodBeat.i(52831);
    if ((paramjw != null) && ((paramjw instanceof jw)))
    {
      ab.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (paramjw.czl.cmX)
      {
        g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
        g.RL().Ru().set(ac.a.yxV, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(52831);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c.4
 * JD-Core Version:    0.7.0.1
 */