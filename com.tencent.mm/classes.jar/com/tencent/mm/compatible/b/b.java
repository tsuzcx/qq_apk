package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int jmL = 0;
  public int jmM = 0;
  public byte[] jmN = null;
  public int jmO = 0;
  public int jmP = 0;
  public boolean jmQ = false;
  public Lock jmR = null;
  
  public final int atF()
  {
    AppMethodBeat.i(155548);
    if (this.jmQ) {
      this.jmR.lock();
    }
    if (this.jmO == this.jmP)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.jmO < this.jmP) {
      this.jmM = (this.jmP - this.jmO);
    }
    for (;;)
    {
      if (this.jmQ) {
        this.jmR.unlock();
      }
      int i = this.jmM;
      AppMethodBeat.o(155548);
      return i;
      if (this.jmO > this.jmP) {
        this.jmM = (this.jmP + this.jmL - this.jmO);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */