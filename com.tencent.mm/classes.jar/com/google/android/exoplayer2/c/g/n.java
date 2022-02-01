package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean bgc;
  private final int bha;
  boolean bhb;
  public int bhc;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.bha = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void et(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.bgc)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.bha) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bgc = bool1;
      if (this.bgc)
      {
        this.bhc = 3;
        this.bhb = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean eu(int paramInt)
  {
    if (!this.bgc) {
      return false;
    }
    this.bhc -= paramInt;
    this.bgc = false;
    this.bhb = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.bgc)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.bhc + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.bhc + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.bhc, paramInt2);
    this.bhc = (paramInt2 + this.bhc);
    AppMethodBeat.o(92264);
  }
  
  public final void reset()
  {
    this.bgc = false;
    this.bhb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.n
 * JD-Core Version:    0.7.0.1
 */