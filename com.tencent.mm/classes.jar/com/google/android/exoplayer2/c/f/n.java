package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean bgI;
  private final int bhG;
  boolean bhH;
  public int bhI;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.bhG = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void et(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.bgI)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.bhG) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bgI = bool1;
      if (this.bgI)
      {
        this.bhI = 3;
        this.bhH = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean eu(int paramInt)
  {
    if (!this.bgI) {
      return false;
    }
    this.bhI -= paramInt;
    this.bgI = false;
    this.bhH = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.bgI)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.bhI + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.bhI + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.bhI, paramInt2);
    this.bhI = (paramInt2 + this.bhI);
    AppMethodBeat.o(92264);
  }
  
  public final void reset()
  {
    this.bgI = false;
    this.bhH = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */