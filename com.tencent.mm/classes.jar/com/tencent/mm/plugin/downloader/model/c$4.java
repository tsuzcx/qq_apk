package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4
  implements Runnable
{
  c$4(c paramc, long paramLong, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2379);
    m[] arrayOfm = c.bji();
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].b(this.kYi, this.val$path, this.kYn);
      i += 1;
    }
    if (c.bjj() != null) {
      c.bjj().b(this.kYi, this.val$path, this.kYn);
    }
    AppMethodBeat.o(2379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.c.4
 * JD-Core Version:    0.7.0.1
 */