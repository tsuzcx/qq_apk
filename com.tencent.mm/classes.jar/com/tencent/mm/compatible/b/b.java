package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int fXA = 0;
  public byte[] fXB = null;
  public int fXC = 0;
  public int fXD = 0;
  public boolean fXE = false;
  public Lock fXF = null;
  public int fXz = 0;
  
  public final int ZQ()
  {
    AppMethodBeat.i(155548);
    if (this.fXE) {
      this.fXF.lock();
    }
    if (this.fXC == this.fXD)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.fXC < this.fXD) {
      this.fXA = (this.fXD - this.fXC);
    }
    for (;;)
    {
      if (this.fXE) {
        this.fXF.unlock();
      }
      int i = this.fXA;
      AppMethodBeat.o(155548);
      return i;
      if (this.fXC > this.fXD) {
        this.fXA = (this.fXD + this.fXz - this.fXC);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */