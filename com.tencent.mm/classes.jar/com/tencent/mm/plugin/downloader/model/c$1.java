package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements Runnable
{
  c$1(c paramc, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(2376);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].onTaskStarted(this.kYi, this.val$path);
      i += 1;
    }
    if (c.bjj() != null) {
      c.bjj().onTaskStarted(this.kYi, this.val$path);
    }
    AppMethodBeat.o(2376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.1
 * JD-Core Version:    0.7.0.1
 */