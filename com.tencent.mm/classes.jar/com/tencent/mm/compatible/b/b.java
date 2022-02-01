package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int lPW = 0;
  public int lPX = 0;
  public byte[] lPY = null;
  public int lPZ = 0;
  public int lQa = 0;
  public boolean lQb = false;
  public Lock lQc = null;
  
  public final int aOd()
  {
    AppMethodBeat.i(155548);
    if (this.lQb) {
      this.lQc.lock();
    }
    if (this.lPZ == this.lQa)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.lPZ < this.lQa) {
      this.lPX = (this.lQa - this.lPZ);
    }
    for (;;)
    {
      if (this.lQb) {
        this.lQc.unlock();
      }
      int i = this.lPX;
      AppMethodBeat.o(155548);
      return i;
      if (this.lPZ > this.lQa) {
        this.lPX = (this.lQa + this.lPW - this.lPZ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */