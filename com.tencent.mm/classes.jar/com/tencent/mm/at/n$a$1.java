package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class n$a$1
  implements Runnable
{
  n$a$1(n.a parama, n.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(78357);
    long l = System.currentTimeMillis();
    n.a.a locala = new n.a.a();
    locala.fGi = new PString();
    locala.fGj = new PString();
    locala.fGk = new PString();
    locala.fGl = new PString();
    String str = f.tc(this.fGg.fGq);
    locala.fDX = o.ahC().a(this.fGg.fGq, str, this.fGg.fDP, true, locala.fGi, locala.fGj, locala.fGk, locala.fGl, this.fGg.fGs, this.fGg.fGx);
    n.a.a(this.fGh).lock();
    try
    {
      this.fGh.fGf = locala;
      n.a.b(this.fGh).signal();
      ab.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { this.fGg.fGq, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      return;
    }
    finally
    {
      n.a.a(this.fGh).unlock();
      AppMethodBeat.o(78357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.n.a.1
 * JD-Core Version:    0.7.0.1
 */