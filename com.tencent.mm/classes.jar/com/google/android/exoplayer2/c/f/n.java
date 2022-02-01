package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean brc;
  private final int bsa;
  boolean bsb;
  public int bsc;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.bsa = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void ex(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.brc)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.bsa) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.brc = bool1;
      if (this.brc)
      {
        this.bsc = 3;
        this.bsb = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean ey(int paramInt)
  {
    if (!this.brc) {
      return false;
    }
    this.bsc -= paramInt;
    this.brc = false;
    this.bsb = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.brc)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.bsc + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.bsc + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.bsc, paramInt2);
    this.bsc = (paramInt2 + this.bsc);
    AppMethodBeat.o(92264);
  }
  
  public final void reset()
  {
    this.brc = false;
    this.bsb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */