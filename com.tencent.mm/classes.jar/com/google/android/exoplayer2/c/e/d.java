package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final e boR;
  final m bpj;
  int bpk;
  private int bpl;
  boolean bpm;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.boR = new e();
    this.bpj = new m(new byte[65025], 0);
    this.bpk = -1;
    AppMethodBeat.o(92155);
  }
  
  private int el(int paramInt)
  {
    int i = 0;
    this.bpl = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.bpl + paramInt >= this.boR.bpt) {
        break;
      }
      int[] arrayOfInt = this.boR.bpv;
      j = this.bpl;
      this.bpl = (j + 1);
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
      if (this.bpm)
      {
        this.bpm = false;
        this.bpj.reset();
      }
      if (this.bpm) {
        break label294;
      }
      if (this.bpk >= 0) {
        break label133;
      }
      if (this.boR.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.boR.bkI;
    if (((this.boR.type & 0x1) == 1) && (this.bpj.limit == 0)) {
      i += el(0);
    }
    for (int j = this.bpl + 0;; j = 0)
    {
      paramf.dP(i);
      this.bpk = j;
      label133:
      j = el(this.bpk);
      i = this.bpk + this.bpl;
      if (j > 0)
      {
        if (this.bpj.capacity() < this.bpj.limit + j) {
          this.bpj.data = Arrays.copyOf(this.bpj.data, this.bpj.limit + j);
        }
        paramf.readFully(this.bpj.data, this.bpj.limit, j);
        this.bpj.eY(j + this.bpj.limit);
        if (this.boR.bpv[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.bpm = bool;
        }
      }
      else
      {
        if (i != this.boR.bpt) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.bpk = i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.d
 * JD-Core Version:    0.7.0.1
 */