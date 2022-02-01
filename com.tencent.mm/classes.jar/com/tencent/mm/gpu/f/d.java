package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private int[] jVi;
  private int[] jVj;
  private boolean jVk;
  private int size;
  int unit;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(211023);
    this.jVk = true;
    this.size = 5;
    this.jVi = new int[5];
    this.jVj = new int[5];
    this.unit = 61166;
    this.jVk = false;
    AppMethodBeat.o(211023);
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jVk) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.size)) {
      return;
    }
    this.jVi[paramInt1] = paramInt2;
    this.jVj[paramInt1] = paramInt3;
  }
  
  public final int sa(int paramInt)
  {
    if (this.jVk) {}
    for (;;)
    {
      return -1;
      int i = 0;
      int j = this.size - 1;
      while (i <= j)
      {
        int k = (i & j) + ((i ^ j) >> 1);
        int m = this.jVi[k];
        int n = this.jVj[k];
        if ((paramInt >= m) && (paramInt <= n)) {
          return k;
        }
        if (paramInt < m) {
          j = k - 1;
        } else {
          i = k + 1;
        }
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211025);
    if (this.jVk)
    {
      localObject = super.toString();
      AppMethodBeat.o(211025);
      return localObject;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.size)
    {
      int j = this.jVi[i];
      int k = this.jVj[i];
      ((StringBuilder)localObject).append("[").append(j).append(", ").append(k).append(")\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(211025);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.gpu.f.d
 * JD-Core Version:    0.7.0.1
 */