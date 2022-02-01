package com.tencent.matrix.trace;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.e;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.getInstance().onStop();
    com.tencent.matrix.trace.core.b.HU().onStop();
    a.b(this.cBw).Ih();
    a.c(this.cBw).Ih();
    a.d(this.cBw).Ih();
    a.e(this.cBw).Ih();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.a.2
 * JD-Core Version:    0.7.0.1
 */