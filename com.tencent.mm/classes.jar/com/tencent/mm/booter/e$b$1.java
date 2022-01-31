package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$b$1
  implements Runnable
{
  e$b$1(e.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(15842);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(15842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.e.b.1
 * JD-Core Version:    0.7.0.1
 */