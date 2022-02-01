package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean baz;
  private final int bbx;
  boolean bby;
  public int bbz;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.bbx = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void eG(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.baz)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.bbx) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.baz = bool1;
      if (this.baz)
      {
        this.bbz = 3;
        this.bby = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean eH(int paramInt)
  {
    if (!this.baz) {
      return false;
    }
    this.bbz -= paramInt;
    this.baz = false;
    this.bby = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.baz)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.bbz + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.bbz + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.bbz, paramInt2);
    this.bbz = (paramInt2 + this.bbz);
    AppMethodBeat.o(92264);
  }
  
  public final void reset()
  {
    this.baz = false;
    this.bby = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */