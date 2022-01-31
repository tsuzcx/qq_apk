package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int elH = 0;
  public int elI = 0;
  public byte[] elJ = null;
  public int elK = 0;
  public int elL = 0;
  public boolean elM = false;
  public Lock elN = null;
  
  public final int Kz()
  {
    AppMethodBeat.i(92829);
    if (this.elM) {
      this.elN.lock();
    }
    if (this.elK == this.elL)
    {
      AppMethodBeat.o(92829);
      return 0;
    }
    if (this.elK < this.elL) {
      this.elI = (this.elL - this.elK);
    }
    for (;;)
    {
      if (this.elM) {
        this.elN.unlock();
      }
      int i = this.elI;
      AppMethodBeat.o(92829);
      return i;
      if (this.elK > this.elL) {
        this.elI = (this.elL + this.elH - this.elK);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */