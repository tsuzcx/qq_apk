package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int mmA;
  private int mmB;
  int mmC;
  private short[] mmD;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.mmA = 0;
    this.mmB = 0;
    this.mmC = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.mmD = new short[i];
    AppMethodBeat.o(148600);
  }
  
  final int c(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148601);
    if (paramInt > paramArrayOfShort.length) {
      paramInt = paramArrayOfShort.length;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(148601);
        return 0;
      }
      int i = this.mmD.length;
      if (paramInt < this.mmC)
      {
        if (paramInt > i - this.mmA) {
          break label111;
        }
        System.arraycopy(this.mmD, this.mmA, paramArrayOfShort, 0, paramInt);
        this.mmA += paramInt;
        if (this.mmA < i) {}
      }
      label111:
      int j;
      for (this.mmA = 0;; this.mmA = j)
      {
        this.mmC -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.mmC;
        break;
        i -= this.mmA;
        System.arraycopy(this.mmD, this.mmA, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.mmD, 0, paramArrayOfShort, i, j);
      }
    }
  }
  
  final int d(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(148602);
    if (paramArrayOfShort.length < 0)
    {
      AppMethodBeat.o(148602);
      return 0;
    }
    if (paramInt > paramArrayOfShort.length + 0) {
      paramInt = paramArrayOfShort.length + 0;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(148602);
        return 0;
      }
      int i = this.mmD.length - this.mmC;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.mmC) {
            break label221;
          }
          if (i > this.mmD.length - this.mmA) {
            break label229;
          }
          this.mmA += i;
          if (this.mmA >= this.mmD.length) {
            this.mmA = 0;
          }
          label114:
          this.mmC -= i;
        }
      }
      if (paramInt > this.mmD.length)
      {
        i = paramInt - this.mmD.length + 0;
        paramInt = this.mmD.length;
      }
      for (;;)
      {
        if (paramInt <= this.mmD.length - this.mmB)
        {
          System.arraycopy(paramArrayOfShort, i, this.mmD, this.mmB, paramInt);
          this.mmB += paramInt;
          if (this.mmB < this.mmD.length) {}
        }
        label221:
        label229:
        int k;
        for (this.mmB = 0;; this.mmB = k)
        {
          this.mmC += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.mmC;
          break;
          this.mmA = (i - (this.mmD.length - this.mmA));
          break label114;
          int j = this.mmD.length - this.mmB;
          System.arraycopy(paramArrayOfShort, i, this.mmD, this.mmB, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.mmD, 0, k);
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.a
 * JD-Core Version:    0.7.0.1
 */