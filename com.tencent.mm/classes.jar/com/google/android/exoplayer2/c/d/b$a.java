package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  public int aGp;
  private final boolean aGq;
  private final m aGr;
  private final m aGs;
  private int aGt;
  private int aGu;
  public int index;
  public final int length;
  public long offset;
  
  public b$a(m paramm1, m paramm2, boolean paramBoolean)
  {
    AppMethodBeat.i(94941);
    this.aGs = paramm1;
    this.aGr = paramm2;
    this.aGq = paramBoolean;
    paramm2.setPosition(12);
    this.length = paramm2.qT();
    paramm1.setPosition(12);
    this.aGu = paramm1.qT();
    if (paramm1.readInt() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a.checkState(paramBoolean, "first_chunk must be 1");
      this.index = -1;
      AppMethodBeat.o(94941);
      return;
    }
  }
  
  public final boolean od()
  {
    AppMethodBeat.i(94942);
    int i = this.index + 1;
    this.index = i;
    if (i == this.length)
    {
      AppMethodBeat.o(94942);
      return false;
    }
    long l;
    if (this.aGq)
    {
      l = this.aGr.qV();
      this.offset = l;
      if (this.index == this.aGt)
      {
        this.aGp = this.aGs.qT();
        this.aGs.en(4);
        i = this.aGu - 1;
        this.aGu = i;
        if (i <= 0) {
          break label131;
        }
      }
    }
    label131:
    for (i = this.aGs.qT() - 1;; i = -1)
    {
      this.aGt = i;
      AppMethodBeat.o(94942);
      return true;
      l = this.aGr.cc();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.b.a
 * JD-Core Version:    0.7.0.1
 */