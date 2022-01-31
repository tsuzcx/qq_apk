package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.h.a;
import com.google.android.exoplayer2.i.h.b;

final class j$a
{
  final com.google.android.exoplayer2.c.k aCt;
  long aDG;
  long aDO;
  boolean aDP;
  boolean aDS;
  final boolean aDV;
  final boolean aDW;
  final SparseArray<h.b> aEc;
  final SparseArray<h.a> aEd;
  final com.google.android.exoplayer2.i.k aEe;
  int aEf;
  int aEg;
  long aEh;
  long aEi;
  j.a.a aEj;
  j.a.a aEk;
  boolean aEl;
  byte[] buffer;
  
  public j$a(com.google.android.exoplayer2.c.k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aCt = paramk;
    this.aDV = paramBoolean1;
    this.aDW = paramBoolean2;
    this.aEc = new SparseArray();
    this.aEd = new SparseArray();
    this.aEj = new j.a.a((byte)0);
    this.aEk = new j.a.a((byte)0);
    this.buffer = new byte[''];
    this.aEe = new com.google.android.exoplayer2.i.k(this.buffer, 0, 0);
    reset();
  }
  
  public final void a(h.a parama)
  {
    this.aEd.append(parama.aEr, parama);
  }
  
  public final void a(h.b paramb)
  {
    this.aEc.append(paramb.aSr, paramb);
  }
  
  public final void reset()
  {
    this.aDS = false;
    this.aEl = false;
    this.aEk.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.j.a
 * JD-Core Version:    0.7.0.1
 */