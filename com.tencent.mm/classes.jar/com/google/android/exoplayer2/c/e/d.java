package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final m aYL;
  int aYM;
  private int aYN;
  boolean aYO;
  final e aYt;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.aYt = new e();
    this.aYL = new m(new byte[65025], 0);
    this.aYM = -1;
    AppMethodBeat.o(92155);
  }
  
  private int ez(int paramInt)
  {
    int i = 0;
    this.aYN = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.aYN + paramInt >= this.aYt.aYV) {
        break;
      }
      int[] arrayOfInt = this.aYt.aYX;
      j = this.aYN;
      this.aYN = (j + 1);
      k = arrayOfInt[(j + paramInt)];
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
  
  public final boolean k(f paramf)
  {
    AppMethodBeat.i(92156);
    if (paramf != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (this.aYO)
      {
        this.aYO = false;
        this.aYL.reset();
      }
      if (this.aYO) {
        break label294;
      }
      if (this.aYM >= 0) {
        break label133;
      }
      if (this.aYt.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.aYt.aUk;
    if (((this.aYt.type & 0x1) == 1) && (this.aYL.limit == 0)) {
      i += ez(0);
    }
    for (int j = this.aYN + 0;; j = 0)
    {
      paramf.ed(i);
      this.aYM = j;
      label133:
      j = ez(this.aYM);
      i = this.aYM + this.aYN;
      if (j > 0)
      {
        if (this.aYL.vh() < this.aYL.limit + j) {
          this.aYL.data = Arrays.copyOf(this.aYL.data, this.aYL.limit + j);
        }
        paramf.readFully(this.aYL.data, this.aYL.limit, j);
        this.aYL.ft(j + this.aYL.limit);
        if (this.aYt.aYX[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.aYO = bool;
        }
      }
      else
      {
        if (i != this.aYt.aYV) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.aYM = i;
        break;
        bool = false;
        break label258;
      }
      label294:
      AppMethodBeat.o(92156);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.d
 * JD-Core Version:    0.7.0.1
 */