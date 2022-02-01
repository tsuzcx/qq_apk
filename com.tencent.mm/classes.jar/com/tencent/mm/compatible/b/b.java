package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public byte[] fyA = null;
  public int fyB = 0;
  public int fyC = 0;
  public boolean fyD = false;
  public Lock fyE = null;
  public int fyy = 0;
  public int fyz = 0;
  
  public final int Wi()
  {
    AppMethodBeat.i(155548);
    if (this.fyD) {
      this.fyE.lock();
    }
    if (this.fyB == this.fyC)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.fyB < this.fyC) {
      this.fyz = (this.fyC - this.fyB);
    }
    for (;;)
    {
      if (this.fyD) {
        this.fyE.unlock();
      }
      int i = this.fyz;
      AppMethodBeat.o(155548);
      return i;
      if (this.fyB > this.fyC) {
        this.fyz = (this.fyC + this.fyy - this.fyB);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */