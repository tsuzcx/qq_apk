package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class n
{
  private boolean cUu;
  private final int cVs;
  boolean cVt;
  public int cVu;
  public byte[] nalData;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(92262);
    this.cVs = paramInt;
    this.nalData = new byte[''];
    this.nalData[2] = 1;
    AppMethodBeat.o(92262);
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92264);
    if (!this.cUu)
    {
      AppMethodBeat.o(92264);
      return;
    }
    paramInt2 -= paramInt1;
    if (this.nalData.length < this.cVu + paramInt2) {
      this.nalData = Arrays.copyOf(this.nalData, (this.cVu + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.nalData, this.cVu, paramInt2);
    this.cVu = (paramInt2 + this.cVu);
    AppMethodBeat.o(92264);
  }
  
  public final void hW(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92263);
    if (!this.cUu)
    {
      bool1 = true;
      a.checkState(bool1);
      if (paramInt != this.cVs) {
        break label63;
      }
    }
    label63:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cUu = bool1;
      if (this.cUu)
      {
        this.cVu = 3;
        this.cVt = false;
      }
      AppMethodBeat.o(92263);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean hX(int paramInt)
  {
    if (!this.cUu) {
      return false;
    }
    this.cVu -= paramInt;
    this.cUu = false;
    this.cVt = true;
    return true;
  }
  
  public final void reset()
  {
    this.cUu = false;
    this.cVt = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.n
 * JD-Core Version:    0.7.0.1
 */