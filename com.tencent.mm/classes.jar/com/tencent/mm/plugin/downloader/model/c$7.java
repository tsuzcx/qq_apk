package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$7
  implements Runnable
{
  c$7(c paramc, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2382);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].hx(this.kYi);
      i += 1;
    }
    AppMethodBeat.o(2382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.7
 * JD-Core Version:    0.7.0.1
 */