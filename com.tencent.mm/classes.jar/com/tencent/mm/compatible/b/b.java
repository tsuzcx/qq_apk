package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int fCf = 0;
  public int fCg = 0;
  public byte[] fCh = null;
  public int fCi = 0;
  public int fCj = 0;
  public boolean fCk = false;
  public Lock fCl = null;
  
  public final int Xg()
  {
    AppMethodBeat.i(155548);
    if (this.fCk) {
      this.fCl.lock();
    }
    if (this.fCi == this.fCj)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.fCi < this.fCj) {
      this.fCg = (this.fCj - this.fCi);
    }
    for (;;)
    {
      if (this.fCk) {
        this.fCl.unlock();
      }
      int i = this.fCg;
      AppMethodBeat.o(155548);
      return i;
      if (this.fCi > this.fCj) {
        this.fCg = (this.fCj + this.fCf - this.fCi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */