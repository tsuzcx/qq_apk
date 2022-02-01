package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(121427);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(121427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.b.2
 * JD-Core Version:    0.7.0.1
 */