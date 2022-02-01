package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b
{
  public int fVt = 0;
  public int fVu = 0;
  public byte[] fVv = null;
  public int fVw = 0;
  public int fVx = 0;
  public boolean fVy = false;
  public Lock fVz = null;
  
  public final int ZH()
  {
    AppMethodBeat.i(155548);
    if (this.fVy) {
      this.fVz.lock();
    }
    if (this.fVw == this.fVx)
    {
      AppMethodBeat.o(155548);
      return 0;
    }
    if (this.fVw < this.fVx) {
      this.fVu = (this.fVx - this.fVw);
    }
    for (;;)
    {
      if (this.fVy) {
        this.fVz.unlock();
      }
      int i = this.fVu;
      AppMethodBeat.o(155548);
      return i;
      if (this.fVw > this.fVx) {
        this.fVu = (this.fVx + this.fVt - this.fVw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.b
 * JD-Core Version:    0.7.0.1
 */