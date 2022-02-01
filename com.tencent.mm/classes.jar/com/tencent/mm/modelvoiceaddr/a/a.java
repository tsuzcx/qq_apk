package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int ifv;
  private int ifw;
  int ifx;
  private short[] ify;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.ifv = 0;
    this.ifw = 0;
    this.ifx = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.ify = new short[i];
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
      int i = this.ify.length;
      if (paramInt < this.ifx)
      {
        if (paramInt > i - this.ifv) {
          break label111;
        }
        System.arraycopy(this.ify, this.ifv, paramArrayOfShort, 0, paramInt);
        this.ifv += paramInt;
        if (this.ifv < i) {}
      }
      label111:
      int j;
      for (this.ifv = 0;; this.ifv = j)
      {
        this.ifx -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.ifx;
        break;
        i -= this.ifv;
        System.arraycopy(this.ify, this.ifv, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.ify, 0, paramArrayOfShort, i, j);
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
      int i = this.ify.length - this.ifx;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.ifx) {
            break label221;
          }
          if (i > this.ify.length - this.ifv) {
            break label229;
          }
          this.ifv += i;
          if (this.ifv >= this.ify.length) {
            this.ifv = 0;
          }
          label114:
          this.ifx -= i;
        }
      }
      if (paramInt > this.ify.length)
      {
        i = paramInt - this.ify.length + 0;
        paramInt = this.ify.length;
      }
      for (;;)
      {
        if (paramInt <= this.ify.length - this.ifw)
        {
          System.arraycopy(paramArrayOfShort, i, this.ify, this.ifw, paramInt);
          this.ifw += paramInt;
          if (this.ifw < this.ify.length) {}
        }
        label221:
        label229:
        int k;
        for (this.ifw = 0;; this.ifw = k)
        {
          this.ifx += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.ifx;
          break;
          this.ifv = (i - (this.ify.length - this.ifv));
          break label114;
          int j = this.ify.length - this.ifw;
          System.arraycopy(paramArrayOfShort, i, this.ify, this.ifw, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.ify, 0, k);
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