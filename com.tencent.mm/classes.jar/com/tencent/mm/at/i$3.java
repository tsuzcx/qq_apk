package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;

final class i$3
  implements Runnable
{
  i$3(i parami, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(78285);
    if (this.ckS.getType() != 110)
    {
      AppMethodBeat.o(78285);
      return;
    }
    if (!(this.ckS instanceof l))
    {
      AppMethodBeat.o(78285);
      return;
    }
    i.c(this.fFd);
    int i = (int)((l)this.ckS).fFk;
    if (i.d(this.fFd) > 0) {
      i.e(this.fFd);
    }
    for (;;)
    {
      i.ly(i);
      AppMethodBeat.o(78285);
      return;
      i.f(this.fFd);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78286);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(78286);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.i.3
 * JD-Core Version:    0.7.0.1
 */