package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean bqX;
  private final int brV;
  boolean brW;
  public int brX;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.brV = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void er(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.bqX)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.brV) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bqX = bool1;
      if (this.bqX)
      {
        this.brX = 3;
        this.brW = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean es(int paramInt)
  {
    if (!this.bqX) {
      return false;
    }
    this.brX -= paramInt;
    this.bqX = false;
    this.brW = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.bqX)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.brX + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.brX + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.brX, paramInt2);
    this.brX = (paramInt2 + this.brX);
    AppMethodBeat.o(92264);
  }
  
  public final void reset()
  {
    this.bqX = false;
    this.brW = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */