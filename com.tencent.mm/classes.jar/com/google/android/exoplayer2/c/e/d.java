package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final m cSG;
  int cSH;
  private int cSI;
  boolean cSJ;
  final e cSp;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.cSp = new e();
    this.cSG = new m(new byte[65025], 0);
    this.cSH = -1;
    AppMethodBeat.o(92155);
  }
  
  private int hP(int paramInt)
  {
    int i = 0;
    this.cSI = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.cSI + paramInt >= this.cSp.cSQ) {
        break;
      }
      int[] arrayOfInt = this.cSp.cSS;
      j = this.cSI;
      this.cSI = (j + 1);
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
      if (this.cSJ)
      {
        this.cSJ = false;
        this.cSG.reset();
      }
      if (this.cSJ) {
        break label294;
      }
      if (this.cSH >= 0) {
        break label133;
      }
      if (this.cSp.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.cSp.cOg;
    if (((this.cSp.type & 0x1) == 1) && (this.cSG.limit == 0)) {
      i += hP(0);
    }
    for (int j = this.cSI + 0;; j = 0)
    {
      paramf.eP(i);
      this.cSH = j;
      label133:
      j = hP(this.cSH);
      i = this.cSH + this.cSI;
      if (j > 0)
      {
        if (this.cSG.UG() < this.cSG.limit + j) {
          this.cSG.data = Arrays.copyOf(this.cSG.data, this.cSG.limit + j);
        }
        paramf.readFully(this.cSG.data, this.cSG.limit, j);
        this.cSG.iG(j + this.cSG.limit);
        if (this.cSp.cSS[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.cSJ = bool;
        }
      }
      else
      {
        if (i != this.cSp.cSQ) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.cSH = i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.d
 * JD-Core Version:    0.7.0.1
 */