package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

final class n
{
  private boolean aDS;
  private final int aER;
  boolean aES;
  public byte[] aET;
  public int aEU;
  
  public n(int paramInt)
  {
    this.aER = paramInt;
    this.aET = new byte[''];
    this.aET[2] = 1;
  }
  
  public final void dc(int paramInt)
  {
    boolean bool2 = true;
    if (!this.aDS)
    {
      bool1 = true;
      a.aC(bool1);
      if (paramInt != this.aER) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aDS = bool1;
      if (this.aDS)
      {
        this.aEU = 3;
        this.aES = false;
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean dd(int paramInt)
  {
    if (!this.aDS) {
      return false;
    }
    this.aEU -= paramInt;
    this.aDS = false;
    this.aES = true;
    return true;
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.aDS) {
      return;
    }
    paramInt2 -= paramInt1;
    if (this.aET.length < this.aEU + paramInt2) {
      this.aET = Arrays.copyOf(this.aET, (this.aEU + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.aET, this.aEU, paramInt2);
    this.aEU = (paramInt2 + this.aEU);
  }
  
  public final void reset()
  {
    this.aDS = false;
    this.aES = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.n
 * JD-Core Version:    0.7.0.1
 */