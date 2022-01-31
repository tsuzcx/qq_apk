package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18726);
    Looper.prepare();
    ak localak = new ak(Looper.myLooper());
    this.kHk.kHi.put(Long.valueOf(Thread.currentThread().getId()), localak);
    Looper.loop();
    AppMethodBeat.o(18726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */