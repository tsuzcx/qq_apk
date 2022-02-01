package com.tencent.mm.plugin.m.a.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
{
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(123792);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(123792);
      return;
    }
    ar.f(paramRunnable);
    AppMethodBeat.o(123792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.c.b
 * JD-Core Version:    0.7.0.1
 */