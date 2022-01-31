package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.atomic.AtomicLong;

final class c$a
{
  volatile AtomicLong jzH;
  ai jzI;
  ai jzJ;
  
  private c$a(c paramc)
  {
    AppMethodBeat.i(17175);
    this.jzH = new AtomicLong(0L);
    this.jzI = new ai(true);
    this.jzJ = new ai(true);
    AppMethodBeat.o(17175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.a
 * JD-Core Version:    0.7.0.1
 */