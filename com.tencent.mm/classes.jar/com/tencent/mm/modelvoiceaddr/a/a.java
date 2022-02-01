package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int pgn;
  private int pgo;
  int pgp;
  private short[] pgq;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(148600);
    this.pgn = 0;
    this.pgo = 0;
    this.pgp = 0;
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.pgq = new short[i];
    AppMethodBeat.o(148600);
  }
  
  final int d(short[] paramArrayOfShort, int paramInt)
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
      int i = this.pgq.length;
      if (paramInt < this.pgp)
      {
        if (paramInt > i - this.pgn) {
          break label111;
        }
        System.arraycopy(this.pgq, this.pgn, paramArrayOfShort, 0, paramInt);
        this.pgn += paramInt;
        if (this.pgn < i) {}
      }
      label111:
      int j;
      for (this.pgn = 0;; this.pgn = j)
      {
        this.pgp -= paramInt;
        AppMethodBeat.o(148601);
        return paramInt;
        paramInt = this.pgp;
        break;
        i -= this.pgn;
        System.arraycopy(this.pgq, this.pgn, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.pgq, 0, paramArrayOfShort, i, j);
      }
    }
  }
  
  final int e(short[] paramArrayOfShort, int paramInt)
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
      int i = this.pgq.length - this.pgp;
      if (paramInt > i)
      {
        i = paramInt - i;
        if (i != 0)
        {
          if (i >= this.pgp) {
            break label221;
          }
          if (i > this.pgq.length - this.pgn) {
            break label229;
          }
          this.pgn += i;
          if (this.pgn >= this.pgq.length) {
            this.pgn = 0;
          }
          label114:
          this.pgp -= i;
        }
      }
      if (paramInt > this.pgq.length)
      {
        i = paramInt - this.pgq.length + 0;
        paramInt = this.pgq.length;
      }
      for (;;)
      {
        if (paramInt <= this.pgq.length - this.pgo)
        {
          System.arraycopy(paramArrayOfShort, i, this.pgq, this.pgo, paramInt);
          this.pgo += paramInt;
          if (this.pgo < this.pgq.length) {}
        }
        label221:
        label229:
        int k;
        for (this.pgo = 0;; this.pgo = k)
        {
          this.pgp += paramInt;
          AppMethodBeat.o(148602);
          return paramInt;
          i = this.pgp;
          break;
          this.pgn = (i - (this.pgq.length - this.pgn));
          break label114;
          int j = this.pgq.length - this.pgo;
          System.arraycopy(paramArrayOfShort, i, this.pgq, this.pgo, j);
          k = paramInt - j;
          System.arraycopy(paramArrayOfShort, i + j, this.pgq, 0, k);
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