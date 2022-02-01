package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private int[] gtT;
  private int[] gtU;
  private boolean gtV;
  private int size;
  int unit;
  
  public d()
  {
    AppMethodBeat.i(219548);
    this.gtV = true;
    this.size = 5;
    this.gtT = new int[5];
    this.gtU = new int[5];
    this.unit = 61166;
    this.gtV = false;
    AppMethodBeat.o(219548);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.gtV) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.size)) {
      return;
    }
    this.gtT[paramInt1] = paramInt2;
    this.gtU[paramInt1] = paramInt3;
  }
  
  public final int ml(int paramInt)
  {
    if (this.gtV) {}
    for (;;)
    {
      return -1;
      int i = 0;
      int j = this.size - 1;
      while (i <= j)
      {
        int k = (i & j) + ((i ^ j) >> 1);
        int m = this.gtT[k];
        int n = this.gtU[k];
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
    AppMethodBeat.i(219549);
    if (this.gtV)
    {
      localObject = super.toString();
      AppMethodBeat.o(219549);
      return localObject;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.size)
    {
      int j = this.gtT[i];
      int k = this.gtU[i];
      ((StringBuilder)localObject).append("[").append(j).append(", ").append(k).append(")\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(219549);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.d
 * JD-Core Version:    0.7.0.1
 */