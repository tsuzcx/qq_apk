package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  final e bdP;
  final m beh;
  int bei;
  private int bej;
  boolean bek;
  
  d()
  {
    AppMethodBeat.i(92155);
    this.bdP = new e();
    this.beh = new m(new byte[65025], 0);
    this.bei = -1;
    AppMethodBeat.o(92155);
  }
  
  private int en(int paramInt)
  {
    int i = 0;
    this.bej = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.bej + paramInt >= this.bdP.ber) {
        break;
      }
      int[] arrayOfInt = this.bdP.bet;
      j = this.bej;
      this.bej = (j + 1);
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
      if (this.bek)
      {
        this.bek = false;
        this.beh.reset();
      }
      if (this.bek) {
        break label294;
      }
      if (this.bei >= 0) {
        break label133;
      }
      if (this.bdP.c(paramf, true)) {
        break;
      }
      AppMethodBeat.o(92156);
      return false;
    }
    int i = this.bdP.aZG;
    if (((this.bdP.type & 0x1) == 1) && (this.beh.limit == 0)) {
      i += en(0);
    }
    for (int j = this.bej + 0;; j = 0)
    {
      paramf.dR(i);
      this.bei = j;
      label133:
      j = en(this.bei);
      i = this.bei + this.bej;
      if (j > 0)
      {
        if (this.beh.capacity() < this.beh.limit + j) {
          this.beh.data = Arrays.copyOf(this.beh.data, this.beh.limit + j);
        }
        paramf.readFully(this.beh.data, this.beh.limit, j);
        this.beh.fk(j + this.beh.limit);
        if (this.bdP.bet[(i - 1)] != 255)
        {
          bool = true;
          label258:
          this.bek = bool;
        }
      }
      else
      {
        if (i != this.bdP.ber) {
          break label291;
        }
        i = -1;
      }
      label291:
      for (;;)
      {
        this.bei = i;
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