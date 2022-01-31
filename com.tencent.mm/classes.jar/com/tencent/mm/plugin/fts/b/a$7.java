package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$7
  implements ap.a
{
  private int mUh = 0;
  
  a$7(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(136658);
    PluginFTS localPluginFTS = (PluginFTS)g.G(PluginFTS.class);
    if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
    for (int i = 1; i == 0; i = 0)
    {
      i = this.mUh + 1;
      this.mUh = i;
      if (i >= 6) {
        break;
      }
      AppMethodBeat.o(136658);
      return true;
    }
    a.e(this.mUg).a(131093, new a.u(this.mUg, (byte)0));
    this.mUh = 0;
    AppMethodBeat.o(136658);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136659);
    String str = super.toString() + "|delayIndexTimer";
    AppMethodBeat.o(136659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.7
 * JD-Core Version:    0.7.0.1
 */