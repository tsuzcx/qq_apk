package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int jwX;
  private int jwY;
  int jwZ;
  private short[] jxa;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.jwX = 0;
    this.jwY = 0;
    this.jwZ = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.jxa = new short[i];
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
      int i = this.jxa.length;
      if (paramInt < this.jwZ)
      {
        if (paramInt > i - this.jwX) {
          break label111;
        }
        System.arraycopy(this.jxa, this.jwX, paramArrayOfShort, 0, paramInt);
        this.jwX += paramInt;
        if (this.jwX < i) {}
      }
      label111:
      int j;
      for (this.jwX = 0;; this.jwX = j)
      {
        this.jwZ -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.jwZ;
        break;
        i -= this.jwX;
        System.arraycopy(this.jxa, this.jwX, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.jxa, 0, paramArrayOfShort, i, j);
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
      int i = this.jxa.length - this.jwZ;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.jwZ) {
            break label221;
          }
          if (i > this.jxa.length - this.jwX) {
            break label229;
          }
          this.jwX += i;
          if (this.jwX >= this.jxa.length) {
            this.jwX = 0;
          }
          label114:
          this.jwZ -= i;
        }
      }
      if (paramInt > this.jxa.length)
      {
        i = paramInt - this.jxa.length + 0;
        paramInt = this.jxa.length;
      }
      for (;;)
      {
        if (paramInt <= this.jxa.length - this.jwY)
        {
          System.arraycopy(paramArrayOfShort, i, this.jxa, this.jwY, paramInt);
          this.jwY += paramInt;
          if (this.jwY < this.jxa.length) {}
        }
        label221:
        label229:
        int k;
        for (this.jwY = 0;; this.jwY = k)
        {
          this.jwZ += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.jwZ;
          break;
          this.jwX = (i - (this.jxa.length - this.jwX));
          break label114;
          int j = this.jxa.length - this.jwY;
          System.arraycopy(paramArrayOfShort, i, this.jxa, this.jwY, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.jxa, 0, k);
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