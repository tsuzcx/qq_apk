package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final e beB;
  final m beT;
  int beU;
  private int beV;
  boolean beW;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.beB = new e();
    this.beT = new m(new byte[65025], 0);
    this.beU = -1;
    AppMethodBeat.o(92155);
  }
  
  private int en(int paramInt)
  {
    int i = 0;
    this.beV = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.beV + paramInt >= this.beB.bfd) {
        break;
      }
      int[] arrayOfInt = this.beB.bff;
      j = this.beV;
      this.beV = (j + 1);
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
      if (this.beW)
      {
        this.beW = false;
        this.beT.reset();
      }
      if (this.beW) {
        break label294;
      }
      if (this.beU >= 0) {
        break label133;
      }
      if (this.beB.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.beB.bas;
    if (((this.beB.type & 0x1) == 1) && (this.beT.limit == 0)) {
      i += en(0);
    }
    for (int j = this.beV + 0;; j = 0)
    {
      paramf.dQ(i);
      this.beU = j;
      label133:
      j = en(this.beU);
      i = this.beU + this.beV;
      if (j > 0)
      {
        if (this.beT.capacity() < this.beT.limit + j) {
          this.beT.data = Arrays.copyOf(this.beT.data, this.beT.limit + j);
        }
        paramf.readFully(this.beT.data, this.beT.limit, j);
        this.beT.eW(j + this.beT.limit);
        if (this.beB.bff[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.beW = bool;
        }
      }
      else
      {
        if (i != this.beB.bfd) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.beU = i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.d
 * JD-Core Version:    0.7.0.1
 */