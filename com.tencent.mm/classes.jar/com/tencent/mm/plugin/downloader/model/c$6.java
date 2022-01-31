package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$6
  implements Runnable
{
  c$6(c paramc, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2381);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].onTaskPaused(this.kYi);
      i += 1;
    }
    if (c.bjj() != null) {
      c.bjj().onTaskPaused(this.kYi);
    }
    AppMethodBeat.o(2381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.6
 * JD-Core Version:    0.7.0.1
 */