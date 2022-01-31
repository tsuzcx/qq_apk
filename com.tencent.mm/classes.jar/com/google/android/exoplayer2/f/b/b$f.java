package com.google.android.exoplayer2.f.b;

import android.util.SparseArray;

final class b$f
{
  public final boolean aOl;
  public final int aOm;
  public final int aOn;
  public final int aOo;
  public final int aOp;
  public final int aOq;
  public final int aOr;
  public final SparseArray<b.g> aOs;
  public final int height;
  public final int id;
  public final int width;
  
  public b$f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
  {
    this.id = paramInt1;
    this.aOl = paramBoolean;
    this.width = paramInt2;
    this.height = paramInt3;
    this.aOm = paramInt4;
    this.aOn = paramInt5;
    this.aOo = paramInt6;
    this.aOp = paramInt7;
    this.aOq = paramInt8;
    this.aOr = paramInt9;
    this.aOs = paramSparseArray;
  }
  
  public final void a(f paramf)
  {
    if (paramf == null) {}
    for (;;)
    {
      return;
      paramf = paramf.aOs;
      int i = 0;
      while (i < paramf.size())
      {
        this.aOs.put(paramf.keyAt(i), paramf.valueAt(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.b.f
 * JD-Core Version:    0.7.0.1
 */