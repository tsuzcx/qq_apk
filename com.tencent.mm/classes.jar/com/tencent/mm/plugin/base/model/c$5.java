package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$5
  implements Runnable
{
  c$5(c.b paramb, Context paramContext, Pair paramPair, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(155982);
    try
    {
      this.jLn.aVC();
      c.a(this.val$context, ((Integer)this.jLo.first).intValue(), ((Integer)this.jLo.second).intValue(), this.jLp, null, false);
      AppMethodBeat.o(155982);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ab.w("MicroMsg.ShortcutUtil", localIllegalStateException.toString());
      AppMethodBeat.o(155982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.5
 * JD-Core Version:    0.7.0.1
 */