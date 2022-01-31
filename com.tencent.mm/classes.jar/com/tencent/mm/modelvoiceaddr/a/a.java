package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int gcb;
  private int gcc;
  int gcd;
  private short[] gce;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(116754);
    this.gcb = 0;
    this.gcc = 0;
    this.gcd = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.gce = new short[i];
    AppMethodBeat.o(116754);
  }
  
  final int d(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(116755);
    if (paramInt > paramArrayOfShort.length) {
      paramInt = paramArrayOfShort.length;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(116755);
        return 0;
      }
      int i = this.gce.length;
      if (paramInt < this.gcd)
      {
        if (paramInt > i - this.gcb) {
          break label111;
        }
        System.arraycopy(this.gce, this.gcb, paramArrayOfShort, 0, paramInt);
        this.gcb += paramInt;
        if (this.gcb < i) {}
      }
      label111:
      int j;
      for (this.gcb = 0;; this.gcb = j)
      {
        this.gcd -= paramInt;
        AppMethodBeat.o(116755);
        return paramInt;
        paramInt = this.gcd;
        break;
        i -= this.gcb;
        System.arraycopy(this.gce, this.gcb, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.gce, 0, paramArrayOfShort, i, j);
      }
    }
  }
  
  final int e(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(116756);
    if (paramArrayOfShort.length < 0)
    {
      AppMethodBeat.o(116756);
      return 0;
    }
    if (paramInt > paramArrayOfShort.length + 0) {
      paramInt = paramArrayOfShort.length + 0;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        AppMethodBeat.o(116756);
        return 0;
      }
      int i = this.gce.length - this.gcd;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.gcd) {
            break label221;
          }
          if (i > this.gce.length - this.gcb) {
            break label229;
          }
          this.gcb += i;
          if (this.gcb >= this.gce.length) {
            this.gcb = 0;
          }
          label114:
          this.gcd -= i;
        }
      }
      if (paramInt > this.gce.length)
      {
        i = paramInt - this.gce.length + 0;
        paramInt = this.gce.length;
      }
      for (;;)
      {
        if (paramInt <= this.gce.length - this.gcc)
        {
          System.arraycopy(paramArrayOfShort, i, this.gce, this.gcc, paramInt);
          this.gcc += paramInt;
          if (this.gcc < this.gce.length) {}
        }
        label221:
        label229:
        int k;
        for (this.gcc = 0;; this.gcc = k)
        {
          this.gcd += paramInt;
          AppMethodBeat.o(116756);
          return paramInt;
          i = this.gcd;
          break;
          this.gcb = (i - (this.gce.length - this.gcb));
          break label114;
          int j = this.gce.length - this.gcc;
          System.arraycopy(paramArrayOfShort, i, this.gce, this.gcc, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.gce, 0, k);
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