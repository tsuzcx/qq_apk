package com.tencent.e.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements g
{
  public final void Xq() {}
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(183279);
    h.ZvG.bg(paramRunnable);
    AppMethodBeat.o(183279);
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(183280);
    String str = "ComputeScheduler@" + hashCode();
    AppMethodBeat.o(183280);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.b
 * JD-Core Version:    0.7.0.1
 */