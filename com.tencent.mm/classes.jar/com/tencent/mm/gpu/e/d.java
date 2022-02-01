package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private int[] gwA;
  private int[] gwB;
  private boolean gwC;
  private int size;
  int unit;
  
  public d()
  {
    AppMethodBeat.i(209670);
    this.gwC = true;
    this.size = 5;
    this.gwA = new int[5];
    this.gwB = new int[5];
    this.unit = 61166;
    this.gwC = false;
    AppMethodBeat.o(209670);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.gwC) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.size)) {
      return;
    }
    this.gwA[paramInt1] = paramInt2;
    this.gwB[paramInt1] = paramInt3;
  }
  
  public final int mo(int paramInt)
  {
    if (this.gwC) {}
    for (;;)
    {
      return -1;
      int i = 0;
      int j = this.size - 1;
      while (i <= j)
      {
        int k = (i & j) + ((i ^ j) >> 1);
        int m = this.gwA[k];
        int n = this.gwB[k];
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
    AppMethodBeat.i(209671);
    if (this.gwC)
    {
      localObject = super.toString();
      AppMethodBeat.o(209671);
      return localObject;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.size)
    {
      int j = this.gwA[i];
      int k = this.gwB[i];
      ((StringBuilder)localObject).append("[").append(j).append(", ").append(k).append(")\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(209671);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.d
 * JD-Core Version:    0.7.0.1
 */