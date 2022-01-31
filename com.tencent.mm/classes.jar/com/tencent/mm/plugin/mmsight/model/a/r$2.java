package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$2
  implements Runnable
{
  r$2(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(76671);
    r.a(this.oJO);
    if (this.oJO.oJM != null)
    {
      this.oJO.oJM.bRn();
      this.oJO.oJM = null;
    }
    AppMethodBeat.o(76671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r.2
 * JD-Core Version:    0.7.0.1
 */