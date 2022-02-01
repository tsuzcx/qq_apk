package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int iyP;
  private int iyQ;
  int iyR;
  private short[] iyS;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.iyP = 0;
    this.iyQ = 0;
    this.iyR = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.iyS = new short[i];
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
      int i = this.iyS.length;
      if (paramInt < this.iyR)
      {
        if (paramInt > i - this.iyP) {
          break label111;
        }
        System.arraycopy(this.iyS, this.iyP, paramArrayOfShort, 0, paramInt);
        this.iyP += paramInt;
        if (this.iyP < i) {}
      }
      label111:
      int j;
      for (this.iyP = 0;; this.iyP = j)
      {
        this.iyR -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.iyR;
        break;
        i -= this.iyP;
        System.arraycopy(this.iyS, this.iyP, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.iyS, 0, paramArrayOfShort, i, j);
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
      int i = this.iyS.length - this.iyR;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.iyR) {
            break label221;
          }
          if (i > this.iyS.length - this.iyP) {
            break label229;
          }
          this.iyP += i;
          if (this.iyP >= this.iyS.length) {
            this.iyP = 0;
          }
          label114:
          this.iyR -= i;
        }
      }
      if (paramInt > this.iyS.length)
      {
        i = paramInt - this.iyS.length + 0;
        paramInt = this.iyS.length;
      }
      for (;;)
      {
        if (paramInt <= this.iyS.length - this.iyQ)
        {
          System.arraycopy(paramArrayOfShort, i, this.iyS, this.iyQ, paramInt);
          this.iyQ += paramInt;
          if (this.iyQ < this.iyS.length) {}
        }
        label221:
        label229:
        int k;
        for (this.iyQ = 0;; this.iyQ = k)
        {
          this.iyR += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.iyR;
          break;
          this.iyP = (i - (this.iyS.length - this.iyP));
          break label114;
          int j = this.iyS.length - this.iyQ;
          System.arraycopy(paramArrayOfShort, i, this.iyS, this.iyQ, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.iyS, 0, k);
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.a
 * JD-Core Version:    0.7.0.1
 */