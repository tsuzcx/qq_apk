package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final m aIP;
  int aIQ;
  boolean aIR;
  final e aIx;
  private int segmentCount;
  
  d()
  {
    AppMethodBeat.i(95039);
    this.aIx = new e();
    this.aIP = new m(new byte[65025], 0);
    this.aIQ = -1;
    AppMethodBeat.o(95039);
  }
  
  private int dC(int paramInt)
  {
    int i = 0;
    this.segmentCount = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.segmentCount + paramInt >= this.aIx.aIY) {
        break;
      }
      int[] arrayOfInt = this.aIx.aJa;
      j = this.segmentCount;
      this.segmentCount = (j + 1);
      k = arrayOfInt[(j + paramInt)];
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
  
  public final boolean k(f paramf)
  {
    AppMethodBeat.i(95040);
    if (paramf != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (this.aIR)
      {
        this.aIR = false;
        this.aIP.reset();
      }
      if (this.aIR) {
        break label294;
      }
      if (this.aIQ >= 0) {
        break label133;
      }
      if (this.aIx.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(95040);
      return false;
    }
    int i = this.aIx.aEo;
    if (((this.aIx.type & 0x1) == 1) && (this.aIP.limit == 0)) {
      i += dC(0);
    }
    for (int j = this.segmentCount + 0;; j = 0)
    {
      paramf.dg(i);
      this.aIQ = j;
      label133:
      j = dC(this.aIQ);
      i = this.aIQ + this.segmentCount;
      if (j > 0)
      {
        if (this.aIP.capacity() < this.aIP.limit + j) {
          this.aIP.data = Arrays.copyOf(this.aIP.data, this.aIP.limit + j);
        }
        paramf.readFully(this.aIP.data, this.aIP.limit, j);
        this.aIP.em(j + this.aIP.limit);
        if (this.aIx.aJa[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.aIR = bool;
        }
      }
      else
      {
        if (i != this.aIx.aIY) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.aIQ = i;
        break;
        bool = false;
        break label258;
      }
      label294:
      AppMethodBeat.o(95040);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.d
 * JD-Core Version:    0.7.0.1
 */