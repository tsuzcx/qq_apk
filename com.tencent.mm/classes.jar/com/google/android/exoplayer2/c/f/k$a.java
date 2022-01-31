package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$a
{
  private final m aCe;
  boolean aKA;
  long aKS;
  long aKT;
  boolean aKW;
  long aKr;
  long aKz;
  boolean aLq;
  int aLr;
  boolean aLs;
  boolean aLt;
  boolean aLu;
  boolean aLv;
  
  public k$a(m paramm)
  {
    this.aCe = paramm;
  }
  
  final void dH(int paramInt)
  {
    AppMethodBeat.i(95127);
    if (this.aKA) {}
    for (int i = 1;; i = 0)
    {
      int j = (int)(this.aKS - this.aKz);
      this.aCe.a(this.aKr, i, j, paramInt, null);
      AppMethodBeat.o(95127);
      return;
    }
  }
  
  public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.aLs)
    {
      int i = paramInt1 + 2 - this.aLr;
      if (i >= paramInt2) {
        break label55;
      }
      if ((paramArrayOfByte[i] & 0x80) == 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.aLt = bool;
      this.aLs = false;
      return;
    }
    label55:
    this.aLr += paramInt2 - paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k.a
 * JD-Core Version:    0.7.0.1
 */