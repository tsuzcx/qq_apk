package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements Runnable
{
  c$2(c paramc, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(2377);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].i(this.kYi, this.val$path);
      i += 1;
    }
    if (c.bjj() != null) {
      c.bjj().i(this.kYi, this.val$path);
    }
    AppMethodBeat.o(2377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.2
 * JD-Core Version:    0.7.0.1
 */