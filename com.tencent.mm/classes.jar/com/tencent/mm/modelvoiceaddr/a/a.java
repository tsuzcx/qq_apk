package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int hET;
  private int hEU;
  int hEV;
  private short[] hEW;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.hET = 0;
    this.hEU = 0;
    this.hEV = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.hEW = new short[i];
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
      int i = this.hEW.length;
      if (paramInt < this.hEV)
      {
        if (paramInt > i - this.hET) {
          break label111;
        }
        System.arraycopy(this.hEW, this.hET, paramArrayOfShort, 0, paramInt);
        this.hET += paramInt;
        if (this.hET < i) {}
      }
      label111:
      int j;
      for (this.hET = 0;; this.hET = j)
      {
        this.hEV -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.hEV;
        break;
        i -= this.hET;
        System.arraycopy(this.hEW, this.hET, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.hEW, 0, paramArrayOfShort, i, j);
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
      int i = this.hEW.length - this.hEV;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.hEV) {
            break label221;
          }
          if (i > this.hEW.length - this.hET) {
            break label229;
          }
          this.hET += i;
          if (this.hET >= this.hEW.length) {
            this.hET = 0;
          }
          label114:
          this.hEV -= i;
        }
      }
      if (paramInt > this.hEW.length)
      {
        i = paramInt - this.hEW.length + 0;
        paramInt = this.hEW.length;
      }
      for (;;)
      {
        if (paramInt <= this.hEW.length - this.hEU)
        {
          System.arraycopy(paramArrayOfShort, i, this.hEW, this.hEU, paramInt);
          this.hEU += paramInt;
          if (this.hEU < this.hEW.length) {}
        }
        label221:
        label229:
        int k;
        for (this.hEU = 0;; this.hEU = k)
        {
          this.hEV += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.hEV;
          break;
          this.hET = (i - (this.hEW.length - this.hET));
          break label114;
          int j = this.hEW.length - this.hEU;
          System.arraycopy(paramArrayOfShort, i, this.hEW, this.hEU, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.hEW, 0, k);
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