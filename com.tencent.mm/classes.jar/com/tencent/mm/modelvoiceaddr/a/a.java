package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int iBI;
  private int iBJ;
  int iBK;
  private short[] iBL;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.iBI = 0;
    this.iBJ = 0;
    this.iBK = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.iBL = new short[i];
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
      int i = this.iBL.length;
      if (paramInt < this.iBK)
      {
        if (paramInt > i - this.iBI) {
          break label111;
        }
        System.arraycopy(this.iBL, this.iBI, paramArrayOfShort, 0, paramInt);
        this.iBI += paramInt;
        if (this.iBI < i) {}
      }
      label111:
      int j;
      for (this.iBI = 0;; this.iBI = j)
      {
        this.iBK -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.iBK;
        break;
        i -= this.iBI;
        System.arraycopy(this.iBL, this.iBI, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.iBL, 0, paramArrayOfShort, i, j);
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
      int i = this.iBL.length - this.iBK;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.iBK) {
            break label221;
          }
          if (i > this.iBL.length - this.iBI) {
            break label229;
          }
          this.iBI += i;
          if (this.iBI >= this.iBL.length) {
            this.iBI = 0;
          }
          label114:
          this.iBK -= i;
        }
      }
      if (paramInt > this.iBL.length)
      {
        i = paramInt - this.iBL.length + 0;
        paramInt = this.iBL.length;
      }
      for (;;)
      {
        if (paramInt <= this.iBL.length - this.iBJ)
        {
          System.arraycopy(paramArrayOfShort, i, this.iBL, this.iBJ, paramInt);
          this.iBJ += paramInt;
          if (this.iBJ < this.iBL.length) {}
        }
        label221:
        label229:
        int k;
        for (this.iBJ = 0;; this.iBJ = k)
        {
          this.iBK += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.iBK;
          break;
          this.iBI = (i - (this.iBL.length - this.iBI));
          break label114;
          int j = this.iBL.length - this.iBJ;
          System.arraycopy(paramArrayOfShort, i, this.iBL, this.iBJ, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.iBL, 0, k);
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.a
 * JD-Core Version:    0.7.0.1
 */