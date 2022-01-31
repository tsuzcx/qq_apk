package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$8
  implements Runnable
{
  c$8(c paramc, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2383);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].hy(this.kYi);
      i += 1;
    }
    AppMethodBeat.o(2383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.8
 * JD-Core Version:    0.7.0.1
 */