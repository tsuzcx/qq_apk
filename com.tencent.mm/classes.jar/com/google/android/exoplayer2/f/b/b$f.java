package com.google.android.exoplayer2.f.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$f
{
  public final boolean aVF;
  public final int aVG;
  public final int aVH;
  public final int aVI;
  public final int aVJ;
  public final int aVK;
  public final int aVL;
  public final SparseArray<b.g> aVM;
  public final int height;
  public final int id;
  public final int width;
  
  public b$f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
  {
    this.id = paramInt1;
    this.aVF = paramBoolean;
    this.width = paramInt2;
    this.height = paramInt3;
    this.aVG = paramInt4;
    this.aVH = paramInt5;
    this.aVI = paramInt6;
    this.aVJ = paramInt7;
    this.aVK = paramInt8;
    this.aVL = paramInt9;
    this.aVM = paramSparseArray;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(95624);
    if (paramf == null)
    {
      AppMethodBeat.o(95624);
      return;
    }
    paramf = paramf.aVM;
    int i = 0;
    while (i < paramf.size())
    {
      this.aVM.put(paramf.keyAt(i), paramf.valueAt(i));
      i += 1;
    }
    AppMethodBeat.o(95624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.f.b.b.f
 * JD-Core Version:    0.7.0.1
 */