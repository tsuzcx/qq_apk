package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final e boW;
  final m bpo;
  int bpp;
  private int bpq;
  boolean bpr;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.boW = new e();
    this.bpo = new m(new byte[65025], 0);
    this.bpp = -1;
    AppMethodBeat.o(92155);
  }
  
  private int er(int paramInt)
  {
    int i = 0;
    this.bpq = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.bpq + paramInt >= this.boW.bpy) {
        break;
      }
      int[] arrayOfInt = this.boW.bpA;
      j = this.bpq;
      this.bpq = (j + 1);
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
      if (this.bpr)
      {
        this.bpr = false;
        this.bpo.reset();
      }
      if (this.bpr) {
        break label294;
      }
      if (this.bpp >= 0) {
        break label133;
      }
      if (this.boW.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.boW.bkN;
    if (((this.boW.type & 0x1) == 1) && (this.bpo.limit == 0)) {
      i += er(0);
    }
    for (int j = this.bpq + 0;; j = 0)
    {
      paramf.dU(i);
      this.bpp = j;
      label133:
      j = er(this.bpp);
      i = this.bpp + this.bpq;
      if (j > 0)
      {
        if (this.bpo.capacity() < this.bpo.limit + j) {
          this.bpo.data = Arrays.copyOf(this.bpo.data, this.bpo.limit + j);
        }
        paramf.readFully(this.bpo.data, this.bpo.limit, j);
        this.bpo.eZ(j + this.bpo.limit);
        if (this.boW.bpA[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.bpr = bool;
        }
      }
      else
      {
        if (i != this.boW.bpy) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.bpp = i;
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