package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class c$5
  implements Runnable
{
  c$5(c.b paramb, Context paramContext, Pair paramPair, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(151458);
    try
    {
      this.nmh.bHN();
      c.a(this.val$context, ((Integer)this.nmi.first).intValue(), ((Integer)this.nmi.second).intValue(), this.nmj, null, false);
      AppMethodBeat.o(151458);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ac.w("MicroMsg.ShortcutUtil", localIllegalStateException.toString());
      AppMethodBeat.o(151458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.5
 * JD-Core Version:    0.7.0.1
 */