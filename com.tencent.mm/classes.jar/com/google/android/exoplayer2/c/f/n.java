package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean aKD;
  private final int aLB;
  boolean aLC;
  public int aLD;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(95140);
    this.aLB = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(95140);
  }
  
  public final void dI(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(95141);
    if (!this.aKD)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.aLB) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aKD = bool1;
      if (this.aKD)
      {
        this.aLD = 3;
        this.aLC = false;
      }
      AppMethodBeat.o(95141);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean dJ(int paramInt)
  {
    if (!this.aKD) {
      return false;
    }
    this.aLD -= paramInt;
    this.aKD = false;
    this.aLC = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95142);
    if (!this.aKD)
    {
      AppMethodBeat.o(95142);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.aLD + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.aLD + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.aLD, paramInt2);
    this.aLD = (paramInt2 + this.aLD);
    AppMethodBeat.o(95142);
  }
  
  public final void reset()
  {
    this.aKD = false;
    this.aLC = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */