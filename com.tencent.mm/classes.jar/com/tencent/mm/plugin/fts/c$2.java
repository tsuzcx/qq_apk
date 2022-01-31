package com.tencent.mm.plugin.fts;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(136522);
    Looper.prepare();
    c.a(this.mPv, new ak());
    Looper.loop();
    AppMethodBeat.o(136522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.2
 * JD-Core Version:    0.7.0.1
 */