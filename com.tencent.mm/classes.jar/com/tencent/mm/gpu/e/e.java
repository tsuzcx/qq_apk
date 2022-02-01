package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private int[] gau;
  private int[] gav;
  private boolean gaw;
  private int size;
  
  public e()
  {
    AppMethodBeat.i(209435);
    this.gaw = true;
    this.size = 10;
    this.gau = new int[10];
    this.gav = new int[10];
    this.gaw = false;
    AppMethodBeat.o(209435);
  }
  
  public final void I(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.gaw) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.size)) {
      return;
    }
    this.gau[paramInt1] = paramInt2;
    this.gav[paramInt1] = paramInt3;
  }
  
  public final int lM(int paramInt)
  {
    if (this.gaw) {}
    for (;;)
    {
      return -1;
      int i = 0;
      int j = this.size - 1;
      while (i <= j)
      {
        int k = (i & j) + ((i ^ j) >> 1);
        int m = this.gau[k];
        int n = this.gav[k];
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
    AppMethodBeat.i(209436);
    if (this.gaw)
    {
      localObject = super.toString();
      AppMethodBeat.o(209436);
      return localObject;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.size)
    {
      int j = this.gau[i];
      int k = this.gav[i];
      ((StringBuilder)localObject).append("[").append(j).append(", ").append(k).append(")\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(209436);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.gpu.e.e
 * JD-Core Version:    0.7.0.1
 */