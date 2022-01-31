package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$5
  implements ap.a
{
  c$5(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(136742);
    if (!this.mUU.mUN)
    {
      this.mUU.mUN = true;
      this.mUU.ezf.a(131112, new c.a(this.mUU, (byte)0));
    }
    a.ymk.d(this.mUU.mUR);
    AppMethodBeat.o(136742);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136743);
    String str = super.toString() + "|mBackgroundTimer";
    AppMethodBeat.o(136743);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.5
 * JD-Core Version:    0.7.0.1
 */