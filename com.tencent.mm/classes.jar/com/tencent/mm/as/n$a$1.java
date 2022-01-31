package com.tencent.mm.as;

import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class n$a$1
  implements Runnable
{
  n$a$1(n.a parama, n.e parame) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    n.a.a locala = new n.a.a();
    locala.epI = new PString();
    locala.epJ = new PString();
    locala.epK = new PString();
    locala.epL = new PString();
    String str = f.mc(this.epG.epQ);
    locala.enA = o.OJ().a(this.epG.epQ, str, this.epG.ent, true, locala.epI, locala.epJ, locala.epK, locala.epL, this.epG.epS, this.epG.epX);
    n.a.a(this.epH).lock();
    try
    {
      this.epH.epF = locala;
      n.a.b(this.epH).signal();
      y.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { this.epG.epQ, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      return;
    }
    finally
    {
      n.a.a(this.epH).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.n.a.1
 * JD-Core Version:    0.7.0.1
 */